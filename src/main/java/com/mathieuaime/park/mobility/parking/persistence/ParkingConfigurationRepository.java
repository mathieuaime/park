package com.mathieuaime.park.mobility.parking.persistence;

import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import java.util.List;

public interface ParkingConfigurationRepository {

  List<ParkingClientConfiguration> getConfigurations();
}
