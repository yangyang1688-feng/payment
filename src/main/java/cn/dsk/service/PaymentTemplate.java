package cn.dsk.service;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentResult;

// 支付模板
public abstract class PaymentTemplate {
    
    public final PaymentResult process(Order order) {
        // 1. 验证订单
        if (!validateOrder(order)) {
            return new PaymentResult(false, "订单验证失败", order.getOrderNo());
        }
        
        // 2. 执行支付
        PaymentResult result = executePayment(order);
        
        // 3. 更新订单状态
        updateOrderStatus(order, result);
        
        // 4. 发送通知
        sendNotification(order, result);
        
        return result;
    }
    
    protected abstract boolean validateOrder(Order order);
    protected abstract PaymentResult executePayment(Order order);
    protected abstract void updateOrderStatus(Order order, PaymentResult result);
    protected abstract void sendNotification(Order order, PaymentResult result);
}