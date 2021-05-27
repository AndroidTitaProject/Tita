package com.example.tita.TunedCode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tita.R

<<<<<<< HEAD
class SignUpIdPasswardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
                             ): View = inflater.inflate(R.layout.activity_sign_up_id_passward,container,false)
=======
@Suppress("DEPRECATION")
class SignUpIdPasswardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_sign_up_id_passward,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
>>>>>>> [UPDATE] SignUpPage
}