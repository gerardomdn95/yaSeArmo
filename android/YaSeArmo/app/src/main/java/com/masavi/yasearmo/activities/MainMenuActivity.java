package com.masavi.yasearmo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Eventos.ManejarEventosActivity;
import com.masavi.yasearmo.activities.Armala.ArmalaActivity;
import com.masavi.yasearmo.activities.Login.LoginActivity;
import com.masavi.yasearmo.activities.Paquetes.PaquetesActivity;
import com.masavi.yasearmo.activities.Pedidos.ManejarPedidosActivity;
import com.masavi.yasearmo.activities.Pedidos.PedidosActivity;
import com.masavi.yasearmo.activities.Productos.ProductosActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuActivity extends AppCompatActivity {

    @BindView(R.id.btn_main_menu_perfil)
    ImageView imgPerfil;

    @BindView(R.id.tv_main_menu_username)
    TextView tvNombreUsuario;

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);

        // Obtenemos una instancia de Firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Si no se encuentra un usuario cargado
                if (firebaseAuth.getCurrentUser() == null){
                    // Lanzamos la actividad de Login
                    startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
                }
            }
        };

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(MainMenuActivity.this, "Hay un error!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Picasso.with(imgPerfil.getContext()).load(mAuth.getCurrentUser().getPhotoUrl()).into(imgPerfil);
        tvNombreUsuario.setText("¡Bienvenido " + mAuth.getCurrentUser().getDisplayName() + "!");
    }

    @OnClick(R.id.btn_main_menu_perfil)
    public void onClickPerfil(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, PerfilActivity.class));
    }

    @OnClick(R.id.btn_armala)
    public void onClickArmala(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, ArmalaActivity.class));
    }

    @OnClick(R.id.btn_eventos)
    public void onClickEventos(View view){
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, ManejarEventosActivity.class));
    }

    @OnClick(R.id.btn_paquetes)
    public void onClickPaquetes(View view){
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, PaquetesActivity.class));
    }

/*    @OnClick(R.id.btn_pedidos)
    public void onClickServicios(View view){
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, ManejarPedidosActivity.class));
    }*/

    @OnClick(R.id.btn_pedidos)
    public void onClickServicios(View view){
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.image_click));
        startActivity(new Intent(MainMenuActivity.this, PedidosActivity.class));
    }

}
