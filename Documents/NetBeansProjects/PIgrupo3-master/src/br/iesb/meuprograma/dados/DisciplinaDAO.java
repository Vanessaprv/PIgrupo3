
package br.iesb.meuprograma.dados;

import br.iesb.meuprograma.entidades.Disciplina;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DisciplinaDAO implements DAO<Disciplina> {

    @Override
    public void inserir(Disciplina entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "INSERT INTO DISCIPLINA (nomeDisciplina, descricao, codDisciplina, semestre, chDisciplina) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getNomeDisciplina());
            comando.setString(2, entidade.getDescricao());
            comando.setString(3, entidade.getCodDisciplina());
            comando.setString(4, entidade.getSemestre());
            comando.setString(5, entidade.getChDisciplina());
            
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao inserir", ex);
        }
    }

    @Override
    public void alterar(Disciplina entidade) throws DadosException {
       Connection conexao= ConexaoBD.getConexao();
        String sql= "UPDATE  DISCIPLINA SET nomeDisciplina=?, descricao=?, codDisciplina=?, semestre=?, chDisciplina=? WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.setString(2, entidade.getNomeDisciplina());
            comando.setString(3, entidade.getDescricao());
            comando.setString(4, entidade.getCodDisciplina());
            comando.setString(5, entidade.getSemestre());
            comando.setString(6, entidade.getChDisciplina());
            
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao alterar", ex);
        }
    }

    @Override
    public void excluir(Disciplina entidade) throws DadosException {
         Connection conexao= ConexaoBD.getConexao();
        String sql= "DELETE FROM DISCIPLINA WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao excluir", ex);
        }
       
    }

    @Override
    public Disciplina consultar(int id) throws DadosException {
        Disciplina disciplina = new Disciplina();
        Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  DISCIPLINA WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                disciplina.setId(resultado.getInt(1));
                disciplina.setNomeDisciplina(resultado.getString(2));
                disciplina.setDescricao(resultado.getString(3));
                disciplina.setCodDisciplina(resultado.getString(4));
                disciplina.setSemestre(resultado.getString(5));
                disciplina.setChDisciplina(resultado.getString(6));
                
            }
            conexao.close();
            return disciplina;
        } catch (SQLException ex){
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Disciplina> listar() throws DadosException {
        List<Disciplina> lista = new ArrayList<>();
       Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  DISCIPLINA ";
        try{
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(resultado.getInt(1));
                disciplina.setNomeDisciplina(resultado.getString(2));
                disciplina.setDescricao(resultado.getString(3));
                disciplina.setCodDisciplina(resultado.getString(4));
                disciplina.setSemestre(resultado.getString(5));
                disciplina.setChDisciplina(resultado.getString(6));
                lista.add(disciplina);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex){
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
