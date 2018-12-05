package `in`.kikr.android.bindingsample

import `in`.kikr.android.bindingsample.databinding.FragmentMainBinding
import `in`.kikr.android.bindingsample.databinding.ItemTextBinding
import `in`.kikr.android.bindingsample.viewmodel.SampleItemModel
import `in`.kikr.android.bindingsample.viewmodel.SampleViewModel
import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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

        // RecyclerViewのAdapterを、ViewModelのCollectionを表示するようにする
        binding.recyclerView.adapter = RecyclerViewAdapter(viewModel.collection)

        viewModel.collection.addOnListChangedCallback(object: ObservableList.OnListChangedCallback<ObservableList<SampleItemModel>>() {
            override fun onChanged(sender: ObservableList<SampleItemModel>?) {
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(
                sender: ObservableList<SampleItemModel>?,
                positionStart: Int,
                itemCount: Int
            ) {
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onItemRangeMoved(
                sender: ObservableList<SampleItemModel>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onItemRangeInserted(
                sender: ObservableList<SampleItemModel>?,
                positionStart: Int,
                itemCount: Int
            ) {
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                sender: ObservableList<SampleItemModel>?,
                positionStart: Int,
                itemCount: Int
            ) {
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

        })

        //binding.recyclerView.adapter
        // inflateしたroot要素を返してやる
        return binding.root
    }

    class RecyclerViewAdapter(val collection: ObservableList<SampleItemModel>) :
        RecyclerView.Adapter<BindableViewHolder<ItemTextBinding>>() {

        // viewHolderの作成時に、表示したいレイアウトをInflateしてやる
        override fun onCreateViewHolder(parent: ViewGroup, position: Int): BindableViewHolder<ItemTextBinding> {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemTextBinding.inflate(layoutInflater, parent, false)
            return BindableViewHolder(binding)
        }

        // アイテム数はObservableListから取得
        override fun getItemCount(): Int = collection.size

        // このViewHolderが表示すべきアイテムのindexが渡されるので、ViewModelを更新する
        override fun onBindViewHolder(viewHolder: BindableViewHolder<ItemTextBinding>, position: Int) {
            viewHolder.binding.itemModel = collection[position]
        }
    }

    class BindableViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
}
