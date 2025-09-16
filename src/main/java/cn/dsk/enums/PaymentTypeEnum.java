package cn.dsk.enums;

import lombok.Getter;

/**
 * 支付方式枚举
 * @ClassName PaymentMode
 * @Author yangfeng
 * @Date 2025/9/16 10:59
 * @Version 1.0
 */
@Getter
public enum PaymentTypeEnum {
    WECHAT_PAY(1,""),ALI_PAY(2,""),UNION_PAY(3,"");

    private Integer code;

    private String name;

    PaymentTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
