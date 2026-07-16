package java_core.immutable_learn;

import java.util.Locale;
import java.util.Objects;

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
            throw new IllegalArgumentException("Currencies must be equal");
        }
        return new Money(this.amountInCents + other.amountInCents, this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;
        return this.amountInCents == money.amountInCents
                && this.currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountInCents, currency);
    }

    public Money multiply(int multiplier) {
        if (multiplier < 0) {
            throw new IllegalArgumentException("Multiplier must not be negative");
        }
        return new Money(this.amountInCents * multiplier, this.currency);
    }
}
