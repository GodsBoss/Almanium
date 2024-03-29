package org.godsboss.minecraft.mods.almanium;

import org.godsboss.minecraft.mods.almanium.blocks.AlmaniumBlock;
import org.godsboss.minecraft.mods.almanium.blocks.AlmaniumOreBlock;
import org.godsboss.minecraft.mods.almanium.items.Axe;
import org.godsboss.minecraft.mods.almanium.items.Pickaxe;
import org.godsboss.minecraft.mods.almanium.items.Shovel;
import org.godsboss.minecraft.mods.almanium.proxies.Proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod(
	modid = AlmaniumMod.MODID,
	name = AlmaniumMod.MODNAME,
	version = AlmaniumMod.MODVERSION
)
public class AlmaniumMod {
	public static final String MODID = "almanium";
	public static final String MODNAME = "Almanium";
	public static final String MODVERSION = "1.0.0";

	@SidedProxy(
		clientSide="org.godsboss.minecraft.mods.almanium.proxies.ClientProxy",
		serverSide="org.godsboss.minecraft.mods.almanium.proxies.ServerProxy"
	)
	public static Proxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Blocks.populate();
		Items.populate();

		GameRegistry.addSmelting(Items.AlmaniumNetherrackOreBlock, new ItemStack(Items.AlmaniumIngot), 0.7f);
		GameRegistry.addSmelting(Items.AlmaniumOreBlock, new ItemStack(Items.AlmaniumIngot), 0.7f);
		GameRegistry.addSmelting(Items.AlmaniumAxe, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumHoe, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumPickaxe, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumShovel, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumSword, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumBoots, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumChestplate, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumHelmet, new ItemStack(Items.AlmaniumNugget), 0.1f);
		GameRegistry.addSmelting(Items.AlmaniumLeggings, new ItemStack(Items.AlmaniumNugget), 0.1f);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		OreDictionary.registerOre("ingotAlmanium", Items.AlmaniumIngot);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}

	@Mod.EventBusSubscriber(modid = AlmaniumMod.MODID)
	public static class Blocks {
		public static final String AlmaniumBlockName = "almanium_block";
		public static final String AlmaniumNetherrackOreBlockName = "almanium_netherrack_ore_block";
		public static final String AlmaniumOreBlockName = "almanium_ore_block";
		public static Block AlmaniumBlock;
		public static Block AlmaniumNetherrackOreBlock;
		public static Block AlmaniumOreBlock;

		public static void populate() {
			AlmaniumBlock = new AlmaniumBlock();
			AlmaniumNetherrackOreBlock = new AlmaniumOreBlock(AlmaniumNetherrackOreBlockName);
			AlmaniumOreBlock = new AlmaniumOreBlock(AlmaniumOreBlockName);
		}

		@SubscribeEvent
		public static void register(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
				AlmaniumBlock,
				AlmaniumNetherrackOreBlock,
				AlmaniumOreBlock
			);
		}
	}

	@Mod.EventBusSubscriber(modid = AlmaniumMod.MODID)
	public static class Items {
		// Blocks
		// No names, they use the same names as the corresponding blocks.
		public static Item AlmaniumBlock;
		public static Item AlmaniumNetherrackOreBlock;
		public static Item AlmaniumOreBlock;

		// Tools and weapons
		public static final String AlmaniumAxeName = "almanium_axe";
		public static final String AlmaniumHoeName = "almanium_hoe";
		public static final String AlmaniumPickaxeName = "almanium_pickaxe";
		public static final String AlmaniumShovelName = "almanium_shovel";
		public static final String AlmaniumSwordName = "almanium_sword";
		public static Item AlmaniumAxe;
		public static Item AlmaniumHoe;
		public static Item AlmaniumPickaxe;
		public static Item AlmaniumShovel;
		public static Item AlmaniumSword;

		// Armor
		public static final String AlmaniumBootsName = "almanium_boots";
		public static final String AlmaniumChestplateName = "almanium_chestplate";
		public static final String AlmaniumHelmetName = "almanium_helmet";
		public static final String AlmaniumLeggingsName = "almanium_leggings";
		public static Item AlmaniumBoots;
		public static Item AlmaniumChestplate;
		public static Item AlmaniumHelmet;
		public static Item AlmaniumLeggings;

		// Miscellaneous
		public static final String AlmaniumIngotName = "almanium_ingot";
		public static final String AlmaniumNuggetName = "almanium_nugget";
		public static Item AlmaniumIngot;
		public static Item AlmaniumNugget;

		public static void populate() {
			// Blocks
			AlmaniumBlock = (new ItemBlock(Blocks.AlmaniumBlock)).
				setRegistryName(Blocks.AlmaniumBlockName);
			AlmaniumNetherrackOreBlock = (new ItemBlock(Blocks.AlmaniumNetherrackOreBlock)).
				setRegistryName(Blocks.AlmaniumNetherrackOreBlockName);
			AlmaniumOreBlock = (new ItemBlock(Blocks.AlmaniumOreBlock)).
				setRegistryName(Blocks.AlmaniumOreBlockName);

			// Tools and weapons
			AlmaniumAxe = new Axe();
			AlmaniumHoe = (new ItemHoe(Item.ToolMaterial.IRON)).
				setRegistryName(AlmaniumHoeName).
				setUnlocalizedName(AlmaniumHoeName);
			AlmaniumPickaxe = new Pickaxe();
			AlmaniumShovel = new Shovel();
			AlmaniumSword = (new ItemSword(Item.ToolMaterial.IRON)).
				setRegistryName(AlmaniumSwordName).
				setUnlocalizedName(AlmaniumSwordName);

			// Armor
			AlmaniumBoots = (new ItemArmor(
				Materials.armor,
				0,
				EntityEquipmentSlot.FEET
			)).
				setRegistryName(AlmaniumBootsName).
				setUnlocalizedName(AlmaniumBootsName);
			AlmaniumChestplate = (new ItemArmor(
				Materials.armor,
				0,
				EntityEquipmentSlot.CHEST
			)).
				setRegistryName(AlmaniumChestplateName).
				setUnlocalizedName(AlmaniumChestplateName);
			AlmaniumHelmet = (new ItemArmor(
				Materials.armor,
				0,
				EntityEquipmentSlot.HEAD
			)).
				setRegistryName(AlmaniumHelmetName).
				setUnlocalizedName(AlmaniumHelmetName);
			AlmaniumLeggings = (new ItemArmor(
				Materials.armor,
				0,
				EntityEquipmentSlot.LEGS
			)).
				setRegistryName(AlmaniumLeggingsName).
				setUnlocalizedName(AlmaniumLeggingsName);

			// Miscellaneous
			AlmaniumIngot = (new Item()).
				setRegistryName(AlmaniumIngotName).
				setUnlocalizedName(AlmaniumIngotName).
				setCreativeTab(CreativeTabs.MATERIALS);
			AlmaniumNugget = (new Item()).
				setRegistryName(AlmaniumNuggetName).
				setUnlocalizedName(AlmaniumNuggetName).
				setCreativeTab(CreativeTabs.MATERIALS);
		}

		@SubscribeEvent
		public static void register(RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
				// Blocks
				AlmaniumBlock,
				AlmaniumNetherrackOreBlock,
				AlmaniumOreBlock,

				// Tools and weapons
				AlmaniumAxe,
				AlmaniumHoe,
				AlmaniumPickaxe,
				AlmaniumShovel,
				AlmaniumSword,

				// Armor
				AlmaniumBoots,
				AlmaniumChestplate,
				AlmaniumHelmet,
				AlmaniumLeggings,

				// Miscellaneous
				AlmaniumIngot,
				AlmaniumNugget
			);
		}

		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public static void registerRenders(ModelRegistryEvent event) {
			// Blocks
			setCustomModelResourceLocation(AlmaniumBlock);
			setCustomModelResourceLocation(AlmaniumNetherrackOreBlock);
			setCustomModelResourceLocation(AlmaniumOreBlock);

			// Tools and weapons
			setCustomModelResourceLocation(AlmaniumAxe);
			setCustomModelResourceLocation(AlmaniumHoe);
			setCustomModelResourceLocation(AlmaniumPickaxe);
			setCustomModelResourceLocation(AlmaniumShovel);
			setCustomModelResourceLocation(AlmaniumSword);

			// Armor
			setCustomModelResourceLocation(AlmaniumBoots);
			setCustomModelResourceLocation(AlmaniumChestplate);
			setCustomModelResourceLocation(AlmaniumHelmet);
			setCustomModelResourceLocation(AlmaniumLeggings);

			// Miscellaneous
			setCustomModelResourceLocation(AlmaniumIngot);
			setCustomModelResourceLocation(AlmaniumNugget);
		}

		@SideOnly(Side.CLIENT)
		private static void setCustomModelResourceLocation(Item item) {
			ModelLoader.setCustomModelResourceLocation(
				item,
				0,
				new ModelResourceLocation(item.getRegistryName(), "inventory")
			);
		}
	}

	public static class Materials {
		public static ArmorMaterial armor = EnumHelper.addArmorMaterial(
			"almanium",
			"almanium:almanium",
			15,
			new int[] {2, 6, 5, 2},
			9,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			0f
		);
	}
}
