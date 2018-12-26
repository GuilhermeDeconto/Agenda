package com.example.guilhermedeconto.agenda;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListStudentsActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        String[] alunos = {"Daniel", "Guilherme","Felipe", "Jose", "Vitor", "Qual foi", "Marcelinho","Daniel" ,"Guilherme","Felipe", "Jose", "Vitor", "Qual foi", "Marcelinho"};

        listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alunos);
        listView.setAdapter(adapter);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListStudentsActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });


    }
}
