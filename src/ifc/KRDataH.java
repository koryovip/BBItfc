package ifc;

import java.util.Date;

public class KRDataH {
    /** 1min, 5min, 15min, 1hour, 1day, 1week etc.... */
    public final KRCandleType type;
    public final Long time;
    private Date dt = null;

    public KRDataH(KRCandleType type, Long time) {
        super();
        this.type = type;
        this.time = time;
    }

    final public Date getTime() {
        if (this.dt == null) {
            this.dt = new Date(this.time);
        }
        return this.dt;
    }
}
