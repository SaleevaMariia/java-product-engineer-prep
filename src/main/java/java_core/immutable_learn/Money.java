package java_core.immutable_learn;

import java.util.Locale;

public final class Money {
    private final long amountInCents;
    private final String currency;

    public Money(long amountInCents, String currency) {
        if (amountInCents < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be null or blank");
        }
        this.amountInCents = amountInCents;
        this.currency = currency.toUpperCase(Locale.ROOT);
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        if (other == null) {
            throw new IllegalArgumentException("Other money must not be null");
        }
        if (!this.currency.equals(other.getCurrency())) {
            throw new IllegalArgumentException("Currency should be equal");
        }
        return new Money(amountInCents + other.amountInCents, currency);
    }
}
