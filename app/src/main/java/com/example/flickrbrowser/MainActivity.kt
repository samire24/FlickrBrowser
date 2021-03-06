package com.example.flickrbrowser

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),GetRawData.onDownloadComplete {
    private val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val getRawData= GetRawData(this)
//        getRawData.setDownloadCompleteListener(this)
        getRawData.execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=android,oreo,sdk&tagmode=any&format=json&nojsoncallback=1")

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        Log.d(TAG,"onCreate ends")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.d(TAG, "onCreateOptionsMenu")
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onOptionsItemSelected")
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
//    companion object {
//        private const val TAG= "MainActivity"
//    }

    override fun onDownloadComplete(data: String, status:DownloadStatus){
        if (status==DownloadStatus.OK){
            Log.d(TAG,"onDownloadComplete called, data is $data")
        }else{
            Log.d(TAG,"onDownloadComplete failed with status $status. Error message is: $data")
        }

    }
}
