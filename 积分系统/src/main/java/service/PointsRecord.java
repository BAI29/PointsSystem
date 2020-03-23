package service;

/*
* 积分记录
* */

import dao.ConsumePointsRecordDao;
import dao.EarnPointsRecordDao;
import entity.ConsumePointsRecord;
import entity.EarnPointsRecord;

import java.sql.SQLException;
import java.util.List;

public class PointsRecord {

    private EarnPointsRecordDao earnPointsRecordDao;
    private ConsumePointsRecordDao consumePointsRecordDao;

    //记录赚取积分
    public void earnRecord(EarnPointsRecord earnPointsRecord){
        earnPointsRecordDao.insert(earnPointsRecord);
    }

    //查询赚取积分的所有记录
    public List<EarnPointsRecord> queryEarnPointsRecord() throws SQLException {
        return earnPointsRecordDao.queryEarnPointsRecord();
    }

    //记录消费积分
    public void consumeRecord(ConsumePointsRecord consumePointsRecord){
        consumePointsRecordDao.insert(consumePointsRecord);
    }

    //查询消费积分的所有记录
    public List<ConsumePointsRecord> queryConsumePointsRecord() throws SQLException {
        return consumePointsRecordDao.queryConsumePointsRecord();
    }
}
