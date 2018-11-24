
package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.DadosException;
import br.iesb.meuprograma.dados.DisciplinaDAO;
import br.iesb.meuprograma.entidades.Disciplina;
import java.util.List;

public class DisciplinaBO implements BO<Disciplina> {

    @Override
    public void validar(Disciplina entidade) throws NegocioException {
        if (entidade.getNomeDisciplina().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Nome da Disciplina");
        }
        if (entidade.getDescricao().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Descrição da Disciplina");
        }
        if (entidade.getCodDisciplina().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Código da Disciplina");
        }
        if (entidade.getSemestre().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Semestre");
        }
        if (entidade.getChDisciplina().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Carga Horária");
        }
    }

    @Override
    public void inserir(Disciplina entidade) throws NegocioException {
        validar(entidade);
        DisciplinaDAO dao= new DisciplinaDAO ();
        try{
            dao.inserir(entidade);
        } 
        catch(DadosException ex){
        throw new NegocioException ( "Erro ao inserir disciplina");
        }
    }

    @Override
    public void alterar(Disciplina entidade) throws NegocioException {
       validar(entidade);
        consultar(entidade.getId());
        DisciplinaDAO dao= new DisciplinaDAO ();
        try{
            dao.alterar(entidade);
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao alterar disciplina");
        }
    }

    @Override
    public void excluir(Disciplina entidade) throws NegocioException {
        consultar (entidade.getId());
         DisciplinaDAO dao= new DisciplinaDAO ();
        try{
            dao.excluir(entidade);
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao excluir disciplina");
        }
    }

    @Override
    public Disciplina consultar(int id) throws NegocioException {
     DisciplinaDAO dao= new DisciplinaDAO ();
        try{
            Disciplina disciplina = dao.consultar(id);
            if(disciplina.getId()==0){
                throw new NegocioException ( "Disciplina não encontrada");
        }
            return disciplina;   
                
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao consultar disciplina", ex);
        }
        
    }
    @Override
    public List<Disciplina> listar() throws NegocioException {
      DisciplinaDAO dao= new DisciplinaDAO ();
        try{
            List<Disciplina> lista = dao.listar();
            if (lista.isEmpty()){
                 throw new NegocioException ( "Nenhuma disciplina cadastrada");
            }
            return lista;
        } catch(DadosException ex){
        throw new NegocioException ( "Erro ao consultar disciplina", ex);
            }
       
    }
    
}
