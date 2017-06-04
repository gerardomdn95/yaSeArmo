package com.masavi.yasearmo.activities.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.masavi.yasearmo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CrearCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.link_crear_login)
    public void OnClickLogin(View view){
        startActivity(new Intent(CrearCuentaActivity.this, LoginActivity.class));
    }
}
