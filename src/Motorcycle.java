public class Motorcycle extends Vehicle {
    private double engine_displacement;

    public Motorcycle(String plate_number, String maker, String model,
                      double engine_displacement) {
        super(plate_number, maker, model);
        setEngine_displacement(engine_displacement);
    }

    public void setEngine_displacement(double engine_displacement) {
        if (!Double.isFinite(engine_displacement) || engine_displacement < 0)
            throw new IllegalArgumentException("Invalid displacement");

        this.engine_displacement = engine_displacement;
    }

    @Override
    public double annual_taxes() {
        return 0.1 * engine_displacement;
    }
}