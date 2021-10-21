package edu.temple.assignment_6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel(){
    private val itemLiveData = MutableLiveData<Item>()

    fun getItem () : LiveData<Item> {
        return itemLiveData;
    }

    fun setItem(item: Item) {
        itemLiveData.value = item
    }

}