package `in`.kikr.android.bindingsample

import `in`.kikr.android.bindingsample.binding.BindingParameter
import `in`.kikr.android.bindingsample.databinding.FragmentMainBinding
import `in`.kikr.android.bindingsample.viewmodel.SampleItemModel
import `in`.kikr.android.bindingsample.viewmodel.SampleViewModel
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Bindingクラスを通してInflateする
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        // DataBindingのため、ViewModelをセットする
        val viewModel = SampleViewModel()
        binding.viewModel = viewModel

        // コレクションバインディングの定義を行う
        binding.bindingParameter = BindingParameter(
            // バインドしたいコレクションを指定
            viewModel.collection,
            // どの型をどのレイアウトにバインドするかを設定する
            OnItemBindClass<SampleItemModel>().map(
                // 型
                SampleItemModel::class.java,
                // variableタグで指定した変数名を指定
                BR.itemModel,
                // SampleItemModelをRecyclerView内で表示するためのレイアウトを指定
                R.layout.item_text)
        )

        // inflateしたroot要素を返してやる
        return binding.root
    }
}
