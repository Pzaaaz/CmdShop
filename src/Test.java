import com.sun.webkit.InspectorClient;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
        InputStream in1 = Class.forName("Test").getResourceAsStream("/Products.xlsx");
        //File file =new File("D:\\学习\\Cmdshop\\src\\users.xlsx");
        ReaduresExcel readuresExcel = new ReaduresExcel();
        ReadproductExcel readproductExcel = new ReadproductExcel();
        User users[] = readuresExcel.uresExcel(in);
        Product products[] = readproductExcel.productExcel(in1);

        boolean bool = true;
        while (bool){

            System.out.println("请输入用户名： ");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            System.out.println("输入的用户名为： " + username);

            System.out.println("请输入密码: ");
            String password = sc.next();
            for(int cou = 0 ; cou < users.length ; cou++) {
                if(username.equals(users[cou].getUsername())){
                    System.out.println("系统读取到的密码是： " + users[cou].getPassword());
                }
            }
            for (User user : users) {
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("登陆成功");
                    for(Product product:products) {
                        System.out.print(product.getId());
                        System.out.print("\t"+product.getName());
                        System.out.print("\t"+product.getPrice());
                        System.out.println("\t"+product.getDescribe());

                    }
                    int counnt = 0;
                    Product productes[] = new Product[3];
                    boolean bool1 = true;
                    while (bool1) {

                        System.out.println("是否添加商品，选择1添加商品，选择2查看购物车，退出选择0");
                        int cun = sc.nextInt();
                        if(cun!=1&&cun!=0&&cun!=2){
                            System.out.println("请输入正确的选择");
                        }
                        else if(cun == 1) {
                            System.out.println("选择想要加入购物车的id：");
                            String inPic = sc.next();
                            in1 = null;
                            in1 = Class.forName("Test").getResourceAsStream("/Products.xlsx");
                            Product product = readproductExcel.getProductByid(inPic, in1);
                            //将商品加入购物车
                            if (product != null)
                                productes[counnt++] = product;

                        }else if(cun == 0){
                            bool1 = false;
                        }
                        else if(cun==2){
                            if(productes[0]==null){
                                System.out.println("购物车为空，请添加商品");
                            }
                            for (int i = 0; i<=counnt-1; i++){
                                if (productes[i] != null){
                                    System.out.println("你的购物车中已经有" + productes[i].getName());
                                }
                            }
                        }
                    }
                    bool = false;
                    break;
                } else
                    System.out.println("登录失败");
            }

        /*for(int i = 0 ; i<users.length ; i++){
            System.out.println(users[i].getUsername());
            System.out.println(users[i].getPassword());
            System.out.println(users[i].getAddress());
            System.out.println(users[i].getPhone());
        }
*/
        }
    }
}
