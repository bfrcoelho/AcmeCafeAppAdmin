package com.example.acmecafe.acmecafeappadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectedRequestActivity extends AppCompatActivity {


    final ArrayList<ProductQuantity> product_quantity = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_request);

        Bundle b = getIntent().getExtras();
        final String id = (String) b.get("request_id");


        Button serve = findViewById(R.id.serve_button);


        //Por o id do request escolhido no topo da página
        TextView requestID = findViewById(R.id.request_id);
        requestID.setText(id);

        final ArrayList<Product> products = new ArrayList<>();
        final ArrayList<Quantity> quantitys = new ArrayList<>();


        //Button start_finish = findViewById(R.id.start_finish);
        // checkRequestState(id);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Request").child(id).child("Produtos");

        reference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();


                for (final DataSnapshot product : children) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference reference = database.getReference("Produtos").child(product.child("id_product").getValue().toString());

                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            Product productObj = dataSnapshot.getValue(Product.class);
                            productObj.setId_product(Integer.parseInt(dataSnapshot.getKey()));


//                            Quantity quantity = product.child("Quantity").getValue(Quantity.class);
                            Long quantity = (Long) product.child("Quantity").getValue();

                            ProductQuantity productquantity = new ProductQuantity(productObj, quantity);
                            product_quantity.add(productquantity);



                            showProducts(product_quantity);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }


            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        serve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference reference = database.getReference("Request").child(id).child("Estado Pedido");
                reference.setValue(true);
                Intent intent = new Intent(SelectedRequestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void showProducts(ArrayList<ProductQuantity> productsQuantity){

        final ListView products = findViewById(R.id.products);

        final RequestProductAdapter adapter =  new RequestProductAdapter(this,
                R.layout.request_product_item_row, productsQuantity);

        products.setAdapter(adapter);

    }
}
