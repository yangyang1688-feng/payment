package cn.dsk.controller;

import cn.dsk.domain.Order;
import cn.dsk.domain.OrderRequest;
import cn.dsk.domain.PaymentResult;
import cn.dsk.service.OrderService;
import cn.dsk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

// 支付控制器
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        Order order = new Order();
        order.setOrderNo(generateOrderNo());
        order.setAmount(request.getAmount());
        order.setPaymentType(request.getPaymentType());
        
        Order savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
    
    @PostMapping("/pay/{orderNo}")
    public ResponseEntity<PaymentResult> pay(@PathVariable String orderNo) {
        PaymentResult result = paymentService.processPayment(orderNo);
        return ResponseEntity.ok(result);
    }
    
    private String generateOrderNo() {
        return "ORD" + System.currentTimeMillis() + 
               String.format("%04d", new Random().nextInt(10000));
    }
}