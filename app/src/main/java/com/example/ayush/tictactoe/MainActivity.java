package com.example.ayush.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int c=1;
    boolean winner=false;
    int marker=0;
    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int arr[]={2,2,2,2,2,2,2,2,2};
    RelativeLayout relativeLayout;
    GridLayout gridLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        gridLayout=findViewById(R.id.gridLayout);
        relativeLayout=findViewById(R.id.rl);
        relativeLayout.setVisibility(View.GONE);
    }
    protected void play(View view){
        Intent intent=new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }
    protected void finish(View view){
        finish();
    }
    protected void drop(View view){
        ImageView view1=(ImageView)view;
        int tag=Integer.parseInt(view1.getTag().toString());
        // view1.setImageResource(R.drawable.cross);
        if(arr[tag]==2) {
            view1.setTranslationY(-1000f);
            view1.setTranslationX(-1000f);
            if (c % 2 != 0 && !winner) {
                marker = 1;//cross
                view1.setImageResource(R.drawable.cross);
            } else if (c % 2 == 0 && !winner) {
                marker = 0;//circle
                view1.setImageResource(R.drawable.circle);
            }

            view1.animate().translationXBy(1000f).translationYBy(1000f).rotationBy(1800).setDuration(200);

            c++;


            //view1.setOnClickListener(null);
            System.out.println(tag);
            arr[tag] = marker;
            if (c >= 4) {
                for (int b[] : winningPositions) {
                    if (arr[b[0]] == arr[b[1]] && arr[b[1]] == arr[b[2]] && arr[b[0]] != 2) {
                        if (arr[b[0]] == 0) {
                            textView.setText("\n Circle wins");
                            winner = true;
                            view1.setOnClickListener(null);
                            relativeLayout.setVisibility(View.VISIBLE);
                            gridLayout.setAlpha(0.5f);
                        } else if (arr[b[0]] == 1) {
                            textView.setText("\n Cross wins");
                            winner = true;
                            relativeLayout.setVisibility(View.VISIBLE);
                            gridLayout.setAlpha(0.5f);
                        }
                        // this.finish();

                    }
                }
            }

            if (c == 10) {
                relativeLayout.setVisibility(View.VISIBLE);
                winner = true;
            }
        }
    }

}
