package com.masavi.yasearmo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.masavi.yasearmo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TarjetaFragment extends Fragment {

    public static final String ARG_TITLE = "ARG_TITLE";
    private String mTitulo;

    @BindView(R.id.tarjeta_tv_titulo)
    TextView tvTitulo;

    public TarjetaFragment(){
        // Required empty public constructor
    }

    public static TarjetaFragment newInstance(String titulo) {
        TarjetaFragment fragment = new TarjetaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, titulo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            mTitulo = args.getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tarjeta, container, false);
        ButterKnife.bind(this, view);
        tvTitulo.setText(mTitulo);
        return view;
    }
}