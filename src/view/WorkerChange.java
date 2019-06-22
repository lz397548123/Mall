package view;

import controller.WorkerService;
import model.Worker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: WorkerChange
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/9 18:51
 * @Version: 1.0
 */
public class WorkerChange extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField worker_id_text;
    private JTextField worker_name_text;
    private JTextField worker_sex_text;
    private JTextField worker_age_text;
    private JTextField worker_telephone_text;
    private JTextField worker_month_pay_text;
    private JTextField worker_address_text;
    private JTextField worker_status_text;
    private JLabel worker_name;
    private JButton change, gain_out;
    private JComboBox<String> worker_department_box, worker_post_box;
    private Worker worker;

    public WorkerChange(Worker worker) {
        this.worker = worker;
        init();
    }
    public void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("更改VIP用户");
        setBounds(700, 350, 500, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblvip = new JLabel("更改员工信息");
        lblvip.setForeground(Color.RED);
        lblvip.setFont(new Font("楷体", Font.PLAIN, 21));
        lblvip.setBounds(174, 41, 146, 25);
        contentPane.add(lblvip);

        JLabel worker_id = new JLabel("工号：");
        worker_id.setForeground(Color.RED);
        worker_id.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_id.setBounds(41, 90, 51, 18);
        contentPane.add(worker_id);

        worker_id_text = new JTextField(String.valueOf(worker.getId()));
        worker_id_text.setBounds(86, 88, 146, 24);
        worker_id_text.setEnabled(false);
        worker_id_text.setEditable(false);
        contentPane.add(worker_id_text);
        worker_id_text.setColumns(20);

        worker_name = new JLabel("姓名：");
        worker_name.setForeground(Color.RED);
        worker_name.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_name.setBounds(255, 90, 51, 18);
        contentPane.add(worker_name);

        worker_name_text = new JTextField(worker.getName());
        worker_name_text.setBounds(301, 88, 146, 24);
        contentPane.add(worker_name_text);
        worker_name_text.setColumns(20);

        JLabel worker_sex = new JLabel("性别：");
        worker_sex.setForeground(Color.RED);
        worker_sex.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_sex.setBounds(41, 140, 51, 18);
        contentPane.add(worker_sex);

        worker_sex_text = new JTextField(worker.getSex());
        worker_sex_text.setBounds(86, 138, 146, 24);
        contentPane.add(worker_sex_text);
        worker_sex_text.setColumns(20);

        JLabel worker_age = new JLabel("年龄：");
        worker_age.setForeground(Color.RED);
        worker_age.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_age.setBounds(255, 140, 51, 18);
        contentPane.add(worker_age);

        worker_age_text = new JTextField(String.valueOf(worker.getAge()));
        worker_age_text.setBounds(301, 138, 146, 24);
        contentPane.add(worker_age_text);
        worker_age_text.setColumns(20);

        JLabel worker_department = new JLabel("部门：");
        worker_department.setForeground(Color.RED);
        worker_department.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_department.setBounds(41, 190, 51, 18);
        contentPane.add(worker_department);

        String[] str1 = {"人事部","秘书处","市场部","销售部","服务部","进货部"};
        worker_department_box = new JComboBox<>(str1);
        worker_department_box.setBounds(86, 188, 146, 24);
        worker_department_box.setSelectedItem(worker.getDepartment());
        contentPane.add(worker_department_box);

        JLabel worker_post = new JLabel("职务：");
        worker_post.setForeground(Color.RED);
        worker_post.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_post.setBounds(255, 190, 51, 18);
        contentPane.add(worker_post);

        String[] str2 = {"干事","经理","董事长","董事"};
        worker_post_box = new JComboBox<>(str2);
        worker_post_box.setBounds(301, 188, 146, 24);
        worker_post_box.setSelectedItem(worker.getPost());
        contentPane.add(worker_post_box);

        JLabel worker_telephone = new JLabel("电话：");
        worker_telephone.setForeground(Color.RED);
        worker_telephone.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_telephone.setBounds(41, 240, 51, 18);
        contentPane.add(worker_telephone);

        worker_telephone_text = new JTextField(worker.getTelephone());
        worker_telephone_text.setBounds(86, 238, 146, 24);
        contentPane.add(worker_telephone_text);
        worker_telephone_text.setColumns(10);

        JLabel worker_month_pay = new JLabel("月薪：");
        worker_month_pay.setForeground(Color.RED);
        worker_month_pay.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_month_pay.setBounds(255, 240, 51, 18);
        contentPane.add(worker_month_pay);

        worker_month_pay_text = new JTextField(String.valueOf(worker.getMonth_pay()));
        worker_month_pay_text.setBounds(301, 238, 146, 24);
        contentPane.add(worker_month_pay_text);
        worker_month_pay_text.setColumns(10);

        JLabel worker_address = new JLabel("住址：");
        worker_address.setForeground(Color.RED);
        worker_address.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_address.setBounds(41, 290, 51, 18);
        contentPane.add(worker_address);

        worker_address_text = new JTextField(worker.getAddress());
        worker_address_text.setBounds(86, 288, 146, 24);
        contentPane.add(worker_address_text);
        worker_address_text.setColumns(50);

        JLabel worker_status = new JLabel("状态");
        worker_status.setForeground(Color.RED);
        worker_status.setFont(new Font("楷体", Font.PLAIN, 17));
        worker_status.setBounds(255, 290, 51, 18);
        contentPane.add(worker_status);

        worker_status_text = new JTextField(worker.getStatus());
        worker_status_text.setBounds(301, 288, 146, 24);
        contentPane.add(worker_status_text);
        worker_status_text.setColumns(10);

        change = new JButton("修改");
        change.setBounds(137, 352, 78, 27);
        change.addActionListener(this);
        contentPane.add(change);

        gain_out = new JButton("取消");
        gain_out.setBounds(267, 352, 78, 27);
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
            String worker_id = worker_id_text.getText().trim();
            String worker_name = worker_name_text.getText().trim();
            String worker_sex = worker_sex_text.getText().trim();
            String worker_age = worker_age_text.getText().trim();
            String worker_department = (String) worker_department_box.getSelectedItem();
            String worker_post = (String) worker_post_box.getSelectedItem();
            String worker_month_pay = worker_month_pay_text.getText().trim();
            String worker_status = worker_status_text.getText().trim();
            String worker_telephone = worker_telephone_text.getText().trim();
            String worker_address = worker_address_text.getText().trim();
            String worker_telephone_check = "^[1][3,4,5,7,8][0-9]{9}$";
            String check1 = "^[0-9]*[1-9][0-9]*$";
            String check2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
            if("".equals(worker_id) || "".equals(worker_name) || "".equals(worker_age)
                    || "".equals(worker_month_pay) || "".equals(worker_status) || "".equals(worker_telephone)
                    || "".equals(worker_address)) {
                JOptionPane.showMessageDialog(null, "文本框不能为空，请重新输入");
                return;
            }
            if(!worker_id.matches(check1)) {
                JOptionPane.showMessageDialog(null,  "工号必须是正整数！！");
                worker_id_text.setText("");
                return;
            }
            if (!"男".equals(worker_sex) && !"女".equals(worker_sex)) {
                JOptionPane.showMessageDialog(null, "性别必须为男或女！");
                worker_sex_text.setText("");
                return;
            }
            if(!worker_age.matches(check1)) {
                JOptionPane.showMessageDialog(null,  "年龄必须是正整数！！");
                worker_age_text.setText("");
                return;
            }
            if(!worker_month_pay.matches(check2)) {
                JOptionPane.showMessageDialog(null,  "月薪必须大于0！！");
                worker_month_pay_text.setText("");
                return;
            }
            if(!worker_telephone.matches(worker_telephone_check)) {
                JOptionPane.showMessageDialog(null, "电话输入格式不符合规范！");
                worker_telephone_text.setText("");
                return;
            }

            Worker work = new Worker();
            work.setId(Integer.parseInt(worker_id));work.setName(worker_name);work.setSex(worker_sex);
            work.setAge(Integer.parseInt(worker_age));work.setDepartment(worker_department);
            work.setPost(worker_post);work.setTelephone(worker_telephone);work.setMonth_pay(Double.parseDouble(worker_month_pay));
            work.setAddress(worker_address);work.setStatus(worker_status);
            if (new WorkerService().changeWorker(work)) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,  "修改员工信息失败！！");
            }
        }
    }
}
