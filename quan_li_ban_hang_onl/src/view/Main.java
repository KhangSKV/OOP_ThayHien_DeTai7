package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Order panelorder;
	private Product panelproduct;
	private Customer panecustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1024, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelorder  = new Order();
		panelproduct = new Product();
		panecustomer = new Customer();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 234, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelProduct = new JPanel();
		panelProduct.addMouseListener(new PanelButtonMouseAdapter(panelProduct){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelproduct);
			}
		});
		panelProduct.setBackground(new Color(60, 179, 113));
		panelProduct.setForeground(new Color(0, 0, 0));
		panelProduct.setBounds(0, 109, 234, 105);
		panel.add(panelProduct);
		panelProduct.setLayout(null);
		
		JLabel lblProdcuct = new JLabel("Product");
		lblProdcuct.setForeground(new Color(255, 255, 255));
		lblProdcuct.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProdcuct.setBounds(67, 32, 82, 33);
		panelProduct.add(lblProdcuct);
		
		JPanel panelCustomer = new JPanel();
		panelCustomer.addMouseListener(new PanelButtonMouseAdapter(panelCustomer) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panecustomer);
			}
		});
		panelCustomer.setBackground(new Color(60, 179, 113));
		panelCustomer.setBounds(0, 271, 234, 105);
		panel.add(panelCustomer);
		panelCustomer.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setForeground(new Color(255, 255, 255));
		lblCustomer.setBackground(new Color(175, 238, 238));
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCustomer.setBounds(62, 36, 105, 33);
		panelCustomer.add(lblCustomer);
		
		JPanel panelOrder = new JPanel();
		panelOrder.setForeground(new Color(255, 255, 255));
		panelOrder.addMouseListener(new PanelButtonMouseAdapter(panelOrder){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelorder);
			}
		});
		panelOrder.setBackground(new Color(60, 179, 113));
		panelOrder.setBounds(0, 430, 234, 105);
		panel.add(panelOrder);
		panelOrder.setLayout(null);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setForeground(new Color(255, 255, 255));
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblOrder.setBounds(64, 35, 88, 33);
		panelOrder.add(lblOrder);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(244, 10, 760, 686);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(panecustomer);
		panel_1.add(panelorder);
		panel_1.add(panelproduct);
 		menuClicked(panelproduct);
 		
	}
	public void menuClicked(JPanel selectedPanel) {
		panecustomer.setVisible(false);
		panelorder.setVisible(false);  
		panelproduct.setVisible(false);
		selectedPanel.setVisible(true);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel)	{
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(112, 128, 144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
//			panel.setBackground(new Color(47, 79, 79));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
//			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
	}
	}
}
