package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double price;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.price = 4.50;
    }

    public double defaultPrice(){
        return this.price;
    }

    public double priceFor(Visitor visitor){
        double visitorPrice;
        if(visitor.getAge() < 12){
            visitorPrice = this.price * 0.5;
        } else {
            visitorPrice = this.price;
        }
       return visitorPrice;
    }
}
