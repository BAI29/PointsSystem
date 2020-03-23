package service.method.consume;

/*
 * 可以消耗积分来参加活动
 * 参加抽奖活动，参加一次抽奖要消耗20积分
 * 抽奖奖品有100积分、50积分 、20积分 、10积分 、5积分和空 */

import dao.UserDao;
import entity.User;
import service.MethodsOfConsume;

import java.util.Random;

public class JoinActivities implements MethodsOfConsume {

    private UserDao userDao;

    //用积分参加抽奖活动
    public double consume(int id) {
        double cutPoints = 20;
        //设置中奖积分数
        double addPoints = 0;

        //根据传来的id调出消费积分的用户账户
        User user = userDao.query(id);
        //原来所有的积分
        double originPoints = user.getPoints();

        //先判断积分是否大于20，可以参加一次抽奖
        if (originPoints > cutPoints) {
            //若大于则减去20积分并开始抽奖
            double points_consume = originPoints - cutPoints;
            user.setPoints(points_consume);
            //减完后更新数据库
            userDao.update(user);

            //设置一个随机数
            int number = new Random().nextInt(10) + 1;
            //判断是否中奖
            switch (number){
                case 1: addPoints = 100;break;
                case 2: addPoints = 50;break;
                case 3: addPoints = 20;break;
                case 4:
                case 5: addPoints = 10;break;
                case 6:
                case 7:addPoints = 5;break;
                case 8:
                case 9:
                case 10:addPoints = 0;break;
            }
            //判断是否中奖
            if(addPoints > 0){
                //若中奖，增加中奖积分数
                double points_earn = originPoints + addPoints;
                user.setPoints(points_earn);
                ///加完后更新数据库
                userDao.update(user);
            }else{
                //若未中奖，则提醒用户
                System.out.println("SORRY!");
            }

        } else {
            //若小于则报错，并提示积分余额不足
            System.out.println("ERROR!!!");
        }
        //返回消费积分数
        return cutPoints;

    }

    @Override
    public double consume(int id, int goodsId) {
        return 0;
    }
}
