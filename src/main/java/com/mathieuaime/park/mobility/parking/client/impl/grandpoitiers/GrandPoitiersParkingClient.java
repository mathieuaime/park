package com.mathieuaime.park.mobility.parking.client.impl.grandpoitiers;

import com.mathieuaime.park.mobility.parking.client.ParkingClient;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.model.Availability;
import java.util.Set;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Configurable
@Scope(value = "prototype")
class GrandPoitiersParkingClient implements ParkingClient {

  private final RestClient client;
  private final ParkingClientConfiguration configuration;

  public GrandPoitiersParkingClient(RestClient.Builder clientBuilder, ParkingClientConfiguration configuration) {
    this.client = clientBuilder.build();
    this.configuration = configuration;
  }

  @Override
  public Set<Availability> getAvailabilities() {
    GrandPoitiersParkingAvailabilities grandPoitiersParkingAvailabilities = fetchParkingAvailabilities();
    return GrandPoitiersMapper.mapParkingAvailability(grandPoitiersParkingAvailabilities);
  }

  private GrandPoitiersParkingAvailabilities fetchParkingAvailabilities() {
    return this.client.get().uri(configuration.url())
        .retrieve()
        .body(GrandPoitiersParkingAvailabilities.class);
  }
}
