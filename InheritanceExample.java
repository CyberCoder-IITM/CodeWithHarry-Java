public class InheritanceExample {
    //public class Inheritance
    static class Employee{
    float salary = 4000;
}
static class Programmer extends Employee {
    int bonus = 1000;
}
    public static void main(String[] args) {
        Programmer p = new Programmer();
        Employee p1 = new Employee();
        System.out.println("Salary is : "+p.salary);

    }

}
