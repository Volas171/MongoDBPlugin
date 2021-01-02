package mongoplugin;

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

    //called when game initializes
    @Override
    public void init(){
        //listen for a block selection event
        Events.on(BuildSelectEvent.class, event -> {
            if(!event.breaking && event.builder != null && event.builder.buildPlan() != null && event.builder.buildPlan().block == Blocks.thoriumReactor && event.builder.isPlayer()){
                //player is the unit controller
                Player player = event.builder.getPlayer();

                //send a message to everyone saying that this player has begun building a reactor
                Call.sendMessage("[scarlet]ALERT![] " + player.name + " has begun building a reactor at " + event.tile.x + ", " + event.tile.y);
            }
        });
        Events.on(PlayerJoin.class,event->{
           event.player.sendMessage("hello, this is a test msg");
        });
    }

    //register commands that run on the server
//    @Override
//    public void registerServerCommands(CommandHandler handler){
//        handler.register("reactors", "List all thorium reactors in the map.", args -> {
//            for(int x = 0; x < Vars.world.width(); x++){
//                for(int y = 0; y < Vars.world.height(); y++){
//                    //loop through and log all found reactors
//                    if(Vars.world.tile(x, y).block() == Blocks.thoriumReactor){
//                        Log.info("Reactor at @, @", x, y);
//                    }
//                }
//            }
//        });
//    }

    //register commands that player can invoke in-game
    @Override
    public void registerClientCommands(CommandHandler handler){

        //register a simple reply command
        handler.<Player>register("reply", "<text...>", "A simple ping command that echoes a player's text.", (args, player) -> {
            player.sendMessage("You said: [accent] " + args[0]);
        });

    }
}
