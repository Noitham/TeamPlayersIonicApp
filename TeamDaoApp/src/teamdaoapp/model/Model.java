
package teamdaoapp.model;

import java.util.List;
import teamdaoapp.model.persist.TeamArrayDao;
import teamdaoapp.model.persist.TeamDaoInterface;
import teamdaoapp.model.persist.PlayerArrayDao;
import teamdaoapp.model.persist.PlayerDaoInterface;

/**
 *
 * @author Daniel Morales
 */
public class Model {

    //We call for the interfaces and declare them
    private TeamDaoInterface teamDao;
    private PlayerDaoInterface playerDao;

    
    public Model() {
        teamDao = TeamArrayDao.getInstance();
        playerDao = PlayerArrayDao.getInstance();
    }

    //Implementing find method for Teams
    public Team find(Team team) {
        return teamDao.find(team);
    }

    public List<Team> findAllTeams() {
        return teamDao.findAll();

    }

    public List<Team> findTeamsByName(String name) {
        return teamDao.findByName(name);
    }

    public int add(Team team) {
        return teamDao.insert(team);
    }

    public int modify(Team oldEntity, Team newEntity) {
        return teamDao.update(oldEntity, newEntity);
    }
    
    public int modify1(Team team) {
        return teamDao.update1(team);
    }

    public int remove(Team team) {
        return teamDao.delete(team);
    }

    //Player
    public Player find(Player player) {
        return playerDao.find(player);
    }

    public List<Player> findAllPlayers() {
        return playerDao.findAll();

    }

    public List<Player> findPlayersByName(String name) {
        return playerDao.findByName(name);
    }

    public List<Player> findPlayersByTeam(Team team) {
        return playerDao.findByTeam(team);
    }

    public List<Player> findPlayersByTeamId(long teamId) {
        return playerDao.findByTeam(new Team(teamId));
    }

    public int add(Player player) {
        return playerDao.insert(player);
    }

    public int modify(Player oldEntity, Player newEntity) {
        return playerDao.update(oldEntity, newEntity);
    }
    
    public int modify1(Player player) {
        return playerDao.update1(player);
    }

    public int remove(Player player) {
        return playerDao.delete(player);
    }

}
