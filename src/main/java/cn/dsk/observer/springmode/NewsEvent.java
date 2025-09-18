package cn.dsk.observer.springmode;

import org.springframework.context.ApplicationEvent;

public class NewsEvent extends ApplicationEvent {
    private final String newsContent;

    public NewsEvent(Object source, String newsContent) {
        super(source); // source 是事件发布者（如 NewsAgency）
        this.newsContent = newsContent;
    }

    public String getNewsContent() {
        return newsContent;
    }
}