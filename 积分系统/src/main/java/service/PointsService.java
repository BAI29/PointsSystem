package service;
/*
* 所有积分系统提供的服务*/

import dao.UserDao;
import entity.ConsumePointsRecord;
import entity.EarnPointsRecord;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PointsService {
    private EarnPoints earnPoints;
    private ConsumePoints consumePoints;
    private UserDao userDao;
    private PointsRecord pointsRecord;
    private EarnPointsRecord earnPointsRecord;
    private ConsumePointsRecord consumePointsRecord;

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //赚取积分
    public void earnPoints(String type, int id, double money){
        String message = earnPoints.methodsOfEarn(type, id, money);
        double addPoints = Double.parseDouble(message.split(",")[0]);
        int date = Integer.parseInt(message.split(",")[1]);
        String datetime = formatter.format(date);
        //记录赚取积分
        earnRecord(datetime, type, date, addPoints);
    }

    //消费积分
    public void consumePoints(String type, int id, int goodsId){
        String message = consumePoints.methodsOfEarn(type, id, goodsId);
        double cutPoints = Double.parseDouble(message.split(",")[0]);
        String target = message.split(",")[1];
        String datetime = formatter.format(date);
        //记录消费记录
        consumeRecord(datetime, type, target, cutPoints);
    }

    //查询剩余积分
    public double checkPoints(int id){
        return userDao.queryPoints(id);
    }

    //查询赚取积分明细
    public List<EarnPointsRecord> queryEarnPointsRecord() throws SQLException {
        return pointsRecord.queryEarnPointsRecord();
    }

    //查询消费积分明细
    public List<ConsumePointsRecord> queryConsumePointsRecord() throws SQLException {
        return pointsRecord.queryConsumePointsRecord();
    }

    //记录赚取积分
    public void earnRecord(String datetime, String type, int date, double points ){
        earnPointsRecord.setDatetime(datetime);
        earnPointsRecord.setType(type);
        earnPointsRecord.setDate(date);
        earnPointsRecord.setPoints(points);
        pointsRecord.earnRecord(earnPointsRecord);
    }

    //记录消费积分
    public void consumeRecord(String datetime, String type, String target, double points ){
        consumePointsRecord.setDatetime(datetime);
        consumePointsRecord.setType(type);
        consumePointsRecord.setTarget(target);
        consumePointsRecord.setPoints(points);
        pointsRecord.consumeRecord(consumePointsRecord);
    }
}
