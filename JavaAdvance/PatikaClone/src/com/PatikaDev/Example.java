package com.PatikaDev;

import javax.swing.*;

public class Example extends JFrame
{


    private JPanel wrapper;
    public Example()
    {
       setTitle("Uygulama Adı");
       setContentPane(wrapper);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(400,500);
        setLocationRelativeTo(null);
       setVisible(true);

    }
}
