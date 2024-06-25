package constants.common.createaccount;

public enum Countries {
    INDIA("India"),
    UNITED_STATE("United States"),
    CANADA("Canada"),
    AUSTRIA("Australia"),
    ISRAEL("Israel"),
    NEW_ZEALAND("New Zealand"),
    SINGAPORE("Singapore");

    private final String country;

    Countries(final String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
