package com.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {//JFrame extend edilerek pencere olduğu belli edilir

    JPanel wrapper;
    private JLabel lbl_companyName;
    private JPanel pnl_bottom;
    private JPanel pnl_top;
    private JLabel lbl_userLogin;
    private JLabel lbl_userName;
    private JTextField txtField_userName;
    private JLabel lbl_password;
    private JTextField txtField_passwrod;
    private JButton btn_logIn;


    public LoginScreen()
    {

        for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
        {
            if ("Nimbus".equals(info.getName()))
            {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        this.add(wrapper);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x= (Toolkit.getDefaultToolkit().getScreenSize().width-getSize().width)/2;
        int y=(Toolkit.getDefaultToolkit().getScreenSize().height-getSize().height)/2;
        setLocation(x,y);
        setVisible(true);

        btn_logIn.addActionListener(e->{
            if (txtField_userName.getText().length()==0 || txtField_passwrod.getText().length()==0)
            {
                JOptionPane.showMessageDialog(null, "LÜTFEN TÜM ALANLARI DOLDURUNUZ");
            }
            else
            {
                System.out.println(txtField_userName.getText());
                System.out.println(txtField_passwrod.getText());
            }
        });
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
