package permanencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipaDAO {

    public void inserir(int codExposicao, int codObra) throws SQLException {
        String sql = "INSERT INTO Participa (codexposicao, codobra) VALUES (?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codExposicao);
        st.setInt(2, codObra);
        st.executeUpdate();
        st.close();
    }

    public void remover(int codExposicao, int codObra) throws SQLException {
        String sql = "DELETE FROM Participa WHERE codexposicao = ? AND codobra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codExposicao);
        st.setInt(2, codObra);
        st.executeUpdate();
        st.close();
    }

    public void listarObrasPorExposicao(int codExposicao) throws SQLException {
        String sql = "SELECT o.codobra, o.titulo FROM Participa p JOIN Obra o ON p.codobra = o.codobra WHERE p.codexposicao = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codExposicao);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("titulo") + " | codigo: " + rs.getInt("codobra"));
            System.out.println();
        }

        rs.close();
        st.close();
    }

    public void listarExposicoesPorObra(int codObra) throws SQLException {
        String sql = "SELECT e.codexposicao, e.titulo FROM Participa p JOIN Exposicao e ON p.codexposicao = e.codexposicao WHERE p.codobra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codObra);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("titulo") + " | codigo: " + rs.getInt("codexposicao"));
            System.out.println();
        }

        rs.close();
        st.close();
    }
}