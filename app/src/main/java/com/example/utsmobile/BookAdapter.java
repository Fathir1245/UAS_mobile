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

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final List<Book> books;  // Menggunakan List<Book> sesuai dengan model yang digunakan
    private final Context context;
    private final int[] photoArray;  // Array untuk gambar

    // Konstruktor yang benar, menerima List<Book> dan Context
    public BookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
        // Mengambil gambar-gambar dari resources menggunakan context
        TypedArray images = context.getResources().obtainTypedArray(R.array.data_photo);
        photoArray = new int[images.length()];
        for (int i = 0; i < images.length(); i++) {
            photoArray[i] = images.getResourceId(i, -1);
        }
        images.recycle(); // Jangan lupa untuk melepaskan TypedArray
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.description.setText(book.getDescription());
        holder.publisher.setText(book.getPublisher());
        holder.synopsis.setText(book.getSynopsis());

        // Menampilkan gambar berdasarkan posisi, mengambil gambar dari array
        int imageResId = photoArray[position % photoArray.length];  // Menggunakan modulo untuk mengulang gambar
        holder.bookImage.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, publisher, synopsis;
        ImageView bookImage;  // ImageView untuk gambar

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.book_title);
            description = itemView.findViewById(R.id.book_description);
            publisher = itemView.findViewById(R.id.book_publisher);
            synopsis = itemView.findViewById(R.id.book_synopsis);
            bookImage = itemView.findViewById(R.id.book_image);
        }
    }
}
