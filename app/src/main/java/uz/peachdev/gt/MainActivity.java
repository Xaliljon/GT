package uz.peachdev.gt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    TextView as, kel, tan;
    EditText ism;
    Button btnext;
    SpinKitView spin;
    ProgressDialog mmDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printKeyHash();

        ism = findViewById(R.id.editText);
        spin = findViewById(R.id.spin_kit);
        as = findViewById(R.id.assa);
        kel = findViewById(R.id.kelin);
        tan = findViewById(R.id.tanish);
        btnext = findViewById(R.id.next1);


        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation myanim4 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation myanim5 = AnimationUtils.loadAnimation(this, R.anim.alpha);

        new Handler().postDelayed(() -> {
                    as.setVisibility(View.VISIBLE);
                    as.startAnimation(myanim);
                    as.animate().translationY(-25).setDuration(1000);


                }, 500
        );

        new Handler().postDelayed(() -> {
                    kel.setVisibility(View.VISIBLE);
                    kel.startAnimation(myanim2);
                    kel.animate().translationY(-25).setDuration(1000);

                }, 750
        );

        new Handler().postDelayed(() -> {
                    tan.setVisibility(View.VISIBLE);
                    tan.startAnimation(myanim3);
                    tan.animate().translationY(-25).setDuration(1000);

                }, 1000
        );

        new Handler().postDelayed(() -> {
                    ism.setVisibility(View.VISIBLE);
                    ism.startAnimation(myanim4);

                    ism.animate().translationY(-25).setDuration(1000);

                }, 1500
        );

        new Handler().postDelayed(() -> {
                    btnext.setVisibility(View.VISIBLE);
                    btnext.startAnimation(myanim5);
                    btnext.animate().translationY(-25).setDuration(1000);
                }, 1750
        );

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmDialog = new ProgressDialog(MainActivity.this);
                //Show dialog

                mmDialog.show();
                //Set Content View

                mmDialog.setContentView(R.layout.dialog_progress);
                //Set transparent Background
                mmDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );

                sendDataFireBase();
            }

            ;
        });


    }

    private void printKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("uz.peachdev.gt", PackageManager.GET_SIGNATURES);
            for (Signature signature: info.signatures){
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(),Base64.DEFAULT));

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void sendDataFireBase() {
        if (TextUtils.isEmpty(ism.getText().toString())) {
            Toast.makeText(MainActivity.this,
                    "ISMINGIZNI KIRITING!",
                    Toast.LENGTH_SHORT).show();
        } else {


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("users");

            String username = ism.getText().toString();

            UserHelper userHelper = new UserHelper(username);
            myRef.child(username).setValue(userHelper);
            Toast.makeText(MainActivity.this,
                    "1 sekund kuting..",
                    Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                                          @Override
                                          public void run() {
                                              mmDialog.dismiss();
                                              Intent intent = new Intent(MainActivity.this, Registration.class);

                                              intent.putExtra("name", username);
                                              startActivity(intent);
                                              finish();
                                          }
                                      }, 1000
            );


        }
    }


}