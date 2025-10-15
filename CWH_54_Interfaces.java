interface Bicycle{
    int a = 45;
    void applyBrake(int decrement);
    void speedUp(int increment);
}

interface HornBicycle{
    void blowHornk3g();
    void blowHornmhn();
}

class  AvonCycle implements Bicycle , HornBicycle{
    void blowHorn(){
        System.out.println("Pee Pee Poo Poo");
    }

    public void applyBrake(int decrement){
        System.out.println("Applying brake ");

    }

    public void speedUp(int increment){
        System.out.println("Applying speedup ");

    }

    @Override
    public void blowHornk3g() {
        System.out.println("Kabhi khusi kabhi gam pee poo pee");
    }


    public void blowHornmhn() {
        System.out.println("Mai hoo na pee poo pee ");
    }
}

public class CWH_54_Interfaces {
    public static void main(String[] args) {

        AvonCycle cycleHarry = new AvonCycle();
        cycleHarry.applyBrake(1);
        // You can create properties in Interfaces
        System.out.println(cycleHarry.a);

        //   You cannot modify the properties in Interfaces as they are final.
        // cycleharry.a = 233;

        cycleHarry.blowHornk3g();
        cycleHarry.blowHornmhn();

    }
}
