package io;

import java.io.File;

public class FileSizeLimitExceededException extends Exception {
    public FileSizeLimitExceededException(File file) {
        super("Розмір файлу " + file + " вищий за ліміт, створено новий файл.");
    }
}
