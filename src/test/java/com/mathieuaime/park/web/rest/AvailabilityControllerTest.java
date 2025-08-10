package com.mathieuaime.park.web.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mathieuaime.park.TestData;
import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import com.mathieuaime.park.service.AvailabilityServices;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AvailabilityController.class)
class AvailabilityControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private AvailabilityServices availabilityServices;

  @Test
  void getAvailabilities_withUnimplementedMobility_shouldThrowBadRequest() throws Exception {
    mockMvc.perform(get("/availabilities/{mobility}", "UNIMPLEMENTED"))
        .andExpect(status().isBadRequest());
  }

  @Test
  void getAvailabilities_shouldReturnOkAndAResponse() throws Exception {
    Availability availability = TestData.getTestAvailability();

    Mobility mobility = Mobility.PARKING;

    when(availabilityServices.getAvailabilities(mobility)).thenReturn(Set.of(availability));

    mockMvc.perform(get("/availabilities/{mobility}", mobility))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.mobility").value(mobility.name()))
        .andExpect(jsonPath("$.availabilities.length()").value(1))
        .andExpect(jsonPath("$.availabilities[0].name").value(availability.name()))
        .andExpect(jsonPath("$.availabilities[0].position.latitude").value(availability.position().latitude()))
        .andExpect(jsonPath("$.availabilities[0].position.longitude").value(availability.position().longitude()))
        .andExpect(jsonPath("$.availabilities[0].capacity").value(availability.capacity()))
        .andExpect(jsonPath("$.availabilities[0].available").value(availability.available()))
    ;
  }
}