package com.example.andimaroge.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ImageView mainImage;
    String url = "";
    public MainActivityFragment() {
//        LongOperation op = new LongOperation();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainImage = (ImageView) getActivity().findViewById(R.id.mainImage);
            url = "https://raw.githubusercontent.com/Amaroge3/CS6392018/master/pob.jpeg";
        LongOperation op = new LongOperation();
        op.execute(url);

    }

    public class LongOperation extends AsyncTask<String,Void,Bitmap> {

    Bitmap bmap;

        @Override
        protected Bitmap doInBackground(String... params){

            try {

                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream in =  urlConnection.getInputStream();

                if (urlConnection.getResponseCode() != 200){
                    throw new Exception("Failed to connect");
                }
                bmap = BitmapFactory.decodeStream(in);
                in.close();



            } catch (Exception e){
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }

        return bmap;
        }

        @Override
        protected void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Bitmap map){

            super.onPostExecute(map);
            mainImage.setImageBitmap(map);

        }


        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }

    }

}
