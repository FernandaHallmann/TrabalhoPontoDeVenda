package com.example.trabalhopontodevenda.controller;

import java.util.ArrayList;

public class ProdutoController {

    public String adicionarProduto(String ra, String nome){
        try{
            if(ra.equals("") || ra.isEmpty()){
                return "Informe o RA do Aluno!";
            }
            if(nome.equals("") || nome.isEmpty()){
                return "Informe o NOME do Aluno!";
            }

            Aluno aluno = AlunoDao.getInstancia(context)
                    .getById(Integer.parseInt(ra));
            if(aluno != null){
                return "O RA ("+ra+") já está cadastrado!";
            }else{
                aluno = new Aluno();
                aluno.setRa(Integer.parseInt(ra));
                aluno.setNome(nome);

                AlunoDao.getInstancia(context).insert(aluno);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Aluno.";
        }
        return null;
    }

    /**
     * Retorna todos os alunos cadastrados no banco
     * @return
     */
    public ArrayList<Aluno> retornarTodosAlunos(){
        return AlunoDao.getInstancia(context).getAll();
    }

}
