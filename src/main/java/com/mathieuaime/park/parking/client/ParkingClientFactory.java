package com.mathieuaime.park.parking.client;

import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.parking.configuration.ParkingClientType;

public interface ParkingClientFactory {

  ParkingClientType getType();

  ParkingClient getClient(ParkingClientConfiguration configuration);
}
