package com.puput.testsuitmediamobdev.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puput.testsuitmediamobdev.databinding.ListItemGuestBinding
import com.puput.testsuitmediamobdev.model.GuestModel
import java.util.*

class GuestAdapter : RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {
    private val listGuest = ArrayList<GuestModel>()
    private lateinit var onItemClickCallback: OnItemClickCallback


    interface OnItemClickCallback {
        fun onItemClicked(data: GuestModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setGuest(guest: List<GuestModel>?) {
        if (guest == null) return
        this.listGuest.clear()
        this.listGuest.addAll(guest)
    }

    inner class GuestViewHolder(private val binding: ListItemGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guest: GuestModel) {
            with(binding) {
                guestName.text = guest.name

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(guest)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val itemGuestBinding =
            ListItemGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(itemGuestBinding)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(listGuest[position])
    }

    override fun getItemCount(): Int = listGuest.size
}