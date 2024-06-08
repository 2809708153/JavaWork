import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Webcat {
    public static void main(String[] args) throws IOException {
        // 网址字符串
        String urlStr = "";
        // 创建资源符对象
        URL url = new URL(urlStr);
        // 创建连接
        URLConnection conn = url.openConnection();
        // 获取输入流
        InputStream inputStream = conn.getInputStream();
        // 缓冲区，读取输入流内容，64KB
        char[] buffer = new char[1024 * 64];
        int len;
        StringBuilder sb = new StringBuilder();
        // 转换为字符流
        InputStreamReader isr = new InputStreamReader(inputStream);
        // 循环读取
        while ((len = isr.read(buffer)) != -1){
            sb.append(buffer, 0, len);
        }
        System.out.println(sb.toString());
        // 关闭资源
        inputStream.close();
        isr.close();
    }
}