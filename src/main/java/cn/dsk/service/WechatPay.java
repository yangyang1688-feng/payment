package cn.dsk.service;

import cn.dsk.domain.*;
import cn.dsk.enums.PaymentTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信支付
 * @ClassName WechatPay
 * @Author yangfeng
 * @Date 2025/9/16 11:20
 * @Version 1.0
 */
@Service
@Slf4j
public class WechatPay implements PaymentStrategy {
    @Override
    public PaymentResult pay(Order request) {
        return new PaymentResult(true, "微信支付成功","WX123456789");
    }

    @Override
    public RefundResult refund(RefundRequest request) {
        return new RefundResult(true, "退款成功","WX123456789");
    }

    @Override
    public Integer payMode() {
        return PaymentTypeEnum.WECHAT_PAY.getCode();
    }
}