package cn.dsk.domain;

import cn.dsk.enums.PaymentTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentEvent {
    private String orderNo;
    private BigDecimal amount;
    private PaymentTypeEnum paymentType;
    private boolean success;
    private String message;
    private LocalDateTime eventTime;
    
    public PaymentEvent(String orderNo, BigDecimal amount,
                        PaymentTypeEnum paymentType, boolean success, String message) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.paymentType = paymentType;
        this.success = success;
        this.message = message;
        this.eventTime = LocalDateTime.now();
    }
}