public class Seller {
    Object seller;
    final int TIME_TO_GET_CAR = 2000;
    final int TIME_TO_SELL_CAR = 1500;
    final int CARS_QUOTA = 7;

    private static Autohaus autohaus;

    public Seller(Autohaus autohaus) {
        this.autohaus = autohaus;
    }

    public Seller() { }

    public synchronized void receiveAuto() {
        for (int i = 0; i < CARS_QUOTA; i++){
            try {
                Thread.sleep(TIME_TO_GET_CAR);
                autohaus.getAutos().add(new Auto());
                System.out.println("автосалон получил новый автомобиль");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellAuto() {
        System.out.println("потенциальный покупатель зашел в автосалон");
        try {
            if (autohaus.getAutos().size() == 0) {
                System.out.println("в автосалоне нет непроданных автомобилей ");
                wait();
            }
            Thread.sleep(TIME_TO_SELL_CAR);
            System.out.println("автосалон реализовал автомобиль");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        autohaus.getAutos().remove(0);
        notifyAll();
    }
}
