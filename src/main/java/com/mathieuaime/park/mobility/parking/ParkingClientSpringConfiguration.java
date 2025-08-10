package com.mathieuaime.park.mobility.parking;

import com.mathieuaime.park.mobility.parking.client.ParkingClient;
import com.mathieuaime.park.mobility.parking.client.ParkingClientsFactory;
import com.mathieuaime.park.mobility.parking.service.ParkingAvailabilityService;
import com.mathieuaime.park.mobility.parking.service.ParkingConfigurationService;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ParkingClientSpringConfiguration {

  private final ParkingConfigurationService configurationService;
  private final ParkingClientsFactory factory;

  public ParkingClientSpringConfiguration(
      ParkingConfigurationService configurationService,
      ParkingClientsFactory factory
  ) {
    this.configurationService = configurationService;
    this.factory = factory;
  }

  @Bean
  public List<ParkingClient> parkingClients() {
    return configurationService.getConfigurations().stream()
        .map(factory::getClient)
        .toList();
  }

  @Bean
  public ParkingAvailabilityService parkingAvailabilityService() {
    return new ParkingAvailabilityService(parkingClients());
  }
}
