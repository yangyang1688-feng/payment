package cn.dsk.observer.springmode;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("springEmailNotificationListener")
public class EmailNotificationListener {
    @EventListener // 监听 NewsEvent 事件
    public void handleNewsEvent(NewsEvent event) {
        System.out.println("【邮件监听器】收到新闻事件：" + event.getNewsContent());
        // 实际项目中调用邮件服务发送邮件
    }
}
