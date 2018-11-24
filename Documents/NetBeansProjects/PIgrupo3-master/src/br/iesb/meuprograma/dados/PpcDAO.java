
package br.iesb.meuprograma.dados;

import br.iesb.meuprograma.entidades.PPC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PpcDAO implements DAO<PPC> {

    @Override
    public void inserir(PPC entidade) throws DadosException {
       Connection conexao= ConexaoBD.getConexao();
        String sql= "INSERT INTO ppc (curso, perfilcurso, perfilegresso, acesso, graficoperfil,	avalaprendiz, avalcurso, tcc, estagio, politicamob ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getCurso());
            comando.setString(2, entidade.getPerfilCurso());
            comando.setString(3, entidade.getPerfilEgresso());
            comando.setString(4, entidade.getAcessoCurso());
            comando.setString(5, entidade.getGraficaPerfil());
            comando.setString(6, entidade.getAvalAprendizagem());
            comando.setString(7, entidade.getAvalProjCurso());
            comando.setString(8, entidade.getTcc());
            comando.setString(9, entidade.getEstagioCurric());
            comando.setString(10, entidade.getPoliticaDefic());
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao inserir", ex);
        }
        
    }
 

    @Override
    public void alterar(PPC entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "UPDATE  ppc SET curso=?, perfilcurso=?, perfilegresso=?, acesso=?, graficoperfil=?, avalaprendiz=?, avalcurso=?, tcc=?, estagio=?, politicamob=?  WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId());
           comando.setString(2, entidade.getCurso());
            comando.setString(3, entidade.getPerfilCurso());
            comando.setString(4, entidade.getPerfilEgresso());
            comando.setString(5, entidade.getAcessoCurso());
            comando.setString(6, entidade.getGraficaPerfil());
            comando.setString(7, entidade.getAvalAprendizagem());
            comando.setString(8, entidade.getAvalProjCurso());
            comando.setString(9, entidade.getTcc());
            comando.setString(10, entidade.getEstagioCurric());
            comando.setString(11, entidade.getPoliticaDefic());
            
            comando.execute();
            conexao.close();
        } catch (SQLException ex){
            throw new DadosException("Erro ao alterar", ex);
        }
    }

    @Override
    public void excluir(PPC entidade) throws DadosException {
        Connection conexao= ConexaoBD.getConexao();
        String sql= "DELETE FROM ppc WHERE id=? ";
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
    public PPC consultar(int id) throws DadosException {
       PPC ppc = new PPC();
        Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  ppc WHERE id=? ";
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                ppc.setId(resultado.getInt(1));
                ppc.setCurso(resultado.getString(2));
                ppc.setPerfilCurso(resultado.getString(3));
                ppc.setPerfilEgresso(resultado.getString(4));
                ppc.setAcessoCurso(resultado.getString(5));
                ppc.setGraficaPerfil(resultado.getString(6));
                ppc.setAvalAprendizagem(resultado.getString(7));
                ppc.setAvalProjCurso(resultado.getString(8));
                ppc.setTcc(resultado.getString(9));
                ppc.setEstagioCurric(resultado.getString(10));
                ppc.setPoliticaDefic(resultado.getString(11));
            }
            conexao.close();
            return ppc;
            
          } catch (SQLException ex){
            throw new DadosException("Erro ao consultar", ex);
        }
    }


    @Override
    public List<PPC> listar() throws DadosException {
       List<PPC> lista = new ArrayList<>();
       Connection conexao= ConexaoBD.getConexao();
        String sql= "SELECT* FROM  ppc ";
        try{
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                PPC ppc = new PPC();
                ppc.setId(resultado.getInt(1));
                ppc.setCurso(resultado.getString(2));
                ppc.setPerfilCurso(resultado.getString(3));
                ppc.setPerfilEgresso(resultado.getString(4));
                ppc.setAcessoCurso(resultado.getString(5));
                ppc.setGraficaPerfil(resultado.getString(6));
                ppc.setAvalAprendizagem(resultado.getString(7));
                ppc.setAvalProjCurso(resultado.getString(8));
                ppc.setTcc(resultado.getString(9));
                ppc.setEstagioCurric(resultado.getString(10));
                ppc.setPoliticaDefic(resultado.getString(11));
                lista.add(ppc);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex){
            throw new DadosException("Erro ao listar", ex);
        }
    }
   
}