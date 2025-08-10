package com.mathieuaime.park.model;

public record Availability(
    String name,
    Coordinates position,
    long capacity,
    long available
) {

}
