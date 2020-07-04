public class Test05 {

    private Test05() {

    }

    private static final class InnerTest {
        private static Test05 INSTANCE = new Test05();
    }

    public static Test05 getInstance() {
        return InnerTest.INSTANCE;
    }

    public static void main(String[] args) {
        Test05 one = Test05.getInstance();
        Test05 two = Test05.getInstance();
        System.out.println(one == two);
    }
}