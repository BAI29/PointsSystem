package service;

/*
 * 根据不同类型，调动不同的赚取积分的方法*/

import org.xml.sax.helpers.ParserAdapter;
import service.method.earn.CheckIn;
import service.method.earn.Comment;
import service.method.earn.PlaceAnOrder;


public class EarnPoints {

    //根据类型判断是哪一种赚取积分的方式
    public String methodsOfEarn(String type, int id, double money){

        String message = "";
        double addPoints = 0;
        switch (type){
            //下订单
            case "DeductOrderMoney" :
                MethodsOfEarn method1 = new PlaceAnOrder();
                addPoints = method1.earn(id, money);
                message = addPoints + "," + 1;
                break;
            //评论
            case "comment" :
                MethodsOfEarn method2 = new Comment();
                addPoints = method2.earn(id);
                message = addPoints + "," + 1;
                break;
            //每日签到
            case "checkIn" :
                MethodsOfEarn method3 = new CheckIn();
                addPoints = method3.earn(id);
                message = addPoints + "," + 2;
                break;
        }

        return message;
    }
}
