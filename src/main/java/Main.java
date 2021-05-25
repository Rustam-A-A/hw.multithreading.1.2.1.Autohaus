import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Autohaus autohaus = new Autohaus();
        final Seller seller = new Seller();

        Runnable selling = autohaus::sellTheCar;
        Runnable receiving = autohaus::receiveTheCar;

        ThreadGroup threadGroup = new ThreadGroup("main group");

        new Thread(threadGroup, selling, "Client1").start();
        new Thread(threadGroup, selling, "Client2").start();
        new Thread(threadGroup, selling, "Client4").start();
        new Thread(null, receiving, "Automotive Producer").start();
        new Thread(threadGroup, selling, "Client3").start();
        new Thread(threadGroup, selling, "Client4").start();
        new Thread(threadGroup, selling, "Client4").start();
    }
}
