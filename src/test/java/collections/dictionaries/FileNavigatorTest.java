package collections.dictionaries;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {
    private FileNavigator nav;

    @BeforeEach
    void setUp() {
        nav = new FileNavigator();
    }

    @Test
    void shouldToTestFilterBySize() throws WrongPathException {
        FileData file = new FileData("wawda.bat", 60, "/path/to/file");
        FileData file1 = new FileData("awdaw.txt", 40, "/path/to/file1");
        FileData file2 = new FileData("ere.zip", 3300, "/path/to/file2");
        FileData file3 = new FileData("erg.txt", 120, "/path/to/file3");
        nav.add("/path/to/file", file);
        nav.add("/path/to/file1", file1);
        nav.add("/path/to/file2", file2);
        nav.add("/path/to/file3", file3);
        assertEquals(2, nav.filterBySize(100).size());
        assertNotEquals(2, nav.filterBySize(200).size());
    }

    @Test
    void shouldToAddAndFindFiles() throws WrongPathException {
        FileData file = new FileData("file.txt", 20, "/path/to/file");
        FileData file2 = new FileData("file.bat", 10, "/path/to/file2");
        nav.add("/path/to/file", file);
        nav.add("/path/to/file2", file2);
        assertFalse(nav.find("/path/to/file").isEmpty());
        assertFalse(nav.find("/path/to/file2").isEmpty());
    }

    @Test
    void shouldToRemoveFile() throws WrongPathException {
        FileData file = new FileData("wawda.bat", 60, "/path/to/file");
        FileData file1 = new FileData("awdaw.txt", 40, "/path/to/file1");
        FileData file2 = new FileData("ere.zip", 3300, "/path/to/file2");
        FileData file3 = new FileData("erg.txt", 120, "/path/to/file3");
        nav.add("/path/to/file", file);
        nav.add("/path/to/file1", file1);
        nav.add("/path/to/file2", file2);
        nav.add("/path/to/file3", file3);
        nav.remove("/path/to/file2");
        assertEquals(List.of(), nav.find("/path/to/file2"));
    }

    @Test
    void shouldToSortBySize() throws WrongPathException {
        FileData file = new FileData("wawda.bat", 60, "/path/to/file");
        FileData file1 = new FileData("awdaw.txt", 40, "/path/to/file1");
        FileData file2 = new FileData("ere.zip", 3300, "/path/to/file2");
        FileData file3 = new FileData("erg.txt", 120, "/path/to/file3");
        nav.add("/path/to/file", file);
        nav.add("/path/to/file1", file1);
        nav.add("/path/to/file2", file2);
        nav.add("/path/to/file3", file3);
        assertEquals(file1, nav.sortBySize().get(0));
        assertEquals(file, nav.sortBySize().get(1));
        assertEquals(file3, nav.sortBySize().get(2));
        assertEquals(file2, nav.sortBySize().get(3));
    }

    @Test
    void shouldToTestConsistency() throws WrongPathException {
        FileData file = new FileData("file.txt", 20, "/path/to/file");
        FileData file2 = new FileData("file.bat", 10, "/path/to/file2");
        Throwable res = assertThrows(WrongPathException.class, () -> nav.add("/path/another/file2", file2));
        assertNotNull(res.getMessage());
    }
}