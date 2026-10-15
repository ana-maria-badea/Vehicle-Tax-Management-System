public class Car extends Vehicle {
    private String fuel_type;
    private double emission;

    public Car(String plate_number, String maker, String model,
               String fuel_type, double emission) {
        super(plate_number, maker, model);

        setFuel_type(fuel_type);
        setEmission(emission);
    }

    public void setFuel_type(String fuel_type) {
        if (!"petrol".equals(fuel_type) &&
                !"diesel".equals(fuel_type) &&
                !"hybrid".equals(fuel_type))
            throw new IllegalArgumentException("Invalid fuel type");

        this.fuel_type = fuel_type;
    }

    public void setEmission(double emission) {
        if (!Double.isFinite(emission) || emission < 0)
            throw new IllegalArgumentException("Invalid emission");

        this.emission = emission;
    }

    @Override
    public double annual_taxes() {
        if (fuel_type.equals("petrol"))
            return 1.4 * emission;
        else if (fuel_type.equals("diesel"))
            return 1.8 * emission;
        else
            return 1.2 * emission;
    }
}