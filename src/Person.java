public class Person {
    private String license_number;
    private String name;
    private String surname;
    private String address;

    public Person(String license_number, String name, String surname, String address) {
        this.license_number = license_number;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getLicense_number() {
        return license_number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void edit(String var, String new_value) {
        if ("name".equals(var))
            name = new_value;
        else if ("surname".equals(var))
            surname = new_value;
        else if ("address".equals(var))
            address = new_value;
        else
            throw new IllegalArgumentException("Invalid field");
    }
}