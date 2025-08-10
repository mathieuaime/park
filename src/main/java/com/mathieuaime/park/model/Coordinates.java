package com.mathieuaime.park.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public record Coordinates(
    @DecimalMin(value = "-90", inclusive = false) @DecimalMax(value = "90") double latitude,
    @DecimalMin(value = "-180", inclusive = false) @DecimalMax(value = "180") double longitude
) {

}
