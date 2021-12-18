package com.example.movildevappturismo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListCartagenaActivity : AppCompatActivity() {

    private lateinit var listCartagena: ArrayList<CartagenaItem>
    private lateinit var cartagenaAdapter: CartagenaAdapter
    private lateinit var cartagenaRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cartagena)

        cartagenaRecyclerView = findViewById(R.id.cartagena_recycler_view)

       // listCartagena = createMockCartagena()
        listCartagena = loadMockCartagenaFromJson()
        cartagenaAdapter = CartagenaAdapter(listCartagena)

       // cartagenaRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        cartagenaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = cartagenaAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockCartagenaFromJson(): ArrayList<CartagenaItem> {
        var cartagenaString: String = applicationContext.assets.open("poicartagena.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(cartagenaString, Cartagena::class.java)
        return data
    }



    }
