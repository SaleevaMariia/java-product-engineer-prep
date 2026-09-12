package java_core.payments;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentMethod getSupportedMethod() {
        return PaymentMethod.CASH;
    }

    @Override
    public PaymentResult process(PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            throw new IllegalArgumentException("Payment request must not be null");
        }
        return new PaymentResult(PaymentMethod.CASH, PaymentResultStatus.SUCCESS, "Cash payment completed");
    }
}
