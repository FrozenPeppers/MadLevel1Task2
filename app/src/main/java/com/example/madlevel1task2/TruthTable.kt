package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityTruthTableBinding

class TruthTable : AppCompatActivity() {

    private lateinit var binding: ActivityTruthTableBinding
    private var answers: HashMap<String, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTruthTableBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
    }


    private fun initView() {
        binding.btnAnswer.setOnClickListener { submitAnswer() }
        setAnswersHashMap()
    }


    private fun submitAnswer() {
        if (checkAnswers()) {
            showToast("Correct!")
        } else {
            showToast("Incorrect!")
        }
    }


    private fun checkAnswers(): Boolean {

        if (binding.editTextTT.text.toString() == answers["TT"] &&
            binding.editTextTF.text.toString() == answers["TF"] &&
            binding.editTextFT.text.toString() == answers["FT"] &&
            binding.editTextFF.text.toString() == answers["FF"]
        ) {
            return true
        }
        return false
    }


    private fun showToast(message: String) {
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, message, duration)
        toast.show()
    }


    private fun setAnswersHashMap() {
        answers["TT"] = "T"
        answers["TF"] = "F"
        answers["FT"] = "F"
        answers["FF"] = "F"
    }
}