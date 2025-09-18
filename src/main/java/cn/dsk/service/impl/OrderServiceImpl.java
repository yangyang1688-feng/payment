package cn.dsk.service.impl;

import cn.dsk.domain.Order;
import cn.dsk.enums.OrderStatusEnum;
import cn.dsk.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 替换描述
 *
 * @ClassName OrderServiceImpl
 * @Author yangfeng
 * @Date 2025/9/16 17:32
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void updateOrderStatus(Long orderId, OrderStatusEnum status) {

    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderByNo(String orderNo) {
        return null;
    }
}