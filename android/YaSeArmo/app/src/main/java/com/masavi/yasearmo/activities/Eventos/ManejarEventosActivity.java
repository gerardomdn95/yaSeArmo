package com.masavi.yasearmo.activities.Eventos;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.fragments.TarjetaFragment;
import com.masavi.yasearmo.models.Tarjeta;
import com.masavi.yasearmo.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManejarEventosActivity extends AppCompatActivity
{
    // TextView de nuestra actividad donde mostramos el título
    @BindView(R.id.tv_manejar_eventos_titulo)
    TextView tvTitulo;

    // Lista de preguntas donde podemos agregar cada una de las preguntas
    // que se mostrarán al cambiar cada fragmento
    private List<Tarjeta> mListTarjetas = new ArrayList<>();

    // Variable donde guardamos el id de la tarjeta
    private int idTarjeta = 0;

    // Posición del usuario al moverse entre tarjetas
    private int mPosicionTarjeta;

    // Inicialización de fragmentos
    private TarjetaFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Indicamos a nuestra actividad qué layout debe mostrar
        setContentView(R.layout.activity_manejar_eventos);

        //Inicializamos ButterKnife
        ButterKnife.bind(this);

        // Añadimos cada pregunta que será cargada al movernos entre fragmentos
        getData();

        //Inicialización de la primer pregunta
        cambiarFragmento(TarjetaFragment.newInstance(mListTarjetas.get(mPosicionTarjeta = 0).getTitulo()));
    }

    /*
     * Inicializamos la lista de preguntas con sus respuestas correctas
     */
    private void getData()
    {
        mListTarjetas.add(new Tarjeta(0, "Titulo", "Contenido", "url-de-imagen"));
        mListTarjetas.add(new Tarjeta(1, "Titulo", "Contenido", "url-de-imagen"));
        mListTarjetas.add(new Tarjeta(2, "Titulo", "Contenido", "url-de-imagen"));
        mListTarjetas.add(new Tarjeta(3, "Titulo", "Contenido", "url-de-imagen"));
    }

    @OnClick(R.id.quiz_img_arrow_right)
    public void next()
    {
        // Si aún hay tarjetas que mostrar
        if (mPosicionTarjeta < mListTarjetas.size() - 1)
        {
            // Aumentamos en 1 la posición actual de tarjeta y cambiamos de fragmento, según la posición
            cambiarFragmento(TarjetaFragment.newInstance(mListTarjetas.get(++mPosicionTarjeta).getTitulo()));
            idTarjeta++;
        }
        else
        {
            // TODO: Hacer invisible la flecha a la derecha
        }
    }

    @OnClick(R.id.btn_manejar_evento_continuar)
    public void continuar()
    {
        //Seguido, se muestra el historial de puntuaciones
        Intent intent = new Intent(ManejarEventosActivity.this, EventosActivity.class);

        //Mandamos data extra
        intent.putExtra(Constants.TARJETA_ID, idTarjeta);

        //Lanzamos la actividad
        startActivity(intent);
    }

    /*
     * Metodo para cambiar el fragmento que esta en el frame layout de la pantalla
     *
     * @param fragment
     */
    public void cambiarFragmento(TarjetaFragment fragment) {
        /*
         *Obtengo el FragmentManaget que me ayuda con las transacciones
         *que necesite hacer con mis fragmentos
         */
        mFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_rigth_enter, R.anim.slide_left_exit)
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

}
