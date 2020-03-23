package dao;

import entity.EarnPointsRecord;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EarnPointsRecordDao {

    //记录新的赚取积分记录
    public void insert(EarnPointsRecord record) {

        String datetime = record.getDateTime();
        String type = record.getType();
        int date = record.getDate();
        double points = record.getPoints();
        assert datetime != null;
        assert type != null;

        Connection conn = null;
        PreparedStatement stat = null;
        conn = DBConnection.getConnection();

        String sql = "insert into earnRecords (datetime, type, date, points ) values(?,?,?,?)";
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1, datetime);
            stat.setString(2, type);
            stat.setInt(3, date);
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

    //查询赚取积分的记录
    public List<EarnPointsRecord> queryEarnPointsRecord() throws SQLException {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        conn = DBConnection.getConnection();

        List<EarnPointsRecord> list = new ArrayList<EarnPointsRecord>();

        //查询记录
        String sql = "SELECT * FROM earnRecords ";
        stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while (rs.next()) {
            for(int i=1;i<=rs.getMetaData().getColumnCount();i++) {
                EarnPointsRecord record = new EarnPointsRecord();
                record.setDatetime(rs.getString(i)) ;
                record.setType(rs.getString(++i)) ;
                record.setDate(rs.getInt(++i)); ;
                record.setPoints(rs.getDouble(++i));
                list.add(record);
            }
        }
        return list;
    }
}
