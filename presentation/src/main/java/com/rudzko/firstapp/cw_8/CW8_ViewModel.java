package com.rudzko.firstapp.cw_8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.main.MainActivity;

/**
 * @author Olga Rudzko
 */

public class CW8_ViewModel implements BaseViewModel {

    public Activity activity;

    CW8_ViewModel(Activity activity) {
        this.activity = activity;
    }

    public ObservableField<String> myText = new ObservableField<>("My Text");

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void onButtonClick(){
        Log.e("Clicked", "onClick");
        Intent intent= new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    public class MyAsyncTask extends AsyncTask <Void, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }//UI thread, the fist method to execute

        @Override
        protected String doInBackground(Void... params) {
            publishProgress(20);//calls onProgressUpdate
            return "null";
        } //additional thread, sends the result to onPostExecute

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }//UI thread, executes only if called from doInBackground

        @Override
        protected void onPostExecute(String x) {
            super.onPostExecute(x);
        } //UI thread, gets the income parameter from doInBackground
    }
}
