import java.util.Scanner;
import factories.*;
import model.*;
import strategies.TransportStrategy;

public class Main {

    // MAIN FILE CREATE THE routes
    // you can add routes in some ArrayList, sort it, group it etc
    // if you want Main.java to look cleaner, make some RouterController or RouteManager to create routes,
    // then create it in the main

    // you can read from database (check Route.java)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Route route = new Route();

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Create Route");
            System.out.println("2. Quit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid option!");
                continue;
            }

            // -------- SELECT CITY ----------
            System.out.println("\nChoose city:");
            System.out.println("1. Varna");
            System.out.println("2. Sofia");
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
                default:
                    System.out.println("Invalid city!");
                    continue;
            }

            // -------- INPUT DISTANCE AND SPEED ----------
            System.out.print("Enter distance (km): ");
            double distance = scanner.nextDouble();

            System.out.print("Enter speed (km/h): ");
            double speed = scanner.nextDouble();
            scanner.nextLine();

            // -------- SELECT TRANSPORT ----------
            System.out.println("\nChoose travel type:");
            System.out.println("1. Car");
            System.out.println("2. Bus");
            System.out.println("3. Bike");
            System.out.println("4. Walk");
            System.out.print("Enter choice: ");

            int transportChoice = scanner.nextInt();
            scanner.nextLine();

            TransportStrategy strategy = null;

            switch (transportChoice) {

                case 1: // CAR
                    System.out.print("Enter fuel consumption l/100km: ");
                    double gas = scanner.nextDouble();
                    scanner.nextLine();
                    strategy = factory.createCarStrategy(speed, distance, gas);
                    break;

                case 2:
                    try{
                        strategy = factory.createPTStrategy(speed, distance);
                        break;
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage);
                        continue;
                    }
                case 3:
                    strategy = factory.createBikeStrategy(speed, distance);
                    break;

                case 4:
                    strategy = factory.createWalkStrategy(speed, distance);
                    break;

                default:
                    System.out.println("Invalid transport method!");
                    continue;
            }

            // -------- PERFORM ACTION ----------
            route.setStrategy(strategy);
            route.travel();
            System.out.println("ETA: " + route.calculateETA() + " h");
            System.out.println("Cost: " + route.calculateCost() + " lv");

        }

        scanner.close();

    }

}

