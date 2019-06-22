package controller;

import model.Commodity;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: CommodityService
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 0:25
 * @Version: 1.0
 */
public class CommodityService {

    /**
     * 浏览商品(表格)
     */
    public Commodity browseCommodity(Commodity com) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from commodityinfo";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] comInfo = new Object[count][10];
            count = 0;
            while(resultSet.next()){
                comInfo[count][0] = resultSet.getInt("id");
                comInfo[count][1] = resultSet.getString("commodity");
                comInfo[count][2] = resultSet.getString("manufacturer");
                comInfo[count][3] = resultSet.getString("category");
                comInfo[count][4] = resultSet.getDouble("purchase_price");
                comInfo[count][5] = resultSet.getInt("number");
                comInfo[count][6] = resultSet.getDouble("price");
                comInfo[count][7] = resultSet.getDouble("purchase_price_all");
                comInfo[count][8] = resultSet.getString("time");
                count++;
            }
            com.setComInfo(comInfo);
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
        return com;
    }
    /**
     * 查询商品信息
     */
    public Commodity selectCommodity(Commodity com) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from commodityinfo where commodity = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, com.getCommodity());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                com.setID(resultSet.getInt("id"));
                com.setManufacturer(resultSet.getString("manufacturer"));
                com.setCategory(resultSet.getString("category"));
                com.setPurchase_price(resultSet.getDouble("purchase_price"));
                com.setNumber(resultSet.getInt("number"));
                com.setPrice(resultSet.getDouble("price"));
                com.setPurchase_price_all(resultSet.getDouble("purchase_price_all"));
                com.setTime(resultSet.getString("time"));
                System.out.println(com);
                return com;
            }
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
        return com;
    }
    /**
     * 检查商品
     */
    public boolean CheckCommodity(Commodity com) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from commodityinfo where commodity = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, com.getCommodity());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
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
        return false;
    }
    /**
     * 新进商品
     */
    public boolean newPurchase(Commodity com) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String name = com.getCommodity();
        int num1 = com.getNumber();
        String sql = "select * from commodityinfo where commodity = ?";
        String updateSql = "update commodityinfo set number = ? , purchase_price_all = ? where commodity = ?";
        try {
            preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, com.getCommodity());
            resultSet = preparedStatement1.executeQuery();
            if (resultSet.next()) {
                double purchase_price1 = com.setPurchase_price(resultSet.getDouble("purchase_price"));
                int num2 = com.setNumber(resultSet.getInt("number"));
                int num = num1 + num2;
                double price_all = num * purchase_price1;

                preparedStatement2 = connection.prepareStatement(updateSql);
                preparedStatement2.setInt(1, num);
                preparedStatement2.setDouble(2, price_all);
                preparedStatement2.setString(3, com.getCommodity());
                preparedStatement2.executeUpdate();
                System.out.println(com);
                JOptionPane.showMessageDialog(null,  "新进商品成功,当前商品数量由"+num2+"增加到"+num);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,  "商品不存在，新进失败");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement1 != null) {
                    preparedStatement1.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 新增商品
     */
    public boolean addCommodity(Commodity com) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection;
        ResultSet resultSet = null;
        int insertFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from commodityinfo where commodity = ?";
        String insertSql = "insert into commodityinfo (commodity, manufacturer, category, purchase_price, " +
                "number, price, purchase_price_all) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setString(1, com.getCommodity());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该商品已存在" + com.getId() + com.getCommodity() + "***");
                JOptionPane.showMessageDialog(null,  "商品已存在，添加失败");
                //商品已被添加
                return false;
            } else {
                System.out.println("该商品不存在" + com.getId() + "***");
                //向商品表插入数据
                preparedStatement2 = connection.prepareStatement(insertSql);
                preparedStatement2.setString(1, com.getCommodity());
                preparedStatement2.setString(2, com.getManufacturer());
                preparedStatement2.setString(3, com.getCategory());
                preparedStatement2.setDouble(4, com.getPurchase_price());
                preparedStatement2.setInt(5, com.getNumber());
                preparedStatement2.setDouble(6, com.getPrice());
                preparedStatement2.setDouble(7, com.getPurchase_price_all());
                insertFlag = preparedStatement2.executeUpdate();
                System.out.println("向商品表中插入数据" + com.getId()+":"+com.getCommodity() + "****" + insertFlag);

                if(insertFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "商品添加成功");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement1 != null) {
                    preparedStatement1.close();
                }
                if(preparedStatement2 != null) {
                    preparedStatement2.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 更新商品
     */
    public boolean changeCommodity(Commodity com) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int changeFlag;
        connection = Dao.getConnection();
        String updatesql = "update commodityinfo set commodity = ? , manufacturer = ? , category = ? ," +
                "purchase_price = ? , number = ? , price = ? , purchase_price_all = ?  where id = ?";
        try {
            //向商品表更新商品信息;
            preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.setString(1, com.getCommodity());
            preparedStatement.setString(2, com.getManufacturer());
            preparedStatement.setString(3, com.getCategory());
            preparedStatement.setDouble(4, com.getPurchase_price());
            preparedStatement.setInt(5, com.getNumber());
            preparedStatement.setDouble(6, com.getPrice());
            preparedStatement.setDouble(7, com.getPurchase_price_all());
            preparedStatement.setInt(8, com.getId());
            changeFlag = preparedStatement.executeUpdate();
            if(changeFlag == 1) {
                JOptionPane.showMessageDialog(null,  "修改商品信息成功");
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
