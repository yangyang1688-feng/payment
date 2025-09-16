package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentRequest;
import cn.dsk.domain.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 支付上下文
@Component
public class PaymentContext {
    
    private final PaymentFactory strategyFactory;
    
    @Autowired
    public PaymentContext(PaymentFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }
    
    public PaymentResult executePayment(PaymentRequest order) {
        PaymentStrategy strategy = strategyFactory.getStrategy(order.getPaymentType().getCode());
        return strategy.pay(order);
    }
}