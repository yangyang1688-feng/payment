package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 支付服务
@Service
public class PaymentService {
    
    @Autowired
    private ConcretePaymentService concretePaymentService;
    
    @Autowired
    private PaymentEventPublisher eventPublisher;
    
    @Autowired
    private OrderService orderService;

    @Transactional
    public PaymentResult processPayment(String orderNo) {
        Order order = orderService.getOrderByNo(orderNo);
        if (order == null) {
            return new PaymentResult(false, "订单不存在", orderNo);
        }
        
        PaymentResult result = concretePaymentService.process(order);
        
        // 发布支付事件
        eventPublisher.publishPaymentSuccessEvent(order, result);
        
        return result;
    }
}