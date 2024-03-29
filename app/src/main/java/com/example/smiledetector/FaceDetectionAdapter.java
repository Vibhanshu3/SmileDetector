package com.example.smiledetector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.List;

public class FaceDetectionAdapter extends RecyclerView.Adapter<FaceDetectionAdapter
        .ViewHolder> {

    private List<FaceDetectionModel> faceDetectionModelList;
    private Context context;

    public FaceDetectionAdapter(List<FaceDetectionModel> faceDetectionModelList, Context context) {
        this.faceDetectionModelList = faceDetectionModelList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_face_detection, parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FaceDetectionModel faceDetectionModel = faceDetectionModelList.get(position);
        holder.text1.setText(MessageFormat.format("Face: {0}", String.valueOf(faceDetectionModel.getId())));
        holder.text2.setText(MessageFormat.format("Face: {0}", faceDetectionModel.getText()));

    }

    @Override
    public int getItemCount() {
        return faceDetectionModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text1;
        private TextView text2;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            text1 = itemView.findViewById(R.id.item_face_detection_text_view1);
            text2 = itemView.findViewById(R.id.item_face_detection_text_view2);
        }

    }
}
