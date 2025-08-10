package com.mathieuaime.park.mobility.parking.service;

import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.mobility.parking.persistence.ParkingConfigurationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ParkingConfigurationService {

  private final ParkingConfigurationRepository parkingConfigurationRepository;

  public ParkingConfigurationService(ParkingConfigurationRepository parkingConfigurationRepository) {
    this.parkingConfigurationRepository = parkingConfigurationRepository;
  }

  public List<ParkingClientConfiguration> getConfigurations() {
    return parkingConfigurationRepository.getConfigurations();
  }
}
