import java.util.Scanner;

public class Store
{
    Scanner input=new Scanner(System.in);

    ProductActions productActions=new ProductActions();

    public void run()
    {
        boolean status=true;
        while (status)
        {
            System.out.println("----------BEYMİR STORE-------------");
            System.out.println("""
                    Lütfen yapacağınız işlemi seçiniz:
                    1-NoteBook İşlemleri
                    2-Cep Telefonu İşlemleri
                    3-Marka Listeleme
                    0-Çıkış""");

            int choose=input.nextInt();
            /*Aksiyon telefon ve notebook'a göre değişiklik göstereceğinden programın çalışma akışına göre telefon veya notebook
            parametre olarak product aksiyon'a gönderilir
             */
            switch (choose)
            {
                case 1 -> productActions.run(NoteBook.ourNoteBooks);
                case 2 -> productActions.run(Telephone.ourTelephones);
                case 3 -> listToBrand();
                case 0 -> status = false;
            }

        }
    }

    //Markaları listeleme
    public void listToBrand()
    {
        for (Brand brand:Brand.ourBrands)
        {
            System.out.println("Marka adı: "+brand.getName());
            System.out.println("Marka Id: "+brand.getId());
            System.out.println("*----------------------*");
        }
    }
}
