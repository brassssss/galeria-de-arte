package permanencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String url = "jdbc:postgresql://localhost:5432/galeria_de_arte";
    private static final String usuario = "postgres";
    private static final String senha = "bras";

    private static Connection conexao = null;

    private ConexaoDB() { }

    public static Connection getConexao() throws SQLException {
        if(conexao == null) {
            conexao = DriverManager.getConnection(url, usuario, senha);
        }
        return conexao;
    }
}
