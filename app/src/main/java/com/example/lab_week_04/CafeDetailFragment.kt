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
    private var title: String? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(TAB_CONTENT)
            title = it.getString(TAB_TITLE)
            description = it.getString(TAB_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView = view.findViewById<TextView>(R.id.menu_title)
        val descriptionTextView = view.findViewById<TextView>(R.id.menu_description)
        val menuItemsContainer = view.findViewById<LinearLayout>(R.id.menu_items_container)

        // Setel teks untuk judul dan deskripsi
        titleTextView.text = title
        descriptionTextView.text = description

        // Pisahkan konten menjadi item menu individual
        val menuItems = content?.split(", ") ?: emptyList()

        // Tambahkan setiap item menu ke dalam container
        menuItems.forEach { menuItem ->
            val textView = TextView(context).apply {
                text = menuItem
                textSize = 18f
                setPadding(0, 10, 0, 10)
                setTextColor(ContextCompat.getColor(context!!, android.R.color.black))
            }
            menuItemsContainer.addView(textView)
        }
    }

    companion object {
        private const val TAB_CONTENT = "TAB_CONTENT"
        private const val TAB_TITLE = "TAB_TITLE"
        private const val TAB_DESCRIPTION = "TAB_DESCRIPTION"
        fun newInstance(content: String, title: String, description: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                    putString(TAB_TITLE, title)
                    putString(TAB_DESCRIPTION, description)
                }
            }
    }
}
