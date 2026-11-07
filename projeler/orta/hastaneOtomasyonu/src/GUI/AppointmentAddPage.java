package GUI;

import HospitalOtomation.Doctor;
import HospitalOtomation.Patient;
import HospitalOtomation.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentAddPage extends JPanel
{
    private JLabel labelName, labelSurname, labelTc, labelAge, labelDoctor;
    private JTextField fieldName, fieldSurname, fieldTc, fieldAge, fieldDoctor;
    private JButton buttonSave;
    public  static int id=0;
    public AppointmentAddPage()
    {
        // Tabbed Pane renklendirme
        Color color=new Color(188, 243, 255);
        setBackground(color);

        //Label oluşturma
        setLayout(null);
        labelTc = new JLabel("HASTA TC NO :");
        labelName = new JLabel("HASTA ADI :");
        labelSurname = new JLabel("HASTA SOYADI :");
        labelAge = new JLabel("HASTA YASI: ");
        labelDoctor = new JLabel("MUAYENE DOKTOR:  ");

        fieldName = new JTextField(20);
        fieldSurname = new JTextField(20);
        fieldAge = new JTextField(20);
        fieldTc = new JTextField(20);
        fieldDoctor = new JTextField(20);
        buttonSave = new JButton("Kaydet");

        //Label ekleme ve Fieldi Tabbed Pane'ye ekleme
        add(labelName);
        add(fieldName);
        add(labelSurname);
        add(fieldSurname);
        add(labelTc);
        add(fieldTc);
        add(labelAge);
        add(fieldAge);
        add(labelDoctor);
        add(fieldDoctor);
        add(buttonSave);

        //Label konumlandırma
        labelTc.setBounds(30,30,140,40);
        labelName.setBounds(30,100,140,40);
        labelSurname.setBounds(20,170,140,40);
        labelAge.setBounds(35,240,140,40);
        labelDoctor.setBounds(0,310,140,40);
        buttonSave.setBounds(10,390,200,50);


        labelName.setForeground(Color.GREEN);
        labelSurname.setForeground(Color.GREEN);
        labelDoctor.setForeground(Color.GREEN);
        labelAge.setForeground(Color.GREEN);
        labelTc.setForeground(Color.GREEN);



        //Field Konumlandırma
        fieldTc.setBounds(120,35,140,30);
        fieldName.setBounds(120,105,140,30);
        fieldSurname.setBounds(120,175,140,30);
        fieldAge.setBounds(120,245,140,30);
        fieldDoctor.setBounds(120,315,140,30);



        buttonSave.addActionListener(new ActionListener()
        {
            //Dosyaya kaydetme işlemi
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String StringId= Integer.toString(id);
                String Tc= fieldTc.getText();
                String name=fieldName.getText();
                String surName=fieldSurname.getText();
                String genter= fieldDoctor.getText();
                String age=fieldAge.getText();
                ;

                if (fieldName.getText().trim().isEmpty() || fieldSurname.getText().trim().isEmpty() || fieldTc.getText().trim().isEmpty() || fieldAge.getText().trim().isEmpty() || fieldDoctor.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Tüm alanları doldurmadınız", "Hata", JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    id++;
                    String stringId=Integer.toString(id);
                    Person person=new Patient(StringId,name,surName,genter,age,Tc);
                    try
                    {
                        FileWriter writer = new FileWriter("patients.txt" , true);
                        writer.write(stringId+","+((Patient) person).getTc()+","+ person.getName()+ ","+ person.getSurName()+","+ person.getAge() +","+((Patient) person).getTc()+ "\n");
                        writer.close();
                    }
                    catch (IOException m)
                    {
                        System.out.println("Dosya bulunamadı..");
                    }
                    //Doktorlar listelenecek

                    String[] columnNames = {"Sıra", "Tc", "Ad", "Soyad", "Yaş", "Doktor"};
                    List<Patient> hastalar = dosyadanOku(); // dosyadan doktor bilgilerini oku
                    // veri modeli olarak DefaultTableModel nesnesi kullanılır
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    for (Patient hasta : hastalar)
                    {
                        Object[] row = {hasta.getId(), ((Patient) person).getTc(), hasta.getName(), hasta.getSurName(), hasta.getGenter(), hasta.getAge()};
                        model.addRow(row);
                    }
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    add(scrollPane);
                    scrollPane.setBounds(280,20,299,400);

                    // Textleri Temizleme
                    fieldName.setText("");
                    fieldSurname.setText("");
                    fieldTc.setText("");
                    fieldAge.setText("");
                    fieldDoctor.setText("");
                }

            }});
    }

    List<Patient> dosyadanOku()
    {
        List<Patient> hastalar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String tc = parts[1];
                String ad = parts[2];
                String soyad = parts[3];
                String cinsiyet=parts[4];
                String yas = parts[5];
                Patient patient=new Patient(id,tc,ad,soyad,cinsiyet,yas);
                hastalar.add(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hastalar;
    }
    List<Doctor> dosyadanOku2()
    {
        List<Doctor> doktorlar = new ArrayList<>();
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
