package appchat.kuroneko.appchatott;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity {

    // Declare an instance of FirebaseAuth
    private FirebaseAuth mAuth;
    // Declare activity (Log in) components:
    EditText username, password;
    Button signInButton, signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // In the onCreate() method, initialize the FirebaseAuth instance.
        mAuth = FirebaseAuth.getInstance();

        // initilize components:
        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);
        signInButton = findViewById(R.id.login_btn);
        signOutButton = findViewById(R.id.register_btn);

        // set sign in button disable:
        signInButton.setEnabled(false);
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {

        if(user!=null) {
            // Signed in;
            username.setText(user.getEmail());
            password.setText(user.getUid());
            signInButton.setEnabled(true);

        } else {
            Toast.makeText(this, "Invalid user", Toast.LENGTH_SHORT).show();
        }
    }

}
