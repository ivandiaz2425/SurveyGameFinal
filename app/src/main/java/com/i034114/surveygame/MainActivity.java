package com.i034114.surveygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.i034114.surveygame.Helpers.ConexionSQLiteHelper;
import com.i034114.surveygame.Views.Login;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        btnLogout = (Button) findViewById(R.id.btnLogout);

            btnLogout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    logoutUser();
                }
            });
    }
    private void logoutUser() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
