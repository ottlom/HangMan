package storage;

import model.Player;

import java.util.*;

public class InMemoryPlayerStorage implements Storage {
    private static InMemoryPlayerStorage STORAGE;
    private static final Map<String, Player> playersMap = new HashMap<>();

    private InMemoryPlayerStorage() {
    }

    public static InMemoryPlayerStorage getStorage() {
        if (STORAGE == null) {
            STORAGE = new InMemoryPlayerStorage();
        }
        return STORAGE;
    }

    @Override
    public Player save(Player player) {
        return playersMap.put(player.getNickName(), player);
    }

    @Override
    public Player update(Player player) {
        return playersMap.computeIfAbsent(player.getNickName(), nickName -> playersMap.put(nickName, player));
    }

    @Override
    public void delete(String nickName) {
        playersMap.remove(nickName);
    }

    @Override
    public Player get(String nickName) {
        Player player = playersMap.get(nickName);
        return player == null ? null : playersMap.get(nickName);
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(playersMap.values());
    }
}