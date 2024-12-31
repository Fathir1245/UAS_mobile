package com.example.utsmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private CeritaAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);

        recyclerView = view.findViewById(R.id.rv_cerita);  // Pastikan ID sesuai dengan layout XML Anda
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchBooks();  // Memanggil metode untuk mendapatkan data buku

        return view;
    }

    private void fetchBooks() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Book2>> call = apiService.getstoryBooks();  // Pastikan nama method sesuai dengan API Service

        call.enqueue(new Callback<List<Book2>>() {
            @Override
            public void onResponse(Call<List<Book2>> call, Response<List<Book2>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Menggunakan adapter CeritaAdapter untuk menampilkan data yang diterima
                    adapter = new CeritaAdapter(response.body(), getContext());
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("StoryFragment", "Response not successful");
                }
            }

            @Override
            public void onFailure(Call<List<Book2>> call, Throwable t) {
                Log.e("StoryFragment", "Error fetching books", t);
            }
        });
    }
}
