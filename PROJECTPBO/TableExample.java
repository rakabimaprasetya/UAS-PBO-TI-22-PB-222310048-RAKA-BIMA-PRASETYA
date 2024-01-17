package Project.UAS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableExample extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtNo, txtNama, txtNIS;
    private JComboBox<String> cmbJenisKelamin;

    public TableExample() {
        setTitle("Pembayaran");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inisialisasi model tabel
        tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("Nama Siswa");
        tableModel.addColumn("NIS");
        tableModel.addColumn("Jenis Kelamin");

        // Inisialisasi tabel
        table = new JTable(tableModel);

        // Tambahkan kolom "Action"
        tableModel.addColumn("Action");

        // Tambahkan data contoh ke dalam tabel
        Object[] data = {"1", "Nova", "12345", "Laki-laki", "Hapus"};
        tableModel.addRow(data);

        // Buat panel untuk menambahkan data baru
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel lblNo = new JLabel("No:");
        txtNo = new JTextField(5);

        JLabel lblNama = new JLabel("Nama Siswa:");
        txtNama = new JTextField(15);

        JLabel lblNIS = new JLabel("NIS:");
        txtNIS = new JTextField(10);

        JLabel lblJenisKelamin = new JLabel("Jenis Kelamin:");
        String[] jenisKelamin = {"Laki-laki", "Perempuan"};
        cmbJenisKelamin = new JComboBox<>(jenisKelamin);

        JButton btnTambah = new JButton("Tambah");
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData();
            }
        });

        inputPanel.add(lblNo);
        inputPanel.add(txtNo);
        inputPanel.add(lblNama);
        inputPanel.add(txtNama);
        inputPanel.add(lblNIS);
        inputPanel.add(txtNIS);
        inputPanel.add(lblJenisKelamin);
        inputPanel.add(cmbJenisKelamin);
        inputPanel.add(btnTambah);

        // Layout utama
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Pusatkan frame
    }

    private void tambahData() {
        String no = txtNo.getText();
        String nama = txtNama.getText();
        String nis = txtNIS.getText();
        String jenisKelamin = (String) cmbJenisKelamin.getSelectedItem();

        // Validasi input kosong
        if (no.isEmpty() || nama.isEmpty() || nis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tambahkan data ke dalam tabel
        Object[] data = {no, nama, nis, jenisKelamin, "Hapus"};
        tableModel.addRow(data);

        // Bersihkan input setelah ditambahkan
        txtNo.setText("");
        txtNama.setText("");
        txtNIS.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample().setVisible(true);
            }
        });
    }
}
