import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentalSystem  {
        private ArrayList<Car>carList;
        private ArrayList<Customer>customerList;
        private ArrayList<Rental>rentalList;

        public RentalSystem(){
            carList = new ArrayList<>();
            customerList = new ArrayList<>();
            rentalList = new ArrayList<>();
        }

        public void addCar(Car car){
            carList.add(car);
        }

        public void addCustomer(Customer customer){
            customerList.add(customer);
        }

        public void rentCar(Car car,Customer customer,int days){
            if(car.getIsAvailable()){
                car.rent();
                rentalList.add(new Rental(car,customer,days));
            }else{
                System.out.println("Car is not available.");
            }
        }

        public void returnCar(Car car){
            for(Rental rentalsData:rentalList){
                if(rentalsData.getCar() == car){
                    rentalList.remove(rentalsData);
                    car.returnCar();
                    System.out.println("Car return successfully");
                }else{
                    System.out.println("Car did not find.");
                }
            }
        }


        public void menu(){
            System.out.println("Welcome to the Car Rental Service.");
            int choice = 0;



        }

}
