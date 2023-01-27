# JoinItem
If you want to use fast-connect function, you need to use the command of the plugin.

## Command
``` /sendplayer <player> <server> ```

The command can only using by console.

The command must use for the first time to add data 
of server that player connecting to.

## Example 
Using with [DeluxeMenus](https://wiki.helpch.at/clips-plugins/deluxemenus)
```yaml
  'example':
    material: 'dirt'
    slot: 1
    priority: 1
    update: true
    hide_attributes: true
    display_name: '&b&lExample Server'
    lore:
      - ''
      - ' &eLeft-click to join!'
    left_click_commands:
      - '[console] sendplayer %player_name% example'
      - '[close]'
```
