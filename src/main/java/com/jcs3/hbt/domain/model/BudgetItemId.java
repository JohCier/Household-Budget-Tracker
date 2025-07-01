package com.jcs3.hbt.domain.model;

import java.util.UUID;

public class BudgetItemId extends DomainEntityId {

  protected BudgetItemId(String id) {
    super(id);
  }

  public static BudgetItemId generate() {
    return new BudgetItemId(UUID.randomUUID().toString());
  }

  public static BudgetItemId fromString(String id) {
    return new BudgetItemId(id);
  }

}
