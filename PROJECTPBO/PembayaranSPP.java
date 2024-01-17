package Project.UAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PembayaranSPP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNamaUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PembayaranSPP frame = new PembayaranSPP();
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
	public PembayaranSPP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Sistem Informasi Manajemen Keuangan Sekolah");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNamaUser = new JTextField();
		txtNamaUser.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"- Pilih Tahun Angkatan", "2018/2019", "2020/20021", "2022/2023"}));
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		
		final JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtNamaUser.getText();
				String password = txtPassword.getText();
				if(username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton, "Silahkan mengisi data dengan benar", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!username.equals("admin") || !password.equals("123")) {
					JOptionPane.showMessageDialog(btnNewButton, "Data yang anda masukan salah", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Selamat datang " + username, "Login Success", JOptionPane.INFORMATION_MESSAGE);
					JFrameDASHBOARD dashboard = new JFrameDASHBOARD();
					dashboard.setVisible(true);
					dispose();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING)
								.addComponent(lblNewLabel_2, Alignment.LEADING)
								.addComponent(txtPassword, Alignment.LEADING, 381, 381, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, 381, Short.MAX_VALUE)
								.addComponent(txtNamaUser, Alignment.LEADING)
								.addComponent(btnNewButton))))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNamaUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
