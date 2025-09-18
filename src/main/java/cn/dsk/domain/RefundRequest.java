package cn.dsk.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 退款请求
 * @ClassName RefundRequest
 * @Author yangfeng
 * @Date 2025/9/16 10:56
 * @Version 1.0
 */
@Data
public class RefundRequest {
    private String orderNo;
    private BigDecimal amount;

}