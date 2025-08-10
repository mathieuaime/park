package com.mathieuaime.park.model.configuration;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "mobility",
    use = JsonTypeInfo.Id.NAME,
    visible = true
)
public interface ClientConfiguration {

  String name();

  Mobility mobility();
}
