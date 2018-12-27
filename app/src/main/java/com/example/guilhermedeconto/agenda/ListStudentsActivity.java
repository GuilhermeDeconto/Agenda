package com.example.guilhermedeconto.agenda;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.guilhermedeconto.agenda.dao.AlunoDAO;
import com.example.guilhermedeconto.agenda.model.Aluno;

import java.util.List;


public class ListStudentsActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        listView = findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno = (Aluno) listView.getItemAtPosition(position);
                Intent intent = new Intent(ListStudentsActivity.this, FormActivity.class);
                intent.putExtra("Aluno", aluno);
                startActivity(intent);
            }
        });

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListStudentsActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listView);

    }

    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Aluno aluno = (Aluno) listView.getItemAtPosition(info.position);
        String site = aluno.getSite();
        if(!site.startsWith("http://")){
            site = "http://" + site;
        }

        MenuItem visitarSite = menu.add("Visitar site");
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        intentSite.setData(Uri.parse(site));
        visitarSite.setIntent(intentSite);


//        visitarSite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
////                Intent intentSite = new Intent(ListStudentsActivity.this,Browser.class);
////                startActivity(intentSite);
//                return false;
//            }
//        }
        MenuItem deltar = menu.add("Deletar");
        deltar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ListStudentsActivity.this, "Deletar o aluno " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                AlunoDAO dao = new AlunoDAO(ListStudentsActivity.this);
                dao.deleta(aluno);
                dao.close();
                carregaLista();
                return false;
            }
        });
    }
}
