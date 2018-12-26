package com.example.guilhermedeconto.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormActivity.this,"Aluno salvo",Toast.LENGTH_SHORT).show();
                finish();
//                Intent intent = new Intent(FormActivity.this, ListStudentsActivity.class);
//                startActivity(intent);
            }
        });


    private void onCreateOptionsMenu(Menu menu) {

        }
    }
}
