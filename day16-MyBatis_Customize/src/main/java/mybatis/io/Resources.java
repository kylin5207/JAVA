package mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件
 */
public class Resources {

    /**
     * 根据传入的文件路径参数，获取字节输入流
     * @param filePath 配置文件路径
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
