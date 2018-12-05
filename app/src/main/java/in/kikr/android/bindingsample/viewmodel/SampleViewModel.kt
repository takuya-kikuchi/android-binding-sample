package `in`.kikr.android.bindingsample.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList

class SampleViewModel {
    val text: ObservableField<String> = ObservableField("Hello Binding!!!")
    val collection: ObservableList<SampleItemModel> = ObservableArrayList()

    fun addItem(text: String) {
        collection.add(SampleItemModel(text))
    }
}

class SampleItemModel(val text: String)