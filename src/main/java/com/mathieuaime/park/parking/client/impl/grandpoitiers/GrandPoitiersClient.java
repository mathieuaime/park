package com.mathieuaime.park.parking.client.impl.grandpoitiers;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.parking.client.ParkingClient;
import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import java.util.Set;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Configurable
@Scope(value = "prototype")
class GrandPoitiersClient implements ParkingClient {

  private final RestClient client;
  private final ParkingClientConfiguration configuration;

  public GrandPoitiersClient(RestClient.Builder clientBuilder, ParkingClientConfiguration configuration) {
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
