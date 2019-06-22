package view;

import controller.UserService;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: UserUI
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 10:44
 * @Version: 1.0
 */
public class UserUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField user_id_text;
    private JTextField user_name_text;
    private JTextField user_sex_text;
    private JLabel user_department;
    private JTextField user_department_text;
    private JLabel user_post;
    private JTextField user_post_text;
    private JLabel user_time;
    private JTextField user_time_text;
    private JLabel user_password;
    private JPasswordField user_password_text;
    private JLabel re_user_password;
    private JPasswordField re_user_password_text;
    private JButton commit;
    private JButton gain_out;
    private User user;

    public UserUI(User user) {
        this.user = user;
        init();
    }

    public void init() {
        setTitle("管理员个人资料");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(750, 300, 550, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel myself = new JLabel("个人资料");
        myself.setFont(new Font("楷体", Font.PLAIN, 20));
        myself.setForeground(Color.RED);
        myself.setBounds(205, 35, 90, 29);
        contentPane.add(myself);

        JLabel user_id = new JLabel("账号：");
        user_id.setForeground(Color.RED);
        user_id.setFont(new Font("楷体", Font.PLAIN, 17));
        user_id.setBounds(54, 90, 60, 18);
        contentPane.add(user_id);

        user_id_text = new JTextField(user.getUser());
        user_id_text.setEnabled(false);
        user_id_text.setEditable(false);
        user_id_text.setBounds(100, 88, 125, 24);
        contentPane.add(user_id_text);
        user_id_text.setColumns(20);

        JLabel user_name = new JLabel("姓名：");
        user_name.setForeground(Color.RED);
        user_name.setFont(new Font("楷体", Font.PLAIN, 17));
        user_name.setBounds(54, 130, 60, 18);
        contentPane.add(user_name);

        user_name_text = new JTextField(user.getName());
        user_name_text.setEnabled(false);
        user_name_text.setEditable(false);
        user_name_text.setBounds(100, 128, 125, 24);
        contentPane.add(user_name_text);
        user_name_text.setColumns(20);

        JLabel user_sex = new JLabel("性别：");
        user_sex.setForeground(Color.RED);
        user_sex.setFont(new Font("楷体", Font.PLAIN, 17));
        user_sex.setBounds(252, 130, 59, 18);
        contentPane.add(user_sex);

        user_sex_text = new JTextField(user.getSex());
        user_sex_text.setEnabled(false);
        user_sex_text.setEditable(false);
        user_sex_text.setBounds(302, 128, 76, 24);
        contentPane.add(user_sex_text);
        user_sex_text.setColumns(10);

        user_department = new JLabel("部门：");
        user_department.setForeground(Color.RED);
        user_department.setFont(new Font("楷体", Font.PLAIN, 17));
        user_department.setBounds(54, 170, 60, 18);
        contentPane.add(user_department);

        user_department_text = new JTextField(user.getDepartment());
        user_department_text.setEnabled(false);
        user_department_text.setEditable(false);
        user_department_text.setBounds(100, 168, 125, 24);
        contentPane.add(user_department_text);
        user_department_text.setColumns(10);

        user_post = new JLabel("职务：");
        user_post.setForeground(Color.RED);
        user_post.setFont(new Font("楷体", Font.PLAIN, 17));
        user_post.setBounds(252, 170, 60, 18);
        contentPane.add(user_post);

        user_post_text = new JTextField(user.getPost());
        user_post_text.setEnabled(false);
        user_post_text.setEditable(false);
        user_post_text.setBounds(302, 168, 76, 24);
        contentPane.add(user_post_text);
        user_post_text.setColumns(10);

        user_time = new JLabel("注册时间：");
        user_time.setForeground(Color.RED);
        user_time.setFont(new Font("楷体", Font.PLAIN, 17));
        user_time.setBounds(54, 213, 90, 29);
        contentPane.add(user_time);

        user_time_text = new JTextField(user.getTime());
        user_time_text.setEnabled(false);
        user_time_text.setEditable(false);
        user_time_text.setBounds(135, 216, 295, 24);
        contentPane.add(user_time_text);
        user_time_text.setColumns(10);

        user_password = new JLabel("新密码 ：");
        user_password.setForeground(Color.RED);
        user_password.setFont(new Font("楷体", Font.PLAIN, 17));
        user_password.setBounds(85, 272, 86, 18);
        contentPane.add(user_password);

        user_password_text = new JPasswordField();
        user_password_text.setEnabled(true);
        user_password_text.setEditable(true);
        user_password_text.setText("");
        user_password_text.setBounds(162, 270, 216, 24);
        contentPane.add(user_password_text);
        user_password_text.setColumns(20);

        re_user_password = new JLabel("确认密码：");
        re_user_password.setForeground(Color.RED);
        re_user_password.setFont(new Font("楷体", Font.PLAIN, 17));
        re_user_password.setBounds(85, 314, 86, 18);
        contentPane.add(re_user_password);

        re_user_password_text = new JPasswordField();
        re_user_password_text.setBounds(162, 312, 216, 24);
        contentPane.add(re_user_password_text);
        re_user_password_text.setColumns(20);

        commit = new JButton("确定");
        commit.setBounds(126, 363, 80, 27);
        commit.addActionListener(this);
        contentPane.add(commit);

        gain_out = new JButton("退出");
        gain_out.setBounds(265, 363, 80, 27);
        gain_out.addActionListener(this);
        contentPane.add(gain_out);

        JLabel background = new JLabel("背景");
        background.setIcon(new ImageIcon("images\\myself_background.jpg"));
        background.setBounds(0, 0, 500, 500);
        contentPane.add(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gain_out) {
            dispose();
        }
        if (e.getSource() == commit) {
            String password = new String(user_password_text.getPassword()).trim();
            String re_password = new String(re_user_password_text.getPassword()).trim();
            String check = "^.{5,20}$";
            if(!password.matches(check)) {
                JOptionPane.showMessageDialog(null, "密码请输入5-20个字符！");
                user_password_text.setText("");
                return;
            }

            if(!password.equals(re_password)) {
                JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入");
                user_password_text.setText("");
                re_user_password_text.setText("");
                return;
            }
            user.setPassword(password);
            System.out.println(password);
            System.out.println(re_password);
            System.out.println(user.getUser());
            System.out.println(user.getPassword());
            new UserService().change_password(user);
            dispose();
        }
    }
}
