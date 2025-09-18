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
@Component("traditionEmailNotificationObserver")
@Slf4j
public class EmailNotificationObserver implements Observer {
    @Override
    public void update(String message) {
        log.info("邮件通知收到消息: {}", message);
    }
}