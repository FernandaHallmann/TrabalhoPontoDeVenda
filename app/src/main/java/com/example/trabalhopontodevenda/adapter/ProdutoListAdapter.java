package com.example.trabalhopontodevenda.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trabalhopontodevenda.model.Produto;
import com.example.trabalhopontodevenda.R;

import java.util.ArrayList;

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ViewHolder>{

private ArrayList<Produto> listaProdutos;
private Context context;

/**
 * Construtor da classe
 *
 * @param listaProdutos: lista que será utilizado para retornar os dados a serem exibidos
 * @param context: onde será exibido a lista
 */
public ProdutoListAdapter(ArrayList<Produto> listaProdutos,Context context){
        this.listaProdutos=listaProdutos;
        this.context=context;
        }

/**
 * @param parent The ViewGroup into which the new View will be added after it is bound to
 *               an adapter position.
 * @param viewType The view type of the new View.
 * @return o arquivo xml com seus componentes
 */
@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View listItem=inflater.inflate(R.layout.item_list_produto,
        parent,false);

        return new ViewHolder(listItem);
        }

    /**
 * Método que adiciona os dados de Aluno na tela
 * @param holder The ViewHolder which should be updated to represent the contents of the
 *        item at the given position in the data set.
 * @param position The position of the item within the adapter's data set.
 */
@Override
public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        Produto produtoSelecionado=listaProdutos.get(position);
        holder.tvCodigoProduto.setText(String.valueOf(produtoSelecionado.getCodigo()));
        holder.tvDescricaoProduto.setText(produtoSelecionado.getDescricao());
        holder.tvPrecoProduto.setText(String.valueOf(produtoSelecionado.getQuantidade()));
        holder.tvQuantidadeProduto.setText(String.valueOf(produtoSelecionado.getPreco()));
        }

/**
 * Retorna a quantidade de elementos contidos na lista
 * @return
 */
@Override
public int getItemCount(){
        return this.listaProdutos.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView tvCodigoProduto;
    public TextView tvDescricaoProduto;
    public TextView tvPrecoProduto;
    public TextView tvQuantidadeProduto;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.tvCodigoProduto = itemView.findViewById(R.id.tvCodigoProduto);
        this.tvDescricaoProduto = itemView.findViewById(R.id.tvDescricaoProduto);
        this.tvPrecoProduto = itemView.findViewById(R.id.tvPrecoProduto);
        this.tvQuantidadeProduto = itemView.findViewById(R.id.tvQuantidadeProduto);
        }
    }
}

