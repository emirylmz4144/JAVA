package View;

import Business.BasketController;
import Business.CustomerController;
import Business.ProductController;
import Core.Helper;
import Core.Item;
import Entity.Basket;
import Entity.Customer;
import Entity.Product;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Comparator.*;

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
    private JPanel pnl_basket;
    private JScrollPane scrll_basket;
    private JTable tbl_basket_products;
    private JPanel pnl_create_order;
    private JLabel lbl_basket_select_customer;
    private JComboBox cmbx_selected_customer;
    private JLabel lbl_basket_count;
    private JComboBox cmbx_total_product_count;
    private JLabel lbl_basket_total_price;
    private JLabel lbl_basket_price;
    private JButton btn_clear;
    private JButton btn_create_basket;
    private JTextField txt_selected_product;
    private JPanel pnl_orders;
    private JTable tbl_all_orders;
    private JScrollPane scrll_all_orders;

    private DefaultTableModel tableModelCustomers;
    private DefaultTableModel tableModelProducts;
    private DefaultTableModel tableModelBasketProduct;
    private DefaultTableModel tableModelAllBaskets;
    private JPopupMenu popupMenuCustomers;
    private JPopupMenu popupMenuProducts;
    private JPopupMenu popupMenuBaskets;


    private CustomerController customerController;
    private ProductController productController;
    private BasketController basketController;


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
        this.tableModelBasketProduct=new DefaultTableModel();
        this.tableModelAllBaskets=new DefaultTableModel();

        this.popupMenuCustomers =new JPopupMenu();
        this.popupMenuProducts= new JPopupMenu();
        this.popupMenuBaskets=new JPopupMenu();

        this.customerController=new CustomerController();
        this.productController=new ProductController();
        this.basketController=new BasketController();


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

        //BASKET TAB
        loadProductForBasket(null);
        setComboBoxCustomerAndTotalProductOnBasket();
        loadPopUpMenuBaskets();
        loadBasketButtonEvent();
        this.cmbx_selected_customer.setSelectedItem(null);
        this.cmbx_total_product_count.setSelectedItem(null);
        this.cmbx_total_product_count.addActionListener(e -> updateTotalPrice());
        this.txt_selected_product.setEnabled(false);


        //Orders Tab
        loadOrders(null);

    }




    //  Customer Methods
    public void loadCustomers(ArrayList<Customer> customers){

        Object [] tableRows=new Object[]{"ID","AD","SOYAD","TİP","NUMARA","E-POSTA","ADRES"};

        if (customers==null){
            customers=this.customerController.getAll();
            Collections.sort(customers, comparingInt(Customer::getId));
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
        this.tbl_customers.setRowHeight(50);
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

            }
        });

        this.popupMenuCustomers.add("SİL").addActionListener(e -> {
            int selectedId=Integer.parseInt(tbl_customers.getValueAt(tbl_customers.getSelectedRow(),0).toString());
            if (Helper.confirm("sure")){
                if (this.customerController.delete(selectedId)){
                    Helper.showAutoMessage("done");
                    loadCustomers(null);
                    cmbx_selected_customer.removeAllItems();
                    setComboBoxCustomerAndTotalProductOnBasket();
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
                    loadProductForBasket(null);
                    cmbx_selected_customer.removeAllItems();
                    setComboBoxCustomerAndTotalProductOnBasket();

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
                        cmbx_selected_customer.removeAllItems();
                        setComboBoxCustomerAndTotalProductOnBasket();
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



    //Product Methods
    public void loadProducts(ArrayList<Product> products){
        Object [] tableRows=new Object[]{"ID"," ÜRÜN ADI","ÜRÜN KODU","STOK MİKTARI","FİYAT"};
        if (products==null){
            products=this.productController.getAll();
            Collections.sort(products, comparingInt(Product::getId));
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
        this.tbl_products.setRowHeight(50);
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
                txt_product_filter_code.setText("0");

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



    //Basket Methods
    public void loadProductForBasket(ArrayList<Product> productForBasket){
        Object [] tableRows=new Object[]{"ID"," ÜRÜN ADI","ÜRÜN KODU","STOK MİKTARI","FİYAT"};
        if (productForBasket==null){
            productForBasket=this.productController.getAll();
            Collections.sort(productForBasket, comparingInt(Product::getId));
        }
        //Tabloyu sıfırladık
        DefaultTableModel clearModel=(DefaultTableModel) this.tbl_basket_products.getModel();
        clearModel.setRowCount(0);

        this.tableModelBasketProduct.setColumnIdentifiers(tableRows);

        for (Product product: productForBasket) {
            Object [] rowObject ={
                    product.getId(),
                    product.getName(),
                    product.getCode(),
                    product.getStock(),
                    product.getPrice()

            };
            tableModelBasketProduct.addRow(rowObject);
        }

        this.tbl_basket_products.setModel(tableModelBasketProduct);
        this.tbl_basket_products.setRowHeight(50);
        this.tbl_basket_products.getTableHeader().setReorderingAllowed(false);
        this.tbl_basket_products.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_basket_products.setEnabled(false);
    }

    public void loadPopUpMenuBaskets(){
        //Tabloda üzerine tıklanan hücrenin düzenlenmesi için mouse dinleyici koyuyoruz
        tbl_basket_products.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Üzerine tıklananı seçiyor
                int selectedRow=tbl_basket_products.rowAtPoint(e.getPoint());
                //Üzerine tıklananı tabloda düzenlenebilir elemean olarak ayarlıyor
                tbl_basket_products.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });


        this.popupMenuBaskets.add("SEÇ").addActionListener(e->{

            int selectedRow = tbl_basket_products.getSelectedRow();
            if (selectedRow != -1) { // Seçili satır var mı kontrol et
                String code = tbl_basket_products.getValueAt(selectedRow, 2).toString();
                txt_selected_product.setText(code);

                // Fiyatı güncelleyen metod
                updateTotalPrice();
            }
        });


        this.tbl_basket_products.setComponentPopupMenu(this.popupMenuBaskets);
    }

    public void loadBasketButtonEvent(){

        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbx_selected_customer.setSelectedItem(null);
                cmbx_total_product_count.setSelectedItem(null);
                txt_selected_product.setText(null);
                lbl_basket_price.setText(null);
            }
        });

        btn_create_basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbx_selected_customer.getSelectedItem()==null || txt_selected_product.getText().equals("") ||cmbx_total_product_count.getSelectedItem()==null){
                    Helper.showAutoMessage("Lütfen sipariş bilgilerini doğru giriniz");
                }
                else {
                    Product product=productController.getProductByCode(txt_selected_product.getText());
                    Customer customer=customerController.getByName(cmbx_selected_customer.getSelectedItem().toString());
                    int totalPrice=Integer.parseInt(lbl_basket_price.getText());


                    Basket basket=new Basket(product.getId(),customer.getId(),product.getName(),product.getCode(),customer.getName(),customer.getAddress(),totalPrice);

                    if (product.getStock()-Integer.parseInt(cmbx_total_product_count.getSelectedItem().toString())<0){
                        Helper.showAutoMessage("Stok sayısından fazla ürün alamazsınız");
                    }
                    else if (Helper.confirm("sure")){
                        if (basketController.save(basket)){
                            Helper.showAutoMessage("done");

                            product.setStock(product.getStock()-Integer.parseInt(cmbx_total_product_count.getSelectedItem().toString()));
                            productController.update(product);

                            loadOrders(null);
                            loadProducts(null);
                            loadProductForBasket(null);
                        }
                    }
                }
            }
        });
    }

    public void setComboBoxCustomerAndTotalProductOnBasket(){
        ArrayList<Customer> customerList=this.customerController.getAll();
        for (Customer customer: customerList) {
            this.cmbx_selected_customer.addItem(customer.getName());
        }

        for (int i=1;i<=10;i++){
            cmbx_total_product_count.addItem(i);
        }
    }

    private void updateTotalPrice() {
        int selectedRow = tbl_basket_products.getSelectedRow();
        if (selectedRow != -1 && cmbx_total_product_count.getSelectedItem() != null) {
            int price = Integer.parseInt(tbl_basket_products.getValueAt(selectedRow, 4).toString());
            int quantity = Integer.parseInt(cmbx_total_product_count.getSelectedItem().toString());
            lbl_basket_price.setText(String.valueOf(price * quantity));
        }
    }


    //Orders method
    public void loadOrders(ArrayList<Basket> baskets){
        Object [] tableRows=new Object[]{"SİPARİŞ ID","MÜŞTERİ ID","ÜRÜN ADI","ÜRÜN KODU","MÜŞTERİ ADI","MÜŞTERİ ADRESİ","TOPLAM HARCAMA"};
        if (baskets==null){
            baskets=this.basketController.getAll();
            Collections.sort(baskets, comparing(Basket::getId));
        }

        DefaultTableModel clearModel=(DefaultTableModel) this.tbl_all_orders.getModel();
        clearModel.setRowCount(0);

        this.tableModelAllBaskets.setColumnIdentifiers(tableRows);

        for (Basket basket : baskets){
                Object [] rowObjects={
                        basket.getId(),
                        basket.getProduct_id(),
                        basket.getCustomer_id(),
                        basket.getProduct_name(),
                        basket.getProduct_code(),
                        basket.getCustomer_name(),
                        basket.getCustomer_address(),
                        basket.getTotalPrice()
                };
                tableModelAllBaskets.addRow(rowObjects);


        }

        this.tbl_all_orders.setModel(tableModelAllBaskets);
        this.tbl_all_orders.setRowHeight(50);
        this.tbl_all_orders.getTableHeader().setReorderingAllowed(false);
        this.tbl_all_orders.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_all_orders.setEnabled(false);
    }
}


