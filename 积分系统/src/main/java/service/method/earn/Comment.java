package service.method.earn;

/*
 * 通过评论来赚取积分，每次赚取5积分，有效期为1年 */

import dao.UserDao;
import entity.User;
import service.MethodsOfEarn;

public class Comment implements MethodsOfEarn {

    private UserDao userDao;
    double addPoints = 5;
    //通过评论来赚取积分
    public double earn(int id) {
        //根据传来的id调出增加积分的用户账户
        User user = userDao.query(id);
        //调出该用户原来所有的积分加5
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
