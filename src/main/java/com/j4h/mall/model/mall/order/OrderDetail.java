package com.j4h.mall.model.mall.order;

public class OrderDetail {
    private Order order;
    private OrderGoods[] orderGoods;
    private OrderUser user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderGoods[] getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(OrderGoods[] orderGoods) {
        this.orderGoods = orderGoods;
    }

    public OrderUser getUser() {
        return user;
    }

    public void setUser(OrderUser user) {
        this.user = user;
    }
}
