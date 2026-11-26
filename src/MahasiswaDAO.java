
import java.sql.*;

public class MahasiswaDAO {

    // CREATE
    public void tambah(String nama, String nim) throws Exception {

        Connection conn = Koneksi.getConnection();
        conn.setAutoCommit(false);

        try {
            String sql = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, nim);

            ps.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw e;

        } finally {
            conn.close();
        }
    }

    // READ
    public String tampil() throws Exception {

        Connection conn = Koneksi.getConnection();

        String hasil = "";

        String sql = "SELECT * FROM mahasiswa";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            hasil += rs.getInt("id") + " - "
                  + rs.getString("nama") + " - "
                  + rs.getString("nim") + "\n";
        }

        conn.close();

        return hasil;
    }

    // UPDATE
    public void ubah(int id, String nama, String nim) throws Exception {

        Connection conn = Koneksi.getConnection();
        conn.setAutoCommit(false);

        try {
            String sql = "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, nim);
            ps.setInt(3, id);

            ps.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw e;

        } finally {
            conn.close();
        }
    }

    // DELETE
    public void hapus(int id) throws Exception {

        Connection conn = Koneksi.getConnection();
        conn.setAutoCommit(false);

        try {
            String sql = "DELETE FROM mahasiswa WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw e;

        } finally {
            conn.close();
        }
    }
}
