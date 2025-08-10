package com.mathieuaime.park.mobility.parking.client.impl.grandpoitiers;

import com.mathieuaime.park.model.Availability;
import java.util.Set;
import java.util.stream.Collectors;

final class GrandPoitiersMapper {

  static Set<Availability> mapParkingAvailability(GrandPoitiersParkingAvailabilities availabilities) {
    return availabilities.results().stream()
        .map(GrandPoitiersMapper::mapParkingAvailability)
        .collect(Collectors.toSet());
  }

  private static Availability mapParkingAvailability(GrandPoitiersParkingAvailability availability) {
    return new Availability(
        availability.name(),
        availability.position(),
        availability.capacity(),
        availability.places()
    );
  }
}
