package com.khanappsnj.todoshazadaedition

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.khanappsnj.todoshazadaedition.databinding.NoteDetailBinding

class NoteDetailActivity : AppCompatActivity() {

    private lateinit var binding: NoteDetailBinding
    lateinit var saveButton: Button
    lateinit var titleEditText: EditText
    lateinit var noteBodyEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = NoteDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        saveButton = binding.SaveButton
        titleEditText = binding.TitleEditEditView
        noteBodyEditText = binding.NoteEditEditView

        saveButton.setOnClickListener{
            val title = titleEditText.text.toString()
            val body = titleEditText.text.toString()
            NotesList.notes.add(Note(title,body))
            val intent = Intent(this, MainActivity::class.java)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}