package com.example.acmecafe.acmecafeappadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;

public class list_of_requests extends AppCompatActivity {


    ArrayList<Request> requests = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_requests);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Request");
        GetRequests();

    }

    public void GetRequests() {

        //final ArrayList<Request> requests = new ArrayList<>();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Request");



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();


                for (final DataSnapshot request : children) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference estado = database.getReference("Requests").child(request.child("Estado Pedido").getValue().toString());

                    if(estado.toString().equals("https://acme-cafe-app.firebaseio.com/Requests/false")) {
                        System.out.println("request--->" + request.toString());
                    Request w = new Request(request.getKey());
                        System.out.println("id_request: " + request.getKey());
                        System.out.println("w------> "+ w);
                    requests.add(w);
                    }
                }

                showRequests(requests);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }

    public void showRequests(ArrayList<Request> requestsToShow) {

        final ListView requests = findViewById(R.id.ListOfRequests);

        final ArrayAdapter<Request> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, requestsToShow);

        requests.setAdapter(adapter);

        requests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Request requ = adapter.getItem(position);

                Intent intent = new Intent(list_of_requests.this, SelectedRequestActivity.class);
                intent.putExtra("request_id", requ.id);
                startActivity(intent);

            }
        });

    }
}

