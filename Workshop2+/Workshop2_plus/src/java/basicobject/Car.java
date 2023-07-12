package basicobject;

public class Car {

    private String id;
    private String name;
    private String description;
    private float price;
    private int speed;
    private boolean status;

    public Car() {
    }

    public Car(String id, String name, String description, float price, int speed, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.speed = speed;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
