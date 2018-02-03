import java.time.LocalDateTime;

public class Person {
    private  Integer rentalConunt;
    private LocalDateTime rentEndDateHour;
    private String id;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

   public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRentEndDateHour() {
        return rentEndDateHour;
    }

    public void setRentEndDateHour(LocalDateTime rentEndDateHour) {
        this.rentEndDateHour = rentEndDateHour;
    }

    public Person() {
        this.rentalConunt = 0;
        this.price = 0d;
        this.id = "Initial Id";
    }

    public Integer getRentalConunt() {

        return rentalConunt;
    }

    private  void incrementRental(int numberRents){
        this.rentalConunt += numberRents;
    }

    public double rent( Rental rental, int numberRents){
        incrementRental(numberRents);
        incrementPrice(rental.getCost()*numberRents);
        return rental.getCost()*numberRents;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id != null ? id.equals(person.id) : person.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void incrementPrice(Double price) {
        this.price += price;
    }
}
