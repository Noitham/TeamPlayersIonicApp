
package teamdaoapp.model;

/**
 *
 * @author Daniel Morales
 */
public class Team {
    
    //We define attributes
    private long id;
    private String name;
    private String desc;

    //We create constructors
    public Team(long id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Team(Team f){
            
        this.id = f.id;
    }
    
    
    public Team() {
    }
    
   
    public Team(long id) {
        this.id = id;
    }
    
    
    //We create getters and setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //Overrides
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Team {");
        sb.append("id= "); sb.append(id);
        sb.append(", name= "); sb.append(name);
        sb.append(", description= "); sb.append(desc);       
        sb.append("}.");
        return sb.toString();
    }

}
