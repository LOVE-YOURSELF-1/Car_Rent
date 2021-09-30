package Car_Rent;

import java.io.IOException;
import java.util.Scanner;

public class ma {
    public static void main(String[] args) {
        String ID;
        client_queue m = new client_queue();
        int c;
        Scanner sc = new Scanner(System.in);
        do {
            //设置字体为绿色
            System.out.println( "           \t             \t   欢迎光临竟龙银行集团        \t      \t    \n");
            System.out.println("                    ***********************************************************");
            System.out.println("                    ★  ☆\t     1.新  增  普  通  用  户    \t☆  ★");
            System.out.println("                    ★  ☆\t     2.删  除  用  户  信  息    \t☆  ★");
            System.out.println("                    ★  ☆\t     3.修  改  用  户  信  息    \t☆  ★");
            System.out.println("                    ★  ☆\t     4.查  询  用  户  信  息    \t☆  ★");
            System.out.println("                    ★  ☆\t     5.新  增  Y I  P  用  户    \t☆  ★");
            System.out.println("                    ★  ☆\t     6.预     览    信     息    \t☆  ★");
            System.out.println("                    ★  ☆\t     7.清     除    用     户    \t☆  ★");
            System.out.println("                    ★  ☆\t     8.保     存    数     据    \t☆  ★");
            System.out.println("                    ★  ☆\t     9.插    入    用      户    \t☆  ★");
            System.out.println("                    ★  ☆\t    10.统           计         \t☆  ★");
            System.out.println("                    ★  ☆\t    11.退    出    服      务    \t☆  ★");
            System.out.println("                    ***********************************************************");
            System.out.println("1－11选择服务\t请选择(1-11): ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    try {
                        m.common_Add();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        m.Delete();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3: {
                    System.out.print("请输入要修改人员的ID:  ");
                    ID = sc.nextLine();
                    ID = sc.nextLine();
                    System.out.println();
                    m.Modify(ID);
                }
                break;
                case 4: {
                    m.Query();
                }
                ;
                break;
                case 8:
                    try {
                        m.Save();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        m.Look();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    m.DesTory();
                    break;
                case 10:
                    System.out.println("共" + m.TJ() + "人!!\n");
                    break;
                case 5:
                    try {
                        m.vip_Add();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    System.exit(0);
                case 9: {
                    int x;
                    System.out.println("请输入将要插入何处");
                    x = sc.nextInt();
                    try {
                        m.customer_Insert(x);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    break;
            }
        } while (c != 0);
        char s;
        System.out.println("\n★是否要保存您的所有操作(Y/N):  ");
        s = sc.nextLine().toUpperCase().charAt(0);
        if (s == 'Y') {
            try {
                m.Save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
