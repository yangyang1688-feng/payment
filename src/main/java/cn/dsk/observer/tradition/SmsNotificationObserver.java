package cn.dsk.observer.tradition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *邮件通知观察者
 * @ClassName EmailNotificationObserver
 * @Author yangfeng
 * @Date 2025/9/18 10:53
 * @Version 1.0
 */
@Component("traditionSmsNotificationObserver")
@Slf4j
public class SmsNotificationObserver implements Observer {
    @Override
    public void update(String message) {
        log.info("短信通知收到消息: {}", message);
    }
}