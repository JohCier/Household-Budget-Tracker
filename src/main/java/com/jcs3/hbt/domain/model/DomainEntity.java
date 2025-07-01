package com.jcs3.hbt.domain.model;

import jakarta.validation.constraints.NotNull;

public abstract class DomainEntity<I extends Id> {

  private final I id;

  protected DomainEntity(@NotNull I id) {
    this.id = id;
  }

  public I getId() {
    return id;
  }

}