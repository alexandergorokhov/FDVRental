import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;


public class RentalTest {

    private  Rental rentalByHour;
    private  Rental rentalByDay;
    private  Rental rentalByWeek;
    private Person jack;
    private Person lucy;


    @Before
    public void init(){
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
    public void rentalByHourTest(){
        int localTime=LocalDateTime.now().plusHours(1).getHour();
        jack.setRentEndDateHour(LocalDateTime.now().plusHours(1));
        assertEquals(5d, jack.rent(rentalByHour,1),0.0001);
        assertEquals(localTime,jack.getRentEndDateHour().getHour());
        assertEquals(1, jack.getRentalConunt(),0);

    }

    @Test
    public void rentalByDay(){
        int localTime=LocalDateTime.now().plusDays(1).getHour();
        jack.setRentEndDateHour(LocalDateTime.now().plusDays(1));
        assertEquals(20d, jack.rent(rentalByDay,1),0.0001);
        assertEquals(localTime,jack.getRentEndDateHour().getHour());
    }

    @Test
    public void rentalByWeek(){
        int localTime=LocalDateTime.now().plusWeeks(1).getHour();
        jack.setRentEndDateHour(LocalDateTime.now().plusDays(1));
        assertEquals(60d, jack.rent(rentalByWeek,1),0.0001);
        assertEquals(localTime,jack.getRentEndDateHour().getHour());
    }

    @Test
    public void rentalCountTest(){
        jack.rent(rentalByDay,3);
        assertEquals(3, jack.getRentalConunt(),0);

        lucy.rent(rentalByWeek,4);
        assertEquals(4, lucy.getRentalConunt(),0);
    }

    @Test
    public void priceTest(){
        jack.rent(rentalByDay,3);
        assertEquals(3, jack.getRentalConunt(),0);
        assertEquals(60d, jack.getPrice(), 0.0001);
        jack.rent(rentalByHour,1);
        assertEquals(65d, jack.getPrice(), 0.0001);

        lucy.rent(rentalByWeek,4);
        assertEquals(240d, lucy.getPrice(),0.0001);
    }

}
