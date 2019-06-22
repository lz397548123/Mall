package controller;

import model.Worker;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: WorkerService
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 0:26
 * @Version: 1.0
 */
public class WorkerService {

    /**
     * 浏览员工用户(表格)
     */
    public Worker browseWorker(Worker worker) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from workerInfo";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            resultSet = preparedStatement.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] workerInfo = new Object[count][11];
            count = 0;
            while(resultSet.next()){
                workerInfo[count][0] = resultSet.getInt("id");
                workerInfo[count][1] = resultSet.getString("name");
                workerInfo[count][2] = resultSet.getString("sex");
                workerInfo[count][3] = resultSet.getInt("age");
                workerInfo[count][4] = resultSet.getString("department");
                workerInfo[count][5] = resultSet.getString("post");
                workerInfo[count][6] = resultSet.getString("telephone");
                workerInfo[count][7] = resultSet.getDouble("month_pay");
                workerInfo[count][8] = resultSet.getString("address");
                workerInfo[count][9] = resultSet.getString("status");
                workerInfo[count][10] = resultSet.getString("time");
                count++;
            }
            worker.setWorkerInfo(workerInfo);
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
        return worker;
    }

    /**
     * 注册员工
     */
    public boolean addWorker(Worker worker) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection;
        ResultSet resultSet = null;
        int insertFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from workerInfo where id = ?";
        String insertSql = "insert into workerInfo (id, name, sex, age, department, post, " +
                "telephone, month_pay, address, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setInt(1, worker.getId());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该员工用户已存在" + worker.getId() + "***");
                JOptionPane.showMessageDialog(null,  "员工已存在，注册失败");
                //员工已被添加
                return false;
            } else {
                System.out.println("该员工用户不存在" + worker.getId() + "***");
                //向员工表插入数据
                preparedStatement2 = connection.prepareStatement(insertSql);
                preparedStatement2.setInt(1, worker.getId());
                preparedStatement2.setString(2, worker.getName());
                preparedStatement2.setString(3, worker.getSex());
                preparedStatement2.setInt(4, worker.getAge());
                preparedStatement2.setString(5, worker.getDepartment());
                preparedStatement2.setString(6, worker.getPost());
                preparedStatement2.setString(7, worker.getTelephone());
                preparedStatement2.setDouble(8,worker.getMonth_pay());
                preparedStatement2.setString(9,worker.getAddress());
                preparedStatement2.setString(10,worker.getStatus());
                insertFlag = preparedStatement2.executeUpdate();
                System.out.println("向员工表中插入数据" + worker.getId() +"****" + insertFlag);
                if(insertFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "员工注册成功");
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
     * 查询员工信息
     */
    public Worker selectWorker(Worker worker) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        ResultSet resultSet = null;
        connection = Dao.getConnection();
        String sql = "select * from workerinfo where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, worker.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                worker.setId(resultSet.getInt("id"));
                worker.setName(resultSet.getString("name"));
                worker.setSex(resultSet.getString("sex"));
                worker.setAge(resultSet.getInt("age"));
                worker.setDepartment(resultSet.getString("department"));
                worker.setPost(resultSet.getString("post"));
                worker.setTelephone(resultSet.getString("telephone"));
                worker.setMonth_pay(resultSet.getDouble("month_pay"));
                worker.setAddress(resultSet.getString("address"));
                worker.setStatus(resultSet.getString("status"));
                worker.setTime(resultSet.getString("time"));
                System.out.println(worker);
                return worker;
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
        return worker;
    }

    /**
     * 修改员工信息
     */
    public boolean changeWorker(Worker worker) {
        PreparedStatement preparedStatement = null;
        Connection connection;
        int changeFlag;
        connection = Dao.getConnection();
        String updatesql = "update workerInfo set name = ? , sex = ? , age = ? , department = ? ," +
                " post = ? , telephone = ? , month_pay = ?, address = ?, status = ?  where id = ?";
        try {
            //向VIP用户表表更新用户信息;
            preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setString(2, worker.getSex());
            preparedStatement.setInt(3, worker.getAge());
            preparedStatement.setString(4, worker.getDepartment());
            preparedStatement.setString(5, worker.getPost());
            preparedStatement.setString(6, worker.getTelephone());
            preparedStatement.setDouble(7, worker.getMonth_pay());
            preparedStatement.setString(8, worker.getAddress());
            preparedStatement.setString(9, worker.getStatus());
            preparedStatement.setInt(10, worker.getId());
            changeFlag = preparedStatement.executeUpdate();
            if(changeFlag == 1) {
                JOptionPane.showMessageDialog(null,  "修改员工信息成功");
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
     * 注销员工
     */
    public boolean logoutWorker(Worker worker) {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection;
        ResultSet resultSet =null;
        int changeFlag;
        connection = Dao.getConnection();
        String checkSql = "select *from workerInfo where id = ?";
        String deletesql = "delete from workerInfo where id = ?";
        try {
            //员工表删除用户信息;
            preparedStatement1 = connection.prepareStatement(checkSql);
            preparedStatement1.setInt(1,worker.getId());
            resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()) {
                System.out.println("该员工存在" + worker.getId() + "***");
                //删除员工用户
                preparedStatement2 = connection.prepareStatement(deletesql);
                preparedStatement2.setInt(1, worker.getId());
                changeFlag = preparedStatement2.executeUpdate();
                if(changeFlag == 1) {
                    JOptionPane.showMessageDialog(null,  "注销员工成功");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null,  "注销员工失败");
                }
            } else {
                JOptionPane.showMessageDialog(null,  "不存在该员工，注销失败");
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
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

