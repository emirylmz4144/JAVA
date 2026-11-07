import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookActions
{
    Set<Book> ourBooks=new TreeSet<>();
    Scanner input=new Scanner(System.in);
    public void run()
    {
        boolean status=true;
        while (status)
        {

            System.out.println("""
                    1-Kitap Ekleme
                    2-Kitapları sayfa sayısına göre listeleme
                    3-Kitapları alfabetik olarak sıralama
                    0-Çıkış""");

           int choose=input.nextInt();

            switch (choose) {
                case 1 -> {

                    System.out.println("Yazar Adı ");
                    input.nextLine();
                    String authorName = input.nextLine();
                    System.out.println("Kitap Adı: ");
                    String bookName = input.nextLine();
                    System.out.println("Kitap basım tarihi:  ");
                    String bookDate = input.nextLine();

                    System.out.println("Kitap sayfa sayısı: ");
                    int pagesOfBook = input.nextInt();
                    Book newBook = new Book(bookName, authorName, bookDate, pagesOfBook);
                    ourBooks.add(newBook);
                }
                case 2 -> sortByNumber(ourBooks);
                case 3 -> sortByAlf(ourBooks);
                case 0 -> status = false;
                default -> System.out.println("Lütfen geçerli bir işlem giriniz.");
            }

        }

    }

    /**Alfabetik sıralama yapar
     *
     * @param ourBooks
     */
    public void sortByAlf(Set<Book> ourBooks)
    {
        /*
        *Kitaba ait alfabetik sıralama yapan metoda ait bu yapıda Set Yapısından Tree kullanılmıştır sebebi ise
        * Bu TreeSet yapısının yapıları otomatik olarak sıralayıp bize vermesidir tek yapmamız gereken anonmymous
        * class oluşturup sıralama biçimini belirlemektir
         */
        Set<Book> ourBook=new TreeSet<>((a,b)->a.getBookName().compareTo(b.getBookName()));


        /*
         Set<Book> ourBook=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBookName().compareTo(o2.getBookName());
            }

        });
         */

        ourBook.addAll(ourBooks);

        // Yazdırma işlemi SOLİD kuralları gereği ayrı bir metoda yazılabilir hızlı olması açısından buraya yazılmıştır
        for (Book book:ourBook)
        {
            System.out.println("YAZAR ADI: "+book.getAuthorName());
            System.out.println("KİTAP ADI: "+book.getBookName());
            System.out.println("KİTAP SAYFA SAYISI: "+book.getBookPageNumber());
            System.out.println("BASIM TARİHİ: "+book.getBookDate());
            System.out.println("-----------------------------------");
        }
    }

    /**Sayfa sayısına göre filtreleme yapar
     *
     * @param ourBooks
     */
    public void sortByNumber(Set<Book> ourBooks)
    {
        /*
         *Kitaba ait alfabetik sıralama yapan metoda ait bu yapıda Set Yapısından Tree kullanılmıştır sebebi ise
         * Bu TreeSet yapısının yapıları otomatik olarak sıralayıp bize vermesidir tek yapmamız gereken anonmymous
         * class oluşturup sıralama biçimini belirlemektir
         */
        Set<Book> ourBook=new TreeSet<>((a,b)->Integer.compare(a.getBookPageNumber(),b.getBookPageNumber()));
        /*
         Set<Book> ourBook=new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getBookPageNumber(), o2.getBookPageNumber());
            }
        });
         */

        ourBook.addAll(ourBooks);

        for (Book book:ourBook)
        {
            System.out.println("YAZAR ADI: "+book.getAuthorName());
            System.out.println("KİTAP ADI: "+book.getBookName());
            System.out.println("KİTAP SAYFA SAYISI: "+book.getBookPageNumber());
            System.out.println("BASIM TARİHİ: "+book.getBookDate());
            System.out.println("-----------------------------------");
        }
    }
}
