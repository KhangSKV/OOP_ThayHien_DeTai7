package quan_li_ban_hang_onl;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;

public class quan_li {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> productList = new ArrayList<>(); 
		ArrayList<Customer> customers = new ArrayList<>();
		Order order = new Order(1, "Nguyen Van A", "123 Street");
		
		Product newProduct_1 = new Product("01", "milk", "Mo ta san pham 1", 10.0f, 10);
		productList.add(newProduct_1);
        Product newProduct_2 = new Product("02", "tea", "Mo ta san pham 2", 20.0f, 20);
        productList.add(newProduct_2);
		
        Customer customer1 = new Customer("KH001", "Nguyen Van A", "Ha Noi", "0987654321", "nguyenvana@gmail.com");
        Customer customer2 = new Customer("KH002", "Tran Thi B", "Ho Chi Minh", "0123456789", "tranthib@gmail.com");
        Customer.addCustomer(customer1);
        Customer.addCustomer(customer2);
        customers.add(customer1);
        customers.add(customer2);

 
		while(true) {
			System.out.println("******QUẢN LÝ BÁN HÀNG ONLINE******");
			System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý đơn hàng");
            System.out.println("4. Tắt chương trình");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch(choice) {
	            case 1:
	            	boolean flag = false;
	            	while(true) {
	            		System.out.println("******QUẢN LÝ SẢN PHẨM******");
	                	System.out.println("1. Thêm sản phẩm");
	                    System.out.println("2. Xóa sản phẩm");
	                    System.out.println("3. Hiển thị danh sách sản phẩm");
	                    System.out.println("4. Thoát");
	                    System.out.print("Chọn chức năng: ");
	                    int choice_1 = scanner.nextInt();
	                    scanner.nextLine();
	                    switch(choice_1) {
		                    case 1:
		                    	System.out.print("Nhập ID sản phẩm: ");
		                        String id = scanner.nextLine();
		                        System.out.print("Nhập tên sản phẩm: ");
		                        String tenSP = scanner.nextLine();
		                        System.out.print("Nhập mô tả về sản phẩm: ");
		                        String moTa = scanner.nextLine();
		                        System.out.print("Nhập giá: ");
		                        float giaSP = scanner.nextFloat();
		                        System.out.print("Nhập số lượng: ");
		                        int soLuongSP = scanner.nextInt();
		                        scanner.nextLine(); 
		
		                        Product newProduct = new Product(id, tenSP, moTa, giaSP, soLuongSP);
		                        productList.add(newProduct);
		                        System.out.println("Đã thêm sản phẩm: " + newProduct);
		                        break;
		                    case 2:
		                    	 System.out.print("Nhập ID sản phẩm cần xóa: ");
		                         String idToRemove = scanner.nextLine();
		                         boolean found = false;

		                         // Duyệt qua danh sách sản phẩm để tìm sản phẩm cần xóa
		                         for (Product product : productList) {
		                             if (product.getID().equals(idToRemove)) {
		                                 productList.remove(product);
		                                 System.out.println("Đã xóa sản phẩm: " + product);
		                                 found = true;
		                                 break;
		                             }
		                         }

		                         if (!found) {
		                             System.out.println("Không tìm thấy sản phẩm có ID = " + idToRemove);
		                         }
		                         break;
		                    case 3:
		                    	System.out.println("Danh sách sản phẩm:");
		                        for (Product product : productList) {
		                            System.out.println(product);
		                        }
		                        break;
		                    case 4:
		                    	flag = true;
		                    	break;
		                    default:
		                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại.");
		                        break;
	                    }
	                    if (flag) {
		                	break;
		                }
	            	}
	            	break;
	            	
	            case 2:
	            	boolean flag_2 = false;
	            	while(true) {
	            		System.out.println("******QUẢN LÝ KHÁCH HÀNG******");
		            	System.out.println("1. Thêm khách hàng");
		                System.out.println("2. Sửa thông tin khách hàng");
		                System.out.println("3. Hiển thị danh sách khách hàng");
		                System.out.println("4. Tìm kiếm khách hàng theo tên");
		                System.out.println("5. Thoát");
		                System.out.print("Chọn chức năng: ");
		                //switch case để chọn chức năng
		                int choice_2 = scanner.nextInt();
	                    scanner.nextLine();
	                    switch (choice_2) {
	                    case 1:
	                    	System.out.print("Nhập mã KH: ");
	                        String maKH = scanner.nextLine();
	                        System.out.print("Nhập tên KH: ");
	                        String tenKH = scanner.nextLine();
	                        System.out.print("Nhập địa chỉ: ");
	                        String diaChi = scanner.nextLine();
	                        System.out.print("Nhập số điện thoại: ");
	                        String soDienThoai = scanner.nextLine();
	                        System.out.print("Nhập email: ");
	                        String email = scanner.nextLine();
	                        Customer customer = new Customer(maKH, tenKH, diaChi, soDienThoai, email);
	                        customers.add(customer);
	                        break;
	                    case 2:
	                    	System.out.print("Nhập mã KH cần sửa: ");
	                        String maKHCanSua = scanner.next();
	                        for (Customer c : customers) {
	                            if (c.getMaKH().equals(maKHCanSua)) {
	                                System.out.print("Nhập tên mới: ");
	                                String tenMoi = scanner.next();
	                                System.out.print("Nhập địa chỉ mới: ");
	                                String diaChiMoi = scanner.next();
	                                System.out.print("Nhập số điện thoại mới: ");
	                                String soDienThoaiMoi = scanner.next();
	                                System.out.print("Nhập email mới: ");
	                                String emailMoi = scanner.next();
	                                c.setTenKH(tenMoi);
	                                c.setDiaChi(diaChiMoi);
	                                c.setSoDienThoai(soDienThoaiMoi);
	                                c.setEmail(emailMoi);
	                                System.out.println("Thông tin khách hàng đã được sửa thành công!");
	                                break;
	                            }
	                        }
	                        break;
	                    case 3:
	                        System.out.println("Danh sách khách hàng:");
	                        for (Customer c : customers) {
	                            System.out.println(c.getTenKH());
	                        }
	                        break;
	                    case 4:
	                    	System.out.print("Nhập tên khách hàng cần tìm kiếm: ");
	                        String name = scanner.nextLine();
	                        
	                        // Tìm khách hàng theo tên
	                        Customer.findCustomerByName(name);
	                        
	                        
	                        break;

	                    case 5:
	                    	flag_2 = true;
	                    	break;
	                    default:
	                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại.");
	                        break;
	                    }
	                    if (flag_2) {
		                	break;
		                }
	            	}	
	            	break;
	            case 3:
	            	boolean flag_3 = false;
	            	while(true) {
	            		System.out.println("******QUẢN LÝ ĐƠN HÀNG******");
	            		System.out.println("1. Tạo đơn hàng");
	    	            System.out.println("2. Xóa đơn hàng");
	    	            System.out.println("3. Cập nhật đơn hàng");
	    	            System.out.println("4. Xem danh sách đơn hàng");
	    	            System.out.println("5. Thoát");
		                System.out.print("Chọn chức năng: ");
		                int choice_3 = scanner.nextInt();
	                    scanner.nextLine();
	                    switch(choice_3) {
	                    case 1:
	                    	System.out.print("Đơn hàng có bao nhiêu sản phẩm: ");
		                	int n = scanner.nextInt();
		                	for (int i = 0;i<n;i++) {
		                		System.out.print("Nhập tên sản phẩm: ");
		                		String tenSanPham = scanner.next();
		                		System.out.print("Nhập số lượng sản phẩm: ");
		                		int soLuong = scanner.nextInt();
		                		System.out.print("Tổng giá đơn hàng: ");
		                		double giaDonHang = scanner.nextDouble();
//		                		List<Product> productList1 = new ArrayList<Product>();
		                		order.taoDonHang(tenSanPham, soLuong, giaDonHang, productList);
		                    	
		                	}
		                	break;
	                    case 2:
	                    	System.out.print("Nhập mã đơn hàng cần xóa: ");
		                    int index = scanner.nextInt();
		                    order.xoaDonHang(index);
		                    break;
	                    case 3:
	                    	System.out.print("Nhập mã đơn hàng cần sửa: ");
		                    int indexSua = scanner.nextInt();
		                    System.out.print("Nhập tên sản phẩm mới: ");
		                    String tenSanPhamMoi = scanner.next();
		                    System.out.print("Nhập số lượng mới: ");
		                    int soLuongMoi = scanner.nextInt();
		                    System.out.print("Nhập tổng giá mới: ");
		                    double giaDonHangMoi = scanner.nextDouble();
		                    order.suaDonHang(indexSua, tenSanPhamMoi, soLuongMoi, giaDonHangMoi);
		                    break;
	                    case 4:
	                    	order.xemDanhSachSanPham();
		                    break;
	                    case 5:
	                    	flag_3 = true;
	                    	break;
	                    
	                    default:
	                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại.");
	                        break;
	                    }
	                    if (flag_3) {
		                	break;
		                }
	            	}   	
	                break;
	            case 4:
	            	System.out.println("************CHƯƠNG TRÌNH ĐÃ TẮT************");
	            	scanner.close();
                    System.exit(0);
	            default:
	                System.out.println("Lua chon khong hop le. Vui long chon lai.");
	                break;
            }
		}
	}
}