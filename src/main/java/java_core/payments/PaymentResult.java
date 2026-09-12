package java_core.payments;

public final class PaymentResult {
    private final PaymentMethod paymentMethod;
    private final PaymentResultStatus paymentResultStatus;
    private final String message;

    public PaymentResult(PaymentMethod paymentMethod, PaymentResultStatus paymentResultStatus, String message) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("PaymentMethod must not be null");
        }
        if (paymentResultStatus == null) {
            throw new IllegalArgumentException("PaymentResultStatus must not be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message must not be null or blank");
        }
        this.paymentMethod = paymentMethod;
        this.paymentResultStatus = paymentResultStatus;
        this.message = message;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentResultStatus getPaymentResultStatus() {
        return paymentResultStatus;
    }

    public String getMessage() {
        return message;
    }
}
