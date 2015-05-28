enum Country {

    DK("Denmark"),
    SE("Sweden"),
    NO("Norway"),
    GB("Great Britain"),
    US("USA"),

    final String value

    Country(String value) {
        this.value = value
    }

    @Override
    String toString() {
        return value
    }

    String getKey() {
        return name()
    }
}
