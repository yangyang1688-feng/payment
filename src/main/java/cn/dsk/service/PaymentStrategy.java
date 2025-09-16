package cn.dsk.service;

import cn.dsk.domain.*;

/**
 * 支付策略接口
 * @ClassName PaymentStrategy
 * @Author yangfeng
 * @Date 2025/9/16 10:49
 * @Version 1.0
 */
public interface PaymentStrategy {
    /**
     * 支付方法
     * @param request 支付请求
     * @Return: cn.dsk.domain.PaymentResult
     * @author: yangfeng
     * @date: 2025/9/16 10:56
     **/
    PaymentResult pay(Order request);
   /**
    * 退款方法
    * @param request
    * @Return: cn.dsk.domain.RefundResult
    * @author: yangfeng
    * @date: 2025/9/16 11:19
    **/
    RefundResult refund(RefundRequest request);
    /**
     * 支付方式
     * @param
     * @Return: java.lang.Integer
     * @author: yangfeng
     * @date: 2025/9/16 11:19
     **/
    Integer payMode();
}
