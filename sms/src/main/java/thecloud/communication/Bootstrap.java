/*
 *	Author:      Gilbert Maystre
 *	Date:        Oct 3, 2015
 */

package thecloud.communication;

import static spark.Spark.*;

public class Bootstrap {

    public static void main(String[] args) {
        get("/twillio", (req, res)->("<Response><Message>Hello World!</Message></Response"));
    }

}
