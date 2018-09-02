package for_testing.mockito;

import java.util.List;

/**
 * client(Java programm, browser) -> DAO(Data access object) -> database
 */
public class DAOTest {
    private ImitationDB db;

    public DAOTest(ImitationDB db) {
        this.db = db;
    }

    public void insert(String object) {
        db.insertData(object);
    }

    public void delete(int index) {
        db.delete(index);
    }

    public List<String> getAll() {
        return db.getAllRecords();
    }
}
