package storage;

import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPlayerStorage implements Storage {
    private static final Map<Integer, Player> playersMap = new HashMap<>();

    private InMemoryPlayerStorage() {
    }

    @Override
    public void save(Player player) {
        playersMap.put(player.getId(), player);
    }

    @Override
    public void update(Player player) {
        playersMap.computeIfAbsent(player.getId(), id -> playersMap.put(id, player));
    }

    @Override
    public void delete(int id) {
        playersMap.remove(id);
    }

    @Override
    public void get(int id) {
        playersMap.get(id);
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(playersMap.values());
    }
}
