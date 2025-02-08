package Account;

import java.util.Scanner;
import java.util.TreeSet;

public class AccountMenager
{
    static Scanner input=new Scanner(System.in);
    TreeSet<Account> ourAccounts=new TreeSet<>();
   public Account login()
   {
       Account realAccount=null;
       Account tempAccount=null;
       System.out.println("Lütfen e-Mail adresini giriniz ");String eMail=input.nextLine();
       System.out.println("Lütfen şifreyi giriniz: ");String password=input.nextLine();
       if (ourAccounts.stream().anyMatch((p)->p.getUser().geteMail().equals(eMail)))
       {
           for (Account account:ourAccounts)
           {
               if (account.getUser().geteMail().equals(eMail))
                   tempAccount=account;
           }
           try
           {
               if (tempAccount.login(eMail,password)== Account.AuthenticationStatus.SUCCESS)
               {
                   realAccount=tempAccount;
               }
           }
           catch (InvalidAuthanticationStatus invalidAuthanticationStatus)
             {
                 System.out.println(invalidAuthanticationStatus.getMessage());
             }

       }
       return realAccount;

   }
}
