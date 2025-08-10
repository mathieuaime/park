package com.mathieuaime.park.service;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServices {

  private final Map<Mobility, AvailabilityService> availabilityServices;

  public AvailabilityServices(List<AvailabilityService> availabilityServices) {
    this.availabilityServices = availabilityServices.stream()
        .collect(Collectors.toMap(AvailabilityService::getResourceType, a -> a));
  }

  public Set<Availability> getAvailabilities(Mobility mobility) {
    AvailabilityService service = availabilityServices.get(mobility);

    return Optional.ofNullable(service)
        .map(AvailabilityService::getAvailabilities)
        .orElse(Collections.emptySet());
  }
}
