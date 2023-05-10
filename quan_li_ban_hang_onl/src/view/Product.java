package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

//import connectData.Customers;
import connectData.Products;
import quan_li_ban_hang_onl.test;

public class Product extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textSPField;
	private JTextField textsoluongField;
	private JTextField texttonggiaField;
	private JTable table;
	private JTextField textmotaField;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public Product() {
		setBounds(0, 0, 760, 686);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ten SP");
		lblNewLabel.setBounds(52, 76, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Mo ta");
		lblNewLabel_2.setBounds(52, 107, 45, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gia");
		lblNewLabel_3.setBounds(52, 137, 45, 13);
		add(lblNewLabel_3);
		
		textSPField = new JTextField();
		textSPField.setBounds(130, 72, 138, 19);
		add(textSPField);
		textSPField.setColumns(10);
		
		textmotaField = new JTextField();
		textmotaField.setBounds(130, 103, 138, 19);
		add(textmotaField);
		textmotaField.setColumns(10);
		
		texttonggiaField = new JTextField();
		texttonggiaField.setBounds(130, 133, 138, 19);
		add(texttonggiaField);
		texttonggiaField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 76, 420, 434);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textSPField.setText(model.getValueAt(i, 1).toString());
				//textidField.setText(model.getValueAt(i, 1).toString());
				textmotaField.setText(model.getValueAt(i, 2).toString());
				texttonggiaField.setText(model.getValueAt(i, 3).toString());
				textsoluongField.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model= new DefaultTableModel();
		
		Object[] column = {"ID" , "TenSP" ," MoTa " ," GiaSP ", " SoLSP"};
		Object[] row = new Object[5];
		model .setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textSPField.getText().equals("") ||  textmotaField.getText().equals("") || texttonggiaField.getText().equals("") || textsoluongField.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Hay nhap day du thong tin");
					
				}
				else {
					String TenSP = textSPField.getText();
					//row[1] = textidField.getText();
					String MoTa = textmotaField.getText();
					String Gia = texttonggiaField.getText();
					float GiaSP = Float.parseFloat(Gia);

					String SL = textsoluongField.getText();
					int SoLuong = Integer.parseInt(SL);
					//model.addRow(row);
					
					Products.ThemSP(TenSP, MoTa, GiaSP, SoLuong);
					
					textSPField.setText("");
					//textidField.setText(" ");
					textmotaField.setText("");
					texttonggiaField.setText("");
					textsoluongField.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
				}
			}
		});
		add.setBounds(62, 297, 85, 21);
		add(add);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					String k = (model.getValueAt(i, 0).toString());
					//int k = (int) row[0];
					Products.xoaSP(k);
					JOptionPane.showMessageDialog(null, "Thong tin da duoc xoa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hay chon thong tin de xoa ");
				}
			}
		});
		delete.setBounds(183, 297, 85, 21);
		add(delete);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0) {
					String ids = (model.getValueAt(i, 0).toString());
					String TenSP = textSPField.getText();
					//row[1] = textidField.getText();
					String MoTa = textmotaField.getText();
					String Gia = texttonggiaField.getText();
					float GiaSP = Float.parseFloat(Gia);

					String SL = textsoluongField.getText();
					int SoLuong = Integer.parseInt(SL);
					
					Products.capNhapSP(ids,TenSP, MoTa, GiaSP, SoLuong);
					
					textSPField.setText("");
					//IDKH.setText(" ");
					textmotaField.setText("");
					texttonggiaField.setText("");
					textsoluongField.setText("");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");}
			}
		});
		update.setBounds(62, 352, 85, 21);
		add(update);
		
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSPField.setText("");
				//textidField.setText(" ");
				textmotaField.setText("");
				texttonggiaField.setText("");
				textsoluongField.setText("");
			}
		});
		clear.setBounds(183, 352, 85, 21);
		add(clear);
		
		JLabel lblNewLabel_4 = new JLabel("So luong");
		lblNewLabel_4.setBounds(52, 167, 68, 13);
		add(lblNewLabel_4);
		
		textsoluongField = new JTextField();
		textsoluongField.setBounds(130, 163, 138, 19);
		add(textsoluongField);
		textsoluongField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PRODUCT");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(275, 10, 138, 39);
		add(lblNewLabel_5);
		
		JButton btnHienThi = new JButton("SHOW");
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0); 
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
						row[0] = Integer.toString(ID);
		                row[1] = rs.getString("TenSP");
		                row[2] = rs.getString("MoTa");
		                row[3] = rs.getFloat("GiaSP");
		                row[4] = rs.getInt("SoLuong");
		                model.addRow(row);
							
						

					}
				}catch(SQLException e1) {
					System.out.println(e1.toString());
				}finally {
					try {
						rs.close();
						ps.close();
						con.close();
						
					}catch (SQLException e1) {
						System.out.println(e1.toString());
					}
				}
			}
		});
		btnHienThi.setBounds(472, 542, 89, 23);
		add(btnHienThi);

	}
}
