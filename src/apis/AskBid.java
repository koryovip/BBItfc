package apis;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AskBid {

    final public ExchangeDef exchange;

    public AskBid(ExchangeDef exchange) {
        this.exchange = exchange;
    }

    public BigDecimal ask;
    public BigDecimal bid;

    @Override
    public String toString() {
        return String.format("[%10s][bid: %8s][ask: %8s][Spread: %6s]", exchange, bid(1), ask(1), spread());
    }

    public BigDecimal ask(int round) {
        return ask.setScale(round, RoundingMode.DOWN);
    }

    public BigDecimal bid(int round) {
        return bid.setScale(round, RoundingMode.DOWN);
    }

    public BigDecimal spread() {
        return ask.subtract(bid).setScale(1, RoundingMode.DOWN);
    }
}
