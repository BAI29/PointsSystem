package service;

/*
 * 赚取积分的方法*/

public interface MethodsOfEarn {

    //下订单赚取积分时传入金额
    public double earn(int id , double money);

    //每日签到和评论
    public double earn(int id);
}
