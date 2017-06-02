package com.masavi.yasearmo.activities.Pedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Productos.ProductosActivity;
import com.masavi.yasearmo.api.ServiceGenerator;
import com.masavi.yasearmo.api.YaSeArmoAPI;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_pedidos_ver_productos)
    public void onClickVerProductos(View view)
    {
        startActivity(new Intent(PedidosActivity.this, ProductosActivity.class));
    }
}
