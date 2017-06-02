package com.masavi.yasearmo.activities.Pedidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.api.ServiceGenerator;
import com.masavi.yasearmo.api.YaSeArmoAPI;

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
    }
}
