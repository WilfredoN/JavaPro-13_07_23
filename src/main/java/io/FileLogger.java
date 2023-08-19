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
    private static int newFileIndex;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        newFileIndex = 0;
        initLogFile(newFileIndex);
    }


    public String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private void initLogFile(int index) {
        currentFileLog = new File(configuration.getFilePath(), setFileName(index));
        currentFileSize = currentFileLog.length();
        File logDirectory = currentFileLog.getParentFile();
        if (!logDirectory.exists()) {
            if (logDirectory.mkdirs()) {
                System.out.println("Папка створена, шлях - " + logDirectory.getAbsolutePath());
            } else {
                System.out.println("Папка не створена на шляху - " + logDirectory.getAbsolutePath());
            }
        }
    }

    private String setFileName(int index) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH-mm");
        String timestamp = dateFormat.format(new Date());
        return "Log_" + index + "_" + timestamp + ".txt";
    }

    private void checkFileSize() {
        try {
            if (currentFileSize >= configuration.getMaxFileSize()) {
                throw new FileSizeLimitExceededException(currentFileLog, configuration);
            }
        } catch (FileSizeLimitExceededException e) {
            System.out.println(e.getMessage());
            newFileIndex++;
            initLogFile(newFileIndex);
        }
    }

    public void debug(String message) throws FileSizeLimitExceededException {
        if (configuration.getCurrentLogLevel() == LoggingLevel.DEBUG) {
            logFill("[DEBUG] " + message);
            logFill("[INFO] " + message);
        }
    }

    public void info(String message) throws FileSizeLimitExceededException {
        if (configuration.getCurrentLogLevel() == LoggingLevel.INFO) {
            logFill("[INFO] " + message);
        }
    }

    private void logFill(String message) throws FileSizeLimitExceededException {
        try (PrintWriter write = new PrintWriter(new FileWriter(currentFileLog, true))) {
            checkFileSize();
            String readyMessage = "[" + getCurrentTime() + "]" + message;
            write.println(readyMessage);
            currentFileSize += readyMessage.length() + System.lineSeparator().length();
        } catch (IOException e) {
            throw new FileSizeLimitExceededException(currentFileLog, configuration);
        }
    }


    public long getCurrentFileSize() {
        return currentFileSize;
    }

    public boolean deleteCurrentFile() {
        return currentFileLog.delete();
    }
}