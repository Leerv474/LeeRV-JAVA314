package interfaces;

public class DbDaoMock {
    User[] users;

    public DbDaoMock() {
        users = new User[7];
        users[0] = new User("Nik", "admin");
        users[1] = new User("Josh", "user");
        users[2] = new User("James", "user");
        users[3] = new User("Natalie", "golden");
        users[4] = new User("Ash", "user");
        users[5] = new User("Adam", "admin");
        users[6] = new User("Marine", "admin");
    }
}
