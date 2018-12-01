package `in`.kikr.android.bindingsample

import `in`.kikr.android.bindingsample.databinding.FragmentMainBinding
import `in`.kikr.android.bindingsample.viewmodel.SampleViewModel
import android.support.v4.app.Fragment
import android.os.Bundle
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
        binding.viewModel = SampleViewModel()
        // inflateしたroot要素を返してやる
        return binding.root
    }
}
