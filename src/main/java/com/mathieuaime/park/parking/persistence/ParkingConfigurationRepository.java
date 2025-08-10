package com.mathieuaime.park.parking.persistence;

import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import java.util.List;

public interface ParkingConfigurationRepository {

  List<ParkingClientConfiguration> getConfigurations();
}
