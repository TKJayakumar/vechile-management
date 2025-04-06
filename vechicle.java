
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    String model;
    String plateNumber;
    boolean isRented;

    public Vehicle(String model, String plateNumber) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.isRented = false;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " with plate number " + plateNumber + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " was not rented.");
        }
    }

    @Override
    public String toString() {
        return model + " (Plate: " + plateNumber + ") - " + (isRented ? "Rented" : "Available");
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Toyota Camry", "ABC123"));
        vehicles.add(new Vehicle("Honda Accord", "XYZ789"));
        vehicles.add(new Vehicle("Ford Focus", "DEF456"));

        while (true) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. View Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i));
                    }
                    break;
                case 2:
                    System.out.print("Enter vehicle number to rent: ");
                    int rentChoice = scanner.nextInt();
                    if (rentChoice >= 1 && rentChoice <= vehicles.size()) {
                        vehicles.get(rentChoice - 1).rent();
                    } else {
                        System.out.println("Invalid selection!");
                    }
                    break;
                case 3:
                    System.out.print("Enter vehicle number to return: ");
                    int returnChoice = scanner.nextInt();
                    if (returnChoice >= 1 && returnChoice <= vehicles.size()) {
                        vehicles.get(returnChoice - 1).returnVehicle();
                    } else {
                        System.out.println("Invalid selection!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
        scanner.close();
    }
}
