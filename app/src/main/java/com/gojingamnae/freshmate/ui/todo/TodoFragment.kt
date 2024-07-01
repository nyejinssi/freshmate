package com.gojingamnae.freshmate.ui.todo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gojingamnae.freshmate.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SharedPreferences 초기화
        val sharedPreferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val savedMemo = sharedPreferences?.getString("memo", "")
        binding.editTextMemo.setText(savedMemo)

        // Save 버튼 클릭 리스너
        binding.btnSave.setOnClickListener {
            val memo = binding.editTextMemo.text.toString()
            // 여기에서 메모를 저장할 수 있습니다. 예를 들어, SharedPreferences에 저장하거나 데이터베이스에 저장할 수 있습니다.

            // Toast 메시지 표시
            Toast.makeText(requireContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show()
        }

        // 전부 지우기 버튼 클릭 리스너
        binding.btnClear.setOnClickListener {
            binding.editTextMemo.setText("")
            // 여기에서 메모를 지울 수 있습니다. 예를 들어, SharedPreferences에서 삭제하거나 데이터베이스에서 삭제할 수 있습니다.

            // Toast 메시지 표시
            Toast.makeText(requireContext(), "메모가 삭제되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}