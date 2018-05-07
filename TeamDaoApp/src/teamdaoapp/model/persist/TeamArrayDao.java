
package teamdaoapp.model.persist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import teamdaoapp.model.Team;

/**
 *
 * @author Daniel Morales
 */
public class TeamArrayDao implements TeamDaoInterface {

    private final List<Team> dataSource;
    private static TeamArrayDao instance;

    public static TeamArrayDao getInstance() {

        if (instance == null) {

            instance = new TeamArrayDao();
        }

        return instance;
    }

    private TeamArrayDao() {
        dataSource = new ArrayList<>();
    }

    //METHODS
   /**
    * this method is used to insert a team in the app
    * @param film
    * @return 
    */
    @Override
    public int insert(Team film) {
        int rowsAffected;
        boolean alreadyExists = dataSource.contains(film);
        if (alreadyExists) {
            rowsAffected = 0;
        } else {
            boolean success = dataSource.add(film);
            if (success) {
                rowsAffected = 1;
            } else {
                rowsAffected = 0;
            }
        }
        return rowsAffected;
    }

   /**
    * this method is used to update a team
    * @param team
    * @return 
    */
    @Override
    public int update1(Team team) {
        int res = 0;
        for (Team t : dataSource) {
            if (t.equals(team)) {

                t.setName(team.getName());
                t.setDesc(team.getDesc());
                res = 1;
                break;
            } else {
                res = 0;
            }
        }
        return res;
    }

   /**
    * This method is used to delete a team from the app
    * @param film
    * @return 
    */
    @Override
   
    public int delete(Team film) {
        int rowsAffected;
        if (dataSource.contains(film)) {
            dataSource.remove(film);
            rowsAffected = 1;
        } else {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    /**
     * this method is used to find all teams
     * @return 
     */
    @Override
    public List<Team> findAll() {
        return (List<Team>) dataSource;
    }
    /**
     * this method is used to find one team
     * @param team
     * @return 
     */
    @Override
    public Team find(Team team) {
        Team teamFound;
        int index = dataSource.indexOf(team);
        if (index >= 0) {
            teamFound = dataSource.get(index);
        } else {
            teamFound = null;
        }
        return teamFound;
    }

       @Override
    public List<Team> findByName(String name) {
        List<Team> found = new ArrayList<>();
        for (int i=0; i<dataSource.size(); i++) {
            Team t = dataSource.get(i);
            if (t.getName().equals(name)) {
                found.add(t);
            }
        }
        return found;
    }
    
    @Override
    public int update(Team oldEntity, Team newEntity) {
        //TODO avoid phone duplicates.
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
