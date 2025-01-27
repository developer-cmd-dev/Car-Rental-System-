public class Car {
  private String name;
    private String model;
    private int dayCharge;
    private String type;
    private boolean isAvailable;
    private String carId;

    public Car(String name,String model,int dayCharge,String type ,String id){
        this.name = name;
        this.model = model;
        this.dayCharge = dayCharge;
        this.type = type;
        this.carId = id;
        this.isAvailable = true;
    }



    public int calculatePrice(int days){
        return  days*dayCharge;
    }

    public String getName() {
        return name;
    }

    public String getCarId(){
        return carId;
    }

    public String getModel() {
        return model;
    }

    public int getDayCharge() {
        return dayCharge;
    }

    public String getType() {
        return type;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void rent(){
        isAvailable = false;
    }

    public void returnCar(){
        isAvailable = true;
    }



}
