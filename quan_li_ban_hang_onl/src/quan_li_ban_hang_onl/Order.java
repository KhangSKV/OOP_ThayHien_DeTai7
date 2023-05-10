package quan_li_ban_hang_onl;

import java.util.ArrayList;
import java.util.List;
public class Order {
	 	private int ID;
	    private String TenKhachHang;
	    private String Address;
	    private List<String> TenSanPham;
	    private List<Integer> SoLuong;
	    private List<Double> GiaDonHang;
	    
	    public Order(int ID, String tenKhachHang, String address) {
	        this.setID(ID);
	        this.setTenKhachHang(tenKhachHang);
	        this.setAddress(address);
	        this.TenSanPham = new ArrayList<>();
	        this.SoLuong = new ArrayList<>();
	        this.GiaDonHang = new ArrayList<>();
	    }
	    public boolean kiemTraSanPham(String tenSanPham, List<Product> productList) {
	        for (Product product : productList) {
	            if (product.getTenSP().equals(tenSanPham)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    public void taoDonHang(String tenSanPham, int soLuong, double giaDonHang, List<Product> productList) {
	        boolean sanPhamTonTai = kiemTraSanPham(tenSanPham, productList);
	        if (sanPhamTonTai) {
	            this.TenSanPham.add(tenSanPham);
	            this.SoLuong.add(soLuong);
	            this.GiaDonHang.add(giaDonHang);
	        } else {
	            System.out.println("Khong co san pham");
	        }
	    }

	    
	    public void xoaDonHang(int index) {
	        this.TenSanPham.remove(index);
	        this.SoLuong.remove(index);
	        this.GiaDonHang.remove(index);
	    }
	    
	    public void suaDonHang(int index, String tenSanPham, int soLuong, double giaDonHang) {
	        this.TenSanPham.set(index, tenSanPham);
	        this.SoLuong.set(index, soLuong);
	        this.GiaDonHang.set(index, giaDonHang);
	    }
	    
	    public void xemDanhSachSanPham() {
	        for (int i = 0; i < this.TenSanPham.size(); i++) {
	            System.out.println("Ten san pham: " + this.TenSanPham.get(i) + ", so luong: " + this.SoLuong.get(i) + ", gia don hang: " + this.GiaDonHang.get(i));
	        }
	    }
	  // Getter and Setter methods

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getTenKhachHang() {
			return TenKhachHang;
		}

		public void setTenKhachHang(String tenKhachHang) {
			TenKhachHang = tenKhachHang;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}
}