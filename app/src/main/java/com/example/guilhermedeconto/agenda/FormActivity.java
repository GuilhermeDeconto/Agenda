package com.example.guilhermedeconto.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilhermedeconto.agenda.dao.AlunoDAO;
import com.example.guilhermedeconto.agenda.model.Aluno;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {
    private EditText etnome;
    private EditText etEndereço;
    private EditText etTelefone;
    private EditText etSite;
    private FormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        helper = new FormHelper(this);
        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("Aluno");
        if(aluno !=null){
            helper.preencheFormulario(aluno);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario:
                Aluno aluno = helper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);
                dao.insere(aluno);
                dao.close();
                Toast.makeText(FormActivity.this, "Aluno" + aluno.getNome() + "salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

