package java_core.payments;

public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentMethod getSupportedMethod() {
        return PaymentMethod.CARD;
    }

    @Override
    public PaymentResult process(PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            throw new IllegalArgumentException("Payment request must not be null");
        }
        return new PaymentResult(PaymentMethod.CARD, PaymentResultStatus.SUCCESS, "Card payment completed");
    }
}
