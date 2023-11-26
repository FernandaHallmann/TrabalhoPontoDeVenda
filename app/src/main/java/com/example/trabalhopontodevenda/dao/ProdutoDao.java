package com.example.trabalhopontodevenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabalhopontodevenda.helper.SQLiteDataHelper;
import com.example.trabalhopontodevenda.model.Produto;
import com.example.trabalhopontodevenda.model.Vendedor;

import java.util.ArrayList;

public class ProdutoDao implements IGenericDao<Produto> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[]colunas = {"CODIGO", "DESCRICAO", "PRECO"};
    private String tabela = "PRODUTO";
    private Context context;
    private static ProdutoDao instancia;

    public static ProdutoDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new ProdutoDao(context);
        }else{
            return instancia;
        }
    }

    private ProdutoDao(Context context){
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "PDV", null, 1);

        baseDados = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Produto obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            valores.put(colunas[2], obj.getPreco());

            return baseDados.insert(tabela, null, valores);

        }catch (SQLException ex){
            Log.e("PDV", "ERRO: ProdutoDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Produto obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());

            String[]identificador = {String.valueOf(obj.getCodigo())};

            return baseDados.update(tabela,  valores, colunas[0]+"= ?", identificador);

        }catch (SQLException ex){
            Log.e("PDV", "ERRO: ProdutoDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Produto obj) {
        try{
            String[]identificador = {String.valueOf(obj.getCodigo())};

            return baseDados.delete(tabela, colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("PDV", "ERRO: ProdutoDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Produto produto = new Produto();
                    produto.setCodigo(Integer.parseInt(cursor.getString(0)));
                    produto.setDescricao(cursor.getString(1));
                    produto.setPreco(Double.parseDouble(cursor.getString(2)));

                    lista.add(produto);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("PDV", "ERRO: ProdutoDao.getAll() "+ex.getMessage());
        }

        return lista;
    }

    public Produto getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(cursor.getString(0)));
                produto.setDescricao(cursor.getString(1));
                produto.setPreco(Double.parseDouble(cursor.getString(2)));
                return produto;
            }

        }catch (SQLException ex){
            Log.e("PDV", "ERRO: ProdutoDao.getById() "+ex.getMessage());
        }
        return null;
    }

    @Override
    public Produto getById(String id) {return null;}
}
