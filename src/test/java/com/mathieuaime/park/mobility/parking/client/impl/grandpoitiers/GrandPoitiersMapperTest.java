package com.mathieuaime.park.mobility.parking.client.impl.grandpoitiers;

import static org.assertj.core.api.Assertions.assertThat;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.Coordinates;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GrandPoitiersMapperTest {

  @Test
  void mapParkingAvailability() {
    GrandPoitiersParkingAvailability parkingAvailability = new GrandPoitiersParkingAvailability(
        "id",
        new Coordinates(2.34, 48.12),
        10,
        20,
        "Parking 1"
    );
    GrandPoitiersParkingAvailabilities parkingAvailabilities
        = new GrandPoitiersParkingAvailabilities(1, List.of(parkingAvailability));

    Set<Availability> availabilities = GrandPoitiersMapper.mapParkingAvailability(parkingAvailabilities);

    Availability availability = new Availability(
        "Parking 1",
        new Coordinates(2.34, 48.12),
        20,
        10
    );

    assertThat(availabilities).hasSize(1);
    assertThat(availabilities).contains(availability);
  }
}