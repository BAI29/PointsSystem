package service;

/*
 * 消费积分的方法*/

public interface MethodsOfConsume {

    //订单抵消积分、优惠券兑换、参加活动
    public double consume (int id);

    //积分换购，传入用户id和商品id
    public double consume (int id, int goodsId);
}
