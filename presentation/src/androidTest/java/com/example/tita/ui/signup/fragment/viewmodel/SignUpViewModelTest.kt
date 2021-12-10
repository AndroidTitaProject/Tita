package com.example.tita.ui.signup.fragment.viewmodel

import android.os.Build
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.network.service.SignUpService
import com.example.domain.repository.AuthRepository
import com.example.domain.usecase.IdCheckUseCase
import com.example.domain.usecase.NickNameUseCase
import com.example.domain.usecase.PostMailUseCase
import com.example.domain.usecase.SignUpUseCase
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit
import javax.inject.Inject

// hilt 로 테스트 하겠다
@ExperimentalCoroutinesApi //coroutine 관련 api사용시 필요
// Junit4로 run 돌리겠다
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SignUpViewModelTest {

    @get:Rule
    var hiltrule = HiltAndroidRule(this)

    // 백그라운드 작업과 연관된 모든 아키텍쳐 컴포넌트들을 같은 스레드에서 실행되게 해준다.
    @get:Rule
    var instanTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: SignUpViewModel

    @Inject
    lateinit var repository: AuthRepository


    private lateinit var signUpUseCase: SignUpUseCase
    private lateinit var postMailUseCase: PostMailUseCase
    private lateinit var getIdCheckUseCase: IdCheckUseCase
    private lateinit var nickNameUseCase: NickNameUseCase


    @Before
    fun setUp() {
        hiltrule.inject()
        signUpUseCase = SignUpUseCase(repository)
        postMailUseCase = PostMailUseCase(repository)
        getIdCheckUseCase = IdCheckUseCase(repository)
        nickNameUseCase = NickNameUseCase(repository)
        viewModel = SignUpViewModel(
            signUpUseCase,
            postMailUseCase,
            getIdCheckUseCase,
            nickNameUseCase
        )
    }


    // 성공
    @Test
    fun `닉네임`() = runBlockingTest {
        viewModel.nickNameOverlap("abc")

        Log.d("TAG", "닉네임: ${viewModel.nickName.value}")
    }

    @Test
    fun `안녕하세요`() {
        Log.d("hello", "hello")
    }

}