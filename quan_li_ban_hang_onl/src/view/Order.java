package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectData.Bills;
import connectData.ConnectDB;
import connectData.Products;
import quan_li_ban_hang_onl.Product;
import quan_li_ban_hang_onl.test;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Order extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textTensp;
	private JTextField textTenKh;
	private JTextField textMadh;
	private JTable table;
	DefaultTableModel model;
	private JTextField textsoluongField;
	private JTextField madh;
	private JTextField tongdh;
	/**
	 * Create the panel.
	 */
	public Order() {
		setBounds(0, 0, 760, 686);
		setLayout(null);
		ArrayList<Product> productList = new ArrayList<>();
		Product newProduct1 = new Product("01", "milk", "Mo ta san pham 1", 20.0f, 10);
		productList.add(newProduct1);
		Product newProduct_2 = new Product("02", "tea", "Mo ta san pham 2", 20.0f, 10);
	    productList.add(newProduct_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ma DH");
		lblNewLabel_1.setBounds(70, 86, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ten SP");
		lblNewLabel_2.setBounds(70, 109, 45, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ten KH");
		lblNewLabel_3.setBounds(70, 132, 52, 13);
		add(lblNewLabel_3);
		
		textTensp = new JTextField();
		textTensp.setBounds(144, 105, 142, 19);
		add(textTensp);
		textTensp.setColumns(10);
		
		textTenKh = new JTextField();
		textTenKh.setBounds(144, 128, 142, 19);
		add(textTenKh);
		textTenKh.setColumns(10);
		
		textMadh = new JTextField();
		textMadh.setBounds(144, 82, 142, 19);
		add(textMadh);
		textMadh.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 272, 565, 248);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textMadh.setText(model.getValueAt(i, 1).toString());
				//textidField.setText(model.getValueAt(i, 1).toString());
				textTenKh.setText(model.getValueAt(i, 2).toString());
				textTensp.setText(model.getValueAt(i, 3).toString());
				textsoluongField.setText(model.getValueAt(i, 4).toString());
				
				
				}
		});
		model = new DefaultTableModel();
		Object[] column = {"STT","Ma DH","Ten KH","Ten SP","So Luong","Thanh tien"};
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model); 
		scrollPane.setViewportView(table);
		
		JButton btnDELETE = new JButton("ADD");
		btnDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTensp.getText().equals("") ||  textTenKh.getText().equals("") || textMadh.getText().equals("") || textsoluongField.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Hay nhap day du thong tin");
					
				}
				else {
					String TenSP = textTensp.getText();
					//row[1] = textidField.getText();
					String TenKH = textTenKh.getText();
					String MDH = textMadh.getText();
					int MaDH = Integer.parseInt(MDH);
					
					String SL = textsoluongField.getText();
					int SoLuong = Integer.parseInt(SL);
					//model.addRow(row);
					
					Bills.themDH(MaDH, TenKH, TenSP, SoLuong);
					
					textTensp.setText("");
					//textidField.setText(" ");
					textTenKh.setText("");
					textMadh.setText("");
					textsoluongField.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
				}
			}
		});
		btnDELETE.setBounds(360, 82, 85, 21);
		add(btnDELETE);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					String k = (model.getValueAt(i, 1).toString());
					//int k = (int) row[0];
					Bills.xoaDH(k);
					JOptionPane.showMessageDialog(null, "Thong tin da duoc xoa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hay chon thong tin de xoa ");
				}
			}
		});
		btnDelete.setBounds(495, 82, 85, 21);
		add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0) {
					
					String STT = (model.getValueAt(i, 0).toString());
					String TenSP = textTensp.getText();
					//row[1] = textidField.getText();
					String TenKH = textTenKh.getText();
					String MDH = textMadh.getText();
					int MaDH = Integer.parseInt(MDH);
					
					String SL = textsoluongField.getText();
					int SoLuong = Integer.parseInt(SL);
					//model.addRow(row);
					
					Bills.capNhapDH(STT,MaDH, TenKH, TenSP, SoLuong);
					
					textTensp.setText("");
					//textidField.setText(" ");
					textTenKh.setText("");
					textMadh.setText("");
					textsoluongField.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
				}
			
			}
		});
		btnUpdate.setBounds(360, 128, 85, 21);
		add(btnUpdate);
		
		JButton btnCLEAr = new JButton("CLEAR");
		btnCLEAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTensp.setText("");
				//textidField.setText(" ");
				textMadh.setText("");
				textTenKh.setText("");
				textsoluongField.setText("");
				
			}
			
		});
		btnCLEAr.setBounds(495, 128, 85, 21);
		add(btnCLEAr);
		
		JLabel lblNewLabel_5 = new JLabel("BILL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(287, 10, 123, 39);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("So Luong");
		lblNewLabel_4.setBounds(70, 155, 62, 13);
		add(lblNewLabel_4);
		
		textsoluongField = new JTextField();
		textsoluongField.setBounds(144, 151, 142, 19);
		add(textsoluongField);
		textsoluongField.setColumns(10);
		
		JButton btnHienThi = new JButton("SHOW");
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0); // Xóa tất cả các dòng trong bảng

		        Connection con = ConnectDB.connect();
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        try {
		            String sql = "SELECT * FROM Bills";
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();
		            while(rs.next()) {
		                int ID = rs.getInt("STT");
		                row[0] = Integer.toString(ID);
		                row[1] = rs.getInt("MaDH");
		                row[2] = rs.getString("TenKH");
		                row[3] = rs.getString("TenSP");
		                row[4] = rs.getInt("SL");
		                row[5] = rs.getInt("ThanhTien");
		                model.addRow(row);
		            }
		        } catch(SQLException e1) {
		            System.out.println(e1.toString());
		        } finally {
		            try {
		                rs.close();
		                ps.close();
		                con.close();
		            } catch (SQLException e1) {
		                System.out.println(e1.toString());
		            }
		        }
			}
		});
		btnHienThi.setBounds(307, 550, 89, 23);
		add(btnHienThi);
		
		JLabel lblNewLabel = new JLabel("Ma DH");
		lblNewLabel.setBounds(261, 236, 49, 14);
		add(lblNewLabel);
		
		madh = new JTextField();
		madh.setBounds(299, 233, 62, 20);
		
		add(madh);
		madh.setColumns(10);
		
		tongdh = new JTextField();
		tongdh.setBounds(539, 233, 96, 20);
		add(tongdh);
		tongdh.setColumns(10);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MaDH = madh.getText();
				Connection con = ConnectDB.connect();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					String sql = "SELECT SUM(ThanhTien) FROM Bills WHERE MaDH = ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, MaDH);
					rs = ps.executeQuery();
					
					int size = rs.getInt(1);
					String strNumber = String.valueOf(size);
					//System.out.println("Có tất cả " + size + " sản phẩm");
					tongdh.setText(strNumber);
				}catch(SQLException e1) {
					System.out.println(e1.toString());
				}finally {
					try {
						rs.close();
						ps.close();
						con.close();
						
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(440, 232, 89, 23);
		add(btnNewButton);
		
		

	}
}