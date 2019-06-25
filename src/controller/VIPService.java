package controller;

import model.VIP;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: VIPService
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 0:26
 * @Version: 1.0
 */
public class VIPService {

    /**
     * 浏览VIP用户(表格)
     */
    public VIP browseVIP(VIP vip) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from VIPinfo";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] VIPInfo = new Object[count][8];
            count = 0;
            while(resultSet.next()){
                VIPInfo[count][0] = resultSet.getInt("id");
                VIPInfo[count][1] = resultSet.getString("user");
                VIPInfo[count][2] = resultSet.getString("name");
                VIPInfo[count][3] = resultSet.getString("sex");
                VIPInfo[count][4] = resultSet.getString("address");
                VIPInfo[count][5] = resultSet.getString("telephone");
                VIPInfo[count][6] = resultSet.getDouble("discount");
                VIPInfo[count][7] = resultSet.getString("time");
                count++;
            }
            vip.setVIPInfo(VIPInfo);
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
        return vip;
    }

    /**
     * 购物记录
     */
    public VIP browseVIPPur(VIP vip) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from "+ vip.getUser()+"_purchase";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] VIPInfo = new Object[count][10];
            count = 0;
            while(resultSet.next()){
                VIPInfo[count][0] = resultSet.getInt("id");
                VIPInfo[count][1] = resultSet.getString("user");
                VIPInfo[count][2] = resultSet.getString("name");
                VIPInfo[count][3] = resultSet.getString("sex");
                VIPInfo[count][4] = resultSet.getDouble("discount");
                VIPInfo[count][5] = resultSet.getString("commodity");
                VIPInfo[count][6] = resultSet.getInt("number");
                VIPInfo[count][7] = resultSet.getDouble("price");
                VIPInfo[count][8] = resultSet.getDouble("price_all");
                VIPInfo[count][9] = resultSet.getString("time");
                count++;
            }
            vip.setVIPInfo(VIPInfo);
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
        return vip;
    }

    /**
     * 注册VIP用户
     */
    public boolean addVIP(VIP vip) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;
        Connection connection;
        ResultSet resultSet = null;
        int insertFlag;
        int creatFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from VIPinfo where user = ?";
        String insertSql = "insert into VIPinfo (user, password, name, sex, " +
                "address, telephone, discount) values(?, ?, ?, ?, ?, ?, ?)";
        String creatVipPurchasesql = "CREATE TABLE " + vip.getUser() + "_purchase " +
                                    "(id INT NOT NULL AUTO_INCREMENT, user VARCHAR(20) NOT NULL, name VARCHAR(20) NOT NULL," +
                                    " sex VARCHAR(10) NOT NULL, discount DOUBLE(10,2) NOT NULL, commodity VARCHAR(20) NOT NULL," +
                                    " number INT(10) NOT NULL, price DOUBLE(10,4) NOT NULL, price_all DOUBLE(10,4) NOT NULL," +
                                    " time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , PRIMARY KEY (id))";
        try {
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setString(1, vip.getUser());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该VIP用户已存在" + vip.getUser() + vip.getPassword() + "***");
                JOptionPane.showMessageDialog(null,  "VIP用户已存在，注册失败");
                //VIP用户已被添加
                return false;
            } else {
                System.out.println("该VIP用户不存在" + vip.getUser() + vip.getPassword() + "***");
                //向商品表插入数据
                preparedStatement2 = connection.prepareStatement(insertSql);
                preparedStatement2.setString(1, vip.getUser());
                preparedStatement2.setString(2, vip.getPassword());
                preparedStatement2.setString(3, vip.getName());
                preparedStatement2.setString(4, vip.getSex());
                preparedStatement2.setString(5, vip.getAddress());
                preparedStatement2.setString(6, vip.getTelephone());
                preparedStatement2.setDouble(7, vip.getDiscount());
                insertFlag = preparedStatement2.executeUpdate();
                System.out.println("向VIP表中插入数据" + vip.getUser() + vip.getPassword() +"****" + insertFlag);

                preparedStatement3 = connection.prepareStatement(creatVipPurchasesql);
                creatFlag = preparedStatement3.executeUpdate();
                System.out.println("创建表" + vip.getUser() + "*******" + creatFlag);

                if(insertFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "VIP用户注册成功");
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
                if(preparedStatement3 != null) {
                    preparedStatement3.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 查询VIP信息
     */
    public VIP selectVIP(VIP vip) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from VIPinfo where user = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vip.getUser());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                vip.setID(resultSet.getInt("id"));
                vip.setUser(resultSet.getString("user"));
                vip.setPassword(resultSet.getString("password"));
                vip.setName(resultSet.getString("name"));
                vip.setSex(resultSet.getString("sex"));
                vip.setAddress(resultSet.getString("address"));
                vip.setTelephone(resultSet.getString("telephone"));
                vip.setDiscount(resultSet.getDouble("discount"));
                vip.setTime(resultSet.getString("time"));
                System.out.println(vip);
                return vip;
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
        return vip;
    }
    /**
     * 修改VIP用户
     */
    public boolean changeVIP(VIP vip) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        int changeFlag;
        connection = Dao.getConnection();
        String updatesql = "update VIPinfo set user = ? , password = ? , name = ? ," +
                "sex = ? , address = ? , telephone = ? , discount = ?  where id = ?";
        try {
            //向VIP用户表表更新用户信息;
            preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.setString(1, vip.getUser());
            preparedStatement.setString(2, vip.getPassword());
            preparedStatement.setString(3, vip.getName());
            preparedStatement.setString(4, vip.getSex());
            preparedStatement.setString(5, vip.getAddress());
            preparedStatement.setString(6, vip.getTelephone());
            preparedStatement.setDouble(7, vip.getDiscount());
            preparedStatement.setInt(8, vip.getID());
            changeFlag = preparedStatement.executeUpdate();
            if(changeFlag == 1) {
                JOptionPane.showMessageDialog(null,  "修改VIP信息成功");
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
    /**
     * 注销VIP用户
     */
    public boolean logoutVIP(VIP vip) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;
        Connection connection;
        ResultSet resultSet =null;
        int changeFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from VIPinfo where user = ?";
        String deletesql = "delete from VIPinfo where user = ?";
        String deleteTableSql = "Drop TABLE "+vip.getUser()+"_purchase";
        try {
            //VIP表删除用户信息;
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setString(1,vip.getUser());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该VIP用户存在" + vip.getUser() + vip.getPassword() + "***");
                //删除VIP用户信息
                preparedStatement2 = connection.prepareStatement(deletesql);
                preparedStatement2.setString(1, vip.getUser());
                changeFlag = preparedStatement2.executeUpdate();
                if(changeFlag == 1) {
                    preparedStatement3 = connection.prepareStatement(deleteTableSql);
                    preparedStatement3.executeUpdate();
                    JOptionPane.showMessageDialog(null,  "注销VIP用户成功");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null,  "注销VIP用户失败");
                }
            } else {
                JOptionPane.showMessageDialog(null,  "不存在该VIP用户，注销失败");
            }
        }catch (SQLException e) {
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
                if(preparedStatement3 != null) {
                    preparedStatement3.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 购买商品
     */
    public boolean purchase(VIP vip) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;
        PreparedStatement preparedStatement4 = null;
        Connection connection;
        ResultSet resultSet = null;
        int changeFlag;
        int insertFlag;
        int checkflag;
        int num1 = vip.getNumber();
        double discount = vip.getDiscount();
        connection = Dao.getConnection();
        String checkSql = "select *from commodityInfo where commodity = ?";
        String insertsql = "insert into " + vip.getUser() + "_purchase" + "(user, name, sex," +
                " discount, commodity, number, price, price_all) values(?, ?, ?, ?, ?, ?, ?, ?)";
        String updatesql = "update commodityInfo set number = ?, purchase_price_all = ? where commodity = ?";
        String insertsql2 = "insert into saleinfo (commodity, number, price, price_all) values(?, ?, ?, ?)";
        try {
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setString(1, vip.getCommodity());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("商品存在" + vip.getCommodity() + "***");
                double price = resultSet.getDouble("price");
                double purchase_price = resultSet.getDouble("purchase_price");
                int num2 = resultSet.getInt("number");
                int num = num2 - num1;
                double purchase_price_all = purchase_price * num;
                if (num < 0) {
                    JOptionPane.showMessageDialog(null,  "购买商品数量超过了已有数量！！！");
                    return false;
                }
                //向VIP购买记录表插入信息;
                preparedStatement2 = connection.prepareStatement(insertsql);
                preparedStatement2.setString(1, vip.getUser());
                preparedStatement2.setString(2, vip.getName());
                preparedStatement2.setString(3, vip.getSex());
                preparedStatement2.setDouble(4, discount);
                preparedStatement2.setString(5, vip.getCommodity());
                preparedStatement2.setInt(6, num1);
                preparedStatement2.setDouble(7, price);
                preparedStatement2.setDouble(8, price * num1 * discount);
                insertFlag = preparedStatement2.executeUpdate();
                //商品表更新商品数量信息
                preparedStatement3 = connection.prepareStatement(updatesql);
                preparedStatement3.setInt(1, num);
                preparedStatement3.setDouble(2, purchase_price_all);
                preparedStatement3.setString(3, vip.getCommodity());
                changeFlag = preparedStatement3.executeUpdate();
                //销售表插入数据
                preparedStatement4 =connection.prepareStatement(insertsql2);
                preparedStatement4.setString(1,vip.getCommodity());
                preparedStatement4.setInt(2,num1);
                preparedStatement4.setDouble(3,price);
                preparedStatement4.setDouble(4,price * num1 * discount);
                checkflag = preparedStatement4.executeUpdate();

                if (insertFlag == 1 && changeFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "VIP购买记录插入成功，商品表商品数量更新成功！("
                                                    +vip.getCommodity()+"数量由"+num2+"降至"+num+"）");
                    return true;
                } else if (insertFlag != 1) {
                    JOptionPane.showMessageDialog(null,  "VIP购买记录插入失败");
                    return false;
                } else if (changeFlag != 1) {
                    JOptionPane.showMessageDialog(null,  "商品表商品数量更新失败");
                    return false;
                } else if (checkflag != 1) {
                    JOptionPane.showMessageDialog(null,  "销售表插入数据失败");
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null,  "不存在该商品");
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement1 != null) {
                    preparedStatement1.close();
                }
                if(preparedStatement2 != null) {
                    preparedStatement2.close();
                }
                if(preparedStatement3 != null) {
                    preparedStatement3.close();
                }
                if(preparedStatement4 != null) {
                    preparedStatement4.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
