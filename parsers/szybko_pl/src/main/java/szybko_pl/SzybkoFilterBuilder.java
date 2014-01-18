package szybko_pl;

import common.ads.Filter;

/**
 * Created by Gelu on 16.01.14.
 */
public class SzybkoFilterBuilder {

    private static final String BASE_URL_FOR_SEARCHING = "http://szybko.pl/szukaj?only_content=1&prezentacja=lista&page=1";

    private String baseUrlWithCategory = "";

    private String city = "";

    private String district = "";

    private String priceMin = "";

    private String priceMax = "";

    private String pricePerMeterMin = "";

    private String pricePerMeterMax = "";

    private String areaMin = "";

    private String areaMax = "";

    private String constructionYearMin = "";

    private String constructionYearMax = "";

    private String floorMin = "";

    private String floorMax = "";

    private String numFloorsMin = "";

    private String numFloorsMax = "";

    private String estateType = "";

    private String transactionType = "";

    private String roomsNumMin = "";

    private String roomsNumMax = "";

    private String adType = "";

    private String advertiser = "";

    public SzybkoFilterBuilder(Filter filter){
        System.out.println(filter.getEstateType());
        System.out.println(filter.getTransactionType());
        buildBaseUrlWithCategory(filter);
        if(filter.getCity() != null && !filter.getCity().isEmpty())
            withCity(filter.getCity());
        if(filter.getDistrict() != null && !filter.getDistrict().isEmpty())
            withDistrict(filter.getDistrict());
        if(filter.getPriceMin() != null && !filter.getPriceMin().isEmpty())
            withPriceMin(filter.getPriceMin());
        if(filter.getPriceMax() != null && !filter.getPriceMax().isEmpty())
            withPriceMax(filter.getPriceMax());
        if(filter.getPricePerMeterMin() != null && !filter.getPricePerMeterMin().isEmpty())
            withPricePerMeterMin(filter.getPricePerMeterMin());
        if(filter.getPricePerMeterMax() != null && !filter.getPricePerMeterMax().isEmpty())
            withPricePerMeterMax(filter.getPricePerMeterMax());
        if(filter.getAreaMin() != null && !filter.getAreaMin().isEmpty())
            withAreaMin(filter.getAreaMin());
        if(filter.getAreaMax() != null && !filter.getAreaMax().isEmpty())
            withAreaMax(filter.getAreaMax());
        if(filter.getRoomsNumMin() != null && !filter.getRoomsNumMin().isEmpty())
            withRoomsNumMin(filter.getRoomsNumMin());
        if(filter.getRoomsNumMax() != null && !filter.getRoomsNumMax().isEmpty())
            withRoomsNumMax(filter.getRoomsNumMax());
        if(filter.getConstructionYearMin() != null && !filter.getConstructionYearMin().isEmpty())
            withConstructionYearMin(filter.getConstructionYearMin());
        if(filter.getConstructionYearMax() != null && !filter.getConstructionYearMax().isEmpty())
            withConstructionYearMax(filter.getConstructionYearMax());
        if(filter.getFloorMin() != null && !filter.getFloorMin().isEmpty())
            withFloorMin(filter.getFloorMin());
        if(filter.getFloorMax() != null && !filter.getFloorMax().isEmpty())
            withFloorMax(filter.getFloorMax());
        if(filter.getNumFloorsMin() != null && !filter.getNumFloorsMin().isEmpty())
            withNumFloorsMin(filter.getNumFloorsMin());
        if(filter.getNumFloorsMax() != null && !filter.getNumFloorsMax().isEmpty())
            withNumFloorsMax(filter.getNumFloorsMax());

    }

