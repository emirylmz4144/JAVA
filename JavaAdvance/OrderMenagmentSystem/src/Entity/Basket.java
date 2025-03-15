package Entity;

public class Basket {
    private int id;
    private int product_id;
    private int customer_id;
    private String product_name;
    private String product_code;
    private String customer_name;
    private String customer_address;
    private int totalPrice;

    private Customer customer;
    private Product product;

    public Basket() {
    }

    public Basket(int product_id, int customer_id,int totalPrice) {
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.totalPrice=totalPrice;
    }
    public Basket(int totalPrice){
        this.totalPrice=totalPrice;
    }

    public Basket(int product_id, int customer_id, String product_name, String product_code, String customer_name, String customer_address, int totalPrice) {
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.product_code = product_code;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public Basket setId(int id) {
        this.id = id;
        return this;
    }

    public int getProduct_id() {
        return product_id;
    }

    public Basket setProduct_id(int product_id) {
        this.product_id = product_id;
        return this;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public Basket setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
        return this;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Basket setProduct_name(String product_name) {
        this.product_name = product_name;
        return this;
    }

    public String getProduct_code() {
        return product_code;
    }

    public Basket setProduct_code(String product_code) {
        this.product_code = product_code;
        return this;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public Basket setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
        return this;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public Basket setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Basket setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Basket setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Basket setProduct(Product product) {
        this.product = product;
        return this;
    }
}
