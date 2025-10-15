abstract class Parent2{
    public Parent2(){
        System.out.println("Mai Parent2 ka constructor hu");
    }
    public void sayhello(){
        System.out.println("Hello");
    }
    abstract public void greet();
    abstract public void greet2();
}

// there is no garbage collector in C++, and my brain become garbage I guess

class Child2 extends Parent2{
    @Override
    public void greet() {
        System.out.println("Good Morning");
    }
    @Override
    public void greet2() {
        System.out.println("Good afternoon");
    }

    public void sayname(){
        System.out.println("my name is khan");
    }
}

abstract class child3 extends Parent2{
    public void greet(){
        System.out.println("I am child3");
    }
}

public class CWH_53_abstract {
    public static void main(String[] args) {

//        Parent2 p = new Parent2(); //Not allowed bohot bure ho tum parent to abstract hai

        Child2 c = new Child2();

//        child3 c1 = new child3(); //Not allowed

        c.sayname();
//        c.sayhello();
//        c.greet();

    }
}
