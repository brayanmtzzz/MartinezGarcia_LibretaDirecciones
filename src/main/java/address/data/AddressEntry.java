package address.data;

/**
 * Representa una entrada en el libro de direcciones.
 * Contiene la información de contacto de una persona.
 */
public class AddressEntry {
    // Atributos
    /**
     * El primer nombre de la persona.
     */
    private String firstName;

    /**
     * El apellido de la persona.
     */
    private String lastName;

    /**
     * La calle donde reside la persona.
     */
    private String street;

    /**
     * La ciudad donde reside la persona.
     */
    private String city;

    /**
     * El estado donde reside la persona.
     */
    private String state;

    /**
     * El código postal de la dirección de la persona.
     */
    private String zip;

    /**
     * El correo electrónico de la persona.
     */
    private String email;

    /**
     * El número de teléfono de la persona.
     */
    private String phone;

    /**
     * Constructor para crear una nueva entrada de dirección.
     * 
     * @param firstName El primer nombre de la persona.
     * @param lastName  El apellido de la persona.
     * @param street    La calle donde reside la persona.
     * @param city      La ciudad donde reside la persona.
     * @param state     El estado donde reside la persona.
     * @param zip       El código postal de la dirección de la persona.
     * @param email     El correo electrónico de la persona.
     * @param phone     El número de teléfono de la persona.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, String zip,
            String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    // Métodos getters y setters

    /**
     * Obtiene el primer nombre de la persona.
     * 
     * @return El primer nombre de la persona.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el primer nombre de la persona.
     * 
     * @param firstName El primer nombre de la persona.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene el apellido de la persona.
     * 
     * @return El apellido de la persona.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido de la persona.
     * 
     * @param lastName El apellido de la persona.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la calle donde reside la persona.
     * 
     * @return La calle donde reside la persona.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la calle donde reside la persona.
     * 
     * @param street La calle donde reside la persona.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtiene la ciudad donde reside la persona.
     * 
     * @return La ciudad donde reside la persona.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad donde reside la persona.
     * 
     * @param city La ciudad donde reside la persona.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtiene el estado donde reside la persona.
     * 
     * @return El estado donde reside la persona.
     */
    public String getState() {
        return state;
    }

    /**
     * Establece el estado donde reside la persona.
     * 
     * @param state El estado donde reside la persona.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtiene el código postal de la dirección de la persona.
     * 
     * @return El código postal de la dirección de la persona.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Establece el código postal de la dirección de la persona.
     * 
     * @param zip El código postal de la dirección de la persona.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return El correo electrónico de la persona.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico de la persona.
     * 
     * @param email El correo electrónico de la persona.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     * 
     * @return El número de teléfono de la persona.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece el número de teléfono de la persona.
     * 
     * @param phone El número de teléfono de la persona.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Método toString()

    /**
     * Devuelve una representación en cadena de la entrada de dirección.
     * 
     * @return Una cadena que contiene la información de la entrada de dirección.
     */
    @Override
    public String toString() {
        return "Nombre: " + firstName + "\nApellido: " + lastName + "\nCalle: " + street + "\nCiudad: "
                + city + "\nEstado: " + state + "\nCódigo Postal: " + zip + "\nCorreo electrónico: " + email
                + "\nTeléfono: " + phone;
    }
}
