public class Test03 {

    private static Test03 instance;

    private Test03() {

    }

    private static Test03 getInstance() {
        if (instance == null) {
            synchronized(Test03.class) {
                if (instance == null) {
                    instance = new Test03();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Test03 one = Test03.getInstance();
        Test03 two = Test03.getInstance();
        System.out.println(one == two);
    }
}