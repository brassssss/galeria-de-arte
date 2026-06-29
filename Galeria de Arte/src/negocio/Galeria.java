package negocio;
import dados.*;
import permanencia.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Galeria {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        try {
            Connection con = ConexaoDB.getConexao();
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        while(true){
            int op = menu();
            if(op == 0){
                break;
            }else if (op == 1) {
                try {
                    inserirArtista();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else if (op == 2) {
                try {
                    listarArtistas();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else if (op == 3) {
                try {
                    removerArtista();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 4){
                try {
                    inserirComprador();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 5){
                try {
                    listarCompradores();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 6){
                try {
                    removerComprador();
                }catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 7){
                try {
                    inserirExposicao();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 8){
                try {
                    listarExposicoes();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 9){
                try {
                    removerExposicao();
                }catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 10){
                try {
                    inserirObra();
                } catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 11){
                try {
                    listarObras();
                } catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 12){
                try {
                    removerObra();
                }catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 13){
                try {
                    inserirRegistro();
                } catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 14){
                try{
                    listarRegistros();
                }catch (SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 15){
                try{
                    removerRegistro();
                }catch(SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            else if(op == 16){
                try {
                    atribuirObra();
                }catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 17){
                try {
                    listarArtistasObra();
                }catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 18){
                try {
                    listarObrasArtista();
                }catch(SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 19){
                try {
                    removerAtribuicao();
                }catch(SQLException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 20){
                try{
                    adicionarObraExposicao();
                }catch (SQLException | IOException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 21){
                try {
                    mostrarExposicoesObra();
                }catch  (SQLException | IOException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 22){
                try {
                    mostrarObrasExposicao();
                } catch (SQLException | IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 23){
                try {
                    removerObraExposicao();
                }catch (SQLException | IOException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }else if(op == 24){
                try {
                    listarArtistasMaisDeUmaObra();
                }catch (SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
    }


    public static int menu(){
        System.out.println("Galeria de Arte");
        System.out.println("Digite a opcao desejada: ");
        System.out.println("0 - Sair do sistema");
        System.out.println("1 - Inserir artista");
        System.out.println("2 - Consultar artistas");
        System.out.println("3 - Remover artista");
        System.out.println("4 - Inserir comprador");
        System.out.println("5 - Consultar compradores");
        System.out.println("6 - Remover comprador");
        System.out.println("7 - Inserir exposicao");
        System.out.println("8 - Consultar exposicoes");
        System.out.println("9 - Remover exposicao");
        System.out.println("10 - Inserir obra");
        System.out.println("11 - Consultar obras");
        System.out.println("12 - Remover obra");
        System.out.println("13 - Inserir registro de compra");
        System.out.println("14 - Consultar registros de compra");
        System.out.println("15 - Remover registro de compra");
        System.out.println("16 - Atribuir obra a artista");
        System.out.println("17 - Mostrar artistas de uma obra");
        System.out.println("18 - Mostrar obras de um artista");
        System.out.println("19 - Remover atribuicao");
        System.out.println("20 - Adicionar obra a exposicao");
        System.out.println("21 - Mostrar exposicoes de uma obra");
        System.out.println("22 - Mostrar obras de uma exposicao");
        System.out.println("23 - Remover obra de uma exposicao");
        System.out.println("24 - Listar artistas com mais de uma obra");
        return Integer.parseInt(sc.nextLine());
    }

    public static void inserirArtista() throws SQLException {
        System.out.println("Digite o nome do artista: ");
        String nome = sc.nextLine();
        System.out.println("Digite a nascionalidade do artista: ");
        String nasc = sc.nextLine();
        System.out.println("Digite a data de nascimento do artista: ");
        Date dataNasc = Date.valueOf(sc.nextLine());

        Artista artista = new Artista(nome, nasc, dataNasc);
        ArtistaDAO artistaDAO = new ArtistaDAO();
        artistaDAO.inserir(artista);
    }

    public static void listarArtistas() throws SQLException {
        ArtistaDAO artistaDAO = new ArtistaDAO();
        for(Artista art : artistaDAO.listarTodos()){
            System.out.println(art);
        }
    }

    public static void removerArtista() throws SQLException {
        listarArtistas();
        System.out.print("Digite o codigo do artista que deseja remover: ");
        int cod = Integer.parseInt(sc.nextLine());
        ArtistaDAO dao = new ArtistaDAO();
        dao.remover(cod);
    }

    public static void inserirComprador() throws SQLException {
        System.out.println("Digite o nome do comprador: ");
        String nome = sc.nextLine();
        System.out.println("Digite o pais do comprador: ");
        String pais = sc.nextLine();
        System.out.println("Digite o telefone do comprador: ");
        String telefone = sc.nextLine();
        Comprador comprador = new Comprador(nome, pais, telefone);
        CompradorDAO compradorDAO = new CompradorDAO();
        compradorDAO.inserir(comprador);
    }

    public static void listarCompradores() throws SQLException {
        CompradorDAO compradorDAO = new CompradorDAO();
        for(Comprador comprador : compradorDAO.listarTodos()){
            System.out.println(comprador);
        }
    }

    public static void removerComprador() throws SQLException {
        listarCompradores();
        System.out.print("Digite o codigo do comprador que deseja remover: ");
        int cod = Integer.parseInt(sc.nextLine());
        CompradorDAO dao = new CompradorDAO();
        dao.remover(cod);
    }

    public static void inserirExposicao() throws SQLException {
        System.out.println("Digite o titulo da exposicao: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o tema da exposicao: ");
        String tema = sc.nextLine();
        System.out.println("Digite a data de inicio da exposicao: ");
        Date dataInicio = Date.valueOf(sc.nextLine());
        System.out.println("Digite a data do fim da exposicao: ");
        Date dataFim = Date.valueOf(sc.nextLine());
        Exposicao e = new Exposicao(titulo, tema, dataInicio, dataFim);
        ExposicaoDAO exposicaoDAO = new ExposicaoDAO();
        exposicaoDAO.inserir(e);
    }

    public static void listarExposicoes() throws SQLException {
        ExposicaoDAO exposicaoDAO = new ExposicaoDAO();
        for(Exposicao e : exposicaoDAO.listarTodos()){
            System.out.println(e);
        }
    }

    public static void removerExposicao() throws SQLException {
        listarExposicoes();
        System.out.println("Digite o codigo da exposicao que deseja remover: ");
        int cod = Integer.parseInt(sc.nextLine());
        ExposicaoDAO dao = new ExposicaoDAO();
        dao.remover(cod);
    }

    public static void inserirObra() throws SQLException, IOException {
        System.out.println("Digite o titulo da obra: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o ano em que a obra foi feita: ");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o preco da obra: ");
        double preco = Double.parseDouble(sc.nextLine());

        System.out.println("Digite o caminho da imagem (ou Enter para pular): ");
        String caminho = sc.nextLine();

        byte[] imagem = null;
        if (!caminho.isEmpty()) {
            imagem = Files.readAllBytes(Path.of(caminho));
        }

        Obra o = new  Obra(titulo,ano,preco,imagem);
        ObraDAO obraDAO = new ObraDAO();
        obraDAO.inserir(o);
    }

    public static void listarObras() throws SQLException, IOException {
        ObraDAO obraDAO = new ObraDAO();
        for(Obra o : obraDAO.listarTodos()){
            System.out.println(o);
        }
    }

    public static void removerObra() throws SQLException, IOException {
        listarObras();
        System.out.println("Digite o codigo da obra que deseja remover: ");
        int cod = Integer.parseInt(sc.nextLine());
        ObraDAO obraDAO = new ObraDAO();
        obraDAO.remover(cod);
    }

    public static void inserirRegistro() throws SQLException{
        System.out.println("Digite o codigo do comprador: ");
        int codComprador = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());
        RegistroDAO registroDAO = new RegistroDAO();

        if(registroDAO.obraVendida(codObra)){
            System.out.println("Essa obra ja foi vendida!");
            return;
        }

        System.out.println("Digite o numero do registro: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a data da venda: ");
        Date dataVenda = Date.valueOf(sc.nextLine());
        System.out.println("Digite a forma de pagamento: ");
        String formaPagamento = sc.nextLine();
        System.out.println("Digite qualquer informacao adicional sobre a venda (ou Enter para pular): ");
        String descricao = sc.nextLine();
        System.out.println("Digite o valor da venda: ");
        double valorVenda = Double.parseDouble(sc.nextLine());

        Registro registro = new Registro(codComprador, codObra, num, dataVenda, formaPagamento, descricao, valorVenda);
        registroDAO.inserir(registro);
    }

    public static void listarRegistros() throws SQLException{
        RegistroDAO registroDAO = new RegistroDAO();
        for(Registro registro : registroDAO.listarTodos()){
            System.out.println(registro);
        }
    }

    public static void removerRegistro() throws SQLException{
        listarRegistros();
        System.out.println("Digite o codigo do comprador do registro: ");
        int codComprador = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o codigo da obra do registro: ");
        int codObra = Integer.parseInt(sc.nextLine());
        RegistroDAO registroDAO = new RegistroDAO();
        registroDAO.remover(codComprador, codObra);
    }

    public static void atribuirObra() throws SQLException, IOException {
        listarArtistas();
        System.out.println("Digite o codigo do artista: ");
        int codArtista = Integer.parseInt(sc.nextLine());
        listarObras();
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());
        CriaDAO criaDAO = new CriaDAO();
        criaDAO.inserir(codArtista, codObra);
    }

    public static void listarArtistasObra() throws SQLException, IOException {
        listarObras();
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());
        CriaDAO criaDAO = new CriaDAO();
        criaDAO.listarArtistasPorObra(codObra);
    }

    public static void listarObrasArtista() throws SQLException{
        listarArtistas();
        System.out.println("Digite o codigo do artista: ");
        int codArtista = Integer.parseInt(sc.nextLine());
        CriaDAO criaDAO = new CriaDAO();
        criaDAO.listarObrasPorArtista(codArtista);
    }

    public static void removerAtribuicao() throws SQLException{
        listarArtistas();
        System.out.println("Digite o codigo do artista: ");
        int codArtista = Integer.parseInt(sc.nextLine());
        CriaDAO criaDAO = new CriaDAO();

        criaDAO.listarObrasPorArtista(codArtista);
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());
        criaDAO.remover(codArtista, codObra);
    }

    public static void adicionarObraExposicao() throws SQLException, IOException {
        listarExposicoes();
        System.out.println("Digite o codigo da exposicao: ");
        int codExposicao = Integer.parseInt(sc.nextLine());
        listarObras();
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());

        ParticipaDAO participaDAO = new ParticipaDAO();
        participaDAO.inserir(codExposicao, codObra);
    }

    public static void mostrarExposicoesObra()  throws SQLException, IOException {
        listarObras();
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());

        ParticipaDAO participaDAO = new ParticipaDAO();
        participaDAO.listarExposicoesPorObra(codObra);
    }

    public static void mostrarObrasExposicao()  throws SQLException, IOException {
        listarExposicoes();
        System.out.println("Digite o codigo da exposicao: ");
        int codExposicao = Integer.parseInt(sc.nextLine());

        ParticipaDAO participaDAO = new ParticipaDAO();
        participaDAO.listarObrasPorExposicao(codExposicao);
    }

    public static void removerObraExposicao() throws SQLException, IOException {
        listarExposicoes();
        System.out.println("Digite o codigo da exposicao: ");
        int codExposicao = Integer.parseInt(sc.nextLine());

        ParticipaDAO participaDAO = new ParticipaDAO();
        participaDAO.listarObrasPorExposicao(codExposicao);
        System.out.println("Digite o codigo da obra: ");
        int codObra = Integer.parseInt(sc.nextLine());

        participaDAO.remover(codExposicao, codObra);
    }

    public static void listarArtistasMaisDeUmaObra() throws SQLException {
        ArtistaDAO artistaDAO = new ArtistaDAO();
        artistaDAO.listarArtistasComMaisDeUmaObra();
    }
}
