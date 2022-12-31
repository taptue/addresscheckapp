package model;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Address {
    private String addressId;
    private HashMap<String, String> addressLineDetail;
    private HashMap<String, String> addressType;
    private HashMap<String, String> provinceOrState;
    private HashMap<String, String> country;
    private String cityOrTown;
    private String postalCode;
    private String lastUpdated;

    public Address(JSONObject jsonObject) {
        addressId = (String) jsonObject.get("id");
        addressType = (HashMap<String, String>) jsonObject.get("type");
        addressLineDetail = (HashMap<String, String>) jsonObject.get("addressLineDetail");
        provinceOrState = (HashMap<String, String>) jsonObject.get("provinceOrState");
        country = (HashMap<String, String>) jsonObject.get("country");
        cityOrTown = (String) jsonObject.get("cityOrTown");
        postalCode = (String) jsonObject.get("postalCode");
        lastUpdated = (String) jsonObject.get("lastUpdated");
    }

    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public HashMap<String, String> getAddressType() {
        return this.addressType;
    }

    public void setAddressType(HashMap<String, String> addressType) {
        this.addressType = addressType;
    }

    public HashMap<String, String> getAddressLineDetail() {
        return this.addressLineDetail;
    }

    public void setAddressLineDetail(HashMap<String, String> addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public HashMap<String, String> getProvinceOrState() {
        return this.provinceOrState;
    }

    public void setProvinceOrState(HashMap<String, String> provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public HashMap<String, String> getCountry() {
        return this.country;
    }

    public void setCountry(HashMap<String, String> country) {
        this.country = country;
    }

    public String getCityOrTown() {
        return this.cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return " \t addressId='" + getAddressId() + "'" + ", \n\t addressLineDetail='" + getAddressLineDetail() + "'" +
                ", \n\t addressType='" + getAddressType() + "'" +
                ", \n\t provinceOrState='" + getProvinceOrState() + "'" +
                ", \n\t country='" + getCountry() + "'" +
                ", \n\t cityOrTown='" + getCityOrTown() + "'" +
                ", \n\t postalCode='" + getPostalCode() + "'" +
                ", \n\t lastUpdated='" + getLastUpdated() + "\n" +
                "*************************************************";
    }

}
