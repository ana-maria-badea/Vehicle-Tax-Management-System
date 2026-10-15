import java.util.ArrayList;

public class Sys {
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void add(Person person) {
        if (person == null)
            throw new IllegalArgumentException("Invalid person");

        if (searchPerson(person.getLicense_number()) != null)
            throw new IllegalArgumentException("Person already exists");

        persons.add(person);
    }

    public void add(Vehicle vehicle) {
        if (vehicle == null)
            throw new IllegalArgumentException("Invalid vehicle");

        if (searchVehicle(vehicle.getPlate_number()) != null)
            throw new IllegalArgumentException("Vehicle already exists");

        vehicles.add(vehicle);
    }

    public Person searchPerson(String license_number) {
        for (Person p : persons) {
            if (p.getLicense_number().equals(license_number))
                return p;
        }
        return null;
    }

    public Vehicle searchVehicle(String plate_number) {
        for (Vehicle v : vehicles) {
            if (v.getPlate_number().equals(plate_number))
                return v;
        }
        return null;
    }

    public void editPerson(String license_number, String var, String new_value) {
        Person p = searchPerson(license_number);

        if (p == null)
            throw new IllegalArgumentException("Person not found");

        p.edit(var, new_value);
    }

    public void editVehicle(String plate_number, String var, String new_value) {
        Vehicle v = searchVehicle(plate_number);

        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");

        v.edit(var, new_value);
    }

    public void editCar(String plate_number, String fuel_type, double emission) {
        Vehicle v = searchVehicle(plate_number);

        if (!(v instanceof Car))
            throw new IllegalArgumentException("Car not found");

        Car c = (Car) v;
        c.setFuel_type(fuel_type);
        c.setEmission(emission);
    }

    public void editMotorcycle(String plate_number, double displacement) {
        Vehicle v = searchVehicle(plate_number);

        if (!(v instanceof Motorcycle))
            throw new IllegalArgumentException("Motorcycle not found");

        Motorcycle m = (Motorcycle) v;
        m.setEngine_displacement(displacement);
    }

    public void deletePerson(String license_number) {
        Person p = searchPerson(license_number);

        if (p == null)
            throw new IllegalArgumentException("Person not found");

        for (Vehicle v : vehicles) {
            if (v.getOwner() == p)
                throw new IllegalArgumentException("Person still owns vehicles");
        }

        persons.remove(p);
    }

    public void deleteVehicle(String plate_number) {
        Vehicle v = searchVehicle(plate_number);

        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");

        vehicles.remove(v);
        v.setOwner(null);
    }

    public void transferVehicle(String plate_number, String license_number) {
        Vehicle v = searchVehicle(plate_number);

        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");

        if (license_number == null) {
            v.setOwner(null);
            return;
        }

        Person p = searchPerson(license_number);

        if (p == null)
            throw new IllegalArgumentException("Person not found");

        v.setOwner(p);
    }

    public void annualTaxReport() {
        System.out.println("ANNUAL TAX REPORT");

        for (Person p : persons) {
            double total = 0;

            System.out.println();
            System.out.println(p.getName() + " " + p.getSurname());

            for (Vehicle v : vehicles) {
                if (v.getOwner() == p) {
                    double tax = v.annual_taxes();

                    System.out.println(v.getPlate_number() + ": " + tax + " EUR");
                    total += tax;
                }
            }

            System.out.println("Total: " + total + " EUR");
        }
    }
}