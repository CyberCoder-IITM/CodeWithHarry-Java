class Base1{

    Base1(){
        System.out.println("I am a constructor");
    }

    Base1(int x ){
        System.out.println("I am a overloaded constructor with the value of a as "+x);
    }

    public int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class Derived1 extends Base1{

    Derived1(){
//        super(0);
        System.out.println("I am a Derived class constructor");
    }

    Derived1(int x, int y){
        super(x);
        System.out.println("I am a overloaded constructor of Derived1 with the value of y as "+y);
    }
    public int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class ChildOfDerived1 extends  Derived1{
    ChildOfDerived1(){
        System.out.println("I am a child of Derived1 constructor");
    }
    ChildOfDerived1(int x, int y, int z){
        super(x,y);
        System.out.println("I am a overloaded constructor of ChildOfDerived1 with the value of z as "+z);
    }
}

public class CWH_46_Constructors_in_inheritance {
    public static void main(String[] args) {
//        Base1 b  = new Base1();
//        Derived1 d = new Derived1();
//        Derived1 d1 = new Derived1(4,12);
        ChildOfDerived1 c = new ChildOfDerived1();
//        ChildOfDerived1 c1 = new ChildOfDerived1(5,10,15);




    }
}
