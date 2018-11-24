
package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.CursoDAO;
import br.iesb.meuprograma.dados.DadosException;
import br.iesb.meuprograma.entidades.Curso;
import java.util.List;

public class CursoBO implements BO<Curso> {

    @Override
    public void validar(Curso entidade) throws NegocioException {
       if (entidade.getTipoCurso().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Tipo de Curso");
        }
       if (entidade.getModalidade().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Modalidade");
        }
       if (entidade.getDenominacao().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Denominação do Curso");
        }
        if (entidade.getHabilitacao().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Habilitação");
        } 
        if (entidade.getLocalOferta().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Local de Oferta");
        } 
        if (entidade.getTurnos().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Turnos de Funcionamento");
        } 
        if (entidade.getNumVagas().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Número de Vagas para cada Turno");
        } 
        if (entidade.getCargaHoraria().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Carga Horária do Curso");
        } 
         if (entidade.getRegimeLetivo().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Regime Letivo");
        }
          if (entidade.getPeriodos().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Períodos");
        }
       
        
    }

    @Override
    public void inserir(Curso entidade) throws NegocioException {
         validar(entidade);
        CursoDAO dao= new CursoDAO ();
        try{
            dao.inserir(entidade);
        } 
        catch(DadosException ex){
        throw new NegocioException ( "Erro ao inserir Curso");
        }
    }
    @Override
    public void alterar(Curso entidade) throws NegocioException {
       validar(entidade);
        consultar(entidade.getId());
        CursoDAO dao= new CursoDAO ();
        try{
            dao.alterar(entidade);
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao alterar Curso");
        }
    }

    @Override
    public void excluir(Curso entidade) throws NegocioException {
       consultar (entidade.getId());
         CursoDAO dao= new CursoDAO ();
        try{
            dao.excluir(entidade);
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao excluir Curso");
        }
    }
    @Override
    public Curso consultar(int id) throws NegocioException {
      CursoDAO dao= new CursoDAO ();
        try{
            Curso curso = dao.consultar(id);
            if(curso.getId()==0){
                throw new NegocioException ( "Curso não encontrado");
        }
            return curso;   
                
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao consultar curso", ex);
        }
        
    }

    @Override
    public List<Curso> listar() throws NegocioException {
      CursoDAO dao= new CursoDAO ();
        try{
            List<Curso> lista = dao.listar();
            if (lista.isEmpty()){
                 throw new NegocioException ( "Nenhum curso cadastrado");
            }
            return lista;
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao consultar curso", ex);
            }
       
    }
    
}
