package com.mathieuaime.park.web.dto;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import java.util.Set;

public record GetAvailabilitiesResponse(
    Mobility mobility,
    Set<Availability> availabilities
) {

}
