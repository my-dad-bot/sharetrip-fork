package net.sharetrip.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.sharetrip.R
import net.sharetrip.databinding.ItemTourCityBinding

class PopularCityAdapter : RecyclerView.Adapter<PopularCityAdapter.PopularCityViewHolder>() {
    //private val cityList = ArrayList<HolidayCity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCityViewHolder {
        val bindingView = DataBindingUtil.inflate<ItemTourCityBinding>(LayoutInflater.from(parent.context),
                R.layout.item_tour_city, parent, false)
        return PopularCityViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: PopularCityViewHolder, position: Int) {

    }

    override fun getItemCount() = 0

    //override fun onBindViewHolder(holder: PopularCityViewHolder, position: Int) = holder.bind(cityList[position])

    /*fun update(cities: ArrayList<HolidayCity>) {
        cityList.clear()
        cityList.addAll(cities)
        notifyDataSetChanged()
    }*/

    inner class PopularCityViewHolder(private val cityBinding: ItemTourCityBinding) : RecyclerView.ViewHolder(cityBinding.root) {

        /*fun bind(city: HolidayCity) {
            cityBinding.textViewCityName.text = city.name

            val options = RequestOptions()
                    .centerCrop()
                    .transform(CenterCrop(), RoundedCorners(16))
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_placeholder)

            Glide.with(cityBinding.imageViewCity.context)
                    .load(city.imageUrl)
                    .apply(options)
                    .into(cityBinding.imageViewCity)
        }*/
    }
}