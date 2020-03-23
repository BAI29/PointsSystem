package service.method.earn;

/*
* 通过下订单来赚取积分，消费金额的5%为该单赚取积分，有效期为1年*/

import dao.UserDao;
import entity.User;
import service.MethodsOfEarn;

public class PlaceAnOrder implements MethodsOfEarn {

    private UserDao userDao;


    //通过下订单来增加积分
    public double earn(int id, double money){

        double addPoints = 0;
        //根据传来的id调出增加积分的用户账户
        User user = userDao.query(id);
        //增加积分为金额的5%
        addPoints = money * 0.05;
        //调出该用户原来所有的积分相加
        double points = user.getPoints() + addPoints;
        user.setPoints(points);
        //加完后更新数据库
        userDao.update(user);

        return addPoints;
    }

    @Override
    public double earn(int id) {
        return 0;
    }
}
