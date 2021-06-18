package com.ihfazh.simpleattendanceexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ihfazh.simpleattendanceexample.R
import com.ihfazh.simpleattendanceexample.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonMore.setOnClickListener {
            openMoreMenu(it)
        }
        binding.eventsCard.setOnClickListener {
            Toast.makeText(requireContext(), "Events Card Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.studentsCard.setOnClickListener {
            Toast.makeText(requireContext(), "Students Card Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMoreMenu(view: View) {
        PopupMenu(requireContext(), view).apply {
            inflate(R.menu.more_button)
            setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.menu_event -> {
                        Toast.makeText(requireContext(), "Create event menu clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_student -> {
                        findNavController().navigate(R.id.home_to_student_view)
                    }
                }

                true
            }
            show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}