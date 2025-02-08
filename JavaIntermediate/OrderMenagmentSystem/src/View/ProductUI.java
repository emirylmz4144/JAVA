package View;

import Business.ProductController;
import Core.Helper;
import Entity.Customer;
import Entity.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductUI extends JFrame{
    private JPanel conteiner;
    private JLabel lbl_product_name;
    private JTextField txt_product_name;
    private JLabel lbl_product_code;
    private JTextField txt_product_code;
    private JLabel lbl_product_stock_amount;
    private JTextField txt_product_stock_amount;
    private JTextField txt_product_price;
    private JLabel lbl_product_price;
    private JButton btn_product_save;

    private ProductController productController;

    private Product product;

    public ProductUI(Product product) {
        this.add(conteiner);
        this.setTitle("Ürün ekleme/düzenleme Paneli");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(400,500);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);
        this.setVisible(true);

        this.product=product;
        this.productController=new ProductController();

        if (this.product==null){
            this.setTitle("Ürün Ekle");
        }
        else{
            this.setTitle("Ürün Düzenle");
            this.txt_product_name.setText(this.product.getName());
            this.txt_product_code.setText(this.product.getCode());
            this.txt_product_stock_amount.setText(Integer.toString(this.product.getStock()));
            this.txt_product_price.setText(Integer.toString(this.product.getPrice()));
        }
        btn_product_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField [] checkList={txt_product_name,txt_product_code,txt_product_price,txt_product_stock_amount};
                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (!Helper.isNumber(new JTextField[]{txt_product_price,txt_product_stock_amount})){
                    Helper.showAutoMessage("Lütfen geçerli değer giriniz");
                }
                else {
                    boolean result=false;
                    product.setName(txt_product_name.getText());
                    product.setCode(txt_product_code.getText());
                    product.setStock(Integer.parseInt(txt_product_stock_amount.getText()));
                    product.setPrice(Integer.parseInt(txt_product_price.getText()));

                    if (product.getId()==0){
                        result= productController.save(product);
                    }
                    else {
                        result=productController.update(product);
                    }

                    if (result){
                        Helper.showAutoMessage("done");
                        dispose();
                    }
                    else {
                        Helper.showAutoMessage("error");
                    }
                }
            }
        });
    }
}
