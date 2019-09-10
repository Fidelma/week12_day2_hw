package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ITicketed, ISecurity {

    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.price = 8.40;
    }

    public double defaultPrice(){
        return this.price;
    }

    public double priceFor(Visitor visitor){
        double currentPrice;
        if(visitor.getHeight() > 200){
            currentPrice = this.price * 2;
        }else {
            currentPrice = this.price;
        }
        return currentPrice;
    }

    public boolean isAllowedTo(Visitor visitor){
        if(visitor.getAge() > 12 && visitor.getHeight() > 145){
            return true;
        }else {
            return false;
        }
    }

}
