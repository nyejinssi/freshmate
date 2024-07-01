package com.gojingamnae.freshmate.ui.fridge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.gojingamnae.freshmate.R
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gojingamnae.freshmate.databinding.FragmentFridgeBinding

class FridgeFragment  : Fragment() {
    private var _binding: FragmentFridgeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFridgeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}