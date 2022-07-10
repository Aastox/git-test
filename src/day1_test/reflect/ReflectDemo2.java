package day1_test.reflect;

import day1_test.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        // 只获取 public 修饰的字段
        Field[] fields = personClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("----------------");
        Field a = personClass.getField("a");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);

        a.set(p, "abc");
        System.out.println(p);

        System.out.println("==============");

        Field[] fields1 = personClass.getDeclaredFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
        Field f = personClass.getDeclaredField("age");
        // 暴力反射
        f.setAccessible(true);
        Object value1 = f.get(p);
        System.out.println(value1);

        Constructor[] constructors =personClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);

        }
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object person = constructor.newInstance("char", 23);
        System.out.println(person);

        Constructor constructor1 = personClass.getConstructor();
        Object person1 = constructor1.newInstance();
        System.out.println(person1);
        constructor1.setAccessible(true);

        Object o = personClass.newInstance();
        System.out.println(o);

        System.out.println("====================");
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
            String name = m.getName();
            System.out.println(name);
        }
        Method eat_method = personClass.getMethod("eat");
        System.out.println(eat_method);
        eat_method.invoke(p);
        Method speak_method = personClass.getMethod("speak", String.class);
        speak_method.invoke(p, "abc");
        speak_method.setAccessible(true);

        // 获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
