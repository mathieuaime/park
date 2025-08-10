package com.mathieuaime.park.mobility.parking.service;

import com.mathieuaime.park.mobility.parking.client.ParkingClient;
import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.configuration.Mobility;
import com.mathieuaime.park.service.AvailabilityService;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParkingAvailabilityService implements AvailabilityService {

  private final List<ParkingClient> clients;

  public ParkingAvailabilityService(List<ParkingClient> clients) {
    this.clients = clients;
  }

  @Override
  public Mobility getResourceType() {
    return Mobility.PARKING;
  }

  @Override
  public Set<Availability> getAvailabilities() {
    return clients.stream()
        .map(ParkingClient::getAvailabilities)
        .flatMap(Collection::stream)
        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Availability::name))));
  }
}
