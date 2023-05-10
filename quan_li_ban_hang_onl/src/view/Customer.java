package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import connectData.ConnectDB;
import connectData.Customers;
//import connectData.test;
public class Customer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TenKH;
	//private JTextField IDKH;
	private JTextField diaChi;
	private JTextField sdt;
	private JTextField email;
	private JTable table;
	DefaultTableModel model;
	private JTextField findName;
	/**
	 * Create the panel.
	 */
	public Customer() {
		setBounds(0, 0, 760, 686);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ten KH");
		lblNewLabel.setBounds(40, 70, 67, 13);
		add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Dia chi");
		lblNewLabel_2.setBounds(40, 101, 67, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SDT");
		lblNewLabel_3.setBounds(40, 131, 67, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(40, 161, 67, 13);
		add(lblNewLabel_4);
		
		TenKH = new JTextField();
		TenKH.setBounds(117, 66, 158, 19);
		add(TenKH);
		TenKH.setColumns(10);
		
		diaChi = new JTextField();
		diaChi.setBounds(117, 97, 158, 19);
		add(diaChi);
		diaChi.setColumns(10);
		
		sdt = new JTextField();
		sdt.setBounds(117, 127, 158, 19);
		add(sdt);
		sdt.setColumns(10);
		
		email = new JTextField();
		email.setBounds(117, 157, 158, 19);
		add(email);
		email.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 109, 397, 422);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TenKH.setText(model.getValueAt(i, 1).toString());
				//IDKH.setText(model.getValueAt(i, 1).toString());
				diaChi.setText(model.getValueAt(i, 2).toString());
				sdt.setText(model.getValueAt(i, 3).toString());
				email.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model= new DefaultTableModel();
		
		Object[] column = {"ID" , "Tên KH" ," Địa chỉ" ,"SĐT", " Email"};
		Object[] row = new Object[5];
		
		
		
		model .setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TenKH.getText().equals("") ||  diaChi.getText().equals("") || sdt.getText().equals("") || email.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Hay nhap day du thong tin");
					
				}
				else {
					String TenKH_1 = TenKH.getText();
					//String  = IDKH.getText();
					String DiaChi = diaChi.getText();
					String SoDT  = sdt.getText();
					String mail = email.getText();
					
					Customers.themKH(TenKH_1, DiaChi, SoDT, mail);
					
					TenKH.setText("");
					//IDKH.setText(" ");
					diaChi.setText("");
					sdt.setText("");
					email.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
				}
			}
		});
		add.setBounds(76, 307, 85, 21);
		add(add);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i>=0) {
					String k = (model.getValueAt(i, 0).toString());
					//int k = (int) row[0];
					Customers.xoaKH(k);
					JOptionPane.showMessageDialog(null, "Thong tin da duoc xoa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hay chon thong tin de xoa ");
				}
			}
		});
		delete.setBounds(190, 307, 85, 21);
		add(delete);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0) {
					String ids = (model.getValueAt(i, 0).toString());
					String TenKH_1 = TenKH.getText();
					//String  = IDKH.getText();
					String DiaChi = diaChi.getText();
					String SoDT  = sdt.getText();
					String mail = email.getText();
					
					Customers.capNhapKH(ids,TenKH_1, DiaChi, SoDT, mail);
					
					TenKH.setText("");
					//IDKH.setText(" ");
					diaChi.setText("");
					sdt.setText("");
					email.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
					
				}
				
				
			}
			
		});
		update.setBounds(76, 360, 85, 21);
		add(update);
		
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TenKH.setText("");
				//IDKH.setText(" ");
				diaChi.setText("");
				sdt.setText("");
				email.setText("");
			}
		});
		clear.setBounds(190, 360, 85, 21);
		add(clear);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTOMER");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(247, 22, 158, 26);
		add(lblNewLabel_5);
		
		JButton Hien_thi = new JButton("SHOW");
		Hien_thi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        model.setRowCount(0); // Xóa tất cả các dòng trong bảng

		        Connection con = ConnectDB.connect();
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        try {
		            String sql = "SELECT * FROM Customers";
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();
		            while(rs.next()) {
		                int ID = rs.getInt("ID");
		                row[0] = Integer.toString(ID);
		                row[1] = rs.getString("TenKH");
		                row[2] = rs.getString("DiaChi");
		                row[3] = rs.getString("sdt");
		                row[4] = rs.getString("email");
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

		Hien_thi.setBounds(476, 587, 85, 21);
		add(Hien_thi);
		
		JLabel lblNewLabel_1 = new JLabel("Nhap ten");
		lblNewLabel_1.setBounds(313, 69, 85, 14);
		add(lblNewLabel_1);
		
		findName = new JTextField();
		findName.setBounds(418, 66, 161, 20);
		add(findName);
		findName.setColumns(10);
		
		JButton find = new JButton("FIND");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String name = findName.getText();
				//String name = "Khang";
				Connection con = ConnectDB.connect();
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    try {
			        String sql = "SELECT * FROM Customers WHERE TenKH LIKE ?";
			        ps = con.prepareStatement(sql);
			        ps.setString(1, "%" + name + "%");
			        rs = ps.executeQuery();
			        while(rs.next()) {
			            int ID = rs.getInt("ID");
			            row[0] = Integer.toString(ID);
			            row[1] = rs.getString("TenKH");
			            row[2] = rs.getString("DiaChi");
			            row[3] = rs.getString("sdt");
			            row[4] = rs.getString("email");
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
		find.setBounds(585, 65, 89, 23);
		add(find);
		
	}
	
}