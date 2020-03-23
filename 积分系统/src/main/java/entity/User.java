package entity;

public class User {
    private int id;
    private String password;
    private double points;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password  = password;
    }

    public double getPoints() { return points; }
    public void setPoints(double points) {
        this.points = points;
    }
}
