package com.example.tita.ui.fragment.signup


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tita.databinding.FragmentCertificatioBinding

class SignUpCertificatioFragment : Fragment() {
    private var _binding: FragmentCertificatioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCertificatioBinding.inflate(inflater, container, false)


        binding.nextButton.setOnClickListener {

            Log.d(TAG, "onCreateView: ")
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}



