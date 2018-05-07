package teamdaoapp;

import teamdaoapp.model.Model;
import teamdaoapp.model.Player;
import teamdaoapp.model.Team;

import java.util.List;

/**
 * Model tester
 * @author ProvenSoft
 */
public class ModelTester {
    
    private Model instance;
    private final String msgPass;
    private final String msgFail;
    
    public ModelTester() {
        msgPass = "\n  + Pass";
        msgFail = "\n  - Fail";
    }
    
    public void testFindExistingTeam(Team input) {
        alert("\nTesting find existing team:\t");
        Team result = instance.find(input);
        checkEquals(input, result);
    }
    
    public void testFindNonExistingTeam(Team input) {
        alert("\nTesting find non existing team:\t");
        Team result = instance.find(input);
        checkNull(result);
    }    
    
    public void testFindExistingPlayer(Player input) {
        alert("\nTesting find existing player:\t");
        Player result = instance.find(input);
        checkEquals(input, result);
    }
    
    public void testFindNonExistingPlayer(Player input) {
        alert("\nTesting find non existing player:\t");
        Player result = instance.find(input);
        checkNull(result);
    }     

    public void testFindTeamsByExistingName(String input) {
        alert("\nTesting find teams by existing name:\t");
        List<Team> result = instance.findTeamsByName(input);
        boolean b = true;
    	for (Team elem:  result) {
            b = b && elem.getName().equals(input);
        }      
        if (b)
            alert(this.msgPass);
    	else
            alert(this.msgFail);
    }
 
    public void testFindTeamsByNonExistingName(String input) {
        alert("\nTesting find teams by non existing name:\t");
        List<Team> result = instance.findTeamsByName(input);
        if (result.size() == 0) 
            alert(this.msgPass);
    	else
            alert(this.msgFail);
    }

    public void testFindPlayersByExistingName(String input) {
        alert("\nTesting find players by existing name:\t");
        List<Player> result = instance.findPlayersByName(input);
        boolean b = true;
    	for (Player elem:  result) {
            b = b && elem.getName().equals(input);
        }      
        if (b)
            alert(this.msgPass);
    	else
            alert(this.msgFail);
    }
 
    public void testFindPlayersByNonExistingName(String input) {
        alert("\nTesting find players by non existing name:\t");
        List<Team> result = instance.findTeamsByName(input);
        if (result.size() == 0) 
            alert(this.msgPass);
    	else
            alert(this.msgFail);
    }    
    
    public void testAddTeamOk(Team input) {
        alert("\nTesting add team ok:\t");
        int result = instance.add(input);
        if (result == 1) {
            Team found = instance.find(input);
            checkEquals(input, found);
        } else {
            alert(msgFail);
        }
    }

    public void testAddTeamFail(Team input) {
        alert("\nTesting add team fail:\t");
        int result = instance.add(input);
        if (result == 1) {
            alert(msgFail);
        } else {
            alert(msgPass);
        }
    }

    public void testModifyTeamOk(Team input) {
        alert("\nTesting modify team ok:\t");
        int result = instance.modify1(input);
        if (result == 1) {
            Team found = instance.find(input);
            checkEquals(input, found);
        } else {
            alert(msgFail);
        }
    }

    public void testModifyPlayerOk(Player input) {
        alert("\nTesting modify player ok:\t");
        int result = instance.modify1(input);
        if (result == 1) {
            Player found = instance.find(input);
            checkEquals(input, found);
        } else {
            alert(msgFail);
        }
    }

    public void testModifyTeamFail(Team input) {
        alert("\nTesting modify team fail:\t");
        int result = instance.modify1(input);
        if (result == 1) {
            alert(msgFail);
        } else {
            alert(msgPass);
        }
    }

    public void testModifyPlayerFail(Player input) {
        alert("\nTesting modify player fail:\t");
        int result = instance.modify1(input);
        if (result == 1) {
            alert(msgFail);
        } else {
            alert(msgPass);
        }
    }    
        
