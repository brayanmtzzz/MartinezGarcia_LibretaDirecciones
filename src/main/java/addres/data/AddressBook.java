package addres.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    // Método para agregar, elinminar, buscar y mostrar todas las entradas
    public void addAddressEntry(AddressEntry entry) {
        entries.add(entry);
    }

    public void removeAddressEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    public List<AddressEntry> searchAddressEntries(String firstName) {
        List<AddressEntry> result = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getFirstName().startsWith(firstName)) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<AddressEntry> getAllAddressEntries() {
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);
        Collections.sort(sortedEntries, (e1, e2) -> e1.getFirstName().compareTo(e2.getLastName()));
        return sortedEntries;
    }
}
