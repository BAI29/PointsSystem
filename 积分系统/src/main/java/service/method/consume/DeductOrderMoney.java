package service.method.consume;

/*
 * 下单时用积分抵消一部分的金额
 * 积分和金额的换算为：积分*0.01 = 可抵消金额
 * 如：500积分可抵消5元钱
 * 可抵消的积分上限是1000积分，10元钱*/

import dao.UserDao;
import entity.User;
import service.MethodsOfConsume;

public class DeductOrderMoney implements MethodsOfConsume {

    private UserDao userDao;

    //用积分抵消一部分金额
    public double consume (int id ){

        //根据传来的id调出消费积分的用户账户
        User user = userDao.query(id);
        //原来所有的积分
        double originPoints = user.getPoints();
        //可消费的积分
        double cutPoints = 0;
        //先判断是否大于1000积分
        if(originPoints > 1000){
            //大于则最多只能抵消1000积分
            cutPoints = 1000;
        }else{
            //小于则可以抵消全部
            cutPoints = originPoints;
        }
        //调出该用户原有的积分减去消费的
        double points = originPoints - cutPoints;
        user.setPoints(points);
        //减完后更新数据库
        userDao.update(user);

        //可以抵消的金额为：积分* 0.01
        double money = cutPoints * 0.01;
        //返回消费积分数
        return cutPoints;
    }

    @Override
    public double consume(int id, int goodsId) {
        return 0;
    }
}
