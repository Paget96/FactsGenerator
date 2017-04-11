package com.alex.alex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int DETAIL_REQUEST = 1;
    TextView appTitle;
    Button mButton = null;
    ProgressBar mLoadingIndicator;
    TextView FactTitleText = null;
    TextView FactDescText = null;
    LinearLayout FactLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FactLayout = (LinearLayout)findViewById(R.id.FactLayout);
        appTitle = (TextView)findViewById(R.id.Title_Text);
        FactTitleText = (TextView)findViewById(R.id.factTitle);
        FactDescText = (TextView)findViewById(R.id.factDesc);
        mLoadingIndicator = (ProgressBar)findViewById(R.id.loading_indicator);
        mButton = (Button)findViewById(R.id.toSecondActivity);
        mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new GenerateFactTask().execute();
           }
       });


    }

    public class GenerateFactTask extends AsyncTask<Void,Void,Fact>{

        @Override
        protected void onPreExecute() {
            mLoadingIndicator.setVisibility(View.VISIBLE);

            super.onPreExecute();
        }

        @Override
        protected Fact doInBackground(Void... voids) {
            Fact fact = new FactCatalogue().sayRandomFact();
            return fact;
        }


        @Override
        protected void onPostExecute(Fact fact) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            FactLayout.setVisibility(View.VISIBLE);
            appTitle.setVisibility(View.INVISIBLE);
            if(FactTitleText.getText().equals(fact.getTitle())){
                return;
            }
            FactTitleText.setText(fact.getTitle());
            FactDescText.setText(fact.getDesc());
            super.onPostExecute(fact);
        }

    }

}
