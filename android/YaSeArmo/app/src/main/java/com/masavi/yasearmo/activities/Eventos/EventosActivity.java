package com.masavi.yasearmo.activities.Eventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Productos.ProductosActivity;
import com.masavi.yasearmo.adapters.ItemAdapter;
import com.masavi.yasearmo.adapters.PaqueteAdapter;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventosActivity extends AppCompatActivity
{
    @BindView(R.id.recycler_paquetes)
    RecyclerView recyclerView;

    private int idTarjeta;

    List<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_paquetes);

        getIntentData();
        yaSeArmoAPIConnection();
    }

    public void getIntentData()
    {
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            idTarjeta = extras.getInt(Constants.TARJETA_ID);
            Log.e("myLog", "ID de actividad anterior: " + idTarjeta);
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

                switch (idTarjeta)
                {
                    // Fiesta de Cumpleaños
                    case 0: mItems.add(new Item(
                            paquetes.get(1).getId(),
                            paquetes.get(1).getNombre(),
                            paquetes.get(1).getImagen()
                            )
                    );
                        break;

                    // Reunión
                    case 1: mItems.add(new Item(
                                    paquetes.get(2).getId(),
                                    paquetes.get(2).getNombre(),
                                    paquetes.get(2).getImagen()
                            )
                    );
                        break;

                    // Bautizo
                    case 2: mItems.add(new Item(
                                    paquetes.get(4).getId(),
                                    paquetes.get(4).getNombre(),
                                    paquetes.get(4).getImagen()
                            )
                    );
                        break;

                    // Fiesta de Compromiso
                    case 3: mItems.add(new Item(
                                    paquetes.get(3).getId(),
                                    paquetes.get(3).getNombre(),
                                    paquetes.get(3).getImagen()
                            )
                    );
                        break;
                }
/*
               for (int i = 0; i < paquetes.size() -1; i++)
                {
                    Log.e("myLog", "Poblando items...");
                    mItems.add(new Item(
                            paquetes.get(i).getId(),
                            paquetes.get(i).getNombre(),
                            paquetes.get(i).getImagen()
                            )
                    );
                }
*/
                settingRecyclerView();
            }

            @Override
            public void onFailure(Call<List<Paquete>> call, Throwable t) {
                Log.e("myLog", "Valió barriga");
            }
        });

    }

    private void settingRecyclerView()
    {
        PaqueteAdapter paqueteAdapter = new PaqueteAdapter(mItems);

        //LayoutManager Como se mostraran los elementos
        recyclerView.setLayoutManager(new LinearLayoutManager(EventosActivity.this));

        //Adaptador de los elementos
        recyclerView.setAdapter(paqueteAdapter);
    }

}
