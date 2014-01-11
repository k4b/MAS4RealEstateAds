package common.ads;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 * Instance of ad. All fields are optional.
 * @author Karol Abramczyk
 */
public class Ad {
    /**
     * Holds the number of all created ads. Used for ad ID assignment.
     */
    public static int adsCount = 0;
    
    /**
     * Ad unique ID
     */
    private int ID;
    
    /**
     * Ad title
     */
    private String title;
    
    /**
     * Ad description
     */
    private String description;
    
    /**
     * City, where advertised property is located.
     */
    private String city;
    
    /**
     * District of city, where advertised property is located.
     */
    private String district;
    
    /**
     * Street, where advertised property is located.
     */
    private String street;
    
    /**
     * Price of the advertised property
     */
    private int price;
    
    /**
     * Price per meter of advertised property
     */
    private int pricePerMeter;
    
    /**
     * Number of bedrooms
     */
    private int numBedrooms;
    
    /**
     * Number of bathrooms
     */
    private int numBathrooms;
    
    /**
     * Floor number
     */
    private int floor;
    
    /**
     * Area of the advertised property in square meters
     */
    private double area;
    
    /**
     * Date of ad last update
     */
    private Date lastUpdate;
    
    /**
     * Date of the ad creation
     */
    private Date creationDate;
    
    /**
     * Year of building construction
     */
    private int constructionYear;
    
    /**
     * Number of floors in the building
     */
    private int numFloors;
    
    /**
     * Direct link to this advertisement
     */
    private String link;    

    /**
     * Creates Ad, increments number of all ads, and assigns ID to this Ad
     */
    public Ad() {
        Ad.adsCount++;
        this.ID = Ad.adsCount;
    }
    
    /**
     * Returns parameters of this Ad as a string
     */
    @Override
    public String toString() {
        String out = "";
        out += "ID :" + ID + AdsConstants.NEWLINE 
                + "title : " + title + AdsConstants.NEWLINE 
                + "price : " + price + AdsConstants.NEWLINE
                + "price/m2 : " + pricePerMeter + AdsConstants.NEWLINE
                + "area : " + area + AdsConstants.NEWLINE
                + "city : " + city + AdsConstants.NEWLINE
                + "district : " + district + AdsConstants.NEWLINE
                + "street : " + street + AdsConstants.NEWLINE
                + "rooms : " + numBedrooms + AdsConstants.NEWLINE
                + "bathrooms : " + numBathrooms + AdsConstants.NEWLINE
                + "floor : " + floor + AdsConstants.NEWLINE
                + "floors in building : " + numFloors + AdsConstants.NEWLINE
                + "construction year : " + constructionYear + AdsConstants.NEWLINE
                + "description : " + description + AdsConstants.NEWLINE
                + "link : " + link + AdsConstants.NEWLINE;
        
        return out;
    }

    /**
     * Returns unique ID of this ad
     * @return ad ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Sets ad ID
     * @param ID new ID of the ad
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Returns ad title
     * @return ad title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(int pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return date of creation of the ad
     */
    public Date getCreationDate() {
      return creationDate;
    }

    /**
     * @param creationDate the date to set
     */
    public void setCreationDate(Date creationDate) {
      this.creationDate = creationDate;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
