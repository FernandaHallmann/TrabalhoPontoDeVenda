package com.example.trabalhopontodevenda.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.trabalhopontodevenda.R;
import com.example.trabalhopontodevenda.adapter.ProdutoListAdapter;
import com.example.trabalhopontodevenda.controller.ProdutoController;
import com.example.trabalhopontodevenda.model.Produto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class VendaActivity extends AppCompatActivity {
    private ImageButton btAddProdutoVenda;
    private AlertDialog dialog;
    private ProdutoController controller;
    private EditText edCodigoTelaVenda;
    private EditText edDescricaoTelaVenda;
    private EditText edPrecoTelaVenda;
    private EditText edQuantidadeTelaVenda;
    private RecyclerView rvProdutosVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);

        controller = new ProdutoController(this);
        rvProdutosVenda = findViewById(R.id.rvProdutosVenda);
        btAddProdutoVenda = findViewById(R.id.btAddProdutoVenda);
        edCodigoTelaVenda = findViewById(R.id.edCodigoTelaVenda);
        edDescricaoTelaVenda = findViewById(R.id.edDescricaoTelaVenda);
        edPrecoTelaVenda = findViewById(R.id.edPrecoTelaVenda);
        edQuantidadeTelaVenda = findViewById(R.id.edQuantidadeTelaVenda);
        btAddProdutoVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDados();
            }
        });

        atualizarListaProduto();
    }

    public void salvarDados(){
        String retorno = controller.adicionarProduto(edCodigoTelaVenda.getText().toString(), edDescricaoTelaVenda.getText().toString(), edPrecoTelaVenda.getText().toString(), edQuantidadeTelaVenda.getText().toString());
        if(retorno != null){
            if(retorno.contains("Código")){
                edCodigoTelaVenda.setError(retorno);
                edCodigoTelaVenda.requestFocus();
            }
            if(retorno.contains("Descrição")){
                edDescricaoTelaVenda.setError(retorno);
                edDescricaoTelaVenda.requestFocus();
            }
            if(retorno.contains("Preço")){
                edPrecoTelaVenda.setError(retorno);
                edPrecoTelaVenda.requestFocus();
            }
            if(retorno.contains("Quantidade")){
                edQuantidadeTelaVenda.setError(retorno);
                edQuantidadeTelaVenda.requestFocus();
            }
        }else{
            Toast.makeText(this, "Produto adicionado com sucesso!", Toast.LENGTH_LONG).show();
            atualizarListaProduto();
        }
    }

    private void atualizarListaProduto(){
        ArrayList<Produto> listaProdutos = controller.retornarTodosProdutos();
        ProdutoListAdapter adapter = new ProdutoListAdapter(listaProdutos, this);
        rvProdutosVenda.setLayoutManager(new LinearLayoutManager(this));
        rvProdutosVenda.setAdapter(adapter);
    }

    private String gerarNumeroPedido() {
        String prefixo = "PED";
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyyMMdd");
        String dataAtual = formatoData.format(new Date());
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100000); // Número aleatório de 0 a 99999

        String numeroFormatado = String.format("%05d", numeroAleatorio);

        return prefixo + dataAtual + "-" + numeroFormatado;
    }
}