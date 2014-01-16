package common.ads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gelu on 16.01.14.
 */
public class Filter {

    private String city;

    private String district;

    private String street;

    private String priceMin;

    private String priceMax;

    private String pricePerMeterMin;

    private String pricePerMeterMax;

    private String areaMin;

    private String areaMax;

    private String constructionYearMin;

    private String constructionYearMax;

    private String floorMin;

    private String floorMax;

    private String numFloorsMin;

    private String numFloorsMax;
    
    private String estateType;
    
    private String transactionType;
    
    private String roomsNumMin;
    
    private String roomsNumMax;
    
    private String adType;
    
    private String advertiser;
    
    public Filter() {
    }


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

    public String getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }

    public String getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    public String getPricePerMeterMin() {
        return pricePerMeterMin;
    }

    public void setPricePerMeterMin(String pricePerMeterMin) {
        this.pricePerMeterMin = pricePerMeterMin;
    }

    public String getPricePerMeterMax() {
        return pricePerMeterMax;
    }

    public void setPricePerMeterMax(String pricePerMeterMax) {
        this.pricePerMeterMax = pricePerMeterMax;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumFloorsMax() {
        return numFloorsMax;
    }

    public void setNumFloorsMax(String numFloorsMax) {
        this.numFloorsMax = numFloorsMax;
    }

    public String getFloorMax() {
        return floorMax;
    }

    public void setFloorMax(String floorMax) {
        this.floorMax = floorMax;
    }

    public String getNumFloorsMin() {
        return numFloorsMin;
    }

    public void setNumFloorsMin(String numFloorsMin) {
        this.numFloorsMin = numFloorsMin;
    }

    public String getFloorMin() {
        return floorMin;
    }

    public void setFloorMin(String floorMin) {
        this.floorMin = floorMin;
    }

    public String getConstructionYearMax() {
        return constructionYearMax;
    }

    public void setConstructionYearMax(String constructionYearMax) {
        this.constructionYearMax = constructionYearMax;
    }

    public String getConstructionYearMin() {
        return constructionYearMin;
    }

    public void setConstructionYearMin(String constructionYearMin) {
        this.constructionYearMin = constructionYearMin;
    }

    public String getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(String areaMax) {
        this.areaMax = areaMax;
    }

    public String getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(String areaMin) {
        this.areaMin = areaMin;
    }

    /**
     * @return the types
     */
    public String getEstateType() {
      return estateType;
    }

    /**
     * @param types the types to set
     */
    public void setEstateType(String type) {
      this.estateType = type;
    }


    /**
     * @return the transactionType
     */
    public String getTransactionType() {
      return transactionType;
    }


    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
    }


    /**
     * @return the roomsNumMin
     */
    public String getRoomsNumMin() {
      return roomsNumMin;
    }


    /**
     * @param roomsNumMin the roomsNumMin to set
     */
    public void setRoomsNumMin(String roomsNumMin) {
      this.roomsNumMin = roomsNumMin;
    }


    /**
     * @return the roomsNumMax
     */
    public String getRoomsNumMax() {
      return roomsNumMax;
    }


    /**
     * @param roomsNumMax the roomsNumMax to set
     */
    public void setRoomsNumMax(String roomsNumMax) {
      this.roomsNumMax = roomsNumMax;
    }


    /**
     * @return the adType
     */
    public String getAdType() {
      return adType;
    }


    /**
     * @param adType the adType to set
     */
    public void setAdType(String adType) {
      this.adType = adType;
    }


    /**
     * @return the advertiser
     */
    public String getAdvertiser() {
      return advertiser;
    }


    /**
     * @param advertiser the advertiser to set
     */
    public void setAdvertiser(String advertiser) {
      this.advertiser = advertiser;
    }
}
