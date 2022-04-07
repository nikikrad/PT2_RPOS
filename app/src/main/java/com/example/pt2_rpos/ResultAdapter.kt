package com.example.pt2_rpos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pt2_rpos.data.PersonEntity
import com.example.pt2_rpos.databinding.FragmentResultBinding

class ResultAdapter(
    private val coinList: List<PersonEntity>,
    private val applicationContext: Context,
    private val binding: FragmentResultBinding
) : RecyclerView.Adapter<ResultAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_person, parent, false)
        return MainViewHolder(view, applicationContext, binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(coinList[position])
    }

    override fun getItemCount(): Int = coinList.size

    class MainViewHolder(
        itemView: View,
        private val applicationContext: Context,
        private val binding: FragmentResultBinding
    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.tv_Name)
        private val result: TextView = itemView.findViewById((R.id.tv_Result))

        fun bind(item: PersonEntity) {
            name.text = item.name
            result.text = item.result.toString() + "/10"
            itemView.setOnClickListener{
                val resultFragment = ResultFragment()
                resultFragment.showSnackBar(item.id, applicationContext, binding)
            }
        }
    }
}