package com.mathieuaime.park.parking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.mathieuaime.park.TestData;
import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.parking.client.ParkingClient;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ParkingAvailabilityServiceTest {

  @Mock
  private ParkingClient client1;

  @Mock
  private ParkingClient client2;

  private ParkingAvailabilityService service;

  @BeforeEach
  void setUp() {
    this.service = new ParkingAvailabilityService(List.of(client1, client2));
  }

  @Test
  void name() {
    Availability availability = TestData.getTestAvailability();

    when(client1.getAvailabilities()).thenReturn(Set.of(availability));
    when(client2.getAvailabilities()).thenReturn(Set.of(availability));

    Set<Availability> availabilities = service.getAvailabilities();

    assertThat(availabilities).containsExactly(availability);
  }
}