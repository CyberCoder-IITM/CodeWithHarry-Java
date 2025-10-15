class Rectangle{
    int length;
    int breadth;
    public int area(){
        return length*breadth;
    }
    public int perimeter(){
        return (2*length)+(2*breadth);
    }
}

public class Area_Rectangle {
    public static void main(String[] args) {

        // Problem 1
//        Employee harry = new Employee();
//        harry.setName("CodeWithHarry");
//        harry.salary = 233;
//        System.out.println(harry.getSalary());
//        System.out.println(harry.getName());
//
//        // Problem 2
//        CellPhone asus = new CellPhone();
//        asus.callFriend();
//        asus.vibrate();
//        //asus.ring();


        // Problem 3
        Rectangle rec = new Rectangle();
        rec.length = 2;
        rec.breadth = 2;
        System.out.println(rec.area());
        System.out.println(rec.perimeter());


        // Problem 5
//        Tommy player1 = new Tommy();
//        player1.fire();
//        player1.run();
//        player1.hit();


    }
}