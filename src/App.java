import java.util.List;

import model.Address;
import service.AddressService;
import service.AddressServiceImpl;

public class App {

    public static void main(String[] args) throws Exception {
        AddressService addressService = new AddressServiceImpl();
        List<Address> addrList = addressService.getAllAddress();

        /*
         * Print all address
         */
        addressService.printAllAddresses();

        /*
         * Print address by ID
         */
        addressService.getPrettyPrintAddressById("1");
        addressService.getPrettyPrintAddressById("2");
        addressService.getPrettyPrintAddressById("3");

        /*
         * Print address of type physical, postal or business
         */
        addressService.printAddressOfType("5");
        addressService.printAddressOfType("2");
        addressService.printAddressOfType("1");

        /*
         * Validate all address
         */
        for (Address address : addrList) {
            addressService.validateAddress(address);
        }
    }

}
