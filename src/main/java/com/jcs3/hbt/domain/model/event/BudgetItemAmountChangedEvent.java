package com.jcs3.hbt.domain.model.event;

import com.jcs3.hbt.domain.model.BudgetItemId;
import com.jcs3.hbt.domain.model.valueobject.Money;

public class BudgetItemAmountChangedEvent extends DomainEvent<BudgetItemId> {

  public final Money amount;
  public final Money oldAmount;

  public BudgetItemAmountChangedEvent(BudgetItemId id, Money amount, Money oldAmount) {
    super(id);
    this.amount = amount;
    this.oldAmount = oldAmount;
  }

}
