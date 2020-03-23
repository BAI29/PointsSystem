package dao;

import db.DBConnection;
import entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDao {

    //根据id查找物品
    public Goods query(int id) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        Goods goods = new Goods();

        conn = DBConnection.getConnection();
        double price = 0;
        int number = 0;
        boolean status = false;

        String sql = "SELECT * FROM goods WHERE id = ?";
        try {
            stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()) {
                goods.setPrice(rs.getDouble("price"));
                goods.setNumber(rs.getInt("number"));
                goods.setStatus(rs.getBoolean("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

    //更新换购物品的数量
    public void updateNumber(Goods goods) {

        int id = goods.getId();
        int number = goods.getNumber();

        Connection conn = null;
        PreparedStatement stat = null;

        conn = DBConnection.getConnection();

        String sql = "UPDATE goods SET number = ? WHERE id = ? ";
        try {
            stat = conn.prepareStatement(sql);
            stat.setDouble(1, number);
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

    //更新换购物品的状态
    public void updateStatus(Goods goods) {

        int id = goods.getId();
        boolean status = goods.getStatus();

        Connection conn = null;
        PreparedStatement stat = null;

        conn = DBConnection.getConnection();

        String sql = "UPDATE goods SET status = ? WHERE id = ? ";
        try {
            stat = conn.prepareStatement(sql);
            stat.setBoolean(1, status);
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



}

