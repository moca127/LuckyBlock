package kr.mocha;

import java.util.LinkedHashMap;
import java.util.Random;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class LuckyBox extends PluginBase implements Listener{
	public Config blockDB;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("block", "80:0");
		getDataFolder().mkdirs();
		blockDB = new Config(getDataFolder()+"/blockDB.yml",Config.YAML,map);
        super.onEnable();
	}
	@Override
	public void onDisable() {
        blockDB.save();
        super.onDisable();
	}
	@EventHandler(priority = EventPriority.LOW)
	public void onBrake(BlockBreakEvent event){
		Block block = event.getBlock();
		Item target = Item.fromString(blockDB.getString("block"));
		Item item = event.getItem();

		Player player = event.getPlayer();
		if(block.getId() == target.getId()){
			if(!item.isTool()){
				randoms(player);
			}
		}
	}
	public void randoms(Player player){
		Random random = new Random();
		int i = random.nextInt(120);

		try{
			if(i<5){
				player.getInventory().addItem(Item.get(Item.EMERALD_BLOCK,0,3));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.EMERALD_BLOCK).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<10){
				player.getInventory().addItem(Item.get(Item.DIAMOND_BLOCK,0,3));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.DIAMOND_BLOCK).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<15){
				player.getInventory().addItem(Item.get(Item.GOLD_BLOCK,0,3));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.GOLD_BLOCK).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<20){
				player.getInventory().addItem(Item.get(Item.IRON_BLOCK,0,3));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.IRON_BLOCK).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<25){
				player.getInventory().addItem(Item.get(Item.EMERALD,0,5));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.EMERALD).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<30){
				player.getInventory().addItem(Item.get(Item.DIAMOND,0,5));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.DIAMOND).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<35){
				player.getInventory().addItem(Item.get(Item.GOLD_INGOT,0,5));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.GOLD_INGOT).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<40){
				player.getInventory().addItem(Item.get(Item.IRON_INGOT,0,5));
				player.sendMessage(TextFormat.YELLOW+Item.get(Item.IRON_INGOT).getName()+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<45){
				player.getInventory().addItem(Item.get(Item.POTION,6,1));
				player.getInventory().addItem(Item.get(Item.POTION,11,1));
				player.getInventory().addItem(Item.get(Item.POTION,13,1));
				player.getInventory().addItem(Item.get(Item.POTION,16,1));
				player.getInventory().addItem(Item.get(Item.POTION,22,1));
				player.getInventory().addItem(Item.get(Item.POTION,30,1));
				player.getInventory().addItem(Item.get(Item.POTION,33,1));
				player.sendMessage(TextFormat.YELLOW+"마시는 포션 1개씩!"+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<50){
				player.getInventory().addItem(Item.get(Item.POTION,30,3));
				player.getInventory().addItem(Item.get(Item.POTION,16,3));
				player.getInventory().addItem(Item.get(Item.POTION,33,3));
				player.sendMessage(TextFormat.YELLOW+"PVP용 포션 3개묶음!"+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<55){
				player.getInventory().addItem(Item.get(Item.SPLASH_POTION,35,3));
				player.getInventory().addItem(Item.get(Item.SPLASH_POTION,27,3));
				player.getInventory().addItem(Item.get(Item.SPLASH_POTION,18,3));
				player.getInventory().addItem(Item.get(Item.SPLASH_POTION,24,3));
				player.sendMessage(TextFormat.YELLOW+"부정효과 포션 세트!"+TextFormat.BLUE+"에 당첨되셨습니다.");
			}
			else if(i<60){
				player.getInventory().addItem(Item.get(Item.DIAMOND_BOOTS));
				player.getInventory().addItem(Item.get(Item.DIAMOND_LEGGINGS));
				player.getInventory().addItem(Item.get(Item.DIAMOND_CHESTPLATE));
				player.getInventory().addItem(Item.get(Item.DIAMOND_HELMET));
				player.getInventory().addItem(Item.get(Item.DIAMOND_SWORD));
				player.getInventory().addItem(Item.get(Item.DIAMOND_PICKAXE));
				player.getInventory().addItem(Item.get(Item.DIAMOND_AXE));
				player.sendMessage(TextFormat.YELLOW+"대박!다이아몬드 풀세트!"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<65){
				player.getInventory().addItem(Item.get(Item.IRON_BOOTS));
				player.getInventory().addItem(Item.get(Item.IRON_LEGGINGS));
				player.getInventory().addItem(Item.get(Item.IRON_CHESTPLATE));
				player.getInventory().addItem(Item.get(Item.IRON_HELMET));
				player.getInventory().addItem(Item.get(Item.IRON_SWORD));
				player.getInventory().addItem(Item.get(Item.IRON_PICKAXE));
				player.getInventory().addItem(Item.get(Item.IRON_AXE));
				player.sendMessage(TextFormat.YELLOW+"나쁘지 않아..철 풀세트!"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<70){
				player.getInventory().addItem(Item.get(Item.DIAMOND_SWORD));
				player.getInventory().addItem(Item.get(Item.DIAMOND_PICKAXE));
				player.getInventory().addItem(Item.get(Item.DIAMOND_AXE));
				player.sendMessage(TextFormat.YELLOW+"다이아몬드 도구 세트!"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<75){
				player.getInventory().addItem(Item.get(Item.IRON_SWORD));
				player.getInventory().addItem(Item.get(Item.IRON_PICKAXE));
				player.getInventory().addItem(Item.get(Item.IRON_AXE));
				player.sendMessage(TextFormat.YELLOW+"꽝 보다는 나은 철 도구 세트!"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<80){
				player.getInventory().addItem(Item.get(Item.DIAMOND_BOOTS));
				player.getInventory().addItem(Item.get(Item.DIAMOND_LEGGINGS));
				player.getInventory().addItem(Item.get(Item.DIAMOND_CHESTPLATE));
				player.getInventory().addItem(Item.get(Item.DIAMOND_HELMET));
				player.sendMessage(TextFormat.YELLOW+"다이아갑옷 세트!!"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<85){
				player.getInventory().addItem(Item.get(5,0,64));
				player.getInventory().addItem(Item.get(5,1,64));
				player.getInventory().addItem(Item.get(5,2,64));
				player.getInventory().addItem(Item.get(5,3,64));
				player.sendMessage(TextFormat.YELLOW+"나무파뤼"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<90){
				player.getInventory().addItem(Item.get(Item.OBSIDIAN,0,32));
				player.sendMessage(TextFormat.YELLOW+"옵시디언 32개"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else if(i<100){
				player.getInventory().addItem(Item.fromStringMultiple(blockDB.getString("block")));
				player.getInventory().addItem(Item.fromStringMultiple(blockDB.getString("block")));
				player.getInventory().addItem(Item.fromStringMultiple(blockDB.getString("block")));
				player.sendMessage(TextFormat.YELLOW+"다시할 기회를 3번더 드리지"+TextFormat.BLUE+" 에 당첨되셨습니다.");
			}
			else{
				player.sendMessage(TextFormat.YELLOW+"꽝! "+TextFormat.BLUE+"입니다.");
			}
		}catch (Exception e){
			player.sendMessage(TextFormat.YELLOW+"꽝! "+TextFormat.BLUE+"입니다.");
		}
	}
}
