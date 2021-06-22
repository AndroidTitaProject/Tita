package com.example.tita

import android.app.Application


/***Application  class
    어플리케이션 컴포넌트들 사이에서 공동으로 멤버들을 사용할 수 있는 편리한 클래스를 제공한다.

*/
class App : Application() {
    companion object {
        lateinit var instance: App
            private set

    }
    override fun onCreate(){
        super.onCreate()
        instance =this
    }
}