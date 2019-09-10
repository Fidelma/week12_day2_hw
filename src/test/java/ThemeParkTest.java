import attractions.Dodgems;
import behaviours.ISecurity;
import behaviours.ISites;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    
    ThemePark themePark;
    Dodgems dodgems;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Visitor visitor;
    
    @Before
    public void setUp(){
        themePark = new ThemePark();
        dodgems = new Dodgems("dodge", 4);
        iceCreamStall = new IceCreamStall("yum", "bob", ParkingSpot.A1, 4);
        tobaccoStall = new TobaccoStall("smelly", "bobby", ParkingSpot.A1, 2);
        visitor = new Visitor(15, 210, 20);

    }

    @Test
    public void reviewedEmptyToStart() {
        assertEquals(0, themePark.numberOfReviewed());
    }

    @Test
    public void canAddReviewedSite() {
        themePark.addReviewedSite(dodgems);
        assertEquals(1, themePark.numberOfReviewed());
    }

    @Test
    public void canGetAllReviewed() {
        themePark.addReviewedSite(dodgems);
        themePark.addReviewedSite(iceCreamStall);
        ArrayList<ISites> returnedSites = themePark.getAllReviewed();
        assertEquals(2, returnedSites.size());
    }

    @Test
    public void visitorCanVisitAttraction() {
        themePark.addReviewedSite(dodgems);
        themePark.visit(dodgems, visitor);
        assertEquals(1, visitor.getNumberOfAttractionsVisited());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canGetRatings() {
        themePark.addReviewedSite(dodgems);
        themePark.addReviewedSite(iceCreamStall);
        HashMap<String, Integer> rating = themePark.getAllRatings();
        assertEquals(true, rating.containsKey("dodge"));
        assertEquals(true, rating.containsKey("yum"));

    }

    @Test
    public void canGetAllAllowed() {
        themePark.addReviewedSite(dodgems);
        themePark.addReviewedSite(iceCreamStall);
        themePark.addReviewedSite(tobaccoStall);
        ArrayList<ISecurity> allowed = themePark.getAllAllowedFor(visitor);
        assertEquals(1, allowed.size());

    }
}
