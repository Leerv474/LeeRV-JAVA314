package interfaces;

public interface IAdmin {
    User findById(int id);
    User findByUsername(String username);
    void setAdmin(int id);
    User[] findAll();
    String[] findAllNames();
}
