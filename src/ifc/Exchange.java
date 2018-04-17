package ifc;

import java.util.List;

public interface Exchange {

    public List<CandleValue> getCandles(KRCandleType candleType, int limit) throws Exception;

}
