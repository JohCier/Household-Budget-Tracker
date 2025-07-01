package com.jcs3.hbt.domain.model.valueobject;

import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyTest {

  private static final Currency EUR = Currency.getInstance("EUR");
  private static final Currency USD = Currency.getInstance("USD");

  @Test
  void shouldCreateMoneyWithCorrectAmountAndCurrency() {
    Money money = Money.of(new BigDecimal("10.00"), EUR);
    assertEquals(new BigDecimal("10.00"), money.getAmount());
    assertEquals(EUR, money.getCurrency());
  }

  @Test
  void shouldFailOnNullAmountOrCurrency() {
    assertThrows(IllegalArgumentException.class, () -> Money.of(null, EUR));
    assertThrows(IllegalArgumentException.class, () -> Money.of(BigDecimal.TEN, null));
  }

  @Test
  void shouldRejectInvalidScale() {
    assertThrows(IllegalArgumentException.class, () -> Money.of(new BigDecimal("10.001"), EUR));
  }

  @Test
  void shouldAddMoneyWithSameCurrency() {
    Money a = Money.of(new BigDecimal("10.00"), EUR);
    Money b = Money.of(new BigDecimal("5.50"), EUR);
    Money result = a.add(b);
    assertEquals(Money.of(new BigDecimal("15.50"), EUR), result);
  }

  @Test
  void shouldSubtractMoneyWithSameCurrency() {
    Money a = Money.of(new BigDecimal("10.00"), EUR);
    Money b = Money.of(new BigDecimal("4.00"), EUR);
    Money result = a.subtract(b);
    assertEquals(Money.of(new BigDecimal("6.00"), EUR), result);
  }

  @Test
  void shouldThrowOnCurrencyMismatchInAdd() {
    Money eur = Money.of(new BigDecimal("10.00"), EUR);
    Money usd = Money.of(new BigDecimal("5.00"), USD);
    assertThrows(IllegalArgumentException.class, () -> eur.add(usd));
  }

  @Test
  void shouldThrowOnCurrencyMismatchInSubtract() {
    Money eur = Money.of(new BigDecimal("10.00"), EUR);
    Money usd = Money.of(new BigDecimal("5.00"), USD);
    assertThrows(IllegalArgumentException.class, () -> eur.subtract(usd));
  }

  @Test
  void shouldCompareCorrectly() {
    Money a = Money.of(new BigDecimal("10.00"), EUR);
    Money b = Money.of(new BigDecimal("5.00"), EUR);
    Money c = Money.of(new BigDecimal("10.00"), EUR);

    assertTrue(a.isGreaterThan(b));
    assertFalse(b.isGreaterThan(a));
    assertFalse(a.isGreaterThan(c));

    assertTrue(b.isLessThan(a));
    assertFalse(a.isLessThan(b));
    assertFalse(a.isLessThan(c));
  }

  @Test
  void shouldImplementEqualsAndHashCode() {
    Money m1 = Money.of(new BigDecimal("10.00"), EUR);
    Money m2 = Money.of(new BigDecimal("10.00"), EUR);
    Money m3 = Money.of(new BigDecimal("10.00"), USD);
    Money m4 = Money.of(new BigDecimal("5.00"), EUR);

    assertEquals(m1, m2);
    assertEquals(m1.hashCode(), m2.hashCode());

    assertNotEquals(m1, m3);
    assertNotEquals(m1, m4);
  }

  @Test
  void shouldFormatToStringCorrectly() {
    Money money = Money.of(new BigDecimal("99.99"), EUR);
    assertEquals("99.99 EUR", money.toString());
  }

  @Test
  void shouldCreateMoneyUsingStringFactoryMethod() {
    Money money = Money.of("19.95", "EUR");
    assertEquals(new BigDecimal("19.95"), money.getAmount());
    assertEquals(EUR, money.getCurrency());
  }

}
