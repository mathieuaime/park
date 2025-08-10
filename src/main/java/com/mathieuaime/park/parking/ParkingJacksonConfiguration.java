package com.mathieuaime.park.parking;

import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mathieuaime.park.model.configuration.Mobility;
import com.mathieuaime.park.parking.configuration.ParkingClientConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ParkingJacksonConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer addParkingConfigurationSubtype() {
    return builder -> builder.modules(new SimpleModule().registerSubtypes(
        new NamedType(ParkingClientConfiguration.class, Mobility.PARKING.name())));
  }
}
