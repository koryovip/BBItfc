package ifc.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

import ifc.CandleValue;

public abstract class KRCalculator {

    final protected BigDecimal ONE = new BigDecimal(1);
    final protected BigDecimal TWO = new BigDecimal(2);

    final protected BigDecimal ma(final List<CandleValue> list, final int index, final BigDecimal length, final int round) {
        BigDecimal result = BigDecimal.ZERO;
        for (int ii = index - length.intValue() + 1; ii <= index; ii++) {
            result = result.add(list.get(ii).close); // close
        }
        return result.divide(length, round, RoundingMode.HALF_UP);
    }

    final public BigDecimal getHigher(CandleValue ohlcv) {
        if (ohlcv.open.compareTo(ohlcv.close) >= 0) {
            return ohlcv.open;
        }
        return ohlcv.close;
    }

    final public BigDecimal getLower(CandleValue ohlcv) {
        if (ohlcv.open.compareTo(ohlcv.close) <= 0) {
            return ohlcv.open;
        }
        return ohlcv.close;
    }

    // sample
    final protected Double calculateStandardDiviation(List<Double> scores) {
        SynchronizedSummaryStatistics stats = new SynchronizedSummaryStatistics();
        for (Double score : scores) {
            stats.addValue(score);
        }
        Double stdev = stats.getStandardDeviation();
        return Precision.round(stdev, 2);
    }

    final protected Double calculatePopulationStandardDiviation(List<Double> scores) {
        SynchronizedSummaryStatistics stats = new SynchronizedSummaryStatistics();
        for (Double score : scores) {
            stats.addValue(score);
        }
        Double varp = stats.getPopulationVariance();
        Double stdevp = FastMath.sqrt(varp);
        return Precision.round(stdevp, 2);
    }

}
