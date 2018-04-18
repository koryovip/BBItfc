package ifc;

import java.math.BigDecimal;

public class BollValue extends KRDataH {

    final public BigDecimal ma;
    final public BigDecimal high1;
    final public BigDecimal high2;
    final public BigDecimal low1;
    final public BigDecimal low2;

    public BollValue(CandleValue candleValue, BigDecimal ma, BigDecimal high1, BigDecimal high2, BigDecimal low1, BigDecimal low2) {
        super(candleValue.type, candleValue.time);
        this.ma = ma;
        this.high1 = high1;
        this.high2 = high2;
        this.low1 = low1;
        this.low2 = low2;
    }

    final public boolean isValid() {
        return this.ma != null && this.high1 != null && this.high2 != null && this.low1 != null && this.low2 != null;
    }

    final public static BollValue newNull(CandleValue candleValue) {
        return new BollValue(candleValue, null, null, null, null, null);
    }
}
