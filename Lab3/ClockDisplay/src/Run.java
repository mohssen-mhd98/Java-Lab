import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        ClockDisplay clockDisplay = new ClockDisplay(ldt.getHour(), ldt.getMinute(), ldt.getSecond());
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clockDisplay.timeTick();
            System.out.println(clockDisplay.getTime());
        }
    }
}