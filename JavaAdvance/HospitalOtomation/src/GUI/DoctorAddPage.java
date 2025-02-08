package GUI;

import HospitalOtomation.*;

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

public class DoctorAddPage extends JPanel {
    private JLabel labelName, labelSurname, labelBranch, labelAge, labelGender;
    private JTextField fieldName, fieldSurname,  fieldBranch, fieldAge, fieldGender;
    private JButton buttonSave;
    public  static int id=1;

    public DoctorAddPage() {

        // Tabbed Pane renklendirme
        Color color=new Color(188, 243, 255);
        setBackground(color);

        //Label oluşturma
        setLayout(null);
        labelName = new JLabel("DOKTOR ADI :");
        labelSurname = new JLabel("DOKTOR SOYADI :");
        labelGender = new JLabel("DOKTOR CİNSİYETİ: ");
        labelAge = new JLabel("DOKTOR YASI: ");
        labelBranch = new JLabel("DOKTOR BRANSI: ");
        fieldName = new JTextField(20);
        fieldSurname = new JTextField(20);
        fieldGender = new JTextField(20);
        fieldAge = new JTextField(20);
        fieldBranch = new JTextField(20);
        buttonSave = new JButton("Kaydet");

        //Label ekleme ve Fieldi Tabbed Pane'ye ekleme
        add(labelName);
        add(fieldName);
        add(labelSurname);
        add(fieldSurname);
        add(labelBranch);
        add(fieldBranch);
        add(labelAge);
        add(fieldAge);
        add(labelGender);
        add(fieldGender);
        add(buttonSave);

        //Label konumlandırma
        labelName.setBounds(35,30,140,40);
        labelSurname.setBounds(10,100,140,40);
        labelGender.setBounds(0,170,140,40);
        labelAge.setBounds(30,240,140,40);
        labelBranch.setBounds(20,310,140,40);
        buttonSave.setBounds(10,390,200,50);


        labelName.setForeground(Color.GREEN);
        labelSurname.setForeground(Color.GREEN);
        labelGender.setForeground(Color.GREEN);
        labelAge.setForeground(Color.GREEN);
        labelBranch.setForeground(Color.GREEN);



        //Field Konumlandırma
        fieldName.setBounds(120,35,140,30);
        fieldSurname.setBounds(120,105,140,30);
        fieldGender.setBounds(120,175,140,30);
        fieldAge.setBounds(120,245,140,30);
        fieldBranch.setBounds(120,315,140,30);



        buttonSave.addActionListener(new ActionListener()
        {
            //Dosyaya kaydetme işlemi
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String name=fieldName.getText();
                String surName=fieldSurname.getText();
                String genter=fieldGender.getText();
                String age=fieldAge.getText();
                String branch=fieldBranch.getText();

                if (fieldName.getText().trim().isEmpty() || fieldSurname.getText().trim().isEmpty() || fieldBranch.getText().trim().isEmpty() || fieldAge.getText().trim().isEmpty() || fieldGender.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Tüm alanları doldurmadınız", "Hata", JOptionPane.ERROR_MESSAGE);
                }

                else
                {
                    id++;
                    String StringId= Integer.toString(id);
                    Person person=new Doctor(StringId,name,surName,genter,age,branch);
                    try
                    {
                        FileWriter writer = new FileWriter("doctor.txt", true);
                        writer.write(person.getId()+","+person.getName()+","+ person.getSurName()+ ","+ person.getGenter()+","+ person.getAge() +","+((Doctor) person).getBranch()+ "\n");
                        writer.close();
                    }
                    catch (IOException m)
                    {
                        System.out.println("Dosya bulunamadı..");
                    }
                    //Doktorlar listelenecek

                    String[] columnNames = {"ID", "Ad", "Soyad", "Cinsiyet", "Yaş", "Branş"};
                    List<Doctor> doktorlar = dosyadanOku(); // dosyadan doktor bilgilerini oku
                    // veri modeli olarak DefaultTableModel nesnesi kullanılır
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    for (Doctor doktor : doktorlar)
                    {
                        Object[] row = {doktor.getId(), doktor.getName(), doktor.getSurName(), doktor.getGenter(), doktor.getAge(), ((Doctor) person).getBranch()};
                        model.addRow(row);
                    }
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    add(scrollPane);
                    scrollPane.setBounds(280,20,299,400);

                    // Textleri Temizleme
                    fieldName.setText("");
                    fieldSurname.setText("");
                    fieldBranch.setText("");
                    fieldAge.setText("");
                    fieldGender.setText("");
                }

            }});
        }

    List<Doctor> dosyadanOku()
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
