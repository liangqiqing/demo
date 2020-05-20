package util;

import java.io.*;

/**
 * 对拷贝工具类
 */
public class Copy {
    //声明变量
    private static int len;
    private static byte[] bytes;
    private static char[] chars;

    public static void copyA(InputStream is, OutputStream fos) throws IOException {
        bytes = new byte[1024*8];
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
    }
    public static void copyB(Reader fis, Writer fos) throws IOException {
        chars = new char[1024*8];
        while ((len = fis.read(chars)) != -1){
            fos.write(chars,0,len);
        }
    }
}
