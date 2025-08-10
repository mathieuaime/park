package com.mathieuaime.park.mobility.parking.client;

import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientType;

public interface ParkingClientFactory {

  ParkingClientType getType();

  ParkingClient getClient(ParkingClientConfiguration configuration);
}
