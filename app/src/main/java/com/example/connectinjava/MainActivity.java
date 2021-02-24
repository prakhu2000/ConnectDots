package com.example.connectinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    var a= arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var n:Int = 0
    var winningpositions= arrayOf(intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8), intArrayOf(0,4,8),intArrayOf(2, 4, 6), intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8))

    var gameactive=true

    fun drop(view: View) {
        var img = view as ImageView
        var tapped = (img.getTag().toString()).toInt()

        if (a[tapped] == 2 && gameactive) {
            a[tapped] = n
            img.translationY = -1500f
            if (n == 0) {
                img.setImageResource(R.drawable.yellow)
                n = 1
            } else {
                img.setImageResource(R.drawable.red)
                n = 0
            }
            img.animate().translationYBy(1500f).rotation(3600f).setDuration(200L)
            for (winningpostion in winningpositions) {
                if (a[winningpostion[0]] == a[winningpostion[1]] && a[winningpostion[1]] == a[winningpostion[2]] && a[winningpostion[0]] != 2) {
                    gameactive=false
                    var msg: String
                    if (n == 1) {
                        msg = "yellow"
                    } else {
                        msg = "red"
                    }
                    var text=findViewById<TextView>(R.id.textView)
                            var button=findViewById<Button>(R.id.button)
                            text.setText("$msg has won")
                    text.visibility=View.VISIBLE
                    button.visibility=View.VISIBLE



                    //Toast.makeText(this, "$msg has won", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
    fun again(view: View){
        var text=findViewById<TextView>(R.id.textView)
                var button=findViewById<Button>(R.id.button)
                text.visibility=View.INVISIBLE
        button.visibility=View.INVISIBLE
        var gridlayout=findViewById<GridLayout>(R.id.grid)
        for (i in 0 until gridlayout.getChildCount()) {
            val img =  gridlayout.getChildAt(i) as ImageView
            img.setImageDrawable(null)

            // do stuff with child view
        }
//      for(i in a.indices){
//          a[i]=2
//      }
//      n = 0
//      gameactive=true
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}