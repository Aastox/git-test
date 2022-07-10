package day1_test.annotation.demo;

public class Calculator {

    @Check
    public void add() {
        String s = null;
        s.toString();
        System.out.println("0 + 1 = " + (0 + 1));
    }

    @Check
    public void sub() {
        System.out.println("0 - 1 = " + (0 - 1));
    }

    @Check
    public void mut() {
        System.out.println("0 * 1 = " + (0 * 1));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    public void show() {
        System.out.println("无bug......");
    }
}
