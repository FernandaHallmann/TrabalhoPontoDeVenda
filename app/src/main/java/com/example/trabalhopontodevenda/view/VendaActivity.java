package com.example.trabalhopontodevenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trabalhopontodevenda.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class VendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
    }

    public void voltarMenu(View view) {
        Intent intent = new Intent(VendaActivity.this, MainActivity.class);

        startActivity(intent);
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