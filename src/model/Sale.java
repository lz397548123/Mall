package model;

/**
 * @ClassName: Sale
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/5 22:59
 * @Version: 1.0
 */
public class Sale {

    private int id;
    private String commodity;
    private int number;
    private double price;
    private double price_all;
    private String time;
    private Object[][] saleInfo;

    public int setID(int id) {
        return this.id = id;
    }
    public int getID() { return id; }
    public String setCommodity(String commodity) {
        return this.commodity = commodity;
    }
    public String getCommodity() {
        return commodity;
    }
    public int setNumber(int number) {
        return this.number = number;
    }
    public int getNumber() { return number; }
    public double setPrice(double price) { return this.price = price; }
    public double getPrice() { return price; }
    public double setPriceAll(double price_all) { return this.price_all = price_all; }
    public double getPriceAll() { return price_all; }
    public String setTime(String time) {
        return this.time = time;
    }
    public String getTime() {
        return time;
    }
    public Object[][]  setSaleInfo(Object[][] saleInfo ) { return this.saleInfo = saleInfo; }
    public Object[][]  getSaleInfo() {
        return saleInfo;
    }
}
