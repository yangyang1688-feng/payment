package cn.dsk.observer.tradition;

/**
 * 主题接口
 * @ClassName Subject
 * @Author yangfeng
 * @Date 2025/9/18 10:58
 * @Version 1.0
 */
public interface Subject {
    /**
     * 注册观察者接口
     * @param o
     * @Return: void
     * @author: yangfeng
     * @date: 2025/9/18 11:28
     **/
    void registerObserver(Observer o);
    /**
     * 移除观察者
     * @param o
     * @Return: void
     * @author: yangfeng
     * @date: 2025/9/18 11:29
     **/
    void removeObserver(Observer o);
    /**
     * 通知所有观察者
     * @param message
     * @Return: void
     * @author: yangfeng
     * @date: 2025/9/18 11:29
     **/
    void notifyObservers(String message);
}
