package cn.dsk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付结果
 * @ClassName PaymentResult
 * @Author yangfeng
 * @Date 2025/9/16 10:51
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResult {
    private boolean success;

    private String msg;

    private String code;
}