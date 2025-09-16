package cn.dsk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 退款成功结果
 * @ClassName RefundResult
 * @Author yangfeng
 * @Date 2025/9/16 10:57
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundResult {
    private boolean success;

    private String msg;

    private String code;
}