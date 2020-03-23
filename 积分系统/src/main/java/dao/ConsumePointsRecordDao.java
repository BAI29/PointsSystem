package dao;

import db.DBConnection;
import entity.ConsumePointsRecord;
import entity.EarnPointsRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumePointsRecordDao {

    //记录新的消费积分记录
    public void insert(ConsumePointsRecord record) {

        String datetime = record.getDateTime();
        String type = record.getType();
        String target = record.getTarget();
        double points = record.getPoints();
        assert datetime != null;
        assert type != null;
        assert target != null;

        Connection conn = null;
        PreparedStatement stat = null;
        conn = DBConnection.getConnection();

        String sql = "insert into consumeRecords (datetime, type, target, points ) values(?,?,?,?)";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1, datetime);
            stat.setString(2, type);
            stat.setString(3, target);
            stat.setDouble(4, points);

            int col = stat.executeUpdate();
            if (col > 0) {
                System.out.println("添加成功：" + col + "条数");
            } else {
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询消费积分的记录
    public List<ConsumePointsRecord> queryConsumePointsRecord() throws SQLException {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        conn = DBConnection.getConnection();

        List<ConsumePointsRecord> list = new ArrayList<ConsumePointsRecord>();

        //查询记录
        String sql = "SELECT * FROM consumeRecords ";
        stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while (rs.next()) {
            for(int i=1;i<=rs.getMetaData().getColumnCount();i++) {
                ConsumePointsRecord record = new ConsumePointsRecord();
                record.setDatetime(rs.getString(i)) ;
                record.setType(rs.getString(++i)) ;
                record.setTarget(rs.getString(++i)); ;
                record.setPoints(rs.getDouble(++i));
                list.add(record);
            }
        }
        return list;
    }
}
