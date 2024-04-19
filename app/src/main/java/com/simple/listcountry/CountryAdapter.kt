package com.simple.listcountry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val countries = listOf("Indonesia", "United States", "India", "China", "Brazil", "Japan", "South Korea", "North Korea", "Russia", "Iran", "Palestine", "UAE", "Singapore", "United Kingdom", "Italy", "Germany", "France", "Ireland", "Sweden", "Finland")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countries.size

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val countryNameTextView: TextView = itemView.findViewById(R.id.countryName)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(countryName: String) {
            countryNameTextView.text = countryName
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val clickedCountry = countries[position]
                itemClickListener.onItemClick(clickedCountry)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(countryName: String)
    }
}
