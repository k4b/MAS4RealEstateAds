package szybko_pl;

/**
 * Created by Gelu on 16.01.14.
 */
public class SzybkoFilterBuilder {

    private static final String baseUrlForSearching = "http://szybko.pl/szukaj?only_content=1&prezentacja=lista&page=1&args[asset_category_text]=lokal+mieszkalny+%28mieszkanie%29&args[transaction_type_text]=sprzeda%C5%BC&args[province_text_facet]=-";
    private String city = "";

    private String district = "";

    private String priceMin = "";

    private String priceMax = "";

    private String pricePerMeterMin = "";

    private String pricePerMeterMax = "";

    SzybkoFilterBuilder withCity(String city) {
        this.city = "&args[place_text_facet]=" + city;
        return this;
    }

    SzybkoFilterBuilder withDistrict(String district) {
        this.district = "&args[quarter_text_facet]=" + district;
        return this;
    }

    SzybkoFilterBuilder withPriceMin(int priceMin) {
        this.priceMin = "&args[price_value_from]=" + priceMin;
        return this;
    }

    SzybkoFilterBuilder withPriceMax(int priceMax) {
        this.priceMax = "&args[price_value_to]=" + priceMax;
        return this;
    }

    SzybkoFilterBuilder withPricePerMeterMin(int pricePerMeterMin) {
        this.pricePerMeterMin = "&[price_per_meter_from]=" + pricePerMeterMin;
        return this;
    }

    SzybkoFilterBuilder withPricePerMeterMax(int pricePerMeterMax) {
        this.pricePerMeterMax = "&[price_per_meter_to]=" + pricePerMeterMax;
        return this;
    }

    String build() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(baseUrlForSearching)
                .append(city)
                .append(district)
                .append(priceMin)
                .append(priceMax)
                .append(pricePerMeterMin)
                .append(pricePerMeterMax)
                .toString();

    }

}
