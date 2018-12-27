package com.example.guilhermedeconto.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.guilhermedeconto.agenda.model.Aluno;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 27/12/2018
 **/
public class FormHelper {
    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;

    private Aluno aluno;

    public FormHelper(FormActivity activity){
        campoNome =  activity.findViewById(R.id.editNome);
        campoEndereco =  activity.findViewById(R.id.edEndereco);
        campoTelefone =  activity.findViewById(R.id.editTelefone);
        campoSite =  activity.findViewById(R.id.edSite);
        campoNota =  activity.findViewById(R.id.ratingBar);
        aluno = new Aluno();
    }

    public Aluno pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }
}
