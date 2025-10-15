class Circle{
    public int radius;
    public Circle(){
        System.out.println("Iam a Constructor of circle without arguments");
    }

    public Circle(int r){
        System.out.println("Iam a parameterized constructor of circle class ");
        this.radius = r;
    }
    public double area(){
        return Math.PI*this.radius*this.radius;
    }
}

class Cylinder1 extends Circle{
    public int height;

    public Cylinder1(int r,int h){
        super(r);
        this.height=h;
        System.out.println("Finally Done");
    }
    public double volume(){
        return Math.PI*this.radius*this.radius*this.height;
    }
}

public class CWH_CH10_PS {
    public static void main(String[] args) {
        Circle objc = new Circle();
        Cylinder1 obj = new Cylinder1(12,7);
    }
}
