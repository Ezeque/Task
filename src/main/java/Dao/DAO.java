package Dao;

public interface DAO {
    //    CREATES ENTRIES IN DATABASE
    public boolean create();

    //    GETS DATA IN DATABASE
    public boolean read();

    //    UPDATE DATA IN DATABASE
    public boolean update();

    //    DELETE DATA IN DATABASE
    public boolean delete();
}
