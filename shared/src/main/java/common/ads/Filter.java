package common.ads;

/**
 * Created by Gelu on 16.01.14.
 */
public class Filter {

    private String city;

    private String district;

    private int priceMin;

    private int priceMax;

    private int pricePerMeterMin;

    private int pricePerMeterMax;


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
}
