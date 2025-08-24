package View;

import Business.CustomerController;
import Core.Helper;
import Entity.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame{
    private JPanel conteiner;
    private JTextField txt_name;
    private JTextField txt_surname;
    private JTextField txt_phone;
    private JTextField txt_email;
    private JButton btn_save;
    private JLabel lbl_name;
    private JLabel lbl_surname;
    private JLabel lbl_type;
    private JLabel lbl_phone;
    private JLabel lbl_email;
    private JLabel lbl_address;


    private JTextArea txtarea_address;
    private JComboBox<Customer.Type> cmbBox_customer_type;


    private Customer customer;
    private CustomerController customerController;

    public CustomerUI(Customer customer){

        this.customerController=new CustomerController();
        this.customer=customer;
        this.add(conteiner);
        this.setTitle("Müşteri ekleme/düzenleme paneli");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(400,500);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);
        this.setVisible(true);


        JScrollPane scrollPane = new JScrollPane(conteiner);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
        this.cmbBox_customer_type.setModel(new DefaultComboBoxModel<>(Customer.Type.values()));


        if (this.customer==null){
            this.setTitle("Müşteri ekle");
        }
        else{
            this.setTitle("Müşteri düzenle");
            this.txt_name.setText(this.customer.getName());
            this.txt_surname.setText(this.customer.getSurname());
            this.cmbBox_customer_type.getModel().setSelectedItem(this.customer.getPerson_type());
            this.txt_phone.setText(this.customer.getPhone());
            this.txt_email.setText(this.customer.getE_mail());
            this.txtarea_address.setText(this.customer.getAddress());
        }



        
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField [] checkList={txt_name,txt_surname,txt_phone};
                if (Helper.isFieldListEmpty(checkList) ||cmbBox_customer_type.getSelectedItem()==null){
                    Helper.showAutoMessage("fill");
                }

                else if (!Helper.isEmailValid(txt_email.getText()) && !Helper.isFieldEmpty(txt_email)){
                    Helper.showAutoMessage("Lütfen geçerli bir e-mail adresi giriniz");
                }
                else {
                    boolean result=false;
                    customer.setName(txt_name.getText());
                    customer.setSurname(txt_surname.getText());
                    customer.setPerson_type((Customer.Type )cmbBox_customer_type.getSelectedItem());
                    customer.setPhone(txt_phone.getText());
                    customer.setE_mail(txt_email.getText());
                    customer.setAddress(txtarea_address.getText());

                    if (customer.getId()==0){
                       result= customerController.save(customer);
                    }
                    else {
                        if (Helper.confirm("sure")){
                            result=customerController.update(customer);
                        }
                        else {
                            result=true;
                        }

                    }

                    if (result){
                        Helper.showAutoMessage("done");
                        dispose();
                    }
                    else {
                        Helper.showAutoMessage("error");
                        dispose();
                    }
                }
            }
        });
    }

}
