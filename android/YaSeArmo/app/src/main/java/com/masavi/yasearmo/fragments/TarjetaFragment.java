package com.masavi.yasearmo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.masavi.yasearmo.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TarjetaFragment extends Fragment {

    public static final String ARG_TITULO = "ARG_TITULO";
    public static final String ARG_DESC = "ARG_DESC";
    public static final String ARG_URL = "ARG_URL";
    private String mTitulo;
    private String mDesc;
    private String mUrl;

    @BindView(R.id.tarjeta_tv_titulo)
    TextView tvTitulo;

    @BindView(R.id.tarjeta_img)
    ImageView imgTarjeta;

    @BindView(R.id.tarjeta_desc)
    TextView tvDesc;

    public TarjetaFragment(){
        // Required empty public constructor
    }

    public static TarjetaFragment newInstance(String titulo, String url, String descripcion) {
        TarjetaFragment fragment = new TarjetaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITULO, titulo);
        args.putString(ARG_URL, url);
        args.putString(ARG_DESC, descripcion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            mTitulo = args.getString(ARG_TITULO);
            mUrl = args.getString(ARG_URL);
            mDesc = args.getString(ARG_DESC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tarjeta, container, false);
        ButterKnife.bind(this, view);
        tvTitulo.setText(mTitulo);
        tvDesc.setText(mDesc);
        Picasso.with(imgTarjeta.getContext()).load(mUrl).into(imgTarjeta);
        return view;
    }
}