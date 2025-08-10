package com.mathieuaime.park.mobility.parking.configuration;

import com.mathieuaime.park.model.configuration.ClientConfiguration;
import com.mathieuaime.park.model.configuration.Mobility;

public record ParkingClientConfiguration(
    String name,
    Mobility mobility,
    ParkingClientType clientType,
    String url
) implements ClientConfiguration {

}
