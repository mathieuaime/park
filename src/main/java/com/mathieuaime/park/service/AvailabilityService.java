package com.mathieuaime.park.service;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import java.util.Set;

public interface AvailabilityService {

  Mobility getResourceType();

  Set<Availability> getAvailabilities();
}
