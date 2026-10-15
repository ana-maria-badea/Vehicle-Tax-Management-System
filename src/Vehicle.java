public abstract class Vehicle {
    private String plate_number;
    private String maker;
    private String model;
    private Person owner;

    public Vehicle(String plate_number, String maker, String model) {
        this.plate_number = plate_number;
        this.maker = maker;
        this.model = model;
        this.owner = null;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public Person getOwner() {
        return owner;
    }

    void setOwner(Person owner) {
        this.owner = owner;
    }

    public void edit(String var, String new_value) {
        if ("maker".equals(var))
            maker = new_value;
        else if ("model".equals(var))
            model = new_value;
        else
            throw new IllegalArgumentException("Invalid field");
    }

    public abstract double annual_taxes();
}