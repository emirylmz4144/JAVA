/*
AddBonusMoney adlı bir sınıfımızı Employee sınıfında sadece işçi bilgileri olması için
Yani solid prensibine uymak ve kodun anlaşılmasını kolaylaştırmak için oluşturduk
 */
public class AddBonusMoney

{
    /*  Employe adlı class'ı buraya aktardıkçünki işçinin tüm maaş güncellemeleri burada olacak */
    Employee employee;
    int nowYear;

    public AddBonusMoney(Employee employee)
    {
        this.employee = employee;
        this.nowYear=2021;
    }

//Girilecek olan employee sınıfımıza maaş zamlarını igili metotlarda uyguluyoruz

    double calculateTax()
    {
        double taxQuality =calculateSaleryWithoutTax();   // Zam hesaplamasını gerçek hayata uygun olması
        if (this.employee.salary >= 15000)                 // maksadıyla önce bonusları ekleyip ardından// zam hesaplama metoduna aktardım
            taxQuality = ((taxQuality)*(0.03)); // Vergi miktarı hesaplanıyor
        else
        {
            System.out.println("Çalışan maaşı "+this.employee.salary" TL den az olduğu için vergi muafiyetine tabiidir.");
            taxQuality = 0.0;
        }
        return taxQuality;
    }

    double bonus()
    {
        double workBonus = 0;
        if (this.employee.workHours >= 40)
            workBonus = ((this.employee.workHours - 40) * 30) * 40;// Haftalık zam hesaplanıp aylığa dönüştürlüyor
        else
            System.out.println("Çalışan haftada 40 saatten az çalıştığı için bonus alamamaktadır");

        return workBonus;
    }

    // Çalışanın çalışma yılına göre ek ücret hesapmaması yapılıyor
    double raiseSalary()
    {
        int workYear=this.nowYear-this.employee.hireYear;
        double yearBonus=0.0;
        if(workYear<10)
            yearBonus=((this.employee.salary)*(0.03));
        else if (workYear<20)
            yearBonus=((this.employee.salary)*(0.1));
        else if (workYear<30)
            yearBonus=((this.employee.salary)*(0.15));


        return yearBonus;
    }


       /*
         Maaşa ek ücret ödemesi için metotları her seferinde yeniden çağırmamak için
         Solid prensiplerine uymak ve temiz kod yazmak maksadı ile zam miktarınını vergiyi çıkarmadan
         olan halini hesaplayan bir metot
         */
    double calculateSaleryWithoutTax()
    {
        return (this.employee.salary+bonus()+raiseSalary());
    }

    /*
    Çalışanın vergi ödenerek hesaplanacak olan toplamda alacağı net ücreti hesaplayan metotu
    temiz kod yazmak maksadı için oluşturuyoruz
     */
    double workerRealSalary()
    {
        return this.employee.salary=(calculateSaleryWithoutTax()-calculateTax());
    }

    /*
    Yani işçiye uygulanacak zamları işçiye ait sınıfta oluşturmak ona ait olmayan özelliği
    ona aktarmak gibi geldiği için Employee sınıfına sadece işçiye ait bilgiler ve yanıyacak olan
    ek üçretler vergilendirmeleri aktarmak Solid prensipleri ve temiz kod yazmak açısından daha kolaydır
    Ayrıca metotları metotlar için bir oluşturarak birbiri ile bağlantılı olmasını
    böylece teker teker metot çağırmayı engellemek istedim
   tüm metotlar birbirine bağlanıp sonra hepsini kapsayacak bir metot oluşturmak daha kullanışlı bir yapıya
   sahiptir.
     */
}
