package homeworks.HW.imitation_sql;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Man> manList = new ArrayList<>();

        List<Address> addressList = new ArrayList<>();

        Address address = new Address("Canada", "ldfl", "kal", 3, 200);
        Address address1 = new Address("US", "ldfl", "kal1", 45, 250);
        Address address2 = new Address("US", "ldfl", "kal12", 15, 340);
        Address address3 = new Address("Canada", "ldfl", "kal12", 17, 20000);

        Man man = new Man("adfl", "ldfl", 29, 2, address);
        Man man1 = new Man("zdfl1", "ldfl", 23, 4, address1);
        Man man2 = new Man("fdfl2", "ldfl", 23, 4, address2);
        Man man3 = new Man("mdfl3", "ldfl", 44, 1, address3);

        manList.add(man);
        manList.add(man1);
        manList.add(man2);
        manList.add(man3);

        addressList.add(address);
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);

        SqlService service = new SqlService();

        service.groupByCityAndStreetWithCondition(addressList, 23);
    }
}
