import java.io.Serializable;

public class Address implements Serializable {
    String city,lane,state;
    public Address(String city, String lane, String state) {
        super();
        this.city = city;
        this.lane = lane;
        this.state = state;
    }

}


