package com.rishi.healtheat;

/*
Steve burns 110 calories per mile
1 mile = 1609.34 meters
100 Calories = 1463 meters
10 grams fat = 1500 meters (around)
10 grams fat = 1500 blocks walked

Medicines Total = 12

1. Too Much Potassium
2. Not enough Potassium
3. Not enough Calorie
4. Not enough Fat
5. Not enough Carbs
6. Too much Sugar
7. Not enough Sugar
8. Too much Sodium
9. Not enough Sodium
10. Too much Fiber
11. Not enough Fiber
12. Not enough Protein


 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Random;


public class Main extends JavaPlugin implements Listener {

    Player player;

    double Calories;
    double Protein;
    double Fat;
    double Carbohydrates;
    double Sugars;
    double Sodium;
    double Fiber;
    double Potassium;

    public static boolean health_Scale_lost;

    boolean has_effect_1 = player.hasPotionEffect(PotionEffectType.WITHER);
    boolean has_effect_2 = player.hasPotionEffect(PotionEffectType.SLOW);
    boolean has_effect_3 = player.hasPotionEffect(PotionEffectType.CONFUSION);
    boolean has_effect_4 = player.hasPotionEffect(PotionEffectType.BLINDNESS);

    short max_Calories = 2500;
    short max_Protein = 50;
    short max_Fat = 70;
    short max_Carbohydrates = 50;
    short max_Sugars = 310;
    short max_Sodium = 2300;
    short max_Fiber = 30;
    short max_Potassium = 3500;



    double extra_calories;
    double extra_fat;
    double fat_burned;
    double extra_carbs;

    boolean f_run = false;
    boolean has_drank_f_m_medicine;
    boolean has_drank_f_l_medicine;


    //Diseases Etc.
    boolean Salmonella;
    boolean too_much_potassium;
    boolean not_enough_potassium;
    boolean not_enough_calories;
    boolean not_enough_fat;
    boolean not_enough_carbs;
    boolean too_much_sugar;
    boolean not_enough_sugar;
    boolean too_much_sodium;
    boolean not_enough_sodium;
    boolean too_much_fiber;
    boolean not_enough_fiber;



    double blocks_walked;

    boolean has_drank_s_medicine;
    byte days;
    boolean has_drank_p_l_medicine;
    boolean has_drank_calorie_Medicine;
    boolean has_drank_p_m_medicine;

    //Effects
    public PotionEffect Effect1 = new PotionEffect(PotionEffectType.BLINDNESS, 9999999, 99999999, false, false, false);
    public PotionEffect Effect2 = new PotionEffect(PotionEffectType.SLOW, 999999999, 999999999, false, false, false);
    public PotionEffect Effect3 = new PotionEffect(PotionEffectType.CONFUSION, 999999, 999999999, false, false, false);
    public PotionEffect Effect4 = new PotionEffect(PotionEffectType.WITHER, 9999999, 3, false, false, false);


    short seconds = 1;


    // All Minecraft Foods in ItemStacks
    ItemStack a_apple = new ItemStack(Material.APPLE, 1);
    ItemStack a_mushroom_stew = new ItemStack(Material.MUSHROOM_STEW, 1);
    ItemStack a_bread = new ItemStack(Material.BREAD, 1);
    ItemStack a_raw_pork = new ItemStack(Material.PORKCHOP, 1);
    ItemStack a_cooked_pork = new ItemStack(Material.COOKED_PORKCHOP, 1);
    ItemStack a_golden_apple = new ItemStack(Material.GOLDEN_APPLE, 1);
    ItemStack a_god_apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
    ItemStack a_raw_cod = new ItemStack(Material.COD, 1);
    ItemStack a_cooked_cod = new ItemStack(Material.COOKED_COD, 1);
    ItemStack a_raw_salmon = new ItemStack(Material.SALMON, 1);
    ItemStack a_cooked_salmon = new ItemStack(Material.COOKED_SALMON, 1);
    ItemStack a_tropical_fish = new ItemStack(Material.TROPICAL_FISH, 1);
    ItemStack a_pufferfish = new ItemStack(Material.PUFFERFISH, 1);
    ItemStack a_cake = new ItemStack(Material.CAKE, 1);
    ItemStack a_cookie = new ItemStack(Material.COOKIE, 1);
    ItemStack a_melon = new ItemStack(Material.MELON, 1);
    ItemStack a_kelp = new ItemStack(Material.KELP, 1);
    ItemStack a_raw_beef = new ItemStack(Material.BEEF, 1);
    ItemStack a_cooked_beef = new ItemStack(Material.COOKED_BEEF, 1);
    ItemStack a_raw_chicken = new ItemStack(Material.CHICKEN, 1);
    ItemStack a_cooked_chicken = new ItemStack(Material.COOKED_CHICKEN, 1);
    ItemStack a_rotten_flesh = new ItemStack(Material.ROTTEN_FLESH, 1);
    ItemStack a_spider_eye = new ItemStack(Material.SPIDER_EYE, 1);
    ItemStack a_carrot = new ItemStack(Material.CARROT, 1);
    ItemStack a_potato = new ItemStack(Material.POTATO, 1);
    ItemStack a_baked_potato = new ItemStack(Material.BAKED_POTATO, 1);
    ItemStack a_poisonous_potato = new ItemStack(Material.POISONOUS_POTATO, 1);
    ItemStack a_pie = new ItemStack(Material.PUMPKIN_PIE, 1);
    ItemStack a_raw_rabbit = new ItemStack(Material.RABBIT, 1);
    ItemStack a_cooked_rabbit = new ItemStack(Material.COOKED_RABBIT, 1);
    ItemStack a_rabbit_stew = new ItemStack(Material.RABBIT_STEW, 1);
    ItemStack a_raw_mutton = new ItemStack(Material.MUTTON, 1);
    ItemStack a_cooked_mutton = new ItemStack(Material.COOKED_MUTTON, 1);
    ItemStack a_beetroot = new ItemStack(Material.BEETROOT, 1);
    ItemStack a_beetroot_soup = new ItemStack(Material.BEETROOT_SOUP, 1);
    ItemStack a_sweet_berry = new ItemStack(Material.SWEET_BERRIES, 1);
    ItemStack a_honey_bottle = new ItemStack(Material.HONEY_BOTTLE, 1);
    ItemStack a_golden_carrot = new ItemStack(Material.GOLDEN_CARROT, 1);


    @Override
    public void onEnable() {
        System.out.println("Plugin Enabled");
        Bukkit.getPluginManager().registerEvents(this, this);
        ItemManager.init();
        player.sendTitle("Challenge has begun", "Good Luck", 5, 20, 5);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (Potassium + 7 > max_Potassium) {
                    player.sendMessage(ChatColor.RED + "You have too much Potassium, drink the Too Much Potassium Medicine");
                    player.setWalkSpeed(player.getWalkSpeed() - 0.1f);
                    too_much_potassium = true;


                }
                if (Potassium < max_Potassium - 5) {
                    player.sendMessage(ChatColor.RED + "You don't have enough Potassium, Drink Less Potassium Medicine");
                    not_enough_potassium = true;

                }

                if (Calories > extra_calories){
                    extra_calories = extra_calories + (Calories - max_Calories);
                    Fat = Fat + (extra_calories/10);
                }

                if (Calories < extra_calories - 300){
                    player.sendMessage(ChatColor.RED + "You don't have enough calories, drink the Calories Medicine");
                    not_enough_calories = true;
                }

                if (Fat > max_Fat){
                    extra_fat = Fat - max_Fat;

                }
                if (max_Fat > Fat - 10){
                    player.sendMessage(ChatColor.RED + "You don't have enough fat, drink the Fat Medicine");
                    not_enough_fat = true;
                }


                if (extra_fat > 1 ){
                   extra_fat = extra_fat - 1;
                    player.setWalkSpeed(player.getWalkSpeed() - 0.001f );
                    player.setHealthScale(player.getHealthScale() - 0.05);
                }

                if (Carbohydrates > max_Carbohydrates){
                    extra_carbs = Carbohydrates - max_Carbohydrates;

                }

                if (extra_carbs > 4){
                    extra_carbs = extra_carbs - 4;
                    extra_fat = extra_fat + 1;
                }

                if (max_Carbohydrates > Carbohydrates){
                    player.sendMessage(ChatColor.RED + "You don't have enough Carbs, drink the Less Carbs Medicine");
                    not_enough_carbs = true;
                }

                if (Sugars > max_Sugars){
                    player.sendMessage(ChatColor.RED + "You have too much sugar, drink the Too Much Sugar Medicine");

                }



















            }
        }, 24000L, 24000L);

    }


    public void Salmonella_recipe() {
        ItemStack item = new ItemStack(ItemManager.salmonella_medicine);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("!!!", "%#$", "%%%");

        recipe.setIngredient('!', Material.WATER_BUCKET);
        recipe.setIngredient('@', Material.SUSPICIOUS_STEW);
        recipe.setIngredient('#', Material.BLUE_ORCHID);
        recipe.setIngredient('$', Material.SUNFLOWER);
        recipe.setIngredient('%', Material.BONE_MEAL);

        /*

        ! - Water Bottle
        @ - Suspicious Stew
        # - Blue Orchid
        $ - Sunflower
        % - Bonemeal

        */
        this.getServer().addRecipe(recipe);
    }


    public void Potassium_Medicine_Less() {
        ItemStack item = new ItemStack(ItemManager.potassium_l_Medicine);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("!!!", "%#$", "%%%");

        recipe.setIngredient('!', Material.WATER_BUCKET);
        recipe.setIngredient('@', Material.SUSPICIOUS_STEW);
        recipe.setIngredient('#', Material.NETHER_WART);
        recipe.setIngredient('$', Material.COOKED_BEEF);
        recipe.setIngredient('%', Material.BONE_MEAL);

        this.getServer().addRecipe(recipe);
    }

    public void Potassium_Medicine_More() {
        ItemStack item = new ItemStack(ItemManager.potassium_m_Medicine);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("!!!", "%#$", "%%%");

        recipe.setIngredient('!', Material.WATER_BUCKET);
        recipe.setIngredient('@', Material.SUSPICIOUS_STEW);
        recipe.setIngredient('#', Material.NETHER_WART_BLOCK);
        recipe.setIngredient('$', Material.COOKED_BEEF);
        recipe.setIngredient('%', Material.BONE_MEAL);

        this.getServer().addRecipe(recipe);
    }

    public void Calories_Less_Medicine() {
        ItemStack item = new ItemStack(ItemManager.potassium_m_Medicine);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("!!!", "%#$", "%%%");

        recipe.setIngredient('!', Material.WATER_BUCKET);
        recipe.setIngredient('@', Material.SUSPICIOUS_STEW);
        recipe.setIngredient('#', Material.NETHER_WART_BLOCK);
        recipe.setIngredient('$', Material.ACACIA_LEAVES);
        recipe.setIngredient('%', Material.BONE_MEAL);

        this.getServer().addRecipe(recipe);

    }


    //PotionEffects Interact Event
    public void onInteract3(PlayerInteractEvent e) {
        double cm_walked = e.getPlayer().getStatistic(Statistic.WALK_ONE_CM);
        blocks_walked = cm_walked/100;
        Effect1 = new PotionEffect(PotionEffectType.BLINDNESS, 9999999, 99999999, false, false, false);

        if (e.getPlayer().getInventory().contains(Material.MILK_BUCKET)) {
            e.getPlayer().setHealth(0);
        }


        if (Salmonella = true && has_effect_1 == false && has_effect_2 == false && has_effect_3 == false && has_effect_4 == false) {
            health_Scale_lost = false;
            has_effect_1 = true;
            has_effect_2 = true;
            has_effect_3 = true;
            has_effect_4 = true;

            e.getPlayer().addPotionEffect(Effect1);
            e.getPlayer().addPotionEffect(Effect2);
            e.getPlayer().addPotionEffect(Effect3);
            e.getPlayer().addPotionEffect(Effect4);

            if (health_Scale_lost = false){
                double HealthScale = e.getPlayer().getHealthScale();
                e.getPlayer().setHealthScale(HealthScale - 2);
                health_Scale_lost = true;
            }


            if (has_drank_s_medicine = true) {
                has_drank_s_medicine = false;
                e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
                e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                e.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
                e.getPlayer().removePotionEffect(PotionEffectType.WITHER);
                has_effect_1 = false;
                has_effect_2 = false;
                has_effect_3 = false;
                has_effect_4 = false;
            }
        }





        if (has_drank_p_m_medicine = false && has_effect_1 == false && has_effect_2 == false && has_effect_3 == false && has_effect_4 == false ) {
            health_Scale_lost = false;


            e.getPlayer().addPotionEffect(Effect1);
            e.getPlayer().addPotionEffect(Effect2);
            e.getPlayer().addPotionEffect(Effect3);
            e.getPlayer().addPotionEffect(Effect4);

            if (health_Scale_lost = false){
                double HealthScale = e.getPlayer().getHealthScale();
                e.getPlayer().setHealthScale(HealthScale - 2);
                health_Scale_lost = true;
            }




        }
        if (has_drank_p_m_medicine = true) {
            e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
            e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
            e.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
            e.getPlayer().removePotionEffect(PotionEffectType.WITHER);
            has_effect_1 = false;
            has_effect_2 = false;
            has_effect_3 = false;
            has_effect_4 = false;

        }



        if (has_drank_p_l_medicine = false && has_effect_1 == false && has_effect_2 == false && has_effect_3 == false && has_effect_4 == false ) {
            health_Scale_lost = false;


            e.getPlayer().addPotionEffect(Effect1);
            e.getPlayer().addPotionEffect(Effect2);
            e.getPlayer().addPotionEffect(Effect3);
            e.getPlayer().addPotionEffect(Effect4);

            if (health_Scale_lost = false){
                double HealthScale = e.getPlayer().getHealthScale();
                e.getPlayer().setHealthScale(HealthScale - 2);
                health_Scale_lost = true;
            }




        }

        if (has_drank_p_m_medicine = true) {
            e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
            e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
            e.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
            e.getPlayer().removePotionEffect(PotionEffectType.WITHER);
            has_effect_1 = false;
            has_effect_2 = false;
            has_effect_3 = false;
            has_effect_4 = false;

        }
    }



    @EventHandler
    public void onEat(FoodLevelChangeEvent e) {
        ItemStack food = e.getItem();

        if (food.equals(a_cooked_beef)) {
            Calories = Calories + 217;
            Protein = Protein + 26.1;
            Fat = Fat + 11.8;
            Sodium = Sodium + 146;
        }

        if (food.equals(a_apple)) {
            Calories = Calories + 95;
            Sodium = Sodium + 2;
            Sugars = Sugars + 19;
            Protein = Protein + 0.5;
            Fat = Fat + 0.3;
            Carbohydrates = Carbohydrates + 25;
        }
        if (food.equals(a_bread)) {
            Calories = Calories + 92;
            Fat = Fat + 2;
            Carbohydrates = Carbohydrates + 17;
            Protein = Protein + 3;
            Fiber = Fiber + 2;
            Sodium = Sodium + 161;

        }

        if (food.equals(a_mushroom_stew)) {
            Calories = Calories + 129;
            Fat = Fat + 6;
            Carbohydrates = Carbohydrates + 17;
            Fiber = Fiber + 6;
            Sugars = Sugars + 6;
            Protein = Protein + 4;
            Sodium = Sodium + 550;
        }

        if (food.equals(a_cooked_pork)) {
            Calories = Calories + 139;
            Fat = Fat + 5;
            Sodium = Sodium + 62;
            Protein = Protein + 25;
        }

        if (food.equals(a_cooked_chicken)) {
            Calories = Calories + 284;
            Protein = Protein + 53.4;
            Fat = Fat + 6.2;
        }

        if (food.equals(a_cooked_cod)) {
            Calories = Calories + 93;
            Protein = Protein + 20;
            Fat = Fat + 1;
            Carbohydrates = Carbohydrates + 0.8;

        }

        if (food.equals(a_cooked_salmon)) {
            Calories = Calories + 118;
            Fat = Fat + 3.65;
            Protein = Protein + 19.93;

        }

        if (food.equals(a_golden_apple)) {
            Calories = Calories + 95;
            Sodium = Sodium + 2;
            Sugars = Sugars + 19;
            Protein = Protein + 0.5;
            Fat = Fat + 0.3;
            Carbohydrates = Carbohydrates + 25;
        }
        if (food.equals(a_god_apple)) {
            Calories = Calories + 95;
            Sodium = Sodium + 2;
            Sugars = Sugars + 19;
            Protein = Protein + 0.5;
            Fat = Fat + 0.3;
            Carbohydrates = Carbohydrates + 25;
        }
        if (food.equals(a_tropical_fish)) {
            Calories = Calories + 118;
            Fat = Fat + 3.65;
            Protein = Protein + 19.93;

        }


        if (food.equals(a_pufferfish)) {
            e.getEntity().setHealth(0);
        }

        if (food.equals(a_cake)) {
            Calories = Calories + 320;
            Carbohydrates = Carbohydrates + 42;
            Sugars = Sugars + 29;
            Protein = Protein + 3;
            Fat = Fat + 16;
        }

        if (food.equals(a_cookie)) {
            Calories = Calories + 120;
            Fat = Fat + 4;
            Sodium = Sodium + 63.9;
            Carbohydrates = Carbohydrates + 22.8;
        }

        if (food.equals(a_melon)) {
            Calories = Calories + 85;
            Fat = Fat + 0.4;
            Sodium = Sodium + 3;
            Potassium = Potassium + 314;
            Carbohydrates = Carbohydrates + 21;
            Fiber = Fiber + 1.1;
            Sugars = Sugars + 17;
            Protein = Protein + 1.7;
        }

        if (food.equals(a_kelp)) {
            Calories = Calories + 17.2;
            Fat = Fat + 0.2;
            Sodium = Sodium + 93;
            Carbohydrates = Carbohydrates + 3.8;
            Sodium = Sodium + 93;
            Fiber = Fiber + 0.5;
            Sugars = Sugars + 0.2;
            Protein = Protein + 0.7;

        }
        if (food.equals(a_rotten_flesh)) {
            e.getEntity().setHealth(0);
        }

        if (food.equals(a_spider_eye)) {
            e.getEntity().setHealth(0);
        }

        if (food.equals(a_carrot)) {
            Calories = Calories + 25;
            Carbohydrates = Carbohydrates + 6;
            Fiber = Fiber + 2;
            Sugars = Sugars + 3;
            Protein = Protein + 0.5;
        }

        if (food.equals(a_potato)) {
            Calories = Calories + 168;
            Protein = Protein + 5;
            Carbohydrates = Carbohydrates + 37;
            Fiber = Fiber + 4;

        }

        if (food.equals(a_baked_potato)) {
            Calories = Calories + 161;
            Sodium = Sodium + 17;
            Fat = Fat + 0.8;
            Carbohydrates = Carbohydrates + 37;
            Fiber = Fiber + 4;
            Protein = Protein + 4;

        }

        if (food.equals(a_pie)) {
            Fat = Fat + 97;
            Calories = Calories + 2417.9;
            Sodium = Sodium + 2378;
            Potassium = Potassium + 1661.7;
            Fiber = Fiber + 17.9;
            Protein = Protein + 38.8;

        }

        if (food.equals(a_poisonous_potato)) {
            e.getEntity().setHealth(0);
        }

        if (food.equals(a_cooked_rabbit)) {
            Calories = Calories + 517;
            Fat = Fat + 10.5;
            Sodium = Sodium + 134.6;
            Potassium = Potassium + 1025.6;
            Protein = Protein + 98.7;

        }
        if (food.equals(a_rabbit_stew)) {
            Calories = Calories + 517;
            Fat = Fat + 10.5;
            Sodium = Sodium + 134.6;
            Potassium = Potassium + 1025.6;
            Protein = Protein + 98.7;

        }

        if (food.equals(a_raw_beef) ||
                food.equals(a_raw_pork) ||
                food.equals(a_raw_chicken) ||
                food.equals(a_raw_cod) ||
                food.equals(a_raw_rabbit) ||
                food.equals(a_raw_mutton) ||
                food.equals(a_raw_salmon)) {

            Random rand = new Random();


            int n = rand.nextInt(4);
            if (n != 1) {
                Salmonella = true;
            }


        }


    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        if (e.getItem().equals(ItemManager.salmonella_medicine)) {
            has_drank_s_medicine = true;
        }



    }


}




























