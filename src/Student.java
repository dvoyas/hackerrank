public class Student {
    int id;
    String name;

    void display(){
        System.out.println(id+ " " + name);
    }
    void display2(){
        System.out.println(id);
    }

    public static void main(String args[]){
        Student s1=new Student();
        Student s2=new Student();
        s1.display();
        s2.display();
        s2.display2();
        int f = 0;
        System.out.println(f);
    }
}
