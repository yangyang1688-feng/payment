package cn.dsk.service;

import cn.dsk.enums.OrderStatusEnum;

/**
 * 替换描述
 *
 * @ClassName OrderService
 * @Author yangfeng
 * @Date 2025/9/16 17:32
 * @Version 1.0
 */
public interface OrderService {

    void updateOrderStatus(Long orderId, OrderStatusEnum status);
}
