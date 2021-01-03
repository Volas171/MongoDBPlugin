package mongoplugin;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;
import mindustry.world.blocks.storage.*;

public class MongoPlugin extends Plugin{
    public mongoClientHandler mCH;
    //called when game initializes
    @Override
    public void init(){
        mCH = new mongoClientHandler();
        Events.on(PlayerJoin.class,event->{
            Player p = event.player;
            p.sendMessage("[accent]Hello, This server has a plugin that has been not tested and might be [red]unistable, [accent]play at your own risk");
            mCH.send_uuid(p);
        });
    }

    //register commands that run on the server
    @Override
    public void registerServerCommands(CommandHandler handler){
        //todo
    }

    //register commands that player can invoke in-game
    @Override
    public void registerClientCommands(CommandHandler handler){

        //register a simple reply command
        handler.<Player>register("reply1", "<text...>", "A simple ping command that echoes a player's text.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
        });

    }
}
