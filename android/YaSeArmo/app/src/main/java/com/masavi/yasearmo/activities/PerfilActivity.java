package com.masavi.yasearmo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.masavi.yasearmo.R;
import com.masavi.yasearmo.activities.Login.LoginActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilActivity extends AppCompatActivity {

    private Button mLogOutBtn;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @BindView(R.id.img_perfil_perfil)
    ImageView imgPerfil;

    @BindView(R.id.tv_perfil_nombre)
    TextView tvNombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        // Obtenemos una instancia de Firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Si no se encuentra un usuario cargado
                if (firebaseAuth.getCurrentUser() == null){
                    // Lanzamos la actividad de Login
                    startActivity(new Intent(PerfilActivity.this, LoginActivity.class));
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
                        Toast.makeText(PerfilActivity.this, "Hay un error!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Picasso.with(getApplicationContext()).load(mAuth.getCurrentUser().getPhotoUrl()).into(imgPerfil);
        tvNombreUsuario.setText("¡Hola " + mAuth.getCurrentUser().getDisplayName() + "!");
        mLogOutBtn = (Button) findViewById(R.id.btn_logout);


        // Al presionar el botón de cerrar sesión
        mLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Firebase Sign Out
                mAuth.signOut();

                // Google Sign Out
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}
