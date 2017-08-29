package ex1.lauri.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> carList = new ArrayList<String>();

    private static void getCars() {
        carList.add("AlfaRomeo");
        carList.add("BMW");
        carList.add("Corvette");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCars();

        final ListView myListView = (ListView) findViewById(R.id.myListView);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carList);
        myListView.setAdapter(aa);

        // For add button
        Button addCar = (Button) findViewById(R.id.button1);
        final EditText line = (EditText) findViewById(R.id.editText1);

        addCar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                String mark = line.getText().toString();
                carList.add(mark);
                myListView.setAdapter(aa);

            }
        });

        // For edit button
        Button editCar = (Button) findViewById(R.id.button2);

        editCar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                        String selectedCar = carList.get(position);
                        Toast.makeText(getApplicationContext(), "Car Selected: " + selectedCar, Toast.LENGTH_SHORT).show();
                        line.setText(selectedCar);
                    }
                });
            }
        });

        // For remove button
        Button removeCar = (Button) findViewById(R.id.button3);

        removeCar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                        String selectedCar = carList.get(position);
                        Toast.makeText(getApplicationContext(), "Car Selected to remove: " + selectedCar, Toast.LENGTH_SHORT).show();
                        line.setText(selectedCar);
                    }
                });
                String mark = line.getText().toString();
                carList.remove(mark);
                myListView.setAdapter(aa);

            }
        });

        // For 2nd button
        Button secondActivity = (Button) findViewById(R.id.button4);

        secondActivity.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Second Activity Selected: ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
                // callIntent.setData(Uri.parse(callData));
                // startActivity(callIntent);
            }
        });
    }
}
