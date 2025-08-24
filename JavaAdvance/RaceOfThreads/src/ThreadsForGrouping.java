import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreadsForGrouping implements Runnable {

    private static final Object _LOCK=new Object();
    private List<Integer> dividedList;
    private List<Integer> indivisibleList;
    private List<Integer> willBreakinList;

    public ThreadsForGrouping(ArrayList<Integer> willBreakinList,ArrayList<Integer> dividedList,ArrayList<Integer>indivisibleList)
    {
        this.willBreakinList=willBreakinList;
        this.dividedList=dividedList;
        this.indivisibleList=indivisibleList;
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(200);

            for (int i:willBreakinList)
            {
                synchronized (_LOCK)//hangi listeye senkronizasyon yapmak istiyorsan içeriye onu yazabilirsin
                {
                    if (i%2==0)
                    {
                        System.out.println(Thread.currentThread().getName()+" threadi ile bölünen listesine "+i+" eklenmiştir");
                        dividedList.add(i);
                    }
                    else
                    {
                        System.out.println(Thread.currentThread().getName()+" threadi ile bölünemeyen listesine "+ i+" eklenmişir");
                        indivisibleList.add(i);

                    }


                }
            }

        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public List<Integer> getDividedList() {
        return dividedList;
    }

    public void setDividedList(List<Integer> dividedList) {
        this.dividedList = dividedList;
    }

    public List<Integer> getIndivisibleList() {
        return indivisibleList;
    }

    public void setIndivisibleList(List<Integer> indivisibleList) {
        this.indivisibleList = indivisibleList;
    }

    public List<Integer> getWillBreakinList() {
        return willBreakinList;
    }

    public void setWillBreakinList(List<Integer> willBreakinList) {
        this.willBreakinList = willBreakinList;
    }
}
