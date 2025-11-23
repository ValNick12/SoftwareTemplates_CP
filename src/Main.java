import java.util.Scanner;
import factories.*;
import model.Route;
import model.Exceptions.NoBikeLanesException;
import model.Exceptions.NoPublicTransportException;
import model.Exceptions.TooLongToWalkException;
import strategies.TransportStrategy;


void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Route route = new Route();

    while (true) {

        System.out.println("\n--- MENU ---");
        System.out.println("1. Create Route");
        System.out.println("2. Quit");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 2) {
            System.out.println("Goodbye!");
            break;
        }

        if (choice != 1) {
            System.out.println("Invalid option!");
            continue;
        }

        // --- City selection ---
        System.out.println("\nChoose city:");
        System.out.println("1. Sungurlare");
        System.out.println("2. Sofia");
        System.out.println("3. Warsaw");
        System.out.print("Enter choice: ");

        int cityChoice = scanner.nextInt();
        scanner.nextLine();

        TransportFactory factory;

        switch (cityChoice) {
            case 1:
                factory = SungurlareTransportFactory.getInstance();
                break;
            case 2:
                factory = SofiaTransportFactory.getInstance();
                break;
            case 3:
                factory = WarsawTransportFactory.getInstance();
                break;
            default:
                System.out.println("Invalid city!");
                continue;
        }

        // --- Distance and speed input ---
        System.out.print("Enter distance (km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter speed (km/h): ");
        double speed = scanner.nextDouble();
        scanner.nextLine();

        // --- Transport Selection ---
        System.out.println("\nChoose travel type:");
        System.out.println("1. Car");
        System.out.println("2. Public Transport");
        System.out.println("3. Bike");
        System.out.println("4. Walk");
        System.out.print("Enter choice: ");

        int transportChoice = scanner.nextInt();
        scanner.nextLine();

        TransportStrategy strategy;

        switch (transportChoice) {
            case 1: // Car
                System.out.print("Enter fuel consumption l/100km: ");
                double gas = scanner.nextDouble();
                scanner.nextLine();

                strategy = factory.createCarStrategy(speed, distance, gas);
                break;

            case 2: // Public Transport
                strategy = factory.createPTStrategy(speed, distance);
                break;

            case 3: // Bike
                strategy = factory.createBikeStrategy(speed, distance);
                break;

            case 4: // Walk
                strategy = factory.createWalkStrategy(speed, distance);
                break;

            default:
                System.out.println("Invalid transport method!");
                continue;
        }


        // --- Travel action ---
        try {
            route.setStrategy(strategy);
            route.travel();
            System.out.println("Time to travel: " + route.calculateTime() + " h");
            System.out.println("Cost: " + route.calculateCost() + " lv");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    scanner.close();

}