    public void testDeleteTeamOk(Team input) {
        alert("\nTesting delete team ok:\t");
        int result = instance.remove(input);
        if (result == 1) {
            Team found = instance.find(input);
            checkNull(found);
        } else {
            alert(msgFail);
        }
    }      
        
    public void testDeletePlayerOk(Player input) {
        alert("\nTesting delete player ok:\t");
        int result = instance.remove(input);
        if (result == 1) {
            Player found = instance.find(input);
            checkNull(found);
        } else {
            alert(msgFail);
        }
    }  
    
    public void testDeleteTeamFail(Team input) {
        alert("\nTesting delete team fail:\t");
        int result = instance.remove(input);
        if (result == 1) {
            alert(msgFail);
        } else {
            alert(msgPass);
        }
    }      
        
    public void testDeletePlayerFail(Player input) {
        alert("\nTesting delete player fail:\t");
        int result = instance.remove(input);
        if (result == 1) {
            alert(msgFail);
        } else {
            alert(msgPass);
        }
    }   
    
    
    // convenience methods
    
    private void checkEquals(Object expectedValue, Object obtainedValue) {
        if (obtainedValue==null) {
            alert(this.msgFail);
        } else {
            if (obtainedValue.equals(expectedValue))
                alert(this.msgPass);
            else
                alert(this.msgFail);            
        }

    }    
    
    private void checkNull(Object obtainedValue) {
    	if (obtainedValue==null)
            alert(this.msgPass);
    	else
            alert(this.msgFail);
    }    
    
    private void loadTestData() {
        instance = new Model();
        //
        instance.add(new Team(1001, "Name1001", "Desc1001"));
        instance.add(new Team(1002, "Name1002", "Desc1002"));
        instance.add(new Team(1003, "Name1001", "Desc1003"));
        instance.add(new Team(1004, "Name1004", "Desc1004"));
        //
        instance.add(new Player(101, "pname101", 1991, 1001));
        instance.add(new Player(102, "pname102", 1992, 1002));
        instance.add(new Player(103, "pname103", 1993, 1003));
        instance.add(new Player(104, "pname102", 1994, 1002));
        instance.add(new Player(105, "pname105", 1995, 1001));
    }
    
    private void alert(String msg) {
    	System.out.print(msg);
    }
    
    public static void main(String[] args) {
        ModelTester tester = new ModelTester();
        
        tester.loadTestData();
        
        tester.testFindExistingTeam(new Team(1001, "Name1001", "Desc101"));
        tester.testFindNonExistingTeam(new Team(1009, "Name1001", "Desc101"));
        
        tester.testFindExistingPlayer(new Player(102, "pname102", 1992, 1002));
        tester.testFindNonExistingPlayer(new Player(109, "pname102", 1992, 1002));
        
        tester.testFindTeamsByExistingName("Name1001");
        tester.testFindTeamsByNonExistingName("Name1009");
        
        tester.testFindPlayersByExistingName("pname102");
        tester.testFindPlayersByNonExistingName("pname109");
        
        tester.testAddTeamOk(new Team(1005, "Name1005", "Desc105"));
        tester.testAddTeamFail(new Team(1001, "Name1005", "Desc105"));
        
        tester.testModifyTeamOk(new Team(1002, "name1012", "Desc1012"));
        tester.testModifyTeamFail(new Team(1020, "name1020", "Desc1020"));
        
        tester.testModifyPlayerOk(new Player(102, "pname112", 2992, 2002));
        tester.testModifyPlayerFail(new Player(192, "pname112", 2992, 2002));
        
        tester.testDeleteTeamOk(new Team(1002));
        tester.testDeleteTeamFail(new Team(1020));
        
        tester.testDeletePlayerOk(new Player(102));
        tester.testDeletePlayerFail(new Player(192));
        
    }          
    
}
