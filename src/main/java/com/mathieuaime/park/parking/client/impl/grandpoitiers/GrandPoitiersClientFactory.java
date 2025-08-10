package com.mathieuaime.park.parking.client.impl.grandpoitiers;

import com.mathieuaime.park.parking.client.ParkingClient;
import com.mathieuaime.park.parking.client.ParkingClientFactory;
import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.parking.configuration.ParkingClientType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
class GrandPoitiersClientFactory implements ParkingClientFactory, ApplicationContextAware {

  private final RestClient.Builder clientBuilder;

  private ApplicationContext applicationContext;

  private final Map<String, ParkingClient> parkingClients = new ConcurrentHashMap<>();

  public GrandPoitiersClientFactory(RestClient.Builder clientBuilder) {
    this.clientBuilder = clientBuilder;
  }

  @Override
  public ParkingClientType getType() {
    return ParkingClientType.GRAND_POITIERS;
  }

  @Override
  public ParkingClient getClient(ParkingClientConfiguration configuration) {
    return parkingClients.computeIfAbsent(
        configuration.name(), n -> createClient(configuration));
  }

  private GrandPoitiersClient createClient(ParkingClientConfiguration parkingClientConfiguration) {
    return this.applicationContext.getBean(GrandPoitiersClient.class, clientBuilder, parkingClientConfiguration);
  }

  @Override
  public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
