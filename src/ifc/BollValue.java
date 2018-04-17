package ifc;

import java.math.BigDecimal;

public class BollValue extends KRDataH {

    final public BigDecimal ma;
    final public BigDecimal sigmaPlus1;
    final public BigDecimal sigmaPlus2;
    final public BigDecimal sigmaMinus1;
    final public BigDecimal sigmaMinus2;

    public BollValue(CandleValue candleValue, BigDecimal ma, BigDecimal sigmaPlus1, BigDecimal sigmaPlus2, BigDecimal sigmaMinus1, BigDecimal sigmaMinus2) {
        super(candleValue.type, candleValue.time);
        this.ma = ma;
        this.sigmaPlus1 = sigmaPlus1;
        this.sigmaPlus2 = sigmaPlus2;
        this.sigmaMinus1 = sigmaMinus1;
        this.sigmaMinus2 = sigmaMinus2;
    }

    final public boolean isValid() {
        return this.ma != null && this.sigmaPlus1 != null && this.sigmaPlus2 != null && this.sigmaMinus1 != null && this.sigmaMinus2 != null;
    }

    final public static BollValue newNull(CandleValue candleValue) {
        return new BollValue(candleValue, null, null, null, null, null);
    }
}
