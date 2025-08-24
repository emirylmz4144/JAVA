package ObjectSerializable;

import java.io.*;

public class Object_InputOutput_StreamClass
{
    public static void main(String[] args) {
        Car newCar=new Car("Audi","benz",100);

        try
        {

            // Serileştirilen objenin dosyaya aktarılışı
            FileOutputStream fileOutputStream=new FileOutputStream("car.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(newCar);

            //Serileştirilen objenin dosyadan alınması

            FileInputStream fileInputStream=new FileInputStream("car.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            Car ourCar=(Car) objectInputStream.readObject();

            System.out.println(ourCar.getBrand());
            System.out.println(ourCar.getName());
            System.out.println(ourCar.getPrice());

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getStackTrace());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());;
        }
    }


}



