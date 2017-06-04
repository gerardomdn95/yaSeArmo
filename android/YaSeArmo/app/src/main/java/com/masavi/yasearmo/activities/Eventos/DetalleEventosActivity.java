package com.masavi.yasearmo.activities.Eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Carrito.CarritoActivity;
import com.masavi.yasearmo.activities.Productos.ProductosActivity;
import com.masavi.yasearmo.adapters.ItemAdapter;
import com.masavi.yasearmo.api.ServiceGenerator;
import com.masavi.yasearmo.api.YaSeArmoAPI;
import com.masavi.yasearmo.models.Item;
import com.masavi.yasearmo.models.Paquete;
import com.masavi.yasearmo.models.Producto;
import com.masavi.yasearmo.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleEventosActivity extends AppCompatActivity
{
    @BindView(R.id.recycler_eventos)
    RecyclerView recyclerView;

    List<Item> mItems = new ArrayList<>();

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_eventos);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_eventos);

        getIntentData();
        yaSeArmoAPIConnection();

    }

    public void getIntentData()
    {
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            id = extras.getInt(Constants.ID);
            Log.e("myLog", "ID recibido: " + id);
        }
    }

    public void yaSeArmoAPIConnection ()
    {
        YaSeArmoAPI yaSeArmoApi = ServiceGenerator.createService();

        yaSeArmoApi.obtenerPaquetes().enqueue(new Callback<List<Paquete>>() {
            @Override
            public void onResponse(Call<List<Paquete>> call, Response<List<Paquete>> response)
            {
                List<Paquete> paquetes = response.body();
                Log.e("myLog", "Guardado en lista el cuerpo de la respuesta");

                List<Producto> basico  = paquetes.get(0).getProductos();
                List<Producto> cumple  = paquetes.get(1).getProductos();
                List<Producto> cheves  = paquetes.get(2).getProductos();
                List<Producto> whiskey = paquetes.get(3).getProductos();
                List<Producto> grande  = paquetes.get(4).getProductos();


               switch (id)
                {
                    // Paquete "Puras Cheves"
                    case 1:

                        for (int i = 0; i < cheves.size() -1; i++)
                        {
                            mItems.add(new Item(
                                    cheves.get(i).getNombre(),
                                    cheves.get(i).getImagen(),
                                    cheves.get(i).getDescripcion(),
                                    cheves.get(i).getCategoria(),
                                    (int) cheves.get(i).getRating()));
                        }

                        break;

                    // Paquete "Básico"
                    case 2:

                        for (int i = 0; i < basico.size() -1; i++)
                        {
                            mItems.add(new Item(
                                    basico.get(i).getNombre(),
                                    basico.get(i).getImagen(),
                                    basico.get(i).getDescripcion(),
                                    basico.get(i).getCategoria(),
                                    (int) basico.get(i).getRating()));
                        }

                        break;

                    // Paquete "Whiskey Triple"
                    case 3:

                        for (int i = 0; i < whiskey.size() -1; i++)
                        {
                            mItems.add(new Item(
                                    whiskey.get(i).getNombre(),
                                    whiskey.get(i).getImagen(),
                                    whiskey.get(i).getDescripcion(),
                                    whiskey.get(i).getCategoria(),
                                    (int) whiskey.get(i).getRating()));
                        }

                        break;

                    // Paquete "Fiesta en Grande"
                    case 4:

                        for (int i = 0; i < grande.size() -1; i++)
                        {
                            mItems.add(new Item(
                                    grande.get(i).getNombre(),
                                    grande.get(i).getImagen(),
                                    grande.get(i).getDescripcion(),
                                    grande.get(i).getCategoria(),
                                    (int) grande.get(i).getRating()));
                        }

                        break;

                    // Paquete "Fiesta de Cumpleaños"
                    case 5:

                        for (int i = 0; i < cumple.size() -1; i++)
                        {
                            mItems.add(new Item(
                                    cumple.get(i).getNombre(),
                                    cumple.get(i).getImagen(),
                                    cumple.get(i).getDescripcion(),
                                    cumple.get(i).getCategoria(),
                                    (int) cumple.get(i).getRating()));
                        }

                        break;
                }

                settingRecyclerView();
            }

            @Override
            public void onFailure(Call<List<Paquete>> call, Throwable t) {
                Log.e("myLog", "Algo salió mal");
            }
        });
    }


    private void settingRecyclerView()
    {
        ItemAdapter itemAdapter = new ItemAdapter(mItems);

        //LayoutManager Como se mostraran los elementos
        recyclerView.setLayoutManager(new LinearLayoutManager(DetalleEventosActivity.this));

        //Adaptador de los elementos
        recyclerView.setAdapter(itemAdapter);
    }

    @OnClick(R.id.detalle_eventos_btn)
    public void onClickCarrito(View view)
    {
        startActivity(new Intent(DetalleEventosActivity.this, CarritoActivity.class));
    }
}
