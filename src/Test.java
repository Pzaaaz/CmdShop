import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    static int counnt = 0;
    static Product carts[] = new Product[3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");

        //File file =new File("D:\\学习\\Cmdshop\\src\\users.xlsx");
        ReaduresExcel readuresExcel = new ReaduresExcel();
        User users[] = readuresExcel.uresExcel(in);
        boolean bool = true;
        while (bool) {
            System.out.println("请输入用户名： ");
            String username = sc.next();
            System.out.println("输入的用户名为： " + username);
            System.out.println("请输入密码: ");
            String password = sc.next();
            for (int cou = 0; cou < users.length; cou++) {
                if (username.equals(users[cou].getUsername())) {
                    System.out.println("系统读取到的密码是： " + users[cou].getPassword());
                }
            }
            for (int i=0;i<users.length;i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    while (true) {
                        System.out.println("选择1添加商品到购物车，选择2结账，选择3查看购物车，选择4退出");
                        int cun1 = sc.nextInt();
                        if (cun1 != 1 && cun1 != 2 && cun1 != 3 && cun1 != 4) {
                            System.out.println("请输入正确的选择");
                        } else if (cun1 == 1) {
                            commodity();
                        } else if (cun1 == 2) {
                            Order order=new Order();
                            order.setUser(users[i]);//订单关联用户
                            Product products[]=new Product[counnt];
                            for(int j  = 0 ; j <carts.length;j++){
                                if(carts[j]!=null){
                                    products[j]=carts[j];
                                }
                            }
                            //订单关联商品
                            order.setProduct(products);//问题：有的时候只买了两件商品，导致有一个数值没用到
                            //下订单
                            CreateOrder.creatOrder(order);
                        } else if (cun1 == 3) {
                            viewcart();
                        } else {
                            break;
                        }
                    }
                    bool = false;
                    break;
                } else
                    System.out.println("登录失败");
            }
        }
    }

    static void viewcart() {
        if (carts[0] == null) {
            System.out.println("购物车为空，请添加商品");
        }
        for (int i = 0; i <= counnt - 1; i++) {
            if (carts[i] != null) {
                System.out.println("你的购物车中已经有" + carts[i].getName());
            }
        }
    }

    public static void commodity() throws ClassNotFoundException {
        InputStream in1 = Class.forName("Test").getResourceAsStream("/Products.xlsx");
        ReadproductExcel readproductExcel = new ReadproductExcel();
        Product products[] = readproductExcel.productExcel(in1);
        for (Product product : products) {
            System.out.print(product.getId());
            System.out.print("\t" + product.getName());
            System.out.print("\t" + product.getPrice());
            System.out.println("\t" + product.getDescribe());
        }
        System.out.println("选择想要加入购物车的id：");
        String inPic = sc.next();
        in1 = null;
        in1 = Class.forName("Test").getResourceAsStream("/Products.xlsx");
        Product product = readproductExcel.getProductByid(inPic, in1);
        //将商品加入购物车
        if (product != null)
            carts[counnt++] = product;
    }


}

