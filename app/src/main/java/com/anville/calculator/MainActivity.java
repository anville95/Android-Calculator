package com.anville.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private  TextView result;

    private boolean justPressedEqual;
    private boolean isShifted;
    private boolean justEntered;

    private int bracket;
    private Double resultNum;

    //Number buttons
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    //Operators buttons
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEquals;
    private Button buttonDot;

    //Special Modifier buttons
    private Button buttonShift;
    private Button buttonAC;
    private Button buttonDel;

    //Trigonometric ratios
    private Button buttonCos;
    private Button buttonSin;
    private Button buttonTan;

    private Button buttonCosh;
    private Button buttonSinh;
    private Button buttonTanh;

    //logarithms butttons
    private Button buttonLog;
    private Button buttonLn;

    //Power, Pi, Factorial and e
    private Button buttonPow;
    private Button buttonPi;

    //Brackets
    private Button buttonOpenBrackets;
    private Button buttonCloseBrackets;

    //Other fields for use in evaluation
    private List<String> expressionList = new ArrayList<String>();
    private List<String> screenList = new ArrayList<String>();
    private StringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.text);
        screen.setMovementMethod(new ScrollingMovementMethod());
        screen.setHorizontallyScrolling(true);
        result = (TextView)findViewById(R.id.result);
        result.setMovementMethod(new ScrollingMovementMethod());
        result.setHorizontallyScrolling(true);
        result.setVerticalScrollBarEnabled(false);

        Toast.makeText(MainActivity.this, "Please swipe calculator screen to turn it on!", Toast.LENGTH_LONG).show();

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);

        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonMultiply = (Button)findViewById(R.id.buttonMultiply);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        buttonEquals = (Button)findViewById(R.id.buttonEquals);
        buttonDot = (Button)findViewById(R.id.buttonDot);

        buttonShift = (Button)findViewById(R.id.buttonShift);
        buttonAC = (Button)findViewById(R.id.buttonAC);
        buttonDel = (Button)findViewById(R.id.buttonDel);

        buttonCos = (Button)findViewById(R.id.buttonCos);
        buttonSin = (Button)findViewById(R.id.buttonSin);
        buttonTan = (Button)findViewById(R.id.buttonTan);

        buttonCosh = (Button)findViewById(R.id.buttonCosh);
        buttonSinh = (Button)findViewById(R.id.buttonSinh);
        buttonTanh = (Button)findViewById(R.id.buttonTanh);

        buttonLog = (Button)findViewById(R.id.buttonLog);
        buttonLn = (Button)findViewById(R.id.buttonLn);

        buttonPow = (Button)findViewById(R.id.buttonPow);
        buttonPi = (Button)findViewById(R.id.buttonPi);

        buttonOpenBrackets = (Button)findViewById(R.id.buttonOpenBrackets);
        buttonCloseBrackets = (Button)findViewById(R.id.buttonCloseBracket);

        builder = new StringBuilder();

        isShifted = false;

        bracket = 0;

        justEntered = true;

        //Listeners for numeric buttons...
        try{button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(justEntered){
                    screen.setText("");
                    justEntered = false;
                }
                if(justPressedEqual){
                    screen.setText("");
                    justPressedEqual = false;
                }
                builder.append(0);
                screen.append("0");
            }
        });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(1);
                    screen.append("1");
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append("2");
                    screen.append("2");
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(3);
                    screen.append("3");
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(4);
                    screen.append("4");
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(5);
                    screen.append("5");
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(6);
                    screen.append("6");
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(7);
                    screen.append("7");
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(8);
                    screen.append("8");
                }
            });
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    builder.append(9);
                    screen.append("9");
                }
            });

            //Listeners for operators
            buttonPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        screen.append(String.valueOf(resultNum));
                        expressionList.add(String.valueOf(resultNum));
                        screenList.add(String.valueOf(resultNum));
                        justPressedEqual = false;
                    }
                    //Ensure previous element is not an operator
                    if(CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        expressionList.add("+");
                        screenList.add("+");
                        screen.append("+");
                    }
                }
            });
            buttonMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        screen.append(String.valueOf(resultNum));
                        expressionList.add(String.valueOf(resultNum));
                        screenList.add(String.valueOf(resultNum));
                    }
                    //Ensure previous element is not an operator
                    if(canAddMinus()){
                        if(builder.length() != 0 && !justPressedEqual){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                            expressionList.add("-");
                            screenList.add("-");
                            screen.append("-");
                        }else if(justPressedEqual){
                            screen.append("-");
                            expressionList.add("-");
                            screenList.add("-");
                            justPressedEqual = false;
                        } else{
                            builder.append("-");
                            screen.append("-");
                        }
                    }
                }
            });
            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        screen.append(String.valueOf(resultNum));
                        expressionList.add(String.valueOf(resultNum));
                        screenList.add(String.valueOf(resultNum));
                        justPressedEqual = false;
                    }
                    //Ensure previous element is not an operator
                    if(CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        expressionList.add("x");
                        screenList.add("x");
                        screen.append("x");
                    }
                }
            });
            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        screen.append(String.valueOf(resultNum));
                        expressionList.add(String.valueOf(resultNum));
                        screenList.add(String.valueOf(resultNum));
                        justPressedEqual = false;
                    }
                    //Ensure previous element is not an operator
                    if(CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        expressionList.add("÷");
                        screenList.add("÷");
                        screen.append("÷");
                    }
                }
            });
            buttonDot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(canAddDot()){
                        if(justPressedEqual){
                            screen.setText("");
                            justPressedEqual = false;
                        }
                        if(builder.length() == 0 || (builder.length() == 1 && builder.charAt(0) == '-')){
                            builder.append(0);
                            screen.append("0");
                        }
                        builder.append(".");
                        screen.append(".");
                    }
                }
            });

            buttonEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                    }
                    if(expressionList.size() == 18){
                        if(expressionList.contains("-0")){
                            StringBuilder listBuilder = new StringBuilder();
                            for(int index = 0; index < expressionList.size(); index ++){
                                listBuilder.append(expressionList.get(index));
                            }
                            if(listBuilder.toString().equals("((((-0)((((-0)))))))")){
                                screen.setText("");

                                try{
                                    File path = getApplicationContext().getFilesDir();
                                    File file = new File(path, "anville_calculator_errors.err");
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    byte[] data = new byte[1024];
                                    while(fileInputStream.read(data) != -1){
                                        screen.append(new String(data));
                                        data = new byte[1024];
                                    }
                                }catch(Exception ex){
                                    result.setText("Sorry, couldn't load error file!!, Please restart the calculator");
                                }
                            }
                        }
                    }
                    if(CanAddOperator() && bracket == 0 && !expressionList.isEmpty()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        resultNum = evaluateList(expressionList);
                        setResultScreen();
                        expressionList = new ArrayList<String>();
                        screenList = new ArrayList<String>();
                        builder = new StringBuilder();
                        justPressedEqual = true;
                    }else if(!(builder.length() == 0) && expressionList.isEmpty()){
                        resultNum = Double.parseDouble(builder.toString());
                        setResultScreen();
                        builder = new StringBuilder();
                        justPressedEqual = true;
                    } else{
                        if(!(bracket == 0)){
                            Toast.makeText(MainActivity.this, "Too less closing brackets!", Toast.LENGTH_SHORT).show();
                        }else if(expressionList.isEmpty()){
                            Toast.makeText(MainActivity.this, "Input empty!", Toast.LENGTH_SHORT).show();
                            result.setText(String.valueOf(resultNum));
                        }
                        else if(!CanAddOperator()){
                            Toast.makeText(MainActivity.this, "Operator or Dot at terminal position!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("cos");
                            screenList.add("cos");
                            screen.append("cos");
                        }
                        else{
                            expressionList.add("cos^-1");
                            screenList.add("cos^-1");
                            screen.append("cos^-1");
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });

            //Trigonometric ratios
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("sin");
                            screenList.add("sin");
                            screen.append("sin");
                        }
                        else{
                            expressionList.add("sin^-1");
                            screenList.add("sin^-1");
                            screen.append("sin^-1");
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });
            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("tan");
                            screenList.add("tan");
                            screen.append("tan");
                        }
                        else{
                            expressionList.add("tan^-1");
                            screenList.add("tan^-1");
                            screen.append("tan^-1");
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });


            buttonCosh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("cosh");
                            screenList.add("cosh");
                            screen.append("cosh");
                            expressionList.add("(");
                            screenList.add("(");
                            screen.append("(");
                            bracket++;
                        }
                        else{
                            Toast.makeText( MainActivity.this, "Don't use this yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            buttonSinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("sinh");
                            screenList.add("sinh");
                            screen.append("sinh");
                            expressionList.add("(");
                            screenList.add("(");
                            screen.append("(");
                            bracket++;
                        }
                        else{
                            Toast.makeText( MainActivity.this, "Don't use this yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            buttonTanh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("tanh");
                            screenList.add("tanh");
                            screen.append("tanh");
                            expressionList.add("(");
                            screenList.add("(");
                            screen.append("(");
                            bracket++;
                        }
                        else{
                            Toast.makeText( MainActivity.this, "Don't use this yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            //Logarithms...
            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("log");
                            screenList.add("log");
                            screen.append("log");
                        }
                        else{
                            expressionList.add("10");
                            expressionList.add("^");
                            screenList.add("10");
                            screenList.add("^");
                            screen.append("10");
                            screen.append("^");
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });
            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(!(builder.length() == 0)){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("ln");
                            screenList.add("ln");
                            screen.append("ln");
                        }
                        else {
                            expressionList.add("2.7182818284590452353602874713527");
                            expressionList.add("^");
                            screenList.add("e");
                            screenList.add("^");
                            screen.append("e");
                            screen.append("^");
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });

            //Power button ---> x^y , and π
            buttonPow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("^");
                            screenList.add("^");
                            screen.append("^");
                        }
                        else{
                            expressionList.add("!");
                            screenList.add("!");
                            screen.append("!");
                        }
                    }
                }
            });
            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        if(!isShifted){
                            expressionList.add("3.141592653589793238462643383279502884197");
                            screenList.add("π");
                            screen.append("π");
                        }
                        else{
                            expressionList.add("2.7182818284590452353602874713527");
                            screenList.add("e");
                            screen.append("e");
                        }
                    }
                }
            });

            //Shift button
            buttonShift.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    setShiftableButtonsText();
                }
            });

            buttonOpenBrackets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(canAddDot() || CanAddOperator()){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        expressionList.add("(");
                        screenList.add("(");
                        screen.append("(");
                        bracket++;
                    }
                }
            });
            buttonCloseBrackets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if((CanAddOperator()) && (bracket != 0)){
                        if(builder.length() != 0){
                            expressionList.add(builder.toString());
                            screenList.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        expressionList.add(")");
                        screenList.add(")");
                        screen.append(")");
                        bracket--;
                    }
                }
            });

            //Listeners for AC and DEL buttons
            buttonAC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    screen.setText("");
                    result.setText("");
                    expressionList.clear();
                    screenList.clear();
                    builder = new StringBuilder();
                    bracket = 0;
                    resultNum = 0d;
                    justPressedEqual = false;
                    Toast.makeText(MainActivity.this, "All cleared!!!", Toast.LENGTH_SHORT).show();
                }
            });
            buttonDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(justEntered){
                        screen.setText("");
                        justEntered = false;
                    }
                    if(justPressedEqual){
                        screen.setText("");
                        justPressedEqual = false;
                    }
                    if(!expressionList.isEmpty() || builder.length() != 0){
                        //if builder is not empty,modify builder instead...
                        if(builder.length() != 0){
                            builder.deleteCharAt(builder.length() - 1);
                        }else if(!expressionList.isEmpty()){
                            //in deletion, the increment and decrement of bracket is reverse...
                            if(expressionList.get(expressionList.size() - 1).equals(")")){
                                bracket ++;
                            }else if(expressionList.get(expressionList.size() - 1).equals("(")){
                                bracket --;
                            }
                            expressionList.remove(expressionList.size() - 1);
                            screenList.remove(screenList.size() - 1);
                        }
                        if(!expressionList.isEmpty() && builder.length() == 0){
                            if(isNumber(expressionList.get(expressionList.size() - 1))){
                                builder = new StringBuilder(expressionList.get(expressionList.size() - 1));
                                expressionList.remove(expressionList.size() - 1);
                                screenList.remove(screenList.size() - 1);
                            }
                        }
                        //Update Calculator screen after deleting an element...
                        screen.setText("");
                        for(int index = 0; index < screenList.size(); index++){
                            screen.append(screenList.get(index));
                        }
                        screen.append(builder.toString());
                    }
                }
            });
        }catch(Exception e){
            //turning the exception to string before writting to file; method acquired from programmiz.com
            result.setText("Sorry, an error occurred! logging error to file...");
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String error = stringWriter.toString();
            try{
                File path = getApplicationContext().getFilesDir();
                File file = new File(path, "anville_calculator_errors.err");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(error.getBytes());
            }catch(Exception ex){
                result.setText("Sorry, couldn't log error to file!!, Please restart the calculator");
            }
        }
    }

    private boolean isNumber(String input){
        try{
            Double value = Double.valueOf(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private void setShiftableButtonsText(){
        if(!isShifted){
            isShifted = true;
            buttonShift.setText(R.string.shifted);

            buttonCos.setText(R.string.cos_inverse);
            buttonSin.setText(R.string.sin_inverse);
            buttonTan.setText(R.string.tan_inverse);

            buttonCosh.setText(R.string.cos_h_inverse);
            buttonSinh.setText(R.string.sin_h_inverse);
            buttonTanh.setText(R.string.tan_h_inverse);

            buttonLog.setText(R.string.antilog);
            buttonLn.setText(R.string.antiln);

            buttonPow.setText(R.string.factorial);
            buttonPi.setText(R.string.e);
        }
        else{
            isShifted = false;
            buttonShift.setText(R.string.shift);

            buttonCos.setText(R.string.cosine);
            buttonSin.setText(R.string.sine);
            buttonTan.setText(R.string.tangent);

            buttonCosh.setText(R.string.cos_h);
            buttonSinh.setText(R.string.sin_h);
            buttonTanh.setText(R.string.tan_h);

            buttonLog.setText(R.string.log);
            buttonLn.setText(R.string.ln);

            buttonPow.setText(R.string.power);
            buttonPi.setText(R.string.pi);
        }
    }

    private Double evaluate(List<String> inputList) {
        // logarithms
        while (inputList.contains("ln")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("ln") + 1));
            inputList.set(inputList.indexOf("ln") + 1, String.valueOf(Math.log(number)));
            inputList.remove("ln");
        }
        while (inputList.contains("log")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("log") + 1));
            inputList.set(inputList.indexOf("log") + 1, String.valueOf(Math.log(number) / 2.302585093));
            inputList.remove("log");
        }
        // cosines
        while (inputList.contains("cos")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("cos") + 1)) * 3.141592653589793238462643383279502884197 / 180;
            inputList.set(inputList.indexOf("cos") + 1, String.valueOf(Math.cos(number)));
            inputList.remove("cos");
        }
        // sines
        while (inputList.contains("sin")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("sin") + 1)) * 3.141592653589793238462643383279502884197 / 180;
            inputList.set(inputList.indexOf("sin") + 1, String.valueOf(Math.sin(number)));
            inputList.remove("sin");
        }
        // tangents
        while (inputList.contains("tan")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("tan") + 1)) * 3.141592653589793238462643383279502884197 / 180;
            inputList.set(inputList.indexOf("tan") + 1, String.valueOf(Math.tan(number)));
            inputList.remove("tan");
        }
        // cosh
        while (inputList.contains("cosh")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("cosh") + 1)) * 3.141592653589793238462643383279502884197 / 180;
            inputList.set(inputList.indexOf("cosh") + 1, String.valueOf(Math.cosh(number)));
            inputList.remove("cosh");
        }
        // sinh
        while (inputList.contains("sinh")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("sinh") + 1)) * 3.141592653589793238462643383279502884197 / 180;
            inputList.set(inputList.indexOf("sinh") + 1, String.valueOf(Math.sinh(number)));
            inputList.remove("sinh");
        }
        // tanh
        while (inputList.contains("tanh")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("tanh") + 1)) * 3.141592653589793 / 180;
            inputList.set(inputList.indexOf("tanh") + 1, String.valueOf(Math.tanh(number)));
            inputList.remove("tanh");
        }

        // cos-inverse
        while (inputList.contains("cos^-1")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("cos^-1") + 1));
            inputList.set(inputList.indexOf("cos^-1") + 1,
                    String.valueOf(Math.acos(number) * 180 / 3.141592653589793238462643383279502884197));
            inputList.remove("cos^-1");
        }
        // sin-inverse
        while (inputList.contains("sin^-1")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("sin^-1") + 1));
            inputList.set(inputList.indexOf("sin^-1") + 1,
                    String.valueOf(Math.asin(number) * 180 / 3.141592653589793238462643383279502884197));
            inputList.remove("sin^-1");
        }
        // tan-inverse
        while (inputList.contains("tan^-1")) {
            double number = Double.parseDouble(inputList.get(inputList.indexOf("tan^-1") + 1));
            inputList.set(inputList.indexOf("tan^-1") + 1,
                    String.valueOf(Math.atan(number) * 180 / 3.141592653589793238462643383279502884197));
            inputList.remove("tan^-1");
        }
        // factorial
        while (inputList.contains("!")) {
            Integer number = Integer.valueOf(inputList.get(inputList.indexOf("!") - 1));
            inputList.set(inputList.indexOf("!") - 1, String.valueOf(factorial(number)));
            inputList.remove("!");
        }
        //power
        while(inputList.contains("^")){
            int index = inputList.indexOf("^");
            Double firstOperand = Double.valueOf(inputList.get(index - 1));
            double secondOperand = Double.parseDouble(inputList.get(index + 1));
            firstOperand = Math.pow(firstOperand, secondOperand);
            inputList.set(index - 1, String.valueOf(firstOperand));
            inputList.remove(index + 1);
            inputList.remove("^");
        }
        // Check for implicit multiplications e.g (90)(2) = 180
        for (int index = 0; index < inputList.size() - 1; index++) {
            if (isNumber(inputList.get(index))) {
                while(isNumber(inputList.get(index + 1))){
                    inputList.set(index, String.valueOf(
                            Double.parseDouble(inputList.get(index)) * Double.parseDouble(inputList.get(index + 1))));
                    inputList.remove(index + 1);
                    if(inputList.size() <= 1 || index == inputList.size() - 1){
                        break;
                    }
                }
            }
        }
        // division
        while (inputList.contains("÷")) {
            int index = inputList.indexOf("÷");
            double firstOperand = Double.parseDouble(inputList.get(index - 1));
            double secondOperand = Double.parseDouble(inputList.get(index + 1));
            firstOperand = firstOperand / secondOperand;
            inputList.set(index - 1, String.valueOf(firstOperand));
            inputList.remove(index + 1);
            inputList.remove("÷");
        }
        while(inputList.contains("")){
            inputList.remove("");
        }
        // multiplication
        while (inputList.contains("x")) {
            int index = inputList.indexOf("x");
            double firstOperand = Double.parseDouble(inputList.get(index - 1));
            double secondOperand = Double.parseDouble(inputList.get(index + 1));
            firstOperand = firstOperand * secondOperand;
            inputList.set(index - 1, String.valueOf(firstOperand));
            inputList.remove(index + 1);
            inputList.remove("x");
        }
        // Check for implicit AGAIN multiplications e.g (90)(2) = 180
        for (int index = 0; index < inputList.size() - 1; index++) {
            if (isNumber(inputList.get(index))) {
                while(isNumber(inputList.get(index + 1))){
                    inputList.set(index, String.valueOf(
                            Double.parseDouble(inputList.get(index)) * Double.parseDouble(inputList.get(index + 1))));
                    inputList.remove(index + 1);
                    if(inputList.size() <= 1 || index == inputList.size() - 1){
                        break;
                    }
                }
            }
        }
        // addition
        while (inputList.contains("+")) {
            int index = inputList.indexOf("+");
            double firstOperand = Double.parseDouble(inputList.get(index - 1));
            double secondOperand = Double.parseDouble(inputList.get(index + 1));
            firstOperand = firstOperand + secondOperand;
            inputList.set(index - 1, String.valueOf(firstOperand));
            inputList.remove(index + 1);
            inputList.remove("+");
        }
        // subtraction
        while (inputList.contains("-")) {

            int index = inputList.indexOf("-");
            double firstOperand = Double.parseDouble(inputList.get(index - 1));
            double secondOperand = Double.parseDouble(inputList.get(index + 1));
            firstOperand = firstOperand - secondOperand;
            inputList.set(index - 1, String.valueOf(firstOperand));
            inputList.remove(index + 1);
            inputList.remove("-");
        }
        return Double.parseDouble(inputList.get(0));
    }
    private Double evaluateList(List<String> inputList) {
        try{
            while (inputList.contains("(")) {
                int start = inputList.lastIndexOf("(");
                int size = inputList.size();
                int stop = start
                        + inputList.subList(inputList.lastIndexOf("("), inputList.size()).indexOf(")");
                inputList.set(start, String.valueOf(evaluate(inputList.subList(start + 1, stop))));
                for (int index = start; index <= stop - (size - inputList.size()); index++) {
                    inputList.remove(start + 1);
                }
            }
            return evaluate(inputList);
        }catch(Exception e){
            //turning the exception to string before writting to file; method acquired from programmiz.com
            screen.setTextSize(25f);
            screen.setTextColor(Color.RED);
            screen.setText("Sorry, an error occurred! logging error to file...");
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String error = stringWriter.toString();
            try{
                File path = getApplicationContext().getFilesDir();
                File file = new File(path, "anville_calculator_errors.err");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(error.getBytes());
            }catch(Exception ex){
                screen.setText("Sorry, couldn't log error to file!!, Please restart the calculator");
            }
        }
        screen.append("...Logging done. Austine will take a look at it! please restart Calculator");
        //I was forced to provide a return statement regardless of the try-catch block above...
        return 0.0;
    }

    private Integer factorial(Integer number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    private boolean canAddDot(){
        return builder.length() != 0 && builder.indexOf(".") < 0 || builder.length() == 0;
    }

    private boolean CanAddOperator(){
        if(!expressionList.isEmpty()){
            return (builder.length() != 0 && builder.charAt(builder.length() - 1) != '.') || (builder.length() == 0 && (isNumber(expressionList.get(expressionList.size() - 1)) || expressionList.get(expressionList.size() - 1).equals(")") || expressionList.get(expressionList.size() - 1).equals("!")));
        }else{
            return builder.length() != 0;
        }
    }

    private boolean canAddMinus(){
        if(!expressionList.isEmpty()){
            return (!expressionList.get(expressionList.size() - 1).equals("-") && builder.length() == 0) || builder.length() != 0;
        }else{
            return true;
        }
    }
    private void setResultScreen(){
        //if it is below 0.001, we must avoid the E scientific notation...
        result.setText("");
        if(resultNum < 0.001 && String.valueOf(resultNum).contains("E")){
            StringBuilder wholePortion = new StringBuilder(String.valueOf(resultNum));
            StringBuilder firstPortion = new StringBuilder(wholePortion.substring(0, wholePortion.indexOf("E")));
            StringBuilder lastPortion = new StringBuilder(wholePortion.substring(wholePortion.indexOf("E"), wholePortion.length()));
            //Delete "E" and "-" from last portion so as to use in appending result...
            for(int index = 0; index <= 1; index++){
                lastPortion.deleteCharAt(0);
            }
            result.append("0.");
            //appending the zeros
            for(int index = 0; index < Integer.parseInt(lastPortion.toString()); index++){
                result.append("0");
            }
            //remove the dot in first portion
            firstPortion.deleteCharAt(firstPortion.indexOf("."));
            //adding the significant part of the number...
            result.append(firstPortion.toString());
        }else if(resultNum > 10000000){
            if(String.valueOf(resultNum).contains("E")){
                StringBuilder wholePortion = new StringBuilder(String.valueOf(resultNum));
                StringBuilder firstPortion = new StringBuilder(wholePortion.substring(0, wholePortion.indexOf("E")));
                StringBuilder lastPortion = new StringBuilder(wholePortion.substring(wholePortion.indexOf("E"), wholePortion.length()));
                //remove "E" from second portion...
                lastPortion.deleteCharAt(0);
                result.append("10^");
                result.append(lastPortion.toString());
                result.append("x ");
                result.append(firstPortion.toString());
            }else{
                result.setText(String.valueOf(resultNum));
            }
        }else{
            result.setText(String.valueOf(resultNum));
        }
    }
}