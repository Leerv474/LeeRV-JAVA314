package interfaces;

public class User implements IUser, IAdmin, IGolden {
    private String username;
    private String password;
    private String role;
    private DbDaoMock dao;




    public User(String username, String role) {
        this.username = username;
        this.password = "qwerty";
        this.role = role;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDao(DbDaoMock dao) {
        this.dao = dao;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", role='" + role + '\'' + '}';
    }

    @Override
    public String[] findAllNames() {
        String[] names = new String[dao.users.length];
        for (int i = 0; i < dao.users.length; i++) {
            names[i] = dao.users[i].username;
        }
        return names;
    }

    @Override
    public User[] findAll() {
        return dao.users;
    }

    @Override
    public User findById(int id) {
        return dao.users[id];
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < dao.users.length; i++) {
            if (dao.users[i].username.equals(username)) {
                return dao.users[i];
            }
        }
        return null;
    }

    @Override
    public void setAdmin(int id) {
        dao.users[id].role = "admin";
    }

}
