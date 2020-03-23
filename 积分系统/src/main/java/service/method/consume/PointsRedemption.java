package service.method.consume;

/*
 * 可以用积分换购物品
 * 换购积分为换购物品价格 * 10
 * 如：牙刷25元，需要的积分 = 25 * 10 = 250*/

import dao.GoodsDao;
import dao.UserDao;
import entity.Goods;
import entity.User;
import service.MethodsOfConsume;

public class PointsRedemption implements MethodsOfConsume {

    private UserDao userDao;
    private GoodsDao goodsDao;

    //用积分换购物品
    public double consume (int id, int goodsId){

        double cutPoints = 0;
        //根据传来的id调出消费积分的用户账户
        User user = userDao.query(id);
        //得到原来所有的积分
        double originPoints = user.getPoints();

        //根据传来的物品id，查找该商品的信息
        Goods goods = goodsDao.query(goodsId);
        //得到该兑换物品的价格
        double price = goods.getPrice();
        double needPoints = price * 10;
        //得到该物品的剩余可兑换数量
        int number = goods.getNumber();
        //得到该物品状态
        boolean status = goods.getStatus();

        //先判断该物品的兑换状态是否为可兑换
        if(status){
            //再判断该商品剩余可兑换数量是否大于1
            if(number >= 1){
                //若大于，则判断用户积分余额是否可以兑换该商品
                if(originPoints > needPoints){
                    //若可以兑换，则减去消费积分
                    cutPoints = needPoints;
                    double points = originPoints - needPoints;
                    user.setPoints(points);
                    //减完后更新数据库
                    userDao.update(user);

                    //兑换成功后，商品数量减1
                    goods.setNumber(number - 1);
                    //减完后更新数据库
                    goodsDao.updateNumber(goods);
                }else{
                    //若不足以兑换，则报错，并提示积分余额不足
                    System.out.println("ERROR!!!");
                }
            }else{
                //不能被兑换，则报错，提示该物品已被兑换完毕，并更改物品兑换信息
                System.out.println("ERROR!!!");
                //更改物品兑换状态为false
                goods.setStatus(false);
                //更新数据库
                goodsDao.updateStatus(goods);
            }
        }else{
            //不能被兑换，则报错，并提示改物品以兑换完毕
            System.out.println("ERROR!!!");
        }


        //返回消费的积分数
        return cutPoints;
    }

    @Override
    public double consume(int id) {
        return 0;
    }

}
