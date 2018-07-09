package com.example.emeka.gitgeneraltask2;

import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Crypto extends Activity {

    private EditText editPlainText;
    private EditText editKey;
    private TextView encryptedText;
    private TextView decryptedText;

    //private char[] charPlainText;

    private String stringPlainText;
    private char[] charDecryptedText;
    private int key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);



        //Integer k = Integer.valueOf(editKey.toString());

        //key = Integer.parseInt(editKey.toString());

//        String stringPlainText;
//
//        stringPlainText = editPlainText.toString();
//
//
//        char[] charPlainText;
//        charPlainText = stringPlainText.toCharArray();


        encryptedText = findViewById(R.id.encryptedText);
        decryptedText = findViewById(R.id.decryptedText);
        encryptedText.setVisibility(View.INVISIBLE);
        decryptedText.setVisibility(View.INVISIBLE);
    }

    public void encryptPlainText(View view)
    {
        editPlainText = (EditText)findViewById(R.id.plainText);
        editKey = (EditText)findViewById(R.id.lockKey);
        encryptedText = (TextView)findViewById(R.id.encryptedText);

        if (editPlainText.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter a message", Toast.LENGTH_SHORT).show();
            return;
        }

        if (editKey.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter the key", Toast.LENGTH_SHORT).show();
            return;
        }

        key = Integer.parseInt(editKey.getText().toString());

        stringPlainText = editPlainText.getText().toString();


        char[] charPlainText;
        charPlainText = stringPlainText.toCharArray();

        char[] cryptoText = new char[charPlainText.length];

        for (int i = 0; i < charPlainText.length; i++)
        {
            cryptoText[i] = (char)(((int)charPlainText[i]) + key);
        }

        editPlainText.setText("");
        editKey.setText("");

        encryptedText.setText("Encrypted Message: " + String.valueOf(cryptoText));
        encryptedText.setVisibility(View.VISIBLE);
        decryptedText.setVisibility(View.INVISIBLE);

        //encryptedText.setText("Seems alright so far");

        //put toast at the end
        Toast.makeText(this, "Message Encrypted", Toast.LENGTH_SHORT).show();
    }

    public void decryptCipherText(View view)
    {
        if(encryptedText.getVisibility() == View.INVISIBLE)
        {
            Toast.makeText(this,"No encryption yet",Toast.LENGTH_SHORT).show();
            return;
        }

        editKey = findViewById(R.id.unlockKey);

        if (editKey.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter the key", Toast.LENGTH_SHORT).show();
            return;
        }

        key = Integer.parseInt(editKey.getText().toString());

        String stringCipherText;
        stringCipherText = encryptedText.getText().toString();
        stringCipherText = stringCipherText.replace("Encrypted Message: ","");

        char[] charCipherText;
        charCipherText = stringCipherText.toCharArray();

        charDecryptedText = new char[charCipherText.length];

        for (int i = 0; i < charCipherText.length; i++)
        {
            charDecryptedText[i] = (char)(((int)charCipherText[i]) - key);
        }

        decryptedText.setText(String.valueOf(charDecryptedText));
        decryptedText.setVisibility(View.VISIBLE);

        editKey.setText("");

        //encryptedText.setText("Seems alright so far");

        //put toast at the end
        if(String.valueOf(charDecryptedText) == stringPlainText)
        {
            Toast.makeText(this, "Message decrypted successfully", Toast.LENGTH_SHORT).show();
        }
    }

}























