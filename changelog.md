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
#### To-Do List
- Remove all the messy comments from the forge MDK template.
- Rings in planning:
  - Unnamed Ring 1:
    - Can break any block as if it is the correct tool for said block
    - Has a small limit on amount of uses
    - Is very expensive to craft
    - Can NOT be repaired
      - Will need to look into how to prevent the repair/mending rings from repairing it
  - Unnamed Ring 2:
    - Deletes any block it is used on.
    - Does not *break* the block instead *deletes* it and no drop is made.
    - Undecided if it will work on bedrock blocks
  - Unnamed Ring 3:
    - Can break glass and give a drop
    - Drop considerations:
      - glass shards that can be crafted back into glass
        - amount dropped would vary based on glass pane vs glass block
        - amount dropped by each would be enough to craft into the respective block that got broken
      - the glass block that got broken
    - Tinted glass might drop generic shards and need to be re tinted. 