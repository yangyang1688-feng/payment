package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentResult;
import cn.dsk.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// 抽象支付服务
@Service
@Slf4j
public abstract class AbstractPaymentService extends PaymentTemplate {
    
    @Autowired
    private PaymentContext paymentContext;
    
    @Autowired
    private OrderService orderService;
    
    @Override
    protected boolean validateOrder(Order order) {
        log.info("验证订单，订单号：{}，金额：{}", order.getOrderNo(), order.getAmount());
        // 检查订单是否存在且金额正确
        return order != null && order.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
    
    @Override
    protected PaymentResult executePayment(Order order) {
        log.info("执行支付，订单号：{}，金额：{}", order.getOrderNo(), order.getAmount());
         // 使用支付上下文执行支付
        return paymentContext.executePayment(order);
    }
    
    @Override
    protected void updateOrderStatus(Order order, PaymentResult result) {
        log.info("更新订单状态，订单号：{}，支付结果：{}", order.getOrderNo(), result.isSuccess());
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