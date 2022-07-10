package day1_test.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "day1_test.annotation.student", methodName = "study")
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Class<ReflectTest> ref = ReflectTest.class;
        // 获取注解定义位置的对象
        Pro an = ref.getAnnotation(Pro.class);
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
