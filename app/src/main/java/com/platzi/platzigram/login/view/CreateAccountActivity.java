package com.platzi.platzigram.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.platzi.platzigram.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccountActivity extends AppCompatActivity {

    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.name)
    TextInputEditText name;
    @BindView(R.id.user)
    TextInputEditText user;
    @BindView(R.id.password_createaccount)
    TextInputEditText passwordCreateaccount;
    @BindView(R.id.confirmPassword)
    TextInputEditText confirmPassword;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount), true);

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {

                } else {

                }
            }
        };
    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }

    public void showToolbar(String tittle, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @OnClick(R.id.joinUs)
    public void onViewClicked() {
        createAccount();
    }

    private void createAccount() {
        String mail = email.getText().toString();
        String pass = passwordCreateaccount.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CreateAccountActivity.this, getResources().getString(R.string.account_success), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CreateAccountActivity.this, getResources().getString(R.string.account_failed), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
