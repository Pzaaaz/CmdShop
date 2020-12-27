import com.sun.webkit.InspectorClient;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
        //File file =new File("D:\\学习\\Cmdshop\\src\\users.xlsx");
        ReaduresExcel readExcel = new ReaduresExcel();
        User users[] = readExcel.readExcel(in);

        boolean bool = true;
        while (bool){

            System.out.println("请输入用户名： ");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            System.out.println("输入的用户名为： " + username);

            System.out.println("请输入密码: ");
            String password = sc.next();
            for (User user : users) {
                System.out.println("系统读取到的密码有： " + user.getPassword());
            }

            for (User user : users) {
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("登陆成功");
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
