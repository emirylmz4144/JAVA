package View;

import Business.CustomerController;
import Core.Helper;
import Entity.Customer;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DashboardUI extends JFrame {

    private JPanel conteiner;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JPanel pnl_bottom;
    private JTabbedPane tab_menu;
    private JPanel pnl_customers;
    private JScrollPane scrll_customers;
    private JTable tbl_customers;
    private JPanel pnl_filter;
    private JLabel lbl_filter_name;
    private JTextField txt_filter_name;
    private JLabel lbl_filter_type;
    private JComboBox cmbx_filter_type;
    private JButton btn_filter_search;
    private JButton btn_filter_clear;
    private JButton btn_filter_addnew;

    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;


    private CustomerController customerController;


    User user;
    public DashboardUI(User user) {

        if (user==null){
            Helper.showAutoMessage("error");
            dispose();
        }
        this.user=user;
        this.add(conteiner);
        this.setTitle("Müşteri yönetim paneli");
        this.setSize(1000,600);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.tableModel=new DefaultTableModel();
        this.popupMenu=new JPopupMenu();

        this.customerController=new CustomerController();

        this.lbl_welcome.setText("Hoşgeldin : "+ this.user.getName()+" "+this.user.getSurname());

        btn_logout.addActionListener(e-> {
            dispose();
            LoginUI loginUI=new LoginUI();
        });


        loadCustomers(null);
        loadPopUpMenu();


    }

    public void loadCustomers(ArrayList<Customer> customers){

        Object [] tableRows=new Object[]{"ID","AD","SOYAD","TİP","NUMARA","E-POSTA","ADRES"};

        if (customers==null){
            customers=this.customerController.getAll();
        }

        //Tabloyu sıfırladık
        DefaultTableModel clearModel=(DefaultTableModel) this.tbl_customers.getModel();
        clearModel.setRowCount(0);

        this.tableModel.setColumnIdentifiers(tableRows);
        for (Customer customer: customers) {
            Object [] rowObject ={
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getPhone(),
                    customer.getE_mail(),
                    customer.getAddress()
            };
            tableModel.addRow(rowObject);
        }
        this.tbl_customers.setModel(tableModel);
        this.tbl_customers.getTableHeader().setReorderingAllowed(false);
        this.tbl_customers.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_customers.setEnabled(false);
    }

    public void loadPopUpMenu(){
        //Tabloda üzerine tıklanan hücrenin düzenlenmesi için mouse dinleyici koyuyoruz
        tbl_customers.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Üzerine tıklananı seçiyor
                int selectedRow=tbl_customers.rowAtPoint(e.getPoint());
                //Üzerine tıklananı tabloda düzenlenebilir elemean olarak ayarlıyor
                tbl_customers.setRowSelectionInterval(selectedRow,selectedRow);
                System.out.println("Deneme--");
            }
        });

        this.popupMenu.add("SİL").addActionListener(e -> {
            int selectedId=Integer.parseInt(tbl_customers.getValueAt(tbl_customers.getSelectedRow(),0).toString());
        });


        this.popupMenu.add("GÜNCELLE").addActionListener(e->{
            int selectedId=Integer.parseInt(tbl_customers.getValueAt(tbl_customers.getSelectedRow(),0).toString());
        });
        this.tbl_customers.setComponentPopupMenu(this.popupMenu);
    }
}


