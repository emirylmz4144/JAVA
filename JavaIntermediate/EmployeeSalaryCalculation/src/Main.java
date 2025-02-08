public class Main {
    public static void main(String[] args)
    {
        /*
        Planladığımız şekilde uzun uzun metotlar ve işlevler yapmadan temiz bir şekilde
        çalışanımızı oluşturduk sonra ona ait bilgileri sanki bir muhasebeciye veriyormuşçasına
        yeni bir AddBonusMoney nesnesi oluşturduk böylece kısa ve öz şekilde çalışana ait
        ek ücretleri hesaplamış olduk
         */

        Employee employee=new Employee("Emir",2000,50,2002);
        employee.writeInformations(new AddBonusMoney(employee));
    }
}