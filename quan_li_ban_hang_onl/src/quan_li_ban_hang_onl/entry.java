package quan_li_ban_hang_onl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.SQLException;
public class entry {
	public static void main(String[] args) {
		//test.connect();
		insert("Milk","Make in VietNam", 27, 20);
		
		//reading data
		//readAllData();
		//readSpecifiRow(20);
		
		
		//Update
		//updateProducts();
		
		
		//Delete
		//deleteRow();
		
		//count
		countProducts();
	}
	
	private static void insert(String TenSP, String MoTa, int GiaSP, int SoLuong) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO Products(TenSP, MoTa, GiaSP, SoLuong) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, TenSP);
			ps.setString(2, MoTa);
			ps.setInt(3, GiaSP);
			ps.setInt(4, SoLuong);
			ps.execute();
			System.out.println("Done insert");

		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	//reading
	private static void readAllData() {
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
	
	private static void readSpecifiRow(int SL) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT TenSP FROM Products WHERE SOLUONG = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SL);
			rs = ps.executeQuery();
			
			String TenSP = rs.getString(1);
			System.out.println(TenSP);
			
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
	
	private static void updateProducts() {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE Products set SoLuong = ? WHERE TenSP = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 22);
			ps.setString(2, "Milk");
			ps.execute();
			System.out.println("Done Update");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	private static void deleteRow() {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM Products WHERE SoLuong = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 22);
			ps.execute();
			System.out.println("Done Delete");
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
	
	private static void countProducts() {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(TenSP) FROM Products";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int size = rs.getInt(1);
			System.out.println("Có tất cả " + size + " sản phẩm");
			
		}catch(SQLException e) {
			System.out.println(e.toString());
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
