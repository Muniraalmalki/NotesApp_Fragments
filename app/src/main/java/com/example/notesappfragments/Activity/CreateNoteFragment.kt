package com.example.notesappfragments.Activity


import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.notesappfragments.Database.ViewModel
import com.example.notesappfragments.Model.Note
import com.example.notesappfragments.R
import com.example.notesappfragments.databinding.FragmentCreateNoteBinding


import java.util.*

class CreateNoteFragment : Fragment() {

    lateinit var binding: FragmentCreateNoteBinding
    lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        binding.btnSaveNotes.setOnClickListener {
            addNote(it)
        }
        return binding.root
    }

    private fun addNote(it: View?) {
        val title = binding.edtTitle.text.toString()
        val subTitle = binding.edtSubTitle.text.toString()
        val noteDescription = binding.edtNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy", d.time)
        Log.e("error", "createNotes: $notesDate")

        if (title.isNotEmpty() && subTitle.isNotEmpty() && noteDescription.isNotEmpty() && notesDate.isNotEmpty()){
            viewModel.addNote(Note(0,title,subTitle,noteDescription,notesDate.toString()))
            Toast.makeText(requireContext(), "Notes added", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
        }
        else{
            Toast.makeText(requireContext(), "Fail Notes added", Toast.LENGTH_SHORT).show()

        }

    }
}