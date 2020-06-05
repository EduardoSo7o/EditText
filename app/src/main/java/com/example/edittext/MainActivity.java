package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edittext.exceptions.*;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.et_name);
        editTextPassword = findViewById(R.id.et_password);
    }

    public void save(View view){
        String name = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();

        try{
            if(name.equals(""))
                if (password.equals(""))
                    throw new NullNameAndPasswordException();
                else
                    throw new NullNameException();

            else if (password.equals(""))
                throw new NullPasswordException();

            Toast.makeText(this, "Name and password saved!", Toast.LENGTH_SHORT).show();
        } catch (NullNameException e) {
            Toast.makeText(this, "Type your name", Toast.LENGTH_SHORT).show();
        } catch (NullPasswordException e) {
            Toast.makeText(this, "Type your password", Toast.LENGTH_SHORT).show();
        } catch (NullNameAndPasswordException e) {
            Toast.makeText(this, "Type your name and password", Toast.LENGTH_SHORT).show();
        }
    }
}