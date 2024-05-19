import org.junit.Before;
import org.junit.Test;

import address.data.AddressEntry;

import static org.junit.Assert.*;

public class AddressEntryTest {

    private AddressEntry entry;

    @Before
    public void setUp() {
        entry = new AddressEntry("Alejandro", "Martinez", "Corderos", "Minatitlan", "Veracruz", "62704",
                "alejandromartinezdecorderos@gmail.com",
                "9226666910");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Alejandro", entry.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        entry.setFirstName("Juan");
        assertEquals("Juan", entry.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Martinez", entry.getLastName());
    }

    @Test
    public void testSetLastName() {
        entry.setLastName("Garcia");
        assertEquals("Garcia", entry.getLastName());
    }

    @Test
    public void testGetStreet() {
        assertEquals("Corderos", entry.getStreet());
    }

    @Test
    public void testSetStreet() {
        entry.setStreet("Teresa");
        assertEquals("Teresa", entry.getStreet());
    }

    @Test
    public void testGetCity() {
        assertEquals("Minatitlan", entry.getCity());
    }

    @Test
    public void testSetCity() {
        entry.setCity("Coatzacoalcos");
        assertEquals("Coatzacoalcos", entry.getCity());
    }

    @Test
    public void testGetState() {
        assertEquals("Veracruz", entry.getState());
    }

    @Test
    public void testSetState() {
        entry.setState("Chiapas");
        assertEquals("Chiapas", entry.getState());
    }

    @Test
    public void testGetZip() {
        assertEquals("62704", entry.getZip());
    }

    @Test
    public void testSetZip() {
        entry.setZip("90001");
        assertEquals("90001", entry.getZip());
    }

    @Test
    public void testGetEmail() {
        assertEquals("alejandromartinezdecorderos@gmail.com", entry.getEmail());
    }

    @Test
    public void testSetEmail() {
        entry.setEmail("correodeejemplo@gmail.com");
        assertEquals("correodeejemplo@gmail.com", entry.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("9226666910", entry.getPhone());
    }

    @Test
    public void testSetPhone() {
        entry.setPhone("9213211234");
        assertEquals("9213211234", entry.getPhone());
    }

    @Test
    public void testToString() {
        String expected = "Nombre: Alejandro\nApellido: Martinez\nCalle: Corderos\nCiudad: Minatitlan\nEstado: Veracruz\nCódigo Postal: 62704\nCorreo electrónico: alejandromartinezdecorderos@gmail.com\nCorreo electrónico: 9226666910";
        assertEquals(expected, entry.toString());
    }
}
