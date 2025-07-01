package com.jcs3.hbt.domain.model;

import com.jcs3.hbt.domain.model.valueobject.Description;
import com.jcs3.hbt.domain.model.valueobject.Money;

public class BudgetItem extends DomainEntity<BudgetItemId> {

  private final Description description;
  private final Money amount;
  private final BudgetItemCategory category;

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
