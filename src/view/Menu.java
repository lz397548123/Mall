package view;

import controller.CommodityService;
import controller.SaleService;
import controller.VIPService;
import controller.WorkerService;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Menu
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/3 17:40
 * @Version: 1.0
 */
public class Menu extends JFrame {

    private JPanel contentPane;
    private JTextField user_name_text;
    private JTextField user_nickname_text;
    private JLabel time_label;
    private JButton logoff,exit_system,system_backup,help;
    private JButton myself;
    private JButton JButton_first_1,JButton_first_2,JButton_first_3,JButton_first_4,JButton_first_5;
    private JButton JButton_second_1,JButton_second_2,JButton_second_3,JButton_second_4,JButton_second_5;
    private JButton JButton_thrid_1,JButton_thrid_2,JButton_thrid_3,JButton_thrid_4,JButton_thrid_5;
    private JButton JButton_fourth_1,JButton_fourth_2,JButton_fourth_3,JButton_fourth_4,JButton_fourth_5;
    private JPanel left_1,left_2,left_3,left_4;
    private JPanel right_1,right_2,right_4;
    private JSplitPane splitPane_first,splitPane_second,splitPane_third,splitPane_fourth;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField id_text;
    private JTextField commodity_text;
    private JTextField manufacturer_text;
    private JTextField category_text;
    private JTextField purchase_price_text;
    private JTextField number_text;
    private JTextField price_text;
    private JTextField user_text;
    private JPasswordField password_text;
    private JTextField name_text;
    private JTextField address_text;
    private JTextField telephone_text;
    private JTextField discount_text;
    private JTextField worker_text;
    private JTextField work_name_text;
    private JTextField age_text;
    private JTextField month_pay_text;
    private JTextField status_text;
    private JTextField telephone_textworker;
    private JTextField address_textworker;
    private JTextArea cominfo, VIPInfo, WorkerInfo,SaleInfo;
    private JTable browse;
    private String user_id, user_name;
    private Timer loacl_time;
    private User user;

    public Menu(User user, String user_id, String user_name) {
        this.user = user;
        this.user_id = user_id;
        this.user_name = user_name;
        init();
    }

