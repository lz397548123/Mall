package controller;

import model.Sale;
import model.VIP;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: SaleService
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 23:00
 * @Version: 1.0
 */
public class SaleService {

    /**
     * 单日查询//单月查询//年份查询
     */
    public Sale browseSale(Sale sale) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from saleinfo where time like ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sale.getTime()+"%");
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] saleInfo = new Object[count][6];
            count = 0;
            while(resultSet.next()){
                saleInfo[count][0] = resultSet.getInt("id");
                saleInfo[count][1] = resultSet.getString("commodity");
                saleInfo[count][2] = resultSet.getInt("number");
                saleInfo[count][3] = resultSet.getDouble("price");
                saleInfo[count][4] = resultSet.getDouble("price_all");
                saleInfo[count][5] = resultSet.getString("time");
                count++;
            }
            sale.setSaleInfo(saleInfo);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return sale;
    }
    /**
     * 浏览全部
     */
    public Sale browseSaleAll(Sale sale) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from saleinfo";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] saleInfo = new Object[count][6];
            count = 0;
            while(resultSet.next()){
                saleInfo[count][0] = resultSet.getInt("id");
                saleInfo[count][1] = resultSet.getString("commodity");
                saleInfo[count][2] = resultSet.getInt("number");
                saleInfo[count][3] = resultSet.getDouble("price");
                saleInfo[count][4] = resultSet.getDouble("price_all");
                saleInfo[count][5] = resultSet.getString("time");
                count++;
            }
            sale.setSaleInfo(saleInfo);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return sale;
    }
    /**
     * 总额查询
     */
    public Sale QueryPriceAll(Sale sale) {
        int count = 0;
        double priceAll = 0;
        double price = 0;
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select *from saleinfo where commodity = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sale.getCommodity());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                System.out.println(111);
                count = resultSet.getInt("number");
                priceAll = resultSet.getDouble("price_all");
                price = resultSet.getDouble("price");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("number"));
                    System.out.println(resultSet.getDouble("price_all"));
                    System.out.println(resultSet.getDouble("price"));
                    count += resultSet.getInt("number");
                    priceAll += resultSet.getDouble("price_all");
                    price = resultSet.getDouble("price");
                }
                sale.setPrice(price);
                sale.setNumber(count);
                sale.setPriceAll(priceAll);
                System.out.println(count);
                System.out.println(priceAll);
                return sale;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return sale;
    }
}
