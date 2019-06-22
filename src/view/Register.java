package view;

import controller.UserService;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: Register
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/3 11:10
 * @Version: 1.0
 */
public class Register extends JFrame implements ActionListener {

    private JTextField user_name_text,user_nickname_text;
    private JButton reset,submission;
    private JPasswordField user_password_text;
    private JPasswordField re_user_password_text;
    private JComboBox<String> user_post_box,user_department_box;
    private JRadioButton radioButton_men,radioButton_women;
    private String user_name_check,user_password_check;

    public static void main(String[] args) {

        try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
        new Register();
    }

    /**
     * Create the frame.
     */
    public Register() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("注册窗口");
        setResizable(false);
        setBounds(700, 200, 500, 750);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel user_name = new JLabel("用户名 ：");
        user_name.setFont(new Font("楷体", Font.PLAIN, 17));
        user_name.setBounds(95, 110, 85, 18);
        contentPane.add(user_name);

        user_name_text = new JTextField();
        user_name_text.setBounds(180, 108, 149, 24);
        user_name_text.setColumns(20);
        contentPane.add(user_name_text);

        JLabel user_password = new JLabel("密   码：");
        user_password.setFont(new Font("楷体", Font.PLAIN, 17));
        user_password.setBounds(95, 155, 85, 18);
        contentPane.add(user_password);

        user_password_text = new JPasswordField();
        user_password_text.setBounds(180, 152, 149, 24);
        user_password_text.setColumns(20);
        contentPane.add(user_password_text);

        JLabel res_user_password = new JLabel("确认密码：");
        res_user_password.setFont(new Font("楷体", Font.PLAIN, 17));
        res_user_password.setBounds(95, 190, 85, 34);
        contentPane.add(res_user_password);

        re_user_password_text = new JPasswordField();
        re_user_password_text.setBounds(180, 196, 149, 24);
        re_user_password_text.setColumns(20);
        contentPane.add(re_user_password_text);

        JLabel user_nickname = new JLabel("姓   名：");
        user_nickname.setFont(new Font("楷体", Font.PLAIN, 17));
        user_nickname.setBounds(95, 245, 85, 18);
        contentPane.add(user_nickname);

        user_nickname_text = new JTextField();
        user_nickname_text.setBounds(180, 243, 149, 24);
        contentPane.add(user_nickname_text);
        user_nickname_text.setColumns(20);

        JLabel user_sex = new JLabel("性   别：");
        user_sex.setFont(new Font("楷体", Font.PLAIN, 17));
        user_sex.setBounds(95, 290, 85, 18);
        contentPane.add(user_sex);

        radioButton_men = new JRadioButton("男");
        radioButton_men.setBounds(180, 287, 53, 27);
        radioButton_men.setOpaque(false);
        contentPane.add(radioButton_men);

        radioButton_women = new JRadioButton("女");
        radioButton_women.setBounds(263, 287, 53, 27);
        radioButton_women.setOpaque(false);
        contentPane.add(radioButton_women);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton_men);
        buttonGroup.add(radioButton_women);
        radioButton_men.setSelected(true);

        JLabel user_department = new JLabel("部   门：");
        user_department.setFont(new Font("楷体", Font.PLAIN, 17));
        user_department.setBounds(95, 335, 85, 18);
        contentPane.add(user_department);

        String[] str1 = {"人事部","秘书处","市场部","销售部","服务部","进货部"};
        user_department_box = new JComboBox<>(str1);
        user_department_box.setBackground(Color.WHITE);
        user_department_box.setBounds(180, 330, 149, 24);
        contentPane.add(user_department_box);

        JLabel user_post = new JLabel("职   务：");
        user_post.setFont(new Font("楷体", Font.PLAIN, 17));
        user_post.setBounds(95, 373, 85, 18);
        contentPane.add(user_post);

        String[] str2 = {"干事","经理","董事长","董事"};
        user_post_box = new JComboBox<>(str2);
        user_post_box.setBounds(180, 367, 149, 24);
        contentPane.add(user_post_box);

        submission = new JButton("确定");
        submission.setBounds(125, 432, 73, 27);
        submission.addActionListener(this);
        contentPane.add(submission);

        reset = new JButton("重置");
        reset.setBounds(231, 432, 73, 27);
        reset.addActionListener(this);
        contentPane.add(reset);

        JLabel background = new JLabel("背景");
        background.setIcon(new ImageIcon("images\\register_background.jpg"));
        background.setBounds(0, 0, 500, 750);
        contentPane.add(background);

        //正则表达式5-20个字符
        user_name_check = "^.{5,20}$";
        user_password_check = "^.{5,20}$";

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset) {
            user_name_text.setText("");
            user_nickname_text.setText("");
            user_password_text.setText("");
            re_user_password_text.setText("");
        }

        if(e.getSource() == submission) {
            System.out.println(111);

            String user_id = user_name_text.getText().trim();
            String password = new String(user_password_text.getPassword()).trim();
            String re_password = new String(re_user_password_text.getPassword()).trim();
            String nickname = user_nickname_text.getText().trim();
            String sex;
            if(radioButton_men.isSelected()) {
                sex = radioButton_men.getText().trim();
            } else {
                sex = radioButton_women.getText().trim();
            }
            String department = (String) user_department_box.getSelectedItem();
            String post = (String) user_post_box.getSelectedItem();

            if("".equals(user_id) || "".equals(password) || "".equals(re_password) || "".equals(nickname)) {
                JOptionPane.showMessageDialog(null, "文本框不能为空，请重新输入");
                return;
            }

            if(!user_id.matches(user_name_check)) {
                JOptionPane.showMessageDialog(null, "用户名请输入5-20个字符！");
                user_name_text.setText("");
                return;
            }

            if(!password.matches(user_password_check)) {
                JOptionPane.showMessageDialog(null, "密码请输入5-20个字符！");
                user_password_text.setText("");
                return;
            }

            if(!password.equals(re_password)) {
                System.out.println(password);
                System.out.println(re_password);
                JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入");
                user_password_text.setText("");
                re_user_password_text.setText("");
                return;
            }

            System.out.println("user_id:"+user_id);
            System.out.println("password:"+password);
            System.out.println("re_password:"+re_password);
            System.out.println("nickname:"+nickname);
            System.out.println("sex:"+sex);
            System.out.println("department:"+department);
            System.out.println("post:"+post);

            User user = new User();
            user.setUser(user_id);
            user.setPassword(password);
            user.setName(nickname);
            user.setSex(sex);
            user.setDepartment(department);
            user.setPost(post);

            if(new UserService().registerUser(user)) {
                dispose();
            }

        }

    }
}
