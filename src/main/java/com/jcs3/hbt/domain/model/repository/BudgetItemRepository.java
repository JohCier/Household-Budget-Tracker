package com.jcs3.hbt.domain.model.repository;

import com.jcs3.hbt.domain.model.BudgetItem;
import com.jcs3.hbt.domain.model.BudgetItemId;

public interface BudgetItemRepository {

  BudgetItem load(BudgetItemId budgetItemId);

  void save(BudgetItem budgetItem);

}
