package com.mathieuaime.park.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.mathieuaime.park.TestData;
import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AvailabilityServicesTest {

  @Mock
  private AvailabilityService availabilityService;

  private AvailabilityServices availabilityServices;

  @BeforeEach
  void setUp() {
    when(availabilityService.getResourceType()).thenReturn(Mobility.PARKING);
    availabilityServices = new AvailabilityServices(List.of(availabilityService));
  }

  @Test
  void getAvailabilities_withUnimplementedMobility_shouldReturnEmptyAvailabilities() {
    Set<Availability> availabilities = availabilityServices.getAvailabilities(null);

    assertThat(availabilities).isEmpty();
  }

  @Test
  void getAvailabilities_withCorrectMobility_shouldReturnAvailabilities() {
    Set<Availability> expected = Set.of(TestData.getTestAvailability());

    when(availabilityService.getAvailabilities()).thenReturn(expected);

    Set<Availability> availabilities = availabilityServices.getAvailabilities(Mobility.PARKING);

    assertThat(availabilities).isEqualTo(expected);
  }


}