package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class MainPage extends JFrame
{
    String userName;
    String password;
    public MainPage() {
        // Pencere özellikleri
        setTitle("Hastane Otomasyon sistemi");
        setSize(600, 600);
        setLocationRelativeTo(null);// Ekranda merkeze alınması için
        getContentPane().setLayout(null);// null yaparak conteinerı devre dışı bırakırız ve setBounds aktifleşir
        getContentPane().setBackground(Color.CYAN);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Görsel Ekleme
        ImageIcon gorsel = new ImageIcon("Images\\Sağlık bakanlığı logosu.png");
        JLabel imageLabel = new JLabel(gorsel);
        imageLabel.setBounds(260,100,75,75);
        add(imageLabel);



        // Görsel Boyutunu ayarlama
        Image gorselAyarlama=gorsel.getImage();
        Image newImage = gorselAyarlama.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        gorsel.setImage(newImage);

        //Label oluşturma ve metin ekleme
        JLabel hastaneAdi=new JLabel("TEKFİR MAHALLESİ" );
        add(hastaneAdi);
        JLabel hastaneAdi2=new JLabel("   SAĞLIK OCAĞI");
        add(hastaneAdi2);

        //Label konumu ve özellikleri ayarlama
        hastaneAdi.setBounds(240,160,280,80);
        hastaneAdi2.setBounds(245,175,280,80);

        //Kullanıcı adı alan Jlabel ve JTextField
        JLabel kullaniciAdi=new JLabel("Kullanıcı Adi: ");
        add(kullaniciAdi);
        kullaniciAdi.setBounds(120,245,200,60);

        JTextField kullaniciAdiField=new JTextField(18);
        add(kullaniciAdiField);
        kullaniciAdiField.setBounds(200,265,200,25);

        //Şifre alan Jlabel ve JPasword ayarlama
        JLabel sifre=new JLabel("Şifre: ");
        add(sifre);
        sifre.setBounds(150,315,200,20);

        JPasswordField sifreField=new JPasswordField();
        add(sifreField);
        sifreField.setBounds(200,315,200,25);



        // Buton oluşturma ve pencere'ye ekleme
        JButton loginButton = new JButton("GİRİŞ YAP");
        add(loginButton);
        loginButton.setBounds(220,380,140,40);




        // Butona tıklama olayını dinleme
        loginButton.addActionListener(new ActionListener()
       {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 userName = kullaniciAdiField.getText();
                 password = sifreField.getText();

                String correctPassword = "tekfirHospital4144";


                if (userName.equals("tekfirHospital") && correctPassword.equals(password))
                {
                    // SecondPage nesnesi oluşturma ve gösterme
                    ActionsPage anaSayfa = new ActionsPage();
                    anaSayfa.setVisible(true);

                }
                else
                {

                    // Hata penceresi oluşturma
                    JFrame errorWindow = new JFrame("HATA");
                    errorWindow.setSize(400, 200);
                    errorWindow.setLocationRelativeTo(null);
                    errorWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Hata mesajı oluşturma
                    JLabel errorLabel = new JLabel("Hatalı kullanıcı adı veya şifre girdiniz.");
                    errorLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
                    errorWindow.add(errorLabel, BorderLayout.CENTER);

                    // Tamam düğmesi oluşturma
                    JButton okButton = new JButton("Tamam");
                    okButton.addActionListener(e1 -> errorWindow.dispose());
                    errorWindow.add(okButton, BorderLayout.SOUTH);

                    // Hata penceresini gösterme
                    errorWindow.setVisible(true);
                }
            }
        });


        //Şifreyi isteğe bağlı görünür kılma
        JCheckBox showPasswordCheckBox = new JCheckBox("Şifreyi Göster");
        add(showPasswordCheckBox);
        showPasswordCheckBox.setBounds(400,303,200,50);
        showPasswordCheckBox.setBorderPainted(false);
        showPasswordCheckBox.setBackground(Color.CYAN);

        // Checkbox'a tıklama olayını dinleme
        showPasswordCheckBox.addActionListener(new ActionListener()
       {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (showPasswordCheckBox.isSelected())
                {
               // Şifre göster
                    sifreField.setEchoChar((char) 0);
                } else
                {
                // Şifre gizle
                    sifreField.setEchoChar('*');
                }
            }
       });
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


