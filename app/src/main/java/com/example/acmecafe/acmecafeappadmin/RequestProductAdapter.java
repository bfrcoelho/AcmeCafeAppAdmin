package com.example.acmecafe.acmecafeappadmin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bruno Coelho on 05/04/2018.
 */

public class RequestProductAdapter extends BaseAdapter {

    ArrayList<ProductQuantity> productsquantity;
    int layoutResourceId;
    Context mContext;


    public RequestProductAdapter(Context mContext,int layoutResourceId, ArrayList<ProductQuantity> products) {
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.productsquantity = products;

    }


    public int getCount() {
        return productsquantity.size();
    }


    public ProductQuantity getItem(int position) {
        return productsquantity.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View row = convertView;
        ProductHolder holder = null;

        //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(row == null)
        {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, viewGroup, false);

            holder = new ProductHolder();
            holder.name = row.findViewById(R.id.name);
            holder.quantity = row.findViewById(R.id.tv_quantity);



            row.setTag(holder);
        }
        else
        {
            holder = (ProductHolder) row.getTag();
        }

        holder.name.setText(productsquantity.get(position).getName());
        System.out.println("HOLDER: " + holder.name);
        holder.quantity.setText(productsquantity.get(position).getQuantity().toString());
        System.out.println("HOLDER: " + holder.quantity);


        return row;
    }


    static class ProductHolder
    {
        TextView name;
        TextView quantity;

    }

}



