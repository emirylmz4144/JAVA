import java.time.LocalDate;

public class Book
{
    private String bookName;
    private int pageNumberOfBook;
    private String nameOfAuthor;
    private LocalDate releaseDate;

    public Book(String bookName, int pageNumberOfBook, String nameOfAuthor, LocalDate releaseDate) {
        this.bookName = bookName;
        this.pageNumberOfBook = pageNumberOfBook;
        this.nameOfAuthor = nameOfAuthor;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumberOfBook() {
        return pageNumberOfBook;
    }

    public void setPageNumberOfBook(int pageNumberOfBook) {
        this.pageNumberOfBook = pageNumberOfBook;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}
