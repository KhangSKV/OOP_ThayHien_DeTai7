package connectData;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quan_li_ban_hang_onl.test;

public class Products {
	
	public static void main(String[] args) {
		//hienThiDanhSachSP();
	}
	
	public static void ThemSP(String TenSP, String MoTa, float GiaSP, int SoLuong) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO Products(TenSP, MoTa, GiaSP, SoLuong) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, TenSP);
			ps.setString(2, MoTa);
			ps.setFloat(3, GiaSP);
			ps.setInt(4, SoLuong);
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void xoaSP(String ID) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM Products WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void hienThiDanhSachSP() {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Products";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ALL Products\n");
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String TenSP = rs.getString("TenSP");
				String MoTa = rs.getString("MoTa");
				int GiaSP = rs.getInt("GiaSP");
				int SoLuong = rs.getInt("SoLuong");
					
				
				System.out.println("ID: " + ID );
				System.out.println("Tên Sản phẩm: " + TenSP);
				System.out.println("Mô tả: " + MoTa);
				System.out.println("Giá: " + GiaSP);
				System.out.println("SoLuong: " + SoLuong + "\n\n");

			}
		}catch(SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
				
			}catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	
	public static void capNhapSP(String ID, String TenSP, String MoTa, float GiaSP, int SoLuong) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE Products SET TenSP = ?, MoTa = ?, GiaSP = ?, SoLuong = ? WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, TenSP);
			ps.setString(2, MoTa);
			ps.setFloat(3, GiaSP);
			ps.setInt(4, SoLuong);
			ps.setString(5, ID);

			ps.execute();
			//System.out.println("Done Update");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
}
