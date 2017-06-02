package com.masavi.yasearmo.activities.Productos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.adapters.ItemAdapter;
import com.masavi.yasearmo.api.ServiceGenerator;
import com.masavi.yasearmo.api.YaSeArmoAPI;
import com.masavi.yasearmo.models.Item;
import com.masavi.yasearmo.models.Producto;
import com.masavi.yasearmo.models.ProductoObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosActivity extends AppCompatActivity
{
    @BindView(R.id.recycler_productos)
    RecyclerView recyclerView;

    List<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_productos);

        yaSeArmoAPIConnection();
    }

    public void yaSeArmoAPIConnection ()
    {
        YaSeArmoAPI yaSeArmoApi = ServiceGenerator.createService();

        yaSeArmoApi.buscarEventos().enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response)
            {
                List<Producto> productos = response.body();
                Log.e("myLog", "Guardado en lista el cuerpo de la respuesta");

                for (int i = 1; i < productos.size() -1; i++)
                {
                    Log.e("myLog", "Poblando items...");
                    mItems.add(new Item(
                            productos.get(i).getNombre(),
                            productos.get(i).getImagen(),
                            productos.get(i).getDescripcion(),
                            productos.get(i).getCategoria(),
                            (int) productos.get(i).getRating()));
                }

                settingRecyclerView();

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t)
            {
                Log.e("myLog", "Valió barriga");
            }
        });

    }


    private void settingRecyclerView()
    {
        ItemAdapter itemAdapter = new ItemAdapter(mItems);

        //LayoutManager Como se mostraran los elementos
        recyclerView.setLayoutManager(new LinearLayoutManager(ProductosActivity.this));

        //Adaptador de los elementos
        recyclerView.setAdapter(itemAdapter);
    }

}
