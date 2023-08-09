package collections.dictionaries;

import java.util.*;

public class FileNavigator {
    public Map<String, List<FileData>> files = new HashMap<>();

    public void add(String path, FileData data) {
        if (!files.containsKey(path)) {
            files.put(path, new ArrayList<>());
        }
        files.get(path).add(data);
    }

    public List<FileData> find(String path) {
        return files.getOrDefault(path, List.of());
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> filteredData = new ArrayList<>();
        for (List<FileData> files : files.values()) {
            for (FileData fileData : files) {
                if (fileData.getFileSize() <= size) {
                    filteredData.add(fileData);
                }
            }
        }
        return filteredData;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortedData = new ArrayList<>();
        for (List<FileData> file : files.values()) sortedData.addAll(file);
        sortedData.sort(Comparator.comparingInt(FileData::getFileSize));
        return sortedData;
    }

    public boolean consistencyCheck(String path, FileData fileData) {
        return path.equals(fileData.getFilePath());
    }
}