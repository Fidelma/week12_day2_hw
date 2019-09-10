package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(14, 210, 10);
        visitor2 = new Visitor(14, 110, 10);
        visitor3 = new Visitor(11, 210, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void doublesPriceForTall() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void wontDoubleForSmall() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor2), 0.01);
    }

    @Test
    public void canImplementAgeAndHeightRestrictions() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void canBeVisited() {
        rollerCoaster.canBeVisited();
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
