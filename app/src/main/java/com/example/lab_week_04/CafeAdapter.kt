package com.example.lab_week_04

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val context: Context) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        val (content, title, description) = when (position) {
            0 -> Triple(
                listOf("Caramel Macchiato", "Frappuccino", "Mocha", "Latte", "Espresso").joinToString("\n"),
                "Starbucks",
                context.getString(R.string.starbucks_desc)
            )
            1 -> Triple(
                listOf("Milk Coffee", "Gula Aren Coffee", "Cappuccino", "Matcha Latte", "Black Coffee").joinToString("\n"),
                "Janji Jiwa",
                context.getString(R.string.janjijiwa_desc)
            )
            2 -> Triple(
                listOf("Kopi Kenangan Mantan", "Kopi LDR", "Kopi Soekarno", "Es Teh Manis", "Es Cokelat").joinToString("\n"),
                "Kopi Kenangan",
                context.getString(R.string.kopikenangan_desc)
            )
            else -> Triple("", "", "")
        }
        return CafeDetailFragment.newInstance(content, title, description)
    }
}
