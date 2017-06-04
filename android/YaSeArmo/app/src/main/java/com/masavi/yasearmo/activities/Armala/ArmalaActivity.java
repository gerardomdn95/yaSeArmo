package com.masavi.yasearmo.activities.Armala;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.masavi.yasearmo.activities.MainMenuActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArmalaActivity extends AppCompatActivity {

    @BindView(R.id.armala_img_perfil)
    ImageView imgProfilePic;

    @BindView(R.id.armala_tv_nombre)
    TextView tvNombre;

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armala);
        ButterKnife.bind(this);

        // Obtenemos una instancia de Firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // Si no se encuentra un usuario cargado
                if (firebaseAuth.getCurrentUser() == null){
                    // Lanzamos la actividad de Login
                    startActivity(new Intent(ArmalaActivity.this, LoginActivity.class));
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
                        Toast.makeText(ArmalaActivity.this, "Hay un error!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        Picasso.with(imgProfilePic.getContext()).load(mAuth.getCurrentUser().getPhotoUrl()).into(imgProfilePic);
        tvNombre.setText(mAuth.getCurrentUser().getDisplayName());
    }
}
