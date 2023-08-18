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
    private int newFileIndex = 0;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        initLogFile(newFileIndex);
    }

    public String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private File initLogFile(int index) {
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
        return currentFileLog;
    }

    private String setFileName(int index) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH-mm");
        String timestamp = dateFormat.format(new Date());
        return "Log_" + index + "_" + timestamp + ".txt";
    }

    private void checkFileSize() throws FileSizeLimitExceededException {
        if (currentFileSize >= configuration.getMaxFileSize()) {
            currentFileLog = initLogFile(newFileIndex);
            currentFileSize = 0;
            newFileIndex++;
           /* if (currentFileLog == null || !currentFileLog.exists()) {
                throw new RuntimeException("Failed to create a new log file.");
            }*/

           // throw new FileSizeLimitExceededException(currentFileLog, configuration);
        }
    }
    //FIXME не працює функціонал створення нових файлів із заданим індексом
    public void debug(String message) throws FileSizeLimitExceededException, IOException {
        if (configuration.getCurrentLogLevel() == LoggingLevel.DEBUG) {
            logFill("[DEBUG] " + message);
        }
    }

    public void info(String message) throws FileSizeLimitExceededException, IOException {
        if (configuration.getCurrentLogLevel() == LoggingLevel.INFO) {
            logFill("[INFO] " + message);
        }
    }

    private void logFill(String message) throws FileSizeLimitExceededException {
        try {
            checkFileSize();
            try (PrintWriter write = new PrintWriter(new FileWriter(currentFileLog, true))) {
                String readyMessage = "[" + getCurrentTime() + "]" + message;
                write.println(readyMessage);
                currentFileSize += readyMessage.length() + System.lineSeparator().length();
            }
        } catch (FileSizeLimitExceededException e) {
            newFileIndex++;
            initLogFile(newFileIndex);
            currentFileSize = 0;
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
