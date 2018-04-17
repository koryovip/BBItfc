package ifc;

import java.util.List;

public interface Exchange {

    public List<CandleValue> getCandles(final KRCandleType candleType, final int limit) throws Exception;

}
