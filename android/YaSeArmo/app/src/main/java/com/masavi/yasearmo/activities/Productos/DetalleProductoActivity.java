package com.masavi.yasearmo.activities.Productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Carrito.CarritoActivity;
import com.masavi.yasearmo.util.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetalleProductoActivity extends AppCompatActivity
{
    private String imagenUrl;
    private String titulo;
    private String descripcion;
    private int rating;

    @BindView(R.id.detalle_producto_img)
    ImageView imgProducto;

    @BindView(R.id.detalle_producto_titulo)
    TextView tvNombre;

    @BindView(R.id.detalle_producto_descripcion)
    TextView tvDescripcion;

    @BindView(R.id.detalle_producto_star_1)
    ImageView imgEstrella1;

    @BindView(R.id.detalle_producto_star_2)
    ImageView imgEstrella2;

    @BindView(R.id.detalle_producto_star_3)
    ImageView imgEstrella3;

    @BindView(R.id.detalle_producto_star_4)
    ImageView imgEstrella4;

    @BindView(R.id.detalle_producto_star_5)
    ImageView imgEstrella5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        ButterKnife.bind(this);

        getIntentData();
        setProductInformation();
    }

    public void getIntentData()
    {
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            imagenUrl = extras.getString(Constants.PRODUCTO_IMAGEN);
            titulo = extras.getString(Constants.PRODUCTO_TITULO);
            descripcion = extras.getString(Constants.PRODUCTO_DESCRIPCION);
            rating = extras.getInt(Constants.PRODUCTO_RATING);
        }
    }

    public void setProductInformation()
    {
        Picasso.with(imgProducto.getContext()).load(imagenUrl).into(imgProducto);
        tvNombre.setText(titulo);
        tvDescripcion.setText(descripcion);

        switch (rating)
        {
            case 1:
                Picasso.with(imgEstrella1.getContext()).load(Constants.ESTRELLA).into(imgEstrella1);
                break;

            case 2:
                Picasso.with(imgEstrella1.getContext()).load(Constants.ESTRELLA).into(imgEstrella1);
                Picasso.with(imgEstrella2.getContext()).load(Constants.ESTRELLA).into(imgEstrella2);
                break;

            case 3:
                Picasso.with(imgEstrella1.getContext()).load(Constants.ESTRELLA).into(imgEstrella1);
                Picasso.with(imgEstrella2.getContext()).load(Constants.ESTRELLA).into(imgEstrella2);
                Picasso.with(imgEstrella3.getContext()).load(Constants.ESTRELLA).into(imgEstrella3);
                break;

            case 4:
                Picasso.with(imgEstrella1.getContext()).load(Constants.ESTRELLA).into(imgEstrella1);
                Picasso.with(imgEstrella2.getContext()).load(Constants.ESTRELLA).into(imgEstrella2);
                Picasso.with(imgEstrella3.getContext()).load(Constants.ESTRELLA).into(imgEstrella3);
                Picasso.with(imgEstrella4.getContext()).load(Constants.ESTRELLA).into(imgEstrella4);
                break;

            case 5:
                Picasso.with(imgEstrella1.getContext()).load(Constants.ESTRELLA).into(imgEstrella1);
                Picasso.with(imgEstrella2.getContext()).load(Constants.ESTRELLA).into(imgEstrella2);
                Picasso.with(imgEstrella3.getContext()).load(Constants.ESTRELLA).into(imgEstrella3);
                Picasso.with(imgEstrella4.getContext()).load(Constants.ESTRELLA).into(imgEstrella4);
                Picasso.with(imgEstrella5.getContext()).load(Constants.ESTRELLA).into(imgEstrella5);
                break;
        }
    }

    @OnClick(R.id.detalle_producto_btn)
    public void onClick(View view)
    {
        startActivity(new Intent(DetalleProductoActivity.this, CarritoActivity.class));
    }
}
