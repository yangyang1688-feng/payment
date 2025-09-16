package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentEvent;
import cn.dsk.domain.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

// 支付事件发布者
@Component
public class PaymentEventPublisher {
    
    private final ApplicationEventPublisher eventPublisher;
    
    @Autowired
    public PaymentEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    public void publishPaymentSuccessEvent(Order order, PaymentResult result) {
        PaymentEvent paymentEvent = new PaymentEvent(
            order.getOrderNo(),
            order.getAmount(),
            order.getPaymentType(),
            result.isSuccess(),
            result.getMsg()
        );
        
        PaymentSuccessEvent event = new PaymentSuccessEvent(this, paymentEvent);
        eventPublisher.publishEvent(event);
    }
}