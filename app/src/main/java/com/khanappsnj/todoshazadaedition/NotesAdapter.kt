package com.khanappsnj.todoshazadaedition

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NotesAdapter(val dataset: List<Note>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val view: View) : ViewHolder(view){
         var titleTv : TextView = view.findViewById(R.id.NoteTitle_tv)
         var editBtn : Button = view.findViewById(R.id.Edit_Button)

        init {
            editBtn.setOnClickListener {
                val intent = Intent()
                (view.context as AppCompatActivity).startActivityForResult(intent,124)
            }
        }

         var content : String = ""

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view  = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item,parent,false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = dataset[position]
        holder.titleTv.text = note.title
        holder.content = note.body
    }
}