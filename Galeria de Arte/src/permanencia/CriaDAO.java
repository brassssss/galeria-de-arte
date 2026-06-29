package permanencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriaDAO {

    public void inserir(int codArtista, int codObra) throws SQLException {
        String sql = "INSERT INTO Cria (codartista, codobra) VALUES (?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codArtista);
        st.setInt(2, codObra);
        st.executeUpdate();
        st.close();
    }

    public void remover(int codArtista, int codObra) throws SQLException {
        String sql = "DELETE FROM Cria WHERE codartista = ? AND codobra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codArtista);
        st.setInt(2, codObra);
        st.executeUpdate();
        st.close();
    }

    public void listarArtistasPorObra(int codObra) throws SQLException {
        String sql = "SELECT a.codartista, a.nome FROM Cria c JOIN Artista a ON c.codartista = a.codartista WHERE c.codobra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codObra);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("nome") + " | codigo: " + rs.getInt("codartista"));
            System.out.println();
        }
        rs.close();
        st.close();
    }

    public void listarObrasPorArtista(int codArtista) throws SQLException {
        String sql = "SELECT o.codobra, o.titulo, o.ano, o.preco FROM Cria c JOIN Obra o ON c.codobra = o.codobra WHERE c.codartista = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codArtista);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("titulo") + " | " + rs.getInt("ano") + " | " + rs.getDouble("preco") + " | codigo: " + rs.getInt("codobra"));
            System.out.println();
        }
        rs.close();
        st.close();
    }
}