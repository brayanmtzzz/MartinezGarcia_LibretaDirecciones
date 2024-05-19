import address.Menu;
import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    private AddressBook addressBook;
    private Menu menu;
    private AddressEntry entry1;
    private AddressEntry entry2;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
        entry1 = new AddressEntry("Alejandro", "Martinez", "Corderos", "Minatitlan", "Veracruz", "62704",
                "alejandromartinezdecorderos@gmail.com", "9226666910");
        entry2 = new AddressEntry("Juan", "Garcia", "Teresa", "Coatzacoalcos", "Chiapas", "90001",
                "juangarcia@example.com", "9213211234");
    }

    @Test
    public void testAddEntry() {
        String simulatedInput = "Maria\nLopez\nAv. Insurgentes\nXalapa\nVeracruz\n91000\nmarialopez@example.com\n9216549876\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        menu.addEntry();

        List<AddressEntry> entries = addressBook.getAllAddressEntries();
        assertEquals(1, entries.size());
        AddressEntry addedEntry = entries.get(0);
        assertEquals("Maria", addedEntry.getFirstName());
        assertEquals("Lopez", addedEntry.getLastName());
        assertEquals("Av. Insurgentes", addedEntry.getStreet());
        assertEquals("Xalapa", addedEntry.getCity());
        assertEquals("Veracruz", addedEntry.getState());
        assertEquals("91000", addedEntry.getZip());
        assertEquals("marialopez@example.com", addedEntry.getEmail());
        assertEquals("9216549876", addedEntry.getPhone());

        System.setIn(originalIn);
    }

    @Test
    public void testDeleteEntry() {
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);

        String simulatedInput = "Juan\n1\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        menu.deleteEntry();

        List<AddressEntry> entries = addressBook.getAllAddressEntries();
        assertEquals(1, entries.size());
        assertFalse(entries.contains(entry2));

        System.setIn(originalIn);
    }

    @Test
    public void testSearchEntries() {
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);

        String simulatedInput = "Juan\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        menu.searchEntries();

        List<AddressEntry> searchResults = addressBook.searchAddressEntries("Juan");
        assertEquals(1, searchResults.size());
        assertEquals(entry2, searchResults.get(0));

        System.setIn(originalIn);
    }

    @Test
    public void testShowEntries() {
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);

        menu.showEntries();

        List<AddressEntry> entries = addressBook.getAllAddressEntries();
        assertEquals(2, entries.size());
        assertTrue(entries.contains(entry1));
        assertTrue(entries.contains(entry2));
    }
}
