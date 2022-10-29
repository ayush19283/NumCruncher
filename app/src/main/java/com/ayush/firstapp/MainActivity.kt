package com.ayush.firstapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.black)
            window.navigationBarColor=this.resources.getColor(R.color.black)
        }
        val tvOne: TextView = findViewById(R.id.tvOne)
        val tvTwo: TextView = findViewById(R.id.tvTwo)
        val tvThree: TextView = findViewById(R.id.tvThree)
        val tvFour: TextView = findViewById(R.id.tvFour)
        val tvFive: TextView = findViewById(R.id.tvFive)
        val tvSix: TextView = findViewById(R.id.tvSix)
        val tvSeven: TextView = findViewById(R.id.tvSeven)
        val tvEight: TextView = findViewById(R.id.tvEight)
        val tvNine: TextView = findViewById(R.id.tvNine)
        val tvZero: TextView = findViewById(R.id.tvZero)
        val tvResult: TextView = findViewById(R.id.tvResult)
        val tvExpression: TextView = findViewById(R.id.tvExpression)
        val tvMinus: TextView = findViewById(R.id.tvMinus)
        val tvEquals: TextView = findViewById(R.id.tvEquals)
        val tvDivide: TextView = findViewById(R.id.tvDivide)
        val tvClear: TextView = findViewById(R.id.tvClear)
        val tvBack: TextView = findViewById(R.id.tvBack)
        val tvDot: TextView = findViewById(R.id.tvDot)
        val tvMul: TextView = findViewById(R.id.tvMul)
        val tvPlus: TextView = findViewById(R.id.tvPlus)
        var plus=0;var sub=0;var div=0;var mul=0;var res=0;var calc=0
        val no = ArrayList<Int>()

        tvExpression.setText("")
        /*Number Buttons*/

        tvOne.setOnClickListener {
            tvExpression.append(" 1")
            no.add(1)
        }

        tvTwo.setOnClickListener {
            tvExpression.append(" 2")
            no.add(2)
        }

        tvThree.setOnClickListener {
            tvExpression.append(" 3")
            no.add(3)
        }
        tvFour.setOnClickListener {
            tvExpression.append(" 4")
            no.add(4)
        }

        tvFive.setOnClickListener {
            tvExpression.append(" 5")
            no.add(5)
        }

        tvSix.setOnClickListener {
            tvExpression.append(" 6")
            no.add(6)
        }

        tvSeven.setOnClickListener {
            tvExpression.append(" 7")
            no.add(7)
        }

        tvEight.setOnClickListener {
            tvExpression.append(" 8")
            no.add(8)
        }

        tvNine.setOnClickListener {
            tvExpression.append(" 9")
            no.add(9)
        }

        tvZero.setOnClickListener {
            tvExpression.append(" 0")
            no.add(0)
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            tvExpression.append(" +")
            plus=1
            calc=1
        }

        tvMinus.setOnClickListener {
            tvExpression.append(" -")
            sub=1
            calc=1
        }

        tvMul.setOnClickListener {
            tvExpression.append(" *")
            sub=1
            calc=1
        }

        tvDivide.setOnClickListener {
            tvExpression.append(" /")
            div=1
            calc=1
        }

        tvDot.setOnClickListener {
            tvExpression.append(" .")
        }

        tvClear.setOnClickListener {
           tvExpression.setText("")
        }

        tvEquals.setOnClickListener {
           if (no.size<2 && calc==0){
               print("nothing to process")
           }else{
               calc=0
               if (plus==1){

                  res = no.get(0)+no.get(1)
                   tvResult.text=res.toString()
               }else if(sub==1){
                   res = no.get(0)-no.get(1)
                   tvResult.text=res.toString()
               }else if(mul==1){
                   res=no.get(0)*no.get(1)
                   tvResult.text=res.toString()
               }
               else if(div==1){
                   res=no.get(0)/no.get(1)
                   tvResult.text=res.toString()
               }
               no.clear()
           }
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            val length=text.length-2
            if(text.isNotEmpty()) {
                tvExpression.text = text.slice(0..length).toString()
            }

            tvResult.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
//        if(clear) {
//            Result.text = ""
//            Expression.append(string)
//        } else {
//            Expression.append(Result.text)
//            Expression.append(string)
//            Result.text = ""
//        }
    }
}