/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.entidades.PPC;
import java.util.List;

public class PpcBO implements BO<PPC> {

    @Override
    public void validar(PPC entidade) throws NegocioException {
       if (entidade.getPerfilCurso().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Perfil Curso");
        }
        if (entidade.getPerfilEgresso().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Perfil do Egresso");
        }
        if (entidade.getAcessoCurso().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Forma de Acesso ao Curso");
        }
        if (entidade.getGraficaPerfil().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Representação Gráfica de um Perfil de Formação ");
        }
        if (entidade.getAvalAprendizagem().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Sistema de Avaliação do Processo Ensino Aprendizagem");
        }
        if (entidade.getAvalProjCurso().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Sistema de Avaliação do Projeto de Curso");
        }
        if (entidade.getTcc().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Trabalho de Conclusão de Curso");
        }
         if (entidade.getEstagioCurric().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Estágio Curricular");
        }
         if (entidade.getPoliticaDefic().isEmpty()){
       throw new NegocioException("Todos os campos devem ser preenchidos. Verifique o campo: Política de Atendimento a Pessoa com Deficiência e/ou Mobilidade reduzida");
        }
    }

    @Override
    public void inserir(PPC entidade) throws NegocioException {
         validar (entidade);
    }

    @Override
    public void alterar(PPC entidade) throws NegocioException {
        validar (entidade);
       consultar (entidade.getId());
    }

    @Override
    public void excluir(PPC entidade) throws NegocioException {
         consultar (entidade.getId());
    }

    @Override
    public PPC consultar(int id) throws NegocioException {
        return new PPC();
    }

    @Override
    public List<PPC> listar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
