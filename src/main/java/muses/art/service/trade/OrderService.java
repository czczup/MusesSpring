package muses.art.service.trade;

import muses.art.model.trade.OrderModel;

import java.util.ArrayList;
import java.util.List;


public interface OrderService {

    /**
     * @param userId 用户id
     * @return
     */
    List<OrderModel> listOrders(Integer userId);

    /**
     * @param id 订单id
     * @return
     */
    Boolean deleteOrder(Integer id);

    /**
     * @param id        订单id
     * @param payStatus 支付状态
     * @return
     */
    Boolean updateOrder(Integer id, String payStatus);

    /**
     *
     * @param cartIds 购物车id
     * @param addressId 地址id
     * @return
     */
    Boolean createOrderFromCart(ArrayList<Integer> cartIds, Integer addressId);


    /**
     * 增加待支付订单
     * @param orderModel 订单model
     * @param userId     用户id
     * @param addressId  地址id
     * @return Boolean
     */
    Boolean addOrderOfNoPay(OrderModel orderModel, int userId, int addressId);

    /**
     * 增加已支付订单
     * @param orderModel 订单model
     * @param userId 用户id
     * @param addressId 地址id
     * @return Boolean
     */
    Boolean addOrderOfPay(OrderModel orderModel, int userId, int addressId);


    /**
     * 更改待支付订单为已支付
     * @param id 订单id
     * @return Boolean
     */
    Boolean updateOrderStatus(int id);


    /**
     * 用户取消订单
     * @param id 订单id
     * @return Boolean
     */
    Boolean cancelOrder(int id);


    /**
     * 修改订单
     * @param orderModel 订单model
     * @return Boolean
     */
    Boolean updateOrder(OrderModel orderModel);


    /**
     * 得到订单详细信息
     * @param id 订单id
     * @return OrderModel
     */
    OrderModel getOrderById(int id);


    /**
     * 分页列出某用户订单信息
     * @param userId 用户id
     * @param start 页数
     * @param max 每页数量
     * @return 分页模型
     */
    List<OrderModel> listOrder(int userId, int start, int max);
}