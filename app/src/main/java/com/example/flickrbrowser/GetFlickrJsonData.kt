package com.example.flickrbrowser

import android.os.AsyncTask
import android.view.View

class GetFlickrJsonData(private val listener: onDataAvailable): AsyncTask<String,Void, ArrayList<Photo>>() {
    private val TAG= "GetFlickrJsonData"

    interface onDataAvailable{
        fun onDataAvailable(data: List<Photo>)
        fun onError(exception: Exception)
    }

    override fun onPostExecute(result: ArrayList<Photo>?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: String?): ArrayList<Photo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}