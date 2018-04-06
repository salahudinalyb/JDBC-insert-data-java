package programbunga;

import java.sql.*;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nama;
	private JTextField keterangan;
	private JTextField jumlah;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(178, 31, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		nama = new JTextField();
		nama.setBounds(178, 62, 86, 20);
		contentPane.add(nama);
		nama.setColumns(10);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				 try {
				  String username = "root";
				  String password = "";
				  String url = "jdbc:mysql://localhost:3306/jdbc";
				  Class.forName("com.mysql.jdbc.Driver").newInstance ();
				  conn = DriverManager.getConnection(url, username, password);
				  Statement stmt =conn.createStatement();
				  String tableName = " jdbc.db_bunga ";
				  String sqlStmt = "INSERT INTO "+tableName+"VALUES('"+id.getText()+"','"+nama.getText()+"','"+keterangan.getText()+"','"+jumlah.getText()+"')";
				  int updateCount = stmt.executeUpdate (sqlStmt);
				  stmt.close();
				  conn.close();
				 } catch (Exception e) {
				  System.err.println (e.getMessage());  
				  }
			}
		});
		btnSimpan.setBounds(137, 169, 89, 23);
		contentPane.add(btnSimpan);
		
		keterangan = new JTextField();
		keterangan.setBounds(178, 93, 86, 20);
		contentPane.add(keterangan);
		keterangan.setColumns(10);
		
		jumlah = new JTextField();
		jumlah.setBounds(178, 124, 86, 20);
		contentPane.add(jumlah);
		jumlah.setColumns(10);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(58, 34, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(58, 65, 46, 14);
		contentPane.add(lblNama);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setBounds(58, 96, 76, 14);
		contentPane.add(lblKeterangan);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(58, 127, 46, 14);
		contentPane.add(lblJumlah);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(137, 197, 89, 23);
		contentPane.add(btnReset);
	}
}
