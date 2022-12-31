package service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import model.Address;

public interface AddressService {
    Address getPrettyPrintAddressById(String addr) throws IOException;

    void printAllAddresses() throws IOException;

    void printAddressOfType(String t) throws IOException;

    boolean validateAddress(Address addr);

    List<Address> getAllAddress() throws IOException, ParseException;
}
