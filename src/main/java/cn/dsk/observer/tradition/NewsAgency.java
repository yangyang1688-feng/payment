package cn.dsk.observer.tradition;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // 交给 Spring 管理
public class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String latestNews; // 主题状态（最新新闻）

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message); // 通知所有观察者
        }
    }

    // 设置最新新闻并触发通知
    public void setLatestNews(String news) {
        this.latestNews = news;
        System.out.println("【新闻社】最新新闻已更新：" + news);
        notifyObservers(news); // 状态变化时通知观察者
    }
}