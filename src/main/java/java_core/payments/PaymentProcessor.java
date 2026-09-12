package java_core.payments;

public interface PaymentProcessor {
    PaymentMethod getSupportedMethod();
    PaymentResult process(PaymentRequest paymentRequest);
}

