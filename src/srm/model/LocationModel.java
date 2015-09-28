package srm.model;

public class LocationModel {
    private int id;
    private String name;
    private String description;
    private String phone;
    private String head;
    private String city;
    private String country;
    private double timezone;
    public LocationModel(int id, String name, String desc, String phone, String head, String city, String country, double tz)
    {
        this.id=id;
        this.name=name;
        this.description=desc;
        this.phone=phone;
        this.head=head;
        this.city=city;
        this.country=country;
        this.timezone=tz;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTimezone() {
        return timezone;
    }

    public void setTimezone(double timezone) {
        this.timezone = timezone;
    }
    
}
