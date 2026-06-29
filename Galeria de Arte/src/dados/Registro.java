package dados;

import java.sql.Date;

public class Registro {
    private int codComprador;
    private int codObra;
    private int numRegistro;
    private Date dtVenda;
    private String formaPgto;
    private String descricao;
    private double precoFinal;

    public int getCodComprador() {
        return codComprador;
    }

    public void setCodComprador(int codComprador) {
        this.codComprador = codComprador;
    }

    public int getCodObra() {
        return codObra;
    }

    public void setCodObra(int codObra) {
        this.codObra = codObra;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String toString(){
        String s = "";
        s += "Codigo do comprador: " + codComprador + "\n";
        s += "Codigo da obra: " + codObra + "\n";
        s += "Numero do registro: " + numRegistro + "\n";
        s += "Data da venda: " + dtVenda + "\n";
        s += "Forma de pagamento: " + formaPgto + "\n";
        s += "Descricao da venda: " + descricao + "\n";
        s += "Preco final: " + precoFinal + "\n";
        return s;
    }

    public Registro(){ }

    public Registro(int codComprador, int codObra, int numRegistro, Date dtVenda, String formaPgto, String descricao, double precoFinal){
        this.codComprador = codComprador;
        this.codObra = codObra;
        this.numRegistro = numRegistro;
        this.dtVenda = dtVenda;
        this.formaPgto = formaPgto;
        this.descricao = descricao;
        this.precoFinal = precoFinal;
    }
}
