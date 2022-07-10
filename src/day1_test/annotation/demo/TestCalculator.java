package day1_test.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCalculator {
    public static void main(String[] args) throws IOException {

        Calculator c = new Calculator();

        Class cls = c.getClass();

        Method[] methods = cls.getMethods();

        int num = 0;

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method m : methods) {
            if (m.isAnnotationPresent(Check.class)) {
                try {
                    m.invoke(c);
                } catch (Exception e) {
                    num ++;

                    bw.write(m.getName() + "方法出现异常了");
                    bw.newLine();
                    bw.write("异常名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因:" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("========================================");
                    bw.newLine();
                }
            }
        }
        bw.write("出现" + num + "次异常");

        bw.flush();
        bw.close();
    }
}
