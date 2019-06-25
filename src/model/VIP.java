package model;

/**
 * @ClassName: VIP
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 0:07
 * @Version: 1.0
 */
public class VIP {
    /**
     * 以下分别是VIP用户的信息，分别为：
     *  用户名，密码，姓名，性别，住址，电话，
     *  折扣，时间，数据信息，商品，数量。
     */
    private int id;
    private String user;
    private String password;
    private String name;
    private String sex;
    private String address;
    private String telephone;
    private double discount;
    private String time;
    private Object[][] VIPInfo;
    private String commodity;
    private int number;


    public int setID(int id) {
        return this.id = id;
    }
    public int getID() { return id; }
    public String setUser(String user) {
        return this.user = user;
    }
    public String getUser() {
        return user;
    }
    public String setPassword(String password) {
        return this.password = password;
    }
    public String getPassword() {
        return password;
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
    public String setAddress(String address) {
        return this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public String setTelephone(String telephone) {
        return this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }
    public double setDiscount(double discount) {
        return this.discount = discount;
    }
    public double getDiscount() {
        return discount;
    }
    public String setTime(String time) {
        return this.time = time;
    }
    public String getTime() {
        return time;
    }
    public Object[][]  setVIPInfo(Object[][] VIPInfo ) { return this.VIPInfo = VIPInfo; }
    public Object[][]  getVIPInfo() {
        return VIPInfo;
    }
    public String setCommodity(String commodity) {return this.commodity = commodity;}
    public String getCommodity() {
        return commodity;
    }
    public int setNumber(int number) {
        return this.number = number;
    }
    public int getNumber() { return number; }
}
