package day1_test.annotation;

import java.util.Date;

@MyAnno3
// 压制警告  all 所有警告
@SuppressWarnings("all")
public class AnnoDemo2 {

    // 检测被该注解标注的方法是否是继承自父类(接口)的方法
    @Override
    public String toString() {
        return super.toString();
    }

    // 标注已过时
    @Deprecated
    public void show1() {
        System.out.println("已过时");
    }

    @MyAnno(show = "1", anno2 = @MyAnno2, ss = {"aaa", "bbb"})
    public void show2() {

    }

    @MyAnno3
    public void demo() {

        show1();
        Date date = new Date();
        date.getMonth();

    }
}
