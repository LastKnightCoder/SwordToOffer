public class Test04 {
    private static Test04 INSTANCE = new Test04();

    private Test04() {

    }

    public static Test04 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Test04 one = Test04.getInstance();
        Test04 two = Test04.getInstance();
        System.out.println(one == two);
    }
}