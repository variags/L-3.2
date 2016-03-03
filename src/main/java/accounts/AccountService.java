package accounts;

import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * Created by m.simonov on 29.02.2016.
 */
public class AccountService {

    private final DBService dbService;


 /*   private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;
*/


    public AccountService() {
        this.dbService = new DBService();


    /*  loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();*/
    }

    public void addNewUser(UserProfile userProfile) throws Exception {

        dbService.addUser(userProfile.getLogin(), userProfile.getPass());

    }


     public UserProfile getUser(String login)throws Exception {

       UsersDataSet dataSet = dbService.getUser(login);

         if(dataSet == null){

             return null;

         }
         return new UserProfile(dataSet.getLogin(),dataSet.getPassword(),"");
    }

 /*   public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }*/

    /*
    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }



    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }*/
}
