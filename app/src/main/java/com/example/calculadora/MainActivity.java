package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtHoras, txtDias, txtPxHora, txtBase;
    private CheckBox chbxPago, chbxDcto;
    private RadioGroup rgRedondeo;
    private RadioButton rdbRedondeo, rdbNoRedondeo;
    private Button btnLimpiar, btnCalcular;
    private TextView lblPago, lblDcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoras = (EditText) findViewById(R.id.txtHoras);
        txtDias = (EditText) findViewById(R.id.txtDias);
        txtPxHora = (EditText) findViewById(R.id.txtPxHora);
        txtBase = (EditText) findViewById(R.id.txtBase);
        chbxPago = (CheckBox) findViewById(R.id.chbxPago);
        chbxDcto = (CheckBox) findViewById(R.id.chbxDcto);
        rgRedondeo = (RadioGroup) findViewById(R.id.rgRedondeo);
        rdbRedondeo = (RadioButton) findViewById(R.id.rdbRedondeo);
        rdbNoRedondeo = (RadioButton) findViewById(R.id.rdbNoRedondeo);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblDcto = (TextView) findViewById(R.id.lblDcto);
        lblPago = (TextView) findViewById(R.id.lblPago);
    }

    public void calcular(View view) {

        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int pxHoras = Integer.parseInt(txtPxHora.getText().toString());
        int horas_mensuales = horas * dias;
        double descuento = 0.00;
        double sueldo_base = Double.parseDouble(txtBase.getText().toString()); //Modificado de 10000.00
        double pago = sueldo_base + horas_mensuales * pxHoras;


        if (chbxPago.isChecked() == true) {
            lblPago.setText(String.valueOf(pago));
        }
        if (chbxDcto.isChecked() == true && pago > 335000) {
            descuento = pago - (pago * 0.1);
            lblDcto.setText(String.valueOf(descuento));
        }
        if (rgRedondeo.getCheckedRadioButtonId() == R.id.rdbRedondeo) {
            int pago_redondeo = (int) Math.round(pago);
            lblPago.setText(String.valueOf(pago_redondeo));
            int dcto_redondeo = (int) Math.round(descuento);
            lblDcto.setText(String.valueOf(dcto_redondeo));
        }

    }


    public void limpiar (View view){

        txtHoras.setText("");
        txtDias.setText("");
        txtPxHora.setText("");
        txtBase.setText("");
        lblPago.setText("Pago");
        lblDcto.setText("Descuento");
        chbxDcto.setChecked(false);
        chbxPago.setChecked(false);
        rgRedondeo.clearCheck();

    }
}

