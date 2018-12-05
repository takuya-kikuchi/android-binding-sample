package `in`.kikr.android.bindingsample.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList

class SampleViewModel {
    val text: ObservableField<String> = ObservableField("Hello Binding!!!")
    val collection: ObservableList<SampleItemModel> = ObservableArrayList()

    fun addItemLeft(text: String) {
        collection.add(SampleItemModel.LeftText(text))
    }
    fun addItemRight(text: String) {
        collection.add(SampleItemModel.RightText(text))
    }
    fun addImage() {
        collection.add(SampleItemModel.Image)
    }
}

sealed class SampleItemModel {
    class LeftText(val text: String) : SampleItemModel()
    class RightText(val text: String) : SampleItemModel()
    object Image : SampleItemModel()
}

