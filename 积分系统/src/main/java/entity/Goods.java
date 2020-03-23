package entity;
/*
* 换购物品*/

public class Goods {

    private int id;//物品id
    private double price;//物品价格
    private int number;//物品可换购的个数
    private boolean status;//该物品是否还能被兑换

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getStatus() { return status; }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
