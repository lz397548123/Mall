package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @ClassName: Help
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/10 11:33
 * @Version: 1.0
 */
public class Help extends JFrame {

    private JPanel contentPane;


    public Help() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("帮助");
        setResizable(false);
        setBounds(750, 300, 554, 580);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JTextArea help = new JTextArea();
        help.setText("1,登录，注册：傻瓜式操作，文本框书写如果填写错误\r\n" +
                "	会有提示。\r\n" +
                "\r\n" +
                "2,浏览商品，VIP，员工，购物记录：所生成的表格都为\r\n" +
                "	不可编辑，只有查看作用。\r\n" +
                "\r\n" +
                "3,更新商品：选中一行商品信息，双击会弹出来一个窗\r\n" +
                "	口，在该窗口可进行商品信息更新。\r\n" +
                "\r\n" +
                "4,购买商品与更新商品同等操作。\r\n" +
                "\r\n" +
                "5,购买记录：双击表格中的某行商品信息，会弹出一个\r\n" +
                "	窗口，窗口里有该VIP的购物记录。\r\n" +
                "\r\n" +
                "6,系统备份：点击按钮会弹出文件选择器，选择文件夹\r\n" +
                "	目录，点击保存可将数据库文件信息保存。\r\n" +
                "\r\n" +
                "7,其余都是傻瓜式操作。\r\n" +
                "\r\n" +
                "      本系统界面导入美化jar包，增加视觉享受。\r\n" +
                "         操作流程人性化，简单易上手。");
        help.setFont(new Font("楷体", Font.PLAIN, 19));
        help.setForeground(Color.RED);
        help.setBounds(28, 20, 477, 466);
        help.setOpaque(false);
        help.setEditable(false);
        contentPane.add(help);

        JLabel background = new JLabel("背景");
        background.setIcon(new ImageIcon("images\\myself_background.jpg"));
        background.setBounds(0, 0, 500, 500);
        contentPane.add(background);

        setVisible(true);

    }

}
