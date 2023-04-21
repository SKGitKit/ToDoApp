package com.khanappsnj.todoshazadaedition

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.khanappsnj.todoshazadaedition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var notes_rv : RecyclerView
    lateinit var addNote_btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        Log.d("DataSet:","In Main Activity: List size is ${NotesList.notes.size}")
        addNote_btn = binding.AddNoteButton
        notes_rv = binding.NotesListRecycler
        addNote_btn = binding.AddNoteButton

        notes_rv.adapter = NotesAdapter(NotesList.notes)

        addNote_btn.setOnClickListener {
            val intent = Intent(this,NoteDetailActivity::class.java)
            startActivityForResult(intent,123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("DataSet:","Change called: List size is ${NotesList.notes.size}")
        if (resultCode == Activity.RESULT_OK){
            notes_rv.adapter?.notifyDataSetChanged()
        }

    }
}