package cn.dsk.observer.tradition;

/**
 * 观察者接口
 * @ClassName Observer
 * @Author yangfeng
 * @Date 2025/9/18 10:50
 * @Version 1.0
 */
public interface Observer {
    //接收主题通知的方法
    void update(String message);
}
