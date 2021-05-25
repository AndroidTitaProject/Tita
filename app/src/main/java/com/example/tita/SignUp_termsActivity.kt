package com.example.tita

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tita.databinding.ActivitySignUpBinding
import com.example.tita.databinding.CustomDialogLayoutBinding


class SignUp_termsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var binding2: CustomDialogLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null)
        setContentView(R.layout.activity_sign_up)

        binding2 = DataBindingUtil.setContentView(this, R.layout.custom_dialog_layout)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        AllCheck()

        binding.TermsOfServiceText.setOnClickListener {
            //커스텀 다이얼로그를 만들어주고, 다이얼로그가 과거에 열렸는지 확인하고 열렸었으면 지워주는 코드 중복방지.
            //또한 맞는 Title과 Text를 넣어준다.
          val builder = AlertDialog.Builder(this)
            val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
            val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
            dialogMainText.text = "서비스 이용약관"
            dialogText.setText(R.string.Zunmun)

            if (dialogView.getParent() != null)
                    (dialogView.getParent() as ViewGroup)
                    .removeView(dialogView)
                    builder.setView(dialogView)
                    .setNegativeButton("확인") { dialogInterface, i ->
                        dialogMainText.text = "서비스 이용약관"
                        dialogText.setText(R.string.Zunmun)
                    }
                    .show()
        }

        binding.PrivacyTermsText.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
            val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
            dialogMainText.text = "개인정보 처리방침"
            dialogText.setText(R.string.Zunmun)

            if (dialogView.getParent() != null)
                (dialogView.getParent() as ViewGroup)
                        .removeView(dialogView)
            builder.setView(dialogView)
                    .setNegativeButton("확인") { dialogInterface, i ->
                        dialogMainText.text = "개인정보 처리방침"
                        dialogText.setText(R.string.Zunmun)
                    }
                    .show()
        }

        binding.CommunityUsageRulesText.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
            val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
            dialogMainText.text = "커뮤니티 이용규칙"
            dialogText.setText(R.string.Zunmun)

            if (dialogView.getParent() != null)
                (dialogView.getParent() as ViewGroup)
                        .removeView(dialogView)
            builder.setView(dialogView)
                    .setNegativeButton("확인") { dialogInterface, i ->
                        dialogMainText.text = "커뮤니티 이용규칙"
                        dialogText.setText(R.string.Zunmun)
                    }
                    .show()
        }

        binding.nextButton.setOnClickListener {

            if(binding.CheckboxAgree1.isChecked && binding.CheckboxAgree2.isChecked && binding.CheckboxAgree3.isChecked){

                startActivity(Intent(this, SignUp_CertificatioActivity::class.java))

            }
            else
            {
                val builder = AlertDialog.Builder(this)
                val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
                val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
                dialogMainText.text = "오류"
                dialogText.setText("필수 체크박스를 체크하지 않았습니다.")

                if (dialogView.getParent() != null)
                    (dialogView.getParent() as ViewGroup)
                            .removeView(dialogView)
                builder.setView(dialogView)
                        .setNegativeButton("확인") { dialogInterface, i ->
                            dialogMainText.text = "오류"
                            dialogText.setText("필수 체크박스를 체크하지 않았습니다.")
                        }
                        .show()
            }
        }
    }

    private fun AllCheck() {
        binding.CheckboxAllAgree.setOnClickListener {
            if(binding.CheckboxAllAgree.isChecked)
            {
                binding.CheckboxAgree1.isChecked = true
                binding.CheckboxAgree2.isChecked = true
                binding.CheckboxAgree3.isChecked = true
            }

            else
            {
                binding.CheckboxAgree1.isChecked = false
                binding.CheckboxAgree2.isChecked = false
                binding.CheckboxAgree3.isChecked = false
            }
        }

    }
}