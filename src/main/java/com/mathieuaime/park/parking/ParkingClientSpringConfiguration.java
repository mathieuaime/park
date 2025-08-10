package com.mathieuaime.park.parking;

import com.mathieuaime.park.parking.client.ParkingClient;
import com.mathieuaime.park.parking.client.ParkingClientsFactory;
import com.mathieuaime.park.parking.service.ParkingAvailabilityService;
import com.mathieuaime.park.parking.service.ParkingConfigurationService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ParkingClientSpringConfiguration {

  private static final Logger log = LoggerFactory.getLogger(ParkingClientSpringConfiguration.class);
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
        .collect(Collectors.toList());
  }

  @Bean
  public ParkingAvailabilityService parkingAvailabilityService() {
    return new ParkingAvailabilityService(parkingClients());
  }
}
