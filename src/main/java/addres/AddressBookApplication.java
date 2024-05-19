package addres;

import addres.data.AddressBook;

import java.util.Scanner;

public class AddressBookApplication {
    private static AddressBook addressBook = new AddressBook();
    private static Menu menu = new Menu(addressBook);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            menu.displayMenu();
            String choice = in.nextLine();
            switch (choice) {
                case "a":
                    System.out.print("Ingresa el nombre del archivo: ");
                    String filename = in.nextLine();
                    menu.loadFromFile(filename);
                    break;
                case "b":
                    menu.addEntry();
                    break;
                case "c":
                    menu.deleteEntry();
                    break;
                case "d":
                    menu.searchEntries();
                    break;
                case "e":
                    menu.showEntries();
                    break;
                case "f":
                    running = false;
                    break;
                default:
                    System.out.println("Ingresa una opción válida.\n");
            }
        }
    }
}