package com.senna.view.fragment.compositions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.utils.extensions.listen
import com.senna.utils.extensions.setPaddingFromNavBar
import com.senna.utils.extensions.startEnterAnimation
import com.senna.view.activity.nagivation.NavigationActivity
import com.senna.view.fragment.compositions.adapter.CompositionsAdapter
import kotlinx.android.synthetic.main.fragment_compositions.*


class CompositionsFragment : Fragment() {

    private lateinit var activity: NavigationActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.fragment_compositions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        container.setPaddingFromNavBar(resources)
        val viewModel = ViewModelProviders.of(activity).get(CompositionsViewModel::class.java)

        val adapter = CompositionsAdapter()
        compositionsRecyclerView.adapter = adapter

        viewModel.getCompositionsLiveData().listen(this) { compositions ->
            adapter.setCompositions(compositions = compositions)
            compositionsRecyclerView.startEnterAnimation()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as NavigationActivity
    }
}
