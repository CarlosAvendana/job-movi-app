package com.example.form.Actividades;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.form.Adaptador.FormAdapter;
import com.example.form.Helper.RecyclerItemTouchHelper;
import com.example.form.R;
import com.example.form.logic.Form;
import com.example.form.logic.ModelData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ListaFormulariosActivity extends AppCompatActivity implements FormAdapter.FormAdapterListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private RecyclerView mRecyclerView;
    private FormAdapter mAdapter;
    private List<Form> formList;
    private ModelData model;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_formularios);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form List");

        mRecyclerView = findViewById(R.id.recycler_FormulariosFld);
        formList = new ArrayList<>();
        model = ModelData.getInstance();
        formList = model.getFormList();
        mAdapter = new FormAdapter(formList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        

        checkIntentInformation();

        mAdapter.notifyDataSetChanged();
        whiteNotificationBar(mRecyclerView);
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.parseColor("#455A64"));
        }
    }

    @Override
    public void onContactSelected(Form form) {
        Toast.makeText(getApplicationContext(), "Selected", Toast.LENGTH_LONG).show();
    }

    public void goToAddUpdForm() {
        Intent intent = new Intent(this, Formulario.class);
        intent.putExtra("editable", false);
        startActivity(intent);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (direction == ItemTouchHelper.START) {
            if (viewHolder instanceof FormAdapter.MyViewHolder) {
                String name = formList.get(viewHolder.getAdapterPosition()).get_first_name();
                final int deletedIndex = viewHolder.getAdapterPosition();
                mAdapter.removeItem(viewHolder.getAdapterPosition());
                Toast.makeText(getApplicationContext(), name + " removido!", Toast.LENGTH_LONG).show();
            }
        } else {

            Form aux = mAdapter.getSwipedItem(viewHolder.getAdapterPosition());
            Intent intent = new Intent(this, Formulario.class);
            intent.putExtra("editable", true);
            intent.putExtra("Form", aux);
            mAdapter.notifyDataSetChanged();
            startActivity(intent);
        }
    }

    @Override
    public void onItemMove(int source, int target) {
        mAdapter.onItemMove(source, target);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                mAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //TODO it's not working yet
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        Intent a = new Intent(this, NavDrawerActivy.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        super.onBackPressed();
    }

    private void checkIntentInformation() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Form aux;
            aux = (Form) getIntent().getSerializableExtra("addForm");
            if (aux == null) {
                aux = (Form) getIntent().getSerializableExtra("editForm");
                if (aux != null) {
                    //found an item that can be updated
                    boolean founded = false;
                    for (Form carrera : formList) {
                        if (carrera.get_first_name().equals(aux.get_first_name())) {
                            carrera.set_first_name(aux.get_first_name());
                            carrera.set_email_address(aux.get_email_address());
                            founded = true;
                            break;
                        }
                    }

                    if (founded) {
                        Toast.makeText(getApplicationContext(), " Just edited", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry not founded", Toast.LENGTH_LONG).show();
                    }
                }
            } else {

                formList.add(aux);
                Toast.makeText(getApplicationContext(), " Just added", Toast.LENGTH_LONG).show();
            }
        }
    }

}
