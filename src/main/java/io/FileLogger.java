package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private final FileLoggerConfiguration configuration;
    private File currentFileLog;
    private long currentFileSize;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        initLogFile();
    }

    public String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private void initLogFile() {
        currentFileLog = new File(configuration.getFilePath());
        currentFileSize = currentFileLog.length();
    }

    private String setFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
        String timestamp = dateFormat.format(new Date());
        return "Log_" + timestamp + ".txt";
    }

    private void checkFileSize() throws FileSizeLimitExceededException {
        if (currentFileSize > configuration.getMaxFileSize()) {
            String newFileLog = setFileName();
            currentFileLog = new File(newFileLog);
            currentFileSize = 0;
            initLogFile();
        }
        else {
            throw new FileSizeLimitExceededException(currentFileLog);
        }
    }

    public void debug(String message) throws FileSizeLimitExceededException, IOException {
        checkFileSize();
        logFill("[INFO] " + message);
    }

    public void info(String message) throws FileSizeLimitExceededException, IOException {
        if (configuration.getCurrentLogLevel() == LoggingLevel.INFO) {
            checkFileSize();
            logFill("[INFO] " + message);
        }
    }

    private void logFill(String message) throws IOException {
        try (PrintWriter write = new PrintWriter(new FileWriter(currentFileLog, true))) {
            String readyMessage = "[" + getCurrentTime() + "]" + message;
            write.println(readyMessage);
            currentFileSize = readyMessage.length();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
