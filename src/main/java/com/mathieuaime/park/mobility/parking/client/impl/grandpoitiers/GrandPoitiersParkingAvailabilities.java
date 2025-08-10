package com.mathieuaime.park.mobility.parking.client.impl.grandpoitiers;

import java.util.List;

record GrandPoitiersParkingAvailabilities(
    long total,
    List<GrandPoitiersParkingAvailability> results
) {

}
