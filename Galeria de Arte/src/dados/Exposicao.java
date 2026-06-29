package dados;

import java.sql.Date;

public class Exposicao {
    private int codExposicao;
    private String titulo;
    private String tema;
    private Date dtInicio;
    private Date dtFim;

    public int getCodExposicao() {
        return codExposicao;
    }

    public void setCodExposicao(int codExposicao) {
        this.codExposicao = codExposicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Exposicao(){ }

    public Exposicao(String titulo, String tema, Date dtInicio, Date dtFim){
        this.titulo = titulo;
        this.tema = tema;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public String toString(){
        String s = "";
        s += "Titulo: " + this.titulo + "\n";
        s += "Tema: " + this.tema + "\n";
        s += "Data de Inicio: " + this.dtInicio + "\n";
        s += "Data de Fim: " + this.dtFim + "\n";
        s += "Codigo: " + this.codExposicao + "\n";
        return s;
    }
}
