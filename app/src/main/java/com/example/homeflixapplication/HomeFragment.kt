package com.example.homeflixapplication
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeflixapplication.viewmodel.MyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var recAdapter: RecAdapter
    private val viewModel: MyViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        initRecView(view)
        return view
    }


    companion object{
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
    private fun initRecView(view:View){
     recyclerView =  view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        getData()
    }
    private fun getData(){
        viewModel.getMutableLiveData()
        viewModel.filmList.observe(viewLifecycleOwner, Observer {
            Log.d("dwd","jhgf")
            recAdapter = RecAdapter(it)
            recyclerView.adapter = recAdapter
        })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}
