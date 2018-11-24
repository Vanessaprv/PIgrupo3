
package br.iesb.meuprograma.dados;

import br.iesb.meuprograma.entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CursoDAO implements DAO<Curso> {

  
    @Override
    public void inserir(Curso entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "INSERT INTO curso (tipoCurso, modalidade, denominacao, habilitacao, localOferta, turnos,numVagas,cargaHoraria, regimeLetivo ) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTipoCurso());
            comando.setString(2, entidade.getModalidade());
            comando.setString(3, entidade.getDenominacao());
            comando.setString(4, entidade.getHabilitacao());
            comando.setString(5, entidade.getLocalOferta());
            comando.setString(6, entidade.getTurnos());
            comando.setString(7, entidade.getNumVagas());
            comando.setString(8, entidade.getCargaHoraria());
            comando.setString(9, entidade.getRegimeLetivo());
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao inserir", ex);
        }
        
    }
 

    public void alterar(Curso entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "UPDATE  curso SET tipoCurso=?, modalidade=?, denominacao=?, habilitacao=?, localOferta=?, turnos=?, numVagas=?, cargaHoraria=?, regimeLetivo=? WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
            comando.setString(2, entidade.getTipoCurso());
            comando.setString(3, entidade.getModalidade());
            comando.setString(4, entidade.getDenominacao());
            comando.setString(5, entidade.getHabilitacao());
            comando.setString(6, entidade.getLocalOferta());
            comando.setString(7, entidade.getTurnos());
            comando.setString(8, entidade.getNumVagas());
            comando.setString(9, entidade.getCargaHoraria());
            comando.setString(10, entidade.getRegimeLetivo());
            
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao alterar", ex);
        }
    }

  
    @Override
    public void excluir(Curso entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "DELETE FROM curso WHERE id=? ";
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
    public Curso consultar(int id) throws DadosException {
        Curso curso = new Curso();
        Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  curso WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                curso.setId(resultado.getInt(1));
                curso.setTipoCurso(resultado.getString(2));
                curso.setModalidade(resultado.getString(3));
                curso.setDenominacao(resultado.getString(4));
                curso.setHabilitacao(resultado.getString(5));
                curso.setLocalOferta(resultado.getString(6));
                curso.setTurnos(resultado.getString(7));
                curso.setNumVagas(resultado.getString(8));
                curso.setCargaHoraria(resultado.getString(9));
                curso.setRegimeLetivo(resultado.getString(10));
            }
            conexao.close();
            return curso;
            
          } catch (SQLException ex){
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Curso> listar() throws DadosException {
       List<Curso> lista = new ArrayList<>();
       Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  curso ";
        try{
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                Curso curso = new Curso();
                curso.setId(resultado.getInt(1));
                curso.setTipoCurso(resultado.getString(2));
                curso.setModalidade(resultado.getString(3));
                curso.setDenominacao(resultado.getString(4));
                curso.setHabilitacao(resultado.getString(5));
                curso.setLocalOferta(resultado.getString(6));
                curso.setTurnos(resultado.getString(7));
                curso.setNumVagas(resultado.getString(8));
                curso.setCargaHoraria(resultado.getString(9));
                curso.setRegimeLetivo(resultado.getString(10));
                lista.add(curso);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex){
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}

    

