package com.example.tita.viewmodels

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.tita.R
import com.example.tita.base.BaseViewModel
import com.example.tita.ui.fragment.SignUpCertificatioFragment

class SignUpViewModel(layoutInflater: LayoutInflater, application: Application) :
    BaseViewModel(application = application) {

    @SuppressLint("StaticFieldLeak")
    private val context = Application().applicationContext

    @SuppressLint("StaticFieldLeak")

    val dialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null)

    fun naverLogin(view: View) {


        val builder = AlertDialog.Builder(context)
        val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
        val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
        dialogMainText.text = "서비스 이용약관"
        dialogText.setText(R.string.Zunmun)

        if (dialogView.parent != null)
            (dialogView.parent as ViewGroup)
                .removeView(dialogView)
            builder.setView(dialogView)
            .setNegativeButton("확인") { dialogInterface, i ->
                dialogMainText.text = "서비스 이용약관"
                dialogText.setText(R.string.Zunmun)
            }
            .show()
    }
    fun intentSignUpTerms(view: View) {
        Log.d(TAG, "intentSignUpTerms: ")
        view.findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpCertificatioFragment)

    }

}
