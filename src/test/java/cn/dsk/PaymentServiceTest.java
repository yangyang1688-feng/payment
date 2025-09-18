package cn.dsk;

import cn.dsk.domain.Order;
import cn.dsk.domain.PaymentResult;
import cn.dsk.enums.PaymentTypeEnum;
import cn.dsk.service.OrderService;
import cn.dsk.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@ActiveProfiles("test")
public class PaymentServiceTest {
    
    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private OrderService orderService;
    
    @Test
    public void testAlipayPayment() {
        // 创建测试订单
        Order order = new Order();
        order.setOrderNo("TEST001");
        order.setAmount(new BigDecimal("100.00"));
        order.setPaymentType(PaymentTypeEnum.ALI_PAY);
        
        Order savedOrder = orderService.createOrder(order);
        
        // 执行支付
        PaymentResult result = paymentService.processPayment(savedOrder.getOrderNo());
        
        assertTrue(result.isSuccess());
        assertEquals("支付宝支付成功", result.getMsg());
    }
    
    @Test
    public void testWechatPayment() {
        // 创建测试订单
        Order order = new Order();
        order.setOrderNo("TEST002");
        order.setAmount(new BigDecimal("200.00"));
        order.setPaymentType(PaymentTypeEnum.WECHAT_PAY);
        
        Order savedOrder = orderService.createOrder(order);
        
        // 执行支付
        PaymentResult result = paymentService.processPayment(savedOrder.getOrderNo());
        
        assertTrue(result.isSuccess());
        assertEquals("微信支付成功", result.getMsg());
    }
}