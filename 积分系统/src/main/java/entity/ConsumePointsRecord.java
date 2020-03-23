package entity;

public class ConsumePointsRecord {

    private int id;//自增加1
    private String datetime;
    private String type;//消费积分类型：抵扣订单金额、兑换优惠券、积分换购、参加活动
    private String target;//消费的对象
    private double points;//消费的积分数


    public int getId(){
        return id;
    }
    public String getDateTime(){
        return datetime;
    }
    public String getType(){
        return type;
    }
    public String getTarget(){
        return target;
    }
    public double  getPoints(){
        return points;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
