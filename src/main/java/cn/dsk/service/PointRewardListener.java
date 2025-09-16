package cn.dsk.service;

import cn.dsk.domain.PaymentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// 积分奖励监听器
@Component
public class PointRewardListener {
    
    @EventListener
    @Async
    public void handlePaymentSuccessEvent(PaymentSuccessEvent event) {
        PaymentEvent paymentEvent = event.getPaymentEvent();
        
        if (paymentEvent.isSuccess()) {
            System.out.println("为用户增加积分: 订单号=" + paymentEvent.getOrderNo() + 
                             ", 金额=" + paymentEvent.getAmount());
            // 实际增加积分的逻辑
        }
    }
}