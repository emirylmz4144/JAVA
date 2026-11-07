import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static List<Integer> mainList=new ArrayList<>();
    public static ArrayList<Integer> dividedList=new ArrayList<>();
    public static ArrayList<Integer> indivisibleList=new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> fragmentedList=new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        for (int i=1;i<=10000;i++)
            mainList.add(i);

        for (int i=0;i<4;i++)
            fragmentedList.add(new ArrayList<>());

        for (int i=0;i<10000;i++)
            fragmentedList.get(i%4).add(mainList.get(i));

        for (int i=0;i<4;i++)
        {
            Thread thread=new Thread(new ThreadsForGrouping(fragmentedList.get(i%4),dividedList,indivisibleList));
            thread.start();
            /*main'de thread'tir bu olmazsa aşağıdaki kod satırlarını bilinmeyen bir yere verir
            threadler bittikten sonra aşağı geçmeyi sağlar */
             thread.join();
        }


        /*//Alternatif Çözüm
        ExecutorService threads= Executors.newFixedThreadPool(1);
        for (int i=0;i<4;i++)
           {
            threads.execute(new ThreadsForGrouping(fragmentedList.get(i%4),dividedList,indivisibleList));
           }
           threads.shutdown();
         */

        System.out.println(mainList.size());




    }
}