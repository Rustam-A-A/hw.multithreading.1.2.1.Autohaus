import java.util.ArrayList;
import java.util.List;

public class Autohaus{
    final int CAPACITY = 10;

    final Seller seller = new Seller(this);

    List<Auto> autos = new ArrayList<>(CAPACITY);

    public void sellTheCar(){
        synchronized (seller){
            seller.sellAuto();
        }
    }

    public void receiveTheCar(){
        synchronized (seller){
            seller.receiveAuto();
        }

    }

    public List<Auto> getAutos() {
        return autos;
    }
}
