public class Test02 {

    private static Test02 instance;

    private Test02() {

    }

    private static Test02 getInstance() {
        synchronized(Test02.class) {
            if (instance == null) {
                instance = new Test02();
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Test02 one = Test02.getInstance();
        Test02 two = Test02.getInstance();
        System.out.println(one == two);
    }
}