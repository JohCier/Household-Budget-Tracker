package com.jcs3.hbt.domain.model;

import com.jcs3.hbt.domain.model.event.DomainEvent;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public abstract class DomainEntity<I extends DomainEntityId> {

  private final I id;
  private final List<DomainEvent<?>> events = new ArrayList<>();

  protected DomainEntity(@NotNull I id) {
    this.id = id;
  }

  public I getId() {
    return id;
  }

  public void addEvent(DomainEvent<?> event) {
    events.add(event);
  }

  public List<DomainEvent<?>> getEvents() {
    return events;
  }

}