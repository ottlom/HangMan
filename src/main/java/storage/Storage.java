package storage;

import model.Player;

import java.util.List;

public interface Storage {
    void save(Player player);

    void update(Player player);

    void delete(int id);

    void get(int id);

    List<Player> getAll();
}
