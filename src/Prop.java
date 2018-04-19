import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by deepbay on 2018/4/18.
 */
public class Prop {

    private Properties properties; //定义一个读取properties文件

    /**
     * 构造函数中进行 对 proreties 进行初始化
     * @param fileName
     * @param encoding
     */
    public Prop(String fileName,String encoding){
        this.properties = null;
        InputStream inputStream = null;
        try {
            //获取当前线程中的inputStream
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(inputStream==null){
                throw new IllegalArgumentException("找不到文件 在这个路径下"+fileName);
            }
            //初始化 properties
            this.properties = new Properties();
            //加载相关文件
            this.properties.load(new InputStreamReader(inputStream,encoding));
        } catch (IOException e) {
            throw new RuntimeException("Error 加载文件失败",e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  String get(String key){

        return this.properties.getProperty(key);
    }
}
