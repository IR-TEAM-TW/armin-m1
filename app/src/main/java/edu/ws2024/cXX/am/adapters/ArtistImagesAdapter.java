package edu.ws2024.cXX.am.adapters;

import static android.view.View.VISIBLE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.databinding.ImageItemViewBinding;

public class ArtistImagesAdapter extends RecyclerView.Adapter<ArtistImagesAdapter.ViewHolder> {

    private Context context;
    private List<Integer> images;
    private int frameSet = 1;

    public ArtistImagesAdapter(Context context, List<Integer> images, int frameSet) {
        this.context = context;
        this.images = images;
        this.frameSet = frameSet;
    }

    enum ImageFrame {
        CIRCLE,
        DOWN_ROUND,
        UP_ROUND,
        RECTANGLE
    }

    private final ImageFrame[] framesSet1 = new ImageFrame[] { ImageFrame.CIRCLE, ImageFrame.DOWN_ROUND, ImageFrame.RECTANGLE };
    private final ImageFrame[] framesSet2 = new ImageFrame[] { ImageFrame.UP_ROUND, ImageFrame.CIRCLE, ImageFrame.DOWN_ROUND };
    private final ImageFrame[] framesSet3 = new ImageFrame[] { ImageFrame.UP_ROUND, ImageFrame.RECTANGLE, ImageFrame.CIRCLE };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageItemViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.image_item_view,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer image = images.get(position);
        ImageFrame[] imageFrame = null;

        if (frameSet == 1) {
            imageFrame = framesSet1;
        }
        else if (frameSet == 2) {
            imageFrame = framesSet2;
        }
        else {
            imageFrame = framesSet3;
        }

        if (imageFrame[position] == ImageFrame.CIRCLE) {
            holder.binding.circle.setVisibility(VISIBLE);
            holder.binding.imgCircle.setImageResource(image);
        }
        else if (imageFrame[position] == ImageFrame.RECTANGLE) {
            holder.binding.rect.setVisibility(VISIBLE);
            holder.binding.imgRect.setImageResource(image);
        }
        else if (imageFrame[position] == ImageFrame.UP_ROUND) {
            holder.binding.upRound.setVisibility(VISIBLE);
            holder.binding.imgUpRound.setImageResource(image);
        }
        else  {
            holder.binding.downRound.setVisibility(VISIBLE);
            holder.binding.imgDownRound.setImageResource(image);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageItemViewBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull ImageItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
