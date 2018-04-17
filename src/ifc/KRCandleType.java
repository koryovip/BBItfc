package ifc;

public enum KRCandleType {
    _1MIN("1min"), //
    _5MIN("5min"), //
    _15MIN("15min"), //
    _30MIN("30min"), //
    _1HOUR("1hour"), //
    _4HOUR("4hour"), //
    _8HOUR("8hour"), //
    _12HOUR("12hour"), //
    _1DAY("1day"), //
    _1WEEK("1week"); //

    private final String type;

    KRCandleType(final String type) {
        this.type = type;
    }

    public String getCode() {
        return this.type;
    }
}