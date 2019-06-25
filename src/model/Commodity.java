package model;

/**
 * @ClassName: commodity
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/4 23:50
 * @Version: 1.0
 */
public class Commodity {
    /**
     * 以下是商品信息，分别为：
     *  编号，商品，厂商，类别，进价，数量，售价，总进价，时间，数据信息。
     */
    private int id;
    private String commodity;
    private String manufacturer;
    private String category;
    private double purchase_price;
    private int number;
    private double price;
    private double purchase_price_all;
    private String time;
    private Object[][] comInfo;

    public int setID(int id) {
        return this.id = id;
    }
    public int getId() {
        return id;
    }
    public String setCommodity(String commodity) {
        return this.commodity = commodity;
    }
    public String getCommodity() {
        return commodity;
    }
    public String setManufacturer(String manufacturer) {
        return this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String setCategory(String category) {
        return this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public double setPurchase_price(double purchase_price) {
        return this.purchase_price = purchase_price;
    }
    public double getPurchase_price() {
        return purchase_price;
    }
    public int setNumber(int number) {
        return this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public double setPrice(double price) {
        return this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    public double setPurchase_price_all(double purchase_price_all) { return this.purchase_price_all = purchase_price_all; }
    public double getPurchase_price_all() { return this.purchase_price_all; }
    public String setTime(String time) {
        return this.time = time;
    }
    public String getTime() {
        return time;
    }
    public Object[][]  setComInfo(Object[][] comInfo ) { return this.comInfo = comInfo; }
    public Object[][]  getComInfo() {
        return comInfo;
    }
}
