package common.ads;

/**
 * Created by Gelu on 16.01.14.
 */
public class Filter {

    private String city;

    private String district;

    private String street;

    private int priceMin;

    private int priceMax;

    private int pricePerMeterMin;

    private int pricePerMeterMax;

    private double areaMin;

    private double areaMax;

    private int constructionYearMin;

    private int constructionYearMax;

    private int floorMin;

    private int floorMax;

    private int numFloorsMin;

    private int numFloorsMax;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public int getPricePerMeterMin() {
        return pricePerMeterMin;
    }

    public void setPricePerMeterMin(int pricePerMeterMin) {
        this.pricePerMeterMin = pricePerMeterMin;
    }

    public int getPricePerMeterMax() {
        return pricePerMeterMax;
    }

    public void setPricePerMeterMax(int pricePerMeterMax) {
        this.pricePerMeterMax = pricePerMeterMax;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumFloorsMax() {
        return numFloorsMax;
    }

    public void setNumFloorsMax(int numFloorsMax) {
        this.numFloorsMax = numFloorsMax;
    }

    public int getFloorMax() {
        return floorMax;
    }

    public void setFloorMax(int floorMax) {
        this.floorMax = floorMax;
    }

    public int getNumFloorsMin() {
        return numFloorsMin;
    }

    public void setNumFloorsMin(int numFloorsMin) {
        this.numFloorsMin = numFloorsMin;
    }

    public int getFloorMin() {
        return floorMin;
    }

    public void setFloorMin(int floorMin) {
        this.floorMin = floorMin;
    }

    public int getConstructionYearMax() {
        return constructionYearMax;
    }

    public void setConstructionYearMax(int constructionYearMax) {
        this.constructionYearMax = constructionYearMax;
    }

    public int getConstructionYearMin() {
        return constructionYearMin;
    }

    public void setConstructionYearMin(int constructionYearMin) {
        this.constructionYearMin = constructionYearMin;
    }

    public double getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(double areaMax) {
        this.areaMax = areaMax;
    }

    public double getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(double areaMin) {
        this.areaMin = areaMin;
    }
}
