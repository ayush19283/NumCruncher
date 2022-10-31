package com.ayush.firstapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

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
        var result=""


        tvExpression.setText("")
        /*Number Buttons*/

        tvOne.setOnClickListener {
            tvExpression.append("1")

        }

        tvTwo.setOnClickListener {
            tvExpression.append("2")
        }

        tvThree.setOnClickListener {
            tvExpression.append("3")
        }
        tvFour.setOnClickListener {
            tvExpression.append("4")
        }

        tvFive.setOnClickListener {
            tvExpression.append("5")
        }

        tvSix.setOnClickListener {
            tvExpression.append("6")
        }

        tvSeven.setOnClickListener {
            tvExpression.append("7")
        }

        tvEight.setOnClickListener {
            tvExpression.append("8")
        }

        tvNine.setOnClickListener {
            tvExpression.append("9")
        }

        tvZero.setOnClickListener {
            tvExpression.append("0")
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            tvExpression.append("+")

        }

        tvMinus.setOnClickListener {
            tvExpression.append("-")
        }

        tvMul.setOnClickListener {
            tvExpression.append("*")

        }

        tvDivide.setOnClickListener {
            tvExpression.append("/")

        }

        tvDot.setOnClickListener {
            tvExpression.append(".")
        }

        tvClear.setOnClickListener {
           tvExpression.setText("")
            tvResult.setText("")
        }

        tvEquals.setOnClickListener(){
            tvResult.setText("")
            val string=tvExpression.text.toString()
            var str=""
            try{
                 str= calculate(string)
            }
            catch(e: EmptyStackException){
                // caught and handles it
                Toast.makeText(this, "Invalid Syntax", Toast.LENGTH_SHORT).show()
            }
            catch (e:ArithmeticException){
                Toast.makeText(this, "Can not Divide by zero", Toast.LENGTH_SHORT).show()
            }

            tvResult.setText(str)
            tvExpression.setText("")
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            val length=text.length-1
            if(text.isNotEmpty()) {
                tvExpression.text = text.slice(0..length-1).toString()
            }

            tvResult.text = ""
        }
    }


    }
    fun calculate(s: String): String {
        return evaluatePostfix(infixToPostfix(s)).toString()
    }

    private fun rank(op: Char): Int {
        return when {
            op == '+' || op == '-' -> 1
            op == '*' || op == '/' -> 2
            else -> 0
        }
    }

    private fun infixToPostfix(infixExp: String): Queue<String> {
        val ans: Queue<String> = LinkedList()
        val stack: Stack<Char> = Stack()
        var i = 0
        val len = infixExp.length
        while (i < len) {
            val num = StringBuilder()
            while (i < len && infixExp[i].isDigit()) num.append(infixExp[i++])
            if (num.isNotEmpty()) ans.add(num.toString())
            if (i == len) break
            val ch = infixExp[i++]
            when {
                ch.isWhitespace() -> {}
                else -> {
                    while (stack.isNotEmpty() && rank(stack.peek()) >= rank(ch)) {
                        ans.add("${stack.pop()}")
                    }
                    stack.push(ch)
                }
            }
        }
        while (stack.isNotEmpty()) {
            ans.add("${stack.pop()}")
        }
        return ans
    }

    private fun evaluatePostfix(postfix: Queue<String>): Int {
        val stack: Stack<Long> = Stack()
        for (exp in postfix) {
            if (exp[0].isDigit())
                stack.push(exp.toLong())
            else {
                val b = stack.pop()
                val a = stack.pop()
                when (exp[0]) {
                    '+' -> stack.push(a + b)
                    '-' -> stack.push(a - b)
                    '*' -> stack.push(a * b)
                    else -> stack.push(a / b)
                }
            }
        }
        return stack.pop().toInt()
    }

