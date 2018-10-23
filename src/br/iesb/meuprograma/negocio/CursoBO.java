
package br.iesb.meuprograma.negocio;

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
         if (entidade.getNomeCoord().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Nome do Coordenador");
        }
          if (entidade.getCpf().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: CPF do Coordenador");
        }
          if (entidade.getCpf().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: CPF do Coordenador");
        }
          if (entidade.getTitulacao().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Titulação do Coordenador");
        }
         if (entidade.getTempoDedicacao().isEmpty ()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Tempo de Dedicação do Coordenador");
        }
    }

    @Override
    public void inserir(Curso entidade) throws NegocioException {
          validar (entidade);
    }

    @Override
    public void alterar(Curso entidade) throws NegocioException {
       validar (entidade);
       consultar (entidade.getId());
    }

    @Override
    public void excluir(Curso entidade) throws NegocioException {
        consultar (entidade.getId());
    }

    @Override
    public Curso consultar(int id) throws NegocioException {
         return new Curso();
}

    @Override
    public List<Curso> listar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
