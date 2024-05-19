package address.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase AddressBook gestiona una lista de entradas de direcciones.
 */
public class AddressBook {
    /**
     * Lista de entradas de direcciones.
     */
    private List<AddressEntry> entries;

    /**
     * Constructor que inicializa una nueva lista de entradas de direcciones.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Agrega una nueva entrada de dirección al libro de direcciones.
     * 
     * @param entry La entrada de dirección a agregar.
     */
    public void addAddressEntry(AddressEntry entry) {
        entries.add(entry);
    }

    /**
     * Elimina una entrada de dirección del libro de direcciones.
     * 
     * @param entry La entrada de dirección a eliminar.
     */
    public void removeAddressEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    /**
     * Busca entradas de dirección por nombre.
     * 
     * @param firstName El primer nombre a buscar.
     * @return Una lista de entradas de dirección que coinciden con el nombre.
     */
    public List<AddressEntry> searchAddressEntries(String firstName) {
        List<AddressEntry> result = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getFirstName().startsWith(firstName)) {
                result.add(entry);
            }
        }
        return result;
    }

    /**
     * Obtiene todas las entradas de dirección, ordenadas por el primer nombre.
     * 
     * @return Una lista de todas las entradas de dirección, ordenadas
     *         alfabéticamente por el primer nombre.
     */
    public List<AddressEntry> getAllAddressEntries() {
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);
        Collections.sort(sortedEntries, (e1, e2) -> e1.getFirstName().compareTo(e2.getLastName()));
        return sortedEntries;
    }
}
