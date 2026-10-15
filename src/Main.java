public class Main {
    public static void main(String[] args) {
        Sys system = new Sys();

        Person p1 = new Person("L1", "Ana", "Popescu", "Barcelona");
        Person p2 = new Person("L2", "Maria", "Ionescu", "Madrid");
        Person p3 = new Person("L3", "Alex", "Marin", "Valencia");

        system.add(p1);
        system.add(p2);
        system.add(p3);

        Car c1 = new Car("B123ABC", "BMW", "320", "diesel", 120);
        Car c2 = new Car("B456DEF", "Toyota", "Prius", "hybrid", 80);
        Motorcycle m1 = new Motorcycle("M123ABC", "Yamaha", "MT07", 689);

        system.add(c1);
        system.add(c2);
        system.add(m1);

        system.transferVehicle("B123ABC", "L1");
        system.transferVehicle("B456DEF", "L1");
        system.transferVehicle("M123ABC", "L2");

        system.annualTaxReport();

        // Transfer a car to another person
        system.transferVehicle("B123ABC", "L2");

        // Edit a person and vehicles
        system.editPerson("L1", "address", "New Address");
        system.editVehicle("B123ABC", "model", "320d");
        system.editCar("B456DEF", "hybrid", 75);
        system.editMotorcycle("M123ABC", 700);


        // Delete a person without vehicles
        system.deletePerson("L3");

        System.out.println("\nAFTER CHANGES");
        system.annualTaxReport();

        // Remove the owner of a vehicle
        system.transferVehicle("B123ABC", null);

        // Delete the vehicle
        system.deleteVehicle("B123ABC");
    }
}