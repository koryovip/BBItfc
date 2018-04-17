package ifc.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics;
import org.apache.commons.math3.util.FastMath;

import ifc.BollValue;
import ifc.CandleValue;

public class CalcBoll extends KRCalculator {
    private static CalcBoll singleton = new CalcBoll();

    public static CalcBoll me() {
        return singleton;
    }

    final public List<BollValue> calc(final List<CandleValue> candleValueList, final BigDecimal LENGTH, final int round) {
        List<BollValue> bollValueList = new ArrayList<BollValue>();
        for (int ii = 0; ii < candleValueList.size(); ii++) {
            final CandleValue candleInfo = candleValueList.get(ii);
            if (ii < LENGTH.intValue() - 1) {
                bollValueList.add(BollValue.newNull(candleInfo));
                continue;
            }
            final BigDecimal ma = ma(candleValueList, ii, LENGTH, round);
            final BigDecimal boll1 = boll(candleValueList, ii, LENGTH, 1, round);
            bollValueList.add(new BollValue(candleInfo, //
                    ma, //
                    ma.add(ONE.multiply(boll1)), //
                    ma.add(TWO.multiply(boll1)), //
                    ma.subtract(ONE.multiply(boll1)), //
                    ma.subtract(TWO.multiply(boll1)) //
            ));
        }
        return bollValueList;
    }

    /**
     * 正規分布を計算
     * @param list
     * @param index
     * @param length
     * @param sigma
     * @param round
     * @return
     */
    final protected BigDecimal boll(final List<CandleValue> list, final int index, final BigDecimal length, final int sigma, final int round) {
        SynchronizedSummaryStatistics stats = new SynchronizedSummaryStatistics();
        for (int ii = index - length.intValue() + 1; ii <= index; ii++) {
            stats.addValue(list.get(ii).close.doubleValue());
        }
        return new BigDecimal(FastMath.sqrt(stats.getPopulationVariance())).setScale(round, RoundingMode.HALF_UP);
    }

}
