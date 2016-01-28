package com.example.cefranlly.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cefranlly.myfirstapp.Bandas;

/**
 * Created by Cefranlly on 27/01/16.
 */
public class BandasAdapter extends ArrayAdapter<Bandas>{
    Context context;
    int LayoutResourceId;
    Bandas data[] = null;

    public BandasAdapter(Context context, int LayoutResourceId, Bandas[] data){
        super(context, LayoutResourceId,data);
        this.context = context;
        this.LayoutResourceId = LayoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        BandasHolder holder = null;

        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(LayoutResourceId,parent,false);

            holder = new BandasHolder();
            holder.imagen = (ImageView)row.findViewById(R.id.imagen);
            holder.texto = (TextView)row.findViewById(R.id.vistaTexto);
            row.setTag(holder);
        }else{
            holder = (BandasHolder)row.getTag();
        }

        Bandas bandas = data[position];
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);
        return row;
    }

    static class BandasHolder{
        ImageView imagen;
        TextView texto;
    }
}
