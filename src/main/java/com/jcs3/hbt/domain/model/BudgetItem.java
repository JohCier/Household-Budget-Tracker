package com.jcs3.hbt.domain.model;

import com.jcs3.hbt.application.command.ChangeAmountCmd;
import com.jcs3.hbt.domain.model.event.BudgetItemAmountChangedEvent;
import com.jcs3.hbt.domain.model.valueobject.Description;
import com.jcs3.hbt.domain.model.valueobject.Money;

public class BudgetItem extends DomainEntity<BudgetItemId> {

  private Description description;
  private Money amount;
  private BudgetItemCategory category;

  // Constructors ------------------------------------------------------------------------------------------------------

  private BudgetItem(BudgetItemId id, Description description, Money amount, BudgetItemCategory category) {
    super(id);
    this.description = description;
    this.amount = amount;
    this.category = category;
  }

  public BudgetItem createNew(Description description, Money amount, BudgetItemCategory category) {
    return new BudgetItem(BudgetItemId.generate(), description, amount, category);
  }

  // Commands ----------------------------------------------------------------------------------------------------------

  public void execute(ChangeAmountCmd changeAmountCmd) {
    Money oldAmount = amount;
    this.amount = changeAmountCmd.amount();
    addEvent(new BudgetItemAmountChangedEvent(getId(), amount, oldAmount));
  }

  // Queries -----------------------------------------------------------------------------------------------------------

  public Description getDescription() {
    return description;
  }

  public Money getAmount() {
    return amount;
  }

  public BudgetItemCategory getCategory() {
    return category;
  }

  // Inner Types -------------------------------------------------------------------------------------------------------

  public enum BudgetItemCategory {
    FIXED_COSTS, SAVINGS, LEISURE
  }

}
