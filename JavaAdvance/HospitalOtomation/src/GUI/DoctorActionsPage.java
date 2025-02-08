package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorActionsPage extends JFrame
{
    JTabbedPane tabbedPane;

    public DoctorActionsPage()
    {
        setTitle("Doktor İşlemleri");
        setSize(600, 600);
        setLocationRelativeTo(null);// Ekranda merkeze alınması için
        getContentPane().setLayout(null);// null yaparak conteinerı devre dışı bırakırız ve setBounds aktifleşir
        Color color=new Color(188, 243, 255);
        getContentPane().setBackground(color);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,600,500);

        tabbedPane.setBackground(color);

        DoctorAddPage doctorAddPage=new DoctorAddPage();
        DoctorDeletePage doctorDeletePage=new DoctorDeletePage();
        tabbedPane.addTab("DOKTOR EKLE", doctorAddPage);
        tabbedPane.addTab("DOKTOR SİL",doctorDeletePage);

        //Geri tuşu
        JButton geri=new JButton("GERİ");
        add(geri);
        geri.setBounds(20,520,100,50);
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionsPage actionsPage=new ActionsPage();
                actionsPage.setVisible(true);

                dispose();
            }
        });

        add(tabbedPane);


    }

}
