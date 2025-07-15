package interfaces;

import java.util.List;

public class MongoBD implements DatabaseService{
    @Override
    public String getById(Long id) {
        return "Getting Record with ID: " + id;
    }
    @Override
    public List<String> getAllRecords() {
        return List.of("Record 1", "Record 2", "Record 3");
    }
}
