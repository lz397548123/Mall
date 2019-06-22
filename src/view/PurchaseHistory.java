package view;

import controller.VIPService;
import model.VIP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @ClassName: PurchaseHistory
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/9 6:08
 * @Version: 1.0
 */
public class PurchaseHistory extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel background;
    private String vip_user;

    public PurchaseHistory(String vip_user) {
        this.vip_user = vip_user;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(vip_user+"用户的购物记录");
        setResizable(false);
        setBounds(650, 300, 900, 580);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblVip = new JLabel("购物记录");
        lblVip.setForeground(Color.RED);
        lblVip.setFont(new Font("楷体", Font.PLAIN, 21));
        lblVip.setBounds(743, 31, 91, 101);
        contentPane.add(lblVip);

        VIP vip = new VIP();
        vip.setUser(vip_user);
        vip = new VIPService().browseVIPPur(vip);

        String[] vip_title = {"编号","账号","姓名","性别","折扣","商品","数量","售价","总价","时间"};
        table = new JTable(vip.getVIPInfo(), vip_title);
        table.setBounds(0, 0, 726, 524);
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setSize(726,524);
        contentPane.add(jScrollPane);

        background = new JLabel("背景");
        background.setBounds(0, 0, 869, 537);
        background.setIcon(new ImageIcon("images\\table_background.jpg"));
        contentPane.add(background);

        setVisible(true);
    }
}
