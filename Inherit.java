 class Common{
    int id;
    String name;
//    String BloodGroup;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }

class worker extends Common{
    int id;
    String name;
    public worker(int id,String name) {
        System.out.println("The id of worker is  "+id+ " and name is "+name);
    }

    //    String Work;
//    public void ExtraTime(int a){
//        System.out.println("This worker worked for "+a+" Hours extra today");
//    }
//


}

class Supervisor extends Common{
    int Experience;
    public Supervisor(int id,String name, int Experience){
        System.out.println("The id and name of supervisor is "+id+" and "+name+"and Experience is "+Experience+" years");
    }

}

class Manager extends Common{

}

public class Inherit {
    public static void main(String[] args) {

        worker w = new worker(21232, "woker1");

        Supervisor s1 = new Supervisor(41231,"Supervisor1",7);


    }
}
