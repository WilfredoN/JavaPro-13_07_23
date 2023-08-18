package io;

import java.io.File;

public class FileSizeLimitExceededException extends Exception {
    public FileSizeLimitExceededException(File file, FileLoggerConfiguration configuration) {
        super("Розмір файлу " + file + " тепер дорівнює " + file.length() + " вищий за ліміт - " + configuration.getMaxFileSize() + ", створено новий файл.");
    }
}
