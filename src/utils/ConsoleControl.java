package utils;

import java.io.IOException;

public class ConsoleControl {

    private static ConsoleControl singleton = new ConsoleControl();

    public static ConsoleControl me() {
        return singleton;
    }

    final private ProcessBuilder pb;

    private ConsoleControl() {
        pb = new ProcessBuilder("cmd", "/c", "cls");
    }

    /**
     * コマンドプロンプトの画面をクリアするメソッド。
     */
    public void cls() throws IOException, InterruptedException {
        pb.inheritIO().start().waitFor();
    }

}
