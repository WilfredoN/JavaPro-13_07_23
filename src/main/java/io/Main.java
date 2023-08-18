package io;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var config = new FileLoggerConfiguration(
                "./src/main/logs/",
                512,
                "hillel_",
                LoggingLevel.DEBUG
        );
        var fileLogger = new FileLogger(config);
        try {
            fileLogger.debug("u1QYNXB6EoG5K7Ysu2XW2xD2iOnKN0cW1DR8eTGMDUra5ahqdqelj16ywqYd7Gu4jXAc9qk3S7AQo2SElmpU3V" +
                    "ma7m16K0Fe8Q4HK146xcFH4Lv3NN1Enc4lm50xbzMYDw0C3SyLWdB97m0PHTz0Prx2700FBU5GX77GOL3FOXp0Y320ZT9untW" +
                    "cccmA188FBvP6fgm3RPjTb5fh");
            fileLogger.info("Info message!");
        } catch (FileSizeLimitExceededException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
