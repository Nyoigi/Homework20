package com.example.homework20.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.homework20.R

fun FragmentActivity.navigateToFragment(fragment: Fragment, addToBackStack: Boolean = false) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)

    if (addToBackStack) {
        fragmentTransaction.addToBackStack(null).commit()
    } else {
        fragmentTransaction.commit()
    }
}