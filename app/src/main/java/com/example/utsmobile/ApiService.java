package com.example.utsmobile;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
        @GET("https://siplah.kemdikbud.go.id/sds/lookup-tables/msts/books/text_books.json")
        Call<List<Book>> getEducationBooks();


    @GET("https://siplah.kemdikbud.go.id/sds/lookup-tables/msts/books/non_text_books.json")
    Call<List<Book2>> getstoryBooks();

}

