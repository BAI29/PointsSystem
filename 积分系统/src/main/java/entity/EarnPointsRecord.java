package entity;

public class EarnPointsRecord {

    private int id;//自增加1
    private String datetime;
    private String type;//赚取积分类型：下订单、每日签到、评论
    private int date;//有效期：如有效期为两年，则为2
    private double points;//增加的积分数


    public int getId(){
        return id;
    }
    public String getDateTime(){
        return datetime;
    }
    public String getType(){
        return type;
    }
    public int getDate(){
        return date;
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

    public void setDate(int date) {
        this.date = date;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
