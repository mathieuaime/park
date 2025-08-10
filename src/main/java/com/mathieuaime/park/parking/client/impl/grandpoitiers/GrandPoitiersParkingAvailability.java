package com.mathieuaime.park.parking.client.impl.grandpoitiers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mathieuaime.park.model.Coordinates;

record GrandPoitiersParkingAvailability(
    @JsonProperty("_id") String id,
    @JsonDeserialize(using = CoordinatesDeserializer.class) @JsonProperty("_geopoint") Coordinates position,
    @JsonProperty("Places") long places,
    @JsonProperty("Capacite") long capacity,
    @JsonProperty("Nom") String name
) {

}
