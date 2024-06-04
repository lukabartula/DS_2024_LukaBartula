package homework3;

// entry in the phonebook.
public class Entry implements Comparable<Entry> {
    // attributes for each person.
    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    // initialization
    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    // This method returns a nicely formatted string representation of the entry.
    @Override
    public String toString(){
        return  "\nName: " + this.surname + ", " + this.name
                + "\nAddress: " + this.streetAddress
                + "\nCity: " + this.city
                + "\nPost Code: " + this.postcode
                + "\nCountry: " + this.country
                + "\nPhone Number: " + this.phoneNumber + "\n";
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // This overridden method is used to compare two entries. It first compares the surnames, and if they
    // are the same, it compares the names.
    @Override
    public int compareTo(Entry other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }
}