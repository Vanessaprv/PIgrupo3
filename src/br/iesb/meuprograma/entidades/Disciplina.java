
package br.iesb.meuprograma.entidades;

public class Disciplina {
    private int id;
    private String nomeDisciplina;
    private String descricao;
    private String codDisciplina;
    private String semestre;
    private String chDisciplina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getChDisciplina() {
        return chDisciplina;
    }

    public void setChDisciplina(String chDisciplina) {
        this.chDisciplina = chDisciplina;
    }
    
    
}
