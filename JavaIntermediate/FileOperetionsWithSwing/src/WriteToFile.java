import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.SwingConstants;
public class WriteToFile {

    private JFrame frame;
    private JTextField txtAdSoyad;
    private JTextField txtNumara;
    private JTextField txtBolum;
    private JTextField txtDosyaAd;

    public static void main(String[] args)
    {
        try
        {
            WriteToFile window = new WriteToFile();
            window.frame.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public WriteToFile()
    {
        run();
    }


    private void run() {
        //Frame oluşturulur
        frame = new JFrame();
        //Frame'e ait özellikler belirlenir
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        //Arayüz görünümleri ayarlanır
        JLabel lblAdSoyad = new JLabel("Öğrenci Adı Soyadı");
        lblAdSoyad.setBounds(85, 150, 150, 24);
        frame.getContentPane().add(lblAdSoyad);

        JLabel lblNumara = new JLabel("Öğrenci Numarası");
        lblNumara.setBounds(85, 200, 150, 24);
        frame.getContentPane().add(lblNumara);

        JLabel lblBolum = new JLabel("Öğrenci Bölümü");
        lblBolum.setBackground(Color.GREEN);
        lblBolum.setBounds(85, 250, 250, 24);
        frame.getContentPane().add(lblBolum);

        txtAdSoyad = new JTextField();
        txtAdSoyad.setBounds(200, 150, 143, 24);
        frame.getContentPane().add(txtAdSoyad);
        txtAdSoyad.setColumns(10);

        txtNumara = new JTextField();
        txtNumara.setBounds(200, 200, 250, 22);
        frame.getContentPane().add(txtNumara);
        txtNumara.setColumns(10);


        txtBolum = new JTextField();
        txtBolum.setBounds(200, 250, 250, 22);
        frame.getContentPane().add(txtBolum);
        txtBolum.setColumns(10);

        //Aksiyon alındığında kullanıcıya gösterilecek mesaj companenti ayarlanır
        final JLabel lblMesaj = new JLabel("");
        lblMesaj.setForeground(Color.GREEN);
        lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
        lblMesaj.setBounds(127, 325, 250, 22);
        frame.getContentPane().add(lblMesaj);



        //İlgili companent oluşturulur
        JButton btnTemizle = new JButton("Herşeyi sil");

        //Companent özellikleri atanır
        btnTemizle.setBounds(110, 290, 130, 23);
        frame.getContentPane().add(btnTemizle);

        //İlgili companente tıklandığında alınacak aksiyon ayarlanır
        btnTemizle.addActionListener(e -> {
            txtDosyaAd.setText("");
            txtAdSoyad.setText("");
            txtNumara.setText("");
            txtBolum.setText("");
            lblMesaj.setText("");
        });


        //UI'ya girilen bilgileri alıp dosyaya kaydetmemk için bir companent
        JButton btnDosyayaYaz = new JButton("Dosyaya Kaydet");
        //Companent'e tıklanırsa alınacak aksiyon
        btnDosyayaYaz.addActionListener(arg0 -> {

            //UI'daki bilgiler alınır
            String str=txtAdSoyad.getText() + "\n" + txtNumara.getText() + "\n" + txtBolum.getText() +"\n***********************************";
            //Kaydedilmesi gereken dosya arayüzden alınır
            String dosyaAdi=txtDosyaAd.getText();
            File dosya = new File(dosyaAdi);

            //Dosya varsa bilgiler dosyaya yazdırılır
            if (dosya.exists())
            {
                try {
                    dosyaYaz(dosyaAdi, str, true);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                lblMesaj.setText("Yazma İşlemi Başarılı");
            }
            else
            {
                try {
                    dosyaYaz(dosyaAdi, str, false);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                lblMesaj.setText("Yazma İşlemi Başarılı");

            }

        });
        btnDosyayaYaz.setBounds(250, 290, 150, 23);
        frame.getContentPane().add(btnDosyayaYaz);

        JLabel lblDosyaAd = new JLabel("Dosya Ad");
        lblDosyaAd.setBackground(Color.CYAN);
        lblDosyaAd.setBounds(10, 11, 107, 24);
        frame.getContentPane().add(lblDosyaAd);

        txtDosyaAd = new JTextField();
        txtDosyaAd.setBackground(Color.CYAN);
        txtDosyaAd.setBounds(127, 13, 143, 24);
        frame.getContentPane().add(txtDosyaAd);
        txtDosyaAd.setColumns(10);

    }

    private static void dosyaYaz(String dosyaAdi, String str,boolean uzerineYaz ) throws IOException
    {
        FileWriter f = new FileWriter(dosyaAdi, uzerineYaz);
        BufferedWriter out = new BufferedWriter(f);

        out.write(str);
        out.newLine();

        out.close();
        f.close();
    }
}