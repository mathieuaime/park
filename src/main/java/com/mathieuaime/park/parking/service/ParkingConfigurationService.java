package com.mathieuaime.park.parking.service;

import com.mathieuaime.park.model.configuration.ClientConfiguration;
import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.parking.persistence.ParkingConfigurationRepository;
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
