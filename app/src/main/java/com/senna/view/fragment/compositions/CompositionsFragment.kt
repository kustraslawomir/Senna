package com.senna.view.fragment.compositions

import android.os.Bundle
import android.view.View
import com.senna.com.R
import com.senna.model.databse.Composition
import com.senna.utils.Constants.Companion.COMPOSITION
import com.senna.utils.extensions.listen
import com.senna.utils.extensions.setPaddingFromNavBar
import com.senna.utils.extensions.startEnterAnimation
import com.senna.view.fragment.base.BaseFragment
import com.senna.view.fragment.compositions.adapter.CompositionsAdapter
import com.senna.view.fragment.player.PlayerFragment
import kotlinx.android.synthetic.main.fragment_compositions.*

class CompositionsFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_compositions

    override fun getViewModel() = provideViewModel(CompositionsViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        container.setPaddingFromNavBar(resources)

        val viewModel = getViewModel()

        val adapter = CompositionsAdapter(::chooseComposition)
        compositionsRecyclerView.adapter = adapter

        viewModel.getCompositionsLiveData().listen(viewLifecycleOwner) { compositions ->
            adapter.setCompositions(compositions = compositions)
            compositionsRecyclerView.startEnterAnimation()
        }
    }

    private fun chooseComposition(composition: Composition) {
        val bundle = Bundle().apply {
            putParcelable(COMPOSITION, composition)
        }
        val fragment = PlayerFragment().apply {
            arguments = bundle
        }

        getNavigationActivity().replaceFragment(withBackStack = true, fragment = fragment)
    }
}
