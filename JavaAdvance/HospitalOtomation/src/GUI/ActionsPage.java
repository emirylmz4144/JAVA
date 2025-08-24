package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ActionsPage extends JFrame
{
    public ActionsPage()  {
        // Pencere özellikleri
        setTitle("İşlemler");
        setSize(600, 600);
        setLocationRelativeTo(null);// Ekranda merkeze alınması için
        getContentPane().setLayout(null);// null yaparak conteinerı devre dışı bırakırız ve setBounds aktifleşir
        setResizable(false);
        Color color=new Color(188, 243, 255);
        getContentPane().setBackground(color);

        setDefaultCloseOperation(EXIT_ON_CLOSE);





        // hasta işlemleri için görsel
        ImageIcon hastaIslemleri = new ImageIcon("Images\\hastaIslemleri.jpg");
        JLabel hastaLabel = new JLabel(hastaIslemleri);
        hastaLabel.setBounds(205,40,180,120);
        add(hastaLabel);

        //resme tıklama olayları
        hastaLabel.addMouseListener(new MouseListener() {

            // Daha sonra eklenecek olan bilgilendirme mesajı
            JLabel bilgiMesaji=new JLabel("HASTA İŞLEMLERİ");
            JLabel bilgiMesaji2=new JLabel("RANDEVU ALMA");
            JLabel bilgiMesaji3=new JLabel("HASTA ÇIKIŞ");


            //Tıklama olayında yeni sayfa açılacak
            @Override
            public void mouseClicked(MouseEvent e)
            {
                PatientActionsPage patientActionsPage=new PatientActionsPage();
                patientActionsPage.setVisible(true);

                dispose();

            }

            //Resmin üzerine geldiğimizde oluşacak eylemler
            @Override
            public void mouseEntered(MouseEvent e) {
                hastaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                hastaLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                add(bilgiMesaji);
                bilgiMesaji.setForeground(Color.GREEN);
                bilgiMesaji.setBounds(30,70,140,60);
                add(bilgiMesaji2);
                bilgiMesaji2.setForeground(Color.blue);
                bilgiMesaji2.setBounds(420,40,140,80);
                add(bilgiMesaji3);
                bilgiMesaji3.setBounds(420,80,140,80);
                bilgiMesaji3.setForeground(Color.blue);
            }

            // Resim alanından çıkıldığında ise oluşacak eylemler
            @Override
            public void mouseExited(MouseEvent e) {
                hastaLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                hastaLabel.setBorder(null);
                bilgiMesaji.setBounds(-1,-1,-1,-1);
                bilgiMesaji2.setBounds(-1,-1,-1,-1);
                bilgiMesaji3.setBounds(-1,-1,-1,-1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });







        ImageIcon doktorIslemleri = new ImageIcon("Images\\doktorAnimasyon2.jpg");
        JLabel doktorLabel = new JLabel(doktorIslemleri);
        doktorLabel.setBounds(205,180,180,120);
        add(doktorLabel);

        doktorLabel.addMouseListener(new MouseListener() {

            // Daha sonra eklenecek olan bilgilendirme mesajı
            JLabel bilgiMesaji=new JLabel("DOKTOR İŞLEMLERİ");
            JLabel bilgiMesaji2=new JLabel("DOKTOR EKLE");
            JLabel bilgiMesaji3=new JLabel("DOKTOR SİL");


            //Tıklama olayında yeni sayfa açılacak
            @Override
            public void mouseClicked(MouseEvent e)
            {
                DoctorActionsPage doctorActionsPage=new DoctorActionsPage();
                doctorActionsPage.setVisible(true);

                dispose();
            }

            //Resmin üzerine geldiğimizde oluşacak eylemler
            @Override
            public void mouseEntered(MouseEvent e) {
                doktorLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                doktorLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
                add(bilgiMesaji);
                bilgiMesaji.setForeground(Color.GREEN);
                bilgiMesaji.setBounds(30,210,140,60);
                add(bilgiMesaji2);
                bilgiMesaji2.setForeground(Color.blue);
                bilgiMesaji2.setBounds(420,175,140,80);
                add(bilgiMesaji3);
                bilgiMesaji3.setForeground(Color.blue);
                bilgiMesaji3.setBounds(420,220,140,80);
            }

            // Resim alanından çıkıldığında ise oluşacak eylemler
            @Override
            public void mouseExited(MouseEvent e) {
                doktorLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                doktorLabel.setBorder(null);
                bilgiMesaji.setBounds(-1,-1,-1,-1);

                bilgiMesaji2.setBounds(-1,-1,-1,-1);
                bilgiMesaji3.setBounds(-1,-1,-1,-1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });








        ImageIcon adminIslemleri = new ImageIcon("Images\\adminIslemleri.jpg");
        JLabel adminLabel = new JLabel(adminIslemleri);
        adminLabel.setBounds(205,340,180,120);
        add(adminLabel);





        adminLabel.addMouseListener(new MouseListener() {

            // Daha sonra eklenecek olan bilgilendirme mesajı
            JLabel bilgiMesaji=new JLabel("ADMİN İŞLEMLERİ");
            JLabel bilgiMesaji2=new JLabel("ŞİFRE DEĞİŞTİR");



            //Tıklama olayında yeni sayfa açılacak
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            //Resmin üzerine geldiğimizde oluşacak eylemler
            @Override
            public void mouseEntered(MouseEvent e) {
                adminLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                adminLabel.setBorder(BorderFactory.createLineBorder(Color.RED));

                add(bilgiMesaji);
                bilgiMesaji.setBounds(30,375,140,60);
                add(bilgiMesaji2);
                bilgiMesaji.setForeground(Color.GREEN);
                bilgiMesaji2.setBounds(420,365,140,80);
                bilgiMesaji2.setForeground(Color.blue);

            }

            // Resim alanından çıkıldığında ise oluşacak eylemler
            @Override
            public void mouseExited(MouseEvent e) {
                adminLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                adminLabel.setBorder(null);
                bilgiMesaji.setBounds(-1,-1,-1,-1);
                bilgiMesaji2.setBounds(-1,-1,-1,-1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });



        // Geri düğmesi oluşturma ve pencere'ye ekleme
        JButton backButton = new JButton("Geri");
        add(backButton);
        backButton.setBounds(20,500,75,35);



        // Geri düğmesine tıklama olayını dinleme
        backButton.addActionListener(e ->
        {
            // Ana sayfayı tekrar açma
            MainPage mainPage = new MainPage();
            mainPage.setVisible(true);

            // SecondPage'i kapatma
            dispose();
        });


    }
}
