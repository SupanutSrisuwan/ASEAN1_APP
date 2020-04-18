package data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.asean1_app.R
import kotlinx.android.synthetic.main.list_item_asean.view.*

class aseanAdapter (private val context: Context, private val dataSource: ArrayList<asean>) : BaseAdapter(

) {

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowview = inflater.inflate(R.layout.list_item_asean, null)

        rowview.TvCountryName.text = dataSource[position].CountryName

        rowview.Tvmuang.text = dataSource[position].caption
        val res = context.resources
        val drawableId :Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        val drawableId2 :Int = res.getIdentifier(dataSource[position].imageFile2,"drawable",context.packageName)
        rowview.picflag.setImageResource(drawableId)
        return rowview
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}
