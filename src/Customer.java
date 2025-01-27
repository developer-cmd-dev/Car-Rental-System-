public class Customer {
    private String name;
    private int age;
    private String address;
    private int id;

    public  Customer(String name,int age,String address,int id){
        this.name= name;
        this.address=address;
        this.age = age;
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
