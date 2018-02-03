import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DiscountTest {

        private Discount famiylDiscount;
        private  Rental rentalByHour;
        private  Rental rentalByDay;
        private  Rental rentalByWeek;
        private Person jack;
        private Person lucy;

        @Before
        public void init(){
                famiylDiscount = new FamilyDiscount();
                rentalByHour = new RentalByHour();
                rentalByDay = new RentalByDay();
                rentalByWeek = new RentalByWeek();
                jack = new Person();
                lucy = new Person();
                rentalByHour.setCost(5d);
                rentalByDay.setCost(20d);
                rentalByWeek.setCost(60d);
                jack.setId("123");
                lucy.setId("456");
        }

        @Test
        public void familyDiscountTest(){
                jack.rent(rentalByDay,3);
                assertEquals(42d, famiylDiscount.applyGetDiscountPrice(jack),0.001);

                lucy.rent(rentalByHour,1);
                lucy.rent(rentalByDay,2);
                assertEquals(31.5d, famiylDiscount.applyGetDiscountPrice(lucy),0.001);

                jack.rent(rentalByWeek,1);
                assertEquals(84d, famiylDiscount.applyGetDiscountPrice(jack),0.001);

        }

}
