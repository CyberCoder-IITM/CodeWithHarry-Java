import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate yesterday = date.minusDays(1);
        System.out.println(yesterday);

        LocalDate tomorrow = date.plusDays(1);
        System.out.println(tomorrow);

//        LocalDateTime date1 = new LocalDateTime(1,null);
//        System.out.println(date1);
    }
}
