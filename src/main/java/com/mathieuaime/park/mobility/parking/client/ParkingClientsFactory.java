package com.mathieuaime.park.mobility.parking.client;

import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ParkingClientsFactory {

  private final Map<ParkingClientType, ParkingClientFactory> factories;

  public ParkingClientsFactory(List<ParkingClientFactory> factories) {
    this.factories = factories.stream().collect(Collectors.toMap(ParkingClientFactory::getType, f -> f));
  }

  public ParkingClient getClient(ParkingClientConfiguration configuration) {
    ParkingClientFactory factory = factories.get(configuration.clientType());

    if (factory == null) {
      throw new IllegalArgumentException("Unknown parking clientType: " + configuration.clientType());
    }

    return factory.getClient(configuration);
  }
}
