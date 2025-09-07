package edu.ws2024.cXX.am.view.ticketing;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.databinding.ActivityTicketingBinding;

public class TicketingActivity extends AppCompatActivity {

    private ActivityTicketingBinding binding;
    private int normal = 2;
    private int special = 1;
    private final int per_normal_ticket = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ticketing);
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnAddNormal.setOnClickListener(v -> {
            if (normal < 9) {
                binding.quantityNormal.setText(String.valueOf(++normal));
                binding.txtTotal.setText("Total: €" + String.valueOf(normal * per_normal_ticket));
            }
        });

        binding.btnDecNormal.setOnClickListener(v -> {
            if (normal > 0) {
                binding.quantityNormal.setText(String.valueOf(--normal));
                binding.txtTotal.setText("Total: €" + String.valueOf(normal * per_normal_ticket));
            }
        });


        binding.btnAddSpec.setOnClickListener(v -> {
            if (special < 9) {
                binding.quantitySpec.setText(String.valueOf(++special));
            }
        });

        binding.btnDecSepc.setOnClickListener(v -> {
            if (special > 0) {
                binding.quantitySpec.setText(String.valueOf(--special));
            }
        });
    }
}