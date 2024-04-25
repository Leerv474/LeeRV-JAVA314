import LibraryDB_pkg.LibraryDB;

public class Main {
    public static void main(String[] args) {
        LibraryDB library = new LibraryDB();

        //TODO: заполнить библиотеку минимум 5 книгами
        library.addBook("\"To Kill a Mockingbird\" by Harper Lee");
        library.addBook("\"1984\" by George Orwell");
        library.addBook("\"The Great Gatsby\" by F. Scott Fitzgerald");
        library.addBook("\"The Catcher in the Rye\" by J.D. Salinger");
        library.addBook("\"The Lord of the Rings\" by J.R.R. Tolkien");

        library.listOwnedBooks();

        //TODO: выдать 2 книги посетителям
        library.issueBook("\"To Kill a Mockingbird\" by Harper Lee", "Ethan Reynolds");
        library.issueBook("\"The Catcher in the Rye\" by J.D. Salinger", "Olivia Bennett");

        library.listOwnedBooks();

        //TODO: принять от посетителей 2 книги
        library.takeBook("\"To Kill a Mockingbird\" by Harper Lee");
        library.takeBook("\"The Catcher in the Rye\" by J.D. Salinger");

        library.listOwnedBooks();

        //TODO: списать 1 книгу
        library.writeOffBook("\"The Great Gatsby\" by F. Scott Fitzgerald");

        library.listOwnedBooks();

        //TODO: принять 2 новых книги
        library.addBook("\"The Night Circus\" by Erin Morgenstern");
        library.addBook("\"Sapiens: A Brief History of Humankind\" by Yuval Noah Harari");

        library.listOwnedBooks();
    }
}