import java.util.Calendar;
import java.util.TimeZone;

public class CWH_98_calendar_class {
    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        System.out.println(c.getCalendarType());
//        System.out.println(c.getTime());

        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Riyadh"));
        System.out.println(c.getCalendarType());
        System.out.println(c.getTimeZone().getDisplayName());
        System.out.println(c.getTimeZone().getID());
    }
}
