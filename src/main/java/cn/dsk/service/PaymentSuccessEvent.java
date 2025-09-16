package cn.dsk.service;

import cn.dsk.domain.PaymentEvent;
import org.springframework.context.ApplicationEvent;

public class PaymentSuccessEvent extends ApplicationEvent {
    private final PaymentEvent paymentEvent;
    
    public PaymentSuccessEvent(Object source, PaymentEvent paymentEvent) {
        super(source);
        this.paymentEvent = paymentEvent;
    }
    
    public PaymentEvent getPaymentEvent() {
        return paymentEvent;
    }
}