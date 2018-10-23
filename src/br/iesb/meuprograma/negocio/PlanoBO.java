
package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.entidades.PlanoEnsino;
import java.util.List;

public class PlanoBO implements BO<PlanoEnsino> {

    @Override
    public void validar(PlanoEnsino entidade) throws NegocioException {
        if (entidade.getCurso().isEmpty ()){
       throw new NegocioException("O campo Curso é obrigatório");
        }
        if (entidade.getAno().isEmpty ()){
       throw new NegocioException("O campo Ano é obrigatório");
        }
        if (entidade.getSemestre().isEmpty ()){
       throw new NegocioException("O campo Semestre é obrigatório");
        }
        if (entidade.getEmenta().isEmpty ()){
       throw new NegocioException("O campo Ementa é obrigatório");
        }
        if (entidade.getCompetencias().isEmpty ()){
       throw new NegocioException("O campo Competências e Habilidades é obrigatório");
        }
        if (entidade.getMetodologia().isEmpty ()){
       throw new NegocioException("O campo Metodologia de Ensino é obrigatório");
        }
        if (entidade.getAvaliacao().isEmpty ()){
       throw new NegocioException("O campo Avaliação é obrigatório");
        }
        if (entidade.getBibliografia().isEmpty ()){
       throw new NegocioException("O campo Bibliografia é obrigatório");
        }
    }

    @Override
    public void inserir(PlanoEnsino entidade) throws NegocioException {
        validar (entidade);
    }

    @Override
    public void alterar(PlanoEnsino entidade) throws NegocioException {
        validar (entidade);
        consultar (entidade.getId());
    }

    @Override
    public void excluir(PlanoEnsino entidade) throws NegocioException {
         consultar (entidade.getId());
    }

    @Override
    public PlanoEnsino consultar(int id) throws NegocioException {
         return new PlanoEnsino();
    }

    @Override
    public List<PlanoEnsino> listar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
