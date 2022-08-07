package p455w0rd.cmotd.handler;

import com.mojang.authlib.GameProfile;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.text.WordUtils;
import p455w0rd.cmotd.ModCache;
import p455w0rdslib.LibText;
import p455w0rdslib.util.ProxiedUtils;


public class EventsHandler
{
  @SideOnly(Side.SERVER)
  @SubscribeEvent
  public void onServerTick(TickEvent.ServerTickEvent e) {
    UUID randUUID = UUID.randomUUID();
    MinecraftServer server = ProxiedUtils.getServer();
    long time = MinecraftServer.getSystemTimeMillis();
    long seconds = time / 1000L % 60L;
    if (ModCache.getMOTDListFileCache().isEmpty() || seconds % 5L == 0L) {
      ModCache.cacheMOTDListFile();
    }
    List<String> motdList = ModCache.getMOTDListFileCache();
    int index = (new Random()).nextInt(motdList.size());
    String selectedMOTD = motdList.get(index);
    selectedMOTD = randomFromString(selectedMOTD);
    selectedMOTD = selectedMOTD.replace("|", "\n");
    selectedMOTD = selectedMOTD.replace("{playercount}", server.getCurrentPlayerCount() + "");
    selectedMOTD = selectedMOTD.replace("{maxplayers}", server.getMaxPlayers() + "");
    selectedMOTD = selectedMOTD.replace("{playerlist}", getPlayerListString() + "");
    selectedMOTD = selectedMOTD.replace("{difficulty}", WordUtils.capitalizeFully(server.func_147135_j().name()));
    selectedMOTD = selectedMOTD.replace("{radio}", LibText.RADIO_BARS);
    selectedMOTD = selectedMOTD.replace("{mcversion}", server.getMinecraftVersion());
    selectedMOTD = selectedMOTD.replace("&&", "%%AND%%");
    selectedMOTD = selectedMOTD.replace("&", "§");
    selectedMOTD = selectedMOTD.replace("%%AND%%", "&");
    server.func_147134_at().func_151315_a((IChatComponent)new ChatComponentText(selectedMOTD));

    server.func_147134_at().func_151319_a(new ServerStatusResponse.PlayerCountData(server.getMaxPlayers(), server.getCurrentPlayerCount()));

    List<GameProfile> profileList = new ArrayList<>();
    if (ModCache.getPlayerListFileCache().isEmpty() || seconds % 5L == 0L) {
      ModCache.cachePlayerListFile();
    }
    for (String entry : ModCache.getPlayerListFileCache()) {
        entry = randomFromString(entry);
      entry = entry.replace("{playercount}", server.getCurrentPlayerCount() + "");
      entry = entry.replace("{maxplayers}", server.getMaxPlayers() + "");
      entry = entry.replace("{difficulty}", WordUtils.capitalizeFully(server.func_147135_j().name()));
      entry = entry.replace("{radio}", LibText.RADIO_BARS);
      entry = entry.replace("{mcversion}", server.getMinecraftVersion());
      entry = entry.replace("{playerlist}", getPlayerListString(false) + "");
      entry = entry.replace("&&", "%%AND%%");
      entry = entry.replace("&", "§");
      entry = entry.replace("%%AND%%", "&");
      profileList.add(new GameProfile(randUUID, entry));
    }
    GameProfile[] customPlayerList = profileList.<GameProfile>toArray(new GameProfile[profileList.size()]);
    server.func_147134_at().func_151318_b().func_151330_a(customPlayerList);
  }

  private String getPlayerListString () {
      MinecraftServer server = ProxiedUtils.getServer();
      if (server.getAllUsernames().length == 0) {
          return "So empty :(";
      }
      String res = "";
      for (int i = 0; i < Math.min(server.getAllUsernames().length, 10); i++) {
          res += server.getAllUsernames()[i];
          if (i < server.getAllUsernames().length - 1) {
              res += ", ";
          }
      }
      return res;
  }

    private String getPlayerListString (boolean oneLine) {
        MinecraftServer server = ProxiedUtils.getServer();
        if (server.getAllUsernames().length == 0) {
            return "So empty :(";
        }
        String res = "";
        for (int i = 0; i < Math.min(server.getAllUsernames().length, 10); i++) {
            res += server.getAllUsernames()[i];
            if (i < server.getAllUsernames().length - 1) {
                if (oneLine) {
                    res += ", ";
                } else {
                    res += System.lineSeparator();
                }
            }
        }
        return res;
    }

    private String randomFromString (String list) {
      String res = "";
      for (int i = 0; i < list.length(); i++) {
          if (i < list.length() - 7 && list.substring(i, i + 7).equals("{random")) {
              List<String> randomWords = new ArrayList<String>();
              String temp = "";
              int counter = i + 8;
              int openBrackets = 1;
              while (!(String.valueOf(list.charAt(counter)).equals("}") && openBrackets == 1) && counter < list.length()) {
                  if (list.charAt(counter) == ',') {
                      randomWords.add(temp);
                      temp = "";
                  } else if (list.charAt(counter + 1) == '}' && openBrackets == 1) {
                      temp += list.charAt(counter);
                      randomWords.add(temp);
                  } else {
                      temp += list.charAt(counter);
                      if (list.charAt(counter) == '{') {
                          openBrackets ++;
                      } else if (list.charAt(counter) == '}') {
                          openBrackets --;
                      }
                  }
                  counter ++;
              }
              for (int j = 0; j < randomWords.size(); j++) {
                  if (Character.isSpaceChar(randomWords.get(j).charAt(0))) {
                      randomWords.set(j, randomWords.get(j).substring(1));
                  }
                  if (randomWords.get(j).length() > 0 && Character.isSpaceChar(randomWords.get(j).charAt(randomWords.get(j).length() - 1))) {
                      randomWords.set(j, randomWords.get(j).substring(0, randomWords.get(j).length() - 1));
                  }
              }
              Random rand = new Random();
              res += randomWords.get(rand.nextInt(randomWords.size()));
              //i += counter - 8;
              i = counter;
          } else {
              res += list.charAt(i);
          }
      }
      return res;
    }
}