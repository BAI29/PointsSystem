package service.method.consume;

/*
 * 可以用积分来兑换优惠券
 * 兑换一张满300减10的优惠券，需要300积分
 * */

import dao.UserDao;
import entity.User;
import service.MethodsOfConsume;

public class RedeemCoupons implements MethodsOfConsume {

    private UserDao userDao;

    //用积分兑换优惠券
    public double consume (int id ){
        double cutPoints = 300;
        //根据传来的id调出消费积分的用户账户
        User user = userDao.query(id);
        //原来所有的积分
        double originPoints = user.getPoints();
        //先判断积分是否大于300，可以兑换一张优惠券
        if(originPoints > cutPoints){
            //若大于则在原有积分上减去300积分
            double points = originPoints - cutPoints;
            user.setPoints(points);
            //减完后更新数据库
            userDao.update(user);
        }else{
            //若小于则报错，并提示积分余额不足
            System.out.println("ERROR!!!");
        }
        //返回消费的积分数
        return cutPoints;
    }

    @Override
    public double consume(int id, int goodsId) {
        return 0;
    }

}
