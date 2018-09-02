package del;

public class Contact {

    public static void main(String[] args) {

        Contact contact = new ContactBuilder().setAddress("Krakow").build();


        ContactBuilder c = new ContactBuilder().setAddress("d") ;

        System.out.println(contact.address);
        System.out.println(contact);
    }


    private Contact(ContactBuilder contactBuilder) {

        this.name = contactBuilder.getName();
        this.surname = contactBuilder.getSurname();
        this.address = contactBuilder.getAddress();
        this.phone = contactBuilder.getPhone();

    }


    private String name;
    private String surname;
    private String address;
    private int phone;

    public static class ContactBuilder {

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getAddress() {
            return address;
        }

        public int getPhone() {
            return phone;
        }

        private String name;
        private String surname;
        private String address;
        private int phone;


        public ContactBuilder setName(final String name) {

            this.name = name;
            return this;

        }

        public ContactBuilder setSurname(final String surname) {

            this.surname = surname;
            return this;

        }

        public ContactBuilder setAddress(final String address) {

            this.address = address;
            return this;

        }

        public ContactBuilder setPhone(final int phone) {

            this.phone = phone;
            return this;

        }

        public Contact build() {
            return new Contact(this);
        }


    }

}
