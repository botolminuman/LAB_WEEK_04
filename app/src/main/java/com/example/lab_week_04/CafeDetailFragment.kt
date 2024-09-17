package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class CafeDetailFragment : Fragment() {
    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(TAB_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuContainer = view.findViewById<LinearLayout>(R.id.menu_container)

        // Split content into individual menu items
        val menuItems = content?.split("\n") ?: emptyList()

        // Add each menu item to the container
        menuItems.forEach { menuItem ->
            val textView = TextView(context).apply {
                text = menuItem
                textSize = 18f
                setPadding(10, 20, 10, 20)
                setTextColor(ContextCompat.getColor(context!!, android.R.color.black))
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
            menuContainer.addView(textView)
        }
    }

    companion object {
        private const val TAB_CONTENT = "TAB_CONTENT"
        fun newInstance(content: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                }
            }
    }
}
