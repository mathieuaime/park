package com.mathieuaime.park.parking.client;

import com.mathieuaime.park.model.Coordinates;
import com.mathieuaime.park.model.Availability;
import java.util.Set;

public interface ParkingClient {

  Set<Availability> getAvailabilities();
}
