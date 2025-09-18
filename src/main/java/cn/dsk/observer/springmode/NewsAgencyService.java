package cn.dsk.observer.springmode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NewsAgencyService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    // 发布新闻事件
    public void publishNews(String newsContent) {
        System.out.println("【新闻社】发布新闻：" + newsContent);
        NewsEvent event = new NewsEvent(this, newsContent);
        eventPublisher.publishEvent(event); // 发布事件
    }
}