    public void init() {
        setTitle("商场管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300, 900, 648);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*第一层：工具栏四个*/
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 846, 40);
        toolBar.setFloatable(false);
        contentPane.add(toolBar);

        JButton logoff = new JButton("注销用户");
        logoff.setFont(new Font("宋体", Font.PLAIN, 17));
        logoff.addActionListener(e -> {
            int option= JOptionPane.showConfirmDialog(
                    null, "您要注销此用户? ", "提示 ",JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION){
                dispose();
                new Login();
            }
        });
        toolBar.add(logoff);

        JButton exit_system = new JButton("退出系统");
        exit_system.setFont(new Font("宋体", Font.PLAIN, 17));
        exit_system.addActionListener(e -> {
            int option= JOptionPane.showConfirmDialog(
                    null, "确定退出此系统? ", "提示 ",JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION){
                    System.exit(0);
            }
        });
        toolBar.add(exit_system);

        JButton system_backup = new JButton("系统备份");
        system_backup.setFont(new Font("宋体", Font.PLAIN, 17));
        system_backup.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setMultiSelectionEnabled(false);
        /*使用showOpenDialog()方法，显示出打开选择文件的窗口，当选择了某个文件后，或者关闭此窗口那么都会返回一个
    整型数值，如果返回的是0，代表已经选择了某个文件。如果返回1代表选择了取消按钮或者直接关闭了窗口*/
            int result=fileChooser.showSaveDialog(null);
            //JFileChooser.APPROVE_OPTION是个整型常量，代表0。就是说当返回0的值我们才执行相关操作，否则什么也不做。
            if (result==JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getAbsolutePath()+"\\mall.sql";
                System.out.println(path);
                new SystemBackup(path);
            } else {
                JOptionPane.showMessageDialog(null, "系统备份失败！！");
            }
        });
        toolBar.add(system_backup);

        JButton help = new JButton("帮助");
        help.setFont(new Font("宋体", Font.PLAIN, 17));
        help.addActionListener(e -> new Help());
        toolBar.add(help);

        /*第二层：*/
        JPanel panel = new JPanel();
        panel.setBounds(0, 31, 858, 38);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel user_name = new JLabel("账号：");
        user_name.setFont(new Font("楷体", Font.PLAIN, 17));
        user_name.setForeground(Color.RED);
        user_name.setBounds(0, 13, 51, 18);
        panel.add(user_name);

        user_name_text = new JTextField(this.user_id);
        user_name_text.setEnabled(false);
        user_name_text.setBackground(Color.CYAN);
        user_name_text.setBounds(43, 10, 127, 24);
        panel.add(user_name_text);
        user_name_text.setColumns(10);

        JLabel user_nickname = new JLabel("姓名：");
        user_nickname.setFont(new Font("楷体", Font.PLAIN, 17));
        user_nickname.setForeground(Color.RED);
        user_nickname.setBounds(184, 14, 51, 18);
        panel.add(user_nickname);

        user_nickname_text = new JTextField(this.user_name);
        user_nickname_text.setEnabled(false);
        user_nickname_text.setBackground(Color.CYAN);
        user_nickname_text.setBounds(231, 11, 132, 24);
        panel.add(user_nickname_text);
        user_nickname_text.setColumns(10);

        JButton myself = new JButton("个人详情");
        myself.setBounds(389, 10, 113, 27);
        myself.addActionListener(e -> new UserUI(user));
        panel.add(myself);

        JLabel time = new JLabel("时间：");
        time.setFont(new Font("楷体", Font.PLAIN, 17));
        time.setForeground(Color.RED);
        time.setBounds(524, 14, 51, 18);
        panel.add(time);

        panel.add(this.getTime());

        /*第三层：JTabbedPane：选项卡面板*/
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 72, 858, 541);
        contentPane.add(tabbedPane);

        JPanel panel_first = new JPanel();
        JPanel panel_second = new JPanel();
        JPanel panel_third = new JPanel();
        JPanel panel_fourth = new JPanel();
        panel_first.setLayout(null);
        panel_second.setLayout(null);
        panel_third.setLayout(null);
        panel_fourth.setLayout(null);
        tabbedPane.addTab("商品信息管理模块", null, panel_first, "商品信息管理模块");
        tabbedPane.addTab("VIP信息管理模块", null, panel_second, "VIP信息管理模块");
        tabbedPane.addTab("商场人事管理模块", null, panel_third, "商场人事管理模块");
        tabbedPane.addTab("商场销售管理模块", null, panel_fourth, "商场销售管理模块");
        tabbedPane.setFont(new Font("宋体", Font.PLAIN, 17));

        /*JSplitPane：分割成左右两块，左边是按钮，右边是左边按钮的响应事件*/
        JPanel[] right = new JPanel[4];
        JPanel right_1 = new JPanel();
        JPanel right_2 = new JPanel();
        JPanel right_3 = new JPanel();
        JPanel right_4 = new JPanel();
        right_1.setLayout(null);
        right_2.setLayout(null);
        right_3.setLayout(null);
        right_4.setLayout(null);
        right[0] = right_1;
        right[1] = right_2;
        right[2] = right_3;
        right[3] = right_4;

        /*第一个：商品信息管理模块*/
        JPanel left_1 = new JPanel();
        left_1.setLayout(null);

        JSplitPane splitPane_first = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_1, right_1);
        splitPane_first.setDividerLocation(150);
        splitPane_first.setEnabled(false);
        splitPane_first.setBounds(0, 0, 853, 517);
        splitPane_first.setLeftComponent(left_1);

        JButton JButton_first_1 = new JButton("浏览商品");
        JButton_first_1.setBounds(25, 30, 95, 27);
        JButton_first_1.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("浏览商品");
            Commodity com = new Commodity();
            com = new CommodityService().browseCommodity(com);


            String[] com_title = {"编号","商品","厂商","类别","进价","数量","售价","总进价","进货时间"};
            browse = new JTable(com.getComInfo(),com_title);
            browse.setBounds(0, 0, 690, 500);
            browse.getTableHeader().setReorderingAllowed(false);
            browse.setEnabled(false);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            right_1.add(jScrollPane);
            right_1.updateUI();
        });
        left_1.add(JButton_first_1);

        JButton JButton_first_2 = new JButton("查询商品");
        JButton_first_2.setBounds(25, 90, 95, 27);
        JButton_first_2.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("查询商品");
            JLabel label = new JLabel("请输入您要查询的商品的名称：");
            label.setForeground(Color.RED);
            label.setFont(new Font("楷体", Font.PLAIN, 17));
            label.setBounds(222, 105, 247, 18);
            right_1.add(label);

            JTextField query_text = new JTextField();
            query_text.setBounds(232, 147, 198, 24);
            right_1.add(query_text);
            query_text.setColumns(16);

            cominfo = new JTextArea();
            cominfo.setBounds(167, 240, 353, 204);
            cominfo.setFont(new Font("楷体", Font.PLAIN, 17));
            cominfo.setOpaque(false);
            cominfo.setEditable(false);

            JButton query_button = new JButton("查询");
            query_button.addActionListener(e18 -> {
                cominfo.removeAll();
                String commodity = query_text.getText().trim();
                Commodity com = new Commodity();
                com.setCommodity(commodity);
                com = new CommodityService().selectCommodity(com);
                if (com.getId() == 0 || com.getCommodity() == null || com.getManufacturer() == null ||
                    com.getCategory() == null || com.getPurchase_price() == 0 || com.getPurchase_price_all() == 0 ||
                    com.getTime() == null) {
                    query_text.setText("");
                    cominfo.setText("");
                    JOptionPane.showMessageDialog(null,  "没有该商品信息！！请重新输入");
                } else {
                    String str = "编号: "+com.getId()+"\n"+"商品："+com.getCommodity()+"\n"
                            +"厂商："+com.getManufacturer()+"\n"+"类别："+com.getCategory()+"\n"
                            +"进价："+com.getPurchase_price()+"\n"+"数量："+com.getNumber()+"\n"
                            +"售价："+com.getPrice()+"\n"+"总进价："+com.getPurchase_price_all()+"\n"
                            +"进货时间："+com.getTime();
                    cominfo.setText(str);
                    right_1.add(cominfo);

                    right_1.updateUI();
                }
            });
            query_button.setBounds(300, 195, 80, 27);
            right_1.add(query_button);

            right_1.updateUI();
        });
        left_1.add(JButton_first_2);

        JButton JButton_first_3 = new JButton("新进商品");
        JButton_first_3.setBounds(25, 150, 95, 27);
        JButton_first_3.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("新进商品");
            JLabel commodity_name = new JLabel("新进商品名称：");
            commodity_name.setForeground(Color.RED);
            commodity_name.setFont(new Font("楷体", Font.PLAIN, 17));
            commodity_name.setBounds(134, 111, 119, 18);
            right_1.add(commodity_name);

            JTextField commodity_name_text = new JTextField();
            commodity_name_text.setBounds(257, 109, 162, 24);
            right_1.add(commodity_name_text);
            commodity_name_text.setColumns(16);

            JLabel commodity_number = new JLabel("新进商品数量:");
            commodity_number.setForeground(Color.RED);
            commodity_number.setFont(new Font("楷体", Font.PLAIN, 17));
            commodity_number.setBounds(134, 164, 119, 18);
            right_1.add(commodity_number);

            JTextField commodity_number_text = new JTextField();
            commodity_number_text.setBounds(257, 162, 162, 24);
            right_1.add(commodity_number_text);
            commodity_number_text.setColumns(16);

            JButton commit = new JButton("提交");
            commit.setBounds(190, 221, 80, 27);
            commit.addActionListener(e110 -> {
                String check1 = "^[0-9]*[1-9][0-9]*$";
                String name = commodity_name_text.getText().trim();
                String number = commodity_number_text.getText().trim();

                if ("".equals(name) || "".equals(number)) {
                    JOptionPane.showMessageDialog(null,  "商品名，数量均不能为空！！");
                    return;
                }
                if(!number.matches(check1)) {
                    JOptionPane.showMessageDialog(null,  "数量必须正整数");
                    commodity_number_text.setText("");
                    return;
                }

                Commodity com = new Commodity();
                com.setCommodity(name);
                com.setNumber(Integer.parseInt(number));
                if(new CommodityService().newPurchase(com)) {
                    commodity_name_text.setText("");
                    commodity_number_text.setText("");
                } else {
                    commodity_name_text.setText("");
                    commodity_number_text.setText("");
                }
            });
            right_1.add(commit);

            JButton sign_out = new JButton("取消");
            sign_out.addActionListener(e17 -> {
                right_1.removeAll();
                right_1.updateUI();
            });
            sign_out.setBounds(300, 221, 70, 27);
            right_1.add(sign_out);

            right_1.updateUI();
        });
        left_1.add(JButton_first_3);

        JButton JButton_first_4 = new JButton("新增商品");
        JButton_first_4.setBounds(25, 210, 95, 27);
        JButton_first_4.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("新增商品");
            JLabel label_3 = new JLabel("新增商品信息");
            label_3.setForeground(Color.BLUE);
            label_3.setFont(new Font("楷体", Font.PLAIN, 19));
            label_3.setBounds(263, 80, 141, 29);
            right_1.add(label_3);

            JLabel commodity = new JLabel("商品：");
            commodity.setForeground(Color.RED);
            commodity.setFont(new Font("楷体", Font.PLAIN, 17));
            commodity.setBounds(202, 125, 51, 18);
            right_1.add(commodity);

            commodity_text = new JTextField();
            commodity_text.setBounds(251, 125, 168, 24);
            right_1.add(commodity_text);
            commodity_text.setColumns(10);

            JLabel manufacturer = new JLabel("厂商：");
            manufacturer.setForeground(Color.RED);
            manufacturer.setFont(new Font("楷体", Font.PLAIN, 17));
            manufacturer.setBounds(202, 160, 51, 18);
            right_1.add(manufacturer);

            manufacturer_text = new JTextField();
            manufacturer_text.setBounds(251, 160, 168, 24);
            right_1.add(manufacturer_text);
            manufacturer_text.setColumns(10);

            JLabel category = new JLabel("类别：");
            category.setForeground(Color.RED);
            category.setFont(new Font("楷体", Font.PLAIN, 17));
            category.setBounds(202, 195, 51, 18);
            right_1.add(category);

            category_text = new JTextField();
            category_text.setBounds(251, 195, 168, 24);
            right_1.add(category_text);
            category_text.setColumns(10);

            JLabel purchase_price = new JLabel("进价：");
            purchase_price.setForeground(Color.RED);
            purchase_price.setFont(new Font("楷体", Font.PLAIN, 17));
            purchase_price.setBounds(202, 230, 51, 18);
            right_1.add(purchase_price);

            purchase_price_text = new JTextField();
            purchase_price_text.setBounds(251, 230, 168, 24);
            right_1.add(purchase_price_text);
            purchase_price_text.setColumns(10);

            JLabel number = new JLabel("数量：");
            number.setForeground(Color.RED);
            number.setFont(new Font("楷体", Font.PLAIN, 17));
            number.setBounds(202, 265, 51, 18);
            right_1.add(number);

            number_text = new JTextField();
            number_text.setBounds(251, 265, 168, 24);
            right_1.add(number_text);
            number_text.setColumns(10);

            JLabel price = new JLabel("售价：");
            price.setForeground(Color.RED);
            price.setFont(new Font("楷体", Font.PLAIN, 17));
            price.setBounds(202, 300, 51, 18);
            right_1.add(price);

            price_text = new JTextField();
            price_text.setBounds(251, 300, 168, 24);
            right_1.add(price_text);
            price_text.setColumns(10);

            JButton commit = new JButton("确认新增");
            commit.setBounds(213, 353, 93, 27);
            commit.addActionListener(e19 -> {
                String commodity1 = commodity_text.getText().trim();
                String manufacturer1 = manufacturer_text.getText().trim();
                String category1 = category_text.getText().trim();
                String purchase_price1 = purchase_price_text.getText().trim();
                String number1 = number_text.getText().trim();
                String price1 = price_text.getText().trim();
                String check1 = "^[0-9]*[1-9][0-9]*$";
                String check2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
                if(!purchase_price1.matches(check2)) {
                    JOptionPane.showMessageDialog(null,  "进价必须大于0");
                    purchase_price_text.setText("");
                    return;
                }
                if(!number1.matches(check1)) {
                    JOptionPane.showMessageDialog(null,  "数量必须正整数");
                    number_text.setText("");
                    return;
                }
                if(!price1.matches(check2)) {
                    JOptionPane.showMessageDialog(null,  "售价必须大于0");
                    price_text.setText("");
                    return;
                }
                if("".equals(commodity1) || "".equals(manufacturer1) || "".equals(category1)) {
                    JOptionPane.showMessageDialog(null,  "商品，厂商，类别都不能为空");
                    return;
                }

                Commodity com = new Commodity();
                com.setCommodity(commodity1);
                com.setManufacturer(manufacturer1);
                com.setCategory(category1);
                com.setPurchase_price(Double.parseDouble(purchase_price1));
                com.setNumber(Integer.parseInt(number1));
                com.setPrice(Double.parseDouble(price1));
                com.setPurchase_price_all(com.getPurchase_price()*com.getNumber());
                System.out.println(com.setNumber(Integer.parseInt(number1)));
                System.out.println(com.setPrice(Double.parseDouble(price1)));
                System.out.println(com.setPurchase_price_all(com.getPurchase_price()*com.getNumber()));
                if(new CommodityService().addCommodity(com)) {
                    commodity_text.setText("");manufacturer_text.setText("");category_text.setText("");
                    purchase_price_text.setText("");number_text.setText("");price_text.setText("");
                }
            });
            right_1.add(commit);

            JButton sign_out = new JButton("退出");
            sign_out.setBounds(340, 353, 72, 27);
            sign_out.addActionListener(e16 -> {
                // TODO Auto-generated method stub
                right_1.removeAll();
                right_1.updateUI();
            });
            right_1.add(sign_out);

            right_1.updateUI();
        });
        left_1.add(JButton_first_4);

        JButton JButton_first_5 = new JButton("更新商品");
        JButton_first_5.setBounds(25, 270, 95, 27);
        JButton_first_5.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("更新商品");
            Commodity com = new Commodity();
            com = new CommodityService().browseCommodity(com);

            String[] com_title = {"编号","商品","厂商","类别","进价","数量","售价","总进价","进货时间"};
            browse = new JTable(com.getComInfo(),com_title){
                @Override
                public boolean isCellEditable(int rowIndex, int ColIndex){
                    return false;
                }
            };
            browse.setBounds(0, 0, 690, 500);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            browse.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int count= browse.getSelectedRow();
                        String get1 = browse.getValueAt(count, 0).toString();
                        String get2 = browse.getValueAt(count, 1).toString();
                        String get3 = browse.getValueAt(count, 2).toString();
                        String get4 = browse.getValueAt(count, 3).toString();
                        String get5 = browse.getValueAt(count, 4).toString();
                        String get6 = browse.getValueAt(count, 5).toString();
                        String get7 = browse.getValueAt(count, 6).toString();
                        new CommodityChange(Integer.parseInt(get1), get2, get3, get4, get5, get6, get7);
                    }
                }
            });
            right_1.add(jScrollPane);
            right_1.updateUI();
        });
        left_1.add(JButton_first_5);
        panel_first.add(splitPane_first);

        /*第二个：VIP信息管理模块*/
        JPanel left_2 = new JPanel();
        left_2.setLayout(null);

        JSplitPane splitPane_second = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_2, right_2);
        splitPane_second.setDividerLocation(150);
        splitPane_second.setEnabled(false);
        splitPane_second.setBounds(0, 0, 853, 517);
        splitPane_second.setLeftComponent(left_2);

        JButton JButton_second_1 = new JButton("浏览VIP");
        JButton_second_1.setBounds(25, 30, 95, 27);
        JButton_second_1.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("浏览VIP");
            VIP vip = new VIP();
            vip = new VIPService().browseVIP(vip);

            String[] vip_title = {"编号","账号","姓名","性别","住址","电话","折扣","注册时间"};
            browse = new JTable(vip.getVIPInfo(),vip_title);
            browse.setBounds(0, 0, 690, 500);
            browse.getTableHeader().setReorderingAllowed(false);
            browse.setEnabled(false);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            right_2.add(jScrollPane);
            right_2.updateUI();
        });
        left_2.add(JButton_second_1);

        JButton JButton_second_2 = new JButton("购买记录");
        JButton_second_2.setBounds(25, 90, 95, 27);
        JButton_second_2.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("购买记录");
            VIP vip = new VIP();
            vip = new VIPService().browseVIP(vip);

            String[] vip_title = {"编号","账号","姓名","性别","住址","电话","折扣","注册时间"};
            browse = new JTable(vip.getVIPInfo(),vip_title);
            browse.setBounds(0, 0, 690, 500);
            browse = new JTable(vip.getVIPInfo(),vip_title){
                @Override
                public boolean isCellEditable(int rowIndex, int ColIndex){
                    return false;
                }
            };
            browse.setBounds(0, 0, 690, 500);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            browse.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int count= browse.getSelectedRow();
                        String vip_user = browse.getValueAt(count, 1).toString();
                        new PurchaseHistory(vip_user);
                    }
                }
            });
            right_2.add(jScrollPane);
            right_2.updateUI();
        });
        left_2.add(JButton_second_2);

        JButton JButton_second_3 = new JButton("注册VIP");
        JButton_second_3.setBounds(25, 150, 95, 27);
        JButton_second_3.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("注册VIP");
            JLabel latvia_2 = new JLabel("注册VIP用户");
            latvia_2.setForeground(Color.BLUE);
            latvia_2.setFont(new Font("楷体", Font.PLAIN, 20));
            latvia_2.setBounds(258, 70, 121, 31);
            right_2.add(latvia_2);

            JLabel user = new JLabel("账号：");
            user.setForeground(Color.RED);
            user.setFont(new Font("楷体", Font.PLAIN, 17));
            user.setBounds(209, 125, 59, 18);
            right_2.add(user);

            user_text = new JTextField();
            user_text.setBounds(258, 125, 191, 24);
            right_2.add(user_text);
            user_text.setColumns(10);

            JLabel password = new JLabel("密码：");
            password.setForeground(Color.RED);
            password.setFont(new Font("楷体", Font.BOLD, 17));
            password.setBounds(209, 160, 59, 18);
            right_2.add(password);

            password_text = new JPasswordField();
            password_text.setBounds(258, 160, 191, 24);
            right_2.add(password_text);

            JLabel name = new JLabel("姓名：");
            name.setForeground(Color.RED);
            name.setFont(new Font("楷体", Font.PLAIN, 17));
            name.setBounds(209, 195, 59, 18);
            right_2.add(name);

            name_text = new JTextField();
            name_text.setBounds(258, 195, 191, 24);
            right_2.add(name_text);
            name_text.setColumns(10);

            JLabel sex = new JLabel("性别：");
            sex.setForeground(Color.RED);
            sex.setFont(new Font("楷体", Font.PLAIN, 17));
            sex.setBounds(209, 230, 59, 18);
            right_2.add(sex);

            JRadioButton sex_men = new JRadioButton("男");
            sex_men.setBounds(278, 230, 49, 27);
            sex_men.setOpaque(false);
            right_2.add(sex_men);

            JRadioButton sex_women = new JRadioButton("女");
            sex_women.setBounds(380, 230, 49, 27);
            sex_women.setOpaque(false);
            right_2.add(sex_women);

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(sex_men);
            buttonGroup.add(sex_women);
            sex_men.setSelected(true);

            JLabel address = new JLabel("住址：");
            address.setForeground(Color.RED);
            address.setFont(new Font("楷体", Font.PLAIN, 17));
            address.setBounds(209, 265, 59, 18);
            right_2.add(address);

            address_text = new JTextField();
            address_text.setBounds(258, 265, 191, 24);
            right_2.add(address_text);
            address_text.setColumns(10);

            JLabel telephone = new JLabel("电话：");
            telephone.setForeground(Color.RED);
            telephone.setFont(new Font("楷体", Font.PLAIN, 17));
            telephone.setBounds(209, 300, 59, 18);
            right_2.add(telephone);

            telephone_text = new JTextField();
            telephone_text.setBounds(258, 300, 191, 24);
            right_2.add(telephone_text);
            telephone_text.setColumns(10);

            JLabel discount = new JLabel("折扣：");
            discount.setForeground(Color.RED);
            discount.setFont(new Font("楷体", Font.PLAIN, 17));
            discount.setBounds(209, 335, 59, 18);
            right_2.add(discount);

            discount_text = new JTextField();
            discount_text.setBounds(258, 335, 191, 24);
            right_2.add(discount_text);
            discount_text.setColumns(10);

            JButton commit = new JButton("注册");
            commit.setBounds(257, 383, 70, 27);
            commit.addActionListener(e111 -> {
                String vip_user = user_text.getText().trim();
                String vip_password = new String(password_text.getPassword()).trim();
                String vip_name = name_text.getText().trim();
                String vip_sex;
                if(sex_men.isSelected()) {
                    vip_sex = sex_men.getText().trim();
                } else {
                    vip_sex = sex_women.getText().trim();
                }
                String vip_address = address_text.getText().trim();
                String vip_telephone = telephone_text.getText().trim();
                String vip_discount = discount_text.getText().trim();
                //正则表达式5-20个字符
                String vip_user_check = "^.{5,20}$";
                String vip_password_check = "^.{5,20}$";
                String vip_telephone_check = "^[1][3,4,5,7,8][0-9]{9}$";
                System.out.println(vip_telephone);
                if("".equals(vip_user) || "".equals(vip_password) || "".equals(vip_name)
                        || "".equals(vip_address) || "".equals(vip_telephone) || "".equals(vip_discount)) {
                    JOptionPane.showMessageDialog(null, "文本框不能为空，请重新输入");
                    return;
                }

                if(!vip_user.matches(vip_user_check)) {
                    JOptionPane.showMessageDialog(null, "用户名请输入5-20个字符！");
                    user_text.setText("");
                    return;
                }

                if(!vip_password.matches(vip_password_check)) {
                    JOptionPane.showMessageDialog(null, "密码请输入5-20个字符！");
                    password_text.setText("");
                    return;
                }

                if(!vip_telephone.matches(vip_telephone_check)) {
                    JOptionPane.showMessageDialog(null, "电话输入格式不符合规范！");
                    telephone_text.setText("");
                    return;
                }

                if (Double.parseDouble(vip_discount) <=0 || Double.parseDouble(vip_discount) >=1) {
                    JOptionPane.showMessageDialog(null, "折扣请输入0-1的数字（不包括0和1）！");
                    discount_text.setText("");
                    return;
                }

                double vip_discount1 = Double.parseDouble(vip_discount);
                System.out.println("vip_user:" + vip_user);
                System.out.println("vip_password:" + vip_password);
                System.out.println("vip_name:" + vip_name);
                System.out.println("vip_sex:" + vip_sex);
                System.out.println("vip_address:" + vip_address);
                System.out.println("vip_telephone:" + vip_telephone);
                System.out.println("vip_discount1:" + vip_discount1);

                VIP vip = new VIP();
                vip.setUser(vip_user);
                vip.setPassword(vip_password);
                vip.setName(vip_name);
                vip.setSex(vip_sex);
                vip.setAddress(vip_address);
                vip.setTelephone(vip_telephone);
                vip.setDiscount(vip_discount1);

                if( new VIPService().addVIP(vip)) {
                    user_text.setText("");password_text.setText("");name_text.setText("");
                    address_text.setText("");telephone_text.setText("");discount_text.setText("");
                }
            });
            right_2.add(commit);

            JButton sign_out = new JButton("退出");
            sign_out.setBounds(359, 383, 70, 27);
            sign_out.addActionListener(e15 -> {
                // TODO Auto-generated method stub
                right_2.removeAll();
                right_2.updateUI();
            });
            right_2.add(sign_out);

            right_2.updateUI();
        });
        left_2.add(JButton_second_3);

        JButton JButton_second_4 = new JButton("查看修改");
        JButton_second_4.setBounds(25, 210, 95, 27);
        JButton_second_4.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("查看修改");
            JLabel latvia = new JLabel("请输入您要查询的VIP账号：");
            latvia.setForeground(Color.RED);
            latvia.setFont(new Font("楷体", Font.PLAIN, 17));
            latvia.setBounds(224, 105, 242, 24);
            right_2.add(latvia);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_2.add(textField);
            textField.setColumns(10);

            VIPInfo = new JTextArea();
            VIPInfo.setBounds(167, 240, 353, 204);
            VIPInfo.setFont(new Font("楷体", Font.PLAIN, 17));
            VIPInfo.setOpaque(false);
            VIPInfo.setEditable(false);

            JButton button = new JButton("查询");
            button.setBounds(222, 193, 76, 27);
            button.addActionListener(e112 -> {
                VIPInfo.removeAll();
                String vip_user = textField.getText().trim();
                if("".equals(vip_user)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                VIP vip = new VIP();
                vip.setUser(vip_user);
                vip = new VIPService().selectVIP(vip);
                if (vip.getID() == 0 || vip.getUser() == null || vip.getPassword() == null ||
                        vip.getName() == null || vip.getSex() == null || vip.getAddress() == null ||
                        vip.getTelephone() == null || vip.getDiscount() == 0 || vip.getTime() == null) {
                    JOptionPane.showMessageDialog(null,  "没有该VIP用户信息，请重新输入！！");
                    textField.setText("");
                    VIPInfo.setText("");
                    right_2.add(VIPInfo);
                    right_2.updateUI();
                } else  {
                    String str = "编号："+vip.getID()+"\n"+"账号: "+vip.getUser()+"\n"+"密码："+vip.getPassword()+"\n"
                            +"姓名："+vip.getName()+"\n"+"性别："+vip.getSex()+"\n"
                            +"住址："+vip.getAddress()+"\n"+"电话："+vip.getTelephone()+"\n"
                            +"折扣："+vip.getDiscount()+"\n"+"注册时间："+vip.getTime();
                    VIPInfo.setText(str);
                    right_2.add(VIPInfo);

                    right_2.updateUI();
                }
            });
            right_2.add(button);

            JButton button_1 = new JButton("修改");
            button_1.setBounds(332, 193, 76, 27);
            button_1.addActionListener(e113 -> {
                String vip_user = textField.getText().trim();
                if("".equals(vip_user)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                VIP vip = new VIP();
                vip.setUser(vip_user);
                vip = new VIPService().selectVIP(vip);
                if(vip.getID() != 0 || vip.getPassword() != null ||
                        vip.getName() != null || vip.getSex() != null || vip.getAddress() != null ||
                        vip.getTelephone() != null || vip.getDiscount() != 0 || vip.getTime() != null) {
                    new VIPChange(vip);
                } else {
                    JOptionPane.showMessageDialog(null,  "没有该VIP用户信息，请重新输入！！");
                    textField.setText("");
                }
            });
            right_2.add(button_1);

            right_2.updateUI();
        });
        left_2.add(JButton_second_4);

        JButton JButton_second_5 = new JButton("注销VIP");
        JButton_second_5.setBounds(25, 270, 95, 27);
        JButton_second_5.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("注销VIP");
            JLabel latvia_1 = new JLabel("请输入您要注销的VIP账号：");
            latvia_1.setForeground(Color.RED);
            latvia_1.setFont(new Font("楷体", Font.PLAIN, 17));
            latvia_1.setBounds(227, 112, 218, 33);
            right_2.add(latvia_1);

            textField_1 = new JTextField();
            textField_1.setBounds(227, 158, 185, 24);
            right_2.add(textField_1);
            textField_1.setColumns(10);

            JButton logout = new JButton("注销");
            logout.addActionListener(e14 -> {
                    String vip_logout = textField_1.getText().trim();
                    if ("".equals(vip_logout)) {
                        JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                        return;
                    }
                    VIP vip = new VIP();
                    vip.setUser(vip_logout);
                    if (new VIPService().logoutVIP(vip)) {
                        textField_1.setText("");
                    }
            });
            logout.setBounds(259, 205, 102, 27);
            right_2.add(logout);

            right_2.updateUI();
        });
        left_2.add(JButton_second_5);

        JButton JButton_second_6 = new JButton("购买商品");
        JButton_second_6.setBounds(25, 330, 95, 27);
        JButton_second_6.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("购买商品");
            VIP vip = new VIP();
            vip = new VIPService().browseVIP(vip);

            String[] vip_title = {"编号","账号","姓名","性别","住址","电话","折扣","注册时间"};
            browse = new JTable(vip.getVIPInfo(),vip_title);
            browse.setBounds(0, 0, 690, 500);
            browse = new JTable(vip.getVIPInfo(),vip_title){
                @Override
                public boolean isCellEditable(int rowIndex, int ColIndex){
                    return false;
                }
            };
            browse.setBounds(0, 0, 690, 500);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            browse.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getClickCount() == 2) {
                        int count= browse.getSelectedRow();
                        String get1 = browse.getValueAt(count, 1).toString();
                        String get2 = browse.getValueAt(count, 2).toString();
                        String get3 = browse.getValueAt(count, 3).toString();
                        String get4 = browse.getValueAt(count, 6).toString();
                        new VIPPurchase(get1,get2,get3,get4);
                    }
                }
            });
            right_2.add(jScrollPane);
            right_2.updateUI();
        });
        left_2.add(JButton_second_6);
        panel_second.add(splitPane_second);

        /*第三个：商场人事管理模块*/
        JPanel left_3 = new JPanel();
        left_3.setLayout(null);

        JSplitPane splitPane_third = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_3, right_3);
        splitPane_third.setDividerLocation(150);
        splitPane_third.setEnabled(false);
        splitPane_third.setBounds(0, 0, 853, 517);
        splitPane_third.setLeftComponent(left_3);

        JButton JButton_third_1 = new JButton("浏览员工");
        JButton_third_1.setBounds(25, 30, 95, 27);
        JButton_third_1.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("浏览员工");
            Worker worker = new Worker();
            worker = new WorkerService().browseWorker(worker);

            String[] worker_title = {"工号","姓名","性别","年龄","部门","职务","电话","月薪","地址","状态","注册时间"};
            browse = new JTable(worker.getWorkerInfo(),worker_title);
            browse.setBounds(0, 0, 690, 500);
            browse.getTableHeader().setReorderingAllowed(false);
            browse.setEnabled(false);
            JScrollPane jScrollPane = new JScrollPane(browse);
            jScrollPane.setSize(690,500);
            right_3.add(jScrollPane);
            right_3.updateUI();
        });
        left_3.add(JButton_third_1);

        JButton JButton_third_2 = new JButton("查询员工");
        JButton_third_2.setBounds(25, 90, 95, 27);
        JButton_third_2.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("查询员工");
            JLabel latvia = new JLabel("请输入您要查询员工的工号：");
            latvia.setForeground(Color.RED);
            latvia.setFont(new Font("楷体", Font.PLAIN, 17));
            latvia.setBounds(224, 85, 242, 24);
            right_3.add(latvia);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_3.add(textField);
            textField.setColumns(10);

            WorkerInfo = new JTextArea();
            WorkerInfo.setBounds(167, 220, 353, 204);
            WorkerInfo.setFont(new Font("楷体", Font.PLAIN, 17));
            WorkerInfo.setOpaque(false);
            WorkerInfo.setEditable(false);

            JButton button = new JButton("查询");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e13 -> {
               String worker_id = textField.getText().trim();
                if("".equals(worker_id)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请重新输入！！");
                    return;
                }
               Worker worker = new Worker();
               worker.setId(Integer.parseInt(worker_id));
               worker = new WorkerService().selectWorker(worker);
               if (worker.getId() == 0 || worker.getName() == null || worker.getSex() == null ||
                       worker.getAge() == 0 || worker.getDepartment() == null || worker.getPost() == null ||
                       worker.getTelephone() == null || worker.getMonth_pay() == 0 || worker.getAddress() == null
                       || worker.getStatus() == null || worker.getTime() == null) {
                    JOptionPane.showMessageDialog(null,  "没有该员工信息，请重新输入！！");
                    textField.setText("");
                   WorkerInfo.setText("");
                    right_3.add(WorkerInfo);
                    right_3.updateUI();
                } else  {
                    String str = "编号："+worker.getId()+"      "+"注册时间："+worker.getTime()+"\n"+"姓名: "+worker.getName()+"\n"+"性别："+worker.getSex()+"\n"
                            +"年龄："+worker.getAge()+"\n"+"部门："+worker.getDepartment()+"\n"
                            +"职务："+ worker.getPost()+"\n"+"电话："+worker.getTelephone()+"\n"
                            +"月薪："+worker.getMonth_pay()+"\n"+"住址："+worker.getAddress()+"\n"
                            +"状态："+worker.getStatus();
                    WorkerInfo.setText(str);
                    right_3.add(WorkerInfo);

                    right_3.updateUI();
                }
            });
            right_3.add(button);

            right_3.updateUI();
        });
        left_3.add(JButton_third_2);

        JButton JButton_third_3 = new JButton("注册员工");
        JButton_third_3.setBounds(25, 150, 95, 27);
        JButton_third_3.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("注册员工");

            JLabel label = new JLabel("注册新员工");
            label.setForeground(Color.BLUE);
            label.setFont(new Font("楷体", Font.PLAIN, 20));
            label.setBounds(273, 47, 114, 24);
            right_3.add(label);

            JLabel worker = new JLabel("工号：");
            worker.setForeground(Color.RED);
            worker.setFont(new Font("楷体", Font.PLAIN, 17));
            worker.setBounds(120, 90, 56, 18);
            right_3.add(worker);

            worker_text = new JTextField();
            worker_text.setBounds(170, 90, 180, 24);
            right_3.add(worker_text);
            worker_text.setColumns(10);

            JLabel worker_name = new JLabel("姓名：");
            worker_name.setForeground(Color.RED);
            worker_name.setFont(new Font("楷体", Font.PLAIN, 17));
            worker_name.setBounds(120, 125, 56, 18);
            right_3.add(worker_name);

            work_name_text = new JTextField();
            work_name_text.setBounds(170, 125, 180, 24);
            right_3.add(work_name_text);
            work_name_text.setColumns(10);

            JLabel sex = new JLabel("性别：");
            sex.setForeground(Color.RED);
            sex.setFont(new Font("楷体", Font.PLAIN, 17));
            sex.setBounds(120, 160, 56, 18);
            right_3.add(sex);

            JRadioButton sex_men = new JRadioButton("男");
            sex_men.setBounds(180, 158, 49, 27);
            sex_men.setOpaque(false);
            right_3.add(sex_men);

            JRadioButton sex_women = new JRadioButton("女");
            sex_women.setBounds(263, 158, 49, 27);
            sex_women.setOpaque(false);
            right_3.add(sex_women);

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(sex_men);
            buttonGroup.add(sex_women);
            sex_men.setSelected(true);

            JLabel age = new JLabel("年龄：");
            age.setForeground(Color.RED);
            age.setFont(new Font("楷体", Font.PLAIN, 17));
            age.setBounds(120, 195, 56, 18);
            right_3.add(age);

            age_text = new JTextField();
            age_text.setBounds(170, 195, 180, 24);
            right_3.add(age_text);
            age_text.setColumns(10);

            JLabel department = new JLabel("部门：");
            department.setForeground(Color.RED);
            department.setFont(new Font("楷体", Font.PLAIN, 17));
            department.setBounds(381, 160, 56, 18);
            right_3.add(department);

            String[] str1 = {"人事部","秘书处","市场部","销售部","服务部","进货部"};
            JComboBox<String> department_box = new JComboBox<>(str1);
            department_box.setBounds(434, 158, 145, 24);
            right_3.add(department_box);

            JLabel post = new JLabel("职务：");
            post.setForeground(Color.RED);
            post.setFont(new Font("楷体", Font.PLAIN, 17));
            post.setBounds(381, 266, 56, 18);
            right_3.add(post);

            String[] str2 = {"干事","经理","董事长","董事"};
            JComboBox<String> post_text = new JComboBox<>(str2);
            post_text.setBounds(434, 264, 145, 24);
            right_3.add(post_text);

            JLabel month_pay = new JLabel("月薪：");
            month_pay.setForeground(Color.RED);
            month_pay.setFont(new Font("楷体", Font.PLAIN, 17));
            month_pay.setBounds(120, 230, 56, 18);
            right_3.add(month_pay);

            month_pay_text = new JTextField();
            month_pay_text.setBounds(170, 230, 180, 24);
            right_3.add(month_pay_text);
            month_pay_text.setColumns(10);

            JLabel status = new JLabel("状态：");
            status.setForeground(Color.RED);
            status.setFont(new Font("楷体", Font.PLAIN, 17));
            status.setBounds(120, 265, 56, 18);
            right_3.add(status);

            status_text = new JTextField();
            status_text.setBounds(170, 265, 180, 24);
            right_3.add(status_text);
            status_text.setColumns(10);

            JLabel telephone = new JLabel("电话：");
            telephone.setForeground(Color.RED);
            telephone.setFont(new Font("楷体", Font.PLAIN, 17));
            telephone.setBounds(120, 300, 56, 18);
            right_3.add(telephone);

            telephone_textworker = new JTextField();
            telephone_textworker.setBounds(170, 300, 180, 24);
            right_3.add(telephone_textworker);
            telephone_textworker.setColumns(10);

            JLabel address = new JLabel("住址：");
            address.setForeground(Color.RED);
            address.setFont(new Font("楷体", Font.PLAIN, 17));
            address.setBounds(120, 335, 56, 18);
            right_3.add(address);

            address_textworker = new JTextField();
            address_textworker.setBounds(170, 333, 409, 24);
            right_3.add(address_textworker);
            address_textworker.setColumns(10);

            JButton commit = new JButton("注册");
            commit.setBounds(211, 384, 80, 27);
            commit.addActionListener(e114 -> {
                String worker_id = worker_text.getText().trim();
                String worker_name1 = work_name_text.getText().trim();
                String worker_sex;
                if(sex_men.isSelected()) {
                    worker_sex = sex_men.getText().trim();
                } else {
                    worker_sex = sex_women.getText().trim();
                }
                String worker_age = age_text.getText().trim();
                String worker_department = (String) department_box.getSelectedItem();
                String worker_post = (String) post_text.getSelectedItem();
                String worker_month_pay = month_pay_text.getText().trim();
                String worker_status = status_text.getText().trim();
                String worker_telephone = telephone_textworker.getText().trim();
                String worker_address = address_textworker.getText().trim();
                String worker_telephone_check = "^[1][3,4,5,7,8][0-9]{9}$";
                String check1 = "^[0-9]*[1-9][0-9]*$";
                String check2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
                if("".equals(worker_id) || "".equals(worker_name1) || "".equals(worker_age)
                        || "".equals(worker_month_pay) || "".equals(worker_status) || "".equals(worker_telephone)
                        || "".equals(worker_address)) {
                    JOptionPane.showMessageDialog(null, "文本框不能为空，请重新输入");
                    return;
                }
                if(!worker_id.matches(check1)) {
                    JOptionPane.showMessageDialog(null,  "工号必须是正整数！！");
                    worker_text.setText("");
                    return;
                }
                if(!worker_age.matches(check1)) {
                    JOptionPane.showMessageDialog(null,  "年龄必须是正整数！！");
                    age_text.setText("");
                    return;
                }
                if(!worker_month_pay.matches(check2)) {
                    JOptionPane.showMessageDialog(null,  "月薪必须大于0！！");
                    month_pay_text.setText("");
                    return;
                }
                if(!worker_telephone.matches(worker_telephone_check)) {
                    JOptionPane.showMessageDialog(null, "电话输入格式不符合规范！");
                    telephone_textworker.setText("");
                    return;
                }

                Worker work = new Worker();
                work.setId(Integer.parseInt(worker_id));work.setName(worker_name1);work.setSex(worker_sex);
                work.setAge(Integer.parseInt(worker_age));work.setDepartment(worker_department);
                work.setPost(worker_post);work.setTelephone(worker_telephone);work.setMonth_pay(Double.parseDouble(worker_month_pay));
                work.setAddress(worker_address);work.setStatus(worker_status);
                if (new WorkerService().addWorker(work)) {
                    worker_text.setText("");work_name_text.setText("");age_text.setText("");
                    month_pay_text.setText("");status_text.setText("");telephone_textworker.setText("");address_textworker.setText("");
                }
            });
            right_3.add(commit);

            JButton sign_out = new JButton("退出");
            sign_out.setBounds(381, 384, 80, 27);
            sign_out.addActionListener(e12 -> {
                // TODO Auto-generated method stub
                right_2.removeAll();
                right_2.updateUI();
            });
            right_3.add(sign_out);

            right_3.updateUI();
        });
        left_3.add(JButton_third_3);

        JButton JButton_third_4 = new JButton("修改员工");
        JButton_third_4.setBounds(25, 210, 95, 27);
        JButton_third_4.addActionListener(e -> {
            // TODO Auto-generated method stub
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("修改员工");
            JLabel latvia = new JLabel("请输入您要修改员工的工号：");
            latvia.setForeground(Color.RED);
            latvia.setFont(new Font("楷体", Font.PLAIN, 17));
            latvia.setBounds(224, 85, 242, 24);
            right_3.add(latvia);

            textField = new JTextField();
            textField.setBounds(224, 122, 201, 24);
            right_3.add(textField);
            textField.setColumns(10);

            WorkerInfo = new JTextArea();
            WorkerInfo.setBounds(167, 220, 353, 204);
            WorkerInfo.setFont(new Font("楷体", Font.PLAIN, 17));
            WorkerInfo.setOpaque(false);
            WorkerInfo.setEditable(false);

            JButton button = new JButton("查询");
            button.setBounds(242, 173, 76, 27);
            button.addActionListener(e115 -> {
                String worker_id = textField.getText().trim();
                if("".equals(worker_id)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请重新输入！！");
                    return;
                }
                Worker worker = new Worker();
                worker.setId(Integer.parseInt(worker_id));
                worker = new WorkerService().selectWorker(worker);
                if (worker.getId() == 0 || worker.getName() == null || worker.getSex() == null ||
                        worker.getAge() == 0 || worker.getDepartment() == null || worker.getPost() == null ||
                        worker.getTelephone() == null || worker.getMonth_pay() == 0 || worker.getAddress() == null
                        || worker.getStatus() == null || worker.getTime() == null) {
                    JOptionPane.showMessageDialog(null,  "没有该员工信息，请重新输入！！");
                    textField.setText("");
                    WorkerInfo.setText("");
                    right_3.add(WorkerInfo);
                    right_3.updateUI();
                } else  {
                    String str = "编号："+worker.getId()+"      "+"注册时间："+worker.getTime()+"\n"+"姓名: "+worker.getName()+"\n"+"性别："+worker.getSex()+"\n"
                            +"年龄："+worker.getAge()+"\n"+"部门："+worker.getDepartment()+"\n"
                            +"职务："+ worker.getPost()+"\n"+"电话："+worker.getTelephone()+"\n"
                            +"月薪："+worker.getMonth_pay()+"\n"+"住址："+worker.getAddress()+"\n"
                            +"状态："+worker.getStatus();
                    WorkerInfo.setText(str);
                    right_3.add(WorkerInfo);

                    right_3.updateUI();
                }
            });
            right_3.add(button);

            JButton button_1 = new JButton("修改");
            button_1.setBounds(342, 173, 76, 27);
            button_1.addActionListener(e116 -> {
                String worker_id = textField.getText().trim();
                if("".equals(worker_id)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                Worker worker = new Worker();
                worker.setId(Integer.parseInt(worker_id));
                worker = new WorkerService().selectWorker(worker);
                if (worker.getId() == 0 || worker.getName() == null || worker.getSex() == null ||
                        worker.getAge() == 0 || worker.getDepartment() == null || worker.getPost() == null ||
                        worker.getTelephone() == null || worker.getMonth_pay() == 0 || worker.getAddress() == null
                        || worker.getStatus() == null || worker.getTime() == null)  {
                    JOptionPane.showMessageDialog(null,  "没有该员工信息，请重新输入！！");
                    textField.setText("");
                    right_3.updateUI();
                } else  {
                    new WorkerChange(worker);
                }
            });
            right_3.add(button_1);

            right_3.updateUI();
        });
        left_3.add(JButton_third_4);

        JButton JButton_third_5 = new JButton("注销员工");
        JButton_third_5.setBounds(25, 270, 95, 27);
        JButton_third_5.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("注销员工");
            JLabel latvia = new JLabel("请输入您要注销员工的工号：");
            latvia.setForeground(Color.RED);
            latvia.setFont(new Font("楷体", Font.PLAIN, 17));
            latvia.setBounds(224, 105, 242, 24);
            right_3.add(latvia);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_3.add(textField);
            textField.setColumns(10);

            JButton button = new JButton("确定");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e1 -> {
                String worker_id = textField.getText().trim();
                if ("".equals(worker_id)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                Worker worker = new Worker();
                worker.setId(Integer.parseInt(worker_id));
                if (new WorkerService().logoutWorker(worker)) {
                    textField.setText("");
                }
            });
            right_3.add(button);

            right_3.updateUI();
        });
        left_3.add(JButton_third_5);
        panel_third.add(splitPane_third);

        /*第四个：商场销售管理模块*/
        JPanel left_4 = new JPanel();
        left_4.setLayout(null);

        JSplitPane splitPane_fourth = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_4, right_4);
        splitPane_fourth.setDividerLocation(150);
        splitPane_fourth.setEnabled(false);
        splitPane_fourth.setBounds(0, 0, 853, 517);
        splitPane_fourth.setLeftComponent(left_4);

        JButton JButton_fourth_1 = new JButton("单日查询");
        JButton_fourth_1.setBounds(25, 30, 95, 27);
        JButton_fourth_1.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("单日查询");
            JLabel day = new JLabel("请输入查询的日期：");
            day.setForeground(Color.RED);
            day.setFont(new Font("楷体", Font.PLAIN, 17));
            day.setBounds(224, 105, 242, 24);
            right_4.add(day);

            JLabel label = new JLabel("格式：*****-**-**");
            label.setFont(new Font("楷体", Font.PLAIN, 17));
            label.setBounds(240, 230, 350, 24);
            right_4.add(label);

            JLabel label2 = new JLabel("例如：2019-06-09");
            label2.setFont(new Font("楷体", Font.PLAIN, 17));
            label2.setBounds(240, 260, 350, 24);
            right_4.add(label2);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_4.add(textField);
            textField.setColumns(10);

            JButton button = new JButton("确定");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e1 -> {
                String SaleTime = textField.getText().trim();
                String check = "\\d{4}-\\d{2}-\\d{2}";
                String flag = "单日查询";
                System.out.println(SaleTime);
                if ("".equals(SaleTime)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                if (!SaleTime.matches(check)) {
                    JOptionPane.showMessageDialog(null,  "日期输入不规范，请重新输入！！");
                    textField.setText("");
                    return;
                }
                new SaleHistory(SaleTime, flag);

            });
            right_4.add(button);
            right_4.updateUI();
        });
        left_4.add(JButton_fourth_1);

        JButton JButton_fourth_2 = new JButton("单月查询");
        JButton_fourth_2.setBounds(25, 90, 95, 27);
        JButton_fourth_2.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("单月查询");
            JLabel day = new JLabel("请输入查询的日期：");
            day.setForeground(Color.RED);
            day.setFont(new Font("楷体", Font.PLAIN, 17));
            day.setBounds(224, 105, 242, 24);
            right_4.add(day);

            JLabel label = new JLabel("格式：*****-**");
            label.setFont(new Font("楷体", Font.PLAIN, 17));
            label.setBounds(240, 230, 350, 24);
            right_4.add(label);

            JLabel label2 = new JLabel("例如：2019-06");
            label2.setFont(new Font("楷体", Font.PLAIN, 17));
            label2.setBounds(240, 260, 350, 24);
            right_4.add(label2);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_4.add(textField);
            textField.setColumns(10);

            JButton button = new JButton("确定");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e1 -> {
                String SaleTime = textField.getText().trim();
                String check = "\\d{4}-\\d{2}";
                String flag = "单月查询";
                System.out.println(SaleTime);
                if ("".equals(SaleTime)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                if (!SaleTime.matches(check)) {
                    JOptionPane.showMessageDialog(null,  "日期输入不规范，请重新输入！！");
                    textField.setText("");
                    return;
                }
                new SaleHistory(SaleTime, flag);

            });
            right_4.add(button);
            right_4.updateUI();
        });
        left_4.add(JButton_fourth_2);

        JButton JButton_fourth_3 = new JButton("年份查询");
        JButton_fourth_3.setBounds(25, 150, 95, 27);
        JButton_fourth_3.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("年份查询");
            JLabel day = new JLabel("请输入查询的日期：");
            day.setForeground(Color.RED);
            day.setFont(new Font("楷体", Font.PLAIN, 17));
            day.setBounds(224, 105, 242, 24);
            right_4.add(day);

            JLabel label = new JLabel("格式：*****");
            label.setFont(new Font("楷体", Font.PLAIN, 17));
            label.setBounds(240, 230, 350, 24);
            right_4.add(label);

            JLabel label2 = new JLabel("例如：2019");
            label2.setFont(new Font("楷体", Font.PLAIN, 17));
            label2.setBounds(240, 260, 350, 24);
            right_4.add(label2);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_4.add(textField);
            textField.setColumns(10);

            JButton button = new JButton("确定");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e1 -> {
                String SaleTime = textField.getText().trim();
                String check = "\\d{4}";
                String flag = "年份查询";
                System.out.println(SaleTime);
                if ("".equals(SaleTime)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }
                if (!SaleTime.matches(check)) {
                    JOptionPane.showMessageDialog(null,  "日期输入不规范，请重新输入！！");
                    textField.setText("");
                    return;
                }
                new SaleHistory(SaleTime, flag);

            });
            right_4.add(button);
            right_4.updateUI();
        });
        left_4.add(JButton_fourth_3);

        JButton JButton_fourth_4 = new JButton("浏览全部");
        JButton_fourth_4.setBounds(25, 210, 95, 27);
        JButton_fourth_4.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("浏览全部");
            Sale sale = new Sale();
            sale = new SaleService().browseSaleAll(sale);

            String[] sale_title = {"编号","商品","数量","售价","总价","时间"};
            JTable table = new JTable(sale.getSaleInfo(), sale_title);
            table.setBounds(0, 0, 690, 500);
            table.setOpaque(false);
            table.getTableHeader().setReorderingAllowed(false);
            table.setEnabled(false);
            JScrollPane jScrollPane = new JScrollPane(table);
            jScrollPane.setBounds(0,0,690,500);
            right_4.add(jScrollPane);

            right_4.updateUI();
        });
        left_4.add(JButton_fourth_4);

        JButton JButton_fourth_5 = new JButton("总额查询");
        JButton_fourth_5.setBounds(25, 270, 95, 27);
        JButton_fourth_5.addActionListener(e -> {
            for(JPanel japan : right) {
                japan.removeAll();
            }
            System.out.println("总额查询");
            JLabel day = new JLabel("请输入查询商品的名称：");
            day.setForeground(Color.RED);
            day.setFont(new Font("楷体", Font.PLAIN, 17));
            day.setBounds(224, 105, 242, 24);
            right_4.add(day);

            textField = new JTextField();
            textField.setBounds(224, 142, 201, 24);
            right_4.add(textField);
            textField.setColumns(10);

            SaleInfo = new JTextArea();
            SaleInfo.setBounds(224, 240, 353, 204);
            SaleInfo.setFont(new Font("楷体", Font.PLAIN, 17));
            SaleInfo.setForeground(Color.RED);
            SaleInfo.setOpaque(false);
            SaleInfo.setEditable(false);

            JButton button = new JButton("确定");
            button.setBounds(280, 193, 76, 27);
            button.addActionListener(e1 -> {

                String commodity = textField.getText().trim();
                System.out.println(commodity);
                if ("".equals(commodity)) {
                    JOptionPane.showMessageDialog(null,  "输入框不能为空，请输入！！");
                    return;
                }

                Commodity com = new Commodity();
                com.setCommodity(commodity);
                if(new CommodityService().CheckCommodity(com)) {
                    Sale sale = new Sale();
                    sale.setCommodity(commodity);
                    sale = new SaleService().QueryPriceAll(sale);
                    DecimalFormat df = new DecimalFormat("#.00");
                    String str =  "商品："+commodity+"\n"+"单价："+sale.getPrice()+"\n"+"数量："+sale.getNumber()+"\n"+"销售总额："+df.format( sale.getPriceAll());
                    SaleInfo.setText(str);
                    right_4.add(SaleInfo);
                    right_4.updateUI();
                } else {
                    JOptionPane.showMessageDialog(null,  "不存在改商品，请重新输入！！");
                    textField.setText("");
                    SaleInfo.setText("");
                    right_4.add(SaleInfo);
                    right_4.updateUI();
                }

            });
            right_4.add(button);
            right_4.updateUI();
        });
        left_4.add(JButton_fourth_5);
        panel_fourth.add(splitPane_fourth);

        setVisible(true);
    }

    private JLabel getTime() {
        if (time_label == null) {
            time_label = new JLabel("");
            time_label.setEnabled(false);
            time_label.setBounds(580, 11, 259, 24);
            loacl_time = new Timer(1000, arg0 -> time_label.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE HH:mm:ss").format(new Date())));
            loacl_time.start();
        }
        return time_label;
    }
}
