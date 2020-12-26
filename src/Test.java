import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file =new File("D:\\学习\\Cmdshop\\src\\users.xlsx");
        ReadExcel readExcel = new ReadExcel();
        User users[] = readExcel.readExcel(file);

        System.out.println("请输入用户名： ");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        System.out.println("请输入密码: ");
        String password = sc.next();

        for(User user:users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("登陆成功");
            }
            else
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
