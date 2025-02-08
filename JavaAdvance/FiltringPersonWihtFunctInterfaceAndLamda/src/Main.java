import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static List<Person> persons=new LinkedList<Person>();
    public static void main(String[] args)
    {
        //Örnek olması açısından birkaç adet person nesnesi eklenmiştir
        persons.add(new Person("emir",21, Person.Gender.Erkek));
        persons.add(new Person("bilal",24,Person.Gender.Erkek));
        persons.add(new Person("hilal",26,Person.Gender.Kadın));
        /*
        İşte burası aşırı önemli çünki sembolik şekilde nesne tutması ve tutulan bu nesneye ne yapılacağı burada belirlenir yani
        kesinlikle burada değer ataması işlemi yapmıyoruz burası biraz kafa karıştırıyor burada yapılan işlem değer ataması değil
        değer geldiğinde var olan değere neyin yapılacağı işleminin tanımlanmasıdır.
        ZATEN newPerson diye bir nesne yoktur burada biz sembolik olarak ne değer alacağını belirliyoruz
         */
        listByFilter(persons,(newPerson)->newPerson.getGender().equals(Person.Gender.Erkek));

    }
    /*Burada ise var olan değer atamasını gerçekleştirmek için real bir değer oluşturuyoruz yani burada oluşan nesneye gerçek değer ataması yapılacaktır
     yani bu örnekte boolean değer olduğu için boolean ataması yapacağız*/
    public static void listByFilter(List<Person> ourList, FiltringToPerson filtringWithPerson)//2.virgülden sonra gerçek nesne ataması için bir instance oluşturyoruz
    {
        for (Person person:ourList)
        {
            //Halihazırda var olan listemize atama yapıyoruz.
            if (filtringWithPerson.filter(person))
            {
                System.out.println(person);
            }
        }
    }
}
