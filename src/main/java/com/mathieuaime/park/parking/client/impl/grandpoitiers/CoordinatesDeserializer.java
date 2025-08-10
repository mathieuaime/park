package com.mathieuaime.park.parking.client.impl.grandpoitiers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mathieuaime.park.model.Coordinates;
import java.io.IOException;

class CoordinatesDeserializer extends JsonDeserializer<Coordinates> {

  @Override
  public Coordinates deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    String text = jsonParser.getText();
    if (text == null || text.isBlank()) {
      return null;
    }

    String[] parts = text.split(",");
    if (parts.length != 2) {
      throw deserializationContext.weirdStringException(text, Coordinates.class, "Expected format: 'lat, lon'");
    }

    try {
      double latitude = Double.parseDouble(parts[0].trim());
      double longitude = Double.parseDouble(parts[1].trim());
      return new Coordinates(latitude, longitude);
    } catch (NumberFormatException e) {
      throw deserializationContext.weirdStringException(text, Coordinates.class, "Invalid number format");
    }
  }
}
