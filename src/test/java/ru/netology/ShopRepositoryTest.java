package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void shouldAddToArray() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);

        Product[] actual = repository.findAll();
        Product[] expected = {game, toy, food};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);

        Product actual = repository.findById(3);
        Product expected = toy;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindById() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);

        Product actual = repository.findById(6);
        Product expected = null;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);

        repository.remove(2);

        Product[] actual = repository.findAll();
        Product[] expected = {game, toy};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotRemoveById() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(12321);
        });

    }

    @Test
    public void shouldNotAddExisting() {
        Product game = new Product(1, "Game", 100);
        Product food = new Product(2, "Food", 10);
        Product toy = new Product(3, "Toy", 50);
        ShopRepository repository = new ShopRepository();

        repository.add(game);
        repository.add(toy);
        repository.add(food);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(toy);
        });

    }
}