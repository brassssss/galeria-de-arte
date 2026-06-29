package permanencia;

import dados.Artista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    public void inserir(Artista a) throws SQLException {
        String sql = "INSERT INTO Artista (nome, nacionalidade, dtNascimento) VALUES (?, ?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, a.getNome());
        st.setString(2, a.getNacionalidade());
        st.setDate(3, a.getDataNascimento());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            a.setCodArtista(rs.getInt(1));
        }
        rs.close();
        st.close();
    }

    public void remover(int codArtista) throws SQLException {
        String sql = "DELETE FROM Artista WHERE codArtista = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codArtista);
        st.executeUpdate();
        st.close();
    }

    public List<Artista> listarTodos() throws SQLException {
        String sql = "SELECT * FROM Artista";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        List<Artista> lista = new ArrayList<>();
        while (rs.next()) {
            Artista a = new Artista();
            a.setCodArtista(rs.getInt("codArtista"));
            a.setNome(rs.getString("nome"));
            a.setNacionalidade(rs.getString("nacionalidade"));
            a.setDataNascimento(rs.getDate("dtNascimento"));
            lista.add(a);
        }
        rs.close();
        st.close();
        return lista;
    }

    public void listarArtistasComMaisDeUmaObra() throws SQLException {
        String sql = "SELECT a.nome FROM Artista a WHERE (SELECT COUNT(*) FROM Cria c WHERE c.codartista = a.codartista) > 1";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("nome"));
            System.out.println();
        }
        rs.close();
        st.close();
    }
}