package com.armin.mehraein.mazegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity{

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14,
    btn_15, btn_16, btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25;
    int number_first = 1 , number_end = 25 , number_current = 0;
    Button btn_start , btn_up , btn_dowm , btn_left , btn_right , btn_block , btn_win ;
    Stack<Integer> whole = new Stack<>();
    Stack<Integer> way = new Stack<>();
    TextView show ;
    int joon = 3 ;
    Button joon1 , joon2 , joon3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btn_left.setVisibility(View.INVISIBLE);
        btn_right.setVisibility(View.INVISIBLE);
        btn_up.setVisibility(View.INVISIBLE);
        btn_dowm.setVisibility(View.INVISIBLE);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGame();
                Button button = returnView(number_first);
                button.setText("شروع");
                button.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorGreen));
                Button button1 = returnView(number_end);
                button1.setText("پایان");
                button1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorBlue));
                playGame(number_first);
                btn_start.setClickable(false);
                btn_left.setVisibility(View.VISIBLE);
                btn_right.setVisibility(View.VISIBLE);
                btn_up.setVisibility(View.VISIBLE);
                btn_dowm.setVisibility(View.VISIBLE);
            }
        });
        btn_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("بازی رو شروع کن");
                for (int i=1 ; i<26 ; i++){
                    Button button = returnView(i);
                    button.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    button.setText("☐");
                }
                whole.clear();
                way.clear();
                btn_start.setClickable(true);
                btn_win.setVisibility(View.INVISIBLE);
                joon3.setText("جون 3");
                joon3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                joon2.setText("جون 2");
                joon2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                joon1.setText("جون 1");
                joon1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
            }
        });
        btn_dowm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(number_current + 5);
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(number_current - 1);
            }
        });
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(number_current - 5);
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(number_current + 1);
            }
        });
        btn_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joon--;
                if (joon < 0){
                    btn_win.setVisibility(View.VISIBLE);
                    btn_left.setVisibility(View.GONE);
                    btn_right.setVisibility(View.GONE);
                    btn_up.setVisibility(View.GONE);
                    btn_dowm.setVisibility(View.GONE);
                    btn_block.setVisibility(View.GONE);
                    show.setText("تو باختی !!");
                    return;
                }else {
                    setJoon(joon);
                }
                int number = way.pop();
                Button button = returnView(number);
                button.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorOrange));
                button.setText("نادرست");
                while (number != 0){
                    number = way.pop();
                    if (number != 0) {
                        Button button1 = returnView(number);
                        button1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorOrange));
                        button1.setText("نادرست");
                    }
                }
                btn_block.setVisibility(View.INVISIBLE);
                //Toast.makeText(MainActivity.this, "Number ="+way.pop(), Toast.LENGTH_SHORT).show();
                playGame(way.pop());

            }
        });
    }

    private void setGame(){
        setWall(2);
        setWall(4);
        setWall(11);
        setWall(12);
        setWall(2);
        setWall(14);
        setWall(17);
        setWall(24);
    }

    private void initView(){
        joon1 = findViewById(R.id.joo1);
        joon2 = findViewById(R.id.joo2);
        joon3 = findViewById(R.id.joo3);
        show = findViewById(R.id.show);
        btn_win = findViewById(R.id.btn_win);
        btn_block = findViewById(R.id.btn_block);
        btn_right = findViewById(R.id.btn_right);
        btn_left = findViewById(R.id.btn_left);
        btn_up = findViewById(R.id.btn_up);
        btn_dowm = findViewById(R.id.btn_down);
        btn_start = findViewById(R.id.btn_start);
        btn_1  = findViewById(R.id.btn_1 );
        btn_2  = findViewById(R.id.btn_2 );
        btn_3  = findViewById(R.id.btn_3 );
        btn_4  = findViewById(R.id.btn_4 );
        btn_5  = findViewById(R.id.btn_5 );
        btn_6  = findViewById(R.id.btn_6 );
        btn_7  = findViewById(R.id.btn_7 );
        btn_8  = findViewById(R.id.btn_8 );
        btn_9  = findViewById(R.id.btn_9 );
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_13 = findViewById(R.id.btn_13);
        btn_14 = findViewById(R.id.btn_14);
        btn_15 = findViewById(R.id.btn_15);
        btn_16 = findViewById(R.id.btn_16);
        btn_17 = findViewById(R.id.btn_17);
        btn_18 = findViewById(R.id.btn_18);
        btn_19 = findViewById(R.id.btn_19);
        btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21);
        btn_22 = findViewById(R.id.btn_22);
        btn_23 = findViewById(R.id.btn_23);
        btn_24 = findViewById(R.id.btn_24);
        btn_25 = findViewById(R.id.btn_25);
    }

    private Button returnView(int numner){
        switch (numner){
            case 1 :return btn_1 ;
            case 2 :return btn_2 ;
            case 3 :return btn_3 ;
            case 4 :return btn_4 ;
            case 5 :return btn_5 ;
            case 6 :return btn_6 ;
            case 7 :return btn_7 ;
            case 8 :return btn_8 ;
            case 9 :return btn_9 ;
            case 10:return btn_10;
            case 11:return btn_11;
            case 12:return btn_12;
            case 13:return btn_13;
            case 14:return btn_14;
            case 15:return btn_15;
            case 16:return btn_16;
            case 17:return btn_17;
            case 18:return btn_18;
            case 19:return btn_19;
            case 20:return btn_20;
            case 21:return btn_21;
            case 22:return btn_22;
            case 23:return btn_23;
            case 24:return btn_24;
            case 25:return btn_25;
            default:return null;
        }
    }

    private void setWall(int number){
        Button button = returnView(number);
        button.setText("دیوار");
        button.setTextColor(ContextCompat.getColor(this,R.color.colorBrown));
    }

    private void playGame(int number){

        int count = 0 ;
        boolean isWay = false ;

        if (number == number_end){
            btn_win.setVisibility(View.VISIBLE);
            btn_left.setVisibility(View.GONE);
            btn_right.setVisibility(View.GONE);
            btn_up.setVisibility(View.GONE);
            btn_dowm.setVisibility(View.GONE);
            btn_block.setVisibility(View.GONE);
            show.setText("تو به مقصد رسیدی");
            return;
        }
        whole.push(number);
        way.push(number);
        number_current = number ;
        Button button  = returnView(number);
        button.setTextColor(ContextCompat.getColor(this, R.color.colorGreen));
        button.setText("ردپا");

        int up = number - 5 ;
        if (validtion(up)){
            btn_up.setClickable(true);
            btn_up.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
            button.setText("ردپا");
            isWay = true ;
            count++ ;

        }else {
            btn_up.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
            btn_up.setClickable(false);
        }

        int left = number - 1 ;
        if (left == 0 || left == 5 || left == 10 || left == 15 || left == 20){
            btn_left.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
            btn_left.setClickable(false);
        }else{
            if (validtion(left)){
                btn_left.setClickable(true);
                btn_left.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                button.setText("ردپا");
                isWay = true ;
                count++ ;

            }else {
                btn_left.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                btn_left.setClickable(false);
            }
        }


        int down = number + 5 ;
        if (validtion(down)){
            btn_dowm.setClickable(true);
            btn_dowm.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
            button.setText("ردپا");
            isWay = true ;
            count++ ;

        }else {
            btn_dowm.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
            btn_dowm.setClickable(false);
        }

        int right = number + 1 ;
        if (right == 6 || right == 11 || right == 16 || right == 21){
            btn_right.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
            btn_right.setClickable(false);
        }else {
            if (validtion(right)){
                btn_right.setClickable(true);
                btn_right.setBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen));
                button.setText("ردپا");
                isWay = true ;
                count++ ;

            }else {
                btn_right.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
                btn_right.setClickable(false);
            }
        }



        if (count > 1){
            for (int i=0 ; i<count ; i++) {
                way.push(0);
                if (i != count-1) {
                    way.push(number);
                }
            }
            show.setText("به چندراهی رسیدی");
        }else {
            show.setText("یک مسیر وجود داره");
        }

        if (!isWay){
            btn_block.setVisibility(View.VISIBLE);
            btn_block.setClickable(true);
            show.setText("خوردی به بن بست");
        }

        if (number == number_first){
            button.setText("شروع");
        }

    }

    private void setJoon(int joon) {
        switch (joon){
            case 2 : joon3.setText("مصرف");
                joon3.setTextColor(ContextCompat.getColor(this, R.color.colorRed));break;
            case 1 : joon2.setText("مصرف");
                joon2.setTextColor(ContextCompat.getColor(this, R.color.colorRed));break;
            case 0 : joon1.setText("مصرف");
                joon1.setTextColor(ContextCompat.getColor(this, R.color.colorRed));break;
        }
    }

    private boolean validtion(int number){
        if (whole.contains(number)){
            return false ;
        }else
        if (number <= 0){
            return false;
        }else if (number > 25){
            return false;
        }else if (number == 2 || number == 4 || number == 11 || number == 12 || number == 14 || number == 17 || number == 24){
            return false;
        }else {
            return true;
        }
    }
}
