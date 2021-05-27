<<<<<<< HEAD
package com.example.tita.TunedCode

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignUp_Adapter(fm:FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
=======
@file:Suppress("DEPRECATION")

package com.example.tita.TunedCode

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SignUp_Adapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
>>>>>>> [UPDATE] SignUpPage
        return when (position){
            0       ->  SignUptermsFragment()

            1       ->  SignUpCertificatioFragment()

            else    ->  SignUpIdPasswardFragment()

        }
    }

}