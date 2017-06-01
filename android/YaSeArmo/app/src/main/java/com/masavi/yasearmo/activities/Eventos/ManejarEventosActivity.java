package com.masavi.yasearmo.activities.Eventos;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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

    // Layouts que contienen las flechas de selección para moverse entre fragmentos
    @BindView(R.id.evento_img_arrow_right)
    LinearLayout arrowRightLayout;

    @BindView(R.id.evento_img_arrow_left)
    LinearLayout arrowLeftLayout;

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

        // Asignamos los layouts a nuestras variables, para poder desaparecer las flechas
        arrowRightLayout = (LinearLayout) findViewById(R.id.evento_img_arrow_right);
        arrowLeftLayout = (LinearLayout) findViewById(R.id.evento_img_arrow_left);

        // Colocamos el texto introductorio
        tvTitulo.setText(R.string.eventos_title);

        // Añadimos cada pregunta que será cargada al movernos entre fragmentos
        getData();

        // Inicialización de la primer pregunta
        cambiarFragmento(TarjetaFragment.newInstance(
                mListTarjetas.get(mPosicionTarjeta = 0).getTitulo(),
                mListTarjetas.get(mPosicionTarjeta).getImgUrl(),
                mListTarjetas.get(mPosicionTarjeta).getContenido()
        ), 1);

        // Verificamos la posición actual de tarjeta, para mostrar visible o invisible las flechas
        checarVisibilidad();
    }

    /*
     * Inicializamos la lista de preguntas con sus respuestas correctas
     */
    private void getData()
    {
        mListTarjetas.add(new Tarjeta(0, "Cumpleaños", getString(R.string.lorem_ipsum),
                "http://www.elblogdeyes.com/wp-content/uploads/fiestas-de-cumplea%C3%B1os.jpg"));
        mListTarjetas.add(new Tarjeta(1, "Reunión", getString(R.string.lorem_ipsum),
                "http://www.ciudaris.com/blog/wp-content/uploads/banner-fiesta-coctel2.jpg"));
        mListTarjetas.add(new Tarjeta(2, "Bautizo", getString(R.string.lorem_ipsum),
                "http://www.milfiestasinfantiles.com/wp-content/uploads/2015/03/decoracion-original-para-una-fiesta-de-bautizo.jpg"));
        mListTarjetas.add(new Tarjeta(3, "Fiesta de Compromiso", getString(R.string.lorem_ipsum),
                "https://cdn0.bodas.com.mx/usr/8/2/4/1/cfb_437663.jpg"));
    }

    public void checarVisibilidad()
    {
        if (mPosicionTarjeta == 0)
        {
            arrowLeftLayout.setVisibility(View.INVISIBLE);
            arrowLeftLayout.setClickable(false);

            arrowRightLayout.setVisibility(View.VISIBLE);
            arrowRightLayout.setClickable(true);
        }
        else if (mPosicionTarjeta == mListTarjetas.size() - 1)
        {
            arrowRightLayout.setVisibility(View.INVISIBLE);
            arrowRightLayout.setClickable(false);

            arrowLeftLayout.setVisibility(View.VISIBLE);
            arrowLeftLayout.setClickable(true);
        }
        else
        {
            arrowLeftLayout.setVisibility(View.VISIBLE);
            arrowLeftLayout.setClickable(true);

            arrowRightLayout.setVisibility(View.VISIBLE);
            arrowRightLayout.setClickable(true);
        }
    }

    @OnClick(R.id.evento_img_arrow_right)
    public void next()
    {
        // Si aún hay tarjetas que mostrar
        if (mPosicionTarjeta < mListTarjetas.size() - 1)
        {
            // Aumentamos en 1 la posición actual de tarjeta y cambiamos de fragmento, según la posición
            cambiarFragmento(TarjetaFragment.newInstance(
                    mListTarjetas.get(++mPosicionTarjeta).getTitulo(),
                    mListTarjetas.get(mPosicionTarjeta).getImgUrl(),
                    mListTarjetas.get(mPosicionTarjeta).getContenido()
            ), 1);
            idTarjeta++;
        }

        checarVisibilidad();
    }

    @OnClick(R.id.evento_img_arrow_left)
    public void goBack()
    {
        // Aumentamos en 1 la posición actual de tarjeta y cambiamos de fragmento, según la posición
        cambiarFragmento(TarjetaFragment.newInstance(
                mListTarjetas.get(--mPosicionTarjeta).getTitulo(),
                mListTarjetas.get(mPosicionTarjeta).getImgUrl(),
                mListTarjetas.get(mPosicionTarjeta).getContenido()
        ), 0);
        idTarjeta--;

        checarVisibilidad();
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
    public void cambiarFragmento(TarjetaFragment fragment, int forward) {
        /*
         *Obtengo el FragmentManaget que me ayuda con las transacciones
         *que necesite hacer con mis fragmentos
         */
        mFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (forward == 1)
        {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_rigth_enter, R.anim.slide_left_exit)
                    .replace(R.id.frame_layout, fragment)
                    .commit();
        }

        else if (forward == 0)
        {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit)
                    .replace(R.id.frame_layout, fragment)
                    .commit();
        }

    }

}
