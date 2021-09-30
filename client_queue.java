package Car_Rent;


import java.io.*;
import java.util.Objects;
import java.util.Scanner;


public class client_queue{
    customer first, rear, now = null;
    int flag = 0;
    Scanner sc = new Scanner(System.in);
    client_queue()
    {
        first = null;
        try {
            Load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void Find_Name(String Name){
        //按姓名查找
        customer p1;
        int count = 0;
        p1 = first;
        while(p1 != null)
        {
            if(p1.name.compareTo(Name)==0)
            {
                count++;
                Output(p1);
            }
            p1 = p1.next;
        }
        if(count != 0)
        {
            System.out.println("共找到 " + count + " 个名字为 ★" + Name + "★ 的顾客");
        }
        else
            System.out.println("\n\t\t未找到该顾客!!!\n");
    }

    void Find_ID(String ID){
        //按编号查找
        customer p1;
        p1 = first;
        while(p1 != null)
        {
            if(Objects.equals(p1.id, ID))
                break;
            else
            {
                p1 = p1.next;
            }
        }
        if(p1 != null)
        {
            Output(p1);
        }
        else
            System.out.println("未找到该顾客");
    }

    void Find_TEL(String TEL){
        //按编号查找
        customer p1;
        p1 = first;
        while(p1 != null)
        {
            if(Objects.equals(p1.tel, TEL))
                break;
            else
            {
                p1 = p1.next;
            }
        }
        if(p1 != null)
        {
            Output(p1);
        }
        else
            System.out.println("未找到该顾客");
    }

    void common_Add() throws IOException {
        //添加加信息
//        System.clearProperty("cls");
        customer p; //新结点指针
        String ID;
        int Age;
        char Sex;
        String TEL;
        String Name;
        char c;
        System.out.println("\n** 新增普通顾客 **");
        //输入顾客信息
        System.out.print("输入ID:\t");
        ID = sc.nextLine();
        {
            customer p1;
            p1 = first;
            while(p1 != null)
            {
                if(Objects.equals(p1.id, ID)) {
                    break;
                }
                else {
                    p1 = p1.next;
                }
            }
            if(p1 != null)
            {
                System.out.println("该顾客已存在,是否修改该顾客信息(Y/N) ");
                String s = sc.nextLine();
                c = s.toUpperCase().charAt(0);
                if(c =='Y')
                {
                    System.out.println("该顾客信息为:");
                    Find_ID(ID);
                    System.out.println();
                    Modify(ID);
                    return ;
                }
                else
                    return ;
            }
        }
        System.out.print("输入姓名:\t");
        Name = sc.nextLine();
        System.out.print("输入性别:\t");
        String s = sc.nextLine();
        Sex = s.toUpperCase().charAt(0);
        System.out.print("输入年龄:\t");
        Age = sc.nextInt();
        System.out.print("输入电话:\t");
        TEL = sc.nextLine();
        TEL = sc.nextLine();
        System.out.println();
        p=new customer(ID, Name, Sex, Age, TEL, null);
        p.next = null;
        //顾客结点加入链表
        if(first != null) //若已经存在结点
        {
            rear.next = p;//连接
            rear = p;
        }
        else //若不存在结点(表空)
        {
            first=p;
            rear=p;//连接
        }
        System.out.println("\t\t\t   ***添加成功***\n");
        System.out.println("是否继续添加(Y/N)  ");
        s = sc.nextLine();
        c = s.toUpperCase().charAt(0);
        if(c == 'Y')
        {
            common_Add();
            return ;
        }
        else
            return ;
    }

    void Delete() throws IOException{
        //删除信息
        char c;
        String  No;
        System.out.println("\n** 删除信息 **");
        System.out.print("输入要删除的顾客ID:\t");
        No = sc.nextLine();
        //查找要删除的结点
        customer p1, p2;
        p1 = first;
        p2 = null;
        while(p1 != null)
        {
            if(Objects.equals(p1.id, No))
                break;
            else
            {
                p2 = p1;
                p1 = p1.next;
            }
        }
        //删除结点
        if(p1 != null)//若找到结点，则删除
        {
            System.out.println("所要删除的顾客的信息如下:\n");
            Output(p1);
            System.out.print("确定是否删除(Y/N): ");
            String s = sc.nextLine();
            c = s.toUpperCase().charAt(0);
            if(c !='Y')
                return;
            //	system("pause");
            if(p1 == first) //若要删除的结点是第一个结点
            {
                first = p1.next;
            }
            else //若要删除的结点是后续结点
            {
                p2.next = p1.next;
            }
            System.out.print("\t\t***删除成功***\n");
            System.out.println("是否继续删除(Y/N)  ");
            s = sc.nextLine();
            c = s.toUpperCase().charAt(0);
            if(c =='Y')
            {
                Delete();
                return ;
            }
            else
                return ;
        }
        else //未找到结点
            System.out.print("未找到该顾客!\n");
//        getch();
    }

    void Query(){
        //查询信息
        String c;
        String ID,Tel, Name;
        do{
            System.out.println("1. 按账号查找   2. 按名字查找  3. 按电话号码查找  4.退出查找");
            c = sc.nextLine();
            System.out.println();
            switch(c)
            {
                case "1": {
                    System.out.print("输入账号 ID:  ");
                    ID = sc.nextLine();
                    System.out.print("\t\t\t   ***查找成功***\n");
                    Find_ID(ID);
                }; break;
                case "2": {
                    System.out.print("输入姓名 Name:  ");
                    Name = sc.nextLine();
                    System.out.print("\t\t\t   ***查找成功***\n");
                    Find_Name(Name);
                }; break;
                case "3": {
                    System.out.print("输入电话号码 Tel:   ");
                    Tel = sc.nextLine();
                    System.out.print("\t\t\t   ***查找成功***\n");
                    Find_TEL(Tel);
                };break;
                case "4":break;
                default:  System.out.print("输入有误 请重新输入!!!\n");
            }
        }while(!c.equals("1") && !c.equals("2") && !c.equals("3") && !c.equals("4"));
        System.out.println("是否继续查找(Y/N)  ");
        c = sc.nextLine();
        if(c.toUpperCase().charAt(0)=='Y')
        {
            Query();
            return ;
        }
        else
            return ;
    }

    int TJ(){
        //清除文件信息
        int a=0;
        customer q = first;
        while(q != null)
        {
            a++;
            q = q.next;
        }
        return a;
    }

    void Save() throws IOException{
        //保存数据
        FileWriter writer = new FileWriter("/home/D2184231458/2184231458/Car_Rent/src/Car_Rent/Client.txt");
        String c;
        System.out.print("\n保存数据,是否继续?[Y/N]:");
        c = sc.nextLine();
        if(!Objects.equals(c, "Y"))
            return;
        customer p = first;
        while(p != null)
        {
            writer.write(p.id + "-" + p.name + "-" + p.sex + "-" + p.age + "-" + p.tel+ "\n");
            p = p.next;
        }
        writer.close();
        System.out.println("\n保存成功...");
    }

    void Load() throws IOException {
        //读入数据
        File file = new File("/home/D2184231458/2184231458/Car_Rent/src/Car_Rent/Client.txt");
        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(inputReader);
        // 按行读取字符串
        String str;
        customer p;
        String No,Tel, Name;
        int Age;
        char Sex;
        String [] strs = new String[7];
        int i = 0;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            for (String str1: str.split("-")){
                strs[i] = str1;
                i++;
            }
            i = 0;
            No = strs[0];
            Name = strs[1];
            Sex = strs[2].toUpperCase().charAt(0);
            Age = Integer.parseInt(strs[3]);
            Tel = strs[4];
            p = new customer(No,Name,Sex,Age,Tel, null);
            p.next = null;
            //顾客结点加入链表
            if(first != null) //若已经存在结点
            {
                customer p2;
                p2 = first;
                while(p2.next != null) //查找尾结点
                {
                    p2 = p2.next;
                }
                p2.next = p; //连接
                rear = p;
            }
            else //若不存在结点(表空)
            {
                first = p; //连接
            }
        }
        bf.close();
        inputReader.close();
    }

    void Look() throws IOException{
        //预览
        customer p1;
        int count=0;
        String c;
        p1 = first;
        while(p1 != null)
        {
            System.out.println("ID: " + p1.id + "\t姓名: " + p1.name);
            count++;
            p1 = p1.next;
        }
        if(count!=0)
        {
            System.out.println("\n\t\t预览成功!!! \n");
            System.out.print("查询详细信息(Y/N): ");
            c = sc.nextLine();
            if(c.toUpperCase().charAt(0) == 'Y')
            {
                Query();
                return;
            }
            else
                return ;
        }
        else
        {
            System.out.println("尚未创建顾客信息表，是否创建(Y/N)");
            c = sc.nextLine();
            if(c.toUpperCase().charAt(0) == 'Y')
            {
                common_Add();
                return;
            }
            else
                return ;
        }
    }

    void DesTory(){
        String c;
        System.out.println("\n\t\t\t** 清除信息 **");
        System.out.println("警告:\n    清除顾客信息会导致您保存的信息完全消失!!!\n");
        System.out.println("★是否决定清除顾客信息(Y/N):  ");
        c = sc.nextLine();
        if(c.toUpperCase().charAt(0) != 'Y')
            return;
        System.out.println("请再次确认(Y/N)");
        c = sc.nextLine();
        if(c.toUpperCase().charAt(0) != 'Y')
            return;
        else
        {
            customer p;
            p = first;
            while(p != null)
            {
                p = p.next;
            }
            first = null;
        }
    }

    void vip_Add() throws IOException{
        customer p, p2; //新结点指针
        String ID;
        int Age;
        char Sex;
        String TEL;
        String name;
        char c;
        System.out.println("\n** 新增VIP顾客 **\n");
        //输入顾客信息
        System.out.print("输入ID:       ");
        ID = sc.nextLine();
        {
            customer p1;
            p1 = first;
            while(p1 != null)
            {
                if(Objects.equals(p1.id, ID)) {
                    break;
                }
                else {
                    p1 = p1.next;
                }
            }
            if(p1 != null)
            {
                System.out.println("该顾客已存在,是否修改该顾客信息(Y/N) ");
                String s = sc.nextLine();
                c = s.toUpperCase().charAt(0);
                if(c =='Y')
                {
                    System.out.println("该顾客信息为:");
                    Find_ID(ID);
                    System.out.println();
                    Modify(ID);
                    return ;
                }
                else
                    return ;
            }
        }
        System.out.print("输入姓名:\t");
        name = sc.nextLine();
        System.out.print("输入性别:\t");
        String s = sc.nextLine();
        Sex = s.toUpperCase().charAt(0);
        System.out.print("输入年龄:\t");
        Age = sc.nextInt();
        System.out.print("输入电话:\t");
        TEL = sc.nextLine();
        TEL = sc.nextLine();
        sc.nextLine();
        p=new customer(ID, name, Sex, Age, TEL, null);
        p.next = null;
        //顾客结点加入链表
        if(now != null) //若已经存在结点
        {
            p.next = now.next;
            now.next = p;
            now = p;
        }
        else    //若不存在结点(表空)
        {
            p.next = first;
            first = p;
            now = p;//连接
        }
        p2 = first;
        while(p2.next!=null)
            p2 = p2.next;
        rear = p2;
        System.out.println("\t\t\t   ***添加成功***\n");
        System.out.println("是否继续添加(Y/N)  ");
        s = sc.nextLine();
        c = s.toUpperCase().charAt(0);
        if(c == 'Y')
        {
            vip_Add();
            return ;
        }
        else
            return ;
    }

    void customer_Insert(int d) throws IOException{
        customer p, p2; //新结点指针
        String ID;
        int Age;
        char Sex;
        String TEL;
        String Name;
        char c;
        System.out.println("\n** 插入新顾客 **");
        //输入顾客信息
        System.out.print("输入ID:         ");
        ID = sc.nextLine();
        {
            customer p1;
            p1 = first;
            while(p1 != null)
            {
                if(Objects.equals(p1.id, ID))
                {
                    break;
                }
                else
                {
                    p1 = p1.next;
                }
            }
            if(p1 != null)
            {
                System.out.println("该顾客已存在,是否修改该顾客信息(Y/N) ");
                String s = sc.nextLine();
                c = s.toUpperCase().charAt(0);
                if(c =='Y')
                {
                    System.out.println("该顾客信息为:");
                    Find_ID(ID);
                    System.out.println();
                    Modify(ID);
                    return ;
                }
                else
                    return ;
            }
        }
        System.out.print("输入姓名:\t");
        Name = sc.nextLine();
        System.out.print("输入性别:\t");
        String s = sc.nextLine();
        Sex = s.toUpperCase().charAt(0);
        System.out.print("输入年龄:\t");
        Age = sc.nextInt();
        System.out.print("输入电话:\t");
        TEL =sc.nextLine();
        sc.nextLine();
        p = new customer(ID, Name, Sex, Age, TEL, null);
        p.next = null;
        //顾客结点加入链表
        if(first != null) //若已经存在结点
        {
            int e = 1;
            if(d == 1)
            {
                p.next = first;
                first = p;
            }
            else if(d == 2)
            {
                p.next = first.next;
                first.next = p;
            }
            else
            {
                d-=2;

                p2=first;
                while(d != 0)
                {
                    d--;
                    p2 = p2.next;
                }
                p.next = p2.next;
                p2.next = p;
            }
        }
        else //若不存在结点(表空)
        {
            System.out.println("抱歉，你输入的信息有误");
            return ;
        }
        System.out.println("\t\t\t   ***插入成功***\n");
        System.out.println("是否继续插入(Y/N)  ");
        s = sc.nextLine();
        c = s.toUpperCase().charAt(0);
        if(c =='Y')
        {
            System.out.println("输入你要插入到何处");
            int ss =  sc.nextInt();
            customer_Insert(ss);
            return ;
        }
        else
            return ;
    }

    void Modify(String ID){
        customer p1;
        char c;
        p1 = first;
        while(p1 != null)
        {
            if(Objects.equals(p1.id, ID))
                break;
            else
            {
                p1 = p1.next;
            }
        }
        if(p1 != null)//若找到结点
        {
            System.out.println("所要修改的顾客的信息如下:\n");
            Output(p1);
            do
            {
                System.out.println("1. 修改姓名  2. 修改性别  3. 修改年龄  4. 修改联系方式  5. 退出修改 \n");
                System.out.println("请选择(1-5)要修改的信息\n");
                String s = sc.nextLine();
                c = s.charAt(0);
                if(c!='5')
                    System.out.print("请输入新的信息:  ");
                switch(c)
                {
                    case '1': p1.name = sc.nextLine(); break;
                    case '2': p1.sex = sc.nextLine().toUpperCase().charAt(0); break;
                    case '3': p1.age = sc.nextInt(); sc.nextLine(); break;
                    case '4': p1.tel = sc.nextLine(); break;
                    default: break;
                }
            }while(c!='5');
            System.out.print("\t   ***修改成功***\n");
            System.out.print("是否继续修改(Y/N):  ");
            String s = sc.nextLine();
            c = s.toUpperCase().charAt(0);
            if(c == 'Y')
            {
                System.out.print("请输入要修改人员的ID:  ");
                ID = sc.nextLine();
                System.out.println();
                Modify(ID);
                return ;
            }
            else
                return ;
        }
        else //未找到结点
            System.out.println("未找到该顾客!");
//        getch();//暂停
    }

    void Output(customer p) {
        System.out.println("\t\t账号: " + p.id);
        System.out.println("\t\t姓名: " + p.name);
        System.out.println("\t\t性别: " + p.sex);
        System.out.println("\t\t年龄: " + p.age);
        System.out.println("\t\t联系电话: " + p.tel);
        System.out.println();
    }

}
