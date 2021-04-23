package com.staqu.staquassignment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.staqu.staquassignment.Interface.Api
import com.staqu.staquassignment.Model.NoAnswersData
import com.staqu.staquassignment.RetrofitSingleTon.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar?.title = "StackOverFlow"
        setSupportActionBar(toolbar);
        supportActionBar?.title = title
        window.statusBarColor
        setContentView(R.layout.activity_main)
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
        }
        progressDialog!!.setMessage("Please wait..")
        progressDialog!!.setCancelable(false)


        getStackOverFlowList()
    }

    private fun getStackOverFlowList() {
        progressDialog!!.show()
        var service: Api = RetrofitClientInstance.getRetrofitInstance().create(Api::class.java)
        var call: Call<NoAnswersData> = service.getStackOverFlowList(
            "desc",
            "activity",
            "stackoverflow"
        )
        call.enqueue(object : Callback<NoAnswersData> {
            override fun onResponse(call: Call<NoAnswersData>, response: Response<NoAnswersData>) {
                main_rc.adapter = StackoverflowlistAdapter(applicationContext, response.body())
                main_rc.addItemDecoration(
                    DividerItemDecoration(
                        applicationContext,
                        LinearLayoutManager.VERTICAL
                    )
                )
                progressDialog!!.dismiss()
            }

            override fun onFailure(call: Call<NoAnswersData>, t: Throwable) {
                Snackbar.make(main_rc, "Try again!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", object : View.OnClickListener{
                        override fun onClick(v: View?) {
                            getStackOverFlowList()
                        }

                    }).show()
            }

        })
    }
}