package com.masavi.yasearmo.activities.Carrito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.MainMenuActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.carrito_btn_main_menu)
    public void onClickMainMenu(View view)
    {
        startActivity(new Intent(CarritoActivity.this, MainMenuActivity.class));
    }

}
