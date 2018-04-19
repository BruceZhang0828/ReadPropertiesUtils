import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class Main {

    public static void main(String[] args) {
        //当前是时间
        long l = System.currentTimeMillis();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm:ss");
        long time = 0;
        try {
            Date parse = simpleFormatter.parse("13:00:00");
            time= parse.getTime();
        } catch (Exception e){
            e.printStackTrace();
        }
        long de = (time - l)/1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm:ss");
                String format = simpleFormatter.format(new Date());
                System.out.println(format);
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,de,1, TimeUnit.MINUTES);
    }
}
