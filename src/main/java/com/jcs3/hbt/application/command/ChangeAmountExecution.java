package com.jcs3.hbt.application.command;

import com.jcs3.hbt.domain.model.BudgetItem;
import com.jcs3.hbt.domain.model.BudgetItemId;
import com.jcs3.hbt.domain.model.repository.BudgetItemRepository;
import com.jcs3.hbt.domain.model.valueobject.Money;

public class ChangeAmountExecution {

  private final BudgetItemRepository budgetItemRepository;

  ChangeAmountExecution(BudgetItemRepository budgetItemRepository) {
    this.budgetItemRepository = budgetItemRepository;
  }

  public String changeAmount(BudgetItemId budgetItemId, Money amount) {
    BudgetItem budgetItem = budgetItemRepository.load(budgetItemId);
    budgetItem.execute(new ChangeAmountCmd(amount));
    budgetItemRepository.save(budgetItem);
    return "Success";
  }

}
