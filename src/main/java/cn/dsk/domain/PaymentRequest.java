package cn.dsk.domain;

import cn.dsk.enums.OrderStatusEnum;
import cn.dsk.enums.PaymentTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付请求
 * @ClassName PaymentRequest
 * @Author yangfeng
 * @Date 2025/9/16 10:51
 * @Version 1.0
 */
@Data
public class PaymentRequest {
    private Long id;
    private String orderNo;
    private BigDecimal amount;
    private PaymentTypeEnum paymentType;
    private OrderStatusEnum status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}