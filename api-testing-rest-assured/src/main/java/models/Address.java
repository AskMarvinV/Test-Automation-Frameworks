package models;
public class Address extends AddressDetails {

    private String businessId;
    private String name;
    private AddressDetails address;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDetails getAddress() {
        return address;
    }

    public void setAddress(AddressDetails address) {
        this.address = address;
    }

}
