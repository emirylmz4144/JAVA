import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Book implements Comparable<Book>
{
    private String bookName;
    private String authorName;
    private String bookDate;
    private int bookPageNumber;


    public Book (String bookName,String authorName,String bookDate,int bookPageNumber)
    {
        //Kitaba ait yapıcı metot oluşturulumuştur

        this.bookName=bookName;
        this.authorName=authorName;
        this.bookDate=bookDate;
        this.bookPageNumber=bookPageNumber;
    }


    /* karşılaştırma için compareTo metodu oluşturulmuştur bu sayede sıralı yapının neye göre olacağı
    küme elamanlarının nasıl yoklanacağı belirleniyor
     */
    @Override
    public int compareTo(Book book) {
       return this.bookName.compareTo(book.bookName);
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }


}
