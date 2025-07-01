package com.jcs3.hbt.domain.model.event;

import com.jcs3.hbt.domain.model.DomainEntityId;
import jakarta.validation.constraints.NotNull;

public class DomainEvent<I extends DomainEntityId> {

  private final I id;

  protected DomainEvent(@NotNull I id) {
    this.id = id;
  }

  public I getId() {
    return id;
  }

}
