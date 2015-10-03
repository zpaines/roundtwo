/*
 *	Author:      Gilbert Maystre
 *	Date:        Oct 3, 2015
 */

package thecloud.communication;

import static spark.Spark.*;

public class Bootstrap {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/twillio", (req, res)->("<Response><Message>This time Hello World gotta works. (req was: "+req.body()+")</Message></Response"));
    }
    
    //code found at https://sparktutorials.github.io/2015/08/24/spark-heroku.html
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
