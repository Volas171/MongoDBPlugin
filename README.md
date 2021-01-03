## A contribution to plugin developers (mongoDB enthusiasts)
![Build](https://github.com/alexpvpmindustry/MongoDBPlugin/workflows/Build/badge.svg)

This plugin demonstrates a way to interact with mongoDB via installable plugins in mindustry.

You need to use atlas mongodb or set up your own mongo database.

sign up for an account here https://cloud.mongodb.com/.

### Disclaimer
- use at your own risk.
- performance not tested.
- all are synchronous functions (idk how to do the async ones ;-; )

### PSA

- if anyone is familar with data visualisations or know how to work with mongoDB, please feel free to ping me at my discord.
- we have lots of data, in need of visualisations. :)
- ugly sample here: https://codepen.io/alexpvpmindustry/pen/xxEWPdy

### Setup

Clone this repository first.
To edit the plugin display name and other data, take a look at `plugin.json`.
Edit the name of the project itself by going into `settings.gradle`.


### Building a Jar

`gradlew jar` / `./gradlew jar`

Output jar should be in `build/libs`.


### Installing

Simply place the output jar from the step above in your server's `config/mods` directory and restart the server.
List your currently installed plugins/mods by running the `mods` command.
