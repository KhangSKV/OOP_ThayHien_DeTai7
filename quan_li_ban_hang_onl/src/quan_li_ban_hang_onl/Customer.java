package quan_li_ban_hang_onl;


import java.util.ArrayList;

public class Customer {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String soDienThoai;
    private String email;
    
    // Danh sách khách hàng
    private static ArrayList<Customer> customers = new ArrayList<>();
    
    public Customer(String maKH, String tenKH, String diaChi, String soDienThoai, String email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }
    
    // Thêm khách hàng mới
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    // Sửa thông tin khách hàng
    public static void editCustomer(int index, Customer customer) {
        customers.set(index, customer);
    }
    
    // Hiển thị danh sách khách hàng
    public static void displayCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("MaKH: " + customer.maKH + ", TenKH: " + customer.tenKH
                + ", DiaChi: " + customer.diaChi + ", SoDienThoai: " + customer.soDienThoai
                + ", Email: " + customer.email);
        }
    }
    
 // Tìm khách hàng theo tên
    public static void findCustomerByName(String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.tenKH.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("MaKH: " + customer.maKH + ", TenKH: " + customer.tenKH
                    + ", DiaChi: " + customer.diaChi + ", SoDienThoai: " + customer.soDienThoai
                    + ", Email: " + customer.email);
            }
        }
    }


    
    // Getters và setters
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

