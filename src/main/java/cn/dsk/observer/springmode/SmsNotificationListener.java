package cn.dsk.observer.springmode;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("springSmsNotificationListener")
public class SmsNotificationListener {
    @EventListener
    public void handleNewsEvent(NewsEvent event) {
        System.out.println("【短信监听器】收到新闻事件：" + event.getNewsContent());
        // 实际项目中调用短信服务发送短信
    }
}