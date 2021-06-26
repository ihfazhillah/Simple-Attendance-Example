package com.ihfazh.simpleattendanceexample.ui.studentform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ihfazh.simpleattendanceexample.databinding.FragmentStudentFormBinding
import io.reactivex.disposables.CompositeDisposable

class StudentFormFragment: Fragment() {
    private var _binding: FragmentStudentFormBinding? = null
    private val binding
        get() = _binding!!
    private val compositeDisposable = CompositeDisposable()
    private val viewModel: StudentFormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val disposable = viewModel.addStudent(binding.editFirstName.text.toString(), binding.editLastName.text.toString())
                .subscribe{findNavController().navigateUp()}
            compositeDisposable.add(disposable)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        compositeDisposable.dispose()
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}