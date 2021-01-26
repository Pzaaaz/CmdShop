import java.util.Date;

public class Order {

   private User user;
   private Product product[];
   private int ammount;
   private float totalpay;
   private float actualpay;
   private Date orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public float getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(float totalpay) {
        this.totalpay = totalpay;
    }

    public float getActualpay() {
        return actualpay;
    }

    public void setActualpay(float actualpay) {
        this.actualpay = actualpay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
