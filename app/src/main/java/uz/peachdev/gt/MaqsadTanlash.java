package uz.peachdev.gt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MaqsadTanlash extends AppCompatActivity {
//    private TextView name, maq, tan;
//    Button btn;
//    ImageView imageView;

//    private FirebaseAuth auth = FirebaseAuth.getInstance();
//    private FirebaseUser user = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maqsad_tanlash);
//        maq = findViewById(R.id.maq);
//        tan = findViewById(R.id.tan);
//        imageView = findViewById(R.id.iface);
//        name = findViewById(R.id.name);
//
//        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.alpha);
//
//
//        new Handler().postDelayed(() -> {
//                    name.setVisibility(View.VISIBLE);
//                    name.startAnimation(myanim);
//                    name.animate().translationY(-25).setDuration(500);
//                }, 500
//        );
//
//        new Handler().postDelayed(() -> {
//                    maq.setVisibility(View.VISIBLE);
//                    maq.startAnimation(myanim2);
//                    maq.animate().translationY(-25).setDuration(500);
//
//                }, 750
//        );
//
//        new Handler().postDelayed(() -> {
//                    tan.setVisibility(View.VISIBLE);
//                    tan.startAnimation(myanim3);
//                    tan.animate().translationY(-25).setDuration(500);
//
//                }, 1000
//        );
//
//
//        if (user != null) {
//            name.setText(user.getDisplayName());
//        }
//        Intent intent = getIntent();
//        String image_url = intent.getStringExtra("image_url");
//        Glide.with(MaqsadTanlash.this).load(image_url).into(imageView);
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth.signOut();
//                LoginManager.getInstance().logOut();
//            }
//        });
//
//
//    }
//
//    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
//        @Override
//        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//            if (currentAccessToken == null) {
//                LoginManager.getInstance().logOut();
//            }
//        }
//    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (user == null) {
//            openLogin();
//        }
//    }
//
//    private void openLogin() {
//        startActivity(new Intent(this, Registration.class));
//        finish();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        accessTokenTracker.stopTracking();
    }
}