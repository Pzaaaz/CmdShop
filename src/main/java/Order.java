import java.util.Date;
import java.util.Map;

public class Order {

   private User user;
   private Product product[];
   private Map<Integer,Integer> ammount;
   private float totalpay;
   private float actualpay;
   private Date orderDate = new Date();


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

    public Map<Integer,Integer> getAmmount() {
        return ammount;
    }

    public void setAmmount(Map<Integer,Integer> ammount) {
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
