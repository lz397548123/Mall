package model;

/**
 * @ClassName: Worker
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 0:15
 * @Version: 1.0
 */
public class Worker {
    /**
     * 以下分别是员工的信息，分别为：
     *  工号，姓名，性别，年龄，部门，职务，电话，月薪，住址，状态。
     */
    private int id;
    private String name;
    private String sex;
    private int age;
    private String department;
    private String post;
    private String telephone;
    private double month_pay;
    private String address;
    private String status;
    private String time;
    private Object[][] workerInfo;

    public int setId(int id) {
        return this.id = id;
    }
    public int getId() {
        return id;
    }
    public String setName(String name) {
        return this.name = name;
    }
    public String getName() {
        return name;
    }
    public String setSex(String sex) {
        return this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public int setAge(int age) {
        return this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String setDepartment(String department) {
        return this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public String setPost(String post) {
        return this.post = post;
    }
    public String getPost() { return post; }
    public String setTelephone(String telephone) {
        return this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }
    public double setMonth_pay(double month_pay) {
        return this.month_pay = month_pay;
    }
    public double getMonth_pay() { return month_pay; }
    public String setAddress(String address) {
        return this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public String setStatus(String status) {
        return this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public String setTime(String time) {
        return this.time = time;
    }
    public String getTime() {
        return time;
    }
    public Object[][]  setWorkerInfo(Object[][] workerInfo ) { return this.workerInfo = workerInfo; }
    public Object[][]  getWorkerInfo() {
        return workerInfo;
    }
}
