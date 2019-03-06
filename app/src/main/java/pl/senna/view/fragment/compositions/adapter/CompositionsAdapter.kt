package pl.senna.view.fragment.compositions.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import pl.senna.com.R
import pl.senna.model.firebase.Composition
import pl.senna.utils.extensions.shouldBeHideIf
import timber.log.Timber

class CompositionsAdapter : RecyclerView.Adapter<CompositionsAdapter.ViewHolder>() {

    private var compositions: List<Composition> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositionsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_composition, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = compositions.size

    override fun onBindViewHolder(holder: CompositionsAdapter.ViewHolder, position: Int) {
        val composition = compositions[position]
        Timber.d("set composition: %s", Gson().toJson(composition))

        holder.name.text = composition.name
        holder.divider.shouldBeHideIf(condition = thisIsLastElement(position))
    }

    private fun thisIsLastElement(position: Int) = position == compositions.size-1

    fun setCompositions(compositions: List<Composition>) {
        this.compositions = compositions
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val container: LinearLayout = view.findViewById(R.id.container)
        val divider: View = view.findViewById(R.id.divider)
    }
}