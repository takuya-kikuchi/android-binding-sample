package `in`.kikr.android.bindingsample.binding

import android.databinding.ObservableList
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass

class BindingParameter<T>(
    // バインド対象のコレクション
    val collection: ObservableList<T>,
    // バインド定義
    val itemBinding: OnItemBindClass<T>)