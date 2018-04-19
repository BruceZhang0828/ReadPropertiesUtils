import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.PortUnreachableException;
import java.util.Properties;

/**
 * Created by deepbay on 2018/4/18.
 */
public class ReadPorperties {

    public static void main(String[] args){
        PropUtils.use("app.properties");
        String username = PropUtils.get("username");
        System.out.println(username);
    }
}
