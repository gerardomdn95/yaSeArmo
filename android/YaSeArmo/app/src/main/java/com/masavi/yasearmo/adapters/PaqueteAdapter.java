package com.masavi.yasearmo.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Eventos.DetalleEventosActivity;
import com.masavi.yasearmo.activities.Productos.DetalleProductoActivity;
import com.masavi.yasearmo.activities.Productos.ProductosActivity;
import com.masavi.yasearmo.models.Item;
import com.masavi.yasearmo.models.Producto;
import com.masavi.yasearmo.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Masavi on 02/06/2017.
 */

public class PaqueteAdapter extends RecyclerView.Adapter<PaqueteAdapter.ItemViewHolder> {

    private List<Item> itemList;

    // Constructor
    public PaqueteAdapter(List<Item> itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_paquete, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position)
    {
        Item item = itemList.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Introducimos contenido al item_producto layout a reciclar
    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.item_paquete_img)
        ImageView imgPaquete;

        @BindView(R.id.item_paquete_titulo)
        TextView tvTituloPaquete;

        Button btnPaquete;

        private int id;

        public ItemViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.btnPaquete = (Button) itemView.findViewById(R.id.item_paquete_btn);
        }

        public void bindItem(Item item)
        {
            // Asignación de datos según lista de items
            Picasso.with(imgPaquete.getContext()).load(item.getUrl()).into(imgPaquete);
            tvTituloPaquete.setText(item.getNombre());
            id = item.getId();

            btnPaquete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetalleEventosActivity.class);
                    intent.putExtra(Constants.ID, id);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
