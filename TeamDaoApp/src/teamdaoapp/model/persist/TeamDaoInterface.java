
package teamdaoapp.model.persist;
import java.util.List;
import teamdaoapp.model.Team;
/**
 *
 * @author Daniel Morales
 */
public interface TeamDaoInterface {
    
    /**
     * Adds a new team to the base data
     * @param team to add
     * @return 
     */
    int insert(Team team);
    
    /**
     *  modifies oldFilm to newFilm values
     * @param oldFilm
     * @param newFilm
     * @return the number of entries affected
     */
   
    
    /**
     *  deletes the given entity from the data base
     * @param team
     * @return 
     */
    int delete(Team team );
    
    /**
     * retrieves all data
     * @return all data
     */
    List<Team> findAll();
    
    /**
     * 
     * @param team
     * @return the team you have searched for.
     */
    
    Team find(Team team);
    
    /**
     *  It search at base dta the name of 
     * the team u looked for
     * @param name
     * @return the team you searched
     */
     List<Team> findByName(String name);

     int update(Team oldEntity, Team newEntity);
     
     int update1(Team team);
     
    
    /**
     * Searches by id and list the results
     * @param id
     * @return the teams found.
     */

    
}
