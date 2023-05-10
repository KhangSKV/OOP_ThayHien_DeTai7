package quan_li_ban_hang_onl;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Customers
{

	private JFrame frame;
	private JTextField TenKH;
	private JTextField IDKH;
	private JTextField diaChi;
	private JTextField sdt;
	private JTextField email;
	private JTable table_1;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers window = new Customers();
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
	public Customers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 547, 430);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TenKH");
		lblNewLabel.setBounds(53, 69, 95, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(53, 103, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1.setBounds(53, 136, 62, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setBounds(53, 167, 101, 13);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setBounds(53, 200, 111, 13);
		panel.add(lblNewLabel_1_3);
		
		TenKH = new JTextField();
		TenKH.setBounds(153, 72, 111, 18);
		panel.add(TenKH);
		TenKH.setColumns(10);
		
		IDKH = new JTextField();
		IDKH.setBounds(153, 100, 111, 19);
		panel.add(IDKH);
		IDKH.setColumns(10);
		
		diaChi = new JTextField();
		diaChi.setBounds(153, 133, 111, 19);
		diaChi.setColumns(10);
		panel.add(diaChi);
		
		sdt = new JTextField();
		sdt.setBounds(153, 164, 111, 19);
		sdt.setColumns(10);
		panel.add(sdt);
		
		email = new JTextField();
		email.setBounds(153, 197, 111, 19);
		email.setColumns(10);
		panel.add(email);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 41, 256, 364);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				TenKH.setText(model.getValueAt(i, 0).toString());
				IDKH.setText(model.getValueAt(i, 1).toString());
				diaChi.setText(model.getValueAt(i, 2).toString());
				sdt.setText(model.getValueAt(i, 3).toString());
				email.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model= new DefaultTableModel();
		
		Object[] column = {"TenKH" , "ID" ," Địa chỉ" ,"SĐT", " Email"};
		Object[] row = new Object[5];
		model .setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(24, 258, 107, 24);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TenKH.getText().equals("") || IDKH.getText().equals("") || diaChi.getText().equals("") || sdt.getText().equals("") || email.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Hay nhap day du thong tin");
					
				}
				else {
					row[0] = TenKH.getText();
					row[1] = IDKH.getText();
					row[2] = diaChi.getText();
					row[3] = sdt.getText();
					row[4] = email.getText();
					model.addRow(row);
					
					TenKH.setText(" ");
					IDKH.setText(" ");
					diaChi.setText(" ");
					sdt.setText(" ");
					email.setText(" ");
					JOptionPane.showMessageDialog(null, "Thong tin da hoan thanh");
				}
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(141, 258, 107, 24);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Thong tin da duoc xoa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hay chon thong tin de xoa ");
				}
			}
		});
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(24, 310, 107, 24);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				model.setValueAt(TenKH.getText(), i, 0);
				model.setValueAt(IDKH.getText(), i, 1);
				model.setValueAt(diaChi.getText(), i, 2);
				model.setValueAt(sdt.getText(), i, 3);
				model.setValueAt(email.getText(), i, 4);
			}
		});
		panel.add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(141, 310, 107, 24);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TenKH.setText(" ");
				IDKH.setText(" ");
				diaChi.setText(" ");
				sdt.setText(" ");
				email.setText(" ");
			}
		});
		panel.add(btnClear);
		
		JLabel lblProducts = new JLabel("Customers");
		lblProducts.setBackground(new Color(153, 193, 241));
		lblProducts.setBounds(114, 37, 95, 24);
		panel.add(lblProducts);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		btnProducts.setBounds(214, 0, 107, 24);
		panel.add(btnProducts);
		
		JButton btnNewButton_1_1 = new JButton("Customers");
		btnNewButton_1_1.setBounds(320, 0, 123, 24);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Bill");
		btnNewButton_1_2.setBounds(440, 0, 107, 24);
		panel.add(btnNewButton_1_2);
	}
}