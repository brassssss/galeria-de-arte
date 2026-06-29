package permanencia;

import dados.Exposicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExposicaoDAO {

    public void inserir(Exposicao e) throws SQLException{
        String sql = "INSERT INTO Exposicao (titulo, tema, dtInicio, dtFim) VALUES (?, ?, ?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, e.getTitulo());
        st.setString(2, e.getTema());
        st.setDate(3, e.getDtInicio());
        st.setDate(4, e.getDtFim());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            e.setCodExposicao(rs.getInt(1));
        }
        rs.close();
        st.close();
    }

    public void remover(int codExposicao) throws SQLException{
        String sql = "DELETE FROM Exposicao WHERE codExposicao = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codExposicao);
        st.executeUpdate();
        st.close();
    }

    public List<Exposicao> listarTodos()  throws SQLException {
        String sql = "SELECT * FROM Exposicao";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        List<Exposicao> lista = new ArrayList<>();
        while(rs.next()){
            Exposicao e = new Exposicao();
            e.setCodExposicao(rs.getInt(1));
            e.setTitulo(rs.getString(2));
            e.setTema(rs.getString(3));
            e.setDtInicio(rs.getDate(4));
            e.setDtFim(rs.getDate(5));
            lista.add(e);
        }
        return lista;
    }

}
