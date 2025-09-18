package cn.dsk;

import cn.dsk.observer.springmode.NewsAgencyService;
import cn.dsk.observer.tradition.EmailNotificationObserver;
import cn.dsk.observer.tradition.NewsAgency;
import cn.dsk.observer.tradition.Observer;
import cn.dsk.observer.tradition.SmsNotificationObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PaymentApplication.class, args);
        // 传统观察者模式示例---------------------------start
//        // 获取主题和观察者实例
//        NewsAgency newsAgency = context.getBean(NewsAgency.class);
//        Observer emailObserver = context.getBean(EmailNotificationObserver.class);
//        Observer smsObserver = context.getBean(SmsNotificationObserver.class);
//
//        // 注册观察者
//        newsAgency.registerObserver(emailObserver);
//        newsAgency.registerObserver(smsObserver);
//
//        // 模拟新闻更新
//        newsAgency.setLatestNews("2025年9月18日：Spring Boot 3.2.0 正式发布！");
//        newsAgency.setLatestNews("2025年9月19日：Java 21 正式发布！");
        // 传统观察者模式示例---------------------------end
        // 获取事件发布者
        NewsAgencyService newsAgencyService = context.getBean(NewsAgencyService.class);

        // 发布新闻事件
        newsAgencyService.publishNews("2025年9月18日：Spring Boot 3.2.0 正式发布！");
        newsAgencyService.publishNews("2025年9月19日：Java 21 正式发布！");

        context.close();
    }

}
