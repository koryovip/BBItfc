package ifc;

import java.math.BigDecimal;

public class CandleValue extends KRDataH {

    public final BigDecimal open;
    public final BigDecimal high;
    public final BigDecimal low;
    public final BigDecimal close;

    public CandleValue(KRCandleType type, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, Long time) {
        super(type, time);
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

}
