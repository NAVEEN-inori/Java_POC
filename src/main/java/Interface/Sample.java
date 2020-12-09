package Interface;

interface Library{

    void issueBook(Book b);
    void retrieveBook(Book b);

    class Book{

        int bookId;
        String bookName;
        int issueDate;
        int returnDate;
    }
}

public class Sample implements Library {

    public static void main(String[] args) {

        Library library = new Sample();

        library.issueBook(new Library.Book());
        library.retrieveBook(new Library.Book());
    }

    @Override
    public void issueBook(Book b) {

        System.out.println("Book Issued");
    }

    @Override
    public void retrieveBook(Book b) {

        System.out.println("Book Retrieved");
    }
}
