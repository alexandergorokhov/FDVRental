public class FamilyDiscount extends Discount {

   private  boolean validateDiscount(Person person){
        return (person.getRentalConunt()>=3 && person.getRentalConunt()<=5);
    }

    public double applyGetDiscountPrice(Person person){
        if(this.validateDiscount(person)){
            return (person.getPrice()/100)*70;
        }
    return person.getPrice();
    }
}
