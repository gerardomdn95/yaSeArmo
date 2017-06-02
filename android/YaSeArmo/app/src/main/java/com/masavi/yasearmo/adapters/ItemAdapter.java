package com.masavi.yasearmo.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Productos.DetalleProductoActivity;
import com.masavi.yasearmo.models.Item;
import com.masavi.yasearmo.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Masavi on 31/5/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<Item> itemList;

    // Constructor
    public ItemAdapter(List<Item> itemList)
    {
        this.itemList = itemList;
    }

    // Inicialización del viewholder onCreate
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    // Enlazar viewholder con items
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position)
    {
        Item item = itemList.get(position);
        holder.bindItem(item);
    }

    // Obtener conteo total de items en la lista
    @Override
    public int getItemCount()
    {
        return itemList.size();
    }


    // Introducimos contenido al item_producto layout a reciclar
    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.item_producto_img)
        ImageView imgProducto;

        @BindView(R.id.item_producto_titulo)
        TextView tvTituloProducto;

        @BindView(R.id.item_producto_descripcion)
        TextView tvDescProducto;

        @BindView(R.id.item_producto_star_1)
        ImageView imgEstrella1;

        @BindView(R.id.item_producto_star_2)
        ImageView imgEstrella2;

        @BindView(R.id.item_producto_star_3)
        ImageView imgEstrella3;

        @BindView(R.id.item_producto_star_4)
        ImageView imgEstrella4;

        @BindView(R.id.item_producto_star_5)
        ImageView imgEstrella5;

        private String imagenUrl;
        private String titulo;
        private String descripcion;
        private int rating;
        private int id;

        private View rootView;

        public ItemViewHolder(View itemView)
        {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, itemView);

        }

        public void bindItem(Item item)
        {
            // Asignación de datos según lista de items
            Picasso.with(imgProducto.getContext()).load(item.getUrl()).into(imgProducto);
            tvTituloProducto.setText(item.getNombre());
            tvDescProducto.setText(item.getDescripcion());

            // Guardamos los datos para mandar al siguiente intent
            imagenUrl = item.getUrl();
            titulo = item.getNombre();
            descripcion = item.getDescripcion();
            rating = (int) item.getRating();

            switch ((int) item.getRating())
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

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(v.getContext(), DetalleProductoActivity.class);
                    intent.putExtra(Constants.PRODUCTO_IMAGEN, imagenUrl);
                    intent.putExtra(Constants.PRODUCTO_TITULO, titulo);
                    intent.putExtra(Constants.PRODUCTO_DESCRIPCION, descripcion);
                    intent.putExtra(Constants.PRODUCTO_RATING, rating);
                    v.getContext().startActivity(intent);
                }
            });

        }


    }
}
