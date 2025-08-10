package com.mathieuaime.park;

import com.mathieuaime.park.model.Availability;
import com.mathieuaime.park.model.Coordinates;

public final class TestData {

  private static final Availability ARC_DE_TRIOMPHE = new Availability("Arc De Triomphe",
      new Coordinates(48.873764922340115, 2.2948498336909906), 1000, 876);

  private TestData() {
    throw new AssertionError();
  }

  public static Availability getTestAvailability() {
    return ARC_DE_TRIOMPHE;
  }
}
