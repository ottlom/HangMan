package storage;

import model.Player;

import java.util.List;

public interface Storage {
    Player save(Player player);

    Player update(Player player);

    void delete(String nickName);

    Player get(String nickName);

    List<Player> getAll();
}
