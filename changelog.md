# Ring Chaos Change Log
## Version 0
### 0.1.0, March 9, 2024:
- Initial Commit
### 0.2.0, March 13, 2024:
- Added required dependency, **Moonlight Lib**
- Switched to an Architectury template
- Renamed all instances of "example mod" to "Ring Chaos"
- Filled in gradle.properties for common, fabric, and forge
- Filled in the mod meta-data for both fabric and forge
- Created mod icon and implemented it
- no commit made.
### 0.2.0, March 24, 2024:
- Created creative mode tab
- no commit made.
### 0.2.0, March 25, 2024:
#### Tasks Accomplished on this date
- Abandoned multiloader idea and reverted to a forge only mod.
- Repair and Mending Rings are now combined and XP use is determined via the config file.
- Added functionality to the following rings:
  - Ring of Damage
- no commit made.
### 0.2.1, June 9, 2024:
#### Tasks in progress on this date
- Trying to get config edits to be recognized without needing to stop and relaunch the server/game
- Noticed the repair rings stop working when the player runs out of XP to drain but do no resume working once the player gains more XP.
#### Tasks Accomplished on this date
- NOTHING
- no commit made.
### 0.2.1, October 19, 2024
#### Tasks in progress on this date
- Figure out wtf was happening last time we worked on this.
- Rings not resuming after play has XP is a non issue. It only happens when the XP is added via cheats and only when using set. When add is used the ring will resume working.
- no changes made
### 0.2.1, October 20, 2024
#### Tasks to do on this date
- Attempt to make the mod watch for changes to the config
- Figure out why items in inventory that are not damageable become unable to stack with the same type of item after a repair ring runs through the inventory.
#### Tasks accomplished on this date
- Moved config to Common to fix the issue of the changes needing a restart to apply.
- Moved the config back to Server.
- Fixed issue with non-damagable items being effected.
### 0.2.1, October 23, 2024
#### Tasks accomplished on this date
- Fleshed out ideas in the readme and formatted it properly
- commit made
### 0.2.2, October 24, 2024
#### Tasks accomplished on this date
- Got the XP calculation working correctly
- Gave the completed rings final names
- Cleaned up the messy comments from the Forge MDK template
- Fixed issue with config strings
### 0.2.3, October 25, 2024
#### Tasks accomplished on this date
- Clean up and re-arrange the classes and packages to make a bit more sense
- Made creative mode icon item unobtainable
#### Needed changes noticed on this date
- ~~Maybe make the tab icon cycle the items in the tab~~ Abandoned until we know more Java.
### 1.0.0, October 29, 2024
- Initial release!