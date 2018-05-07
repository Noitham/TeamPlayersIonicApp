
package teamdaoapp.model.persist;

import java.util.List;
import teamdaoapp.model.Player;
import teamdaoapp.model.Team;

/**
 *
 * @author Daniel Morales
 */
public interface PlayerDaoInterface {
    
    /**
     * Adds a new player to the base data
     * @param player to add
     * @return 
     */
    int insert(Player player);
    
    /**
     *  deletes the given entity from the data base
     * @param player
     * @return 
     */
    int delete(Player player);
    
    /**
     * retrieves all data
     * @return all data
     */
    List<Player> findAll();
    
    /**
     * 
     * @param player
     * @return the player you have searched for.
     */
    
    Player find(Player player);
    
    /**
     *  It search at base dta the name of 
     * the team u looked for
     * @param name
     * @return the team you searched
     */
    List<Player> findByName(String name);
    
    /**
     *  modifies oldFilm to newFilm values
     * @param oldEntity
     * @param newEntity
     * @return the number of entries affected
     */
    int update(Player oldEntity, Player newEntity);
    
    int update1(Player player);
    
    /**
     * Searches by id and list the results
     * @param team
     * @return the teams found.
     */
     public List<Player> findByTeam(Team team);
}
