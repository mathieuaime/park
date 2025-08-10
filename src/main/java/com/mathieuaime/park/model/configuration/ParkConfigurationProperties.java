package com.mathieuaime.park.model.configuration;

import java.util.List;

public class ParkConfigurationProperties {

  private List<ClientConfiguration> configurations;

  public List<ClientConfiguration> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<ClientConfiguration> configurations) {
    this.configurations = configurations;
  }

  public <T extends ClientConfiguration> List<T> getConfigurationByResourceType(Mobility mobility) {
    return configurations.stream().filter(c -> c.mobility() == mobility).map(c -> (T) c).toList();
  }
}
