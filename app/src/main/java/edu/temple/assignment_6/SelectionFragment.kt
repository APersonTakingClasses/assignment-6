package edu.temple.assignment_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ITEMS_KEY = "items"

class SelectionFragment : Fragment() {

    private lateinit var items: Array<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            (it.getParcelableArray(ITEMS_KEY) as Array<Item>).also { items = it }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_selection, container, false)

        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            itemViewModel.setItem(items[itemPosition])
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)

        return layout
    }

    companion object {
        fun newInstance(items: Array<Item>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ITEMS_KEY, items)
                }
            }
    }
}