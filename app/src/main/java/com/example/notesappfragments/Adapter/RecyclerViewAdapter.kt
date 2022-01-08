package com.example.notesappfragments.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappfragments.Activity.EditNoteFragment
import com.example.notesappfragments.Activity.HomeFragment
import com.example.notesappfragments.Activity.HomeFragmentDirections
import com.example.notesappfragments.Model.Note
import com.example.notesappfragments.R
import com.example.notesappfragments.databinding.ItemRowBinding

class RecyclerViewAdapter(private  val fragment:HomeFragment): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    private var notesList = listOf<Note>()
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = notesList[position]
        holder.binding.apply {
            notesTitle.text = note.title
            notesSubTitle.text = note.subTitle
            noteDescription.text = note.noteDescription
            notesDate.text = note.date


//            ivUpdate.setOnClickListener {
//                with(fragment.sharedPreferences.edit()) {
//                    putString("NoteId", note.pk.toString())
//                    putString("NoteTitle", note.title)
//                    putString("SubTitle",note.subTitle)
//                    putString("noteDescription",note.noteDescription)
//                    putString("NoteDate",note.date)
//                    apply()
//                }
//                fragment.findNavController().navigate(R.id.action_homeFragment_to_editNoteFragment)
//            }
//            ivDelete.setOnClickListener {
//               fragment.deleteGo()
//            }



        }

        holder.binding.rowLayout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
            holder.itemView.findNavController().navigate(action)
        }
    }


        override fun getItemCount(): Int {
            return notesList.size
        }

        fun updateRV(notesList: List<Note>) {
            this.notesList = notesList
            notifyDataSetChanged()
        }
    }
