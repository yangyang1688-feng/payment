package cn.dsk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂
 * @ClassName PaymentFactory
 * @Author yangfeng
 * @Date 2025/9/16 15:31
 * @Version 1.0
 */
@Component
@Slf4j
public class PaymentFactory {
    private final Map<Integer, PaymentStrategy> strategyMap = new ConcurrentHashMap<>();
    @Autowired
    private void registerStrategy(List<PaymentStrategy> strategies) {
        for (PaymentStrategy strategy : strategies) {
            log.info("register strategy: {}", strategy.getClass().getSimpleName());
            strategyMap.put(strategy.payMode(), strategy);
        }
    }
    public PaymentStrategy getStrategy(Integer paymentType) {
        PaymentStrategy paymentStrategy = strategyMap.get(paymentType);
        if(null == paymentStrategy) {
            new IllegalArgumentException("不支持的支付方式: " + paymentType);
        }
        return paymentStrategy;
    }
}