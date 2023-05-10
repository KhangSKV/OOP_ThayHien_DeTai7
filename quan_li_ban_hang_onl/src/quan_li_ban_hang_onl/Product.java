package quan_li_ban_hang_onl;

import java.util.List;

public class Product {
    private String ID;
    public String TenSP;
    public String MoTa;
    public Float GiaSP;
    public int SoLuongSP;

    public Product(String iD, String tenSP, String moTa, Float giaSP, int soLuongSP) {
        ID = iD;
        TenSP = tenSP;
        MoTa = moTa;
        GiaSP = giaSP;
        SoLuongSP = soLuongSP;
    }
    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public Float getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(Float giaSP) {
        GiaSP = giaSP;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        SoLuongSP = soLuongSP;
    }
    public static void xoaSanPham(String id, List<Product> productList) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getID().equals(id)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println("San pham da duoc xoa: " + productToRemove);
        } else {
            System.out.println("Khong tim thay san pham co ID = " + id);
        }
    }
    public static void themSanPham(Product product, List<Product> productList) {
        productList.add(product);
    }
    @Override
    public String toString() {
        return "Product [ID=" + ID + ", TenSP=" + TenSP + ", MoTa=" + MoTa + ", GiaSP=" + GiaSP + ", SoLuongSP="
                + SoLuongSP + "]";
    }
}