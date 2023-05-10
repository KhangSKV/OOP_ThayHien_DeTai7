package quan_li_ban_hang_onl;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
public class Orders {
	
	private JFrame frame;
	private JTextField id;
	private JTextField tenSp;
	private JTextField soLuong;
	private JTextField tongGia;
	private JTable table;
	DefaultTableModel model;
	
	
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Orders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		ArrayList<Product> productList = new ArrayList<>();
		Product newProduct1 = new Product("01", "milk", "Mo ta san pham 1", 10.0f, 10);
		productList.add(newProduct1);
		Product newProduct_2 = new Product("02", "tea", "Mo ta san pham 2", 20.0f, 20);
	    productList.add(newProduct_2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel =  new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 661, 596);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(39, 52, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên SP");
		lblNewLabel_1.setBounds(40, 76, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("So Luong");
		lblNewLabel_2.setBounds(39, 102, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gia");
		lblNewLabel_3.setBounds(39, 125, 45, 13);
		panel.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 11));
		id.setBounds(91, 50, 163, 19);
		panel.add(id);
		id.setColumns(10);
		
		tenSp = new JTextField();
		tenSp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tenSp.setBounds(91, 73, 163, 19);
		panel.add(tenSp);
		tenSp.setColumns(10);
		
		soLuong = new JTextField();
		soLuong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		soLuong.setBounds(91, 99, 163, 19);
		panel.add(soLuong);
		soLuong.setColumns(10);
		
		tongGia = new JTextField();
		tongGia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tongGia.setBounds(91, 122, 163, 19);
		panel.add(tongGia);
		tongGia.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 230, 584, 328);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				tenSp.setText(model.getValueAt(i, 1).toString());
				soLuong.setText(model.getValueAt(i, 2).toString());
				tongGia.setText(model.getValueAt(i, 3).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID","Ten SP","So luong","Tong gia"};
		Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model); 
		scrollPane.setViewportView(table);
		JLabel totalsum = new JLabel("0.0");
		totalsum.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totalsum.setBounds(437, 183, 169, 36);
		panel.add(totalsum);
		JButton btnNewButton = new JButton("ADD");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = tenSp.getText();
			     int quantity = Integer.parseInt(Orders.this.soLuong.getText());

			        
			     boolean nameExists = false; 
			     for (Product product: productList) {
			          if (product.getTenSP().equals(name)) {
			        	  nameExists = true;
			              break;
			            }
			        }
			     boolean quantityExists = false; 
			     for (Product product: productList) {
			          if (product.getSoLuongSP()>=quantity) {
			        	  quantityExists = true;
			              break;
			            }
			        }
				if (!quantityExists||!nameExists||id.getText().equals("")|| tenSp.getText().equals("")||soLuong.getText().equals("")||tongGia.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill complete infomation");
				}
//				
				else {
					row[0] = id.getText();
					row[1] = tenSp.getText();
					row[2] = soLuong.getText();
					row[3] = tongGia.getText();
					model.addRow(row);
					id.setText("");
					tenSp.setText("");
					soLuong.setText("");
					tongGia.setText("");
					
					double total = 0;
					for (int i = 0;i<table.getRowCount();i++) {
						int amount = Integer.parseInt((String) table.getValueAt(i,3));
						total+=amount; 
					}
					totalsum.setText(String.valueOf(total));
						try {
						
						}
						catch(Exception e2) {
						
						}
						
					
				}        	      
			} 
		});
		btnNewButton.setBounds(296, 49, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a row");
				
				}
				
			}
		});
		btnNewButton_1.setBounds(437, 49, 85, 21);
		panel.add(btnNewButton_1);				
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(id.getText(), i, 0);
					model.setValueAt(tenSp.getText(), i, 1);
					model.setValueAt(soLuong.getText(), i, 2);
					model.setValueAt(tongGia.getText(), i, 3);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a row");
				}
			}
		});
		btnNewButton_2.setBounds(296, 98, 85, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("CLEAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);

			}
		});
		btnNewButton_4.setBounds(437, 98, 85, 21);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				}
				catch(Exception e1) {}
			}
		});
		btnNewButton_3.setBounds(368, 152, 85, 21);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(382, 196, 45, 13);
		panel.add(lblNewLabel_4);
		
		
	}

	protected static DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
