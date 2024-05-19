package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Menu proporciona una interfaz para interactuar con el libro de
 * direcciones.
 */
public class Menu {
    private AddressBook addressBook;

    /**
     * Constructor que inicializa el menú con un libro de direcciones.
     * 
     * @param addressBook El libro de direcciones a gestionar.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Muestra las opciones del menú.
     */
    public void displayMenu() {
        System.out.println("\n=======================================");
        System.out.println("Elige una opción del menú\n");
        System.out.println("a) Cargar entradas desde un archivo");
        System.out.println("b) Agregar");
        System.out.println("c) Eliminar");
        System.out.println("d) Buscar");
        System.out.println("e) Mostrar");
        System.out.println("f) Guardar y Salir");
        System.out.println("=======================================");
    }

    /**
     * Carga entradas de dirección desde un archivo.
     * 
     * @param filename El nombre del archivo desde el cual cargar las entradas.
     */
    public void loadFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    AddressEntry entry = new AddressEntry(
                            parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                    addressBook.addAddressEntry(entry);
                }
            }
            System.out.println("Entradas cargadas desde el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + filename);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    /**
     * Agrega una nueva entrada de dirección a través de la entrada del usuario.
     */
    public void addEntry() {
        Scanner in = new Scanner(System.in);

        System.out.println("Agregar una nueva entrada:");
        System.out.print("Nombre: ");
        String firstName = in.nextLine();

        System.out.print("Apellido: ");
        String lastName = in.nextLine();

        System.out.print("Calle: ");
        String street = in.nextLine();

        System.out.print("Ciudad: ");
        String city = in.nextLine();

        System.out.print("Estado: ");
        String state = in.nextLine();

        System.out.print("Código Postal: ");
        String zip = in.nextLine();

        System.out.print("Correo electrónico: ");
        String email = in.nextLine();

        System.out.print("Teléfono: ");
        String phone = in.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        addressBook.addAddressEntry(entry);
        System.out.println("Entrada agregada.");
    }

    /**
     * Elimina una entrada de dirección especificada por el usuario.
     */
    public void deleteEntry() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingresa el nombre del contacto que deseas eliminar: ");

        String firstName = in.nextLine();
        List<AddressEntry> entries = addressBook.searchAddressEntries(firstName);
        if (entries.isEmpty()) {
            System.out.println("No se encontraron contactos con el nombre ingresado.");
            return;
        }

        System.out.println("Contactos encontrados:");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ": " + entries.get(i));
        }

        System.out.print("Ingresa el número del contacto que deseas eliminar: ");
        int index = in.nextInt();
        if (index > 0 && index <= entries.size()) {
            addressBook.removeAddressEntry(entries.get(index - 1));
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    /**
     * Busca entradas de dirección según el nombre proporcionado por el usuario.
     */
    public void searchEntries() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa nombre del contacto: ");
        String firstName = in.nextLine();
        List<AddressEntry> entries = addressBook.searchAddressEntries(firstName);
        if (entries.isEmpty()) {
            System.out.println("No se encontraron contactos.");
        } else {
            System.out.println("Contactos encontrados:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Muestra todas las entradas de dirección en el libro de direcciones.
     */
    public void showEntries() {
        List<AddressEntry> entries = addressBook.getAllAddressEntries();
        if (entries.isEmpty()) {
            System.out.println("No hay contactos en la libreta.");
        } else {
            System.out.println("Lista de contactos:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
                System.out.println();
            }
        }
    }

    /**
     * Guarda todas las entradas de dirección en un archivo y sale del programa.
     * 
     * @param filename El nombre del archivo donde se guardarán las entradas.
     */
    public void saveAndQuit(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (AddressEntry entry : addressBook.getAllAddressEntries()) {
                writer.println(entry.getFirstName() + "," +
                        entry.getLastName() + "," +
                        entry.getStreet() + "," +
                        entry.getCity() + "," +
                        entry.getState() + "," +
                        entry.getZip() + "," +
                        entry.getEmail() + "," +
                        entry.getPhone());
            }
            System.out.println("Entradas guardadas en la libreta de direcciones.");
        } catch (IOException e) {
            System.out.println("Error al guardar en la libreta de direcciones: " + e.getMessage());
        }
    }
}
