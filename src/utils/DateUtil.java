package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static DateUtil singleton = new DateUtil();

    public static DateUtil me() {
        return singleton;
    }

    private final ThreadLocal<DateFormat> sdf0;
    private final ThreadLocal<DateFormat> sdf1;
    private final ThreadLocal<DateFormat> sdf2;
    private final ThreadLocal<DateFormat> sdf3;
    private final ThreadLocal<DateFormat> sdf4;
    private final ThreadLocal<DateFormat> sdf5;

    private DateUtil() {
        sdf0 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("MM/dd HH:mm");
            }
        };
        sdf1 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("MM/dd HH:mm:ss");
            }
        };
        sdf2 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("HH:mm:ss MM/dd");
            }
        };
        sdf3 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("yyyyMMdd");
            }
        };
        sdf4 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("yyyyMM");
            }
        };
        sdf5 = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("HH:mm:ss");
            }
        };
    }

    final public String format0(Date date) {
        return sdf0.get().format(date);
    }

    final public String format0(long dateTime) {
        return this.format0(new Date(dateTime));
    }

    final public String format1(Date date) {
        return sdf1.get().format(date);
    }

    final public String format1(long dateTime) {
        return this.format1(new Date(dateTime));
    }

    final public String format2(Date date) {
        return sdf2.get().format(date);
    }

    final public String format2(long dateTime) {
        return this.format2(new Date(dateTime));
    }

    final public String format3(Date date) {
        return sdf3.get().format(date);
    }
    final public String format3(long dateTime) {
        return this.format3(new Date(dateTime));
    }

    final public String format4(Date date) {
        return sdf4.get().format(date);
    }

    final public String format5(Date date) {
        return sdf5.get().format(date);
    }

    final public String format5(long dateTime) {
        return this.format5(new Date(dateTime));
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.me().format1(new Date()));
    }
}
