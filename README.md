# Ring Chaos
by ChaosGames

---
**Ring Chaos** is a pack of mystical rings with various uses. The goal of these rings is to create new useful items that can not only make keeping your favorite tools around longer, but can add tools that have more specific and sometimes very powerful uses. More rings may be added in future updates.

---
## Description of Items Added by Ring Chaos
### Completed Rings as of release 1.0.0
#### Ring of Reconstruction
  - Slowly repairs all damaged items in the player's inventory one by one at a rate of  regaining 1 use every 200 ticks aka 10 seconds
  - Ring must be held in the off-hand for it to repair the items in the inventory.
  - All damaged items in the player inventory are included in the repair process, the entire hot bar, all 3 rows of inventory, any amor in the armor slots. Not sure if it will or can include any slots added by other mods.
  - Rarity: Uncommon
  - Does not Stack aka max stack size of 1
  - Can be configured to take 1 XP from the player for each damage point repaired.
  - If configured to take XP it will stop when no more XP is available.

#### Ring of Restoration
  - Instantly repairs all damaged items in the player's inventory
  - Executes the repair upon using the item aka right-clicking with the item in the main hand
  - All damaged items in the player inventory are included in the repair process, the entire hot bar, all 3 rows of inventory, any amor in the armor slots. Not sure if it will or can include any slots added by other mods.
  - Rarity: Rare
  - Does not Stack aka max stack size of 1
  - Can be configured to take 1 XP from the player for each damage point repaired.
  - If configured to take XP and not enough XP is available to fully repair all damaged items, all XP will be used until empty and repair only as much as the amount of XP taken.

#### Second Hand Ring
  - Instantly damages all damageable items in the player's inventory down to 5 uses left
  - Executes this upon use via right-clicking with the item in the main hand
  - Will not deal more damage if used twice without repairing the items before second use.
  - Can not be crafted (at this time)
  - Can only be obtained via cheats (at this time)
  - Was made purely for testing purposes but can be made available via crafting if desired.

### Rings in progress for upcoming Release 1.1.*
#### Stone Throwing Ring
- Can break glass and give a drop
- Drops will consist of a broken glass item that can be crafted back into glass
- Amount dropped would vary based on glass pane vs glass block
- Amount dropped by each would be enough to craft into the respective block that got broken
- Re-crafting the original glass block/pane will be possible in the 2x2 grid within the player inventory
- Tinted glass will drop generic shards and need to be re tinted.


### Rings in planning:

#### Minor Ring of Breakage
  - Can break any block as if it is the correct tool for said block
  - Has a small limit on amount of uses
  - Is very expensive to craft
  - Might use an entire 100 XP _points_ each use OR might use an entire _level_ per use regardless of how many points that level contains.
  - Can NOT be used on bedrock
  - Can NOT be repaired
  - Will need to look into how to prevent the Ring of Reconstruction and Ring of Restoration from repairing it
#### Epic Ring of Breakage
  - Use a netherite smithing template + netherite on the Minor Ring of Breakage to get this one
  - Has a higher but not high number of uses
  - Can be repaired, however only one use can be restored per netherite ingot in the modded anvil like block
  - No longer uses an entire _level_ and uses 100 XP points instead OR uses 50 XP points instead of 100 XP points. This will depend on which we use for the Minor Ring of Breakage.
  - CAN be used on bedrock, but costs two uses (if possible)
#### Void Ring
  - Deletes any block it is used on.
  - Does not _break_ the block instead _deletes_ it and no drop is made.
  - Undecided if it will work on bedrock blocks
#### Ring of the Cleric:
  - Can heal player
  - Might work like a heal potion
  - Might replace need for full hunger to heal
  - Might take XP
  - Needs more thought....
## Other plans
- ~~Remove all the messy comments from the forge MDK template.~~ Done
- ~~Add a console command to trigger a config reload.~~ Idea scrapped
- Make Ring of Reconstruction work from a curios ring slot.

