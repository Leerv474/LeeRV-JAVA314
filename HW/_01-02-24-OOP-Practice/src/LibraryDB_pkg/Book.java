package LibraryDB_pkg;

public class Book {
    private final String name;
    private EBookState state;
    private String borrower = "Unknown";

    Book(String name) {
        this.name = name;
        this.state = EBookState.STORED;
    }

    public String getName() {
        return name;
    }

    public EBookState getState() {
        return state;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getStatus() {
        return String.format("%s, state = %s", this.name, this.state.toString());
    }

    void registerBorrow(String borrower) {
        if (this.state == EBookState.WRITTEN_OFF) {
            System.out.println("The book has been retired.");
            return;
        }

        this.state = EBookState.BORROWED;
        this.borrower = borrower;
    }

    void registerReturn() {
        if (this.state != EBookState.BORROWED) {
            System.out.println("The book wasn't borrowed.");
            return;
        }

        this.state = EBookState.STORED;
        this.borrower = "Unknown";
    }

    void writeOff() {
        if (this.state == EBookState.BORROWED) {
            System.out.println("The book has been borrowed. Unable to write it off for now.");
            return;
        }
        if (this.state == EBookState.WRITTEN_OFF) {
            System.out.println("The book has been written off already.");
            return;
        }

        this.state = EBookState.WRITTEN_OFF;
    }
}
