package fishmod.fishmod;

import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.util.DyeColor;
import net.fabricmc.api.ModInitializer;


public class FishMod implements ModInitializer {
    @Override
    public void onInitialize() {
//        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                "key.fishmod.switch", // The translation key of the keybinding's name
//                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
//                GLFW.GLFW_KEY_R, // The keycode of the key
//                "category.fishmod.inventory" // The translation key of the keybinding's category.
//        ));
//
//        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            while (keyBinding.wasPressed()) {
//                //client.player.sendMessage(new LiteralText("Key 1 was pressed!"), false);
//                //client.player.inventory.insertStack(9, client.player.inventory.getArmorStack(1));
//                //client.player.attack(client.player.getEntityWorld().getEntityById());
//                ItemStack item = client.player.getInventory().getMainHandStack();
//                if (item.getItem() == Items.TROPICAL_FISH_BUCKET) {
//                    String variant = FishMod.getNameFromVariant(item.getNbt().getInt("BucketVariantTag"), false);
//                    String[] file = read("/home/james/Build/fish/fishes").split("\n");
//                    String out = "";
//
//                    boolean found = false;
//                    for (String line: file) {
//                        System.out.println(line);
//                        if (line.equals("#" + variant)) {
//                            client.player.sendMessage(Text.of("Bade"));
//                            found = true;
//                            out += line + "\n";
//                        } else if (line.equals(variant)) {
//                            out += "#" + line + "\n";
//                            found = true;
//                        } else {
//                            out += line + "\n";
//                        }
//                    }
//
//                    if (!found) {
//                        client.player.sendMessage(Text.of("you fucked up m8"));
//                    }
//
//                    write("/home/james/Build/fish/fishes", out);
//                }
//            }
//        });
    }

    public static String getNameFromVariant(int var, boolean doColour) {
        int shape = var & 0xFF;
        int pattern = (var >> 8) & 0xFF;
        int baseColourInt = (var >> 16) & 0xFF;
        int colourInt = (var >> 24) & 0xFF;
        String varietyShape = "";
        if (shape == 0) {
            switch (pattern) {
                case 0:
                    varietyShape = "Kob"; break;
                case 1:
                    varietyShape = "Sunstreak"; break;
                case 2:
                    varietyShape = "Snooper"; break;
                case 3:
                    varietyShape = "Dasher"; break;
                case 4:
                    varietyShape = "Brinely"; break;
                case 5:
                    varietyShape = "Spotty"; break;
            }
        } else {
            switch (pattern) {
                case 0:
                    varietyShape = "Flopper"; break;
                case 1:
                    varietyShape = "Stripey"; break;
                case 2:
                    varietyShape = "Glitter"; break;
                case 3:
                    varietyShape = "Blockfish"; break;
                case 4:
                    varietyShape = "Betty"; break;
                case 5:
                    varietyShape = "Clayfish"; break;
            }
        }

        DyeColor baseColour = DyeColor.byId(baseColourInt);
        DyeColor colour = DyeColor.byId(colourInt);
        String variantHR = "";
        if (doColour) {
            for (TropicalFishEntity.Variant commonVar : TropicalFishEntity.COMMON_VARIANTS) {
                if (commonVar.getId() == var) {
                    variantHR = "§4";
                    break;
                }
            }
        }
        variantHR += baseColour.toString();
        variantHR += "-";
        variantHR += colour.toString();
        variantHR += " ";
        variantHR += varietyShape;
        return variantHR;
    }

//    public static void write(String fileName, String file) {
//        FileWriter out = null;
//        try {
//            out = new FileWriter(fileName);
//            out.write(file);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static String read(String filename) {
//        BufferedReader reader = null;
//        String out = "";
//        try {
//            String line = null;
//            reader = new BufferedReader(new FileReader(filename));
//            while ((line = reader.readLine()) != null) {
//                out += line + "\n";
//            }
//        } catch (IOException e) {
//
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    //TODO AAAHHHH HELP
//                }
//            }
//        }
//        return out;
//    }

}
