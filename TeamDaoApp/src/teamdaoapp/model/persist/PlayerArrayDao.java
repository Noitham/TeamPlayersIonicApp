
package teamdaoapp.model.persist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import teamdaoapp.model.Player;
import teamdaoapp.model.Team;

public class PlayerArrayDao implements PlayerDaoInterface {

    private final List<Player> dataSource;
    private static PlayerArrayDao instance;

    public static PlayerArrayDao getInstance() {

        if (instance == null) {

            instance = new PlayerArrayDao();
        }

        return instance;

    }

    private PlayerArrayDao() {
        dataSource = new ArrayList<>();
    }

    //Methods  
    @Override
    public int insert(Player player) {
        int rowsAffected;
        boolean alreadyExists = dataSource.contains(player);
        if (alreadyExists) {
            rowsAffected = 0;
        } else {
            boolean success = dataSource.add(player);
            if (success) {
                rowsAffected = 1;
            } else {
                rowsAffected = 0;
            }
        }
        return rowsAffected;
    }

    /**
     *
     * @param player
     * @return updated player
     */
    @Override
    public int update1(Player player) {
        int res = 0;
        for (Player t : dataSource) {
            if (t.equals(player)) {

                t.setName(player.getName());
                t.setYearBirth(player.getYearBirth());
                t.setTeamId(player.getTeamId());
                res = 1;
                break;

            } else {
                res = 0;
            }
        }
        return res;
    }

    @Override
    public int delete(Player player) {
        int rowsAffected;
        if (dataSource.contains(player)) {
            dataSource.remove(player);
            rowsAffected = 1;
        } else {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    @Override
    public List<Player> findAll() {
        return (List<Player>) dataSource;
    }

    @Override
    public Player find(Player player) {
        Player playerFound;
        int index = dataSource.indexOf(player);
        if (index >= 0) {
            playerFound = dataSource.get(index);
        } else {
            playerFound = null;
        }
        return playerFound;
    }
    
       @Override
    public List<Player> findByName(String name) {
        List<Player> found = new ArrayList<>();
        for (int i=0; i<dataSource.size(); i++) {
            Player p = dataSource.get(i);
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    
    
    @Override
    public List<Player> findByTeam(Team team) {
        List<Player> list2 = new ArrayList<>();
        Player c;
        Iterator<Player> iter = list2.iterator();
        while (iter.hasNext()) {
            c = iter.next();
            if (team.getId() == c.getTeamId()) {
                list2.add(c);
            }
        }
        return list2;

    }

    @Override
    public int update(Player oldEntity, Player newEntity) {
        //TODO avoid duplicates.
        int rowsAffected;
        int index = dataSource.indexOf(oldEntity);
        if (index >= 0) {
            dataSource.set(index, newEntity);
            rowsAffected = 1;
        }
        else {
            rowsAffected = 0;
        }
        return rowsAffected;    
    }
}
