package connectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quan_li_ban_hang_onl.test;

public class Customers {
	
	
	public static void themKH(String TenKH, String DiaChi, String sdt, String email) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO Customers(TenKH, DiaChi, sdt, email) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, TenKH);
			ps.setString(2, DiaChi);
			ps.setString(3, sdt);
			ps.setString(4, email);
			ps.execute();
			//System.out.println("Done insert");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void capNhapKH(String ID, String TenKH, String DiaChi, String sdt, String email) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE Customers SET TenKH = ?, DiaChi = ?, sdt = ?, email = ? WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, TenKH);
			ps.setString(2, DiaChi);
			ps.setString(3, sdt);
			ps.setString(4, email);
			ps.setString(5, ID);

			ps.execute();
			//System.out.println("Done Update");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void hienThiDanhSachKH(Object row, Object row2, Object row3, Object row4, Object row5) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Customers";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//System.out.println("ALL Customer\n");
			while(rs.next()) {
				int ID = rs.getInt("ID");
				row = Integer.toString(ID);
				row2 = rs.getString("TenKH");
				row3 = rs.getString("DiaChi");
				row4 = rs.getString("sdt");
				row5 = rs.getString("email");
				//model.addRow(row);
				System.out.println(row2);

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
	
	public static void timKiemTheoTen(String keywork) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Customers WHERE TenSP LIKE '%?%'";
			ps = con.prepareStatement(sql);
			ps.setString(1, keywork);
			rs = ps.executeQuery();
			
			//String TenKH = rs.getString(1);
			//System.out.println(TenSP);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String TenKH = rs.getString("TenKH");
				String DiaChi = rs.getString("DiaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
					
				
				System.out.println("ID: " + ID );
				System.out.println("Tên khách hàng: " + TenKH);
				System.out.println("Địa chỉ: " + DiaChi);
				System.out.println("Số điện thoại: " + sdt);
				System.out.println("email: " + email + "\n\n");

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
	
	public static void xoaKH(String ID) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM Customers WHERE ID = ?";
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
	
}
