package View;

import Business.UserController;
import Core.Helper;
import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends  JFrame{
    private JPanel conteiner;
    private JLabel lbl_info;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_email;
    private JTextField txt_email;
    private JLabel lbl_password;
    private JPasswordField pass_password;
    private JButton btn_login;


    public UserController userController;

    public LoginUI(){

        this.add(conteiner);
        this.setTitle("Müşteri yönetim paneli");
        //UI'ın görünebilmesi için
        this.setVisible(true);
        this.setSize(700,700);

        //UI ekranının bilgisayarda tam ortaya gelmesi için
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);

        //UI kapatılınca program duracak
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.userController=new UserController();


        btn_login.addActionListener(new ActionListener() {

            JTextField[] checkList={txt_email,pass_password};

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldListEmpty(checkList))
                    Helper.showAutoMessage("fill");
               else if (!Helper.isEmailValid(txt_email.getText()))
                    Helper.showAutoMessage("Lütfen geçerli bir e-mail giriniz");
               else {
                    System.out.println(txt_email.getText());
                    System.out.println(pass_password.getText());
                    User user=userController.findByLogin(txt_email.getText(),pass_password.getText());
                   if(user==null){
                       Helper.showAutoMessage("Kullanıcı bulunamadı");
                   }
                   else
                   {
                       dispose();
                       DashboardUI dashboardUI=new DashboardUI(user);
                   }
                }
            }
        });
    }
}
