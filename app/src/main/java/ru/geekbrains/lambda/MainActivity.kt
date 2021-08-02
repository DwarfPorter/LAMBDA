package ru.geekbrains.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import ru.geekbrains.lambda.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonPlus.setOnClickListener {
                operation(editArg1, editArg2) { a1, a2 ->
                    a1 + a2
                }
            }
            buttonMinus.setOnClickListener {
                operation(editArg1, editArg2) { a1, a2 -> a1 - a2 }
            }
            buttonDiv.setOnClickListener {
                operation(editArg1, editArg2) { a1, a2 -> a1 / a2 }
            }
            buttonMulti.setOnClickListener {
                operation(editArg1, editArg2) { a1, a2 -> funcMulti(a1, a2) }
            }
        }
    }

    private val funcMulti = { a1: Double, a2: Double -> a1 * a2 }

    private fun operation(arg1: EditText, arg2: EditText, operator: (Double, Double) -> Double) {
        val a1 = arg1.toDouble()
        val a2 = arg2.toDouble()
        val result = operator(a1, a2)
        binding.result.text = result.toString().myFormat(".0")
    }
}

fun EditText.toDouble(): Double {
    return this.text.toString().toDouble()
}

inline fun String.myFormat(subString: String): String{
    return this.replace(subString, "")
}

fun myFormat2(arg: String, subString: String): String{
    return arg.replace(subString, "")
}