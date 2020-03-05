package genconf;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;

public class ConvMain {

	public interface Checkable{
		public void checkValid(java.util.Map<String,java.util.Map<Integer,? extends Object> > objs);
	}
	final static private org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ConvMain.class);
	public static String getCellValue(Row w,String name,java.util.ArrayList<String> collnames){
		int index=collnames.indexOf(name);
		if(index<0) throw new IllegalArgumentException("閿欒鐨勫弬鏁�,name="+name);
		Cell c=w.getCell(index);
		if(c==null){
			return null;
		}
		switch(c.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			 double d = c.getNumericCellValue();
			 if((int)d == d)
			 	return String.valueOf((int)d);
			 else
			 	return String.valueOf(d);
		case Cell.CELL_TYPE_STRING:
			return c.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(c.getBooleanCellValue());		
		default:
			throw new RuntimeException("鍦ㄧ"+w.getRowNum()+"琛岀殑\""+name+"\"瀛楁涓彂鐜版湭鐭ョ殑cell绫诲瀷"+c.getCellType());
		}
	}
	
	public static Integer getIntegerCellValue(Row w,String name,java.util.ArrayList<String> collnames){
		int index=collnames.indexOf(name);
		if(index<0) throw new IllegalArgumentException("閿欒鐨勫弬鏁�,name="+name);
		Cell c=w.getCell(index);
		if(c==null){
			return null;
		}
		switch(c.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			return (int)c.getNumericCellValue();
		case Cell.CELL_TYPE_STRING:
			return Integer.valueOf(c.getStringCellValue());
		default:
			throw new RuntimeException("鏈煡鐨刢ell绫诲瀷");
		}
	}
	
	public static Long getLongCellValue(Row w,String name,java.util.ArrayList<String> collnames){
		int index=collnames.indexOf(name);
		if(index<0) throw new IllegalArgumentException("閿欒鐨勫弬鏁�,name="+name);
		Cell c=w.getCell(index);
		if(c==null){
			return null;
		}
		switch(c.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			return (long)c.getNumericCellValue();
		case Cell.CELL_TYPE_STRING:
			return Long.valueOf(c.getStringCellValue());
		default:
			throw new RuntimeException("鏈煡鐨刢ell绫诲瀷");
		}
	}
	
	public static Boolean getBooleanCellValue(Row w,String name,java.util.ArrayList<String> collnames){
		int index=collnames.indexOf(name);
		if(index<0) throw new IllegalArgumentException("閿欒鐨勫弬鏁�,name="+name);
		Cell c=w.getCell(index);
		if(c==null){
			return null;
		}
		switch(c.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			return c.getNumericCellValue()!=0;
		case Cell.CELL_TYPE_STRING:
			{
				String t=c.getStringCellValue();
				if(t.equals("鏄�") || t.equals("true"))
					return true;
				else if(t.equals("鍚�") || t.equals("false"))
					return false;
				else
					throw new RuntimeException("鍦ㄧ"+w.getRowNum()+"琛岀殑\""+name+"\"瀛楁涓彂鐜伴敊璇殑鍊�"+t);
			}
		default:
			throw new RuntimeException("鏈煡鐨刢ell绫诲瀷");
		}
	}
	
	public static Double getDoubleCellValue(Row w,String name,java.util.ArrayList<String> collnames){
		int index=collnames.indexOf(name);
		if(index<0) throw new IllegalArgumentException("閿欒鐨勫弬鏁�,name="+name);
		Cell c=w.getCell(index);
		if(c==null){
			return null;
		}
		switch(c.getCellType()){
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_NUMERIC:
			return c.getNumericCellValue();
		case Cell.CELL_TYPE_STRING:
			return Double.valueOf(c.getStringCellValue());
		default:
			throw new RuntimeException("鏈煡鐨刢ell绫诲瀷");
		}
	}
	private static void usage(){
		System.out.println("usage: java -jar xxx.jar inputdir server_outputdir client_outputdir");
	}
	
	private static final String[] serverClassList={
			"ares.logic.main.ModuleInfo",
			"ares.logic.main.HotfixConfig",
			"ares.logic.main.HotfixXml2ModuleConfig",
			"ares.logic.main.LoginLimit",
			"ares.logic.main.JumpQueueUser",
			"ares.logic.map.MapConfig",
			"ares.logic.map.SActivityAwardItems",
			"ares.logic.item.ItemAttr",
			"ares.logic.item.PetAffixAttr",
			"ares.logic.item.gemItemAttr",
			"ares.logic.item.HuobanPassiveSkillbookAttr",
			"ares.logic.item.SYinjiAttr",
			"ares.logic.item.SYinjisuittype",
			"ares.logic.item.SDiamondProp",
			"ares.logic.item.BagConfig",
			"ares.logic.item.ItemAttrClassToLoad",
			"ares.logic.item.ItemClassToLoad",
			"ares.logic.item.SPetShouhuStar",
			"ares.logic.item.PetChipAttr",
			"ares.logic.item.PartnerTokenAttr",
			"ares.logic.item.FoodItemAttr",
			"ares.logic.item.STreasureMapItemAttr",
			"ares.logic.item.EquipItemAttr",
			"ares.logic.item.SEquipStrengthen",
			"ares.logic.item.PetItemAttr",
			"ares.logic.item.SPresentConfig",
			"ares.logic.item.SItemduihuan",
			"ares.logic.item.SEquipCombin",
			"ares.logic.item.SItemStore",
			"ares.logic.item.SStorePriceUnit",
			"ares.logic.item.SItemShop",
			"ares.logic.item.SItemShop__3",
			"ares.logic.item.SJifenShop",
			"ares.logic.item.SFactionShop",
			"ares.logic.item.SItemBuff",
			"ares.logic.item.SBagPrice",
			"ares.logic.item.SBaoshitaozhuang",
			"ares.logic.item.Sgemlv",
			"ares.logic.item.Smoneycost",
			"ares.logic.item.SequipScoreConfig",
			"ares.logic.item.SWandering",
			"ares.logic.item.SItemRideConfig",
			"ares.logic.item.SQuickSynthesis",
			"ares.logic.item.SAnonyCard",
			"ares.logic.item.SAnonyCardGift",
			"ares.logic.item.SSellType",
			"ares.logic.item.SSalepower",
			"ares.logic.item.SPetItemReturnOff",
			"ares.logic.item.SSaleType",
			"ares.logic.item.SgodEquipSkillRandom",
			"ares.logic.item.SgodEquipAdditionAttribute",
			"ares.logic.item.SgodEquipAdditionAttributeRandom",
			"ares.logic.item.SgodEquipAdditionAttributeBelong",
			"ares.logic.item.SgodEquipBaseAttributeRandom",
			"ares.logic.item.SGodEquipSplit",
			"ares.logic.item.SgodEquipIdentified",
			"ares.logic.item.SRareGodEquipConfig",
			"ares.logic.item.SfashionConfig",
			"ares.logic.item.SStarinfoAttr",
			"ares.logic.item.SGodEquipUpgradeConfig",
			"ares.logic.item.SItemAddPet",
			"ares.logic.item.SGodequipUpdateConfig",
			"ares.logic.item.SGodequipCreateConfig",
			"ares.logic.item.SItemAddDialNumConfig",
			"ares.logic.item.Sqinmidu",
			"ares.logic.item.SlingfuInfo",
			"ares.logic.item.Skite",
			"ares.logic.item.SFashionAttributeConfig",
			"ares.logic.item.ShuanhuaConfig",
			"ares.logic.item.ShuanhuaReturn",
			"ares.logic.item.SgodEquipChange",
			"ares.logic.item.SCustomeEquip",
			"ares.logic.item.SItemGetGodEquip",
			"ares.logic.item.SItemProvideGodExp",
			"ares.logic.item.Sschoolequip",
			"ares.logic.item.Sgenderequip",
			"ares.logic.item.Sgemid",
			"ares.logic.item.SItemaddAtlExp",
			"ares.logic.item.Syufusuit",
			"ares.logic.item.Syufucaoconfig",
			"ares.logic.item.Slingyiskillunlock",
			"ares.logic.item.Slingyiskillinfo",
			"ares.logic.item.Syuansuupperlimit",
			"ares.logic.item.Slingyiskillmapping",
			"ares.logic.item.Spluralityelementskillunlock",
			"ares.logic.item.SyufuItem",
			"ares.logic.item.SChenShuiShouItem",
			"ares.logic.item.SZhenYuShouItem",
			"ares.logic.item.SCompositeResult",
			"ares.logic.item.SCultivateResult",
			"ares.logic.item.SAttrlibrary",
			"ares.logic.item.ScultivateSlot",
			"ares.logic.item.SMosaicSlot",
			"ares.logic.item.SAttrnum",
			"ares.logic.item.SExtraitemlist",
			"ares.logic.item.SCompositeExtralist",
			"ares.logic.item.SAgateSuitAttr",
			"ares.logic.item.SAgateSkill",
			"ares.logic.item.SShiPinConfig",
			"ares.logic.item.SShipinfashionitemConfig",
			"ares.logic.item.SItemRecharge",
			"ares.logic.item.SYinjiSuitConfig",
			"ares.logic.item.SYinjibaseRandom",
			"ares.logic.item.SYinjiincidentRandom",
			"ares.logic.item.SYinjiUpgrade",
			"ares.logic.item.SMagicScreen",
			"ares.logic.item.SAffixScreen",
			"ares.logic.item.SHalloween",
			"ares.logic.item.SEquipSoulConfig",
			"ares.logic.item.SEquipSoulUpdate",
			"ares.logic.item.SEquiplevelexp",
			"ares.logic.item.SSoulLibrary",
			"ares.logic.effect.SAttrEffectID2Name",
			"ares.logic.effect.SLevelStandardAttr",
			"ares.logic.npc.SMonsterConfig",
			"ares.logic.npc.SNpcShape",
			"ares.logic.npc.SNpcServiceConfig",
			"ares.logic.npc.SServiceConds",
			"ares.logic.npc.SAllConds",
			"ares.logic.npc.SNpcShare",
			"ares.logic.npc.SNpcShare__3",
			"ares.logic.npc.SXiakeMonsterconfig",
			"ares.logic.npc.SXiakeBreakAttrConfig",
			"ares.logic.npc.SXiakePassiveSkillSlot",
			"ares.logic.npc.SXiakeBreakConfig",
			"ares.logic.npc.SXiakeskill",
			"ares.logic.npc.SMonsterAttackNpc",
			"ares.logic.npc.SMonsterAttackConfig",
			"ares.logic.npc.SMonsterAttackRefresh",
			"ares.logic.npc.SLevelRange",
			"ares.logic.npc.WantedCircularNameConfig",
			"ares.logic.npc.WantedCircularNameConfig__4",
			"ares.logic.npc.SWantedCircularSerieseConfig",
			"ares.logic.npc.SWantedCircularGroupConfig",
			"ares.logic.npc.WantedCircularTimeConfig",
			"ares.logic.npc.SSinglepkactivitynpc",
			"ares.logic.npc.SSinglepkactivitybuff",
			"ares.logic.npc.SSinglepkactivityguide",
			"ares.logic.npc.SSinglepkactivityguidenpc",
			"ares.logic.npc.SSinglepkactivitygroup",
			"ares.logic.npc.SSinglepkactivityscore",
			"ares.logic.npc.SActivityNpcPos",
			"ares.logic.npc.SGatherConfig",
			"ares.logic.npc.SHireNpc",
			"ares.logic.npc.SXiakeAI",
			"ares.logic.npc.SPickupnum",
			"ares.logic.npc.SSceneItem",
			"ares.logic.npc.SRandomNpcConfig",
			"ares.logic.npc.PartnerUnlockConsume",
			"ares.logic.npc.FreePartnerConfig",
			"ares.logic.npc.PartnerCallItem",
			"ares.logic.npc.PartnerTaskConstraints",
			"ares.logic.npc.SpecialPartnerUnlock",
			"ares.logic.npc.SNpcMonitor",
			"ares.logic.npc.SNpcDynamicservice",
			"ares.logic.npc.SPartnerLvParameterConfig",
			"ares.logic.npc.SGetPartnerWeightConfig",
			"ares.logic.npc.SGetPartnerConfig",
			"ares.logic.npc.SSpecialGetPartnerConfig",
			"ares.logic.npc.DemonItem",
			"ares.logic.npc.SlingfuSlot",
			"ares.logic.npc.SlingfuPlan",
			"ares.logic.npc.SlingfuAttrMapping",
			"ares.logic.npc.SLingfuResonance",
			"ares.logic.npc.SXiakeBreakAdditionConfig",
			"ares.logic.npc.SnpcAward",
			"ares.logic.role.RoleConfig",
			"ares.logic.role.Redirect",
			"ares.logic.role.SCreateRoleFirstBattle",
			"ares.logic.role.SCreateRoleConfig",
			"ares.logic.role.SAttrModData",
			"ares.logic.role.NextExpAndResMoney",
			"ares.logic.role.RoleLevelSkillLevel",
			"ares.logic.role.SSpeedname",
			"ares.logic.role.SServerMaxLevelConfig",
			"ares.logic.role.SServerLogicOpenTime",
			"ares.logic.role.SServerLevelConfig",
			"ares.logic.role.SServerExpDecay",
			"ares.logic.role.SDamageToSp",
			"ares.logic.role.SZuoQi",
			"ares.logic.role.SZuoQiBianShen",
			"ares.logic.role.SProsperityDegree",
			"ares.logic.role.SProsperityDegreeConfig",
			"ares.logic.role.SdyeCost",
			"ares.logic.role.SRideUnlockConsume",
			"ares.logic.role.SZuoqiTrain",
			"ares.logic.role.SZuoqiAttr",
			"ares.logic.role.SZuoqiSkill",
			"ares.logic.role.SzuoqiUpdate",
			"ares.logic.role.Szuoqipresent",
			"ares.logic.pet.SPetColumn",
			"ares.logic.pet.PetAttr",
			"ares.logic.pet.PetNextExp",
			"ares.logic.pet.SPetSatietyExp",
			"ares.logic.pet.SPetFeed",
			"ares.logic.pet.SPetFeedSkill",
			"ares.logic.pet.SPetJueXing",
			"ares.logic.pet.SPetchipSynthesis",
			"ares.logic.pet.SPetchapter",
			"ares.logic.pet.SPetillustrated",
			"ares.logic.pet.SPetScoreConfig",
			"ares.logic.pet.SPetstars",
			"ares.logic.pet.SPetcallnum",
			"ares.logic.pet.SPetZizhiSection",
			"ares.logic.pet.SPetSummonAwardConfig",
			"ares.logic.pet.SPetSkillStudyConfig",
			"ares.logic.pet.SPetSkillFristStudy",
			"ares.logic.pet.SCustomizedPet",
			"ares.logic.pet.SPetAttrCalc",
			"ares.logic.pet.SRarePetExchange",
			"ares.logic.pet.SPetControlSpeed",
			"ares.logic.pet.SPetShouhuStarAttr",
			"ares.logic.pet.SPetShouhuStarAttrRandom",
			"ares.logic.pet.SPetShouhuStarstoAttr",
			"ares.logic.pet.SPetShouhuStarsSuit",
			"ares.logic.pet.SSoulItem",
			"ares.logic.pet.Selesoullv",
			"ares.logic.pet.SSoulCost",
			"ares.logic.pet.SSoulAttri",
			"ares.logic.pet.SPETYingLingConfig",
			"ares.logic.login.SCompensationConfig",
			"ares.logic.login.SCompensationCondition",
			"ares.logic.login.SAdfiltering",
			"ares.logic.battle.SFormationConfig",
			"ares.logic.battle.SAIAction",
			"ares.logic.battle.STargetFilter",
			"ares.logic.battle.SCondition",
			"ares.logic.battle.SBattleAI",
			"ares.logic.battle.SBattleInfo",
			"ares.logic.battle.SBattleInfoBoss",
			"ares.logic.battle.SMonsterTypeConfig",
			"ares.logic.SystemSetting.SFunctionConfigSetting",
			"ares.logic.SystemSetting.SHotdeployClass",
			"ares.logic.SystemSetting.SGMsystem",
			"ares.logic.title.STitleConfig",
			"ares.logic.title.SItemTitleConfig",
			"ares.logic.title.SIntimacyAddTitle",
			"ares.logic.game.firstaward",
			"ares.logic.game.Sduihuanma",
			"ares.logic.game.Sduihuanmagroup",
			"ares.logic.game.Sgonghuima",
			"ares.logic.game.SGobalExchangeServicesConfig",
			"ares.logic.game.SFengYaoConfig",
			"ares.logic.game.SFortuneWheel",
			"ares.logic.game.SActivityAward",
			"ares.logic.game.ExternalAward",
			"ares.logic.game.SVIPconfig",
			"ares.logic.game.Sdenglulibao",
			"ares.logic.game.Spaihangbang",
			"ares.logic.game.Sbangpaishilibang",
			"ares.logic.game.Spaihangbangaward",
			"ares.logic.game.SEnumer",
			"ares.logic.game.SBattleTypeConfig",
			"ares.logic.game.SNormalTreasureMapRegionConfig",
			"ares.logic.game.SNormalTreasureMapActivityConfig",
			"ares.logic.game.SBigTreasureMapActivityConfig",
			"ares.logic.game.SBigTreasureMapAwardPreview",
			"ares.logic.game.SBigTreasureMapFangYaoWangConfig",
			"ares.logic.game.SBigTreasureMapBigAward",
			"ares.logic.game.SYaBiaoEvent",
			"ares.logic.game.SYaBiaoRandom",
			"ares.logic.game.Sclimbtower",
			"ares.logic.game.Sclimbtoweritem",
			"ares.logic.game.Sclimbtowerkillmonsters",
			"ares.logic.game.SLvLimitConfig",
			"ares.logic.game.SXianjianAnswer",
			"ares.logic.game.SAnswerReward",
			"ares.logic.game.SAnswerExtraPremium",
			"ares.logic.game.SSign",
			"ares.logic.game.SSign",
			"ares.logic.game.SAccumulatedSign",
			"ares.logic.game.SWuXuanYiconfig",
			"ares.logic.game.SLevePackage",
			"ares.logic.game.SSevendaysreward",
			"ares.logic.game.SJJCGradeConfig",
			"ares.logic.game.SShushanPk",
			"ares.logic.game.SShushanMatch",
			"ares.logic.game.SShuShanAward",
			"ares.logic.game.SShuShanMailConfig",
			"ares.logic.game.SJJCBotConfig",
			"ares.logic.game.SJJCRankAward",
			"ares.logic.game.SJJCGradeAward",
			"ares.logic.game.SGuideEspecialSkill",
			"ares.logic.game.SpinjiandahuiAward",
			"ares.logic.game.SXianMengChapter",
			"ares.logic.game.SXianMengStage",
			"ares.logic.game.SLevelStopConfig",
			"ares.logic.game.SchievementGoal",
			"ares.logic.game.SWorldQuestion",
			"ares.logic.game.SWatchBattle",
			"ares.logic.game.SIDSealedConfig",
			"ares.logic.game.SpinjianFinalAward",
			"ares.logic.game.SUpdateReward",
			"ares.logic.game.SRollActivityAward",
			"ares.logic.game.SinvitationAward",
			"ares.logic.game.SServerCivilWar",
			"ares.logic.game.SServerCivilWarSchedule",
			"ares.logic.game.SServerCivilWarAward",
			"ares.logic.game.SCampReward",
			"ares.logic.game.SCampRewardStar",
			"ares.logic.game.SArenaConfig",
			"ares.logic.game.SArenaRobotConfig",
			"ares.logic.game.SArenaRankAwardConfig",
			"ares.logic.game.SArenaRobotNameRandom",
			"ares.logic.game.SGuajibattleConfig",
			"ares.logic.game.SUnlockTrailer",
			"ares.logic.game.Scampbattlebuff",
			"ares.logic.game.SExperienceRain",
			"ares.logic.game.STaoyuanBattleBuff",
			"ares.logic.game.STaoyuanMonsterConfig",
			"ares.logic.game.SFeastIngredients",
			"ares.logic.game.SFeastFood",
			"ares.logic.game.SFeastAnswer",
			"ares.logic.game.SFeastchest",
			"ares.logic.game.SFeastnpcgrid",
			"ares.logic.game.SLingshouTravelProbability",
			"ares.logic.game.SLingshouTravelCharacter",
			"ares.logic.game.SLingshouTravelCalendar",
			"ares.logic.game.SLingshouTravelIncidentLibrary",
			"ares.logic.game.SLingshouTravelSetoutProbability",
			"ares.logic.game.SLingshouTravelSetoutLibrary",
			"ares.logic.game.SLingshouTravelTreasureboxPrice",
			"ares.logic.game.SWineConfig",
			"ares.logic.game.CSplitPackageConfig",
			"ares.logic.game.SAtlascollectreward",
			"ares.logic.game.SAtlasattributereward",
			"ares.logic.game.SAtlasUpgrade",
			"ares.logic.game.SSpecialattributes",
			"ares.logic.game.SSeparatePackage",
			"ares.logic.game.SRandomDialBattle",
			"ares.logic.game.SBangpaiQiangdaoNumConfig",
			"ares.logic.game.SBangpaiQiangdaoMonsterConfig",
			"ares.logic.game.STongTianTa",
			"ares.logic.game.SServerCivilWar",
			"ares.logic.game.SServerCivilWarSchedule",
			"ares.logic.game.SServerCivilWarAward",
			"ares.logic.game.SFengshenBattleConfig",
			"ares.logic.game.SFengshenBattleGuess",
			"ares.logic.game.SShenbingExchange",
			"ares.logic.game.SRepConfig",
			"ares.logic.game.SReincarnationAward",
			"ares.logic.game.SJulingzhuConfig",
			"ares.logic.game.STianjiReelConfig",
			"ares.logic.game.STianjiReelUpgradeConfig",
			"ares.logic.game.SWuxingxiulianConfig",
			"ares.logic.game.SwuxingxiulianReward",
			"ares.logic.game.SUpdateReward",
			"ares.logic.game.SWinterActivity",
			"ares.logic.game.SWinterIntegralAward",
			"ares.logic.game.SWinterTask",
			"ares.logic.game.SWinterSeeking",
			"ares.logic.game.SAvatarFrame",
			"ares.logic.game.SAvatarFrameItem",
			"ares.logic.game.SLingMaiUpgrade",
			"ares.logic.game.SLingMaiItem",
			"ares.logic.game.SLingMaiResonance",
			"ares.logic.game.SChatBubble",
			"ares.logic.game.SChatBubbleItem",
			"ares.logic.game.Sxmasactivity",
			"ares.logic.game.Sxmaswishingitem",
			"ares.logic.game.SRewardOrder",
			"ares.logic.buff.SCBuffConfig",
			"ares.logic.buff.SIBuffConfig",
			"ares.logic.buff.SBuffConflicts",
			"ares.logic.buff.SNuhuoBuff",
			"ares.logic.buff.SBufftip",
			"ares.logic.buff.SBufftip",
			"ares.logic.buff.SSpecilImmunologyBuff",
			"ares.logic.message.SMessageTip",
			"ares.logic.message.SPostbox",
			"ares.logic.skill.SSkillCost",
			"ares.logic.skill.SLingconfig",
			"ares.logic.skill.SZheJianzhaohuan",
			"ares.logic.skill.SKillBuff",
			"ares.logic.skill.SSkillBuffmachRelate",
			"ares.logic.skill.SPetSkillupgrade",
			"ares.logic.skill.SActionTime",
			"ares.logic.skill.SPetSkillitem",
			"ares.logic.skill.SSkillConfig",
			"ares.logic.skill.SScattered",
			"ares.logic.skill.SSkillLevelLimit",
			"ares.logic.skill.SSpecialBuffConfig",
			"ares.logic.skill.SPetHunyinProbability",
			"ares.logic.skill.SHuanhuaRandom",
			"ares.logic.skill.SHuobanPassiveSkillupgrade",
			"ares.logic.task.SAllTaskLine",
			"ares.logic.task.SQuestCanAcceptList",
			"ares.logic.task.SActiveCalenderConfig",
			"ares.logic.task.SActiveChestConfig",
			"ares.logic.task.Squestions",
			"ares.logic.task.SAnimation",
			"ares.logic.task.SFirstanimationcontrol",
			"ares.logic.task.SQuestionTask",
			"ares.logic.task.SBangpaiTask",
			"ares.logic.task.SActiAwardRetrieve",
			"ares.logic.team.SZhenFaeffect",
			"ares.logic.team.SZhenFacost",
			"ares.logic.team.STeamMatchConfig",
			"ares.logic.team.STeamMatchFirstConfig",
			"ares.logic.team.SStarnature",
			"ares.logic.team.SRobotGrade",
			"ares.logic.team.SRobotEquip",
			"ares.logic.team.SRobotFactionSkill",
			"ares.logic.team.SRobotPet",
			"ares.logic.timer.SScheculedActivity",
			"ares.logic.specialquest.SchoolWheel",
			"ares.logic.specialquest.SWDHConfig",
			"ares.logic.specialquest.SWDHmsgConfig",
			"ares.logic.specialquest.SWDHmapConfig",
			"ares.logic.specialquest.SPJDHmatchConfig",
			"ares.logic.specialquest.SPJDHlevelConfig",
			"ares.logic.specialquest.SSchoolTaskConfig",
			"ares.logic.specialquest.SSchoolTaskMain",
			"ares.logic.specialquest.SSchoolTaskBank",
			"ares.logic.specialquest.SQieTingTaskItem",
			"ares.logic.specialquest.SRankQuesions",
			"ares.logic.specialquest.SPicQuesions",
			"ares.logic.specialquest.STreasureMapTaskConfig",
			"ares.logic.specialquest.SGhosts",
			"ares.logic.specialquest.SBattleTarget",
			"ares.logic.specialquest.SPatrolMap",
			"ares.logic.specialquest.SHeadPortrait",
			"ares.logic.specialquest.SgiveWandering",
			"ares.logic.specialquest.SgivehaiMarket",
			"ares.logic.specialquest.STaskChainStype",
			"ares.logic.specialquest.SEachRoundReward",
			"ares.logic.specialquest.SExperience",
			"ares.logic.specialquest.STasktypedescribe",
			"ares.logic.specialquest.SMissionNPCConfig",
			"ares.logic.specialquest.Sassistance",
			"ares.logic.specialquest.SJigsawLib",
			"ares.logic.specialquest.STaskChainMap",
			"ares.logic.specialquest.STaskChainLib",
			"ares.logic.specialquest.STaskChainRandom",
			"ares.logic.specialquest.SZhuRiTaskConfig",
			"ares.logic.chat.SchatConfig",
			"ares.logic.chat.StopicConfig",
			"ares.logic.chat.SbattleFailedMessage",
			"ares.logic.friend.SfriendDegrees",
			"ares.logic.friend.SFlowerConfig",
			"ares.logic.friend.SEngagedConf",
			"ares.logic.friend.SfriendGiftsNumber",
			"ares.logic.friend.SfriendGiftsItem",
			"ares.logic.task.SMainMissionInfo",
			"ares.logic.faction.SFactionOfficeConfig",
			"ares.logic.faction.SFactionLevel",
			"ares.logic.faction.SCampConfig",
			"ares.logic.faction.SCampJumpConfig",
			"ares.logic.faction.SFactionSkill",
			"ares.logic.faction.SFactionPurchase",
			"ares.logic.faction.SFactionWelfareView",
			"ares.logic.faction.SCampOfficeConfig",
			"ares.logic.faction.SCampLeaveConfig",
			"ares.logic.faction.SGhostSealMap",
			"ares.logic.faction.SFactionGive",
			"ares.logic.faction.SFactionRobberRefreshConfig",
			"ares.logic.faction.SFactionRobberMonsterConfig",
			"ares.logic.faction.PKWuxunConfigFighterNum",
			"ares.logic.faction.PKWuxunConfigGuanzhi",
			"ares.logic.faction.PKWuxunConfigLv",
			"ares.logic.faction.SFactionQA",
			"ares.logic.faction.SFactionShipConfig",
			"ares.logic.faction.SFactionSteal",
			"ares.logic.faction.SFactionStealTaskConfig",
			"ares.logic.faction.SFactionpetCharacter",
			"ares.logic.faction.SFactionpetSwallow",
			"ares.logic.faction.SFactionpetEvolution",
			"ares.logic.faction.SFactionpetReward",
			"ares.logic.faction.SFactionpetVolume",
			"ares.logic.faction.SFactionpetNewRandom",
			"ares.logic.faction.SFactionActivity",
			"ares.logic.faction.SInvadereward",
			"ares.logic.faction.SFactionAngelconfig",
			"ares.logic.faction.SFactionAngelcaiji",
			"ares.logic.faction.STerritoryKill",
			"ares.logic.faction.STerritoryConfig",
			"ares.logic.faction.SNumberreward",
			"ares.logic.faction.Scollectbattle",
			"ares.logic.faction.Scollectreward",
			"ares.logic.faction.STerritoryShopgroup",
			"ares.logic.faction.STerritoryShop",
			"ares.logic.faction.SFactionPrestigeRank",
			"ares.logic.faction.SDonationList",
			"ares.logic.faction.SCollectionWeight",
			"ares.logic.faction.SFactionPrestigeData",
			"ares.logic.log.SLogFormatConfig",
			"ares.logic.yuanbao.SAddCash",
			"ares.logic.yuanbao.SAddCash__3",
			"ares.logic.yuanbao.SAddYuanbao",
			"ares.logic.yuanbao.SUseYuanbao",
			"ares.logic.yuanbao.SLimitSell",
			"ares.logic.yuanbao.SCost",
			"ares.logic.yuanbao.SGiftDai",
			"ares.logic.yuanbao.SOpenCash",
			"ares.logic.yuanbao.SkaifuActivity",
			"ares.logic.yuanbao.SkaifuMissionLibrary",
			"ares.logic.yuanbao.SkaifuPlan",
			"ares.logic.yuanbao.SfirstCharge",
			"ares.logic.yuanbao.SpreserveAward",
			"ares.logic.yuanbao.SkaifuFaction",
			"ares.logic.yuanbao.SinviteScoreAward",
			"ares.logic.yuanbao.SInviteGoalConfig",
			"ares.logic.yuanbao.SRedpacket",
			"ares.logic.yuanbao.SQuestionnaireopen",
			"ares.logic.yuanbao.SGrowthfund",
			"ares.logic.yuanbao.SYiYuanBuy",
			"ares.logic.yuanbao.SRedPacketItem",
			"ares.logic.yuanbao.SChargeConsumeAward",
			"ares.logic.yuanbao.SbingoActivity",
			"ares.logic.yuanbao.SbingoAward",
			"ares.logic.yuanbao.SbingoOpen",
			"ares.logic.yuanbao.SShopdail",
			"ares.logic.yuanbao.STotalChargeAward",
			"ares.logic.yuanbao.SPrivilegecard",
			"ares.logic.yuanbao.SaristocratPackage",
			"ares.logic.yuanbao.SActivegiftbag",
			"ares.logic.yuanbao.SRankAward",
			"ares.logic.yuanbao.SRankAward__3",
			"ares.logic.yuanbao.SAimAward",
			"ares.logic.yuanbao.AwardList",
			"ares.logic.yuanbao.SZhulilibaoopen",
			"ares.logic.yuanbao.SZhulilibaoaward",
			"ares.logic.yuanbao.SFortuneCatConfig",
			"ares.logic.yuanbao.SFortuneCatConfig__3",
			"ares.logic.yuanbao.SGroupBuyAward",
			"ares.logic.yuanbao.SSingleChargeReward",
			"ares.logic.yuanbao.SCashGiveItem",
			"ares.logic.yuanbao.SCashGivePoints",
			"ares.logic.yuanbao.SSpecialgift",
			"ares.logic.yuanbao.SDailyRecharge",
			"ares.logic.yuanbao.SAccumulativeRecharge",
			"ares.logic.yuanbao.SZhuanZhicost",
			"ares.logic.yuanbao.SyuanbaoTurntable",
			"ares.logic.yuanbao.Shunyureturn",
			"ares.logic.yuanbao.SOnlineAward",
			"ares.logic.yuanbao.SZhigouGift",
			"ares.logic.yuanbao.SThreeDaysCharge",
			"ares.logic.yuanbao.SPetLimitSell",
			"ares.logic.yuanbao.SWinterDailyCharge",
			"ares.logic.yuanbao.SFirstChargeAward",
			"ares.logic.yuanbao.SSingleChargeAward",
			"ares.logic.yuanbao.SbingoActivity",
			"ares.logic.yuanbao.SbingoAward",
			"ares.logic.yuanbao.SbingoOpen",
			"ares.logic.yuanbao.SnotputbackTurntable",
			"ares.logic.yuanbao.SnotputbackExtract",
			"ares.logic.yuanbao.Ssmsddiscount",
			"ares.logic.yuanbao.Ssmsdaward",
			"ares.logic.yuanbao.Ssmsditem",
			"ares.logic.yuanbao.SSpikeActivity",
			"ares.logic.yuanbao.SSpikeActivityTime",
			"ares.logic.yuanbao.SSpikeActivityItem",
			"ares.logic.fuben.SFubenjindu",
			"ares.logic.fuben.SFubennpcservice",
			"ares.logic.fuben.SFubennpc",
			"ares.logic.fuben.SFubenconfig",
			"ares.logic.fuben.SFubenthing",
			"ares.logic.fuben.SFubenchildrenjindu",
			"ares.logic.fuben.SDailyFubenConfig",
			"ares.logic.zhiye.SSkilldesignation",
			"ares.logic.zhiye.SVocationalskill",
			"ares.logic.zhiye.SChangeaddpoint",
	};
	
	private static final String[] clientClassList={
			"ares.logic.map.cmaptransport",
			"ares.logic.map.cmappatrolconfig",
			"ares.logic.map.cscenefogconfig",
			"ares.logic.map.cmapconfig",
			"ares.logic.map.cworldmapjump",
			"ares.logic.map.csceneconfig",
			"ares.logic.map.cmapblockconfig",
			"ares.logic.item.cyinjisuittype",
			"ares.logic.item.cgemeffect",
			"ares.logic.item.citemattr",
			"ares.logic.item.cyinjiattr",
			"ares.logic.item.cpetshouhustar",
			"ares.logic.item.chhuobanpassiveskilleffect",
			"ares.logic.item.cpetchipattr",
			"ares.logic.item.cattributedesconfig",
			"ares.logic.item.citemtype",
			"ares.logic.item.cpetitemeffect",
			"ares.logic.item.cequipeffect",
			"ares.logic.item.ctaskrelative",
			"ares.logic.item.ctreasuremapitemattr",
			"ares.logic.item.cequipstrengthen",
			"ares.logic.item.cpresentconfig",
			"ares.logic.item.citemduihuan",
			"ares.logic.item.cequipcombin",
			"ares.logic.item.citemstore",
			"ares.logic.item.citemstoretype",
			"ares.logic.item.citemshop",
			"ares.logic.item.cjifenshop",
			"ares.logic.item.cjifenshoptype",
			"ares.logic.item.cfactionshop",
			"ares.logic.item.citembuffids",
			"ares.logic.item.citembuff",
			"ares.logic.item.cbagprice",
			"ares.logic.item.cbaoshitaozhuang",
			"ares.logic.item.cgemlv",
			"ares.logic.item.cbaoshizhanshi",
			"ares.logic.item.cmoneytype",
			"ares.logic.item.cmoneycost",
			"ares.logic.item.cequipsbscoreconfig",
			"ares.logic.item.citemgetway",
			"ares.logic.item.cwandering",
			"ares.logic.item.cquicksynthesis",
			"ares.logic.item.canonycard",
			"ares.logic.item.canonycardgift",
			"ares.logic.item.cselltype",
			"ares.logic.item.csaletype",
			"ares.logic.item.cpetpricerec",
			"ares.logic.item.cgodequipskillrandom",
			"ares.logic.item.cgodequipadditionattributerandom",
			"ares.logic.item.cgodequipadditionattributebelong",
			"ares.logic.item.cgodequipbaseattributerandom",
			"ares.logic.item.cgodequipsplit",
			"ares.logic.item.cgodequipskillitemconfig",
			"ares.logic.item.cfashionconfig",
			"ares.logic.item.cfashionstoremap",
			"ares.logic.item.cfashionscreeningconfig",
			"ares.logic.item.cstarinfo",
			"ares.logic.item.cproptype",
			"ares.logic.item.cgodequipupgradeconfig",
			"ares.logic.item.citemuse",
			"ares.logic.item.citemuse",
			"ares.logic.item.cgodequipupdateconfig",
			"ares.logic.item.cgodequipcreateconfig",
			"ares.logic.item.cgodequipcreatedisplay",
			"ares.logic.item.cqinmidu",
			"ares.logic.item.clingfuinfo",
			"ares.logic.item.ckite",
			"ares.logic.item.cfashionattributeconfig",
			"ares.logic.item.chuanhuaconfig",
			"ares.logic.item.cgodequipchange",
			"ares.logic.item.citemprovidegodexp",
			"ares.logic.item.cgemid",
			"ares.logic.item.cgemid",
			"ares.logic.item.citemaddatlexp",
			"ares.logic.item.cyufuattrcorrespondence",
			"ares.logic.item.cyufusuit",
			"ares.logic.item.cyufucaoconfig",
			"ares.logic.item.clingyiskillinfo",
			"ares.logic.item.cyuansuupperlimit",
			"ares.logic.item.cyufuitem",
			"ares.logic.item.cchenshuishouitem",
			"ares.logic.item.czhenyushouitem",
			"ares.logic.item.ccompositeresult",
			"ares.logic.item.ccultivateslot",
			"ares.logic.item.cmosaicslot",
			"ares.logic.item.cattrnum",
			"ares.logic.item.cagatesuitattr",
			"ares.logic.item.cshipinconfig",
			"ares.logic.item.cshipinfashionconfig",
			"ares.logic.item.cyinjisuitconfig",
			"ares.logic.item.cyinjibaserandom",
			"ares.logic.item.cyinjiincidentrandom",
			"ares.logic.item.cyinjiupgrade",
			"ares.logic.item.cyinjiarchive",
			"ares.logic.item.cmagicscreen",
			"ares.logic.item.caffixscreen",
			"ares.logic.item.challoween",
			"ares.logic.item.cequipsoulconfig",
			"ares.logic.item.cequipsoulupdate",
			"ares.logic.item.cequiplevelexp",
			"ares.logic.effect.ceffectconfig",
			"ares.logic.effect.csystemswitchcraft",
			"ares.logic.effect.cgodequipeffect",
			"ares.logic.npc.cmonsterconfig",
			"ares.logic.npc.cnpcshape",
			"ares.logic.npc.cnpcshapelua",
			"ares.logic.npc.cnpcconfig",
			"ares.logic.npc.cnpcchat",
			"ares.logic.npc.cnpcserverconfig",
			"ares.logic.npc.cnpcactionconfig",
			"ares.logic.npc.cxiakexinxi",
			"ares.logic.npc.cxiakebreakattrconfig",
			"ares.logic.npc.cxiakepassiveskillslot",
			"ares.logic.npc.cxiakebreakconfig",
			"ares.logic.npc.cxiakebreakdisplayconfig",
			"ares.logic.npc.cxiakeskill",
			"ares.logic.npc.cwantedcircularnameconfig",
			"ares.logic.npc.cwantedcircularserieseconfig",
			"ares.logic.npc.cwantedcirculargroupconfig",
			"ares.logic.npc.csinglepkactivitynpc",
			"ares.logic.npc.csinglepkactivityguide",
			"ares.logic.npc.csinglepkactivitygroup",
			"ares.logic.npc.csinglepkactivityscore",
			"ares.logic.npc.ccaijinpcconfig",
			"ares.logic.npc.cnpcfinding",
			"ares.logic.npc.cpartnerunlockconsume",
			"ares.logic.npc.partnertypeconfig",
			"ares.logic.npc.cpecialpartnerunlock",
			"ares.logic.npc.cnpcmonitor",
			"ares.logic.npc.cpartnerlvparameterconfig",
			"ares.logic.npc.cpartnertokenconfig",
			"ares.logic.npc.acconfig",
			"ares.logic.npc.clingfuslot",
			"ares.logic.npc.clingfuplan",
			"ares.logic.npc.clingfuattrmapping",
			"ares.logic.npc.clingfuresonance",
			"ares.logic.npc.cxiakebreakadditionconfig",
			"ares.logic.role.schoolinfo",
			"ares.logic.role.createroleconfig",
			"ares.logic.role.ccreateroleskill",
			"ares.logic.role.createrolemusic",
			"ares.logic.role.rolepostfix",
			"ares.logic.role.rolemusicconfig",
			"ares.logic.role.ccreateroleconfig",
			"ares.logic.role.cattrmoddata",
			"ares.logic.role.crunaudio",
			"ares.logic.role.cresmoneyconfig",
			"ares.logic.role.crolelevelskilllevel",
			"ares.logic.role.cservermaxlevelconfig",
			"ares.logic.role.cserverexpdecay",
			"ares.logic.role.cdamagetosp",
			"ares.logic.role.czuoqirolename",
			"ares.logic.role.czuoqi",
			"ares.logic.role.czuoqibianshen",
			"ares.logic.role.cprosperitydegree",
			"ares.logic.role.cdyehair",
			"ares.logic.role.cdyeclothes",
			"ares.logic.role.cdyegarnish",
			"ares.logic.role.cdyecost",
			"ares.logic.role.cdyecontrol",
			"ares.logic.role.croleactionconfig",
			"ares.logic.role.croleattrtips",
			"ares.logic.role.crideunlockconsume",
			"ares.logic.role.croleshapeconfig",
			"ares.logic.role.crolechooseacconfig",
			"ares.logic.role.czuoqitrain",
			"ares.logic.role.czuoqiattr",
			"ares.logic.role.czuoqiskill",
			"ares.logic.role.czuoqipresent",
			"ares.logic.pet.cpetcolumn",
			"ares.logic.pet.cpetattr",
			"ares.logic.pet.cpetnextexp",
			"ares.logic.pet.cpetsatietyexp",
			"ares.logic.pet.cpetfeed",
			"ares.logic.pet.cpetfeedskill",
			"ares.logic.pet.cpetjuexing",
			"ares.logic.pet.cpetchipsynthesis",
			"ares.logic.pet.cpetchapter",
			"ares.logic.pet.cpetillustrated",
			"ares.logic.pet.cpettaskunlock",
			"ares.logic.pet.cpetgradecfg",
			"ares.logic.pet.cpetstars",
			"ares.logic.pet.cpetaffix",
			"ares.logic.pet.cpetzizhicolor",
			"ares.logic.pet.cpetcallnum",
			"ares.logic.pet.cpetsubject",
			"ares.logic.pet.cpetsummondisplay",
			"ares.logic.pet.ccustomizedpet",
			"ares.logic.pet.cpetattrcalc",
			"ares.logic.pet.cpetsharechannel",
			"ares.logic.pet.crarepetexchange",
			"ares.logic.pet.cpetcontrolspeed",
			"ares.logic.pet.cpetshouhustarssuit",
			"ares.logic.pet.csoulitem",
			"ares.logic.pet.csoulcost",
			"ares.logic.pet.csoulattrishow",
			"ares.logic.pet.cpetyinglingconfig",
			"ares.logic.pet.cpeteleskill",
			"ares.logic.login.cloginerrorstr",
			"ares.logic.login.cexitgame",
			"ares.logic.login.cupdatewords",
			"ares.logic.battle.cbattlebackmusic",
			"ares.logic.battle.cformationbaseconfig",
			"ares.logic.battle.cbattleaiconfig",
			"ares.logic.battle.cbattleinfo",
			"ares.logic.battle.cbattleinfoboss",
			"ares.logic.battle.cbattleorderconfig",
			"ares.logic.battle.cbattleposconfig",
			"ares.logic.battle.cbattlefuclist",
			"ares.logic.battle.cbattlecameraconfig",
			"ares.logic.SystemSetting.cfunctionconfigsetting",
			"ares.logic.SystemSetting.cgaojishezhi",
			"ares.logic.SystemSetting.interfacesetting",
			"ares.logic.title.ctitleconfig",
			"ares.logic.title.cintimacyaddtitle",
			"ares.logic.game.cduihuanma",
			"ares.logic.game.cfengyaoconfig",
			"ares.logic.game.cactivityaward",
			"ares.logic.game.cvipconfig",
			"ares.logic.game.cdenglulibao",
			"ares.logic.game.cshouchonglibao",
			"ares.logic.game.cpaihangbang",
			"ares.logic.game.cpaihangbangaward",
			"ares.logic.game.cbattletypeconfig",
			"ares.logic.game.cenumer",
			"ares.logic.game.cloadingpic",
			"ares.logic.game.cuiback",
			"ares.logic.game.cbigtreasuremapactivityconfig",
			"ares.logic.game.cbigtreasuremapbigaward",
			"ares.logic.game.cbigtreasuremapnum",
			"ares.logic.game.cyabiaoevent",
			"ares.logic.game.cyabiaorandom",
			"ares.logic.game.cclimbtower",
			"ares.logic.game.cclimbtoweritem",
			"ares.logic.game.clvlimitconfig",
			"ares.logic.game.czhiyinconfig",
			"ares.logic.game.ctiaozhuanconfig",
			"ares.logic.game.czhiyintabconfig",
			"ares.logic.game.cxianjiananswer",
			"ares.logic.game.canswerextrapremium",
			"ares.logic.game.csign",
			"ares.logic.game.caccumulatedsign",
			"ares.logic.game.cwuxuanyiconfig",
			"ares.logic.game.clevepackage",
			"ares.logic.game.csevendaysreward",
			"ares.logic.game.crewardactivitysort",
			"ares.logic.game.csslunjian",
			"ares.logic.game.cjjcgradeconfig",
			"ares.logic.game.cjjcrankaward",
			"ares.logic.game.cjjcgradeaward",
			"ares.logic.game.cfeatureshow",
			"ares.logic.game.cfeatureunlock",
			"ares.logic.game.cguideindex",
			"ares.logic.game.cguidesteps",
			"ares.logic.game.cguideespecialskill",
			"ares.logic.game.cloadingtips",
			"ares.logic.game.cqualityconfig",
			"ares.logic.game.cpinjiandahuiaward",
			"ares.logic.game.cxianmengchapter",
			"ares.logic.game.cxianmengstage",
			"ares.logic.game.cachievementlabel",
			"ares.logic.game.cchievementgoal",
			"ares.logic.game.cworldquestion",
			"ares.logic.game.chotpointconfig",
			"ares.logic.game.cupdatereward",
			"ares.logic.game.cservercivilwaraward",
			"ares.logic.game.cservercivilwarprocess",
			"ares.logic.game.ccampreward",
			"ares.logic.game.ccamprewardstar",
			"ares.logic.game.carenaconfig",
			"ares.logic.game.carenarankawarddisplay",
			"ares.logic.game.cguajibattleconfig",
			"ares.logic.game.cunlocktrailer",
			"ares.logic.game.ccampbattlebuff",
			"ares.logic.game.cexperiencerain",
			"ares.logic.game.ctaoyuanbattlebuff",
			"ares.logic.game.ctaoyuanmonsterconfig",
			"ares.logic.game.cspaceconfig",
			"ares.logic.game.cspacephotoconfig",
			"ares.logic.game.cfeastingredients",
			"ares.logic.game.cfeastfood",
			"ares.logic.game.cfeastanswer",
			"ares.logic.game.cfeastnpcgrid",
			"ares.logic.game.cstrongfirstlevelconfig",
			"ares.logic.game.cstrongsecondlevelconfig",
			"ares.logic.game.cstrongscoreconfig",
			"ares.logic.game.clingshoutravelcharacter",
			"ares.logic.game.clingshoutravelcalendar",
			"ares.logic.game.clingshoutravelincidentlibrary",
			"ares.logic.game.clingshoutravelsetoutlibrary",
			"ares.logic.game.clingshoutraveltreasureboxprice",
			"ares.logic.game.clingshoutravelwaypointconfig",
			"ares.logic.game.clingshoutravelmodelconfig",
			"ares.logic.game.cwineconfig",
			"ares.logic.game.catlas",
			"ares.logic.game.catlascollectreward",
			"ares.logic.game.catlasattributereward",
			"ares.logic.game.catlasupgrade",
			"ares.logic.game.defeatguidance",
			"ares.logic.game.cspecialattributes",
			"ares.logic.game.cseparatepackage",
			"ares.logic.game.cbpdiaoxiang",
			"ares.logic.game.crandomdialbattle",
			"ares.logic.game.ctongtianta",
			"ares.logic.game.cservercivilwaraward",
			"ares.logic.game.cservercivilwarprocess",
			"ares.logic.game.cfengshenwaraward",
			"ares.logic.game.cfengshenwarprocess",
			"ares.logic.game.cservercivilwarstatue",
			"ares.logic.game.cfengshenwarstatue",
			"ares.logic.game.cshenbingexchange",
			"ares.logic.game.crepconfig",
			"ares.logic.game.creincarnation",
			"ares.logic.game.cjulingzhuconfig",
			"ares.logic.game.ctianjireelconfig",
			"ares.logic.game.ctianjireelupgradeconfig",
			"ares.logic.game.cupdatereward",
			"ares.logic.game.cchannellinkconfig",
			"ares.logic.game.cwinterintegralaward",
			"ares.logic.game.cavatarframe",
			"ares.logic.game.clingmaiupgrade",
			"ares.logic.game.clingmaiitem",
			"ares.logic.game.clingmairesonance",
			"ares.logic.game.cchatbubble",
			"ares.logic.game.crewardorder",
			"ares.logic.buff.cibuffconfig",
			"ares.logic.buff.cbuffconfig",
			"ares.logic.message.cmessagetip",
			"ares.logic.message.cstringres",
			"ares.logic.message.cpostbox",
			"ares.logic.message.cconfirm",
			"ares.logic.message.ccommontips",
			"ares.logic.message.cactivepush",
			"ares.logic.message.cconvenientmessage",
			"ares.logic.skill.cskillcost",
			"ares.logic.skill.cschoolskillitem",
			"ares.logic.skill.cskillcloseup",
			"ares.logic.skill.cpetskillupgrade",
			"ares.logic.skill.cskillitem",
			"ares.logic.skill.cschoolskill",
			"ares.logic.skill.cpetskillconfig",
			"ares.logic.skill.chuobanpassiveskillconfig",
			"ares.logic.skill.cskilltypeconfig",
			"ares.logic.skill.cskillconfig",
			"ares.logic.skill.cskillperform",
			"ares.logic.skill.celementskillperform",
			"ares.logic.skill.cskilllevellimit",
			"ares.logic.skill.cpetautoskill",
			"ares.logic.skill.cspecialbuffbanner",
			"ares.logic.skill.cpetqianban",
			"ares.logic.skill.cpetqianbansource",
			"ares.logic.skill.chuanhuarandom",
			"ares.logic.skill.cpetqianbandirection",
			"ares.logic.skill.chuobanpassiveskillupgrade",
			"ares.logic.task.cacceptabletask_new",
			"ares.logic.task.croleanipeiyin",
			"ares.logic.task.ctasklist",
			"ares.logic.task.cactivegiftbox",
			"ares.logic.task.ctasktrackingorder",
			"ares.logic.task.ctiku",
			"ares.logic.task.cuseitemprocessbar",
			"ares.logic.task.activitycalendar",
			"ares.logic.task.cplotanimationui",
			"ares.logic.task.canimationdanmu",
			"ares.logic.task.canimation",
			"ares.logic.task.cquestiontask",
			"ares.logic.task.cbangpaitask",
			"ares.logic.task.cdialogue",
			"ares.logic.task.cchapteranimation",
			"ares.logic.task.cmoodaction",
			"ares.logic.team.czhenfaeffect",
			"ares.logic.team.czhenfacost",
			"ares.logic.team.cteammatchconfig",
			"ares.logic.team.cstarnature",
			"ares.logic.timer.cscheculedactivity",
			"ares.logic.specialquest.cpjdhschoolconfig",
			"ares.logic.specialquest.cescortpoint",
			"ares.logic.specialquest.cqietingshapedir",
			"ares.logic.specialquest.cqietingnpc",
			"ares.logic.specialquest.crankquesions",
			"ares.logic.specialquest.cpicquesions",
			"ares.logic.specialquest.cbattletarget",
			"ares.logic.specialquest.cheadportrait",
			"ares.logic.specialquest.cexperience",
			"ares.logic.specialquest.ctasktypedescribe",
			"ares.logic.specialquest.cmissionnpcconfig",
			"ares.logic.specialquest.cassistance",
			"ares.logic.specialquest.cjigsawlib",
			"ares.logic.specialquest.ctaskchainmap",
			"ares.logic.chat.cchatconfig",
			"ares.logic.chat.clinkconfig",
			"ares.logic.chat.cemojiconfig",
			"ares.logic.chat.cchatfontcolor",
			"ares.logic.chat.cactchat",
			"ares.logic.chat.cchatemojiarea",
			"ares.logic.friend.cfrienddegrees",
			"ares.logic.friend.ceventconfig",
			"ares.logic.friend.cflowerconfig",
			"ares.logic.friend.cengagedconf",
			"ares.logic.friend.cfrienddegreeslevel",
			"ares.logic.friend.cfriendgiftsitem",
			"ares.logic.task.cmainmissioninfo",
			"ares.logic.faction.cfactionofficeconfig",
			"ares.logic.faction.cfactionlevel",
			"ares.logic.faction.ccampconfig",
			"ares.logic.faction.cfactionskill",
			"ares.logic.faction.cfactionpurchase",
			"ares.logic.faction.cfactionactivityview",
			"ares.logic.faction.cfactionwelfareview",
			"ares.logic.faction.ccampofficeconfig",
			"ares.logic.faction.ccampleaveconfig",
			"ares.logic.faction.cfactionjoinshow",
			"ares.logic.faction.cfactionicon",
			"ares.logic.faction.cghostsealmap",
			"ares.logic.faction.cactiongive",
			"ares.logic.faction.cfactionleadernpc",
			"ares.logic.faction.cfactionshipconfig",
			"ares.logic.faction.cfactionstealtaskconfig",
			"ares.logic.faction.cfactionpetcharacter",
			"ares.logic.faction.cfactionpetevolution",
			"ares.logic.faction.cfactionpetevolution",
			"ares.logic.faction.cfactionpetvolume",
			"ares.logic.faction.cfactionpetfeedchat",
			"ares.logic.faction.cfactionstatue",
			"ares.logic.faction.cfactionangelconfig",
			"ares.logic.faction.cfactionangelcaiji",
			"ares.logic.faction.cterritorykill",
			"ares.logic.faction.cterritoryconfig",
			"ares.logic.faction.collectspeed",
			"ares.logic.faction.buffshow",
			"ares.logic.faction.cterritorylabel",
			"ares.logic.faction.cterritoryshop",
			"ares.logic.faction.cfactionprestigerank",
			"ares.logic.EffectPath.ceffectpathnonedrama",
			"ares.logic.EffectPath.cresourcepath",
			"ares.logic.EffectPath.ceffecttimelimit",
			"ares.logic.yuanbao.caddcash",
			"ares.logic.yuanbao.caddyuanbao",
			"ares.logic.yuanbao.cuseyuanbao",
			"ares.logic.yuanbao.ccost",
			"ares.logic.yuanbao.cgiftdai",
			"ares.logic.yuanbao.ckaifuactivity",
			"ares.logic.yuanbao.ckaifuplan",
			"ares.logic.yuanbao.cfirstcharge",
			"ares.logic.yuanbao.cpreserveaward",
			"ares.logic.yuanbao.ckaifufaction",
			"ares.logic.yuanbao.cinvitescoreaward",
			"ares.logic.yuanbao.cinvitegoalconfig",
			"ares.logic.yuanbao.credpacket",
			"ares.logic.yuanbao.cquestionnaire",
			"ares.logic.yuanbao.cquestionnaireopen",
			"ares.logic.yuanbao.cgrowthfund",
			"ares.logic.yuanbao.credpacketitem",
			"ares.logic.yuanbao.cbingoactivity",
			"ares.logic.yuanbao.cbingoaward",
			"ares.logic.yuanbao.ctotalchargeaward",
			"ares.logic.yuanbao.cprivilegecard",
			"ares.logic.yuanbao.caristocratpackage",
			"ares.logic.yuanbao.crankaward",
			"ares.logic.yuanbao.caimaward",
			"ares.logic.yuanbao.czhulilibaoopen",
			"ares.logic.yuanbao.czhulilibaoaward",
			"ares.logic.yuanbao.cfortunecatconfig",
			"ares.logic.yuanbao.csinglechargereward",
			"ares.logic.yuanbao.cdailyrecharge",
			"ares.logic.yuanbao.caccumulativerecharge",
			"ares.logic.yuanbao.chunyuspecaward",
			"ares.logic.yuanbao.cbingoactivity",
			"ares.logic.yuanbao.cbingoaward",
			"ares.logic.fuben.cfubenjindu",
			"ares.logic.fuben.cfubenconfig",
			"ares.logic.fuben.cdailyfuben",
			"ares.logic.zhiye.cvocationalskill",
			"ares.logic.zhiye.cchangeaddpoint",
			"ares.logic.zhiye.caddpointplan",
	};

	@SuppressWarnings("unchecked")
	public static boolean doCheck(java.util.Map objs){
		boolean ret=true;
		for(Object obj:objs.values()){
			if(!(obj instanceof java.util.Map<?,?>)) continue;
			java.util.Map<Integer,? extends Object> m =(java.util.Map<Integer,? extends Object>)obj;
			for(java.util.Map.Entry<Integer,? extends Object> o:m.entrySet())
			if(o.getValue() instanceof ConvMain.Checkable){
				try{
					((ConvMain.Checkable)o.getValue()).checkValid((java.util.Map<String,java.util.Map<Integer,? extends Object>>)objs);
				}catch(Exception ex){
					logger.error("key="+o.getKey()+"鐨勮褰曟牎楠屽け璐�,鍘熷洜鏄�"+ex.getMessage());
					ret=false;
				}
			} 
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")	
	public static java.util.Map<String,java.util.Map<Integer,? extends Object> > doConv(String inputdir,String outputdir,String outputdir2){
		java.util.Map<String,java.util.Map<Integer,? extends Object> > objs= new java.util.TreeMap<String,java.util.Map<Integer,? extends Object> >();
		com.thoughtworks.xstream.XStream xstream=new com.thoughtworks.xstream.XStream();
//		try{
//			objs.put("ares.logic.main.ModuleInfo",ares.logic.main.ModuleInfo.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.main.HotfixConfig",ares.logic.main.HotfixConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.main.HotfixXml2ModuleConfig",ares.logic.main.HotfixXml2ModuleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.main.LoginLimit",ares.logic.main.LoginLimit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.main.JumpQueueUser",ares.logic.main.JumpQueueUser.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.map.MapConfig",ares.logic.map.MapConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.map.SActivityAwardItems",ares.logic.map.SActivityAwardItems.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ItemAttr",ares.logic.item.ItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.PetAffixAttr",ares.logic.item.PetAffixAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.gemItemAttr",ares.logic.item.gemItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.HuobanPassiveSkillbookAttr",ares.logic.item.HuobanPassiveSkillbookAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjiAttr",ares.logic.item.SYinjiAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjisuittype",ares.logic.item.SYinjisuittype.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SDiamondProp",ares.logic.item.SDiamondProp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.BagConfig",ares.logic.item.BagConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ItemAttrClassToLoad",ares.logic.item.ItemAttrClassToLoad.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ItemClassToLoad",ares.logic.item.ItemClassToLoad.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SPetShouhuStar",ares.logic.item.SPetShouhuStar.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.PetChipAttr",ares.logic.item.PetChipAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.PartnerTokenAttr",ares.logic.item.PartnerTokenAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.FoodItemAttr",ares.logic.item.FoodItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.STreasureMapItemAttr",ares.logic.item.STreasureMapItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.EquipItemAttr",ares.logic.item.EquipItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SEquipStrengthen",ares.logic.item.SEquipStrengthen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.PetItemAttr",ares.logic.item.PetItemAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SPresentConfig",ares.logic.item.SPresentConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemduihuan",ares.logic.item.SItemduihuan.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SEquipCombin",ares.logic.item.SEquipCombin.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemStore",ares.logic.item.SItemStore.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SStorePriceUnit",ares.logic.item.SStorePriceUnit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemShop",ares.logic.item.SItemShop.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemShop__3",ares.logic.item.SItemShop__3.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SJifenShop",ares.logic.item.SJifenShop.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SFactionShop",ares.logic.item.SFactionShop.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemBuff",ares.logic.item.SItemBuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SBagPrice",ares.logic.item.SBagPrice.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SBaoshitaozhuang",ares.logic.item.SBaoshitaozhuang.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Sgemlv",ares.logic.item.Sgemlv.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Smoneycost",ares.logic.item.Smoneycost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SequipScoreConfig",ares.logic.item.SequipScoreConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SWandering",ares.logic.item.SWandering.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemRideConfig",ares.logic.item.SItemRideConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SQuickSynthesis",ares.logic.item.SQuickSynthesis.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAnonyCard",ares.logic.item.SAnonyCard.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAnonyCardGift",ares.logic.item.SAnonyCardGift.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SSellType",ares.logic.item.SSellType.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SSalepower",ares.logic.item.SSalepower.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SPetItemReturnOff",ares.logic.item.SPetItemReturnOff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SSaleType",ares.logic.item.SSaleType.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipSkillRandom",ares.logic.item.SgodEquipSkillRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipAdditionAttribute",ares.logic.item.SgodEquipAdditionAttribute.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipAdditionAttributeRandom",ares.logic.item.SgodEquipAdditionAttributeRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipAdditionAttributeBelong",ares.logic.item.SgodEquipAdditionAttributeBelong.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipBaseAttributeRandom",ares.logic.item.SgodEquipBaseAttributeRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SGodEquipSplit",ares.logic.item.SGodEquipSplit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipIdentified",ares.logic.item.SgodEquipIdentified.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SRareGodEquipConfig",ares.logic.item.SRareGodEquipConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SfashionConfig",ares.logic.item.SfashionConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SStarinfoAttr",ares.logic.item.SStarinfoAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SGodEquipUpgradeConfig",ares.logic.item.SGodEquipUpgradeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemAddPet",ares.logic.item.SItemAddPet.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SGodequipUpdateConfig",ares.logic.item.SGodequipUpdateConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SGodequipCreateConfig",ares.logic.item.SGodequipCreateConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemAddDialNumConfig",ares.logic.item.SItemAddDialNumConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Sqinmidu",ares.logic.item.Sqinmidu.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SlingfuInfo",ares.logic.item.SlingfuInfo.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Skite",ares.logic.item.Skite.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SFashionAttributeConfig",ares.logic.item.SFashionAttributeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ShuanhuaConfig",ares.logic.item.ShuanhuaConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ShuanhuaReturn",ares.logic.item.ShuanhuaReturn.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SgodEquipChange",ares.logic.item.SgodEquipChange.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SCustomeEquip",ares.logic.item.SCustomeEquip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemGetGodEquip",ares.logic.item.SItemGetGodEquip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemProvideGodExp",ares.logic.item.SItemProvideGodExp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Sschoolequip",ares.logic.item.Sschoolequip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Sgenderequip",ares.logic.item.Sgenderequip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Sgemid",ares.logic.item.Sgemid.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemaddAtlExp",ares.logic.item.SItemaddAtlExp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Syufusuit",ares.logic.item.Syufusuit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Syufucaoconfig",ares.logic.item.Syufucaoconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Slingyiskillunlock",ares.logic.item.Slingyiskillunlock.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Slingyiskillinfo",ares.logic.item.Slingyiskillinfo.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Syuansuupperlimit",ares.logic.item.Syuansuupperlimit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Slingyiskillmapping",ares.logic.item.Slingyiskillmapping.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.Spluralityelementskillunlock",ares.logic.item.Spluralityelementskillunlock.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SyufuItem",ares.logic.item.SyufuItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SChenShuiShouItem",ares.logic.item.SChenShuiShouItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SZhenYuShouItem",ares.logic.item.SZhenYuShouItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SCompositeResult",ares.logic.item.SCompositeResult.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SCultivateResult",ares.logic.item.SCultivateResult.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAttrlibrary",ares.logic.item.SAttrlibrary.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.ScultivateSlot",ares.logic.item.ScultivateSlot.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SMosaicSlot",ares.logic.item.SMosaicSlot.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAttrnum",ares.logic.item.SAttrnum.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SExtraitemlist",ares.logic.item.SExtraitemlist.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SCompositeExtralist",ares.logic.item.SCompositeExtralist.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAgateSuitAttr",ares.logic.item.SAgateSuitAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAgateSkill",ares.logic.item.SAgateSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SShiPinConfig",ares.logic.item.SShiPinConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SShipinfashionitemConfig",ares.logic.item.SShipinfashionitemConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SItemRecharge",ares.logic.item.SItemRecharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjiSuitConfig",ares.logic.item.SYinjiSuitConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjibaseRandom",ares.logic.item.SYinjibaseRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjiincidentRandom",ares.logic.item.SYinjiincidentRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SYinjiUpgrade",ares.logic.item.SYinjiUpgrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SMagicScreen",ares.logic.item.SMagicScreen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SAffixScreen",ares.logic.item.SAffixScreen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SHalloween",ares.logic.item.SHalloween.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SEquipSoulConfig",ares.logic.item.SEquipSoulConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SEquipSoulUpdate",ares.logic.item.SEquipSoulUpdate.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SEquiplevelexp",ares.logic.item.SEquiplevelexp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.item.SSoulLibrary",ares.logic.item.SSoulLibrary.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.effect.SAttrEffectID2Name",ares.logic.effect.SAttrEffectID2Name.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.effect.SLevelStandardAttr",ares.logic.effect.SLevelStandardAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SMonsterConfig",ares.logic.npc.SMonsterConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcShape",ares.logic.npc.SNpcShape.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcServiceConfig",ares.logic.npc.SNpcServiceConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SServiceConds",ares.logic.npc.SServiceConds.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SAllConds",ares.logic.npc.SAllConds.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcShare",ares.logic.npc.SNpcShare.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcShare__3",ares.logic.npc.SNpcShare__3.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeMonsterconfig",ares.logic.npc.SXiakeMonsterconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeBreakAttrConfig",ares.logic.npc.SXiakeBreakAttrConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakePassiveSkillSlot",ares.logic.npc.SXiakePassiveSkillSlot.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeBreakConfig",ares.logic.npc.SXiakeBreakConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeskill",ares.logic.npc.SXiakeskill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SMonsterAttackNpc",ares.logic.npc.SMonsterAttackNpc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SMonsterAttackConfig",ares.logic.npc.SMonsterAttackConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SMonsterAttackRefresh",ares.logic.npc.SMonsterAttackRefresh.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SLevelRange",ares.logic.npc.SLevelRange.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.WantedCircularNameConfig",ares.logic.npc.WantedCircularNameConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.WantedCircularNameConfig__4",ares.logic.npc.WantedCircularNameConfig__4.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SWantedCircularSerieseConfig",ares.logic.npc.SWantedCircularSerieseConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SWantedCircularGroupConfig",ares.logic.npc.SWantedCircularGroupConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.WantedCircularTimeConfig",ares.logic.npc.WantedCircularTimeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivitynpc",ares.logic.npc.SSinglepkactivitynpc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivitybuff",ares.logic.npc.SSinglepkactivitybuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivityguide",ares.logic.npc.SSinglepkactivityguide.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivityguidenpc",ares.logic.npc.SSinglepkactivityguidenpc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivitygroup",ares.logic.npc.SSinglepkactivitygroup.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSinglepkactivityscore",ares.logic.npc.SSinglepkactivityscore.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SActivityNpcPos",ares.logic.npc.SActivityNpcPos.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SGatherConfig",ares.logic.npc.SGatherConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SHireNpc",ares.logic.npc.SHireNpc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeAI",ares.logic.npc.SXiakeAI.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SPickupnum",ares.logic.npc.SPickupnum.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSceneItem",ares.logic.npc.SSceneItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SRandomNpcConfig",ares.logic.npc.SRandomNpcConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.PartnerUnlockConsume",ares.logic.npc.PartnerUnlockConsume.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.FreePartnerConfig",ares.logic.npc.FreePartnerConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.PartnerCallItem",ares.logic.npc.PartnerCallItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.PartnerTaskConstraints",ares.logic.npc.PartnerTaskConstraints.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SpecialPartnerUnlock",ares.logic.npc.SpecialPartnerUnlock.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcMonitor",ares.logic.npc.SNpcMonitor.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SNpcDynamicservice",ares.logic.npc.SNpcDynamicservice.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SPartnerLvParameterConfig",ares.logic.npc.SPartnerLvParameterConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SGetPartnerWeightConfig",ares.logic.npc.SGetPartnerWeightConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SGetPartnerConfig",ares.logic.npc.SGetPartnerConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SSpecialGetPartnerConfig",ares.logic.npc.SSpecialGetPartnerConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.DemonItem",ares.logic.npc.DemonItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SlingfuSlot",ares.logic.npc.SlingfuSlot.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SlingfuPlan",ares.logic.npc.SlingfuPlan.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SlingfuAttrMapping",ares.logic.npc.SlingfuAttrMapping.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SLingfuResonance",ares.logic.npc.SLingfuResonance.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SXiakeBreakAdditionConfig",ares.logic.npc.SXiakeBreakAdditionConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.npc.SnpcAward",ares.logic.npc.SnpcAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.RoleConfig",ares.logic.role.RoleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.Redirect",ares.logic.role.Redirect.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SCreateRoleFirstBattle",ares.logic.role.SCreateRoleFirstBattle.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SCreateRoleConfig",ares.logic.role.SCreateRoleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SAttrModData",ares.logic.role.SAttrModData.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.NextExpAndResMoney",ares.logic.role.NextExpAndResMoney.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.RoleLevelSkillLevel",ares.logic.role.RoleLevelSkillLevel.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SSpeedname",ares.logic.role.SSpeedname.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SServerMaxLevelConfig",ares.logic.role.SServerMaxLevelConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SServerLogicOpenTime",ares.logic.role.SServerLogicOpenTime.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SServerLevelConfig",ares.logic.role.SServerLevelConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SServerExpDecay",ares.logic.role.SServerExpDecay.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SDamageToSp",ares.logic.role.SDamageToSp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SZuoQi",ares.logic.role.SZuoQi.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SZuoQiBianShen",ares.logic.role.SZuoQiBianShen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SProsperityDegree",ares.logic.role.SProsperityDegree.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SProsperityDegreeConfig",ares.logic.role.SProsperityDegreeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SdyeCost",ares.logic.role.SdyeCost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SRideUnlockConsume",ares.logic.role.SRideUnlockConsume.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SZuoqiTrain",ares.logic.role.SZuoqiTrain.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SZuoqiAttr",ares.logic.role.SZuoqiAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SZuoqiSkill",ares.logic.role.SZuoqiSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.SzuoqiUpdate",ares.logic.role.SzuoqiUpdate.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.role.Szuoqipresent",ares.logic.role.Szuoqipresent.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetColumn",ares.logic.pet.SPetColumn.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.PetAttr",ares.logic.pet.PetAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.PetNextExp",ares.logic.pet.PetNextExp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetSatietyExp",ares.logic.pet.SPetSatietyExp.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetFeed",ares.logic.pet.SPetFeed.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetFeedSkill",ares.logic.pet.SPetFeedSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetJueXing",ares.logic.pet.SPetJueXing.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetchipSynthesis",ares.logic.pet.SPetchipSynthesis.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetchapter",ares.logic.pet.SPetchapter.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetillustrated",ares.logic.pet.SPetillustrated.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetScoreConfig",ares.logic.pet.SPetScoreConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetstars",ares.logic.pet.SPetstars.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetcallnum",ares.logic.pet.SPetcallnum.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetZizhiSection",ares.logic.pet.SPetZizhiSection.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetSummonAwardConfig",ares.logic.pet.SPetSummonAwardConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetSkillStudyConfig",ares.logic.pet.SPetSkillStudyConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetSkillFristStudy",ares.logic.pet.SPetSkillFristStudy.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SCustomizedPet",ares.logic.pet.SCustomizedPet.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetAttrCalc",ares.logic.pet.SPetAttrCalc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SRarePetExchange",ares.logic.pet.SRarePetExchange.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetControlSpeed",ares.logic.pet.SPetControlSpeed.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetShouhuStarAttr",ares.logic.pet.SPetShouhuStarAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetShouhuStarAttrRandom",ares.logic.pet.SPetShouhuStarAttrRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetShouhuStarstoAttr",ares.logic.pet.SPetShouhuStarstoAttr.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPetShouhuStarsSuit",ares.logic.pet.SPetShouhuStarsSuit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SSoulItem",ares.logic.pet.SSoulItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.Selesoullv",ares.logic.pet.Selesoullv.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SSoulCost",ares.logic.pet.SSoulCost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SSoulAttri",ares.logic.pet.SSoulAttri.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.pet.SPETYingLingConfig",ares.logic.pet.SPETYingLingConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.login.SCompensationConfig",ares.logic.login.SCompensationConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.login.SCompensationCondition",ares.logic.login.SCompensationCondition.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.login.SAdfiltering",ares.logic.login.SAdfiltering.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SFormationConfig",ares.logic.battle.SFormationConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SAIAction",ares.logic.battle.SAIAction.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.STargetFilter",ares.logic.battle.STargetFilter.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SCondition",ares.logic.battle.SCondition.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SBattleAI",ares.logic.battle.SBattleAI.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SBattleInfo",ares.logic.battle.SBattleInfo.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SBattleInfoBoss",ares.logic.battle.SBattleInfoBoss.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.battle.SMonsterTypeConfig",ares.logic.battle.SMonsterTypeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.SystemSetting.SFunctionConfigSetting",ares.logic.SystemSetting.SFunctionConfigSetting.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.SystemSetting.SHotdeployClass",ares.logic.SystemSetting.SHotdeployClass.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.SystemSetting.SGMsystem",ares.logic.SystemSetting.SGMsystem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.title.STitleConfig",ares.logic.title.STitleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.title.SItemTitleConfig",ares.logic.title.SItemTitleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.title.SIntimacyAddTitle",ares.logic.title.SIntimacyAddTitle.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.firstaward",ares.logic.game.firstaward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sduihuanma",ares.logic.game.Sduihuanma.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sduihuanmagroup",ares.logic.game.Sduihuanmagroup.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sgonghuima",ares.logic.game.Sgonghuima.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SGobalExchangeServicesConfig",ares.logic.game.SGobalExchangeServicesConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFengYaoConfig",ares.logic.game.SFengYaoConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFortuneWheel",ares.logic.game.SFortuneWheel.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SActivityAward",ares.logic.game.SActivityAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.ExternalAward",ares.logic.game.ExternalAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SVIPconfig",ares.logic.game.SVIPconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sdenglulibao",ares.logic.game.Sdenglulibao.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Spaihangbang",ares.logic.game.Spaihangbang.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sbangpaishilibang",ares.logic.game.Sbangpaishilibang.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Spaihangbangaward",ares.logic.game.Spaihangbangaward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SEnumer",ares.logic.game.SEnumer.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBattleTypeConfig",ares.logic.game.SBattleTypeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SNormalTreasureMapRegionConfig",ares.logic.game.SNormalTreasureMapRegionConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SNormalTreasureMapActivityConfig",ares.logic.game.SNormalTreasureMapActivityConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBigTreasureMapActivityConfig",ares.logic.game.SBigTreasureMapActivityConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBigTreasureMapAwardPreview",ares.logic.game.SBigTreasureMapAwardPreview.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBigTreasureMapFangYaoWangConfig",ares.logic.game.SBigTreasureMapFangYaoWangConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBigTreasureMapBigAward",ares.logic.game.SBigTreasureMapBigAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SYaBiaoEvent",ares.logic.game.SYaBiaoEvent.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SYaBiaoRandom",ares.logic.game.SYaBiaoRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sclimbtower",ares.logic.game.Sclimbtower.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sclimbtoweritem",ares.logic.game.Sclimbtoweritem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sclimbtowerkillmonsters",ares.logic.game.Sclimbtowerkillmonsters.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLvLimitConfig",ares.logic.game.SLvLimitConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SXianjianAnswer",ares.logic.game.SXianjianAnswer.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAnswerReward",ares.logic.game.SAnswerReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAnswerExtraPremium",ares.logic.game.SAnswerExtraPremium.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SSign",ares.logic.game.SSign.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SSign",ares.logic.game.SSign.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAccumulatedSign",ares.logic.game.SAccumulatedSign.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWuXuanYiconfig",ares.logic.game.SWuXuanYiconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLevePackage",ares.logic.game.SLevePackage.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SSevendaysreward",ares.logic.game.SSevendaysreward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SJJCGradeConfig",ares.logic.game.SJJCGradeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SShushanPk",ares.logic.game.SShushanPk.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SShushanMatch",ares.logic.game.SShushanMatch.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SShuShanAward",ares.logic.game.SShuShanAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SShuShanMailConfig",ares.logic.game.SShuShanMailConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SJJCBotConfig",ares.logic.game.SJJCBotConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SJJCRankAward",ares.logic.game.SJJCRankAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SJJCGradeAward",ares.logic.game.SJJCGradeAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SGuideEspecialSkill",ares.logic.game.SGuideEspecialSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SpinjiandahuiAward",ares.logic.game.SpinjiandahuiAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SXianMengChapter",ares.logic.game.SXianMengChapter.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SXianMengStage",ares.logic.game.SXianMengStage.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLevelStopConfig",ares.logic.game.SLevelStopConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SchievementGoal",ares.logic.game.SchievementGoal.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWorldQuestion",ares.logic.game.SWorldQuestion.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWatchBattle",ares.logic.game.SWatchBattle.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SIDSealedConfig",ares.logic.game.SIDSealedConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SpinjianFinalAward",ares.logic.game.SpinjianFinalAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SUpdateReward",ares.logic.game.SUpdateReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SRollActivityAward",ares.logic.game.SRollActivityAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SinvitationAward",ares.logic.game.SinvitationAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWar",ares.logic.game.SServerCivilWar.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWarSchedule",ares.logic.game.SServerCivilWarSchedule.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWarAward",ares.logic.game.SServerCivilWarAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SCampReward",ares.logic.game.SCampReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SCampRewardStar",ares.logic.game.SCampRewardStar.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SArenaConfig",ares.logic.game.SArenaConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SArenaRobotConfig",ares.logic.game.SArenaRobotConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SArenaRankAwardConfig",ares.logic.game.SArenaRankAwardConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SArenaRobotNameRandom",ares.logic.game.SArenaRobotNameRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SGuajibattleConfig",ares.logic.game.SGuajibattleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SUnlockTrailer",ares.logic.game.SUnlockTrailer.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Scampbattlebuff",ares.logic.game.Scampbattlebuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SExperienceRain",ares.logic.game.SExperienceRain.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.STaoyuanBattleBuff",ares.logic.game.STaoyuanBattleBuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.STaoyuanMonsterConfig",ares.logic.game.STaoyuanMonsterConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFeastIngredients",ares.logic.game.SFeastIngredients.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFeastFood",ares.logic.game.SFeastFood.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFeastAnswer",ares.logic.game.SFeastAnswer.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFeastchest",ares.logic.game.SFeastchest.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFeastnpcgrid",ares.logic.game.SFeastnpcgrid.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelProbability",ares.logic.game.SLingshouTravelProbability.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelCharacter",ares.logic.game.SLingshouTravelCharacter.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelCalendar",ares.logic.game.SLingshouTravelCalendar.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelIncidentLibrary",ares.logic.game.SLingshouTravelIncidentLibrary.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelSetoutProbability",ares.logic.game.SLingshouTravelSetoutProbability.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelSetoutLibrary",ares.logic.game.SLingshouTravelSetoutLibrary.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingshouTravelTreasureboxPrice",ares.logic.game.SLingshouTravelTreasureboxPrice.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWineConfig",ares.logic.game.SWineConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.CSplitPackageConfig",ares.logic.game.CSplitPackageConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAtlascollectreward",ares.logic.game.SAtlascollectreward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAtlasattributereward",ares.logic.game.SAtlasattributereward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAtlasUpgrade",ares.logic.game.SAtlasUpgrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SSpecialattributes",ares.logic.game.SSpecialattributes.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SSeparatePackage",ares.logic.game.SSeparatePackage.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SRandomDialBattle",ares.logic.game.SRandomDialBattle.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBangpaiQiangdaoNumConfig",ares.logic.game.SBangpaiQiangdaoNumConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SBangpaiQiangdaoMonsterConfig",ares.logic.game.SBangpaiQiangdaoMonsterConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.STongTianTa",ares.logic.game.STongTianTa.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWar",ares.logic.game.SServerCivilWar.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWarSchedule",ares.logic.game.SServerCivilWarSchedule.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SServerCivilWarAward",ares.logic.game.SServerCivilWarAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFengshenBattleConfig",ares.logic.game.SFengshenBattleConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SFengshenBattleGuess",ares.logic.game.SFengshenBattleGuess.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SShenbingExchange",ares.logic.game.SShenbingExchange.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SRepConfig",ares.logic.game.SRepConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SReincarnationAward",ares.logic.game.SReincarnationAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SJulingzhuConfig",ares.logic.game.SJulingzhuConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.STianjiReelConfig",ares.logic.game.STianjiReelConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.STianjiReelUpgradeConfig",ares.logic.game.STianjiReelUpgradeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWuxingxiulianConfig",ares.logic.game.SWuxingxiulianConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SwuxingxiulianReward",ares.logic.game.SwuxingxiulianReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SUpdateReward",ares.logic.game.SUpdateReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWinterActivity",ares.logic.game.SWinterActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWinterIntegralAward",ares.logic.game.SWinterIntegralAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWinterTask",ares.logic.game.SWinterTask.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SWinterSeeking",ares.logic.game.SWinterSeeking.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAvatarFrame",ares.logic.game.SAvatarFrame.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SAvatarFrameItem",ares.logic.game.SAvatarFrameItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingMaiUpgrade",ares.logic.game.SLingMaiUpgrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingMaiItem",ares.logic.game.SLingMaiItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SLingMaiResonance",ares.logic.game.SLingMaiResonance.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SChatBubble",ares.logic.game.SChatBubble.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SChatBubbleItem",ares.logic.game.SChatBubbleItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sxmasactivity",ares.logic.game.Sxmasactivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.Sxmaswishingitem",ares.logic.game.Sxmaswishingitem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.game.SRewardOrder",ares.logic.game.SRewardOrder.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SCBuffConfig",ares.logic.buff.SCBuffConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SIBuffConfig",ares.logic.buff.SIBuffConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SBuffConflicts",ares.logic.buff.SBuffConflicts.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SNuhuoBuff",ares.logic.buff.SNuhuoBuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SBufftip",ares.logic.buff.SBufftip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SBufftip",ares.logic.buff.SBufftip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.buff.SSpecilImmunologyBuff",ares.logic.buff.SSpecilImmunologyBuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.message.SMessageTip",ares.logic.message.SMessageTip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.message.SPostbox",ares.logic.message.SPostbox.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SSkillCost",ares.logic.skill.SSkillCost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SLingconfig",ares.logic.skill.SLingconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SZheJianzhaohuan",ares.logic.skill.SZheJianzhaohuan.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SKillBuff",ares.logic.skill.SKillBuff.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SSkillBuffmachRelate",ares.logic.skill.SSkillBuffmachRelate.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SPetSkillupgrade",ares.logic.skill.SPetSkillupgrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SActionTime",ares.logic.skill.SActionTime.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SPetSkillitem",ares.logic.skill.SPetSkillitem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SSkillConfig",ares.logic.skill.SSkillConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SScattered",ares.logic.skill.SScattered.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SSkillLevelLimit",ares.logic.skill.SSkillLevelLimit.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SSpecialBuffConfig",ares.logic.skill.SSpecialBuffConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SPetHunyinProbability",ares.logic.skill.SPetHunyinProbability.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SHuanhuaRandom",ares.logic.skill.SHuanhuaRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.skill.SHuobanPassiveSkillupgrade",ares.logic.skill.SHuobanPassiveSkillupgrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SAllTaskLine",ares.logic.task.SAllTaskLine.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SQuestCanAcceptList",ares.logic.task.SQuestCanAcceptList.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SActiveCalenderConfig",ares.logic.task.SActiveCalenderConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SActiveChestConfig",ares.logic.task.SActiveChestConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.Squestions",ares.logic.task.Squestions.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SAnimation",ares.logic.task.SAnimation.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SFirstanimationcontrol",ares.logic.task.SFirstanimationcontrol.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SQuestionTask",ares.logic.task.SQuestionTask.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SBangpaiTask",ares.logic.task.SBangpaiTask.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SActiAwardRetrieve",ares.logic.task.SActiAwardRetrieve.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SZhenFaeffect",ares.logic.team.SZhenFaeffect.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SZhenFacost",ares.logic.team.SZhenFacost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.STeamMatchConfig",ares.logic.team.STeamMatchConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.STeamMatchFirstConfig",ares.logic.team.STeamMatchFirstConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SStarnature",ares.logic.team.SStarnature.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SRobotGrade",ares.logic.team.SRobotGrade.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SRobotEquip",ares.logic.team.SRobotEquip.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SRobotFactionSkill",ares.logic.team.SRobotFactionSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.team.SRobotPet",ares.logic.team.SRobotPet.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.timer.SScheculedActivity",ares.logic.timer.SScheculedActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SchoolWheel",ares.logic.specialquest.SchoolWheel.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SWDHConfig",ares.logic.specialquest.SWDHConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SWDHmsgConfig",ares.logic.specialquest.SWDHmsgConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SWDHmapConfig",ares.logic.specialquest.SWDHmapConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SPJDHmatchConfig",ares.logic.specialquest.SPJDHmatchConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SPJDHlevelConfig",ares.logic.specialquest.SPJDHlevelConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SSchoolTaskConfig",ares.logic.specialquest.SSchoolTaskConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SSchoolTaskMain",ares.logic.specialquest.SSchoolTaskMain.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SSchoolTaskBank",ares.logic.specialquest.SSchoolTaskBank.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SQieTingTaskItem",ares.logic.specialquest.SQieTingTaskItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SRankQuesions",ares.logic.specialquest.SRankQuesions.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SPicQuesions",ares.logic.specialquest.SPicQuesions.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STreasureMapTaskConfig",ares.logic.specialquest.STreasureMapTaskConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SGhosts",ares.logic.specialquest.SGhosts.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SBattleTarget",ares.logic.specialquest.SBattleTarget.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SPatrolMap",ares.logic.specialquest.SPatrolMap.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SHeadPortrait",ares.logic.specialquest.SHeadPortrait.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SgiveWandering",ares.logic.specialquest.SgiveWandering.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SgivehaiMarket",ares.logic.specialquest.SgivehaiMarket.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STaskChainStype",ares.logic.specialquest.STaskChainStype.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SEachRoundReward",ares.logic.specialquest.SEachRoundReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SExperience",ares.logic.specialquest.SExperience.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STasktypedescribe",ares.logic.specialquest.STasktypedescribe.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SMissionNPCConfig",ares.logic.specialquest.SMissionNPCConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.Sassistance",ares.logic.specialquest.Sassistance.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SJigsawLib",ares.logic.specialquest.SJigsawLib.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STaskChainMap",ares.logic.specialquest.STaskChainMap.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STaskChainLib",ares.logic.specialquest.STaskChainLib.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.STaskChainRandom",ares.logic.specialquest.STaskChainRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.specialquest.SZhuRiTaskConfig",ares.logic.specialquest.SZhuRiTaskConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.chat.SchatConfig",ares.logic.chat.SchatConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.chat.StopicConfig",ares.logic.chat.StopicConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.chat.SbattleFailedMessage",ares.logic.chat.SbattleFailedMessage.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.friend.SfriendDegrees",ares.logic.friend.SfriendDegrees.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.friend.SFlowerConfig",ares.logic.friend.SFlowerConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.friend.SEngagedConf",ares.logic.friend.SEngagedConf.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.friend.SfriendGiftsNumber",ares.logic.friend.SfriendGiftsNumber.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.friend.SfriendGiftsItem",ares.logic.friend.SfriendGiftsItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.task.SMainMissionInfo",ares.logic.task.SMainMissionInfo.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionOfficeConfig",ares.logic.faction.SFactionOfficeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionLevel",ares.logic.faction.SFactionLevel.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SCampConfig",ares.logic.faction.SCampConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SCampJumpConfig",ares.logic.faction.SCampJumpConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionSkill",ares.logic.faction.SFactionSkill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionPurchase",ares.logic.faction.SFactionPurchase.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionWelfareView",ares.logic.faction.SFactionWelfareView.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SCampOfficeConfig",ares.logic.faction.SCampOfficeConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SCampLeaveConfig",ares.logic.faction.SCampLeaveConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SGhostSealMap",ares.logic.faction.SGhostSealMap.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionGive",ares.logic.faction.SFactionGive.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionRobberRefreshConfig",ares.logic.faction.SFactionRobberRefreshConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionRobberMonsterConfig",ares.logic.faction.SFactionRobberMonsterConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.PKWuxunConfigFighterNum",ares.logic.faction.PKWuxunConfigFighterNum.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.PKWuxunConfigGuanzhi",ares.logic.faction.PKWuxunConfigGuanzhi.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.PKWuxunConfigLv",ares.logic.faction.PKWuxunConfigLv.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionQA",ares.logic.faction.SFactionQA.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionShipConfig",ares.logic.faction.SFactionShipConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionSteal",ares.logic.faction.SFactionSteal.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionStealTaskConfig",ares.logic.faction.SFactionStealTaskConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetCharacter",ares.logic.faction.SFactionpetCharacter.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetSwallow",ares.logic.faction.SFactionpetSwallow.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetEvolution",ares.logic.faction.SFactionpetEvolution.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetReward",ares.logic.faction.SFactionpetReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetVolume",ares.logic.faction.SFactionpetVolume.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionpetNewRandom",ares.logic.faction.SFactionpetNewRandom.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionActivity",ares.logic.faction.SFactionActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SInvadereward",ares.logic.faction.SInvadereward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionAngelconfig",ares.logic.faction.SFactionAngelconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionAngelcaiji",ares.logic.faction.SFactionAngelcaiji.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.STerritoryKill",ares.logic.faction.STerritoryKill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.STerritoryConfig",ares.logic.faction.STerritoryConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SNumberreward",ares.logic.faction.SNumberreward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.Scollectbattle",ares.logic.faction.Scollectbattle.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.Scollectreward",ares.logic.faction.Scollectreward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.STerritoryShopgroup",ares.logic.faction.STerritoryShopgroup.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.STerritoryShop",ares.logic.faction.STerritoryShop.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionPrestigeRank",ares.logic.faction.SFactionPrestigeRank.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SDonationList",ares.logic.faction.SDonationList.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SCollectionWeight",ares.logic.faction.SCollectionWeight.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.faction.SFactionPrestigeData",ares.logic.faction.SFactionPrestigeData.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.log.SLogFormatConfig",ares.logic.log.SLogFormatConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SAddCash",ares.logic.yuanbao.SAddCash.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SAddCash__3",ares.logic.yuanbao.SAddCash__3.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SAddYuanbao",ares.logic.yuanbao.SAddYuanbao.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SUseYuanbao",ares.logic.yuanbao.SUseYuanbao.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SLimitSell",ares.logic.yuanbao.SLimitSell.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SCost",ares.logic.yuanbao.SCost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SGiftDai",ares.logic.yuanbao.SGiftDai.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SOpenCash",ares.logic.yuanbao.SOpenCash.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SkaifuActivity",ares.logic.yuanbao.SkaifuActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SkaifuMissionLibrary",ares.logic.yuanbao.SkaifuMissionLibrary.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SkaifuPlan",ares.logic.yuanbao.SkaifuPlan.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SfirstCharge",ares.logic.yuanbao.SfirstCharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SpreserveAward",ares.logic.yuanbao.SpreserveAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SkaifuFaction",ares.logic.yuanbao.SkaifuFaction.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SinviteScoreAward",ares.logic.yuanbao.SinviteScoreAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SInviteGoalConfig",ares.logic.yuanbao.SInviteGoalConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SRedpacket",ares.logic.yuanbao.SRedpacket.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SQuestionnaireopen",ares.logic.yuanbao.SQuestionnaireopen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SGrowthfund",ares.logic.yuanbao.SGrowthfund.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SYiYuanBuy",ares.logic.yuanbao.SYiYuanBuy.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SRedPacketItem",ares.logic.yuanbao.SRedPacketItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SChargeConsumeAward",ares.logic.yuanbao.SChargeConsumeAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoActivity",ares.logic.yuanbao.SbingoActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoAward",ares.logic.yuanbao.SbingoAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoOpen",ares.logic.yuanbao.SbingoOpen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SShopdail",ares.logic.yuanbao.SShopdail.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.STotalChargeAward",ares.logic.yuanbao.STotalChargeAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SPrivilegecard",ares.logic.yuanbao.SPrivilegecard.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SaristocratPackage",ares.logic.yuanbao.SaristocratPackage.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SActivegiftbag",ares.logic.yuanbao.SActivegiftbag.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SRankAward",ares.logic.yuanbao.SRankAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SRankAward__3",ares.logic.yuanbao.SRankAward__3.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SAimAward",ares.logic.yuanbao.SAimAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.AwardList",ares.logic.yuanbao.AwardList.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SZhulilibaoopen",ares.logic.yuanbao.SZhulilibaoopen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SZhulilibaoaward",ares.logic.yuanbao.SZhulilibaoaward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SFortuneCatConfig",ares.logic.yuanbao.SFortuneCatConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SFortuneCatConfig__3",ares.logic.yuanbao.SFortuneCatConfig__3.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SGroupBuyAward",ares.logic.yuanbao.SGroupBuyAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSingleChargeReward",ares.logic.yuanbao.SSingleChargeReward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SCashGiveItem",ares.logic.yuanbao.SCashGiveItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SCashGivePoints",ares.logic.yuanbao.SCashGivePoints.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSpecialgift",ares.logic.yuanbao.SSpecialgift.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SDailyRecharge",ares.logic.yuanbao.SDailyRecharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SAccumulativeRecharge",ares.logic.yuanbao.SAccumulativeRecharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SZhuanZhicost",ares.logic.yuanbao.SZhuanZhicost.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SyuanbaoTurntable",ares.logic.yuanbao.SyuanbaoTurntable.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.Shunyureturn",ares.logic.yuanbao.Shunyureturn.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SOnlineAward",ares.logic.yuanbao.SOnlineAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SZhigouGift",ares.logic.yuanbao.SZhigouGift.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SThreeDaysCharge",ares.logic.yuanbao.SThreeDaysCharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SPetLimitSell",ares.logic.yuanbao.SPetLimitSell.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SWinterDailyCharge",ares.logic.yuanbao.SWinterDailyCharge.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SFirstChargeAward",ares.logic.yuanbao.SFirstChargeAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSingleChargeAward",ares.logic.yuanbao.SSingleChargeAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoActivity",ares.logic.yuanbao.SbingoActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoAward",ares.logic.yuanbao.SbingoAward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SbingoOpen",ares.logic.yuanbao.SbingoOpen.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SnotputbackTurntable",ares.logic.yuanbao.SnotputbackTurntable.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SnotputbackExtract",ares.logic.yuanbao.SnotputbackExtract.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.Ssmsddiscount",ares.logic.yuanbao.Ssmsddiscount.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.Ssmsdaward",ares.logic.yuanbao.Ssmsdaward.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.Ssmsditem",ares.logic.yuanbao.Ssmsditem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSpikeActivity",ares.logic.yuanbao.SSpikeActivity.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSpikeActivityTime",ares.logic.yuanbao.SSpikeActivityTime.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.yuanbao.SSpikeActivityItem",ares.logic.yuanbao.SSpikeActivityItem.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubenjindu",ares.logic.fuben.SFubenjindu.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubennpcservice",ares.logic.fuben.SFubennpcservice.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubennpc",ares.logic.fuben.SFubennpc.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubenconfig",ares.logic.fuben.SFubenconfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubenthing",ares.logic.fuben.SFubenthing.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SFubenchildrenjindu",ares.logic.fuben.SFubenchildrenjindu.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.fuben.SDailyFubenConfig",ares.logic.fuben.SDailyFubenConfig.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.zhiye.SSkilldesignation",ares.logic.zhiye.SSkilldesignation.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.zhiye.SVocationalskill",ares.logic.zhiye.SVocationalskill.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.zhiye.SChangeaddpoint",ares.logic.zhiye.SChangeaddpoint.toXML(inputdir, outputdir, xstream));
//			objs.put("ares.logic.map.cmaptransport",ares.logic.map.cmaptransport.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.cmappatrolconfig",ares.logic.map.cmappatrolconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.cscenefogconfig",ares.logic.map.cscenefogconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.cmapconfig",ares.logic.map.cmapconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.cworldmapjump",ares.logic.map.cworldmapjump.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.csceneconfig",ares.logic.map.csceneconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.map.cmapblockconfig",ares.logic.map.cmapblockconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjisuittype",ares.logic.item.cyinjisuittype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgemeffect",ares.logic.item.cgemeffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemattr",ares.logic.item.citemattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjiattr",ares.logic.item.cyinjiattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cpetshouhustar",ares.logic.item.cpetshouhustar.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.chhuobanpassiveskilleffect",ares.logic.item.chhuobanpassiveskilleffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cpetchipattr",ares.logic.item.cpetchipattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cattributedesconfig",ares.logic.item.cattributedesconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemtype",ares.logic.item.citemtype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cpetitemeffect",ares.logic.item.cpetitemeffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipeffect",ares.logic.item.cequipeffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.ctaskrelative",ares.logic.item.ctaskrelative.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.ctreasuremapitemattr",ares.logic.item.ctreasuremapitemattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipstrengthen",ares.logic.item.cequipstrengthen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cpresentconfig",ares.logic.item.cpresentconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemduihuan",ares.logic.item.citemduihuan.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipcombin",ares.logic.item.cequipcombin.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemstore",ares.logic.item.citemstore.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemstoretype",ares.logic.item.citemstoretype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemshop",ares.logic.item.citemshop.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cjifenshop",ares.logic.item.cjifenshop.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cjifenshoptype",ares.logic.item.cjifenshoptype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cfactionshop",ares.logic.item.cfactionshop.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citembuffids",ares.logic.item.citembuffids.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citembuff",ares.logic.item.citembuff.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cbagprice",ares.logic.item.cbagprice.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cbaoshitaozhuang",ares.logic.item.cbaoshitaozhuang.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgemlv",ares.logic.item.cgemlv.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cbaoshizhanshi",ares.logic.item.cbaoshizhanshi.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cmoneytype",ares.logic.item.cmoneytype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cmoneycost",ares.logic.item.cmoneycost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipsbscoreconfig",ares.logic.item.cequipsbscoreconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemgetway",ares.logic.item.citemgetway.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cwandering",ares.logic.item.cwandering.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cquicksynthesis",ares.logic.item.cquicksynthesis.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.canonycard",ares.logic.item.canonycard.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.canonycardgift",ares.logic.item.canonycardgift.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cselltype",ares.logic.item.cselltype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.csaletype",ares.logic.item.csaletype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cpetpricerec",ares.logic.item.cpetpricerec.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipskillrandom",ares.logic.item.cgodequipskillrandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipadditionattributerandom",ares.logic.item.cgodequipadditionattributerandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipadditionattributebelong",ares.logic.item.cgodequipadditionattributebelong.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipbaseattributerandom",ares.logic.item.cgodequipbaseattributerandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipsplit",ares.logic.item.cgodequipsplit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipskillitemconfig",ares.logic.item.cgodequipskillitemconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cfashionconfig",ares.logic.item.cfashionconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cfashionstoremap",ares.logic.item.cfashionstoremap.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cfashionscreeningconfig",ares.logic.item.cfashionscreeningconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cstarinfo",ares.logic.item.cstarinfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cproptype",ares.logic.item.cproptype.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipupgradeconfig",ares.logic.item.cgodequipupgradeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemuse",ares.logic.item.citemuse.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemuse",ares.logic.item.citemuse.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipupdateconfig",ares.logic.item.cgodequipupdateconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipcreateconfig",ares.logic.item.cgodequipcreateconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipcreatedisplay",ares.logic.item.cgodequipcreatedisplay.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cqinmidu",ares.logic.item.cqinmidu.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.clingfuinfo",ares.logic.item.clingfuinfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.ckite",ares.logic.item.ckite.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cfashionattributeconfig",ares.logic.item.cfashionattributeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.chuanhuaconfig",ares.logic.item.chuanhuaconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgodequipchange",ares.logic.item.cgodequipchange.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemprovidegodexp",ares.logic.item.citemprovidegodexp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgemid",ares.logic.item.cgemid.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cgemid",ares.logic.item.cgemid.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.citemaddatlexp",ares.logic.item.citemaddatlexp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyufuattrcorrespondence",ares.logic.item.cyufuattrcorrespondence.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyufusuit",ares.logic.item.cyufusuit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyufucaoconfig",ares.logic.item.cyufucaoconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.clingyiskillinfo",ares.logic.item.clingyiskillinfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyuansuupperlimit",ares.logic.item.cyuansuupperlimit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyufuitem",ares.logic.item.cyufuitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cchenshuishouitem",ares.logic.item.cchenshuishouitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.czhenyushouitem",ares.logic.item.czhenyushouitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.ccompositeresult",ares.logic.item.ccompositeresult.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.ccultivateslot",ares.logic.item.ccultivateslot.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cmosaicslot",ares.logic.item.cmosaicslot.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cattrnum",ares.logic.item.cattrnum.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cagatesuitattr",ares.logic.item.cagatesuitattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cshipinconfig",ares.logic.item.cshipinconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cshipinfashionconfig",ares.logic.item.cshipinfashionconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjisuitconfig",ares.logic.item.cyinjisuitconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjibaserandom",ares.logic.item.cyinjibaserandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjiincidentrandom",ares.logic.item.cyinjiincidentrandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjiupgrade",ares.logic.item.cyinjiupgrade.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cyinjiarchive",ares.logic.item.cyinjiarchive.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cmagicscreen",ares.logic.item.cmagicscreen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.caffixscreen",ares.logic.item.caffixscreen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.challoween",ares.logic.item.challoween.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipsoulconfig",ares.logic.item.cequipsoulconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequipsoulupdate",ares.logic.item.cequipsoulupdate.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.item.cequiplevelexp",ares.logic.item.cequiplevelexp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.effect.ceffectconfig",ares.logic.effect.ceffectconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.effect.csystemswitchcraft",ares.logic.effect.csystemswitchcraft.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.effect.cgodequipeffect",ares.logic.effect.cgodequipeffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cmonsterconfig",ares.logic.npc.cmonsterconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcshape",ares.logic.npc.cnpcshape.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcshapelua",ares.logic.npc.cnpcshapelua.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcconfig",ares.logic.npc.cnpcconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcchat",ares.logic.npc.cnpcchat.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcserverconfig",ares.logic.npc.cnpcserverconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcactionconfig",ares.logic.npc.cnpcactionconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakexinxi",ares.logic.npc.cxiakexinxi.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakebreakattrconfig",ares.logic.npc.cxiakebreakattrconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakepassiveskillslot",ares.logic.npc.cxiakepassiveskillslot.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakebreakconfig",ares.logic.npc.cxiakebreakconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakebreakdisplayconfig",ares.logic.npc.cxiakebreakdisplayconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakeskill",ares.logic.npc.cxiakeskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cwantedcircularnameconfig",ares.logic.npc.cwantedcircularnameconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cwantedcircularserieseconfig",ares.logic.npc.cwantedcircularserieseconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cwantedcirculargroupconfig",ares.logic.npc.cwantedcirculargroupconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.csinglepkactivitynpc",ares.logic.npc.csinglepkactivitynpc.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.csinglepkactivityguide",ares.logic.npc.csinglepkactivityguide.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.csinglepkactivitygroup",ares.logic.npc.csinglepkactivitygroup.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.csinglepkactivityscore",ares.logic.npc.csinglepkactivityscore.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.ccaijinpcconfig",ares.logic.npc.ccaijinpcconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcfinding",ares.logic.npc.cnpcfinding.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cpartnerunlockconsume",ares.logic.npc.cpartnerunlockconsume.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.partnertypeconfig",ares.logic.npc.partnertypeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cpecialpartnerunlock",ares.logic.npc.cpecialpartnerunlock.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cnpcmonitor",ares.logic.npc.cnpcmonitor.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cpartnerlvparameterconfig",ares.logic.npc.cpartnerlvparameterconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cpartnertokenconfig",ares.logic.npc.cpartnertokenconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.acconfig",ares.logic.npc.acconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.clingfuslot",ares.logic.npc.clingfuslot.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.clingfuplan",ares.logic.npc.clingfuplan.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.clingfuattrmapping",ares.logic.npc.clingfuattrmapping.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.clingfuresonance",ares.logic.npc.clingfuresonance.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.npc.cxiakebreakadditionconfig",ares.logic.npc.cxiakebreakadditionconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.schoolinfo",ares.logic.role.schoolinfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.createroleconfig",ares.logic.role.createroleconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.ccreateroleskill",ares.logic.role.ccreateroleskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.createrolemusic",ares.logic.role.createrolemusic.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.rolepostfix",ares.logic.role.rolepostfix.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.rolemusicconfig",ares.logic.role.rolemusicconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.ccreateroleconfig",ares.logic.role.ccreateroleconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cattrmoddata",ares.logic.role.cattrmoddata.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.crunaudio",ares.logic.role.crunaudio.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cresmoneyconfig",ares.logic.role.cresmoneyconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.crolelevelskilllevel",ares.logic.role.crolelevelskilllevel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cservermaxlevelconfig",ares.logic.role.cservermaxlevelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cserverexpdecay",ares.logic.role.cserverexpdecay.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdamagetosp",ares.logic.role.cdamagetosp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqirolename",ares.logic.role.czuoqirolename.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqi",ares.logic.role.czuoqi.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqibianshen",ares.logic.role.czuoqibianshen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cprosperitydegree",ares.logic.role.cprosperitydegree.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdyehair",ares.logic.role.cdyehair.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdyeclothes",ares.logic.role.cdyeclothes.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdyegarnish",ares.logic.role.cdyegarnish.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdyecost",ares.logic.role.cdyecost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.cdyecontrol",ares.logic.role.cdyecontrol.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.croleactionconfig",ares.logic.role.croleactionconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.croleattrtips",ares.logic.role.croleattrtips.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.crideunlockconsume",ares.logic.role.crideunlockconsume.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.croleshapeconfig",ares.logic.role.croleshapeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.crolechooseacconfig",ares.logic.role.crolechooseacconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqitrain",ares.logic.role.czuoqitrain.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqiattr",ares.logic.role.czuoqiattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqiskill",ares.logic.role.czuoqiskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.role.czuoqipresent",ares.logic.role.czuoqipresent.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetcolumn",ares.logic.pet.cpetcolumn.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetattr",ares.logic.pet.cpetattr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetnextexp",ares.logic.pet.cpetnextexp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetsatietyexp",ares.logic.pet.cpetsatietyexp.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetfeed",ares.logic.pet.cpetfeed.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetfeedskill",ares.logic.pet.cpetfeedskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetjuexing",ares.logic.pet.cpetjuexing.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetchipsynthesis",ares.logic.pet.cpetchipsynthesis.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetchapter",ares.logic.pet.cpetchapter.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetillustrated",ares.logic.pet.cpetillustrated.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpettaskunlock",ares.logic.pet.cpettaskunlock.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetgradecfg",ares.logic.pet.cpetgradecfg.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetstars",ares.logic.pet.cpetstars.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetaffix",ares.logic.pet.cpetaffix.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetzizhicolor",ares.logic.pet.cpetzizhicolor.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetcallnum",ares.logic.pet.cpetcallnum.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetsubject",ares.logic.pet.cpetsubject.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetsummondisplay",ares.logic.pet.cpetsummondisplay.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.ccustomizedpet",ares.logic.pet.ccustomizedpet.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetattrcalc",ares.logic.pet.cpetattrcalc.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetsharechannel",ares.logic.pet.cpetsharechannel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.crarepetexchange",ares.logic.pet.crarepetexchange.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetcontrolspeed",ares.logic.pet.cpetcontrolspeed.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetshouhustarssuit",ares.logic.pet.cpetshouhustarssuit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.csoulitem",ares.logic.pet.csoulitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.csoulcost",ares.logic.pet.csoulcost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.csoulattrishow",ares.logic.pet.csoulattrishow.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpetyinglingconfig",ares.logic.pet.cpetyinglingconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.pet.cpeteleskill",ares.logic.pet.cpeteleskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.login.cloginerrorstr",ares.logic.login.cloginerrorstr.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.login.cexitgame",ares.logic.login.cexitgame.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.login.cupdatewords",ares.logic.login.cupdatewords.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattlebackmusic",ares.logic.battle.cbattlebackmusic.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cformationbaseconfig",ares.logic.battle.cformationbaseconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattleaiconfig",ares.logic.battle.cbattleaiconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattleinfo",ares.logic.battle.cbattleinfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattleinfoboss",ares.logic.battle.cbattleinfoboss.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattleorderconfig",ares.logic.battle.cbattleorderconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattleposconfig",ares.logic.battle.cbattleposconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattlefuclist",ares.logic.battle.cbattlefuclist.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.battle.cbattlecameraconfig",ares.logic.battle.cbattlecameraconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.SystemSetting.cfunctionconfigsetting",ares.logic.SystemSetting.cfunctionconfigsetting.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.SystemSetting.cgaojishezhi",ares.logic.SystemSetting.cgaojishezhi.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.SystemSetting.interfacesetting",ares.logic.SystemSetting.interfacesetting.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.title.ctitleconfig",ares.logic.title.ctitleconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.title.cintimacyaddtitle",ares.logic.title.cintimacyaddtitle.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cduihuanma",ares.logic.game.cduihuanma.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfengyaoconfig",ares.logic.game.cfengyaoconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cactivityaward",ares.logic.game.cactivityaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cvipconfig",ares.logic.game.cvipconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cdenglulibao",ares.logic.game.cdenglulibao.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cshouchonglibao",ares.logic.game.cshouchonglibao.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cpaihangbang",ares.logic.game.cpaihangbang.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cpaihangbangaward",ares.logic.game.cpaihangbangaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cbattletypeconfig",ares.logic.game.cbattletypeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cenumer",ares.logic.game.cenumer.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cloadingpic",ares.logic.game.cloadingpic.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cuiback",ares.logic.game.cuiback.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cbigtreasuremapactivityconfig",ares.logic.game.cbigtreasuremapactivityconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cbigtreasuremapbigaward",ares.logic.game.cbigtreasuremapbigaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cbigtreasuremapnum",ares.logic.game.cbigtreasuremapnum.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cyabiaoevent",ares.logic.game.cyabiaoevent.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cyabiaorandom",ares.logic.game.cyabiaorandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cclimbtower",ares.logic.game.cclimbtower.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cclimbtoweritem",ares.logic.game.cclimbtoweritem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clvlimitconfig",ares.logic.game.clvlimitconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.czhiyinconfig",ares.logic.game.czhiyinconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctiaozhuanconfig",ares.logic.game.ctiaozhuanconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.czhiyintabconfig",ares.logic.game.czhiyintabconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cxianjiananswer",ares.logic.game.cxianjiananswer.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.canswerextrapremium",ares.logic.game.canswerextrapremium.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.csign",ares.logic.game.csign.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.caccumulatedsign",ares.logic.game.caccumulatedsign.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cwuxuanyiconfig",ares.logic.game.cwuxuanyiconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clevepackage",ares.logic.game.clevepackage.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.csevendaysreward",ares.logic.game.csevendaysreward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.crewardactivitysort",ares.logic.game.crewardactivitysort.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.csslunjian",ares.logic.game.csslunjian.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cjjcgradeconfig",ares.logic.game.cjjcgradeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cjjcrankaward",ares.logic.game.cjjcrankaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cjjcgradeaward",ares.logic.game.cjjcgradeaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeatureshow",ares.logic.game.cfeatureshow.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeatureunlock",ares.logic.game.cfeatureunlock.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cguideindex",ares.logic.game.cguideindex.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cguidesteps",ares.logic.game.cguidesteps.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cguideespecialskill",ares.logic.game.cguideespecialskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cloadingtips",ares.logic.game.cloadingtips.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cqualityconfig",ares.logic.game.cqualityconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cpinjiandahuiaward",ares.logic.game.cpinjiandahuiaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cxianmengchapter",ares.logic.game.cxianmengchapter.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cxianmengstage",ares.logic.game.cxianmengstage.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cachievementlabel",ares.logic.game.cachievementlabel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cchievementgoal",ares.logic.game.cchievementgoal.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cworldquestion",ares.logic.game.cworldquestion.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.chotpointconfig",ares.logic.game.chotpointconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cupdatereward",ares.logic.game.cupdatereward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cservercivilwaraward",ares.logic.game.cservercivilwaraward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cservercivilwarprocess",ares.logic.game.cservercivilwarprocess.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ccampreward",ares.logic.game.ccampreward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ccamprewardstar",ares.logic.game.ccamprewardstar.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.carenaconfig",ares.logic.game.carenaconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.carenarankawarddisplay",ares.logic.game.carenarankawarddisplay.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cguajibattleconfig",ares.logic.game.cguajibattleconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cunlocktrailer",ares.logic.game.cunlocktrailer.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ccampbattlebuff",ares.logic.game.ccampbattlebuff.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cexperiencerain",ares.logic.game.cexperiencerain.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctaoyuanbattlebuff",ares.logic.game.ctaoyuanbattlebuff.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctaoyuanmonsterconfig",ares.logic.game.ctaoyuanmonsterconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cspaceconfig",ares.logic.game.cspaceconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cspacephotoconfig",ares.logic.game.cspacephotoconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeastingredients",ares.logic.game.cfeastingredients.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeastfood",ares.logic.game.cfeastfood.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeastanswer",ares.logic.game.cfeastanswer.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfeastnpcgrid",ares.logic.game.cfeastnpcgrid.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cstrongfirstlevelconfig",ares.logic.game.cstrongfirstlevelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cstrongsecondlevelconfig",ares.logic.game.cstrongsecondlevelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cstrongscoreconfig",ares.logic.game.cstrongscoreconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelcharacter",ares.logic.game.clingshoutravelcharacter.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelcalendar",ares.logic.game.clingshoutravelcalendar.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelincidentlibrary",ares.logic.game.clingshoutravelincidentlibrary.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelsetoutlibrary",ares.logic.game.clingshoutravelsetoutlibrary.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutraveltreasureboxprice",ares.logic.game.clingshoutraveltreasureboxprice.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelwaypointconfig",ares.logic.game.clingshoutravelwaypointconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingshoutravelmodelconfig",ares.logic.game.clingshoutravelmodelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cwineconfig",ares.logic.game.cwineconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.catlas",ares.logic.game.catlas.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.catlascollectreward",ares.logic.game.catlascollectreward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.catlasattributereward",ares.logic.game.catlasattributereward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.catlasupgrade",ares.logic.game.catlasupgrade.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.defeatguidance",ares.logic.game.defeatguidance.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cspecialattributes",ares.logic.game.cspecialattributes.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cseparatepackage",ares.logic.game.cseparatepackage.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cbpdiaoxiang",ares.logic.game.cbpdiaoxiang.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.crandomdialbattle",ares.logic.game.crandomdialbattle.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctongtianta",ares.logic.game.ctongtianta.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cservercivilwaraward",ares.logic.game.cservercivilwaraward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cservercivilwarprocess",ares.logic.game.cservercivilwarprocess.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfengshenwaraward",ares.logic.game.cfengshenwaraward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfengshenwarprocess",ares.logic.game.cfengshenwarprocess.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cservercivilwarstatue",ares.logic.game.cservercivilwarstatue.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cfengshenwarstatue",ares.logic.game.cfengshenwarstatue.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cshenbingexchange",ares.logic.game.cshenbingexchange.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.crepconfig",ares.logic.game.crepconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.creincarnation",ares.logic.game.creincarnation.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cjulingzhuconfig",ares.logic.game.cjulingzhuconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctianjireelconfig",ares.logic.game.ctianjireelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.ctianjireelupgradeconfig",ares.logic.game.ctianjireelupgradeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cupdatereward",ares.logic.game.cupdatereward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cchannellinkconfig",ares.logic.game.cchannellinkconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cwinterintegralaward",ares.logic.game.cwinterintegralaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cavatarframe",ares.logic.game.cavatarframe.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingmaiupgrade",ares.logic.game.clingmaiupgrade.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingmaiitem",ares.logic.game.clingmaiitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.clingmairesonance",ares.logic.game.clingmairesonance.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.cchatbubble",ares.logic.game.cchatbubble.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.game.crewardorder",ares.logic.game.crewardorder.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.buff.cibuffconfig",ares.logic.buff.cibuffconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.buff.cbuffconfig",ares.logic.buff.cbuffconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cmessagetip",ares.logic.message.cmessagetip.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cstringres",ares.logic.message.cstringres.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cpostbox",ares.logic.message.cpostbox.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cconfirm",ares.logic.message.cconfirm.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.ccommontips",ares.logic.message.ccommontips.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cactivepush",ares.logic.message.cactivepush.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.message.cconvenientmessage",ares.logic.message.cconvenientmessage.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskillcost",ares.logic.skill.cskillcost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cschoolskillitem",ares.logic.skill.cschoolskillitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskillcloseup",ares.logic.skill.cskillcloseup.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetskillupgrade",ares.logic.skill.cpetskillupgrade.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskillitem",ares.logic.skill.cskillitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cschoolskill",ares.logic.skill.cschoolskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetskillconfig",ares.logic.skill.cpetskillconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.chuobanpassiveskillconfig",ares.logic.skill.chuobanpassiveskillconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskilltypeconfig",ares.logic.skill.cskilltypeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskillconfig",ares.logic.skill.cskillconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskillperform",ares.logic.skill.cskillperform.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.celementskillperform",ares.logic.skill.celementskillperform.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cskilllevellimit",ares.logic.skill.cskilllevellimit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetautoskill",ares.logic.skill.cpetautoskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cspecialbuffbanner",ares.logic.skill.cspecialbuffbanner.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetqianban",ares.logic.skill.cpetqianban.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetqianbansource",ares.logic.skill.cpetqianbansource.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.chuanhuarandom",ares.logic.skill.chuanhuarandom.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.cpetqianbandirection",ares.logic.skill.cpetqianbandirection.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.skill.chuobanpassiveskillupgrade",ares.logic.skill.chuobanpassiveskillupgrade.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cacceptabletask_new",ares.logic.task.cacceptabletask_new.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.croleanipeiyin",ares.logic.task.croleanipeiyin.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.ctasklist",ares.logic.task.ctasklist.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cactivegiftbox",ares.logic.task.cactivegiftbox.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.ctasktrackingorder",ares.logic.task.ctasktrackingorder.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.ctiku",ares.logic.task.ctiku.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cuseitemprocessbar",ares.logic.task.cuseitemprocessbar.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.activitycalendar",ares.logic.task.activitycalendar.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cplotanimationui",ares.logic.task.cplotanimationui.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.canimationdanmu",ares.logic.task.canimationdanmu.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.canimation",ares.logic.task.canimation.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cquestiontask",ares.logic.task.cquestiontask.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cbangpaitask",ares.logic.task.cbangpaitask.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cdialogue",ares.logic.task.cdialogue.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cchapteranimation",ares.logic.task.cchapteranimation.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cmoodaction",ares.logic.task.cmoodaction.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.team.czhenfaeffect",ares.logic.team.czhenfaeffect.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.team.czhenfacost",ares.logic.team.czhenfacost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.team.cteammatchconfig",ares.logic.team.cteammatchconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.team.cstarnature",ares.logic.team.cstarnature.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.timer.cscheculedactivity",ares.logic.timer.cscheculedactivity.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cpjdhschoolconfig",ares.logic.specialquest.cpjdhschoolconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cescortpoint",ares.logic.specialquest.cescortpoint.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cqietingshapedir",ares.logic.specialquest.cqietingshapedir.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cqietingnpc",ares.logic.specialquest.cqietingnpc.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.crankquesions",ares.logic.specialquest.crankquesions.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cpicquesions",ares.logic.specialquest.cpicquesions.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cbattletarget",ares.logic.specialquest.cbattletarget.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cheadportrait",ares.logic.specialquest.cheadportrait.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cexperience",ares.logic.specialquest.cexperience.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.ctasktypedescribe",ares.logic.specialquest.ctasktypedescribe.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cmissionnpcconfig",ares.logic.specialquest.cmissionnpcconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cassistance",ares.logic.specialquest.cassistance.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.cjigsawlib",ares.logic.specialquest.cjigsawlib.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.specialquest.ctaskchainmap",ares.logic.specialquest.ctaskchainmap.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.cchatconfig",ares.logic.chat.cchatconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.clinkconfig",ares.logic.chat.clinkconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.cemojiconfig",ares.logic.chat.cemojiconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.cchatfontcolor",ares.logic.chat.cchatfontcolor.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.cactchat",ares.logic.chat.cactchat.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.chat.cchatemojiarea",ares.logic.chat.cchatemojiarea.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.cfrienddegrees",ares.logic.friend.cfrienddegrees.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.ceventconfig",ares.logic.friend.ceventconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.cflowerconfig",ares.logic.friend.cflowerconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.cengagedconf",ares.logic.friend.cengagedconf.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.cfrienddegreeslevel",ares.logic.friend.cfrienddegreeslevel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.friend.cfriendgiftsitem",ares.logic.friend.cfriendgiftsitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.task.cmainmissioninfo",ares.logic.task.cmainmissioninfo.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionofficeconfig",ares.logic.faction.cfactionofficeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionlevel",ares.logic.faction.cfactionlevel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.ccampconfig",ares.logic.faction.ccampconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionskill",ares.logic.faction.cfactionskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpurchase",ares.logic.faction.cfactionpurchase.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionactivityview",ares.logic.faction.cfactionactivityview.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionwelfareview",ares.logic.faction.cfactionwelfareview.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.ccampofficeconfig",ares.logic.faction.ccampofficeconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.ccampleaveconfig",ares.logic.faction.ccampleaveconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionjoinshow",ares.logic.faction.cfactionjoinshow.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionicon",ares.logic.faction.cfactionicon.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cghostsealmap",ares.logic.faction.cghostsealmap.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cactiongive",ares.logic.faction.cactiongive.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionleadernpc",ares.logic.faction.cfactionleadernpc.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionshipconfig",ares.logic.faction.cfactionshipconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionstealtaskconfig",ares.logic.faction.cfactionstealtaskconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpetcharacter",ares.logic.faction.cfactionpetcharacter.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpetevolution",ares.logic.faction.cfactionpetevolution.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpetevolution",ares.logic.faction.cfactionpetevolution.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpetvolume",ares.logic.faction.cfactionpetvolume.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionpetfeedchat",ares.logic.faction.cfactionpetfeedchat.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionstatue",ares.logic.faction.cfactionstatue.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionangelconfig",ares.logic.faction.cfactionangelconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionangelcaiji",ares.logic.faction.cfactionangelcaiji.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cterritorykill",ares.logic.faction.cterritorykill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cterritoryconfig",ares.logic.faction.cterritoryconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.collectspeed",ares.logic.faction.collectspeed.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.buffshow",ares.logic.faction.buffshow.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cterritorylabel",ares.logic.faction.cterritorylabel.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cterritoryshop",ares.logic.faction.cterritoryshop.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.faction.cfactionprestigerank",ares.logic.faction.cfactionprestigerank.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.EffectPath.ceffectpathnonedrama",ares.logic.EffectPath.ceffectpathnonedrama.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.EffectPath.cresourcepath",ares.logic.EffectPath.cresourcepath.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.EffectPath.ceffecttimelimit",ares.logic.EffectPath.ceffecttimelimit.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.caddcash",ares.logic.yuanbao.caddcash.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.caddyuanbao",ares.logic.yuanbao.caddyuanbao.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cuseyuanbao",ares.logic.yuanbao.cuseyuanbao.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.ccost",ares.logic.yuanbao.ccost.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cgiftdai",ares.logic.yuanbao.cgiftdai.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.ckaifuactivity",ares.logic.yuanbao.ckaifuactivity.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.ckaifuplan",ares.logic.yuanbao.ckaifuplan.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cfirstcharge",ares.logic.yuanbao.cfirstcharge.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cpreserveaward",ares.logic.yuanbao.cpreserveaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.ckaifufaction",ares.logic.yuanbao.ckaifufaction.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cinvitescoreaward",ares.logic.yuanbao.cinvitescoreaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cinvitegoalconfig",ares.logic.yuanbao.cinvitegoalconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.credpacket",ares.logic.yuanbao.credpacket.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cquestionnaire",ares.logic.yuanbao.cquestionnaire.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cquestionnaireopen",ares.logic.yuanbao.cquestionnaireopen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cgrowthfund",ares.logic.yuanbao.cgrowthfund.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.credpacketitem",ares.logic.yuanbao.credpacketitem.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cbingoactivity",ares.logic.yuanbao.cbingoactivity.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cbingoaward",ares.logic.yuanbao.cbingoaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.ctotalchargeaward",ares.logic.yuanbao.ctotalchargeaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cprivilegecard",ares.logic.yuanbao.cprivilegecard.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.caristocratpackage",ares.logic.yuanbao.caristocratpackage.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.crankaward",ares.logic.yuanbao.crankaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.caimaward",ares.logic.yuanbao.caimaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.czhulilibaoopen",ares.logic.yuanbao.czhulilibaoopen.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.czhulilibaoaward",ares.logic.yuanbao.czhulilibaoaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cfortunecatconfig",ares.logic.yuanbao.cfortunecatconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.csinglechargereward",ares.logic.yuanbao.csinglechargereward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cdailyrecharge",ares.logic.yuanbao.cdailyrecharge.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.caccumulativerecharge",ares.logic.yuanbao.caccumulativerecharge.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.chunyuspecaward",ares.logic.yuanbao.chunyuspecaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cbingoactivity",ares.logic.yuanbao.cbingoactivity.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.yuanbao.cbingoaward",ares.logic.yuanbao.cbingoaward.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.fuben.cfubenjindu",ares.logic.fuben.cfubenjindu.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.fuben.cfubenconfig",ares.logic.fuben.cfubenconfig.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.fuben.cdailyfuben",ares.logic.fuben.cdailyfuben.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.zhiye.cvocationalskill",ares.logic.zhiye.cvocationalskill.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.zhiye.cchangeaddpoint",ares.logic.zhiye.cchangeaddpoint.toXML(inputdir, outputdir2, xstream));
//			objs.put("ares.logic.zhiye.caddpointplan",ares.logic.zhiye.caddpointplan.toXML(inputdir, outputdir2, xstream));
//		}catch(java.io.IOException ex){
//			logger.error("io閿欒",ex);
//		}
		return objs;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if(args.length!=3) {
			usage();
			return ;
		}
		String inputdir=args[0];
		String outputdir=args[1];
		String outputdir2=args[2];

		if(!new java.io.File(inputdir).exists())
			throw new RuntimeException("鐩綍閿欒锛�"+inputdir+"涓嶅瓨鍦�");
		if(!new java.io.File(outputdir).exists())
			throw new RuntimeException("鐩綍閿欒锛�"+outputdir+"涓嶅瓨鍦�");
		if(!new java.io.File(outputdir2).exists())
			throw new RuntimeException("鐩綍閿欒锛�"+outputdir2+"涓嶅瓨鍦�");	
		org.apache.log4j.xml.DOMConfigurator.configure("log4j.xml");	
		doCheck(doConv(inputdir,outputdir,outputdir2));
	}
}
