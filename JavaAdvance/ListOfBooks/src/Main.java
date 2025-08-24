
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Book> ourBooks = new ArrayList<>();

        boolean status = true;
        while (status) {
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("""
                    Lütfen yapacağınız işlemi seçiniz
                    1-Kitap ekleme
                    2-Yazarlar ve kitaplarını görüntüleme
                    3-Kitap filtreleme
                    0-Çıkış""");

            int choose = Integer.parseInt(input.nextLine());
            while (choose < 0 || choose > 3)
            {
                System.out.print("Lütfen geçerli seçim yapınız");
                choose = Integer.parseInt(input.nextLine());
            }


            if (choose == 0)
                status = false;
            else if (choose == 1)
                addBook(ourBooks);
            else
            {
                if (ourBooks.size()<=1)
                    System.out.println("Lütfen limit sayıda kitap sayısına ulaştıktan sonra bu seçeneği seçiniz.");
                else if (choose==2)
                    authorAndBookName(ourBooks);
                else
                 filtering(ourBooks,(p)->p.getPageNumberOfBook()>100);
            }


        }
    }
    public static void addBook(ArrayList<Book> ourBooks)
    {
        System.out.print("Lütfen kitap adını giriniz: "); String bookName=input.nextLine();
        System.out.print("Lütfen kitap sayfa sayısını giriniz: "); int bookPageNumber=input.nextInt();input.nextLine();
        System.out.print("Lütfen yazar adını giriniz: "); String authorName=input.nextLine();
        System.out.print("Lütfen kitap yayın tarihini giriniz: (dd.MM.yyyy) ");String date=input.nextLine();

        DateTimeFormatter parseRealDate=DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate realDate=LocalDate.parse(date,parseRealDate);


       ourBooks.add(new Book(bookName,bookPageNumber,authorName,realDate));

    }

    public static void authorAndBookName (ArrayList<Book> ourBooks)
    {
        Map<String,String> authorAndBookName=ourBooks.stream().collect(Collectors.toMap((s)->s.getBookName(),s->s.getNameOfAuthor()));
        for (String bookName:authorAndBookName.keySet())
            System.out.println("Kitap adı: "+bookName +"-->"+authorAndBookName.get(bookName));
    }

    public static void filtering(ArrayList<Book> ourBooks,Filter filter)
    {
        for (Book ourBook:ourBooks)
        {
            if (filter.toFilter(ourBook))
            {
                System.out.println("Kitap adı: "+ourBook.getBookName());
                System.out.println("Kitap sayfa sayısı: "+ourBook.getPageNumberOfBook());
                System.out.println("Kitap yazarı: "+ourBook.getNameOfAuthor());
                System.out.println("Kitap basım tarihi :"+ourBook.getReleaseDate());
                System.out.println("-----------");
            }
        }
    }
}