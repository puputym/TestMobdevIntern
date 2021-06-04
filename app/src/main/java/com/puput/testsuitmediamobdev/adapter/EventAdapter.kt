package com.puput.testsuitmediamobdev.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puput.testsuitmediamobdev.databinding.ListItemEventBinding
import com.puput.testsuitmediamobdev.model.EventModel
import java.util.*

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    private val listEvent = ArrayList<EventModel>()
    private lateinit var onItemClickCallback: OnItemClickCallback


    interface OnItemClickCallback {
        fun onItemClicked(data: EventModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setEvent(event: List<EventModel>?) {
        if (event == null) return
        this.listEvent.clear()
        this.listEvent.addAll(event)
    }

    inner class EventViewHolder(private val binding: ListItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventModel) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(event.img)
                    .apply(RequestOptions().override(150, 150))
                    .into(tvImg)
                eventName.text = event.name
                dateName.text = event.date
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(event)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemEventBinding =
            ListItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemEventBinding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(listEvent[position])
    }

    override fun getItemCount(): Int = listEvent.size
}