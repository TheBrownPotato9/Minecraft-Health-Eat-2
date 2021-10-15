package com.rishi.healtheat;
/*
1. Too Much Potassium
2. Not enough Potassium+
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
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack salmonella_medicine;
    public static ItemStack potassium_m_Medicine;
    public static ItemStack potassium_l_Medicine;
    public static ItemStack calorie_medicine;
    public static ItemStack fat_medicine;
    public static ItemStack carbs_medicine;
    public static ItemStack sugar_more_medicine;
    public static ItemStack sugar_less_medicine;
    public static ItemStack sodium_more_medicine;
    public static ItemStack sodium_less_medicine;
    public static ItemStack fiber_more_medicine;
    public static ItemStack fiber_less_medicine;
    public static ItemStack protein_medicine;


    public static void init(){
        create_s_medicine();
    }

    private static void create_s_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Salmonella Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Salmonella");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        salmonella_medicine = item;
    }

    private static void create_p_s_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Potassium More Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for More Potassium");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        potassium_m_Medicine = item;
    }

    private static void create_p_l_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Potassium Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Potassium");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        potassium_l_Medicine = item;
    }
    private static void create_calorie_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Calorie Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Calories");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        calorie_medicine = item;
    }
    private static void create_fat_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Fat Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Fat");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        fat_medicine = item;
    }
    private static void create_carbs_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN +"Carbs Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Les s Carbs");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_sugar_more_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "More Sugar Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for More Sugar");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_sugar_less_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "Sugar Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Sugar");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_sodium_more_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "Sodium More Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for More Sodium");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_sodium_less_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Sodium Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Sodium");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_fiber_more_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Fiber More Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for More Fiber");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_fiber_less_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Fiber Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Fiber");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        carbs_medicine = item;
    }
    private static void create_protein_medicine(){
        ItemStack item = new ItemStack(Material.POTION, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Protein Less Medicine");
        List<String> lore = new ArrayList<>();
        lore.add("Cure for Less Protein");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        protein_medicine = item;
    }








}

