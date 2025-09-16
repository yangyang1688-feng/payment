package cn.dsk.service;

import cn.dsk.domain.PaymentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 支付日志监听器
@Component
public class PaymentLogListener {
    
    @EventListener
    public void handlePaymentSuccessEvent(PaymentSuccessEvent event) {
        PaymentEvent paymentEvent = event.getPaymentEvent();
        
        System.out.println("记录支付日志: " + paymentEvent.toString());
        // 实际记录日志的逻辑
    }
}