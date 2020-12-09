package Interface;

public class A6 implements Show.Message {

    public static void main(String[] args) {

        Show.Message a6 = new A6();
        a6.msg();

    }

    @Override
    public void msg() {

        System.out.println("Hello Nested Interface");
    }
}
