package cn.dsk.domain;

import cn.dsk.enums.OrderStatusEnum;
import cn.dsk.enums.PaymentTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 替换描述
 *
 * @ClassName OrderRequest
 * @Author yangfeng
 * @Date 2025/9/17 11:44
 * @Version 1.0
 */
@Data
public class OrderRequest {
    /**
     * 支付金额
     */
    private BigDecimal amount;
    /**
     * 支付类型
     */
    private PaymentTypeEnum paymentType;
}