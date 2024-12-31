package com.example.utsmobile;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CeritaAdapter extends RecyclerView.Adapter<CeritaAdapter.BookViewHolder> {

    private final List<Book2> books;
    private final Context context;
    private final int[] photoArray; // Array untuk gambar cerita

    // Constructor
    public CeritaAdapter(List<Book2> books, Context context) {
        this.books = books;
        this.context = context;

        // Mendapatkan array gambar dari resources
        TypedArray images = context.getResources().obtainTypedArray(R.array.cerita_photo); // Pastikan array ini ada di `res/values/arrays.xml`
        photoArray = new int[images.length()];
        for (int i = 0; i < images.length(); i++) {
            photoArray[i] = images.getResourceId(i, -1);
        }
        images.recycle(); // Jangan lupa untuk melepaskan TypedArray
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menginflate layout item untuk cerita
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        // Mengambil item dari daftar cerita
        Book2 book = books.get(position);

        // Mengatur data ke TextView
        holder.title.setText(book.getTitle());
        holder.description.setText(book.getDescription());
        holder.synopsis.setText(book.getSynopsis());

        // Menampilkan gambar berdasarkan posisi, menggunakan array "cerita"
        int imageResId = photoArray[position % photoArray.length]; // Modulo untuk mengulang gambar jika jumlah data lebih banyak dari gambar
        holder.bookImage.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return books.size(); // Mengembalikan jumlah item dalam daftar cerita
    }

    // ViewHolder untuk setiap item cerita
    static class BookViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, synopsis;
        ImageView bookImage; // ImageView untuk gambar cerita

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            // Menghubungkan View dengan ID di layout item
            title = itemView.findViewById(R.id.book_title);
            description = itemView.findViewById(R.id.book_description);
            synopsis = itemView.findViewById(R.id.book_synopsis);
            bookImage = itemView.findViewById(R.id.book_image);
        }
    }
}
