public class Rental {
    private Car car ;
    private Customer customer ;
    private int days;

    public Rental(Car car,Customer customer,int days){
        this.car = car;
        this.customer = customer;
        this.days= days;
    }

    public Car getCar(){
        return car;
    }


    public void rentalSlip(){
        System.out.println("Name: "+customer.getName());
        System.out.println("Address: "+customer.getAddress());
        System.out.println("Age: "+customer.getAge());
        System.out.println("Car Name: "+car.getName());
        System.out.println("Car Model: "+car.getModel());
        System.out.println("Charge you will have to pay: "+car.calculatePrice(days));
    }


}
