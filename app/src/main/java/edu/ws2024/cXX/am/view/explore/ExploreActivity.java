package edu.ws2024.cXX.am.view.explore;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.databinding.ActivityExploreBinding;
import edu.ws2024.cXX.am.view.artists.ArtistsActivity;
import edu.ws2024.cXX.am.view.home.MainActivity;
import edu.ws2024.cXX.am.view.ticketing.TicketingActivity;

public class ExploreActivity extends AppCompatActivity {

    ActivityExploreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_explore);
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnGallery.setOnClickListener(v -> startActivity(new Intent(ExploreActivity.this, ArtistsActivity.class)));
        binding.btnTickets.setOnClickListener(v -> startActivity(new Intent(ExploreActivity.this, TicketingActivity.class)));
    }
}