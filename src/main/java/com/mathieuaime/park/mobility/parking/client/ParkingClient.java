package com.mathieuaime.park.mobility.parking.client;

import com.mathieuaime.park.model.Availability;
import java.util.Set;

public interface ParkingClient {

  Set<Availability> getAvailabilities();
}
