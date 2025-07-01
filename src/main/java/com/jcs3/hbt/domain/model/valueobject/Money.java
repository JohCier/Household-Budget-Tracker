package com.jcs3.hbt.domain.model.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

public final class Money {

  private final BigDecimal amount;
  private final Currency currency;

  // Constructors ------------------------------------------------------------------------------------------------------

  private Money(BigDecimal amount, Currency currency) {
    this.amount = amount.setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_EVEN);
    this.currency = currency;
  }

  public static Money of(BigDecimal amount, Currency currency) {
    validate(amount, currency);
    return new Money(amount, currency);
  }

  public static Money of(String amount, String currencyCode) {
    return of(new BigDecimal(amount), Currency.getInstance(currencyCode));
  }

  // Commands ----------------------------------------------------------------------------------------------------------

  private static void validate(BigDecimal amount, Currency currency) {
    if (amount == null || currency == null) {
      throw new IllegalArgumentException("Amount and currency must not be null");
    }
    if (amount.scale() > currency.getDefaultFractionDigits()) {
      throw new IllegalArgumentException("Scale of amount exceeds currency precision");
    }
  }

  public Money add(Money other) {
    ensureSameCurrency(other);
    return new Money(this.amount.add(other.amount), this.currency);
  }

  public Money subtract(Money other) {
    ensureSameCurrency(other);
    return new Money(this.amount.subtract(other.amount), this.currency);
  }

  public boolean isGreaterThan(Money other) {
    ensureSameCurrency(other);
    return this.amount.compareTo(other.amount) > 0;
  }

  public boolean isLessThan(Money other) {
    ensureSameCurrency(other);
    return this.amount.compareTo(other.amount) < 0;
  }

  private void ensureSameCurrency(Money other) {
    if (!this.currency.equals(other.currency)) {
      throw new IllegalArgumentException("Cannot operate on different currencies");
    }
  }

  // Queries -----------------------------------------------------------------------------------------------------------

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Money money)) {
      return false;
    }
    return amount.equals(money.amount) && currency.equals(money.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  @Override
  public String toString() {
    return amount + " " + currency.getCurrencyCode();
  }

}
