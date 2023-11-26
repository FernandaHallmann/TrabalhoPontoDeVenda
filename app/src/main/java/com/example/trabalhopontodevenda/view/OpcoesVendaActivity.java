package com.example.trabalhopontodevenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trabalhopontodevenda.R;

public class OpcoesVendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_venda);
    }


    public void abrirGerenciamentoVenda(View view) {
        Intent intent = new Intent(OpcoesVendaActivity.this, VendaActivity.class);

        startActivity(intent);

    }

    public void abrirReceberPagamento(View view) {
        Intent intent = new Intent(OpcoesVendaActivity.this, PagamentoActivity.class);

        startActivity(intent);

    }

    public void abrirResumoVenda(View view) {
        Intent intent = new Intent(OpcoesVendaActivity.this, NotaFiscalActivity.class);

        startActivity(intent);

    }

    public void abrirRelatorio(View view) {
        Intent intent = new Intent(OpcoesVendaActivity.this, RelatoriosActivity.class);

        startActivity(intent);

    }
}