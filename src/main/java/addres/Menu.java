package addres;

import addres.data.AddressBook;
import addres.data.AddressEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private AddressBook addressBook;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    // Métodos del menú
    public void displayMenu() {
        System.out.println("=======================================");
        System.out.println("Elige una opción del menú");
        System.out.println("a) Cargar entradas desde un archivo");
        System.out.println("b) Agregar");
        System.out.println("c) Eliminar");
        System.out.println("d) Buscar");
        System.out.println("e) Mostrar");
        System.out.println("f) Salir");
        System.out.println("=======================================");
    }

    public void loadFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    AddressEntry entry = new AddressEntry(
                            parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                    addressBook.addAddressEntry(entry);
                }
            }
            System.out.println("Entradas cargadas desde el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }

    public void addEntry() {
        Scanner in = new Scanner(System.in);

        System.out.println("Agregar una nueva entrada:");
        System.out.print("Nombre: ");
        String firstName = in.nextLine();

        System.out.print("Apellido: ");
        String lastname = in.nextLine();

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

        AddressEntry entry = new AddressEntry(firstName, lastname, street, city, state, zip, email, phone);
        addressBook.addAddressEntry(entry);
        System.out.println("Entrada agregada.");
    }

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
}
