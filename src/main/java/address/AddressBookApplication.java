package address;

import address.data.AddressBook;

import java.util.Scanner;

/**
 * La clase AddressBookApplication es la aplicación principal que gestiona la
 * interacción del usuario con el libro de direcciones.
 */
public class AddressBookApplication {
    private static AddressBook addressBook = new AddressBook();
    private static Menu menu = new Menu(addressBook);

    /**
     * El método principal que inicia la aplicación de la libreta de direcciones.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en esta
     *             aplicación).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        String addressbook = "addressbook.txt";

        // Cargar las entradas desde un archivo al iniciar la aplicación
        menu.loadFromFile(addressbook);

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
                    menu.saveAndQuit(addressbook);
                    running = false;
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Ingresa una opción válida.\n");
            }
        }
    }
}
