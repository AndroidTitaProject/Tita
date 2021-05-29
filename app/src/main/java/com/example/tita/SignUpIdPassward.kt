package com.example.tita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.tita.databinding.ActivitySignUpIdPasswardBinding

class SignUpIdPassward : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpIdPasswardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_id_passward)
        //binding.joinBtn.setOnClickListener {

            //모든 엑티비티 종료
            //ActivityCompat.finishAffinity(this)
            //startActivity(Intent(this, LoginActivity::class.java))
        //}
        //binding.text = ObservableUser()

    }
}

class ObservableUser : BaseObservable(){
    val idtext = ObservableField("")
    val nicknametext = ObservableField("")

    //중복확인 if문 추가예정

    fun onclick_idbtn(){
        idtext.set("사용 가능한 아이디 입니다.")
    }
    fun onclick_nickbtn(){
        nicknametext.set("사용 가능한 닉네임 입니다.")

    }
}