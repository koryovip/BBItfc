package ifc;

import java.util.List;

public interface Exchange<Pair, Type> {

    public List<CandleValue> getCandles(final Pair pair, final Type candleType, final int limit) throws Exception;

    public List<BollValue> getBoll(final List<CandleValue> candleValueList, final Pair pair, final Type candleType, final int period, final int round) throws Exception;

    public boolean lastBoll(final CandleValue lastOhlcv, final BollValue lastBollRow) throws Exception;
}
