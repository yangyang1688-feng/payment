package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentResult;
import cn.dsk.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// 抽象支付服务
@Service
public abstract class AbstractPaymentService extends PaymentTemplate {
    
    @Autowired
    private PaymentContext paymentContext;
    
    @Autowired
    private OrderService orderService;
    
    @Override
    protected boolean validateOrder(Order order) {
        // 检查订单是否存在且金额正确
        return order != null && order.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
    
    @Override
    protected PaymentResult executePayment(Order order) {
        return paymentContext.executePayment(order);
    }
    
    @Override
    protected void updateOrderStatus(Order order, PaymentResult result) {
        OrderStatusEnum status = result.isSuccess() ? OrderStatusEnum.PAID : OrderStatusEnum.FAILED;
        orderService.updateOrderStatus(order.getId(), status);
    }
    
    @Override
    protected void sendNotification(Order order, PaymentResult result) {
        // 基础通知逻辑，可由子类扩展
        System.out.println("支付结果通知: 订单号=" + order.getOrderNo() + 
                          ", 结果=" + result.isSuccess() + 
                          ", 消息=" + result.getMsg());
    }
}