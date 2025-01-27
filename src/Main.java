

public class Main {


    public static void main(String[] args) {
        Car marutiSuzuikiAlto = new Car("Maruti Suzuki Alto","2023",500,"Hatchback","C001");
        Car HyundaiGrandi10Nios = new Car("Hyundai Grand i10 Nios","2023",700,"Hatchback","C002");
        Car TataTiago = new Car("Tata Tiago","2023",600,"Hatchback","C003");
        RentalSystem rentalSystem = new RentalSystem();
        rentalSystem.addCar(marutiSuzuikiAlto);
        rentalSystem.addCar(HyundaiGrandi10Nios);
        rentalSystem.addCar(TataTiago);
        rentalSystem.menu();




    }
}