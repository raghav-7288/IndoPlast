package com.example.indoplast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {



    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);

        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {
        QrDetailActivity.resultTextView.setText(result.getText());
        onBackPressed();

    }

    @Override
    public void onPause(){

    super.onPause();

    scannerView.stopCamera();

    }

    @Override
    public void onResume(){
    super.onResume();
    scannerView.setResultHandler(this);
    scannerView.startCamera();


    }
}
