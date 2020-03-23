package service;

/*
* 根据不同类型，调动不同的消费积分的方法*/

import service.method.consume.DeductOrderMoney;
import service.method.consume.JoinActivities;
import service.method.consume.PointsRedemption;
import service.method.consume.RedeemCoupons;


public class ConsumePoints {

    //根据类型判断是哪一种消费积分的方式
    public String methodsOfEarn(String type, int id, int goodsId) {

        String message = "";
        double cutPoints = 0;
        switch (type) {
            //抵消部分订单金额
            case "DeductOrderMoney":
                MethodsOfConsume method1 = new DeductOrderMoney();
                cutPoints = method1.consume(id);
                message = cutPoints + "," + "消费的物品";
                break;
            //兑换优惠券
            case "RedeemCoupons":
                MethodsOfConsume method2 = new RedeemCoupons();
                cutPoints = method2.consume(id);
                message = cutPoints + "," +"优惠券";
                break;
            //积分换购
            case "PointsRedemption":
                MethodsOfConsume method3 = new PointsRedemption();
                cutPoints = method3.consume(id, goodsId);
                message = cutPoints + "," + "换购的物品";
                break;
            //参加活动
            case "JoinActivities":
                MethodsOfConsume method4 = new JoinActivities();
                cutPoints = method4.consume(id);
                message = cutPoints + "," + "参加的活动";
                break;
        }

        return message;
    }
}