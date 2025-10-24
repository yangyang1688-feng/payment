package cn.dsk.observer.tradition;

/**
 * 主题接口（被观察者角色）知道它的观察者，提供添加和删除观察者的方法，并在自身状态发生变化时通知观察者
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
