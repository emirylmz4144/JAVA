public class OurList <Type>
{

    private Type [] array;
    private Type [] tempArray;
    private int size=0;
    private int capasity;



    // Default consturtor
    public  OurList()
    {
        this.capasity=10;// default olarak tanımlanan kapasite
        this.array=(Type[]) new Object[this.capasity];
    }



    //Belirlenen constructor
   public OurList(int capasity)
    {
        this.capasity=capasity;
        this.array=(Type[]) new Object[this.capasity];
    }

    public void insert(Type newValue)
    {
        size++;
        setNewArray();
        array[size-1]=newValue;

    }

    /*
   Projenin en önemki kısmı işte burada başlamaktadır çünki her kapasite aşımında dizinin boyutu aşağıdaki kodlarla
   güncelllenmektedir.
    */
    public void setNewArray()
    {
        if (size>=capasity)
        {
            this.capasity=this.capasity+10;//Kapasite arttırılmaktadır
            templateToFakeArray();//Dizi boyutu arttırılacağı için dizi sahte bir diziye aktarılıyor
            this.array=(Type[]) new Object[this.capasity];//Burada yeni dizi oluşmaktadır
            templateToRealArray();//Sahte diziye atanan dizi ve yeni kapasite oluşumundan kapasitesi tekrar belirlenen diziye sahte dizideki verileri aktarırlır
        }
    }



    public void templateToFakeArray()
    {
        /*
        *Çünki constuructorlarda tanımlama yaparsam ve geçici dizinin boyutunu constuructorlarda yaparsam
        * geçici değişkenin boyu her zaman 10 kalacak ve bir kereliğine bizim projemiz artacak be ana dizi
        * bir kereliğine 20 boyutuna ulaşacak 21 boyutunu geçtikten sonra ana dizi 20 olduğu için sahte diziye kopyalama
        * işlemi gerçekleşemez çünki sahte dizi 10 boyutundaki sahte diziye ana dizi kopyalanamaz ve hata alırız..
        * Bu sebepten dolayı sahta diziye yapılacak her kopyalama işleminde sahte dizinin boyutu her seferinde yeniden
        * tanımlanmak zorundadır
         */
        tempArray=(Type[]) new Object[this.capasity];
        for(int i=0;i<size;i++)
        {
            tempArray[i]=array[i];
        }
    }


    /*
    *Kopyalanan diziyi ana diziye tekrar atıyoruz
     */
    public void templateToRealArray()
    {
        for (int i=0;i<size;i++)
        {
            array[i]=tempArray[i];
        }
    }



    public void update(Type value,Type newValue)
    {
        for (int i=0;i<capasity;i++)
        {
            if (value==array[i])
            {
                array[i]=newValue;
            }
        }
    }


    public Type search(Type value)
    {
        for (int i=0;i<this.capasity;i++)
        {
            if (value==array[i])
            {
                System.out.println("Aradığınız değer dizinin "+(i+1)+".sırasındadır..");
                return value;
            }
        }
        System.out.println("Aradığınız eleman listede bulunamamıştır..");
        return null;
    }

    public void delete (Type value)
    {
        int i=0;

        while (i<this.capasity)
        {
            if (array[i]==value)
            {
                /*
                *Elemanı bulur ve bulunan elemandan sonraki sırayı silinecek elemandan başlayarak
                * sırası ile kaydırır böylece eleman otomotik silinir
                 */
                for (int j=i;j<this.capasity;j++)
                {
                    array[i]=array[i+1];
                }
                this.size--;//Ve boyutu küçülterek bir sonraki eleman ekleme işlemini tamamen yeni bir eleman ekleme şekline ayarlar
            }
            i++;
        }
    }

    public void print()
    {
        System.out.print("[ ");
        for (int i=0;i<size;i++)
        {
            System.out.print(array[i]+" , ");
        }
        System.out.print("]");
    }


    public int getCapasity()
    {
        return this.capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
