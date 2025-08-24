public class Employee
{
    String name;
    double salary;
    int  workHours;
    int hireYear;

    public Employee(String name, int salary, int workHours, int hireYear)
    {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    /*
    Burada ise AddBonusMoney adlı classtan yeni bir nesne oluşturarak tıpkı
    işçiyi muhasebeciye gönderir gibi kendisine ait bilgileri muhasebeciye vermesini(addBonusMoney)
    istemekteyiz gibi writeInformations metodu oluşturduk böylece tek bir metotla hem gerçek hayata
    çok benzer şekilde AddInformationsMoney sınıfındaki ek ücretleri belirledik
    hemde oradaki herşeye temiz ve Solid prensibi mantığı ile ulaşabildik
     */
    void writeInformations(AddBonusMoney addBonusMoney)
    {
        System.out.println("Çalışanın Adı: "+this.name);
        System.out.println("Çalışanın Maaşı: "+this.salary);
        System.out.println("Çalışanın Haftalık çalışma saati: "+this.workHours);
        System.out.println("Çalışan Çalışma Yılı "+this.hireYear);
        System.out.println("Çalışan Aylık mesai ücreti: "+addBonusMoney.bonus());
        System.out.println("Çalışanın tecrübe ücreti : "+addBonusMoney.raiseSalary());
        System.out.println("Çalışanın vergisiz Maaşı: "+addBonusMoney.calculateSaleryWithoutTax());
        System.out.println("Çalışandan kesilen vergi ücreti: "+addBonusMoney.calculateTax());
        System.out.println("Çalışa ödenecek ücret: "+addBonusMoney.workerRealSalary());

    }


}

















