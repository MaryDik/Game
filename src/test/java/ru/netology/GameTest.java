package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "Anna", 10);
    Player player2 = new Player(2, "Boris", 200);
    Player player3 = new Player(3, "Ivan", 50);
    Player player4 = new Player(4, "Maria", 120);
    Player player5 = new Player(5, "Alex", 120);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void secondPlayerIsNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "player6");
        });
    }

    @Test
    public void firstPlayerIsNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("player6", "Ivan");
        });

    }

    @Test
    public void firstPlayerWinner() {
        int expected = 1;
        int actual = game.round("Boris", "Maria");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWinner() {
        int expected = 2;
        int actual = game.round("Anna", "Maria");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenTheDraw() {
        int expected = 0;
        int actual = game.round("Alex", "Maria");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testingGetters() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {player1.getId(), player2.getId(), player3.getId(), player4.getId(), player5.getId()};
        Assertions.assertArrayEquals(expected, actual);

    }
}


