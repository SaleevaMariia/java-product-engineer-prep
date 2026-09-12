package java_core.payments;

import java.util.Locale;

public final class PaymentRequest {
    private final String currency;
    private final long amountInCents;

    public PaymentRequest(String currency, long amountInCents) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be null or blank");
        }
        if (amountInCents <= 0) {
            throw new IllegalArgumentException("AmountInCents must be greater than 0");
        }
        this.currency = currency.toUpperCase(Locale.ROOT);
        this.amountInCents = amountInCents;
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public String getCurrency() {
        return currency;
    }
}