    private void buildBaseUrlWithCategory(Filter filter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BASE_URL_FOR_SEARCHING);
        if("Dom".equals(filter.getEstateType())){
            stringBuilder.append("&args[asset_category_text]=dom");
        }else{
            stringBuilder.append("&args[asset_category_text]=lokal+mieszkalny+%28mieszkanie%29");
        }
        if("Wynajem".equals(filter.getTransactionType())){
            stringBuilder.append("&args[transaction_type_text]=wynajem");
        } else{
            stringBuilder.append("&args[transaction_type_text]=sprzeda%C5%BC");
        }
        stringBuilder.append("&args[province_text_facet]=-");
        baseUrlWithCategory = stringBuilder.toString();

    }

    SzybkoFilterBuilder withRoomsNumMin(String roomsNumMin){
        this.roomsNumMin = "&args[num_rooms_value_from]=" + roomsNumMin;
        return this;
    }

    SzybkoFilterBuilder withRoomsNumMax(String roomsNumMax){
        this.roomsNumMax = "&args[num_rooms_value_to]=" + roomsNumMax;
        return this;
    }

//    SzybkoFilterBuilder withEstateType(String estateType){
//        this.estateType = "&args[floors_total_value_from]=" + estateType;
//        return this;
//    }

    SzybkoFilterBuilder withNumFloorsMin(String numFloorsMin){
        this.numFloorsMin = "&args[floors_total_value_from]=" + numFloorsMin;
        return this;
    }

    SzybkoFilterBuilder withNumFloorsMax(String numFloorsMax){
        this.numFloorsMax = "&args[floors_total_value_to]=" + numFloorsMax;
        return this;
    }

    SzybkoFilterBuilder withFloorMin(String floorMin){
        this.floorMin = "&args[floor_value_from]=" + floorMin;
        return this;
    }
    SzybkoFilterBuilder withFloorMax(String floorMax){
        this.floorMax = "&args[floor_value_to]=" + floorMax;
        return this;
    }

    SzybkoFilterBuilder withConstructionYearMin(String constructionYearMin){
        this.constructionYearMin = "&args[year_built_from]=" + constructionYearMin;
        return this;
    }
    SzybkoFilterBuilder withConstructionYearMax(String constructionYearMax){
        this.constructionYearMax = "&args[year_built_to]=" + constructionYearMax;
        return this;
    }

    SzybkoFilterBuilder withAreaMin(String areaMin){
        this.areaMin = "&args[area_size_from]=" + areaMin;
        return this;
    }
    SzybkoFilterBuilder withAreaMax(String areaMax){
        this.areaMax = "&args[area_size_to]=" + areaMax;
        return this;
    }

    SzybkoFilterBuilder withCity(String city) {
        this.city = "&args[place_text_facet]=" + city;
        return this;
    }

    SzybkoFilterBuilder withDistrict(String district) {
        this.district = "&args[quarter_text_facet]=" + district;
        return this;
    }

    SzybkoFilterBuilder withPriceMin(String priceMin) {
        this.priceMin = "&args[price_value_from]=" + priceMin;
        return this;
    }

    SzybkoFilterBuilder withPriceMax(String priceMax) {
        this.priceMax = "&args[price_value_to]=" + priceMax;
        return this;
    }

    SzybkoFilterBuilder withPricePerMeterMin(String pricePerMeterMin) {
        this.pricePerMeterMin = "&args[price_per_meter_from]=" + pricePerMeterMin;
        return this;
    }

    SzybkoFilterBuilder withPricePerMeterMax(String pricePerMeterMax) {
        this.pricePerMeterMax = "&args[price_per_meter_to]=" + pricePerMeterMax;
        return this;
    }

    String build() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(baseUrlWithCategory)
                .append(city)
                .append(district)
                .append(priceMin)
                .append(priceMax)
                .append(pricePerMeterMin)
                .append(pricePerMeterMax)
                .append(areaMin)
                .append(areaMax)
                .append(roomsNumMin)
                .append(roomsNumMax)
                .append(constructionYearMin)
                .append(constructionYearMax)
                .append(floorMin)
                .append(floorMax)
                .append(numFloorsMin)
                .append(numFloorsMax)
                .toString();

    }

}
