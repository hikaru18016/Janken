package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageView
import android.view.View
import java.util.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var  ImageChange = findViewById<ImageView>(R.id.MyHand)
        var Shape = 1;
        ImageChange.setOnClickListener{
                if(Shape==1){
                    MyHand.setImageResource(R.drawable.s)
                    Shape=2
                }else if(Shape==2) {
                    MyHand.setImageResource(R.drawable.p)
                    Shape=3
                }else if(Shape==3){
                    MyHand.setImageResource(R.drawable.r)
                    Shape=1
                }
        }
        var wincount=0
        var losecount=0
        OK.setOnClickListener {
            val random= Random()
            val OtherShape=random.nextInt(3)+1
            if(OtherShape==1){
                OtherHand.setImageResource(R.drawable.r)
            }else if(OtherShape==2) {
                OtherHand.setImageResource(R.drawable.s)
            }else if(OtherShape==3){
                OtherHand.setImageResource(R.drawable.p)
            }
            if (Shape == 1) {
                if (OtherShape == 2) {
                    Result.setText("あなたの勝ちです")
                    wincount++
                } else if (OtherShape == 3) {
                    Result.setText("あなたの負けです")
                    losecount++
                } else {
                    Result.setText("あいこです")
                }
            } else if (Shape == 2) {
                if (OtherShape == 3) {
                    Result.setText("あなたの勝ちです")
                    wincount++
                } else if (OtherShape == 1) {
                    Result.setText("あなたの負けです")
                    losecount++
                } else {
                    Result.setText("あいこです")
                }
            } else if (Shape == 3) {
                if (OtherShape == 1) {
                    Result.setText("あなたの勝ちです")
                    wincount++
                } else if (OtherShape == 2) {
                    Result.setText("あなたの負けです")
                    losecount++
                } else {
                    Result.setText("あいこです")
                }
            }
            MyWin.setText("勝ち数:" + wincount)
            OtherWin.setText("勝ち数:" + losecount)
            if (wincount == 3) {
                OK.visibility=View.INVISIBLE
            } else if (losecount == 3) {
                OK.visibility=View.INVISIBLE
            }
        }
    }

}