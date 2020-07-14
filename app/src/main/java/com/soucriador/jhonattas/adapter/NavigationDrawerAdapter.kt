package com.soucriador.jhonattas.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.ui.NavigationDrawerCallbacks
import com.soucriador.jhonattas.ui.NavigationItem

class NavigationDrawerAdapter(private val mData: List<NavigationItem>?) : RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder>() {
    var navigationDrawerCallbacks: NavigationDrawerCallbacks? = null
    private var mSelectedPosition = 0
    private var mTouchedPosition = -1

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.navdrawer_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.textView.text = mData!![i].text
        viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(mData[i].drawable, null, null, null)
        viewHolder.itemView.setOnTouchListener(OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    touchPosition(i)
                    return@OnTouchListener false
                }
                MotionEvent.ACTION_CANCEL -> {
                    touchPosition(-1)
                    return@OnTouchListener false
                }
                MotionEvent.ACTION_MOVE -> return@OnTouchListener false
                MotionEvent.ACTION_UP -> {
                    touchPosition(-1)
                    return@OnTouchListener false
                }
            }
            true
        }
        )
        viewHolder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (navigationDrawerCallbacks != null) navigationDrawerCallbacks!!.onNavigationDrawerItemSelected(i)
            }
        }
        )

        //TODO: selected menu position, change layout accordingly
        if (mSelectedPosition == i || mTouchedPosition == i) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.context.resources.getColor(R.color.selected_gray))
        } else {
            viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    private fun touchPosition(position: Int) {
        val lastPosition = mTouchedPosition
        mTouchedPosition = position
        if (lastPosition >= 0) notifyItemChanged(lastPosition)
        if (position >= 0) notifyItemChanged(position)
    }

    fun selectPosition(position: Int) {
        val lastPosition = mSelectedPosition
        mSelectedPosition = position
        notifyItemChanged(lastPosition)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById<View>(R.id.item_name) as TextView
        }
    }

}