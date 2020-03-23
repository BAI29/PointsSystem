package service.method.earn;

/*
 * 通过每日签到来赚取积分，每次赚取2积分，有效期为2年 */

import dao.UserDao;
import entity.User;
import service.MethodsOfEarn;

public class CheckIn implements MethodsOfEarn {

    private UserDao userDao;
    double addPoints = 2;
    //通过每日签到来赚取积分
    public double earn(int id) {
        //根据传来的id调出增加积分的用户账户
        User user = userDao.query(id);
        //调出该用户原来所有的积分加2
        double points = user.getPoints() + addPoints;
        user.setPoints(points);
        //加完后更新数据库
        userDao.update(user);

        return addPoints;
    }


    @Override
    public double earn(int id, double money) {
        return 0;
    }
}
