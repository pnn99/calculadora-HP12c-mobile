package br.com.paulo.projeto_hp12c;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnC;
    private Button btnBackSpace;
    private Button btnVirgula;
    private Button btnMais;
    private Button btnMenos;
    private Button btnVezes;
    private Button btnDivisao;
    private Button btnEnter;

    private EditText visor;
    private Calculadora calculadora = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn0 = findViewById(R.id.buttonZero);
        btn1 = findViewById(R.id.buttonOne);
        btn2 = findViewById(R.id.buttonTwo);
        btn3 = findViewById(R.id.buttonThree);
        btn4 = findViewById(R.id.buttonFour);
        btn5 = findViewById(R.id.buttonFive);
        btn6 = findViewById(R.id.buttonSix);
        btn7 = findViewById(R.id.buttonSeven);
        btn8 = findViewById(R.id.buttonEight);
        btn9 = findViewById(R.id.buttonNine);
        btnBackSpace = findViewById(R.id.buttonBackSpace);
        btnEnter = findViewById(R.id.buttonEnter);
        btnC = findViewById(R.id.buttonClear);
        btnVirgula = findViewById(R.id.button);
        btnMais = findViewById(R.id.buttonPlus);
        btnMenos = findViewById(R.id.buttonMinus);
        btnDivisao = findViewById(R.id.buttonDiv);
        btnVezes = findViewById(R.id.buttonMulti);



        visor = findViewById(R.id.editTextNumber);
        visor.setShowSoftInputOnFocus(false);

        btn0.setOnClickListener(botaoclick("0"));
        btn1.setOnClickListener(botaoclick("1"));
        btn2.setOnClickListener(botaoclick("2"));
        btn3.setOnClickListener(botaoclick("3"));
        btn4.setOnClickListener(botaoclick("4"));
        btn5.setOnClickListener(botaoclick("5"));
        btn6.setOnClickListener(botaoclick("6"));
        btn7.setOnClickListener(botaoclick("7"));
        btn8.setOnClickListener(botaoclick("8"));
        btn9.setOnClickListener(botaoclick("9"));
        btnVirgula.setOnClickListener(botaoclick("."));

        btnC.setOnClickListener((v)->{
            visor.setText("");
            calculadora = new Calculadora();
        });

        btnBackSpace.setOnClickListener((v) -> {
            int inicioSelecao = visor.getSelectionStart() - 1;
            inicioSelecao = Math.max(inicioSelecao,0);
            int finalSelecao = visor.getSelectionEnd();
            visor.getText().delete(inicioSelecao, finalSelecao);
        });

        btnEnter.setOnClickListener((v)->{
            double valor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valor);
            calculadora.enter();
            visor.setText("");
        });

        btnMais.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.soma();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnMenos.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.subtracao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnVezes.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.multiplicacao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnDivisao.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.divisao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

        btnVezes.setOnClickListener((v)->{
            double valorDoVisor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valorDoVisor);
            calculadora.multiplicacao();
            String valor = String.valueOf(calculadora.getNumero());
            visor.setText(valor);
        });

    }

    public View.OnClickListener botaoclick(final String s) {
        return (v) -> {
            int inicioSelecao = visor.getSelectionStart();
            int finalSelecao = visor.getSelectionEnd();
            visor.getText().replace(inicioSelecao,finalSelecao,s);
        };
    }
}