package connectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quan_li_ban_hang_onl.test;

public class Bills {
	public static void main(String[] args) {
		
	}
	
	public static void themDH(int MaDH, String TenKH, String TenSP, int SL) {
		Connection con = ConnectDB.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO Bills(MaDH, TenKH, TenSP, SL, ThanhTien) VALUES(?,?,?,?,(SELECT GiaSP FROM Products WHERE TenSP = ?) * ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, MaDH);
			ps.setString(2, TenKH);
			ps.setString(3, TenSP);
			ps.setInt(4, SL);
			ps.setString(5, TenSP);
			ps.setInt(6, SL);
			ps.execute();
			//System.out.println("Done insert");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void xoaDH(String MaDH) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM Bills WHERE MaDH = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, MaDH);
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
	
	public static void capNhapDH(String STT, int MaDH, String TenKH, String TenSP, int SL) {
		Connection con = test.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE Bills SET MaDH = ?, TenKH = ?, TenSP = ?, SL = ?, ThanhTien = ((SELECT GiaSP FROM Products WHERE TenSP = ?) * ?) WHERE STT = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, MaDH);
			ps.setString(2, TenKH);
			ps.setString(3, TenSP);
			ps.setInt(4, SL);
			ps.setString(5, TenSP);
			ps.setInt(6, SL);
			ps.setString(7, STT);
			ps.execute();
			//System.out.println("Done Update");
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	private static void hienThiDanhSachDH() {
		Connection con = test.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Bills";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ALL Bills\n");
			while(rs.next()) {
				int STT = rs.getInt("STT");
				int ID = rs.getInt("MaDH");
				String TenKH = rs.getString("TenKH");
				String TenSP = rs.getString("TenSP");
				int SL = rs.getInt("SL");
				int ThanhTien = rs.getInt("ThanhTien");
					
				System.out.println("STT: " + STT );
				System.out.println("Mã đơn hàng: " + ID );
				System.out.println("Tên khách hàng: " + TenKH);
				System.out.println("Tên sản phẩm: " + TenSP);
				System.out.println("Số lượng sản phẩm: " + SL);
				System.out.println("Thành tiền: " + ThanhTien);

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
	
	
}
