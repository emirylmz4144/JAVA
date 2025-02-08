package GUI;

import HospitalOtomation.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDeletePage extends JPanel
{
    List<Doctor> doktorlar;

    public DoctorDeletePage()
    {
        Color color=new Color(188, 243, 255);
        setBackground(color);
        setLayout(null);
        String [] columnNames= {"ID", "Ad", "Soyad", "Cinsiyet", "Yaş ","Branş"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(0,0,585,400);




        JButton goruntule=new JButton("GÖRÜNTÜLE");
        add(goruntule);
        goruntule.setBounds(220,420,150,75);
        //Tıklandığında doktorları görüntüler

        goruntule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                model.setRowCount(0);//Veriler üst üste binmesin diye tuşa basınca siler ve aşağıdaki kod ile yine yazar
                doktorlar = dosyadanSil();
                 // dosyadan doktor bilgilerini oku
                // veri modeli olarak DefaultTableModel nesnesi kullanılır

                for (Doctor doktor : doktorlar)
                {
                    Object[] row = {doktor.getId(), doktor.getName(), doktor.getSurName(), doktor.getGenter(), doktor.getAge(), doktor.getBranch()};
                    model.addRow(row);
                }
            }
        });



        JButton doktorSil=new JButton("Sil");
        add(doktorSil);
        doktorSil.setBounds(125,440,100,50);

        doktorSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                Doctor doctor = doktorlar.get(selectedRow);
                doktorlar.remove(selectedRow);
                doktorlar.remove(doctor);


                //Silme işlemi
               try {
                   BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.txt"));
                   for (Doctor d : doktorlar) {
                       String line = d.getId() + "," + d.getName() + "," + d.getSurName() + "," + d.getGenter() + "," + d.getAge() + "," + ((Doctor) d).getBranch();
                       writer.write(line);
                       writer.newLine();
                   }
                   writer.close();
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }
            }
        });
    }

    List<Doctor> dosyadanSil()
    {
         doktorlar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("doctor.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String ad = parts[1];
                String soyad = parts[2];
                String cinsiyet = parts[3];
                String yas=parts[4];
                String brans = parts[5];
                Doctor doktor = new Doctor(id,ad,soyad,cinsiyet,yas,brans);
                doktorlar.add(doktor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doktorlar;
    }

}
