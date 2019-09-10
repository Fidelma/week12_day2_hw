import attractions.Attraction;
import attractions.Dodgems;
import behaviours.ISecurity;
import behaviours.ISites;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<ISites> sites;

    public ThemePark(){
        this.sites = new ArrayList<>();
    }


    public int numberOfReviewed() {
        return this.sites.size();
    }

    public void addReviewedSite(ISites site) {
        this.sites.add(site);
    }

    public ArrayList<ISites> getAllReviewed() {
        return this.sites;
    }

    public void visit(Attraction attraction, Visitor visitor) {
        attraction.canBeVisited();
        visitor.visit(attraction);
    }

    public HashMap<String, Integer> getAllRatings() {
        HashMap<String, Integer> ratings = new HashMap<>();
        for (ISites site : sites){
            ratings.put(site.getName(), site.getRating());
        }
        return ratings;
    }

    public ArrayList<ISecurity> getAllAllowedFor(Visitor visitor) {
        ArrayList<ISecurity> allowed = new ArrayList<>();
        for(ISites site : sites){
            if(site instanceof ISecurity){
                ((ISecurity) site).isAllowedTo(visitor);
                allowed.add((ISecurity) site);
            }
        }
        return allowed;
    }
}
