package view;

import controller.UserService;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: Login
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/3 9:33
 * @Version: 1.0
 */
public class Login extends JFrame implements ActionListener{

    private JButton login, register;
    private JTextField text_user;
    private JPasswordField textPassword;

    public static void main(String[] args) {
        try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
        new Login();
    }

    /**
     * Create the frame.
     */
    public Login() {
        //new StyleWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("登录窗口");
        setBounds(600, 300, 580, 359);
        //登录框大小固定，不允许通过拖、拉改变大小
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel user_name = new JLabel("账号：");
        user_name.setBounds(143, 66, 52, 18);
        user_name.setFont(new Font("楷体", Font.PLAIN, 17));
        contentPane.add(user_name);

        text_user = new JTextField();
        text_user.setBounds(197, 63, 170, 24);
        contentPane.add(text_user);
        text_user.setColumns(20);

        JLabel password = new JLabel("密码：");
        password.setBounds(143, 113, 52, 18);
        password.setFont(new Font("楷体", Font.PLAIN, 17));
        contentPane.add(password);

        textPassword = new JPasswordField();
        textPassword.setBounds(197, 110, 170, 24);
        contentPane.add(textPassword);

        login = new JButton("登录");
        login.setBounds(165, 161, 78, 27);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.addActionListener(this);
        contentPane.add(login);

        register = new JButton("注册");
        register.setBounds(304, 161, 78, 27);
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.addActionListener(this);
        contentPane.add(register);

        JLabel me = new JLabel("制作人：梁壮");
        me.setBounds(400, 235, 150, 18);
        me.setFont(new Font("楷体", Font.PLAIN, 17));
        me.setForeground(Color.RED);
        contentPane.add(me);

        JLabel background = new JLabel("背景");
        background.setIcon(new ImageIcon("images\\login_background.jpg"));
        background.setBounds(0, 0, 530, 279);
        contentPane.add(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register) {
            new Register();
        }

        if(e.getSource() == login) {
            String user_id = text_user.getText().trim();
            String password = new String(textPassword.getPassword()).trim();
            if("".equals(user_id)) {
                JOptionPane.showMessageDialog(null, "请输入账号！！");
                return;
            }
            if("".equals(password)) {
                JOptionPane.showMessageDialog(null, "请输入密码！！");
                return;
            }
            User user = new User();
            user.setUser(user_id);
            user.setPassword(password);

            UserService userService = new UserService();

            if (userService.checkUser(user)) {
                dispose();
                JOptionPane.showMessageDialog(null,  "登录成功");
                System.out.println("user_id:"+user_id);
                System.out.println("password:"+password);
                user = userService.selectUser(user);
                new Menu(user, user.getUser(),user.getName());
            } else {
                JOptionPane.showMessageDialog(null,  "用户名或密码错误，请重新输入");
                text_user.setText("");
                textPassword.setText("");
            }
        }
    }
}
