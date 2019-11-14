package com.example.practice_1108;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
class Fragment2 extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<Item> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment2,container,false);
        recyclerView=v.findViewById(R.id.recycler);
        recyclerView.setAdapter(new MyAdapter());

        DBHelper dbHelper= new DBHelper(getContext());
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select * from tb_gallery";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);

        list= new ArrayList<>();
        while (cursor.moveToNext()){
            String image=cursor.getString(1);
            String title=cursor.getString(2);
            String count=cursor.getString(3);
            Item item= new Item();
            item.image=image;
            item.title=title;
            item.count=count;

            list.add(item);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return v;
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v= (View) LayoutInflater.from(getContext()).inflate(R.layout.item,viewGroup,false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

            Item item= list.get(i);
            myViewHolder.countView.setText(item.count);
            myViewHolder.titleView.setText(item.title);
            if (item.image.equals("img01"))
                myViewHolder.imageView.setImageResource(R.drawable.img01);
            if (item.image.equals("img02"))
                myViewHolder.imageView.setImageResource(R.drawable.img02);
            if (item.image.equals("img03"))
                myViewHolder.imageView.setImageResource(R.drawable.img03);
            if (item.image.equals("img04"))
                myViewHolder.imageView.setImageResource(R.drawable.img02);
            if (item.image.equals("img05"))
                myViewHolder.imageView.setImageResource(R.drawable.img01);
            if (item.image.equals("img06"))
                myViewHolder.imageView.setImageResource(R.drawable.img06);
            if (item.image.equals("img07"))
                myViewHolder.imageView.setImageResource(R.drawable.img06);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleView,countView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            titleView=itemView.findViewById(R.id.title);
            countView=itemView.findViewById(R.id.count);

        }
    }

    class MyItemDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int pos=parent.getChildAdapterPosition(view);
            if (pos%2==0){
                outRect.set(20,20,90,70);
                view.setBackgroundColor(0xffeeeeee);

            }else{
                outRect.set(20,20,90,70);
                ViewCompat.setElevation(view,10.0f);
            }

        }
    }
}
