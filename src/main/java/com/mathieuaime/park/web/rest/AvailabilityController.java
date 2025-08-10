package com.mathieuaime.park.web.rest;

import com.mathieuaime.park.model.configuration.Mobility;
import com.mathieuaime.park.service.AvailabilityServices;
import com.mathieuaime.park.web.dto.GetAvailabilitiesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availabilities")
public class AvailabilityController {

  private final AvailabilityServices availabilityServices;

  public AvailabilityController(AvailabilityServices availabilityServices) {
    this.availabilityServices = availabilityServices;
  }

  @GetMapping("/{mobility}")
  public GetAvailabilitiesResponse getAvailabilities(
      @PathVariable Mobility mobility
  ) {
    var availabilities = availabilityServices.getAvailabilities(mobility);
    return new GetAvailabilitiesResponse(mobility, availabilities);
  }
}
