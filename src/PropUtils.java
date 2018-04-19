import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by deepbay on 2018/4/18.
 */
public class PropUtils {
    /**
     * 在utils中定义一个 对象
     */
    private static Prop prop = null;
    /**
     * 保证线程安全 的作用
     */
    private static final ConcurrentHashMap<String,Prop> map = new ConcurrentHashMap<>();

    private PropUtils(){

    }

    public static Prop use(String fileName){
        return use(fileName,"UTF-8");
    }

    /**
     * 使用一次use方法 就将prop放入map中 所以每次都要先使用use进行初始化一下
     * @param fileName
     * @param encoding
     * @return
     */
    public static Prop use(String fileName,String encoding){
         Prop result = (Prop) map.get(fileName);
        if(result==null){
            result = new Prop(fileName,encoding);
            map.put(fileName,result);
            if(prop==null){
                prop = result;
            }
        }
        return result;
    }


    /**
     * 获取某一个key 对应value
     * @param key
     * @return
     */
    public static String get(String key){

        return prop.get(key);

    }







}
