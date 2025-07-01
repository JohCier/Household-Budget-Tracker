package com.jcs3.hbt.domain.model.valueobject;

import java.util.Objects;

public final class Description {

  private final String value;

  public Description(String value) {
    this.value = value == null ? "" : value;
  }

  public String getValue() {
    return value;
  }

  public boolean isEmpty() {
    return value.isEmpty();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Description that)) {
      return false;
    }
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }

}
