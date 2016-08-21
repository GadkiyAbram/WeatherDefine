package com.example.aleksandrabramovski.weatherdefine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5;

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&mode=xml";
    private String url3 = "&APPID=2aafe22e62f440bfaa13f337847ab25f";
    private HandleXML obj;
    Button mButtonShowWeather;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonShowWeather = (Button)findViewById(R.id.button);

        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);
        ed4 = (EditText)findViewById(R.id.editText4);
        ed5 = (EditText)findViewById(R.id.editText5);

        mButtonShowWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ed1.getText().toString();
                String finalUrl = url1 + url + url3 + url2;
                ed2.setText(finalUrl);

                obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while (obj.parsingComplete) ;
                ed2.setText("Country: " + obj.getCountry());
                ed3.setText("Temperature: " + obj.getTemperature() + " C");
                ed4.setText("Humidity: " + obj.getHumidity() + " %");
                ed5.setText("Pressure: " + obj.getPressure());
            }
        });
    }
}
