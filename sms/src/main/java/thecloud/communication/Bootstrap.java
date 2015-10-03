/*
 *	Author:      Gilbert Maystre
 *	Date:        Oct 3, 2015
 */

package thecloud.communication;

import static spark.Spark.*;

public class Bootstrap {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        
        //test 1
        get("/twillio", (req, res)->(HTTPify("This time Hello World gotta works. (req was: "+req.body())));
        
        //test 2
        get("/twillio/something/else",
                (req, res) -> {
                    return HTTPify((System.currentTimeMillis() % 2 == 0)? "yes" : "no"); 
                }
        );
        
        //test3
        get("/twillio/something/else/:id", 
                (req, res) -> {
                    return HTTPify("you gave me" + req.params("id"));
                }
        );
        
        get("/thecloud/smsin", 
                (req, res) -> {
                    System.out.println("the request is: "+req.body());
                    return HTTPify("");
                }
                );
        
    }

    public static String HTTPify(String text){
        return "<Response><Message>"+text+"</Message></Response>";
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
