package pl.senna.view.fragment.compositions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import pl.senna.com.R
import pl.senna.view.activity.main.NavigationActivity

class CompositionsFragment : Fragment() {

    private lateinit var activity: NavigationActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.fragment_compositions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity).get(CompositionsViewModel::class.java)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as NavigationActivity
    }
}