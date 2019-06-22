package controller;

import model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: Service
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/4 22:34
 * @Version: 1.0
 */
public class UserService {
    /**
     * 管理员用户登录
     */
    public boolean checkUser(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from userinfo where user =? and password =?";
            try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
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
     * 管理员用户注册
     */
    public boolean registerUser(User user) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection;
        ResultSet resultSet = null;
        int insertFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from userinfo where user = ?";
        String insertSql = "insert into userinfo (user, password, name, sex, department, post) values(?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setString(1, user.getUser());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该用户已存在" + user.getUser() + "***");
                JOptionPane.showMessageDialog(null,  "注册失败，用户名已存在");
                //用户已被注册
                return false;
            } else {
                System.out.println("该用户不存在" + user.getUser() + "***");
                //向用户表插入数据
                preparedStatement2 = connection.prepareStatement(insertSql);
                preparedStatement2.setString(1, user.getUser());
                preparedStatement2.setString(2, user.getPassword());
                preparedStatement2.setString(3, user.getName());
                preparedStatement2.setString(4, user.getSex());
                preparedStatement2.setString(5, user.getDepartment());
                preparedStatement2.setString(6, user.getPost());
                insertFlag = preparedStatement2.executeUpdate();
                System.out.println("向表中插入数据" + user.getUser() + "****" + insertFlag);

                if(insertFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "注册成功");
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
     * 搜索管理员信息，并且返回User
     */
    public User selectUser(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from userinfo where user = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setUser(resultSet.getString("user"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setDepartment(resultSet.getString("department"));
                user.setPost(resultSet.getString("post"));
                user.setTime(resultSet.getString("time"));
                System.out.println(user);
                return user;
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
        return user;
    }
    /**
     * 修改管理员用户密码
     */
    public boolean change_password(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int changeFlag;
        connection = Dao.getConnection();
        String updatesql = "update userinfo set password = ? where user = ?";
        try {
            //向用户表更新密码;
            preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getUser());
            changeFlag = preparedStatement.executeUpdate();
            System.out.println("更新密码" + user.getPassword() + "****" + changeFlag);
            if(changeFlag == 1) {
                JOptionPane.showMessageDialog(null,  "修改密码成功");
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
