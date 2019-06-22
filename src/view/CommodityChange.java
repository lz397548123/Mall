package view;

import controller.CommodityService;
import model.Commodity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: CommodityChange
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/6 0:08
 * @Version: 1.0
 */
public class CommodityChange extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField commodity_text;
    private JTextField manufacturer_text;
    private JTextField category_text;
    private JTextField purchase_price_text;
    private JTextField number_text;
    private JTextField price_text;
    private JButton change, gain_out;
    private int id;
    private String commodity,manufacturer, category, purchase_price, number, price;

    public CommodityChange(int id, String commodity, String manufacturer, String category,
                           String purchase_price, String number, String price) {
        this.id = id;
        this.commodity = commodity;
        this.manufacturer = manufacturer;
        this.category = category;
        this.purchase_price = purchase_price;
        this.number = number;
        this.price = price;
        init();
    }

    /**
     * Create the frame.
     */
    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("更新商品");
        setResizable(false);
        setBounds(700, 350, 500, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel label = new JLabel("更改商品信息");
        label.setForeground(Color.RED);
        label.setFont(new Font("楷体", Font.PLAIN, 21));
        label.setBounds(161, 46, 146, 25);
        contentPane.add(label);

        JLabel commodity1 = new JLabel("商品：");
        commodity1.setForeground(Color.RED);
        commodity1.setFont(new Font("楷体", Font.PLAIN, 17));
        commodity1.setBounds(106, 90, 51, 18);
        contentPane.add(commodity1);

        commodity_text = new JTextField(commodity);
        commodity_text.setBounds(161, 88, 181, 24);
        contentPane.add(commodity_text);
        commodity_text.setColumns(20);

        JLabel manufacturer1 = new JLabel("厂商：");
        manufacturer1.setForeground(Color.RED);
        manufacturer1.setFont(new Font("楷体", Font.PLAIN, 17));
        manufacturer1.setBounds(106, 125, 51, 18);
        contentPane.add(manufacturer1);

        manufacturer_text = new JTextField(manufacturer);
        manufacturer_text.setBounds(161, 123, 181, 24);
        contentPane.add(manufacturer_text);
        manufacturer_text.setColumns(20);

        JLabel category1 = new JLabel("类别：");
        category1.setForeground(Color.RED);
        category1.setFont(new Font("楷体", Font.PLAIN, 17));
        category1.setBounds(106, 160, 51, 18);
        contentPane.add(category1);

        category_text = new JTextField(category);
        category_text.setBounds(161, 158, 181, 24);
        contentPane.add(category_text);
        category_text.setColumns(20);

        JLabel purchase_price1 = new JLabel("进价：");
        purchase_price1.setForeground(Color.RED);
        purchase_price1.setFont(new Font("楷体", Font.PLAIN, 17));
        purchase_price1.setBounds(106, 195, 51, 18);
        contentPane.add(purchase_price1);

        purchase_price_text = new JTextField(purchase_price);
        purchase_price_text.setBounds(161, 193, 181, 24);
        contentPane.add(purchase_price_text);
        purchase_price_text.setColumns(20);

        JLabel number1 = new JLabel("数量：");
        number1.setForeground(Color.RED);
        number1.setFont(new Font("楷体", Font.PLAIN, 17));
        number1.setBounds(106, 230, 51, 18);
        contentPane.add(number1);

        number_text = new JTextField(number);
        number_text.setBounds(161, 228, 181, 24);
        contentPane.add(number_text);
        number_text.setColumns(20);

        JLabel price1 = new JLabel("售价：");
        price1.setForeground(Color.RED);
        price1.setFont(new Font("楷体", Font.PLAIN, 17));
        price1.setBounds(106, 270, 51, 18);
        contentPane.add(price1);

        price_text = new JTextField(price);
        price_text.setBounds(161, 268, 181, 24);
        contentPane.add(price_text);
        price_text.setColumns(20);

        change = new JButton("修改");
        change.setBounds(140, 320, 78, 27);
        change.addActionListener(this);
        contentPane.add(change);

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
        if (e.getSource() == change) {
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
            com.setID(id);
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

            if (new CommodityService().changeCommodity(com)) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,  "修改商品信息失败");
            }
        }
    }
}
