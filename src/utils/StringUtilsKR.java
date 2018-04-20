package utils;

public class StringUtilsKR {
    private static StringUtilsKR singleton = new StringUtilsKR();

    public static StringUtilsKR me() {
        return singleton;
    }

    private StringUtilsKR() {
    }

    final public boolean isStrBlank(String str, boolean isnull) {
        if (str == null) {
            return isnull;
        }
        if (str.trim().length() <= 0) {
            return true;
        }
        return false;
    }
}
