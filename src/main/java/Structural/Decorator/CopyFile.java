package Structural.Decorator;

import java.io.*;

/**
 * @author lyd
 * @Description
 * BufferedInputStream利用了装饰器模式对InputStream进行增强，增加缓冲功能
 * 装饰器模式和静态代理模式代码结构类似，只是装饰器模式是附加的原始类相关的增强代码啊
 * 代理模式附加的是与原始类无关的功能
 * @create 2022-07-09-11:27
 */
public class CopyFile {

    public void copy(String file1, String file2) {

        try (FileInputStream in = new FileInputStream(file1);
             FileOutputStream out = new FileOutputStream(file2);){

            BufferedInputStream bIn = new BufferedInputStream(in);
            BufferedOutputStream bOut = new BufferedOutputStream(out);
            byte[] bytes = new byte[128];
            while ((bIn.read(bytes)) != -1) {
                bOut.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
