import org.junit.Before;
import org.junit.Test;

import addres.data.AddressBook;
import addres.data.AddressEntry;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook addressBook;
    private AddressEntry entry1;
    private AddressEntry entry2;
    private AddressEntry entry3;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        entry1 = new AddressEntry("Alejandro", "Martinez", "Corderos", "Minatitlan", "Veracruz", "62704",
                "alejandromartinezdecorderos@gmail.com", "9226666910");
        entry2 = new AddressEntry("Juan", "Garcia", "Teresa", "Coatzacoalcos", "Chiapas", "90001",
                "juangarcia@example.com", "9213211234");
        entry3 = new AddressEntry("Maria", "Lopez", "Av. Insurgentes", "Xalapa", "Veracruz", "91000",
                "marialopez@example.com", "9216549876");
    }

    @Test
    public void testAddAddressEntry() {
        addressBook.addAddressEntry(entry1);
        assertEquals(1, addressBook.getAllAddressEntries().size());
        assertEquals(entry1, addressBook.getAllAddressEntries().get(0));
    }

    @Test
    public void testRemoveAddressEntry() {
        addressBook.addAddressEntry(entry1);
        addressBook.removeAddressEntry(entry1);
        assertEquals(0, addressBook.getAllAddressEntries().size());
    }

    @Test
    public void testSearchAddressEntries() {
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);
        addressBook.addAddressEntry(entry3);

        List<AddressEntry> searchResult = addressBook.searchAddressEntries("Juan");
        assertEquals(1, searchResult.size());
        assertEquals(entry2, searchResult.get(0));
    }

    @Test
    public void testGetAllAddressEntries() {
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);
        addressBook.addAddressEntry(entry3);

        List<AddressEntry> allEntries = addressBook.getAllAddressEntries();
        assertEquals(3, allEntries.size());
        assertTrue(allEntries.contains(entry1));
        assertTrue(allEntries.contains(entry2));
        assertTrue(allEntries.contains(entry3));
    }
}
