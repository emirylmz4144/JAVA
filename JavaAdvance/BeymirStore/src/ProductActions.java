import java.util.*;

public class ProductActions
{
    Scanner input=new Scanner(System.in);
    public  void run(HashMap<Integer, Product> ourProductList)
    {
        boolean status=true;
        while (status)
        {
            System.out.println("""
                    Lütfen yapmak istediğiniz işlemi seçiniz:
                    1-Ürün ekleme
                    2-Ürün silme
                    3-Ürün listeleme
                    4-Filtreleme ile ürün listeleme
                    0-Çıkış yapma""");

            int choose= input.nextInt();

            switch (choose)
            {
                case 1 -> addAProduct(ourProductList);
                case 2 -> deleteToProduct(ourProductList);
                case 3 -> listToProducts(ourProductList);
                case 4 -> searchByFilter(ourProductList);
                case 0 -> status = false;
                default -> System.out.println("Lütfen geçerli bir işlem giriniz..");
            }
        }
    }

    /**Ürün eklemek için kullanılan
     *  @param  ourProductList
     *  parametre olarak alır çünkü notebook crud işlemleri olacaksa notebook hashmap'i alınmalı
     *  telephone alınacaksa telephone hashmap'i alınmalıdır
     * **/
    public void addAProduct(HashMap<Integer, Product> ourProductList)
    {
        System.out.print("Lütfen ürünün adını giriniz: ");input.nextLine();
        String productName=input.nextLine();

        Brand ourBrand=null;
        boolean status=true;

        //Sisteme kaydedilmiş (anlaşmalı marka simülasyonu) markalardan ekleme yapılabilir
        while(status)
        {
            System.out.print("Lütfen (sistemde kayıtlı ürünlerden) ürünün markasını giriniz: ");
            String brandOfProduct=input.nextLine();
            for (Brand brand:Brand.ourBrands)
            {
                if (brand.getName().equals(brandOfProduct))
                {
                    ourBrand=brand;
                    status=false;
                }
                else
                    System.out.println("Anlaşmalı markalardan ürün ekleyebilirsiniz");
            }
        }

        System.out.print("Lütfen ürünün ekran boyutunu giriniz: ");
        double screenSize=input.nextDouble();

        System.out.print("Lütfen ürünün batarya gücünü giriniz: ");
        double bataryPower=input.nextDouble();

        System.out.print("Lütfen ürünün hafıza kapasitesinin giriniz: ");
        int memory=input.nextInt();

        System.out.print("Lütfen ürünün ram miktarını giriniz: ");
        int ram=input.nextInt();

        System.out.print("Lütfen ürünün rengini giriniz "); input.nextLine();
        String color=input.nextLine();

        System.out.print("Lütfen ürünün fiyatını giriniz: ");
        int price=input.nextInt();

        System.out.print("Lütfen ürünün stok adedini giriniz: ");
        int quality=input.nextInt();

        System.out.print("Lütfen ürünün indirim oranını giriniz ");
        int discountRate=input.nextInt();


        Product newProduct=new Product(productName,ourBrand,screenSize,bataryPower,memory,ram,color,price,quality,discountRate);
        ourProductList.put(newProduct.getId(),newProduct);


    }

    /**Ürün silme için kullanılır
     *
     * @param ourProductList
     */
    public void deleteToProduct(HashMap<Integer, Product> ourProductList)
    {
        System.out.print("Lütfen silmek istediğiniz ürünün id'sini giriniz ");
        int id=input.nextInt();

        if (ourProductList.containsKey(id))
        {
            System.out.println("Bu id değerine sahip ürün yoktur..");
        }
        else
        {
            System.out.println(id+" ID numaralı ürün silinmiştir..");
            ourProductList.remove(id);
        }

    }

    /**Ürünleri listelemek için kullanılır
     *
     * @param ourProductList
     */
    public void listToProducts(HashMap<Integer, Product> ourProductList)
    {
        String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Batarya Kapasitesi     | Depolama Kapasitesi       | RAM Kapasitesi   | Renk                   | Fiyat                  | Adet             | İndirim Oranı          |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
           for (Product product:ourProductList.values())
           {
               System.out.format(format, product.getId(), product.getName(), product.getBrandOfPruduct().getName(), product.getScreenSize(), product.getBattaryPower(), product.getMemory(), product.getRam(), product.getColor(), product.getPrice(), product.getQuality(), product.getDiscountRate());
               System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
           }
    }

    /**Ürün filtrelemeyi id ve isim değerine göre mi gireceksiniz
     * bilgisini sormadan girilen değer sayıysa id;
     * değilse ürün ismine göre regex sayesinde otomotik arama yapma
     * @param ourProductList
     */
    public void searchByFilter(HashMap<Integer, Product> ourProductList)
    {
        System.out.println("Filtrele: "); input.nextLine();
        String filter=input.nextLine();
        
        if (filter.matches("\\d+"))//ID numarasına göre arama
        {
            int  ourFilter=Integer.parseInt(filter);
            if (ourProductList.containsKey(ourFilter))
            {
                Product product=ourProductList.get(ourFilter);
                String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Batarya Kapasitesi     | Depolama Kapasitesi       | RAM Kapasitesi   | Renk                   | Fiyat                  | Adet             | İndirim Oranı          |\n");
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                System.out.format(format, product.getId(), product.getName(), product.getBrandOfPruduct().getName(), product.getScreenSize(), product.getBattaryPower(), product.getMemory(), product.getRam(), product.getColor(), product.getPrice(), product.getQuality(), product.getDiscountRate());
                System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
            }
            else
            {
                System.out.println("Bu id numarasına sahip ürün bulunamadı");
            }


        }
        else if(filter.matches("\\D+"))//İsme göre arama
        {
            if (ourProductList.values().stream().anyMatch(p->p.getBrandOfPruduct().getName().equals(filter)))
            {
                for (Product product:ourProductList.values())
                {
                    if (product.getBrandOfPruduct().getName().equals(filter))
                    {
                        String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
                        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                        System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Batarya Kapasitesi     | Depolama Kapasitesi       | RAM Kapasitesi   | Renk                   | Fiyat                  | Adet             | İndirim Oranı          |\n");
                        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                        System.out.format(format, product.getId(), product.getName(), product.getBrandOfPruduct().getName(), product.getScreenSize(), product.getBattaryPower(), product.getMemory(), product.getRam(), product.getColor(), product.getPrice(), product.getQuality(), product.getDiscountRate());
                        System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
                    }
                }
            }
            else
            {
                System.out.println("Belirtilen marka ile eşleşen bir ürün bulunamadı");
            }

         }
        else
        {
            System.out.println("Filtreleme id veya markaya göre yapılıyor lütfen bu değerlerden birini giriniz");
        }
    }

}
