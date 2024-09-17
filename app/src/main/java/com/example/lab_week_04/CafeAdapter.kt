package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

val TABS_CONTENT = listOf(
    R.string.starbucks_content,
    R.string.janjijiwa_content,
    R.string.kopikenangan_content
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        val content = when (position) {
            0 -> listOf("Caramel Macchiato", "Frappuccino", "Mocha").joinToString("\n")
            1 -> listOf("Milk Coffee", "Gula Aren Coffee", "Cappuccino").joinToString("\n")
            2 -> listOf("Mocha Coffee", "Cappuccino", "Latte").joinToString("\n")
            else -> ""
        }
        return CafeDetailFragment.newInstance(content)
    }
}