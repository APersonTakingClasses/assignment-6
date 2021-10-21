package edu.temple.assignment_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout  = inflater.inflate(R.layout.fragment_display, container, false)

        val textView = layout.findViewById<TextView>(R.id.textView)
        val imageView = layout.findViewById<ImageView>(R.id.imageView)

        ViewModelProvider(requireActivity())
            .get(ItemViewModel::class.java)
            .getItem()
            .observe(requireActivity(), {
                imageView.setImageResource(it.resourceId)
                textView.text = it.description
            })

        return layout
    }

}