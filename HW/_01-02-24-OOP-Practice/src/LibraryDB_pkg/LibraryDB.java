package LibraryDB_pkg;

import java.util.Objects;

public class LibraryDB {
    Book[] ownedBooks = new Book[1000];
    int amountOfBooks = 0;

    private int getBookId(String bookName, EBookState state) {
        for (int i = 0; i < this.amountOfBooks; i++) {
            boolean bookIsStored = Objects.equals(this.ownedBooks[i].getName(), bookName) && this.ownedBooks[i].getState() == state;
            if (bookIsStored) {
                return i;
            }
        }
        return -1;
    }


    public void addBook(String bookName) {
        this.ownedBooks[this.amountOfBooks] = new Book(bookName);
        this.amountOfBooks++;
    }

    public void issueBook(String bookName, String borrower) {
        int bookId = getBookId(bookName, EBookState.STORED);
        if (bookId == -1) {
            System.out.println("This book is not avaliable for borrowing.");
            return;
        }
        this.ownedBooks[bookId].registerBorrow(borrower);
    }

    public void takeBook(String bookName) {
        int bookId = getBookId(bookName, EBookState.BORROWED);
        if (bookId == -1) {
            System.out.println("No such book was borrowed.");
            return;
        }

        this.ownedBooks[bookId].registerReturn();
    }

    public void writeOffBook(String bookName) {
        int bookId = getBookId(bookName, EBookState.STORED);
        if (bookId == -1) {
            System.out.println("The book wasn't found in storage.");
            return;
        }

        this.ownedBooks[bookId].writeOff();
    }

    public void listOwnedBooks() {
        System.out.println("Listing of the owned books:");
        for (int i = 0; i < this.amountOfBooks; i++) {
            System.out.println(this.ownedBooks[i].getStatus());
        }
        System.out.println("--------\n");
    }

    // ? Можно ли как-то объединить методы addBook, takeBook, writeOffBook с помощью методов ООП?
    // ? Допустим поместить в параметры сслыки на методы.
    // ? Слишком уж эти три метода похожи.
}
