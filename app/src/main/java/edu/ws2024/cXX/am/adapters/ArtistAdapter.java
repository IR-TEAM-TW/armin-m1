package edu.ws2024.cXX.am.adapters;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.data.Artist;
import edu.ws2024.cXX.am.databinding.ArtistItemViewBinding;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private Context context;
    private List<Artist> artists;

    public ArtistAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArtistItemViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.artist_item_view,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artist artist = artists.get(position);

        if (position % 2 == 0) {
            holder.binding.headerLtr.setVisibility(VISIBLE);
            holder.binding.imgLtr.setImageResource(artist.getImage());
            holder.binding.txtYearsLtr.setText(artist.getBirth() + "-" + artist.getDeath());
            holder.binding.txtNameLtr.setText(artist.getName());
        }
        else {
            holder.binding.headerRtl.setVisibility(VISIBLE);
            holder.binding.imgRtl.setImageResource(artist.getImage());
            holder.binding.txtYearsRtl.setText(artist.getBirth() + "-" + artist.getDeath());
            holder.binding.txtNameRtl.setText(artist.getName());
        }

//        holder.binding.imagesList.setVisibility(INVISIBLE);

        ArtistImagesAdapter adapter = new ArtistImagesAdapter(context, artist.getImages(), position + 1);
        holder.binding.imagesList.setLayoutManager(new LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                true // position % 2 != 0
        ));
        holder.binding.imagesList.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ArtistItemViewBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull ArtistItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
