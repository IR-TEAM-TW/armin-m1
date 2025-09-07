package edu.ws2024.cXX.am.utils;

import java.util.ArrayList;
import java.util.List;

import edu.ws2024.cXX.am.R;
import edu.ws2024.cXX.am.data.Artist;

public class ArtistGenerator {
    public static List<Integer> getDaVinciImages() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.mona_lisa);
        images.add(R.drawable.lady_ermine);
        images.add(R.drawable.litta_madonna);
        return images;
    }

    public static List<Integer> getMichelangeloImages() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.delphic_sibyl);
        images.add(R.drawable.torment_of_saint_anthony);
        images.add(R.drawable.david);
        return images;
    }

    public static List<Integer> getKlimtImages() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.the_kiss);
        images.add(R.drawable.adele_bloch_bauer);
        images.add(R.drawable.lady_with_fan);
        return images;
    }

    public static List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();

        artists.add(new Artist(
                R.drawable.leonardo_da_vinci,
                "Leonardo da Vinci",
                1452,
                1519,
                getDaVinciImages()
        ));

        artists.add(new Artist(
                R.drawable.michelangelo,
                "Michelangelo",
                1475,
                1564,
                getMichelangeloImages()
        ));

        artists.add(new Artist(
                R.drawable.gustav_klimt,
                "Gustav Klimt",
                1862,
                1918,
                getKlimtImages()
        ));

        return artists;
    }
}
