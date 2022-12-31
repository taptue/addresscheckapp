package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Address;

public class AddressServiceImpl implements AddressService {
    public static final String ADDRESS = "src/data/addresses.json";

    @Override
    public Address getPrettyPrintAddressById(String id) throws IOException {
        List<Address> addrList = getAllAddress();
        for (Address address : addrList) {
            if (address.getAddressId().equals(id)) {
                System.out.println(address.toString());
                return address;
            }
        }
        return null;
    }

    @Override
    public void printAddressOfType(String t) throws IOException {
        List<Address> addrList = getAllAddress();
        for (Address address : addrList) {
            if (address.getAddressType().get("code").equals(t)) {
                System.out.println(address.toString());
            }
        }
    }

    @Override
    public boolean validateAddress(Address address) {
        String regPostalCode = "^\\d+$";
        Pattern pattern = Pattern.compile(regPostalCode);

        if (address == null) {
            System.out.println("Address is null");
            return false;
        }

        HashMap<String, String> addrLineDetails = address.getAddressLineDetail();
        if (addrLineDetails == null || addrLineDetails.size() == 0) {
            return false;
        }

        String line1 = addrLineDetails.get("line1").toString();
        String line2 = addrLineDetails.get("line2").toString();
        if ((line1.isEmpty() && line2.isEmpty()) || (line1 == null && line2 == null)
                || (line1.isEmpty() && line2 == null) || (line1 == null && line2.isEmpty())) {
            return false;
        }

        String postalCode = (String) address.getPostalCode();
        if (!pattern.matcher(postalCode).matches()) {
            return false;
        }

        HashMap<String, String> province = address.getProvinceOrState();
        HashMap<String, String> country = address.getCountry();
        if (country.get("code").equals("ZA")) {
            if (province == null) {
                System.out.println("Province name is required. ");
                return false;
            }
            String provinceName = (String) province.get("name");
            if (provinceName == null || provinceName.isBlank()) {
                System.out.println("Province name is required. ");
                return false;
            }
        }

        System.out.println("Address is valid");
        return true;
    }

    @Override
    public List<Address> getAllAddress() throws IOException {
        ArrayList<Address> addreArrayList = new ArrayList<Address>();
        FileReader read = new FileReader(ADDRESS);
        JSONParser jsonP = new JSONParser();
        Object object = new Object();
        try {
            object = jsonP.parse(read);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) object;
        jsonArray.forEach(address -> addreArrayList.add(new Address((JSONObject) address)));

        return addreArrayList;

    }

    @Override
    public void printAllAddresses() throws IOException {

        List<Address> addrList = getAllAddress();
        for (Address address : addrList) {
            System.out.println(address.toString());
        }

    }

}
