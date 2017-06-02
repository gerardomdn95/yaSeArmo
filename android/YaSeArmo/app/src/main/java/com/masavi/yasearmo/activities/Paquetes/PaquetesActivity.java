package com.masavi.yasearmo.activities.Paquetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Eventos.EventosActivity;
import com.masavi.yasearmo.adapters.PaqueteAdapter;
import com.masavi.yasearmo.api.ServiceGenerator;
import com.masavi.yasearmo.api.YaSeArmoAPI;
import com.masavi.yasearmo.models.Item;
import com.masavi.yasearmo.models.Paquete;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaquetesActivity extends AppCompatActivity
{
    @BindView(R.id.recycler_activity_paquetes)
    RecyclerView recyclerView;

    private int idTarjeta;

    List<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paquetes);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_activity_paquetes);

        yaSeArmoAPIConnection();
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
        recyclerView.setLayoutManager(new LinearLayoutManager(PaquetesActivity.this));

        //Adaptador de los elementos
        recyclerView.setAdapter(paqueteAdapter);
    }
}
