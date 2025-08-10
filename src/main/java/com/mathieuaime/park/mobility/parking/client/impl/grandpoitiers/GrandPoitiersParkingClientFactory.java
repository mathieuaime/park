package com.mathieuaime.park.mobility.parking.client.impl.grandpoitiers;

import com.mathieuaime.park.mobility.parking.client.ParkingClient;
import com.mathieuaime.park.mobility.parking.client.ParkingClientFactory;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
class GrandPoitiersParkingClientFactory implements ParkingClientFactory, ApplicationContextAware {

  private final RestClient.Builder clientBuilder;
  private final Map<String, ParkingClient> parkingClients = new ConcurrentHashMap<>();
  private ApplicationContext applicationContext;

  public GrandPoitiersParkingClientFactory(RestClient.Builder clientBuilder) {
    this.clientBuilder = clientBuilder;
  }

  @Override
  public ParkingClientType getType() {
    return ParkingClientType.GRAND_POITIERS;
  }

  @Override
  public ParkingClient getClient(ParkingClientConfiguration configuration) {
    return parkingClients.computeIfAbsent(configuration.name(), name -> createClient(configuration));
  }

  private GrandPoitiersParkingClient createClient(ParkingClientConfiguration configuration) {
    return this.applicationContext.getBean(GrandPoitiersParkingClient.class, clientBuilder, configuration);
  }

  @Override
  public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
