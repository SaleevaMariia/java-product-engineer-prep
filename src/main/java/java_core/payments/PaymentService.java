package java_core.payments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentService {
    private final Map<PaymentMethod, PaymentProcessor> processorsByMethod;

    public PaymentService(List<PaymentProcessor> processors) {
        if (processors == null || processors.isEmpty()) {
            throw new IllegalArgumentException("Payment processors must not be null or empty");
        }
        if (processors.contains(null)) {
            throw new IllegalArgumentException("Payment processors must not contain null");
        }
        Map<PaymentMethod, PaymentProcessor> map = new HashMap<>();
        for (PaymentProcessor processor : processors) {
            PaymentMethod supportedMethod = processor.getSupportedMethod();
            if (supportedMethod == null) {
                throw new IllegalArgumentException("Supported payment method must not be null");
            }
            if (map.containsKey(supportedMethod)) {
                throw new IllegalArgumentException("Duplicate payment processor for method: " + supportedMethod);
            }
            map.put(processor.getSupportedMethod(), processor);
        }
        this.processorsByMethod = Map.copyOf(map);
    }

    public PaymentResult pay(PaymentRequest request, PaymentMethod method) {
        if (request == null) {
            throw new IllegalArgumentException("PaymentRequest must not be null");
        }
        if (method == null) {
            throw new IllegalArgumentException("PaymentMethod must not be null");
        }
        PaymentProcessor processor = processorsByMethod.get(method);
        if (processor != null) {
            return processor.process(request);
        }
        throw new IllegalArgumentException("PaymentProcessor wasn't found");
    }
}