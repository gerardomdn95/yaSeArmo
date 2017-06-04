package com.masavi.yasearmo.activities.Armala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.masavi.yasearmo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManejarArmalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejar_armala);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.armala_crear_evento)
    public void onClickCrearEvento(View view)
    {
        startActivity(new Intent(ManejarArmalaActivity.this, ArmalaActivity.class));
    }

    @OnClick(R.id.armala_consultar_evento)
    public void onClickConsultarInvitaciones(View view)
    {
        startActivity(new Intent(ManejarArmalaActivity.this, ConsultarInvitacionesActivity.class));
    }

    @OnClick(R.id.armala_consultar_historial)
    public void onClickConsultarHistorial(View view)
    {
        startActivity(new Intent(ManejarArmalaActivity.this, ConsultarHistorialActivity.class));
    }
}
