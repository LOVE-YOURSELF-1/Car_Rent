package Car_Rent;

public class customer {
    String id;
    String name;
    char sex;
    int age;
    String tel;
    customer next;

    customer(String id, String name, char sex, int age, String tel, customer next){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.next = next;
    }
    String getID() {
        return this.id;
    }
    String getname(){
        return this.name;
    }
    String gettel() {
        return this.tel;
    }
    int getage()
    {
        return this.age;
    }
    char getsex()
    {
        return this.sex;
    }
}
