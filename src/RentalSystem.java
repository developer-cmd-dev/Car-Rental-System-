import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentalSystem {
    private ArrayList<Car> carList;
    private ArrayList<Customer> customerList;
    private ArrayList<Rental> rentalList;
    Scanner sc = new Scanner(System.in);

    public RentalSystem() {
        carList = new ArrayList<>();
        customerList = new ArrayList<>();
        rentalList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.getIsAvailable()) {
            car.rent();
            rentalList.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        for (Rental rentalsData : rentalList) {
            if (rentalsData.getCar() == car) {
                rentalList.remove(rentalsData);
                car.returnCar();
                System.out.println("Car return successfully");
            } else {
                System.out.println("Car did not find.");
            }
        }
    }

    public void showCar() {
        for (Car cars : carList) {
            System.out.println(cars.getCarId() + ".Car Name: " + cars.getName() + " Daily Charge: " + cars.getDayCharge());
        }
    }


    public void menu() {


        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\n== Rent a Car ==\n");
                System.out.print("Enter your name: ");
                String customerName = sc.nextLine();
                System.out.println("\nAvailable Cars:");
                for (Car cars : carList) {
                    if (cars.getIsAvailable()) {
                        System.out.println(cars.getCarId() + " - " + cars.getName() + " " + cars.getDayCharge());
                    }

                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = sc.nextLine();

                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Customer newCustomer = new Customer(customerName, customerList.size() + 1);
                    addCustomer(newCustomer);
                    Car selectedCar = null;
                    for (Car car : carList) {
                        if (car.getCarId().equals(carId) && car.getIsAvailable()) {
                            selectedCar = car;
                            break;
                        }

                    }

                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getName() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);

                        System.out.print("\nConfirm rental (Y/N): ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\nCar rented successfully.");
                            break;
                        } else {
                            System.out.println("\nRental canceled.");
                        }
                    } else {
                        System.out.println("\nInvalid car selection or car not available for rent.");
                    }


                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = sc.nextLine();
                Car carToReturn = null;
                for (Car cars : carList) {
                    if (cars.getCarId().equals(carId) && !cars.getIsAvailable()) {
                        carToReturn = cars;
                        break;
                    }
                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentalList) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by " + customer.getName());
                        } else {
                            System.out.println("Car was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid car ID or car is not rented.");
                    }
                }
            } else if (choice == 3) {
                break;
            }else{
                System.out.println("Invalid Choice");
            }


        }
    }
    }
