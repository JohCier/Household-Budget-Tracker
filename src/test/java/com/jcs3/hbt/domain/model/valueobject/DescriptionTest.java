package com.jcs3.hbt.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DescriptionTest {

  @Test
  void shouldCreateDescriptionWithText() {
    Description description = new Description("This is a description.");
    assertEquals("This is a description.", description.getValue());
    assertFalse(description.isEmpty());
  }

  @Test
  void shouldTreatNullAsEmpty() {
    Description description = new Description(null);
    assertEquals("", description.getValue());
    assertTrue(description.isEmpty());
  }

  @Test
  void shouldRecognizeEmptyDescription() {
    Description description = new Description("");
    assertTrue(description.isEmpty());
  }

  @Test
  void shouldCompareEqualDescriptions() {
    Description d1 = new Description("Text");
    Description d2 = new Description("Text");

    assertEquals(d1, d2);
    assertEquals(d1.hashCode(), d2.hashCode());
  }

  @Test
  void shouldDetectDifferentDescriptions() {
    Description d1 = new Description("Text A");
    Description d2 = new Description("Text B");

    assertNotEquals(d1, d2);
  }

  @Test
  void shouldHaveStringRepresentation() {
    Description description = new Description("This is a description");
    assertEquals("This is a description", description.toString());
  }

}
