package GUI;

import HospitalOtomation.Doctor;
import HospitalOtomation.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDeletePage extends JPanel
{
    List<Patient> hastalar;
    public AppointmentDeletePage()
    {
        Color color=new Color(188, 243, 255);
        setBackground(color);
        setLayout(null);
        String [] columnNames= {"Sıra", "Tc", "Ad", "Soyad", "Yaş", "Doktor"};
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
                hastalar = dosyadanSil();
                // dosyadan doktor bilgilerini oku
                // veri modeli olarak DefaultTableModel nesnesi kullanılır

                for (Patient hasta : hastalar)
                {
                    Object[] row = {hasta.getId(), ((Patient) hasta).getTc(), hasta.getName(), hasta.getSurName(), hasta.getGenter(), hasta.getAge()};
                    model.addRow(row);
                }
            }
        });



        JButton hastaSil=new JButton("Sil");
        add(hastaSil);
        hastaSil.setBounds(125,440,100,50);

        hastaSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                Patient hasta = hastalar.get(selectedRow);
                hastalar.remove(selectedRow);
                hastalar.remove(hasta);


                //Silme işlemi
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"));
                    for (Patient d : hastalar) {
                        String line = d.getId() + "," + ((Patient) d).getTc() + "," + d.getName() + "," + d.getSurName() + "," + d.getGenter() + "," + d.getAge();
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

    List<Patient> dosyadanSil()
    {
        hastalar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String tc = parts[1];
                String ad = parts[2];
                String soyad = parts[3];
                String cinsiyet=parts[4];
                String doktor = parts[5];
                Patient ourPatient = new Patient(id,tc,ad,soyad,cinsiyet,doktor);
                hastalar.add(ourPatient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hastalar;
    }

}
