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
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JPanel pnl_bottom;
    private JTabbedPane tab_menu;
    private JPanel pnl_customers;
    private JScrollPane scrll_customers;
    private JTable tbl_customers;
    private JPanel pnl__customer_filter;
    private JLabel lbl__customer_filter_name;
    private JTextField txt_customer_filter_name;
    private JLabel lbl_customer_filter_type;
    private JComboBox cmbx_customr_filter_type;
    private JButton btn_customer_filter_search;
    private JButton btn_customer_filter_clear;
    private JButton btn_customer_filter_addnew;
    private JPanel pnl_products;
    private JScrollPane scrll_products;
    private JTable tbl_products;
    private JPanel pnl_product_filter;
    private JLabel lbl_product_filter_name;
    private JTextField txt_filter_product_name;
    private JTextField txt_product_filter_code;
    private JLabel lbl_product_filter_code;
    private JLabel lbl_product_stockAmo_filter;
    private JComboBox<Item> cmbx_product_stockAmo;
    private JButton btn_filter_product_search;
    private JButton btn_filter_product_clear;
    private JButton btn_filter_product_addNew;

    private DefaultTableModel tableModelCustomers;
    private DefaultTableModel tableModelProducts;
    private JPopupMenu popupMenuCustomers;
    private JPopupMenu popupMenuProducts;


    private CustomerController customerController;
    private ProductController productController;


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


        this.tableModelCustomers =new DefaultTableModel();
        this.tableModelProducts=new DefaultTableModel();

        this.popupMenuCustomers =new JPopupMenu();
        this.popupMenuProducts= new JPopupMenu();

        this.customerController=new CustomerController();
        this.productController=new ProductController();


        this.lbl_welcome.setText("Hoşgeldin : "+ this.user.getName()+" "+this.user.getSurname());

        btn_logout.addActionListener(e-> {
            dispose();
            LoginUI loginUI=new LoginUI();
        });


        //CUSTOMER TAB
        loadCustomers(null);
        loadPopUpMenuCustomers();
        loadCustomerButtonEvent();
        this.cmbx_customr_filter_type.setModel(new DefaultComboBoxModel(Customer.Type.values()));
        this.cmbx_customr_filter_type.setSelectedItem(null);

        //PRODUCT TAB
        loadProducts(null);
        loadPopUpMenuProducts();
        loadProductButtonEvent();
        this.cmbx_product_stockAmo.addItem(new Item(1,"1-299"));
        this.cmbx_product_stockAmo.addItem(new Item(2,"300-599"));
        this.cmbx_product_stockAmo.addItem(new Item(3,"600-799"));
        this.cmbx_product_stockAmo.addItem(new Item(4,"800-1199"));
        this.cmbx_product_stockAmo.addItem(new Item(5,"1200-1499"));
        this.cmbx_product_stockAmo.addItem(new Item(6,"1500+"));
        this.cmbx_product_stockAmo.setSelectedItem(null);


    }

    public void loadCustomers(ArrayList<Customer> customers){

        Object [] tableRows=new Object[]{"ID","AD","SOYAD","TİP","NUMARA","E-POSTA","ADRES"};

        if (customers==null){
            customers=this.customerController.getAll();
        }

        //Tabloyu sıfırladık
        DefaultTableModel clearModel=(DefaultTableModel) this.tbl_customers.getModel();
        clearModel.setRowCount(0);

        this.tableModelCustomers.setColumnIdentifiers(tableRows);
        for (Customer customer: customers) {
            Object [] rowObject ={
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getPerson_type(),
                    customer.getPhone(),
                    customer.getE_mail(),
                    customer.getAddress()
            };
            tableModelCustomers.addRow(rowObject);
        }
        this.tbl_customers.setModel(tableModelCustomers);
        this.tbl_customers.getTableHeader().setReorderingAllowed(false);
        this.tbl_customers.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_customers.setEnabled(false);
    }

    public void loadPopUpMenuCustomers(){
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

        this.popupMenuCustomers.add("SİL").addActionListener(e -> {
            int selectedId=Integer.parseInt(tbl_customers.getValueAt(tbl_customers.getSelectedRow(),0).toString());
            if (Helper.confirm("sure")){
                if (this.customerController.delete(selectedId)){
                    Helper.showAutoMessage("done");
                    loadCustomers(null);
                }
                else {
                    Helper.showAutoMessage("Silme işlemi başarısız");
                }

            }
        });


        this.popupMenuCustomers.add("GÜNCELLE").addActionListener(e->{
            int selectedId=Integer.parseInt(tbl_customers.getValueAt(tbl_customers.getSelectedRow(),0).toString());
            CustomerUI customerUI=new CustomerUI(this.customerController.getById(selectedId));
            customerUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCustomers(null);
                }
            });
        });

        this.tbl_customers.setComponentPopupMenu(this.popupMenuCustomers);
    }

    public void loadCustomerButtonEvent(){

        btn_customer_filter_clear.addActionListener(e->{
            loadCustomers(null);
            cmbx_customr_filter_type.setSelectedItem(null);
            txt_customer_filter_name.setText(null);
        });


        btn_customer_filter_addnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerUI customerUI=new CustomerUI(new Customer());
                customerUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadCustomers(null);
                    }
                });
            }
        });

        btn_customer_filter_search.addActionListener(e-> {
            ArrayList<Customer> filtredList=this.customerController.filter(
                    txt_customer_filter_name.getText(),
                    (Customer.Type) cmbx_customr_filter_type.getSelectedItem()
            );

            loadCustomers(filtredList);
        });
    }



    public void loadProducts(ArrayList<Product> products){
        Object [] tableRows=new Object[]{"ID"," ÜRÜN ADI","ÜRÜN KODU","STOK MİKTARI","FİYAT"};
        if (products==null){
            products=this.productController.getAll();
        }

        //Tabloyu sıfırladık
        DefaultTableModel clearModel=(DefaultTableModel) this.tbl_products.getModel();
        clearModel.setRowCount(0);

        this.tableModelProducts.setColumnIdentifiers(tableRows);

        for (Product product: products) {
            Object [] rowObject ={
                    product.getId(),
                    product.getName(),
                    product.getCode(),
                    product.getStock(),
                    product.getPrice()

            };
            tableModelProducts.addRow(rowObject);
        }

        this.tbl_products.setModel(tableModelProducts);
        this.tbl_products.getTableHeader().setReorderingAllowed(false);
        this.tbl_products.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_products.setEnabled(false);

    }

    public void loadPopUpMenuProducts(){
        //Tabloda üzerine tıklanan hücrenin düzenlenmesi için mouse dinleyici koyuyoruz
        tbl_products.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Üzerine tıklananı seçiyor
                int selectedRow=tbl_products.rowAtPoint(e.getPoint());
                //Üzerine tıklananı tabloda düzenlenebilir elemean olarak ayarlıyor
                tbl_products.setRowSelectionInterval(selectedRow,selectedRow);
                System.out.println("Deneme--product");
            }
        });

        this.popupMenuProducts.add("SİL").addActionListener(e -> {
            int selectedId=Integer.parseInt(tbl_products.getValueAt(tbl_products.getSelectedRow(),0).toString());
            if (Helper.confirm("sure")){
                if (this.productController.delete(selectedId)){
                    Helper.showAutoMessage("done");
                    loadProducts(null);
                }
                else {
                    Helper.showAutoMessage("Silme işlemi başarısız");
                }

            }
        });


        this.popupMenuProducts.add("GÜNCELLE").addActionListener(e->{
            int selectedId=Integer.parseInt(tbl_products.getValueAt(tbl_products.getSelectedRow(),0).toString());
            ProductUI productUI=new ProductUI(this.productController.getById(selectedId));
            productUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadProducts(null);
                }
            });
        });

        this.tbl_products.setComponentPopupMenu(this.popupMenuProducts);
    }

    public void loadProductButtonEvent(){

        btn_filter_product_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProducts(null);
                cmbx_product_stockAmo.setSelectedItem(null);
                txt_filter_product_name.setText(null);
                txt_product_filter_code.setText(null);

            }
        });

        btn_filter_product_addNew.addActionListener(new ActionListener() {
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


        btn_filter_product_search.addActionListener(e-> {
            ArrayList<Product> filtredList=this.productController.filter(
                    txt_filter_product_name.getText(),
                    txt_product_filter_code.getText(),
                    (Item) cmbx_product_stockAmo.getSelectedItem()
            );

            loadProducts(filtredList);
        });

    }
}


