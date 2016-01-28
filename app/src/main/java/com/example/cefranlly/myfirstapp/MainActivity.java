package com.example.cefranlly.myfirstapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher,"Coldplay"),
                new Bandas(R.drawable.ic_launcher,"U2"),
                new Bandas(R.drawable.ic_launcher,"Ludacris"),
                new Bandas(R.drawable.ic_launcher,"Pink Floyd"),
                new Bandas(R.drawable.ic_launcher,"Limp Bizkit"),
                new Bandas(R.drawable.ic_launcher,"Guetta"),
                new Bandas(R.drawable.ic_launcher,"Skrillex"),
                new Bandas(R.drawable.ic_launcher,"Calvin Harris"),
                new Bandas(R.drawable.ic_launcher,"Tiesto"),
                new Bandas(R.drawable.ic_launcher,"Snoop Dogg"),
                new Bandas(R.drawable.ic_launcher,"Eminem"),
                new Bandas(R.drawable.ic_launcher,"50 Cent")
        };

        BandasAdapter adapter = new BandasAdapter(this, R.layout.listview_item_row, bandas_data);
        listView = (ListView)findViewById(R.id.lista);
        View header = (View)getLayoutInflater().inflate(R.layout.list_header_row, null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) findViewById(R.id.vistaTexto);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
