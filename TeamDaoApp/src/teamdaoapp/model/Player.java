package teamdaoapp.model;

import java.util.Objects;

/**
 *
 * @author Daniel Morales
 */
public class Player {

    //We define attributes
    private long id;
    private String name;
    private int yearBirth;
    private long teamId;

    
    //We create constructors
    public Player(long id, String name, int yearBirth) {
        this.id = id;
        this.name = name;
        this.yearBirth = yearBirth;

    }

    public Player(long id, String name, int yearBirth, long teamId) {
        this.id = id;
        this.name = name;
        this.yearBirth = yearBirth;
        this.teamId = teamId;
    }

    public Player() {
    }

    public Player(long id) {
        this.id = id;
    }
    
    public Player(String name) {
        this.name = name;
    }

    public Player(Player other) {
        this.id = other.id;
        this.name = other.name;
        this.yearBirth = other.yearBirth;
        this.teamId = other.teamId;
    }

    //We create getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + this.yearBirth;
        hash = 61 * hash + (int) (this.teamId ^ (this.teamId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
                
        sb.append("Player{");
        sb.append("id= "); sb.append(id);
        sb.append(", name= "); sb.append(name);
        sb.append(", yearBirth= ");sb.append( yearBirth);
        sb.append(", teamId= ");sb.append( teamId);
        sb.append('}');
        return sb.toString();               
    }
    

}
