package com.example.user.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button imagebtn,toastbtn;
    ImageView image;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        imagebtn = findViewById ( R.id.imagebtn );
        toastbtn = findViewById ( R.id.toastbtn );
        image = findViewById ( R.id.image );
        progressBar = findViewById ( R.id.progressBar );


        toastbtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText ( MainActivity.this, "Iam in toast", Toast.LENGTH_SHORT ).show ();

            }
        } );
        imagebtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                loadImage();
                new LoadIconTask ().execute ( R.drawable.idiots );

//            }
//        });

            }
        } );
    }
//
//    private void loadImage() {
//        new Thread ( new Runna+ble () {
//            @Override
//            public void run() {
//                final Bitmap bitmap = BitmapFactory.decodeResource ( getResources (),R.drawable.idiots );
//                  MainActivity.this.runOnUiThread ( new Runnable () {
//                      @Override
//                      public void run() {
//                          image.setImageBitmap ( bitmap );
//
//                      }
//                  } );
//
//            }
//        } ).start ();
//    }

            class LoadIconTask extends AsyncTask<Integer, Integer, Bitmap> {
                @Override
                protected Bitmap doInBackground(Integer... integers) {
                    Bitmap bitmap = BitmapFactory.decodeResource ( getResources (), R.drawable.idiots );
                    return bitmap;
                }

                @Override
                protected void onPreExecute() {
                    super.onPreExecute ();
                    progressBar.setVisibility ( ProgressBar.VISIBLE );
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    super.onPostExecute ( bitmap );
                    progressBar.setVisibility ( ProgressBar.INVISIBLE );
                    image.setImageBitmap ( bitmap );
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
                    super.onProgressUpdate ( values );
                    progressBar.setProgress ( values[0] );
                }
            }

    }