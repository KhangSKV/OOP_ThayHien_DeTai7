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


public class Products {

	private JFrame frame;
	private JTextField TenSP;
	private JTextField ID;
	private JTextField MoTa;
	private JTextField GiaSP;
	private JTextField SoLSP;
	private JTable table_1;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products window = new Products();
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
	public Products() {
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
		
		JLabel lblNewLabel = new JLabel("TenSP");
		lblNewLabel.setBounds(53, 69, 95, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(53, 103, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MoTa");
		lblNewLabel_1_1.setBounds(53, 136, 45, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("GiaSP");
		lblNewLabel_1_2.setBounds(53, 167, 78, 13);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SoLSP");
		lblNewLabel_1_3.setBounds(53, 200, 111, 13);
		panel.add(lblNewLabel_1_3);
		
		TenSP = new JTextField();
		TenSP.setBounds(153, 72, 111, 18);
		panel.add(TenSP);
		TenSP.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(153, 100, 111, 19);
		panel.add(ID);
		ID.setColumns(10);
		
		MoTa = new JTextField();
		MoTa.setBounds(153, 133, 111, 19);
		MoTa.setColumns(10);
		panel.add(MoTa);
		
		GiaSP = new JTextField();
		GiaSP.setBounds(153, 164, 111, 19);
		GiaSP.setColumns(10);
		panel.add(GiaSP);
		
		SoLSP = new JTextField();
		SoLSP.setBounds(153, 197, 111, 19);
		SoLSP.setColumns(10);
		panel.add(SoLSP);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 41, 256, 364);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				TenSP.setText(model.getValueAt(i, 0).toString());
				ID.setText(model.getValueAt(i, 1).toString());
				MoTa.setText(model.getValueAt(i, 2).toString());
				GiaSP.setText(model.getValueAt(i, 3).toString());
				SoLSP.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model= new DefaultTableModel();
		
		Object[] column = {"TenSP" , "ID" ," MoTa " ," GiaSP ", " SoLSP"};
		Object[] row = new Object[5];
		model .setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(24, 258, 107, 24);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TenSP.getText().equals("") || ID.getText().equals("") || MoTa.getText().equals("") || GiaSP.getText().equals("") || SoLSP.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null, "Hay nhap day du thong tin");
					
				}
				else {
					row[0] = TenSP.getText();
					row[1] = ID.getText();
					row[2] = MoTa.getText();
					row[3] = GiaSP.getText();
					row[4] = SoLSP.getText();
					model.addRow(row);
					
					TenSP.setText(" ");
					ID.setText(" ");
					MoTa.setText(" ");
					GiaSP.setText(" ");
					SoLSP.setText(" ");
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
				model.setValueAt(TenSP.getText(), i, 0);
				model.setValueAt(ID.getText(), i, 1);
				model.setValueAt(MoTa.getText(), i, 2);
				model.setValueAt(GiaSP.getText(), i, 3);
				model.setValueAt(SoLSP.getText(), i, 4);
			}
		});
		panel.add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(141, 310, 107, 24);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TenSP.setText(" ");
				ID.setText(" ");
				MoTa.setText(" ");
				GiaSP.setText(" ");
				SoLSP.setText(" ");
			}
		});
		panel.add(btnClear);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setBackground(new Color(153, 193, 241));
		lblProducts.setBounds(114, 37, 95, 24);
		panel.add(lblProducts);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setBounds(229, 0, 107, 24);
		panel.add(btnProducts);
		
		JButton btnNewButton_1_1 = new JButton("Customers");
		btnNewButton_1_1.setBounds(336, 0, 107, 24);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("ADD");
		btnNewButton_1_2.setBounds(440, 0, 107, 24);
		panel.add(btnNewButton_1_2);
	}
}