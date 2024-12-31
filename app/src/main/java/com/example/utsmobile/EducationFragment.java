package com.example.utsmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsmobile.ApiClient;
import com.example.utsmobile.ApiService;
import com.example.utsmobile.Book;
import com.example.utsmobile.BookAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        recyclerView = view.findViewById(R.id.rv_edukasi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchBooks();
        return view;
    }

    private void fetchBooks() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Book>> call = apiService.getEducationBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Set adapter dengan data yang diterima dari API
                    adapter = new BookAdapter(response.body(), getContext());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("EducationFragment", "Error fetching books", t);
            }
        });
    }
}
