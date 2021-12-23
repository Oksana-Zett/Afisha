package manager;

import domain.AfishaFilm;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PostManagerTest {
    private final PostManager manager = new PostManager();
    private final AfishaFilm bladshot = new AfishaFilm(1, "Bladshot", "thriller", 2021);
    private final AfishaFilm vpered = new AfishaFilm(2, "Vpered", "cartoon", 2021);
    private final AfishaFilm otelBelgrad = new AfishaFilm(3, "OtelBelgrad", "comedy", 2021);
    private final AfishaFilm dzhentlmeny = new AfishaFilm(4, "Dzhentlmeny", "thriller", 2021);
    private final AfishaFilm chelovekNevidimka = new AfishaFilm(5, "Chelovek-nevidimka", "horror", 2021);
    private final AfishaFilm trollyMirovoiTur = new AfishaFilm(6, "Trolly. Mirovoi tur", "cartoon", 2021);
    private final AfishaFilm nomerOdin = new AfishaFilm(7, "Nomer odin", "comedy", 2021);
    private final AfishaFilm matrix = new AfishaFilm(8, "Matrix", "thriller", 2021);
    private final AfishaFilm forsazh = new AfishaFilm(9, "Forsazh", "thriller", 2021);
    private final AfishaFilm chelovekPauk = new AfishaFilm(10, "Chelovek pauk", "fantasy", 2021);
    private final AfishaFilm ostrovFantasiy = new AfishaFilm(11, "Ostrov fantasiy", "horror", 2021);

    @BeforeEach
    public void shouldSetUp() {
        manager.add(bladshot);
        manager.add(vpered);
        manager.add(dzhentlmeny);
        manager.add(chelovekNevidimka);
        manager.add(trollyMirovoiTur);
        manager.add(nomerOdin);
        manager.add(matrix);
        manager.add(forsazh);
        manager.add(chelovekPauk);
        manager.add(ostrovFantasiy);
    }

    @Test
    public void shouldUseConstructor () {
        PostManager manager = new PostManager(50);
        Assertions.assertEquals (50, manager.getLimit());
    }

    @Test
    public void shouldUseNoArgsConstructor () {
        PostManager manager = new PostManager();

        assertEquals(10, manager.getLimit());
    }

    @Test
    public void shouldSave () {
        manager.save(bladshot);
        manager.save(vpered);
        manager.save(dzhentlmeny);
        manager.save(chelovekNevidimka);
        manager.save(trollyMirovoiTur);
        manager.save(nomerOdin);
        manager.save(matrix);
        manager.save(forsazh);
        manager.save(chelovekPauk);
        manager.save(ostrovFantasiy);
    }

    @Test
    public void shouldAdd() {
        final AfishaFilm reproduction = new AfishaFilm(124, "Reproduction", "fantasy", 2018);
        manager.add(reproduction);
        AfishaFilm[] actual = manager.getAll();
        AfishaFilm[] expected = new AfishaFilm[]{
                reproduction,
                ostrovFantasiy,
                chelovekPauk,
                forsazh,
                matrix,
                nomerOdin,
                trollyMirovoiTur,
                chelovekNevidimka,
                dzhentlmeny,
                vpered,
                bladshot,
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAllWhenOneObject () {
        PostManager manager = new PostManager();
        manager.add(bladshot);
        AfishaFilm[] actual = manager.getAll();
        AfishaFilm[] expected = new AfishaFilm[]{
                bladshot,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastItem() {

        AfishaFilm[] actual = manager.getLastItem();
        AfishaFilm[] expected = new AfishaFilm[]{
                ostrovFantasiy,
                chelovekPauk,
                forsazh,
                matrix,
                nomerOdin,
                trollyMirovoiTur,
                chelovekNevidimka,
                dzhentlmeny,
                vpered,
                bladshot
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastItemLimit() {
        PostManager manager = new PostManager();
        manager.add (bladshot);
        manager.add (vpered);
        manager.add (dzhentlmeny);

        AfishaFilm[] actual = manager.getLastItem();
        AfishaFilm[] expected = new AfishaFilm[]{
                dzhentlmeny,
                vpered,
                bladshot
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastItemOne() {
        PostManager manager = new PostManager();
        manager.add (vpered);

        AfishaFilm[] actual = manager.getLastItem();
        AfishaFilm[] expected = new AfishaFilm[]{
                vpered,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        AfishaFilm[] actual = manager.findAll();
        AfishaFilm[] expected = new AfishaFilm[]{
                bladshot,
                vpered,
                dzhentlmeny,
                chelovekNevidimka,
                trollyMirovoiTur,
                nomerOdin,
                matrix,
                forsazh,
                chelovekPauk,
                ostrovFantasiy,
        };
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 2;

        manager.removeById(idToRemove);

        AfishaFilm[] actual = manager.getAll();
        AfishaFilm[] expected = new AfishaFilm[]{
                ostrovFantasiy,
                chelovekPauk,
                forsazh,
                matrix,
                nomerOdin,
                trollyMirovoiTur,
                chelovekNevidimka,
                dzhentlmeny,
                bladshot,
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 16;

        manager.removeById(idToRemove);

        AfishaFilm[] actual = manager.getAll();
        AfishaFilm[] expected = new AfishaFilm[]{
                ostrovFantasiy,
                chelovekPauk,
                forsazh,
                matrix,
                nomerOdin,
                trollyMirovoiTur,
                chelovekNevidimka,
                dzhentlmeny,
                vpered,
                bladshot,
        };
        Assertions.assertArrayEquals(expected, actual);
    }
}