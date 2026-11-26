
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    JTextField txtId, txtNama, txtNim;
    JTextArea area;
    JButton btnTambah, btnTampil, btnUbah, btnHapus;

    MahasiswaDAO dao = new MahasiswaDAO();

    public Main() {

        setTitle("Data Mahasiswa");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtId = new JTextField(10);
        txtNama = new JTextField(10);
        txtNim = new JTextField(10);

        btnTambah = new JButton("Tambah");
        btnTampil = new JButton("Tampilkan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");

        area = new JTextArea(10, 35);
        area.setEditable(false);

        add(new JLabel("ID:"));
        add(txtId);

        add(new JLabel("Nama:"));
        add(txtNama);

        add(new JLabel("NIM:"));
        add(txtNim);

        add(btnTambah);
        add(btnTampil);
        add(btnUbah);
        add(btnHapus);

        add(new JScrollPane(area));

        btnTambah.addActionListener(e -> {
            proses(() -> dao.tambah(
                txtNama.getText(), txtNim.getText()
            ));
        });

        btnTampil.addActionListener(e -> {
            btnTampil.setEnabled(false);
            area.setText("Loading...");

            new Thread(() -> {
                try {
                    String data = dao.tampil();

                    SwingUtilities.invokeLater(() -> {
                        area.setText(data);
                        btnTampil.setEnabled(true);
                    });

                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        area.setText("Error: " + ex.getMessage());
                        btnTampil.setEnabled(true);
                    });
                }
            }).start();
        });

        btnUbah.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());

                proses(() -> dao.ubah(
                    id, txtNama.getText(), txtNim.getText()
                ));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID harus angka!");
            }
        });

        btnHapus.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                proses(() -> dao.hapus(id));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID harus angka!");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Proses menggunakan Thread
    interface Tugas {
        void jalankan() throws Exception;
    }

    void proses(Tugas tugas) {

        btnTambah.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);

        area.setText("Saving...");

        new Thread(() -> {

            try {
                tugas.jalankan();

                SwingUtilities.invokeLater(() -> {
                    area.setText("Data berhasil diproses!");
                    aktifkanTombol();
                });

            } catch (Exception e) {

                SwingUtilities.invokeLater(() -> {
                    area.setText("Error: " + e.getMessage());
                    aktifkanTombol();
                });
            }

        }).start();
    }

    void aktifkanTombol() {
        btnTambah.setEnabled(true);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
