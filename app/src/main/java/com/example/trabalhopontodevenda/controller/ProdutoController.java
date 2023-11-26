package com.example.trabalhopontodevenda.controller;

import java.util.ArrayList;

public class ProdutoController {

    public String adicionarProduto(Integer codigo, String descricao, double preco, int quantidade){
        try{
            if(codigo == null){
                return "Informe o código do Produto!";
            }
            if(descricao.equals("") || descricao.isEmpty()){
                return "Informe a descrição do Produto!";
            }
            if(preco.equals("") || preco.isEmpty()){
                return "Informe o preço do Produto!";
            }
            if(quantidade.equals("") || quantidade.isEmpty()){
                return "Informe a quantidade do Produto!";
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
