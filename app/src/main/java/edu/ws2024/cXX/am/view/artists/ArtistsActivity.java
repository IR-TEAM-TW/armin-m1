package edu.ws2024.cXX.am.view.artists;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.adapters.ArtistAdapter;
import edu.ws2024.cXX.am.data.Artist;
import edu.ws2024.cXX.am.databinding.ActivityArtistsBinding;
import edu.ws2024.cXX.am.utils.ArtistGenerator;

public class ArtistsActivity extends AppCompatActivity {

    private ActivityArtistsBinding binding;
    private List<Artist> artists = ArtistGenerator.getArtists();
    private ArtistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists);
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adapter = new ArtistAdapter(this, artists);
        binding.artistsList.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        binding.artistsList.setAdapter(adapter);
    }
}