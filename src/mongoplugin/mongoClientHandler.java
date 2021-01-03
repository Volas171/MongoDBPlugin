package mongoplugin;

import arc.Core;
import arc.util.Log;
import arc.util.Strings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mindustry.gen.Player;
import org.bson.Document;

import java.util.Date;

public class mongoClientHandler {
    public MongoDatabase db;
    public MongoCollection<Document> muuid_collection;
    public MongoCollection<Document> duuid_collection;
    public MongoCollection<Document> expgains;
    private static String secretURL = "";
    public void mongoClientHandler(){
        MongoClient mongoClient = MongoClients.create(secretURL);
        db = mongoClient.getDatabase("AlexMindustry");
        muuid_collection = db.getCollection("muuid");
        duuid_collection = db.getCollection("duuid");
        expgains = db.getCollection("expgains");
    }
    public void send_uuid(Player p){
        Document doc = new Document("musername", p.name)
                .append("date", new Date() )
                .append("muuid", p.uuid())
                .append("con_address", p.con.address)
                .append("color", p.color.toString())
                .append("servername", Strings.stripColors(Core.settings.getString("servername") ));
        muuid_collection.insertOne(doc);
        Log.info("player saved to muuid db");
    }
    public void send_duuid(Player p,String color,Long duuid,Long EXP,String role){
        Document doc = new Document("musername", p.name)
                .append("date", new Date() )
                .append("muuid", p.uuid())
                .append("con_address", p.con.address)
                .append("color", p.color.toString())
                .append("duuid",duuid)
                .append("role",role)
                .append("EXP",EXP)
                .append("servername", Strings.stripColors(Core.settings.getString("servername") ));
        duuid_collection.insertOne(doc);
        Log.info("player saved to duuid db");
    }
    public void send_exp_gains(Player p , Long duuid,Long EXP, int gains){
        Document doc = new Document("musername", p.name)
                .append("date", new Date() )
                .append("muuid", p.uuid())
                .append("con_address", p.con.address)
                .append("duuid",duuid)
                .append("EXP",EXP)
                .append("gains",gains)
                .append("servername", Strings.stripColors(Core.settings.getString("servername")) );
        duuid_collection.insertOne(doc);
        Log.info("player saved to duuid db");
    }
}
