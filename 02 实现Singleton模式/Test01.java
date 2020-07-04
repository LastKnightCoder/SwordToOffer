public class Test01 {

    private Test01() {

    }

    private static Test01 instance;

    public static Test01 getInstance() {
        if (instance == null) {
            instance = new Test01();
        } 

        return instance;
    }

    public static void main(String[] args) {
        Test01 one = Test01.getInstance();
        Test01 two = Test01.getInstance();
        System.out.println(one == two);
    }
}