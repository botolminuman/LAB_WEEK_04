package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val MENU_NAME = "MENU_NAME"

class MenuDetailFragment : Fragment() {
    private var menuName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            menuName = it.getString(MENU_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuDescriptionTextView = view.findViewById<TextView>(R.id.menu_description)
        val menuPriceTextView = view.findViewById<TextView>(R.id.menu_price)

        // Assign descriptions and prices based on the menu
        when (menuName) {
            "Espresso" -> {
                menuDescriptionTextView.text = "Espresso adalah kopi dengan rasa kuat yang diekstrak dari mesin espresso."
                menuPriceTextView.text = "Harga: Rp 20.000"
            }
            // Tambahkan deskripsi dan harga untuk menu lainnya
        }
    }

    companion object {
        fun newInstance(menuName: String) =
            MenuDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(MENU_NAME, menuName)
                }
            }
    }
}
