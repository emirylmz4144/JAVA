package View;

import Business.CustomerController;
import Business.ProductController;
import Core.Helper;
import Core.Item;
import Entity.Customer;
import Entity.Product;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DashboardUI extends JFrame {

    private JPanel conteiner;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JTabbedPane tab_customer;
    private JScrollPane scrl_customer;
    private JPanel pnl_customer;
    private JTable tbl_customer;
    private JPanel pnl_func;
    private JLabel lbl_filter_name;
    private JTextField txt_filter_name;
    private JLabel lbl_filter_type;
    private JComboBox cmbbox_filter_type;
    private JButton btn_search;
    private JButton btn_clear;
    private JButton btn_addnew;
    private JPanel pnl_products;
    private JScrollPane scrl_products;
    private JTable tbl_products;
    private JPanel pnl_filter_products;
    private JLabel lbl_producr_name;
    private JTextField txt_product_name;
    private JLabel lbl_product_code;
    private JTextField txt_product_code;
    private JLabel lbl_stock_amount;
    private JComboBox<Item> cmbbox_stock_amount;
    private JButton btn_products_search;
    private JButton btn_clear_products;
    private JButton btn_add_products;

    private CustomerController customerController;
    private ProductController productController;
    private DefaultTableModel tmbl_customer;
    private DefaultTableModel tmbl_products;
    private JPopupMenu popup_customers;
    private JPopupMenu popup_products;

    User user;
    public DashboardUI(User user) {

        this.customerController=new CustomerController();
        this.productController=new ProductController();
        this.tmbl_customer =new DefaultTableModel();
        this.tmbl_products =new DefaultTableModel();
        this.popup_customers=new JPopupMenu();
        this.popup_products=new JPopupMenu();
        this.user=user;
        this.add(conteiner);
        this.setTitle("Müşteri yönetim paneli");
        this.setSize(1000,600);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (user==null){
            Helper.showAutoMessage("error");
        }
        this.lbl_welcome.setText("Hoşgeldin : "+ this.user.getName()+" "+this.user.getSurname());
        this.cmbbox_filter_type.setModel(new DefaultComboBoxModel<>(Customer.Type.values()));
        this.cmbbox_filter_type.setSelectedItem(null);


        this.cmbbox_stock_amount.addItem(new Item(1,"1-299"));
        this.cmbbox_stock_amount.addItem(new Item(2,"300-599"));
        this.cmbbox_stock_amount.addItem(new Item(3,"500-799"));
        this.cmbbox_stock_amount.addItem(new Item(4,"800-1199"));
        this.cmbbox_stock_amount.addItem(new Item(5,"1200-1499"));
        this.cmbbox_stock_amount.addItem(new Item(6,"1500+"));
        this.cmbbox_stock_amount.setSelectedItem(null);





        // CUSTOMERS TAB
        btn_logout.addActionListener((e) -> {
                dispose();
                LoginUI loginUI=new LoginUI();
        });


        btn_addnew.addActionListener(e-> {
            CustomerUI customerUI=new CustomerUI(new Customer());
            customerUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCustomers(null);
                }
            });
        });


        btn_search.addActionListener(e-> {
            ArrayList<Customer> filtredList=this.customerController.filter(
                    txt_filter_name.getText(),
                    (Customer.Type)cmbbox_filter_type.getSelectedItem()
            );
            loadCustomers(filtredList);
        });



        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCustomers(null);
                txt_filter_name.setText(null);
                cmbbox_filter_type.setSelectedItem(null);
            }
        });

        //Customer tab
        loadCustomers(null);
        loadCustomerPopUpMenu();


        //PRODUCTS TAB
        loadProducts(null);
        loadProductPopUpMenu();


        btn_add_products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductUI productUI=new ProductUI(new Product());
                productUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadProducts(null);
                    }
                });
            }
        });


        btn_products_search.addActionListener(e->
        {
            ArrayList<Product> filtredList=this.productController.filter(
                    txt_product_name.getText(),
                    txt_product_code.getText(),
                    (Item) cmbbox_stock_amount.getSelectedItem()
            );
            loadProducts(filtredList);
        });


        btn_clear_products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProducts(null);
                txt_product_name.setText(null);
                txt_product_code.setText(null);
                cmbbox_stock_amount.setSelectedItem(null);
            }
        });
    }






   //METOTLAR
    private void loadCustomerPopUpMenu(){
        this.tbl_customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow=tbl_customer.rowAtPoint(e.getPoint());
                tbl_customer.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });


        this.popup_customers.add("Güncelle").addActionListener(e->
        {
            int id=Integer.parseInt(tbl_customer.getValueAt(tbl_customer.getSelectedRow(),0).toString());
            CustomerUI customerUI=new CustomerUI(this.customerController.getById(id));
            customerUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCustomers(null);
                }
            });
        });




        this.popup_customers.add("Sil").addActionListener(e->
        {
            if (Helper.confirm("sure")){
                int id=Integer.parseInt(tbl_customer.getValueAt(tbl_customer.getSelectedRow(),0).toString());
                if (customerController.delete(id)){
                    Helper.showAutoMessage("done");
                    loadCustomers(null);
                }
                else {
                    Helper.showAutoMessage("error");
                }
            }
        });

        this.tbl_customer.setComponentPopupMenu(popup_customers);
    }





    private void loadProductPopUpMenu(){

        this.tbl_products.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow=tbl_products.rowAtPoint(e.getPoint());
                tbl_products.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });

        this.popup_products.add("Güncelle").addActionListener(e->
        {
            int id=Integer.parseInt(tbl_products.getValueAt(tbl_products.getSelectedRow(),0).toString());
            ProductUI productUI=new ProductUI(this.productController.getById(id));
            System.out.println(id);
            productUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadProducts(null);
                }
            });
        });



        this.popup_products.add("Sil").addActionListener(e->
        {
            if (Helper.confirm("sure")){
                int id=Integer.parseInt(tbl_products.getValueAt(tbl_products.getSelectedRow(),0).toString());
                if (productController.delete(id)){
                    Helper.showAutoMessage("done");
                    loadProducts(null);
                }
                else {
                    Helper.showAutoMessage("error");
                }
            }
        });

        this.tbl_products.setComponentPopupMenu(popup_products);

    }



    private void loadCustomers(ArrayList<Customer> customers) {
        Object [] titleOfTable={"ID","AD","SOYAD","TİP","TELEFON","E-MAİL","ADRES"};
        this.tmbl_customer.setColumnIdentifiers(titleOfTable);
        if (customers==null){
            customers=this.customerController.getAll();
        }

        customers.sort(((o1, o2) -> o1.getId()>o2.getId()?1:-1));


        //Sıfırlama
        DefaultTableModel clearModel=(DefaultTableModel)tbl_customer.getModel();
        clearModel.setRowCount(0);

        for (Customer customer:customers){
            Object [] rowObject={
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getPerson_type(),
                    customer.getPhone(),
                    customer.getE_mail(),
                    customer.getAddress()
            };
            this.tmbl_customer.addRow(rowObject);
        }
        this.tbl_customer.setModel(tmbl_customer);
        this.tbl_customer.getTableHeader().setReorderingAllowed(false);
        this.tbl_customer.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_customer.setEnabled(false);


    }



    private void loadProducts(ArrayList<Product> products) {
        Object [] titleOfTable={"ID","ÜRÜN ADI","ÜRÜN KODU","STOK MİKTARI","FİYAT"};
        this.tmbl_products.setColumnIdentifiers(titleOfTable);
        if (products==null){
            products=this.productController.getAll();
        }

        products.sort(((o1, o2) -> o1.getId()>o2.getId()?1:-1));


        //Sıfırlama
        DefaultTableModel clearModel=(DefaultTableModel)tbl_products.getModel();
        clearModel.setRowCount(0);

        for (Product product:products){
            Object [] rowObject={
                    product.getId(),
                    product.getName(),
                    product.getCode(),
                    product.getStock(),
                    product.getPrice()

            };
            this.tmbl_products.addRow(rowObject);
        }
        this.tbl_products.setModel(tmbl_products);
        this.tbl_products.getTableHeader().setReorderingAllowed(false);
        this.tbl_products.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_products.setEnabled(false);


    }
}


