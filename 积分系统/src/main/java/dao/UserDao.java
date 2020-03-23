package dao;

import db.DBConnection;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //更新积分余额
    public void update(User user) {

        int id = user.getId();
        double points = user.getPoints();

        Connection conn = null;
        PreparedStatement stat = null;

        conn = DBConnection.getConnection();

        String sql = "UPDATE users SET points = ? WHERE id = ? ";
        try {
            stat = conn.prepareStatement(sql);
            stat.setDouble(1, points);
            stat.setInt(2, id);
            int col=stat.executeUpdate();
            if(col>0) {
                System.out.println("添加成功："+col+"条数");
            }else {
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据id查找用户
    public User query(int id) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = new User();

        conn = DBConnection.getConnection();
        String password = "";
        double points = 0;

        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()) {
                user.setPassword(rs.getString("password"));
                user.setPoints(rs.getDouble("points"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    //根据用户id查找剩余积分
    public double queryPoints(int id) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = new User();

        conn = DBConnection.getConnection();
        double points = 0;

        String sql = "SELECT points FROM users WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()) {
                points =  rs.getDouble("points");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }



}

