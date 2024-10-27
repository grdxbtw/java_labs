class Premises {
    private String name;
    private String address;
    private double area;

    public Premises(String name, String address, double area) {
        this.name = name;
        this.address = address;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public String getPremisesInfo() {
        return "Premises: " + name + ", Address: " + address + ", Area: " + area + " sq.m.";
    }
}

class Apartment extends Premises {
    public Apartment(String name, String address, double area) {
        super(name, address, area);
    }
}

class Office extends Premises {
    public Office(String name, String address, double area) {
        super(name, address, area);
    }
}


class Building {

    private Premises[] premises;

    public Building(Premises[] premises) {
        this.premises = premises;
    }


    public int getApartmentCount() {
        int count = 0;
        for (Premises p : premises) {
            if (p instanceof Apartment) {
                count++;
            }
        }
        return count;
    }


    public int getOfficeCount() {
        int count = 0;
        for (Premises p : premises) {
            if (p instanceof Office) {
                count++;
            }
        }
        return count;
    }


    public void printPremisesInfo() {
        for (Premises p : premises) {
            System.out.println(p.getPremisesInfo());
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Premises[] premises = {
                new Apartment("Apartment 1", "Address of apart1", 75),
                new Office("Office 1", "Address of office1", 120),
                new Apartment("Apartment 2", "Address of apart2", 85),
                new Office("Office 2", "Address of office2", 200),
                new Apartment("Apartment 3", "Address of apart2", 95)
        };


        Building building = new Building(premises);


        System.out.println("Number of apartments: " + building.getApartmentCount());
        System.out.println("Number of offices: " + building.getOfficeCount());


        System.out.println("\nPremises details:");
        building.printPremisesInfo();
    }
}
