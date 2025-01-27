import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentalSystem extends Customer {
    ArrayList<Car>carList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public RentalSystem(Car cars[]){
        Collections.addAll(carList, cars);
    }

    public void showCars(){
        int index=0;
        for(Car cars:carList){
            index++;
            System.out.println(index+" "+ cars);
        }
    }

    public void menu(){
        int choice =100;
        System.out.println("==========*** Welcome to the rental System ***==========");
        System.out.println("1]. Show All Cars. \t\t\t\t 2]. Show car on your Budget.");
        System.out.println("0].Exit");

        while(choice !=0){
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("All Cars List");
                    showCars();
                    System.out.println("Choose car of his index no.");
                    choice = sc.nextInt();
                    break;
            }
        }
    }

    public void getCustomerDetail(){

        String name = sc.nextLine();
    }
}
