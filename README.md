## Custom MOTD NoClient, formerly p455w0rd's MOTD Customizer

Patreon: [p455w0rd](https://www.patreon.com/p455w0rd)
 
[Original curse page](https://www.curseforge.com/minecraft/mc-mods/p455w0rds-motd-customizer)

A Forge Server Side-Only mod to customize your server MOTD!

This fork removes the need for the mod to be installed on the client (1.7.10 did not have this feature). It also backports the player list.
p455w0rdlib is not needed.

### Features
* Vanilla Compatible
* 1.7.10, 1.9.4, 1.10, and 1.10.2 compatible 
* Customizable Random MOTDs
* Customizable PlayerList tooltip

On first run, the mod will generate the two required files for MOTD customization in <server root dir>/CustomMOTD
There are 2 files used for configuration.
`customotdlist.txt`

This mod supports multiline MOTDs (2 lines as per vanilla). To set a new line, use the pipe | character in the entry in `custommotdlist.txt`
Each entry in `custommotdlist.txt` is a separate MOTD entry. This is why the pipe character is used for 2nd line

`customplayerlist.txt`
Contains the replacement template for the player list tooltip

### Variables
* `{playercount}` - number of players currently on the server
* `{maxplayers}` - maximum number of players the server supports
* `{difficulty}` - server difficulty level
* `{mcversion}` - server Minecraft version
* `{radio}` - obfuscated radio bars
* `{playerlist}` - list up to 10 players currently online

### Color Codes and Formatting
Full support for default Minecraft color codes and formatting
to use an ampersand (&), use two ampersands in succession (&&).

### License
[GNU Lesser General Public License v3.0](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiXoerA4bX5AhWwNOwKHYakABQQFnoECAUQAQ&url=https%3A%2F%2Fwww.gnu.org%2Flicenses%2Flgpl-3.0.en.html&usg=AOvVaw0r8HDHN9dlxd3P3OzgBNLG)

![image](https://user-images.githubusercontent.com/19153947/183313159-c86c3485-5bf9-4d3a-a093-31e856c64349.png)
![image](https://user-images.githubusercontent.com/19153947/183313245-cc9a1fc3-04a1-4e41-a5bc-1d720f6f45e4.png)

