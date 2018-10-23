
package br.iesb.meuprograma.negocio;

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
         validar (entidade);
    }

    @Override
    public void alterar(Disciplina entidade) throws NegocioException {
         validar (entidade);
       consultar (entidade.getId());
    }

    @Override
    public void excluir(Disciplina entidade) throws NegocioException {
        consultar (entidade.getId());
    }

    @Override
    public Disciplina consultar(int id) throws NegocioException {
        return new Disciplina();
    }

    @Override
    public List<Disciplina> listar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
