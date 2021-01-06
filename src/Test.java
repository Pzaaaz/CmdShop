import java.io.InputStream;
import java.util.Scanner;

public class Test {
    static int counnt = 0;
    static Product productes[] = new Product[3];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException {
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
            for (User user : users) {
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("登陆成功");
                    while (true) {
                        System.out.println("选择1添加商品到购物车，选择2结账，选择3查看购物车，选择4退出");
                        int cun1 = sc.nextInt();
                        if (cun1 != 1 && cun1 != 2 && cun1 != 3 && cun1 != 4) {
                            System.out.println("请输入正确的选择");
                        } else if (cun1 == 1) {
                            commodity();
                        } else if (cun1 == 2) {
                            System.out.println("结账");
                            int tem;
                            int num = 0;
                            for (int i = 0; i <= counnt - 1; i++) {
                                if (productes[i] != null) {
                                    tem = (int) productes[i].getPrice();
                                    num += tem;
                                }
                            }
                            System.out.println("你一共需要付款：" + num);
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
        if (productes[0] == null) {
            System.out.println("购物车为空，请添加商品");
        }
        for (int i = 0; i <= counnt - 1; i++) {
            if (productes[i] != null) {
                System.out.println("你的购物车中已经有" + productes[i].getName());
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
            productes[counnt++] = product;
    }
}
