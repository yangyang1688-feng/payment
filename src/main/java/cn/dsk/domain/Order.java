package cn.dsk.domain;

import cn.dsk.enums.OrderStatusEnum;
import cn.dsk.enums.PaymentTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 订单实体类
 * @ClassName Order
 * @Author yangfeng
 * @Date 2025/9/16 11:52
 * @Version 1.0
 */
@Data
public class Order {
    private Long id;
    private String orderNo;
    private BigDecimal amount;
    private PaymentTypeEnum paymentType;
    private OrderStatusEnum status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}