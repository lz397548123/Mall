package view;

import controller.VIPService;
import model.VIP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: VIPChange
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/6 10:07
 * @Version: 1.0
 */
public class VIPChange extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField vip_user_text;
    private JTextField vip_password_text;
    private JTextField vip_name_text;
    private JTextField vip_sex_text;
    private JTextField vip_address_text;
    private JTextField vip_discount_text;
    private JTextField vip_telephone_text;
    private JButton change, gain_out;
    private VIP vip;
    private int id;

    public VIPChange(VIP vip) {
        this.vip = vip;
        this.id = vip.getID();
        init();
    }

    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("更改VIP用户");
        setResizable(false);
        setBounds(700, 350, 500, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblvip = new JLabel("更改VIP用户信息");
        lblvip.setForeground(Color.RED);
        lblvip.setFont(new Font("楷体", Font.PLAIN, 21));
        lblvip.setBounds(137, 46, 181, 25);
        contentPane.add(lblvip);

        JLabel vip_user = new JLabel("账号：");
        vip_user.setForeground(Color.RED);
        vip_user.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_user.setBounds(106, 90, 51, 18);
        contentPane.add(vip_user);

        vip_user_text = new JTextField(vip.getUser());
        vip_user_text.setBounds(161, 88, 181, 24);
        contentPane.add(vip_user_text);
        vip_user_text.setColumns(20);

        JLabel vip_password = new JLabel("密码：");
        vip_password.setForeground(Color.RED);
        vip_password.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_password.setBounds(106, 125, 51, 18);
        contentPane.add(vip_password);

        vip_password_text = new JTextField(vip.getPassword());
        vip_password_text.setBounds(161, 123, 181, 24);
        contentPane.add(vip_password_text);
        vip_password_text.setColumns(20);

        JLabel vip_name = new JLabel("姓名：");
        vip_name.setForeground(Color.RED);
        vip_name.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_name.setBounds(106, 160, 51, 18);
        contentPane.add(vip_name);

        vip_name_text = new JTextField(vip.getName());
        vip_name_text.setBounds(161, 158, 181, 24);
        contentPane.add(vip_name_text);
        vip_name_text.setColumns(20);

        JLabel vip_sex = new JLabel("性别:");
        vip_sex.setForeground(Color.RED);
        vip_sex.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_sex.setBounds(106, 195, 51, 18);
        contentPane.add(vip_sex);

        vip_sex_text = new JTextField(vip.getSex());
        vip_sex_text.setBounds(161, 193, 181, 24);
        contentPane.add(vip_sex_text);
        vip_sex_text.setColumns(20);

        JLabel vip_address = new JLabel("住址：");
        vip_address.setForeground(Color.RED);
        vip_address.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_address.setBounds(106, 230, 51, 18);
        contentPane.add(vip_address);

        vip_address_text = new JTextField(vip.getAddress());
        vip_address_text.setBounds(161, 228, 181, 24);
        contentPane.add(vip_address_text);
        vip_address_text.setColumns(20);

        JLabel vip_telephone = new JLabel("电话：");
        vip_telephone.setForeground(Color.RED);
        vip_telephone.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_telephone.setBounds(106, 265, 51, 18);
        contentPane.add(vip_telephone);

        vip_telephone_text = new JTextField(vip.getTelephone());
        vip_telephone_text.setBounds(161, 263, 181, 24);
        contentPane.add(vip_telephone_text);
        vip_telephone_text.setColumns(20);

        JLabel vip_discount = new JLabel("折扣：");
        vip_discount.setForeground(Color.RED);
        vip_discount.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_discount.setBounds(106, 300, 51, 18);
        contentPane.add(vip_discount);

        vip_discount_text = new JTextField(String.valueOf(vip.getDiscount()));
        vip_discount_text.setBounds(161, 298, 181, 24);
        contentPane.add(vip_discount_text);
        vip_discount_text.setColumns(10);

        change = new JButton("修改");
        change.setBounds(137, 352, 78, 27);
        change.addActionListener(this);
        contentPane.add(change);

        gain_out = new JButton("取消");
        gain_out.setBounds(242, 352, 78, 27);
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
        if (e.getSource() == change) {
            String user = vip_user_text.getText().trim();
            String password = vip_password_text.getText().trim();
            String name = vip_name_text.getText().trim();
            String sex = vip_sex_text.getText().trim();
            String address = vip_address_text.getText().trim();
            String telephone = vip_telephone_text.getText().trim();
            String discount = vip_discount_text.getText().trim();
            //正则表达式5-20个字符
            String vip_user_check = "^.{5,20}$";
            String vip_password_check = "^.{5,20}$";
            String vip_telephone_check = "^[1][3,4,5,7,8][0-9]{9}$";

            if ("".equals(user) || "".equals(password) || "".equals(name) || "".equals(sex)
                    || "".equals(address) || "".equals(telephone) || "".equals(discount)) {
                JOptionPane.showMessageDialog(null, "文本框不能为空，请重新输入");
                return;
            }
            if (!user.matches(vip_user_check)) {
                JOptionPane.showMessageDialog(null, "用户名请输入5-20个字符！");
                vip_user_text.setText("");
                return;
            }
            if (!password.matches(vip_password_check)) {
                JOptionPane.showMessageDialog(null, "密码请输入5-20个字符！");
                vip_password_text.setText("");
                return;
            }
            if (!"男".equals(sex) && !"女".equals(sex)) {
                JOptionPane.showMessageDialog(null, "性别必须为男或女！");
                vip_sex_text.setText("");
                return;
            }
            if (!telephone.matches(vip_telephone_check)) {
                JOptionPane.showMessageDialog(null, "电话输入格式不符合规范！");
                vip_telephone_text.setText("");
                return;
            }
            if (Double.parseDouble(discount) <= 0 || Double.parseDouble(discount) >= 1) {
                JOptionPane.showMessageDialog(null, "折扣请输入0-1的数字（不包括0和1）！");
                vip_discount_text.setText("");
                return;
            }

            double discount1 = Double.parseDouble(discount);
            System.out.println("id:" + id);
            System.out.println("user:" + user);
            System.out.println("password:" + password);
            System.out.println("name:" + name);
            System.out.println("sex:" + sex);
            System.out.println("address:" + address);
            System.out.println("telephone:" + telephone);
            System.out.println("discount1:" + discount1);

            VIP vip = new VIP();
            vip.setID(id);
            vip.setUser(user);
            vip.setPassword(password);
            vip.setName(name);
            vip.setSex(sex);
            vip.setAddress(address);
            vip.setTelephone(telephone);
            vip.setDiscount(discount1);

            if (new VIPService().changeVIP(vip)) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,  "修改VIP信息失败");
            }
        }
    }
}
