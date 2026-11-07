public class SecurityMan extends Officer
{
    private String document;
    SecurityMan(String nameSurname, String telNumber, String eMail, String depertment, int shift,String document) {
        super(nameSurname, telNumber, eMail, depertment, shift);
        this.document=document;
    }

    public String getDocument()
    {
        return document;
    }

    public void setDocument(String document)
    {
        this.document = document;
    }
    public String spell()
    {
        return super.getNameSurname()+" "+super.getDepertment()+" bölgesinde nöbete girdi";
    }
}
