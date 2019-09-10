package attractions;

import behaviours.IReviewed;
import behaviours.ISites;

public abstract class Attraction implements IReviewed, ISites {
    private String name;
    private int rating;
    private int visitCount;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void canBeVisited(){
        this.visitCount += 1;

    }

}
