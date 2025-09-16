package cn.dsk.service;

import cn.dsk.domain.PaymentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// 邮件通知监听器
@Component
public class EmailNotificationListener {
    
    @EventListener
    @Async
    public void handlePaymentSuccessEvent(PaymentSuccessEvent event) {
        PaymentEvent paymentEvent = event.getPaymentEvent();
        
        if (paymentEvent.isSuccess()) {
            System.out.println("发送支付成功邮件: 订单号=" + paymentEvent.getOrderNo() + 
                             ", 金额=" + paymentEvent.getAmount());
            // 实际发送邮件的逻辑
        }
    }
}