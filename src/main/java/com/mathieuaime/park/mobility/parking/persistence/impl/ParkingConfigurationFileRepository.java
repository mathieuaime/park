package com.mathieuaime.park.mobility.parking.persistence.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathieuaime.park.mobility.parking.configuration.ParkingClientConfiguration;
import com.mathieuaime.park.mobility.parking.persistence.ParkingConfigurationRepository;
import com.mathieuaime.park.model.configuration.Mobility;
import com.mathieuaime.park.model.configuration.ParkConfigurationProperties;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ParkingConfigurationFileRepository implements ParkingConfigurationRepository {

  private final ObjectMapper objectMapper;

  @Value("classpath:data/configuration.json")
  private Resource configurationFile;

  private ParkConfigurationProperties properties;

  public ParkingConfigurationFileRepository(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @PostConstruct
  public void init() throws IOException {
    try (InputStream inputStream = configurationFile.getInputStream()) {
      this.properties = objectMapper.readValue(inputStream, ParkConfigurationProperties.class);
    }
  }

  @Override
  public List<ParkingClientConfiguration> getConfigurations() {
    return properties.getConfigurationByResourceType(Mobility.PARKING);
  }
}
