package view;

import controller.VIPService;
import model.VIP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: VIPPurchase
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/9 4:03
 * @Version: 1.0
 */
public class VIPPurchase extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField vip_user_text;
    private JTextField vip_name_text;
    private JTextField vip_sex_text;
    private JTextField vip_discount_text;
    private JTextField vip_commodity_text;
    private JTextField vip_number_text;
    private JButton commit, gain_out;
    private String user, name,sex, discount;

    public VIPPurchase(String user,String name, String sex, String discount) {
        this.user = user;
        this.name = name;
        this.sex = sex;
        this.discount = discount;
        init();
    }

    /**
     * Create the frame.
     */
    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("购买商品");
        setResizable(false);
        setBounds(700, 350, 500, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel label = new JLabel("VIP用户购买商品");
        label.setForeground(Color.RED);
        label.setFont(new Font("楷体", Font.PLAIN, 21));
        label.setBounds(161, 46, 160, 25);
        contentPane.add(label);

        JLabel vip_user = new JLabel("账号：");
        vip_user.setForeground(Color.RED);
        vip_user.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_user.setBounds(106, 90, 51, 18);
        contentPane.add(vip_user);

        vip_user_text = new JTextField(user);
        vip_user_text.setBounds(161, 88, 181, 24);
        vip_user_text.setEnabled(false);
        vip_user_text.setEditable(false);
        contentPane.add(vip_user_text);
        vip_user_text.setColumns(20);

        JLabel vip_name = new JLabel("姓名：");
        vip_name.setForeground(Color.RED);
        vip_name.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_name.setBounds(106, 125, 51, 18);
        contentPane.add(vip_name);

        vip_name_text = new JTextField(name);
        vip_name_text.setBounds(161, 123, 181, 24);
        vip_name_text.setEnabled(false);
        vip_name_text.setEditable(false);
        contentPane.add(vip_name_text);
        vip_name_text.setColumns(20);

        JLabel vip_sex = new JLabel("性别：");
        vip_sex.setForeground(Color.RED);
        vip_sex.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_sex.setBounds(106, 160, 51, 18);
        contentPane.add(vip_sex);

        vip_sex_text = new JTextField(sex);
        vip_sex_text.setBounds(161, 158, 181, 24);
        vip_sex_text.setEnabled(false);
        vip_sex_text.setEditable(false);
        contentPane.add(vip_sex_text);
        vip_sex_text.setColumns(20);

        JLabel vip_discount = new JLabel("折扣：");
        vip_discount.setForeground(Color.RED);
        vip_discount.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_discount.setBounds(106, 195, 51, 18);
        contentPane.add(vip_discount);

        vip_discount_text = new JTextField(discount);
        vip_discount_text.setBounds(161, 193, 181, 24);
        vip_discount_text.setEnabled(false);
        vip_discount_text.setEditable(false);
        contentPane.add(vip_discount_text);
        vip_discount_text.setColumns(20);

        JLabel vip_commodity = new JLabel("商品：");
        vip_commodity.setForeground(Color.RED);
        vip_commodity.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_commodity.setBounds(106, 230, 51, 18);
        contentPane.add(vip_commodity);

        vip_commodity_text = new JTextField();
        vip_commodity_text.setBounds(161, 228, 181, 24);
        contentPane.add(vip_commodity_text);
        vip_commodity_text.setColumns(20);

        JLabel vip_number = new JLabel("数量:");
        vip_number.setForeground(Color.RED);
        vip_number.setFont(new Font("楷体", Font.PLAIN, 17));
        vip_number.setBounds(106, 270, 51, 18);
        contentPane.add(vip_number);

        vip_number_text = new JTextField();
        vip_number_text.setBounds(161, 268, 181, 24);
        contentPane.add(vip_number_text);
        vip_number_text.setColumns(20);

        commit = new JButton("确定");
        commit.setBounds(140, 320, 78, 27);
        commit.addActionListener(this);
        contentPane.add(commit);

        gain_out = new JButton("取消");
        gain_out.setBounds(240, 320, 78, 27);
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
            String user = vip_user_text.getText().trim();
            String name = vip_name_text.getText().trim();
            String sex = vip_sex_text.getText().trim();
            String discount = vip_discount_text.getText().trim();
            String commodity = vip_commodity_text.getText().trim();
            String number = vip_number_text.getText().trim();
            String check1 = "^[0-9]*[1-9][0-9]*$";

            if("".equals(commodity) || "".equals(number)) {
                JOptionPane.showMessageDialog(null,  "商品，数量都不能为空");
                return;
            }
            if(!number.matches(check1)) {
                JOptionPane.showMessageDialog(null,  "数量必须正整数");
                vip_number_text.setText("");
                return;
            }


            VIP vip = new VIP();
            vip.setUser(user);
            vip.setName(name);
            vip.setSex(sex);
            vip.setDiscount(Double.parseDouble(discount));
            vip.setCommodity(commodity);
            vip.setNumber(Integer.parseInt(number));

            if (new VIPService().purchase(vip)) {
                dispose();
            } else {
                vip_commodity_text.setText("");
                vip_number_text.setText("");
            }
        }
    }
}
