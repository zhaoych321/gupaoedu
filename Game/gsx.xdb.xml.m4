<?xml version="1.0" encoding="UTF-8"?>
<xdb xgenOutput="src" trace="debug" traceTo=":out" corePoolSize="8" procPoolSize="50" schedPoolSize="8" dbhome="xdb" logpages="4096" backupDir="xbackup" 
	checkpointPeriod="60000" backupIncPeriod="600000" backupFullPeriod="3600000" angelPeriod="5000" xdbVerify="true" allowBackup="false" dumpCheckpoint="5000">
	<ProcedureConf executionTime="3000" maxExecutionTime="0" retryTimes="3" retryDelay="100"/>
sinclude(`conf.m4')
	<!-- 服务器相关信息 -->
	<xbean name="ServerInfo">
		<variable name="serverlevel" type="int" order="1"/>  服务器等级
	</xbean>
	<table name="serverinfo" key="int" value="ServerInfo" cacheCapacity="1"/>
	
	<!--<xbean name="PhoneInfo">
		<variable name="roleids" type="set" value="long" order="1"/>  绑定手机的roleid
	</xbean>
	<table name="phonenum" key="string" value="PhoneInfo" cacheCapacity="7000" lock="phonenumlock"/>-->
	
	<xbean name="WinterActivityRole">
		<variable name="chargeNum" type="int" order="1"/>  本期充值数量
		<variable name="receiveState" type="int" order="2"/>  本期充值奖励领取状态
		<variable name="chargeNumClearTime" type="long" order="3"/>  本期充值数量清理时间
		
		<variable name="lightnum" type="int" order="4"/>  灯数
		<variable name="flowerScore" type="int" order="5"/>  本期活动送花积分
		<variable name="drawtimes" type="int" order="6"/>  本期活动抽签次数

		<variable name="taskFinishNumClearTime" type="long" order="7"/>  本期活动完成数量清理时间
		<variable name="awardState" type="map" key="int" value="int" order="8"/>  本期各档位奖励领取状态
		<variable name="lightnumClearTime" type="long" order="9"/> 放灯活动清理时间

		<variable name="clearDataTime" type="long" order="10"/>所有非充值玩法清零时间
	</xbean>
	<table name="winteractivity" key="long" value="WinterActivityRole" cacheCapacity="7000" lock="rolelock"/>

	<xbean name="StatusBean">
		<variable name="status" type="int" order="1"/>  0-未充值 1-已充值可以领取 2-已领取
	</xbean>
	<xbean name="ChargeBean">
		<variable name="chargevalue" type="int" order="1"/>  充值金额
	</xbean>
	<xbean name="ThreeDayCharge">
		<variable name="configstatus" type="map" key="int" value="StatusBean" order="1"/>
		<variable name="charges" type="map" key="int" value="ChargeBean" order="2"/>
	</xbean>
	<table name="threedaycharge" key="long" value="ThreeDayCharge" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="PayGiftBean">
		<variable name="status" type="boolean" order="1"/>
	</xbean>
	<table name="paygift" key="long" value="PayGiftBean" cacheCapacity="7000" lock="rolelock"/>
	
	<!-- 饰品 start -->
	<xbean name="OrnamentInfo">
		<variable name="ornamentid" type="int" order="1"/> 
		<variable name="status" type="int" order="2"/> 
		<variable name="endtime" type="long" order="3"/> 剩余时间 -1永久 0不拥有
	</xbean>
	<xbean name="OrnamentInfoBean">
		<variable name="ornaments" type="list" value="OrnamentInfo" order="1"/> 
	</xbean>
	<xbean name="OrnamentInfosBeans">	
		<variable name="ornaments" type="map" key="int" value="OrnamentInfoBean" order="1"/> key类型为协议OrnamentInfo枚举
	</xbean>
	<table name="ornamentinfos" key="long" value="OrnamentInfosBeans" cacheCapacity="7000" lock="rolelock"/>
 	<!-- 饰品 end -->
	
	<!-- 灵翼评分排行榜 start -->
	<xbean name="GodWingScoreRankRecord">
		<variable name="roleid" type="long" order="1"/> 人物ID
		<variable name="rolename" type="string" order="2"/> 人物名称
		<variable name="level" type="int" order="3"/> 等级
		<variable name="score" type="int" order="4"/> 总评分
	</xbean>
	<xbean name="GodWingScoreRank">
		<variable name="records" type="list" value="GodWingScoreRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="godwingscorerank" key="int" value="GodWingScoreRank" cacheCapacity="1"/>
	<!-- 灵翼评分排行榜 end -->
	
	<!--全服灵翼评分排行榜 start -->
	<xbean name="CrossGodWingScoreRank">
		<variable name="records" type="list" value="GodWingScoreRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="crossgodwingscorerank" key="int" value="CrossGodWingScoreRank" cacheCapacity="1"/>
	<!--全服灵翼评分排行榜 end -->
	
	<xbean name="GatheringBead">
		<variable name="warspirit" type="int" order="1"/> 战灵积分
		<variable name="exp" type="int" order="2"/> 当前经验
		<variable name="level" type="int" default="1" order="3"/> 当前等级
		<variable name="totalexp" type="long" order="4"/> 总经验
	</xbean>
	<table name="gatheringbeads" key="long" value="GatheringBead" cacheCapacity="7000" lock="rolelock"/> 聚灵珠
	
	<xbean name="FreeDrawXiake">
		<variable name="drawtimes" type="int" order="1"/>	已经抽取的次数
		<variable name="freetimes" type="int" order="2"/>	累计的免费次数
	</xbean>
	<table name="freedrawxiake" key="long" value="FreeDrawXiake" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="ChargeGive">
		<variable name="remainnum" type="int" order="1"/> 剩余数量
		<variable name="confid" type="int" order="2"/> 本期id
	</xbean>
	<table name="chargegive" key="long" value="ChargeGive" cacheCapacity="7000" lock="rolelock"/>

	<xbean name="ChargeGiveScore">
		<variable name="remainnum" type="int" order="1"/> 剩余数量
		<variable name="confid" type="int" order="2"/> 本期id
	</xbean>
	<table name="chargegivescore" key="long" value="ChargeGiveScore" cacheCapacity="7000" lock="rolelock"/>
	
	<!-- 随机战斗 start-->
	<xbean name="RandomBattle">
		<variable name="todaynum" type="int" order="1"/> 每日战斗次数
		<variable name="lasttime" type="long" order="2"/> 最后一次时间战斗时间或更改次数时间
		<variable name="rolls" type="vector" value="int" order="3"/> 骰子
		<variable name="battleconfid" type="int" order="4"/> 上次转到的配置id
		<variable name="battles" type="vector" value="int" order="5"/> 转盘中所有战斗信息
		<variable name="awardid" type="int" order="6"/> 未领取的奖励id
		<variable name="roleids" type="vector" value="long" order="7"/> 当时一起战斗的队员
	</xbean>
	<table name="randombattle" key="long" value="RandomBattle" cacheCapacity="7000" lock="rolelock"/>
	<!-- 随机战斗 end-->
	
	<xbean name="AttackCityInfo">  攻城活动信息
		<variable name="startTime" type="long" order="1"/>
		<variable name="endTime" type="long" order="2"/>
		<variable name="timefuture" type="long" order="3"/>
	</xbean>
	<table name="attackcityinfo" key="int" value="AttackCityInfo" lock="AttackCityInfoLock" cacheCapacity="7000"/>
	
	<xbean name="AttackCityRole">  攻城领奖次数
		<variable name="dayClearInfo" type="map" key="int" value="AwardClearInfo" order="1"/>
		<variable name="weekClearInfo" type="map" key="int" value="AwardClearInfo" order="2"/>
	</xbean>
	
	<xbean name="AwardClearInfo">
		<variable name="awardTimes" type="int" order="1"/>
		<variable name="clearTime" type="long" order="2"/>
	</xbean>
	
	<table name="attackcityrole" key="long" value="AttackCityRole" lock="rolelock" cacheCapacity="7000"/>
	
	<xbean name="MagicianRoleInfo">  魔器现世玩家身上的信息
		<enum name="NORMAL" value="1"/>			
		<enum name="BATTLE" value="2"/>	
		
		<variable name="magicianexp" type="int" order="1"/>
		<variable name="cdtime" type="long" order="2"/>
		<variable name="roomid" type="long" order="3"/>
		<variable name="buffid" type="int" order="4"/>
		<variable name="flag" type="int" order="5"/>
		
		<variable name="beginstatus" type="int" order="6"/>
		<variable name="npckeys" type="list" value="long" order="7"/>
		
		<variable name="loadfuturekey" type="long" order="8"/>
	</xbean>
	<table name="magicianrole" key="long" value="MagicianRoleInfo" lock="rolelock" cacheCapacity="7000" persistence="MEMORY"/>
	
	<cbean name="MagicianActivityStatus">  状态
		<enum name="PVE_CAN_ENTER" value="1"/>			
		<enum name="PVE_CAN_NOT_ENTER" value="2"/>			
	</cbean>
		
	<xbean name="MagicianActivityInfo">  魔器现世活动
		<variable name="sceneid2roomid" type="map" key="long" value="long" order="1"/>
		<variable name="lastroomid" type="long" order="2"/>
		<variable name="nextstarttime" type="long" order="3"/> 下一场活动时间戳
		<variable name="activitystatus" type="int" order="4"/>  状态
	</xbean>
	<table name="magicianactivity" key="int" value="MagicianActivityInfo" lock="magicianactivitylock" cacheCapacity="10" persistence="MEMORY"/> key-对应的活动id（策划表id）
	
	
	<xbean name="MagicianRoomInfo">魔器现世房间
		<variable name="roleids" type="set" value="long" order="1"/> 
		<variable name="leaderids" type="set" value="long" order="2"/>
		<variable name="pvenpckeys" type="set" value="long" order="3"/>
		<variable name="sceneid" type="long" order="4"/>
		<variable name="activityid" type="int" order="5"/>
		<variable name="pvpfuturekey" type="long" order="6"/>
		<variable name="matchfuturekey" type="long" order="7"/>
		<variable name="pvpnpckeys" type="set" value="long" order="8"/>
	</xbean>
	<table name="magicianroom" key="long" value="MagicianRoomInfo" lock="magicianroomlock" cacheCapacity="2000" persistence="MEMORY" autoIncrement="true"/>
	
	<xbean name="WorldAnswerInfo">
		<variable name="answers" type="list" value="AnswerOptions" order="1"/>  题库
		<variable name="curquestionid" type="int" order="2"/> 当前题号
		<variable name="thisroundendtime" type="long" order="3"/> 本轮结束时间
		<variable name="rolelist" type="list" value="long" order="4"/> 回答正确的人员列表
	</xbean>

	<xbean name="AnswerOptions">
		<variable name="options" type="list" value="int" order="1"/>  选项顺序	
		<variable name="questionid" type="int" order="2"/>  问题ID
	</xbean>
	
	<table name="worldanswer" key="int" value="WorldAnswerInfo" lock="worldanswerlock" cacheCapacity="1"/>
	
	<xbean name="Item">
		<variable name="id" type="int" order="1"/> 物品编号 
		<variable name="flags" type="int" order="2"/> 标志，叠加的时候，flags 也 OR 叠加
		<variable name="position" type="int" default="-1" order="3"/> 包裹属性，位置。从0开始编号
		<variable name="number" type="int" order="4"/>数量
		<variable name="numbermap" type="map" key="int" value="int" capacity="8" order="5"/>数量		
		<variable name="timeout" type="long" default="0" order="6"/> 到期时间。如果为0，代表没有时间限制
		<variable name="extid" type="long" order="7"/> 扩展动态属性
		<variable name="uniqueid" type="long" order="8"/> 物品的唯一id
		<variable name="loseeffecttime" type="long" order="9"/> 物品失效时间
		<variable name="stalltime" type="long" order="10"/> 完成交易记录的成交时间
	</xbean>
	
	<xbean name="Bag">		
		<variable name="money" type="long" order="1"/>
		<variable name="capacity" type="int" order="2"/>
		<variable name="nextid" type="int" order="3"/>
		<variable name="items" type="map" key="int" value="Item" order="4"/>
		<variable name="locked" type="int" default="0" order="5"/> 0代表未锁。1代表已锁
		<variable name="needCheckTimeout" type="boolean" order="6"/>	是否需要检查timeout
		<variable name="removedkeys" type="list" value="int" order="7"/>	刚删除还未通知的物品keys
	</xbean>
	<!--存储临时包裹物品时间获取的-->
	<xbean name="TempTime">
		<variable name="items" type="map" key="int" value="long" order="1"/>
	</xbean>
	<table name="petchipbag" key="long" value="Bag" cacheCapacity="7000" lock="rolelock"/>
	<table name="xiakexinwubag" key="long" value="Bag" cacheCapacity="7000" lock="rolelock"/>
	<table name="petaffixbag" key="long" value="Bag" cacheCapacity="7000" lock="rolelock"/>
	<table name="temptime" key="long" value="TempTime" persistence="MEMORY" cacheCapacity="8192" lock="rolelock"/>
	<table name="bag" key="long" value="Bag" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="depot" key="long" value="Bag" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="equip" key="long" value="Bag" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="repurchase" key="long" value="Bag" foreign="key:properties" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/>
	<table name="questbag" key="long" value="Bag" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="temp" key="long" value="Bag" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/>
	<table name="xiakestampbag" key="long" value="Bag" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<xbean name="BagTimeLock"> 包裹时间锁
		<variable name="num" type="int" order="2"/>
		<variable name="itemkey" type="int" order="1"/>
		<variable name="timeout" type="long" order="3"/>超时时间
	</xbean>
	<table name="bagtimelock" key="long" value="BagTimeLock" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/>
	
	<xbean name="DiscardItem">
		<variable name="item" type="Item" order="1"/> 物品固有属性
		<variable name="deletedate" type="long" order="2"/> 删除日期
	</xbean>
	<table name="itemrecyclebin" key="long" value="DiscardItem" cacheCapacity="256" cachehigh="512" cachelow="256"/> 物品回收站
	
	<xbean name="DiscardPet">
		<variable name="pet" type="PetInfo" order="1"/> 宠物属性
		<variable name="roleid" type="long" order="2"/> 宠物删除时的主人
		<variable name="deletedate" type="long" order="3"/> 删除日期
		<variable name="reason" type="int" order="4"/> 删除原因
	</xbean>
	<table name="petrecyclebin" key="long" value="DiscardPet" cacheCapacity="256" cachehigh="512" cachelow="256" lock="uniquepets"/> 宠物回收站
	<xbean name="UniquePet">
		<variable name="roleId" type="long" order="1"/> 所属角色
	</xbean>
	<table name="uniquepets" key="long" value="UniquePet" cacheCapacity="28000" cachehigh="512" cachelow="256" lock="uniquepets"/> 宠物的唯一信息
	
	<!-- 包裹卡片 -->
	<xbean name="BagCard" any="true">
		<variable name="cardid" type="int" order="1"/> 卡片id
		<variable name="tosend" type="vector" value="xio.Protocol" order="2"/> 需要发送的协议
	</xbean>
	<table name="carditems" key="long" value="BagCard" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/> key为人物id,value为cardid
	
	<xbean name="User">
		<variable name="prevLoginRoleid" type="long" order="1"/>  	 上一次登录的角色
		<variable name="idlist" type="vector" value="long" order="2"/> 用户的角色列表 value是roleid
		<variable name="createtime" type="long" order="3"/> 帐号第一次进入游戏的时间
		<variable name="phonenumber" type="string" order="4"/> 手机号
		<variable name="identificatestate" type="int" order="5"/> 状态
	</xbean>
	<table name="user" key="int" value="User" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="userlock"/>
	
	<xbean name="PhoneBind">
		<variable name="phonebindcards" type="string" order="1"/> 手机绑定验证码
		<variable name="phonebindcardtime" type="long" order="2"/> 手机绑定验证码获取时间
		<!-- <variable name="phonebindtime" type="long" order="3"/> 手机绑定时间 -->
		<variable name="tmpphonenumber" type="string" order="4"/> 验证码所用手机号
		<variable name="awardstate" type="int" order="7"/> 领奖状态
	</xbean>
	<table name="phonebind" key="long" value="PhoneBind" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>

	<xbean name="AUUserInfo">		
		<variable name="retcode" type="int" order="1"/>
		<variable name="func" type="int" order="2"/>
		<variable name="funcparm" type="int" order="3"/>
		<variable name="loginip" type="int" order="4"/>
		<variable name="blisgm" type="int" order="5"/>
		<variable name="auth" type="vector" value="int" order="6"/>
		<variable name="algorithm" type="int" order="7"/>
		<variable name="nickname" type="string" order="8"/>
		<variable name="username" type="string" order="9"/>
		<variable name="mac" type="string" order="10"/>
		<variable name="os" type="string" order="11"/>
		<variable name="channel" type="string" order="12"/> 渠道的标识符
		<variable name="platform" type="string" order="13"/>
		<variable name="clientsource" type="string" order="14"/>
	</xbean>
	<table name="auuserinfo" key="int" value="AUUserInfo" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="userlock"/>
	 
	<!-- 日志头 字段 -->
	<xbean name="LogHead">	
		<variable name="auuserinfo" type="AUUserInfo" order="1"/> AUUserInfo信息的复制
		<variable name="appId" type="string" order="2"/> 游戏的标识。由gaea提供，每一款游戏在同一区域唯一。需要和数据SDK一样
		<variable name="appVersion" type="string" order="3"/> 游戏的版本号，需要和手机端配置文件的一样，数据SDK会读取。
		<variable name="channel" type="string" order="4"/> 渠道，需要同手机端配置的汇报给SDK的保持一样。
		<variable name="deviceId" type="string" order="5"/> android：IMEI；iOS：idfa
		<variable name="deviceId1" type="string" order="6"/> android：mac；iOS：idfa
		<variable name="deviceId2" type="string" order="7"/> android：adid；iOS：idfv
		<variable name="accountId" type="string" order="8"/> 平台账号，需要和数据SDK保持一致。为了防止不同渠道的账号相同，可以使用“渠道_渠道账号ID”的方式。需要和数据SDK保持一致。
		<variable name="roleId" type="string" order="9"/> 游戏内部角色ID，需要和数据SDK保持一致。
	</xbean>
	<table name="logheadinfo" key="long" value="LogHead" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	 
	<!-- 战报 -->
	<xbean name="BattleReportRole">
		<variable name="battlereports" type="map" key="int" value="BattleReport" order="1"/>
	</xbean>
	<table name="battlereportrole" key="long" value="BattleReportRole" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="BattleReportInfo">
		<variable name="id" type="int" order="1"/> 战报id
		<variable name="params" type="list" value="string" order="2"/> 对应的参数
	</xbean>
	<xbean name="BattleReport">
		<variable name="battlereports" type="list" value="BattleReportInfo" order="1"/>
		<variable name="createtime" type="long" order="2"/> 创建时间
	</xbean>
	<table name="battlereport" key="int" value="BattleReport" cacheCapacity="100" lock="battlereportlock"/> 活动的总战报 lock是活动id
	
	 <!-- 称谓保存的信息 -->
	<xbean name="TitleInfo">
		<variable name="titleid" type="int" order="1"/> 称谓id
		<variable name="titlename" type="string" order="2"/> 称谓名
		<variable name="availtime" type="long" order="3"/>剩余有效时间
	</xbean>
	
	<!-- 基础战斗属性 -->
	<xbean name="BasicFightProperties">
		<variable name="str" type="int" order="1"/>		力量
		<variable name="iq" type="int" order="2"/>		智力
		<variable name="cons" type="int" order="3"/>		体质		
		<variable name="endu" type="int" order="4"/>		耐力
		<variable name="agi" type="int" order="5"/>		敏捷		
	</xbean>
	
	<xbean name="FormBean">
		<variable name="level" type="int" order="1"/>等级
		<variable name="strengthenTimes" type="int" order="2"/> 当前等级强化次数
		<variable name="defendItemId" type="int" order="3"/>灵珠/水晶道具ID
		<variable name="defendAttrs" type="map" key="int" value="float" order="4"/>灵珠/水晶加的属性 key=灵珠/水晶AttrId
	</xbean>
	<xbean name="ShowInfo">
		<enum name="SHOW_PET" value="1"/>
		<variable name="showKey" type="int" order="1"/>	展示的宠物的key
		<variable name="showType" type="int" order="2"/>	1-宠物
	</xbean>
	<xbean name="Properties">
		<variable name="rolename" type="string" order="1"/> 角色名
		<variable name="anonyname" type="string" order="2"/> 匿名
		<variable name="anonyshape" type="int" order="3"/> 匿名造型
		<variable name="usedname" type="list" value="string" order="4"/>  曾用名
		<variable name="plattypestr" type="string" order="5"/>
		<variable name="channel" type="string" order="6"/> 渠道的标识符
		<variable name="level" type="int" order="7"/>	 等级
		<variable name="shape" type="int" order="8"/>  	主角ID(是指游戏中设定的10个角色id)
		<variable name="sex" type="int" order="9"/>      人物性别
		<variable name="exp" type="long" order="10"/>	 	当前经验
		<variable name="school" type="int" order="11"/>	  门派
		<!--注释没用的属性<variable name="schoolvalue" type="int"/> 门派贡献度-->
		<!--注释没用的属性<variable name="faction" type="int"/>      帮派-->
		<!--注释没用的属性<variable name="factionvalue" type="int"/> 帮派贡献度-->
		<variable name="title" type="int" default="-1" order="12"/>	 称谓
		<variable name="hp" type="int" order="13"/>		气血
		<variable name="uplimithp" type="int" order="14"/>    当前气血上限
		<variable name="wound" type="int" order="15"/> 伤，当前血上限=最大血上限-伤，伤：[0,MaxHp-1]
		<variable name="mp" type="int" order="16"/>		法力
		<variable name="sp" type="int" default="0" order="17"/>    怒气
		<variable name="bfp" type="BasicFightProperties" order="18"/>		
		<variable name="point" type="int" order="19"/>		潜能。未分配点数
		<variable name="smoney" type="long" order="20"/>	储备金
		<variable name="yuanbao" type="int" order="21"/>  通用元宝
		<!--注释没用的属性<variable name="bindingyuanbao" type="int" order="22"/> 绑定元宝-->
		<variable name="allexp" type="long" order="23"/>     玩家出生后获得所有经验
		<variable name="sceneid" type="long" order="24"/>		角色所在场景ID
		<variable name="posx" type="int" order="25"/>		坐标x
		<variable name="posy" type="int" order="26"/>		坐标y
		<variable name="posz" type="int" order="27"/>		坐标z
		<variable name="laststaticsceneid" type="long" order="28"/>		最后一次玩家所在的静态场景ID
		<variable name="laststaticposx" type="int" order="29"/>				最后一次玩家所在的静态场景x
		<variable name="laststaticposy" type="int" order="30"/>				最后一次玩家所在的静态场景y
		<variable name="laststaticposz" type="int" order="31"/>				最后一次玩家所在的静态场景z
		<variable name="fightpetkey" type="int" default="-1" order="32"/>  当前战斗宠物
		<variable name="showInfo" type="ShowInfo" order="33"/>  当前展示信息
		<variable name="syssettings" type="map" key="int" value="int" order="34"/> 系统设置
		<variable name="titles" type="map" key="int" value="TitleInfo" order="35"/> 拥有的称谓列表
		<variable name="firstPetid" type="int" default="0" order="36"/> 新手引导选取的第一个宠物id
		<variable name="petskillpoint" type="int" order="37"/> 宠物技能点
		
		<variable name="defultform" type="int" order="38"/> 默认阵法
		<variable name="formationsMap" type="map" key="int" value="FormBean" order="39"/>key=阵法id  value=阵法等级
<!--  
		<variable name="formations" type="int" /> 阵法，按位保存，一共10个阵法
		<variable name="formationElements" type="list" value="int" /> 阵法元素
-->
		<variable name="factionKey" type="long" default="-1" order="40"/>角色对应的帮派key
		<variable name="createFactionKey" type="long" default="-1" order="41"/>角色创建的帮派key
		<variable name="onlineTime" type="long" default="-1" order="42"/> 角色上次登录时间
		<variable name="offlineTime" type="long" default="-1" order="43"/> 角色上次离线时间
		<variable name="stone" type="int" order="44"/>神石
		<variable name="createtime" type="long" order="45"/> 角色创建时间
		<variable name="sumonlinetime" type="long" order="46"/> 累积在线时长,ms,这个时长只有在下线的时候才会改变，其他情况还需要通过上次登录时间进行计算
		<variable name="userid" type="int" order="47"/> 帐号角色id
		<variable name="giveRoseNum" type="int" order="48"/> 角色送出花的总数
		<variable name="deletetime" type="long" order="49"/> 角色被删除的时间,如果角色没有被删除,这个值为0
		<variable name="lastloginip" type="int" order="50"/> 
		<variable name="platformUid" type="string" order="51"/> userid在平台的唯一id
		<variable name="campType" type="int" order="52"/> 0=中立  1= 北府 2= 南廷 (没用 使用CampRole)
		<variable name="rolezonghemaxscore" type="int" default="0" order="53"/> 人物综合实力历史最高评分
		<variable name="fightPowers" type="map" key="int" value="int" order="54"/>	战斗力组合 key=参与计算的类型 1-佣兵 2-宠物 3-装备 4-技能 5-天赋
		<variable name="rongyu" type="int" order="55"/> 荣誉值/功德值
		<variable name="holidayScore" type="int" order="56"/> 节日积分/代币的一种
		<variable name="roleequipmaxscore" type="int" order="57"/> 人物装备历史最高评分
		<variable name="energy" type="int" order="58"/> 活力值
		<variable name="resetenergytime" type="long" order="59"/> 重置活力值时间
		<variable name="zhangongscore" type="int" order="60"/> 战功积分
		<variable name="hunbi" type="int" order="61"/>分解宠物返还魂币
		<variable name="transformTime" type="long" order="62"/> 上次转职的时间
		<variable name="aimSchool" type="int" order="63"/> 转职目标门派
		<variable name="aimShape" type="int" order="64"/> 转职目标造型
		<variable name="godwingmaxscore" type="int" order="65"/> 灵翼历史最高评分
	</xbean>
	
	<table name="properties" key="long" value="Properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock" autoIncrement="true"/> liuchen
	
	<xbean name="TransfromInfo" any="true">
		<variable name="transformid" type="int" default="0" order="1"/> 人物变身时的shape
		<variable name="questid" type="int" default="0" order="2"/> 
		<variable name="validdate" type="long" default="0" order="3"/> 人物变身时的时限
		<variable name="transfromfuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="4"/>
	</xbean>
	<table name="transfromroles" key="long" value="TransfromInfo" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/>
	
	<xbean name="ChatMsgTime">
		<variable name="lastworldchattime" type="long" order="1"/> 角色上次世界聊天的时间
		<variable name="lastCurrentChatTime" type="long" order="2"/>角色上次当前频道聊天的时间
		<variable name="lastFamilyChatTime" type="long" order="3"/>角色上次家族频道聊天的时间
		<variable name="lastFactionChatTime" type="long" order="4"/>角色上次帮派频道聊天的时间
		<variable name="lastCampChatTime" type="long" order="5"/>角色上次阵营频道聊天的时间
		<variable name="lastTopicChatTime" type="long" order="6"/>角色上次话题频道聊天的时间
	</xbean>
	<table name="chatmsgtime" key="long" value="ChatMsgTime" lock="rolelock" cacheCapacity="8192" cachehigh="512" cachelow="256" persistence="MEMORY"/>
	
	<xbean name="TopicInfo">
		<variable name="teamName1" type="string" order="1"/> 队伍一名
		<variable name="teamName2" type="string" order="2"/> 队伍二名
		<variable name="teamRoles1" type="list" value="long" order="3"/> 队伍一人员
		<variable name="teamRoles2" type="list" value="long" order="4"/> 队伍二人员
		<variable name="topicName" type="string" order="5"/> 话题名称

	</xbean>
	<table name="topicinfo" key="int" value="TopicInfo" cacheCapacity="8192" cachehigh="512" cachelow="256"/>
	
	<xbean name="TopicRole">
		<variable name="teamid" type="int" order="1"/> 队伍id
		<variable name="name" type="string" order="2"/> 匿名名称
	</xbean>
	<table name="topicrole" key="long" value="TopicRole" lock="rolelock" cacheCapacity="8192"/>

	<xbean name="OfflineFuture" any="true">
		<variable name="timefuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/> 人物下线后的计时任务
	</xbean>
	<table name="offlinefuture" key="long" value="OfflineFuture" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/> key 是roleid
	
	<xbean name="OnlinerefreshFuture" any="true">
		<variable name="furvec" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>
	</xbean>
	<table name="onlinerefresh" key="long" value="OnlinerefreshFuture" cacheCapacity="8192" cachehigh="512" cachelow="256" lock="rolelock" persistence="MEMORY"/>
	
	<xbean name="PetInfo">
		<variable name="id" type="int" order="1"/>          宠物ID 
		<variable name="key" type="int" order="2"/>         在宠物栏、仓库、商会柜台里的key
		<variable name="uniqid" type="long" order="3"/>     宠物唯一ID 
	    <variable name="name" type="string" order="4"/>     名称
		<variable name="level" type="int" order="5"/>	      等级    	*short够了
		<variable name="bfp" type="BasicFightProperties" order="6"/>   基础战斗属性
		<variable name="hp" type="int" order="7"/>          当前气血
		<variable name="mp" type="int" order="8"/>          当前法力
		<variable name="exp" type="long" order="9"/>         当前经验
		<variable name="attackapt" type="int" order="10"/>  攻击资质   *short够了
		<variable name="defendapt" type="int" order="11"/>  防御资质		*short够了
		<variable name="phyforceapt" type="int" order="12"/>体力资质   *short够了
		<variable name="magicapt" type="int" order="13"/>   法力资质   *short够了
		<variable name="speedapt" type="int" order="14"/>   速度资质   *short够了 	 	
		<variable name="dodgeapt" type="int" order="15"/>   躲闪资质		*short够了 	 	
		<variable name="bornattackapt" type="int" order="16"/>  出生时攻击资质	*short够了 	 	
		<variable name="borndefendapt" type="int" order="17"/>  出生时防御资质	*short够了 
		<variable name="bornphyforceapt" type="int" order="18"/>出生时体力资质	*short够了 
		<variable name="bornmagicapt" type="int" order="19"/>   出生时法力资质	*short够了 
		<variable name="bornspeedapt" type="int" order="20"/>   出生时速度资质	*short够了 
		<variable name="borndodgeapt" type="int" order="21"/>   出生时躲闪资质	*short够了 
		<variable name="kind" type="int" order="22"/>        宠物类型 野生、宝宝	*byte够了
		<!--EffectPet-->
		<variable name="effects" type="map" key="int" value="float" order="23"/> key = effect type id
		<variable name="finalattrs" type="map" key="int" value="float" capacity="50" order="24"/> key = attr type
		<!--EffectPet-->
		<variable name="buffPet" type="BuffAgent" order="25"/>	 buff
		<variable name="petScore" type="int" order="26"/> 宠物评分
		<variable name="ownerID" type="long" order="27"/> 宠物的主人
		<variable name="skills" type="list" value="PetSkill" capacity="8" order="28"/> 宠物通过学习获得技能
		<variable name="starId" type="int" default="1" order="29"/> 星级（天2对应的成长值）
		<variable name="stalltime" type="long" order="30"/> 成功交易时候的交易时间
		<variable name="isdedicated" type="boolean" default="false" order="31"/> 是否专用宠物
		<variable name="awakelevel" type="int" default="1" order="32"/> 觉醒等级
		<variable name="awakeexp" type="int" order="33"/> 觉醒经验条
		<variable name="feedskillattrs" type="map" key="int" value="int" order="34"/> 宠物炼妖升级的技能key-属性id value-等级
		<variable name="understandnum" type="int" order="35"/> 领悟技能计数
		<variable name="islocked" type="boolean" order="36"/> 是否上锁
		
		<variable name="affix" type="map" key="int" value="int" order="37"/> 词缀 key-位置 value-itemid
		<variable name="talentskills" type="list" value="PetSkill" capacity="4" order="38"/> 宠物的天赋技能 （出生带的技能和宠物炼妖获得技能）
		<variable name="petrefine" type="PetRefine" order="39"/> 宠物炼妖随到的信息
		
		<variable name="normalskills" type="list" value="PetSkill" capacity="1" order="40"/> 宠物普通攻击技能
		<variable name="character" type="map" key="int" value="int" order="41"/> 宠物性格
		
		<variable name="speedupvalue" type="int" order="42"/> 御风值
		<variable name="speeduplevel" type="int" order="43"/> 御风等级
		<variable name="isbinding" type="boolean" order="44"/> 是否是绑定宠物(首次抽宠、主线任务五选一)
	</xbean>
	<xbean name="PetRefine">
		<variable name="skillid" type="list" value="int" order="1"/> 技能id
		<variable name="changeapt" type="map" key="int" value="int" order="2"/> 发生变化的资质
		<variable name="oldapt" type="map" key="int" value="float" order="3"/> 变化前的资质
	</xbean>
	<xbean name="PetSkill">
		<variable name="skillId" type="int" order="1"/> 技能id
		<variable name="expiretime" type="long" default="-1" order="2"/> 到期时间，没有时限的技能为-1
		<variable name="skillExp" type="int" order="3"/> 技能当前的经验
		<variable name="skillType" type="int" order="4"/> 0=先天技能  1=后天通过技能书打上去的技能
		<variable name="skilledge" type="int" order="5"/> 当前技能随处的技能缘
		<variable name="addskilledges" type="list" value="int" capacity="6" order="6"/> 当前技能被哪些高级技能添加等级了
		<variable name="addskilltime" type="long" order="7"/> 拥有技能的时间
	</xbean>
	<xbean name="Pets">	
		<variable name="capacity" type="int" order="1"/>
		<variable name="nextid" type="int" order="2"/>		下一个id
		<variable name="petMap" type="map" key="int" value="PetInfo" capacity="15" order="3"/> 宠物数据表
		<variable name="petstoremap" type="map" key="int" value="PetInfo" capacity="15" order="4"/> 宠物仓库表
		<variable name="petstorenum" type="int" order="5"/> 宠物仓库格子数量
		<variable name="shanxianpets" type="set" value="int" order="6"/> 闪现技能的宠物key数组
		<variable name="chapters" type="map" key="int" value="Chapter" order="7"/> 天书章节信息  
		<variable name="extranum" type="int" order="8"/> 抽宠额外奖励计数
		<variable name="fightshanxianpets" type="list" value="int" order="9"/>可在战斗中闪现的宠物key		
	</xbean>
	<xbean name="Chapter">	天书章节信息  2017-10-30 宠物调整
		<variable name="unlockpets" type="map" key="int" value="boolean" order="1"/> 已解锁的宠物 2017-10-30 宠物调整 解锁的宠物才会出现在抽宠奖池. key=宠物id value=状态,用于客户端展示new
		<variable name="awardState" type="boolean"  order="2"/>
	</xbean>
	<xbean name="tempPets">	
		<variable name="nextId" type="int" order="1"/>		下一个id
		<variable name="Number" type="int" order="2"/>		记录扭4连抽的次数
		<variable name="twistEggInfo" type="map" key="int" value="PetInfo" capacity="15" order="3"/> 扭蛋获得的宠物信息
	</xbean>
	<table name="pet" key="long" value="Pets" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/> 
	<table name="twistegg" key="long" value="tempPets" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>  宠物扭蛋临时存储
		
	<xbean name="XiaKeInfo">	
		<variable name="id" type="int" order="1"/>
		<variable name="level" type="int" order="2"/>	     等级
		<variable name="score" type="int" order="3"/> 
		<variable name="bfp" type="BasicFightProperties" order="4"/>  一级属性
		<variable name="effects" type="map" key="int" value="float" order="5"/> key = effect type id
		<variable name="skills" type="map" key="int" value="int" capacity="15" order="6"/> xiake拥有的战斗技能
		<variable name="finalattrs" type="map" key="int" value="float" capacity="50" order="7"/> key = attr type
		<variable name="buffxiake" type="BuffAgent" order="8"/>	 buff
		
		<!--<variable name="expiration" type="long" order="9"/> 过期时间 -1-永久助战-->
		<!--<variable name="weekfree" type="boolean" order="10"/> 周免费-->
		<variable name="breaklv" type="int" order="11"/> 突破等级
		<!--<variable name="tyoe" type="int" order="12"/> 侠客类型-->
		<variable name="owntype" type="int" order="13"/> 拥有类型
		<variable name="lingfuId" type="int" order="14"/> 灵符方案id
		<variable name="stamps" type="map" key="int" value="Item" order="15"/> 侠客穿戴的印记  key-镶嵌位置
		<!--<variable name="stampsuits" type="list" value="int" order="16"/> 侠客印记套装id-->
	</xbean>

	<xbean name="XiaKeJiuguan">	
		<variable name="tenyearsRemainTime" type="long" order="1"/>
		<variable name="tenyearsYuanbaoTimes" type="int" order="2"/>
		<variable name="tenyearsYuanbaoRefreshTime" type="long" order="3"/>
		<variable name="tenyearsRemainNum" type="int" order="4"/>	
		<variable name="tenyearsRemainNumRefreshTime" type="long" order="5"/> 
		<variable name="hundredyearsRemainTime" type="long" order="6"/> 
		<variable name="hundredyearsYuanbaoTimes" type="int" order="7"/>
		<variable name="hundredyearsYuanbaoRefreshTime" type="long" order="8"/>
        <variable name="thousandyearsRemainTime" type="long" order="9"/>
		<variable name="thousandyearsYuanbaoTimes" type="int" order="10"/>
		<variable name="thousandyearsYuanbaoRefreshTime" type="long" order="11"/>
		<variable name="firstClick" type="map" key="int" value="int" order="12"/>
		<variable name="gaojiTimes" type="int" order="13"/>人物抽奖的次数 终身不清零
		<variable name="chuanqiTimes" type="int" order="14"/>
		<variable name="shilianTimes" type="int" order="15"/>
		<variable name="lastEpicTime" type="long" order="16"/>上次史诗抽卡时间
		<variable name="epicTimes" type="int" order="17"/> 史诗抽卡次数
	</xbean>
	<xbean name="ForMationPlan">
		<variable name="fightxiakes" type="list" value="int" order="1"/>
	</xbean>
	<xbean name="XiaKeColumn">
		<variable name="fightxiakes" type="list" value="int" capacity="15" order="1"/>
		<variable name="xiakes" type="map" key="int" value="XiaKeInfo" capacity="15" order="2"/>
		<variable name="formationplan" type="map" key="int" value="ForMationPlan" capacity="15" order="3"/> 
		<variable name="formationindex" type="int" order="4"/> 
		<variable name="xiakeScore" type="int" order="5"/> 参战侠客总评分
		<variable name="weekfreexiakes" type="list" value="int" order="6"/> 周免侠客列表
	</xbean>
	<table name="xiakecolumns" key="long" value="XiaKeColumn" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/> 
  	<table name="xiakejiuguan" key="long" value="XiaKeJiuguan" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/> 
  
	<!--侠客传功 start-->
    <xbean name="ChuangongProp">传功属性
		<variable name="color" type="int" order="1"/>1-绿色 2-蓝色 3-紫色 4-金色
		<variable name="star" type="int" order="2"/>星级1-6星
		<variable name="curexp" type="int" order="3"/>侠客传功经验
	</xbean>
	<!--侠客传功 end-->
	
  	<!--侠客积分榜相关表-->
	<xbean name="xiakeScoreRankList">
		<variable name="records" type="list" value="MarshalXiakeScoreRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="MarshalXiakeScoreRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="rolename" type="string" order="2"/> 玩家名字
		<variable name="rolelv" type="int" order="3"/> 玩家等级
		<variable name="xiakescore" type="int" order="4"/> 侠客总评分
	</xbean>
	<!--侠客排行榜的id=1，只有一条记录一个list-->
	<table name="xiakescorelist" key="int" value="xiakeScoreRankList" cacheCapacity="1"/>
	
	<!-- 多倍时间相关的表-->
	<xbean name="MultiExpInfo">
		<variable name="multiexptime" type="map" key="int" value="int" order="1"/> key 为buff类型，即为buffid， value为剩余的可领取的时间，单位为秒
		<variable name="remainnum" type="int" order="2"/> 本周可以使用的个数
		<variable name="dupdannum" type="int" order="3"/>本周可以使用的双倍丹的个数
		<variable name="lastbacktime" type="long" order="4"/> 上次返还多倍时间的时间
		<variable name="refreshtime" type="long" order="5"/> 刷新的时间
	</xbean>
	<table name="multiexp" type="map" key="long" value="MultiExpInfo" cacheCapacity="7000" foreign="key:properties" lock="rolelock"/> 保存角色多倍时间的状态
	<!-- 多倍时间相关的表定义 end-->  
	
	<table name="roleonoffstate" type="map" key="long" value="int" cacheCapacity="8192" lock="rolelock" persistence="MEMORY"/> key是roleid,value是state
	
	<xbean name="Decision">
		<variable name="operateType" type="int" order="1"/> 	操作类型
		<variable name="operator" type="int" order="2"/> 		操作方的战斗单位索引
		<variable name="aim" type="int" order="3"/>			目标的战斗单位索引
		<variable name="operateID" type="int" order="4"/> 	操作数，如使用物品的物品ID
		<variable name="isAuto" type="boolean" default="false" order="5"/> 	操作是否是自动
		<variable name="isPetShanxian" type="boolean" default="false" order="6"/> 	判断是否是闪现
	</xbean>
	
	<xbean name="Fighter">
		<variable name="uniqueid" type="long" order="1"/>			ID：如果是角色，这里是roleId；如果是宠物或者怪物，这里是baseId
		<variable name="school" type="int" order="2"/>			职业
		<variable name="prefix" type="int" order="3"/>			前缀
		<variable name="fightername" type="string" order="4"/>	名称
		<variable name="subtype" type="int" order="5"/>	子类型
		<variable name="fighterType" type="int" order="6"/>		战斗单位的类型
		<variable name="battleindex" type="int" order="7"/> 		战斗者的战斗单位索引，即fighterId
		<variable name="mappingIndex" type="int" order="8"/>		如果是宠物则为主人的索引，如果是玩家则为宠物的索引
		<variable name="fighterkey" type="int" order="9"/> 		战斗者key,fighterId可能会重复，不能唯一确定一个战斗者，此自增的key不会重复
		<variable name="isHost" type="boolean" order="10"/>  是否是战斗的主方
		<variable name="round" type="int" default="0" order="11"/> 战斗者进入战斗的回合数
		<variable name="positionX" type="int" order="12"/> 战斗者位置x，位置为阵营内的相对位置，一个阵营的坐标为5*4的位置矩阵
		<variable name="positionY" type="int" order="13"/> 战斗者位置y
		<variable name="iniHP" type="int" order="14"/> 		战斗者的初始hp
		<variable name="iniWound" type="int" default="0" order="15"/> 		战斗者的初始伤
		<variable name="iniMP" type="int" order="16"/> 		战斗者的初始mp
		<variable name="iniSP" type="int" order="17"/> 		战斗者的初始怒气
		<variable name="actioncount" type="map" key="int" value="int" order="18"/>记录一场战斗的法术物理的攻击和受击次数
		<variable name="fightedpets" type="map" key="int" value="int" order="19"/>当此fighter为角色时，记录其战斗过的宠物，key为petkey,value是result,逃跑,击飞,召回
		<variable name="initAttrs" type="map" key="int" value="float" order="20"/>记录角色进入战斗时的初始值
		<variable name="useditems" type="map" key="int" value="int" order="21"/>记录在此场战斗中用过的物品
		<variable name="initfightpet" type="int" order="22"/> 记录进入场战斗时的初始参战宠 0=进战斗时没有参战宠
		<variable name="skillcooldown" type="map" key="int" value="int" order="23"/> 技能cd key-技能id value-剩余次数
		<variable name="isMissDamageRound" type="boolean" order="24"/>  每回合是否闪避伤害
		<variable name="shanxianlist" type="list" value="int" order="25"/> 角色为ROLE有用 存可以闪现的宠物petkey
		<variable name="xkbreaklv" type="int" order="26"/> 角色为ROLE有用 存可以闪现的宠物petkey
		
		<enum name="FIGHTER_ROLE" value="1"/>			角色
		<enum name="FIGHTER_PET" value="2"/>			宠物
		<enum name="FIGHTER_MONSTER" value="3"/>		怪物		
		<enum name="FIGHTER_NPC" value="4"/>		特殊战斗NPC（最多4个，11-14,25-28号战斗者为特殊NPC）
		
		<enum name="PHY_ATTACK" value="1"/>			一场战斗进行了多少次物理攻击，包括多次技能连击、合击
		<enum name="PHY_HURT" value="2"/>			一场战斗受到了多少次物理伤害，包括保护
		<enum name="MAGIC_SKILL" value="3"/>		一场战斗释放了多少次法术技能
		<enum name="MAGIC_HURT" value="4"/>			一场战斗受到了多少次法术伤害
		<enum name="SCHOOL_SKILL" value="5"/>		一场战斗职业技能释放次数
	</xbean>
	
	<xbean name="Protectors">
		<variable name="protectorList" type="list" value="int" order="1"/>
	</xbean>

	<xbean name="BattleResult">
		<variable name="battleid" type="long" order="1"/>									战斗ID
		<variable name="taskid" type="int" order="2"/>									  可能关联的任务id
		<variable name="configId" type="int" default="0" order="3"/>			战斗配置ID，默认为0时不是通过战斗配置new的ID
		<variable name="environment" type="int" order="4"/>              战场环境
		<variable name="phase" type="int" order="5"/>										  战斗的阶段
		<variable name="battletype" type="int" order="6"/>								战斗类型
		<variable name="areatype" type="int" order="7"/>									练功区类型
		<variable name="areaconf" type="int" order="8"/>									练功区配置值
		<variable name="hostform" type="int" order="9"/>   								主方阵法
		<variable name="guestform" type="int" order="10"/>   							客方阵法
		<variable name="monstertype" type="int" order="11"/>								怪物类型
		<variable name="roleids" type="map" key="long" value="int" order="12"/>			所有参战的角色ID : 角色的战斗索引
		<variable name="fighters" type="treemap" key="int" value="Fighter" order="13"/>	所有的参战者 战斗索引 ： 战斗者 按索引排序
		<variable name="skipedDeadFighters" type="set" value="int" order="14"/> 本回合因为死亡而未出手的战斗者，出手结束清除
		<variable name="monsters" type="map" key="int" value="Monster" order="15"/> 所有在该场战斗中生成的怪物/NPC，key为fighterId
		<variable name="failedMonsters" type="list" value="FailedMonster" order="16"/> 失败的怪物（包括己方客方）
		<variable name="inifighters" type="treemap" key="int" value="Fighter" order="17"/> 把参战者的状态在战斗前保存一份,擂台pk会用到
		<variable name="audience" type="map" key="long" value="int" order="18"/>					观战的roleid battleindex
		<variable name="watchers" type="treemap" key="int" value="Fighter" order="19"/>
		<variable name="monsterid" type="long" default="-1" order="20"/> 明雷怪id 
		<variable name="round" type="int" default="1" order="21"/>				战斗当前的回合数
		<variable name="roundTime" type="long" order="22"/>								PRoundStart后是本回合的开始时间;PPlayScript后是播放开始的时间
		<variable name="scriptPlayTime" type="long" default="1000" order="23"/>           脚本播放时间（ms），根据脚本计算出来的播放时间，是脚本播放的最短时间，最短1秒
		<variable name="decisions" type="map" key="int" value="Decision" order="24"/>		战斗单元决策结果
		<variable name="feedbacks" type="set" value="long" order="25"/> roleid				角色的反馈记录
		<variable name="battleResult" type="int" default="2" order="26"/> 战斗是否结束及战斗结果，参考BattleField.BATTLE_XXX,默认为2（BATTLE_NOT_END）
		<variable name="roundResult" type="map" key="int" value="int" order="27"/>			战斗单位：战斗结果
		<variable name="roundEndAIAction" type="list" value="int" order="28"/> 在回合末结算时触发的服务器AI动作，将在下一回合读秒完成后先被执行
		<variable name="protectorMap" type="map" key="int" value="Protectors" order="29"/>	被保护人：保护者列表
		<variable name="battleAIs" type="map" key="int" value="int" order="30"/>挂在战场上的AI
		<variable name="battledatas" type="map" key="int" value="float" order="31"/> 保存战斗相关的一些数据
	</xbean>
	
	<xbean name="BattleHpChange">
		<variable name="opfighterid" type="int" order="1"/>
		<variable name="aimfighterid" type="int" order="2"/>
		<variable name="hpchange" type="int" order="3"/>
	</xbean>
	
	<xbean name="RelationBuffs">
		<variable name="usedBuffs" type="list" value="int" order="1"/> value=buffid
	</xbean>	
	
	<xbean name="BattleInfo" any="true">
		<variable name="battleid" type="long" order="1"/>									战斗ID
		<variable name="configId" type="int" default="0" order="2"/>			战斗配置ID，默认为0时不是通过战斗配置new的ID
		<variable name="background" type="int" default="0" order="3"/>		战斗地图
		<variable name="bgm" type="int" default="0" order="4"/>						背景音乐
		<variable name="environment" type="int" order="5"/>              战场环境
		<variable name="envchangefrom" type="int" order="6"/>            环境改变来源（0 = 场外， 1 = 场内）
		<variable name="phase" type="int" order="7"/>										  战斗的阶段
		<variable name="round" type="int" default="0" order="8"/>				战斗当前的回合数
		<variable name="canrunaway" type="boolean" default="true" order="9"/> 本场战斗是否能逃跑
		<variable name="autokey" type="int" default="0" order="10"/>				战斗者key，fighterId可能会重复，不能唯一确定一个战斗者，此自增的key不会重复
		<variable name="battlelevel" type="int" default="0" order="11"/>   战斗等级
		
		<variable name="battletype" type="int" order="12"/>								战斗类型
		<variable name="areatype" type="int" order="13"/>									练功区类型
		<variable name="areaconf" type="int" order="14"/>									练功区配置值
		<variable name="monsterid" type="long" default="-1" order="15"/>   明雷怪npckey
		<variable name="monstertype" type="int" default="-1" order="16"/>	怪物类型
		<variable name="battleEndHandlers" type="vector" value="ares.logic.battle.BattleEndHandler" capacity="2" order="17"/> 处理战斗结束的handler
		
		<variable name="hostform" type="int" order="18"/>   								主方阵法
		<variable name="guestform" type="int" order="19"/>   							客方阵法
		<variable name="hostformLevel" type="int" order="20"/>   						主方阵法等级
		<variable name="guestformLevel" type="int" order="21"/>   						客方阵法等级
		<variable name="hostDefendAttrs" type="map" key="int" value="float" order="22"/> 主方阵法灵珠/水晶属性
		<variable name="guestDefendAttrs" type="map" key="int" value="float" order="23"/> 客方阵法灵珠/水晶属性
		<variable name="roleids" type="map" key="long" value="int" capacity="10" order="24"/>			所有参战的角色ID : 角色的战斗索引
		<variable name="fighters" type="treemap" key="int" value="Fighter" capacity="30" order="25"/>	所有的参战者 战斗索引 ： 战斗者 按索引排序
		<variable name="fighterObjects" type="map" key="int" value="ares.logic.battle.Fighter" capacity="30" order="26"/>  包装好的Fighter类，战斗开始时直接创建完，不用每次用的时候再new,注意使用前要锁rolelock
		<variable name="skipedDeadFighters" type="set" value="int" capacity="10" order="27"/> 本回合因为死亡而未出手的战斗者，出手结束清除
		<variable name="monsters" type="map" key="int" value="Monster" capacity="30" order="28"/> 所有在该场战斗中生成的怪物/NPC，key为fighterId
		<variable name="failedMonsters" type="list" value="FailedMonster" capacity="30" order="29"/> 失败的怪物（包括己方客方）
		<variable name="inifighters" type="treemap" key="int" value="Fighter" capacity="10" order="30"/> 把参战者的状态在战斗前保存一份,擂台pk会用到
		<variable name="audience" type="map" key="long" value="int" capacity="30" order="31"/>					观战的roleid battleindex
		<variable name="watchers" type="treemap" key="int" value="Fighter" capacity="30" order="32"/>
		<variable name="offlineroleids" type="list" value="long" capacity="10" order="33"/> 战斗中掉线的角色，不能发送协议

		<variable name="roundTime" type="long" order="34"/>								PRoundStart后是本回合的开始时间;PPlayScript后是播放开始的时间
		<variable name="scriptPlayTime" type="long" default="1000" order="35"/>           脚本播放时间（ms），根据脚本计算出来的播放时间，是脚本播放的最短时间，最短1秒
		<variable name="decisions" type="map" key="int" value="Decision" capacity="20" order="36"/>		战斗单元决策结果
		<variable name="feedbacks" type="set" value="long" capacity="20" order="37"/> roleid				角色的反馈记录
		<variable name="battleResult" type="int" default="2" order="38"/> 战斗是否结束及战斗结果，参考BattleField.BATTLE_XXX,默认为2（BATTLE_NOT_END）
		<variable name="roundResult" type="map" key="int" value="int" capacity="30" order="39"/>			战斗单位：战斗结果
		<variable name="protectorMap" type="map" key="int" value="Protectors" capacity="10" order="40"/>	被保护人：保护者列表
		<variable name="autoOpTimeout" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="41"/>	自动释放超时检测
		<variable name="timeout" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="42"/>	超时检测
		<variable name="battleAIs" type="list" value="BattleAI" capacity="30" order="43"/> 挂在战场上的AI
		<variable name="engine" type="ares.script.FightJSEngine" order="44"/> 用于本场战斗的JS引擎
		<variable name="fighterChangedAttrs" type="map" key="int" value="ares.logic.battle.ActionChangedAttrs" capacity="30" order="45"/> 战斗者每个回合改变的属性,key=fighterId
		<variable name="battledatas" type="map" key="int" value="float" order="46"/> 保存战斗相关的一些数据
		<variable name="fieldfighter" type="ares.logic.battle.Fighter" order="47"/> 战场虚拟的Fighter，为战场技能而用，虚拟数据的来源是此战斗中的一个怪
		<variable name="endprocedures" type="list" value="BattleEndProcedure" capacity="10" order="48"/> 战斗者出战斗时执行的Procedure
		<variable name="resultItems" type="list" value="ares.logic.battle.NewResultItem" capacity="200" order="49"/> 整场战斗的demo
		<variable name="itemTimeList" type="list" value="int" capacity="40" order="50"/> 整场战斗的demo时间
		<variable name="reliveacts" type="vector" value="ares.logic.battle.act.Act" capacity="5" order="51"/> 复活后要出手的行动
		<variable name="allhpchanges" type="vector" value="BattleHpChange" capacity="80" order="52"/> 战斗中所有对hp的影响
		<variable name="deadMonsters" type="list" value="long" order="53"/>杀死的所有怪物
		<variable name="waitingPets" type="map" key="int" value="int" order="54"/> 等待进入战斗的宠物 petindex, petkey
		<variable name="starttime" type="long" order="55"/> 战斗开始时间
		<variable name="battlemaxround" type="int" order="56"/> 战斗的最大回合数 如果不设置默认为200回合
		<variable name="replyid" type="long" order="57"/> 自动保存的战斗录像id，默认0则未记录
		<variable name="xunluonpcid" type="long" order="58"/>									巡逻npcid
		<variable name="battlerelatedata" type="map" key="int" value="int" capacity="50" order="59"/> 重新定义一个集合用于存储战斗相关信息，键值参考类BattleRelateData
		<variable name="bossbattlecg" type="set" value="long" capacity="5" order="60"/>
		<variable name="bossbattlecgtimeout" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="61"/>	boss战自动战斗开始超时检测
		<variable name="hostdefendstarid" type="int"  order="62"/> 主方阵法灵珠/水晶id
		<variable name="guestdefendstarid" type="int" order="63"/> 客方阵法灵珠/水晶id
		<variable name="shareBossKey" type="long" order="64"/>									共享血量boss表的key
		<variable name="shareBossFighter" type="ares.logic.battle.Fighter" order="65"/>  共享血量boss怪
		<variable name="usedrelationbuff" type="map" key="int" value="RelationBuffs" order="66"/> 战斗中特殊技能已使用的关联buffid key=与策划约定的特殊技能类型
		<variable name="shanxianPetList" type="list" value="int"  order="67"/> 需要闪现出来的index
		
		
		<enum name="PHASE_GOING" value="0"/>			战斗进行中
		<enum name="PHASE_WAITOPERATION" value="1"/>	等待角色选择操作
		<enum name="PHASE_WAITFEEDBACK" value="2"/>		等待角色反馈操作结束
		
		<enum name="AREA_BATTLEHIDE" value="1"/>	暗雷
		<enum name="AREA_BATTLESHOW" value="2"/>	明雷	
		<enum name="MAX_ROUNDNUM" value="200"/>		战斗最多持续多少回合
		
		<enum name="DATA_MONSTER_NUM" value="1"/>		进入战斗时怪物的个数，只统计客方怪物的数量，不算主方怪物
		<enum name="DATA_MONSTER_CHIEF_NUM" value="2"/>		进入战斗时怪物头领的个数，只统计客方怪物的数量，不算主方怪物
		<enum name="DATA_HOST_ROLE_NUM" value="3"/>		进入战斗时主队角色的个数
		<enum name="DATA_GUEST_ROLE_NUM" value="4"/>		进入战斗时客队角色的个数
		<enum name="DATA_HOST_ROLE_AVERAGE_LEVEL" value="5"/>		进入战斗时主队角色的平均等级
		<enum name="DATA_GUEST_ROLE_AVERAGE_LEVEL" value="6"/>		进入战斗时主队角色的平均等级
		<enum name="DATA_HOST_AVERAGE_CREDIT" value="7"/>		进入战斗时主队角色的平均切磋积分
		<enum name="DATA_GUEST_AVERAGE_CREDIT" value="8"/>		进入战斗时客队角色的平均切磋积分
		<enum name="DATA_MONSTER_AVERAGE_LEVEL" value="9"/>		入战斗时客方怪物的平均等级
		<enum name="DATA_HOST_ROLE_MAX_LEVEL" value="10"/>		进入战斗时，主方角色的最大等级
		<enum name="DATA_HOST_ROLE_MIN_LEVEL" value="11"/>		进入战斗时，主方角色的最小等级
		<enum name="DATA_BATTLE_CONFIG_LEVEL" value="12"/>		进入战斗时，如果战斗配置表里有等级公式，计算出的等级	
		<enum name="DATA_HOST_DEATH" value="13"/>		战斗主方死亡人数
		<enum name="DATA_GUEST_DEATH" value="14"/>		战斗客方死亡人数
		<enum name="DATA_HOST_TASKCHAIN_DONENUM" value="15"/>	六界轶事已完成次数
		<enum name="DATA_HOST_FACTION_TREASURY_FLOOR" value="16"/>	帮派宝库层数
		<enum name="DATA_HOST_ROLE_STARTBATTLE_LEVEL" value="17"/>	开启战斗的玩家等级（有队伍是队长等级，没有队伍是单人等级）
		<enum name="DATA_RANDOM_BATTLE_ROLLNUM" value="18"/>	随机战斗roll点数
	
	</xbean>
	
	<xbean name="BattleEndProcedure" any="true">
		<variable name="fighterId" type="int" order="1"/>	战斗者ID，（现在应该是只有角色，将来还可能会有宠物） 
		<variable name="endprocedure" type="xdb.Procedure" order="2"/>	战斗者出战斗时执行的Procedure
	</xbean>
	
	<table name="battle" key="long" value="BattleInfo" persistence="MEMORY" cacheCapacity="8192" autoIncrement="true"/>Key 是 battleid; liuchen
	<table name="roleid2battleid" key="long" value="long" lock="rolelock" cacheCapacity="8192" persistence="MEMORY"/> key是roleid value是角色所在战场 liuchen
	<table name="watcherid2battleid" key="long" value="long" lock="rolelock" cacheCapacity="8192" persistence="MEMORY"/> key是观战者的id
	
	<!--战斗录像 start-->
	
	<xbean name="WatchReplyRole" any="true">
		<variable name="replyId" type="long" order="1"/>
		<variable name="protocolIndex" type="int" order="2"/>
		<variable name="future" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="3"/>
	</xbean>
	
	<table name="watchreplyroles" key="long" value="WatchReplyRole" lock="rolelock" cacheCapacity="8192" persistence="MEMORY"/>
	
	<xbean name="BattleReplyRole">
		<variable name="replyids" type="list" value="long" order="1"/>
	</xbean>
	
	<table name="battlereplyroles" key="long" value="BattleReplyRole" lock="rolelock" cacheCapacity="8192"/>
	
	<xbean name="BattleReplyProtocol">
		<variable name="time" type="long" order="1"/>
		<variable name="protcolClass" type="string" order="2"/>
		<variable name="protcolOctets" type="binary" order="3"/>
	</xbean>
	<xbean name="BattleReply">
		<variable name="battleid" type="long" order="1"/>
		<variable name="rolenum" type="int" order="2"/>  多少人拥有这个录像
		<variable name="battletime" type="long" order="3"/>
		<variable name="protocols" type="list" value="BattleReplyProtocol" order="4"/>
		<variable name="timeout" type="long" order="5"/>  过期时间, 0为永久
		<variable name="roles" type="set" value="long" order="6"/> 记录录像中所有role
	</xbean>
	<table name="battlereplys" key="long" value="BattleReply" cacheCapacity="8192" autoIncrement="true"/>
	
	<xbean name="ReplyLike">
		<variable name="roles" type="set" value="long" order="1"/>  已点赞的人
	</xbean>
	<table name="replylikes" key="long" value="ReplyLike" cacheCapacity="8192"/> //录像点赞 key=replyid
	
	
	<!--战斗录像 end-->
	
	<!-- 活动战斗录像 start-->
	<xbean name="ActReplyInfo">
		<variable name="replyid" type="long" order="1"/> 录像id
		<variable name="play" type="int" order="2"/> 场次
		<variable name="winroleid" type="long" order="3"/> 胜利方队长id
		<variable name="winteamname" type="string" order="4"/> 队伍名称
		<variable name="loseroleid" type="long" order="5"/> 失败方队长id
		<variable name="loseteamname" type="string" order="6"/> 失败方队伍名称
		<variable name="watchnum" type="int" order="7"/> 观看数
	</xbean>
	<xbean name="ActReply">
		<variable name="replys" type="list" value="ActReplyInfo" order="1"/>
	</xbean>
	<xbean name="ActReplys">
		<variable name="session" type="int" order="1"/> 第几届
		<variable name="rounds" type="map" key="int" value="ActReply" order="2"/> key-轮次
	</xbean>
	<table name="actreplys" key="int" value="ActReplys" cacheCapacity="256"/> 活动录像表,key为battletype,负值代表上届
	
	<xbean name="WatchReply">
		<variable name="battletype" type="int" order="1"/> 战斗类型
		<variable name="round" type="int" order="2"/> 轮次
		<variable name="replyid" type="long" order="3"/> 录像id
	</xbean>
	<table name="watcherid2reply" key="long" value="WatchReply" lock="rolelock" cacheCapacity="8192" persistence="MEMORY"/> key是观看录像的角色id
	<!-- 活动战斗录像 end-->
	
	<!-- monster -->
	<xbean name="Monster">
		<variable name="monsterId" type="int" order="1"/> 怪物Id，此Id为在战斗NPC表中配的Id，为monster的baseId
		<variable name="shape" type="int" order="2"/>造型Id
		<variable name="level" type="int" default="1" order="3"/> 等级
		<variable name="bodysize" type="int" default="1" order="4"/> 体型大小
		<variable name="hp" type="int" order="5"/> 血
		<variable name="uplimithp" type="int" order="6"/> 当前气血上限
		<variable name="mp" type="int" order="7"/> 蓝
		<variable name="bfp" type="BasicFightProperties" order="8"/>   基础战斗属性
		<variable name="effects" type="map" key="int" value="float" order="9"/> 效果 key = effect type id
		<variable name="finalattrs" type="map" key="int" value="float" order="10"/>最终属性 key = attr type
		<variable name="buffAgent" type="BuffAgent" order="11"/> buff代理		
		<variable name="ais" type="list" value="BattleAI" capacity="30" order="12"/> 怪物ai
		<variable name="type" type="int" order="13"/> 怪物类型,boss,头领,普通,宝宝
		<variable name="skills" type="list" value="MonsterSkill" order="14"/> value= MonsterSkill
		<variable name="immunebuffs" type="list" value="int" order="15"/>该怪物免疫的buffId 
		<variable name="prefix" type="int" order="16"/> 前缀
		<variable name="monsterroleid" type="long" order="17"/>  由玩家转化成的monster, 玩家的roleid
		<variable name="xkbreaklv" type="int" order="18"/>  侠客突破等级
	</xbean>
	<xbean name="FailedMonster">
		<variable name="fighterId" type="int" order="1"/> 怪物在战场上时的战斗ID，注意，这个ID可能跟其他怪重复
		<variable name="ishost" type="boolean" order="2"/> 主方or客方怪物
		<variable name="monsterId" type="int" order="3"/> 怪物Id，此Id为在战斗NPC表中配的Id，为monster的baseId
		<variable name="level" type="int" order="4"/> 等级
		<variable name="shape" type="int" order="5"/> 造型Id
		<variable name="type" type="int" order="6"/> 怪物类型,boss,头领,普通,宝宝
		<variable name="result" type="int" order="7"/> 结束时的结果，参考knight.logic.battle.ResultType
		<variable name="prefix" type="int" order="8"/> 前缀
	</xbean>
	
	<xbean name="MonsterSkill">
		<variable name="id" type="int" order="1"/>
		<variable name="skilllevel" type="int" order="2"/>
		<variable name="castrate" type="int" order="3"/>以千为底
	</xbean>
	
	<xbean name="BattleAI">
		<variable name="id" type="int" order="1"/>
		<variable name="count" type="int" default="0" order="2"/> 成功执行的次数
		<variable name="enableround" type="int" default="0" order="3"/> 启用时的回合数
	</xbean>
	<!-- monster end-->

	<!--pk-->
	<xbean name="PKdeadtimes">
		<variable name="times" type="int" order="1"/> 死亡次数
		<variable name="starttime" type="long" order="2"/> 第一次死亡的时间
   	</xbean>
	<table name="pkdeadtable" key="long" lock="rolelock" value="PKdeadtimes" cacheCapacity="7000" foreign="key:properties"/> 玩家当天pk或决斗的死亡次数
	<!--pk-->
	
	<xbean name="TeamInfo">
		<variable name="teamLeaderId" type="long" order="1"/>队长ID
		<variable name="minLevel" type="int" order="2"/>最小级别
		<variable name="maxLevel" type="int" order="3"/>最大级别
		<variable name="formation" type="int" order="4"/>阵型id
		<variable name="formationLevel" type="int" order="5"/>阵法等级
		<variable name="switchLeaderId" type="long" order="6"/>改变队长时，保存新队长id，用于返回时验证，不处于改变队长状态时为-1
		<variable name="switchLeaderTime" type="long" order="7"/>记录改变队长操作的时间，判断超时用（30秒）
		<variable name="successSwitchTime" type="long" order="8"/>记录上一次改变队长成功的时间，成功更换后2分钟内不能更换队长
		<variable name="members" type="list" value="TeamMember" capacity="4" order="9"/>
		<variable name="applierIds" type="map" key="long" value="long" capacity="15" order="10"/>
		<variable name="invitingIds" type="map" key="long" value="long" capacity="4" order="11"/>
		<variable name="state" type="int" defatult="1" order="12"/> 队伍状态，参考协议中的kngiht.logic.team.TeamState
		<variable name="smapId" type="int" defatult="0" order="13"/> 地图玩法ID，主要用于在3状态时保存玩法ID；当处于普通队伍状态时，smapId为0
		<variable name="instancezone" type="long" defatult="0" order="14"/> 副本玩法key
		<variable name="hugs" type="map" key="long" value="long" defatult="0" order="15"/> 拥抱的队员们
		<variable name="zoneInstance" type="CommonZoneMap" order="16"/>通用副本z
		<variable name="commander" type="long" order="17"/>指挥者
		<variable name="target" type="int" order="18"/> 队伍目标
	</xbean>
	
	<xbean name="CommonNpcInfo">
		<variable name="posX" type="int" order="1"/>
		<variable name="posY" type="int" order="2"/> 
		<variable name="npcId" type="int" order="3"/> 
		<variable name="npcKey" type="long" order="4"/>
	</xbean>
	<xbean name="CommonZoneInfo">
		<variable name="npcs" type="list" value="CommonNpcInfo" order="1"/> 当前进度剩余npc
		<variable name="freshNpcs" type="list" value="int" order="2"/>当前要刷的npc
	    <variable name="currentTaskid" type="int" order="3"/> 当前的任务Id
		<variable name="takeState" type="int" order="4"/> 0=任务没有完成  1=当前任务已经完成
		<variable name="addmonster" type="int" order="5"/> 0=进入副本的时候需要刷新npc 1=进入副本的时候不需要刷新npc 
	</xbean>
	<xbean name="CommonZoneMap">
		<variable name="commonZoneInfoMap" type="map" key="int" value="CommonZoneInfo" order="1"/> key为mapId
	</xbean>
	
	<xbean name="TeamMember">
		<variable name="roleId" type="long" order="1"/>
		<variable name="state" type="int" order="2"/>
	</xbean>
	
	<xbean name="SingleInvitings">
		<variable name="invitingIds" type="map" key="long" value="long" capacity="4" order="1"/>
	</xbean>
	
	<xbean name="InviteInfo">
		<variable name="beingInvited" type="boolean" order="1"/>
		<variable name="inviting" type="TeamInvite" order="2"/>
		<variable name="invited" type="list" value="TeamInvite" order="3"/>
	</xbean>
	
	<xbean name="TeamInvite">
		<variable name="teamid" type="long" order="1"/>
		<variable name="roleid" type="long" order="2"/>
		<variable name="invitetime" type="long" order="3"/>
	</xbean>
	
	<xbean name="TeamFilter" any="true">
		<variable name="filter" type="ares.logic.team.TeamFilter" order="1"/>
	</xbean>
	
	<table name="team" key="long" value="TeamInfo" lock="teamlock" autoIncrement="true" persistence="MEMORY" cacheCapacity="8192"/> liuchen
	<table name="roleid2teamid" key="long" value="long" lock="rolelock" persistence="MEMORY" cacheCapacity="8192"/>
	<table name="singleinviting" key="long" value="SingleInvitings" lock="rolelock" persistence="MEMORY" cacheCapacity="8192"/>
	<table name="teaminvite" key="long" value="InviteInfo" lock="rolelock" persistence="MEMORY" cacheCapacity="8192"/>
	<table name="teamfilters" key="long" value="TeamFilter" lock="teamlock" persistence="MEMORY" cacheCapacity="8192"/>
	
	
	<!-- 新便捷组队 start -->
	<xbean name="TeamWaiterQueue">
		<variable name="roleId" type="long" order="1"/>
		<variable name="numberId" type="long" order="2"/>
		<variable name="jointime" type="long" order="3"/> 匹配开始时间
		<variable name="future" type="long" order="4"/> 
	</xbean>
	
	<xbean name="TeamGroupWaitIng">
		<variable name="groupId" type="int" order="1"/>
		<variable name="roleList" type="vector" value="TeamWaiterQueue" order="2"/>
		<variable name="leaderList" type="vector" value="TeamWaiterQueue" order="3"/>
	</xbean>
	<table name="teamgroupsdb" lock="teamgroupids" type="map" key="int" value="TeamGroupWaitIng" persistence="MEMORY" cacheCapacity="8192"/>
	
	<xbean name="TeamWaiterInfo">
		<variable name="roleId" type="long" order="1"/>
		<variable name="numberId" type="long" order="2"/> 匹配编号
		<variable name="groupIds" type="vector" value="int" order="3"/>
		<variable name="levelparam" type="int" order="4"/>
		<variable name="minLevel" type="int" order="5"/>
		<variable name="MaxLevel" type="int" order="6"/>
		<variable name="status" type="int" order="7"/> 0 队员  1 队长 
	</xbean>
	<table name="teamwaiterinfodb" lock="rolelock" type="map" key="long" value="TeamWaiterInfo" persistence="MEMORY" cacheCapacity="8192"/>
	
	<xbean name="FastTeamTimeLimit">
		<variable name="roleId" type="long" order="1"/>
		<variable name="lastjointime" type="long" order="2"/>
		<variable name="teammap" type="map" key="long" value="long" order="3"/> key为teamid value为加入时间
	</xbean>
	<table name="fastteamtimelimitdb" lock="rolelock" type="map" key="long" value="FastTeamTimeLimit" persistence="MEMORY" cacheCapacity="8192"/>
	<!-- 新便捷组队 end -->
	
	<xbean name="LeisureRole">
		<variable name="camp" type="int" order="1"/>
		<variable name="factionkey" type="long" order="2"/>
		<variable name="school" type="int"  order="3"/>
		<variable name="level" type="int" order="4"/>
		<variable name="groups" type="list" value = "int" order="5"/> 
		<variable name="inlist" type="boolean"  order="6"/> 看调用吧
		<variable name="teamid" type="long" order="7"/> 被邀请的teamid  用于校验
		<variable name="lastjointime" type="long" order="8"/> 上次以队长身份发出邀请的时间,防止恶意攻击
	</xbean>
	<xbean name="LeisureRoles">
		<variable name="rolelist" type="list" value = "long" order="1"/>
		<variable name="rolemap" type="map" key="long" value="LeisureRole" order="2"/> key为roleid
	</xbean>
	<table name="leisureroles" type="map" key="int" value="LeisureRoles" persistence="MEMORY" cacheCapacity="1"/>  //空闲玩家表, 用于推送组队信息
	
	
	<xbean name="ERole">
		<variable name="finalattrs" type="map" key="int" value="float" order="1"/>最终属性 key = attr type
		<variable name="effects" type="map" key="int" value="float" order="2"/> key = effect type id
	</xbean>
	<table name="erole" lock="rolelock" type="map" key="long" value="ERole" persistence="MEMORY" cacheCapacity="0"/> liuchen

	<!-- buff,effect -->
	<xbean name="BuffRole">
		<variable name="roleId" type="long" order="1"/>
		<variable name="buffAgent" type="BuffAgent" order="2"/>
	</xbean>
	
	<xbean name="BuffAgent">
		<variable name="buffs" type="map" key="int" value="Buff" order="1"/>key为buffId
		<variable name="battleendclear" type="map" key="int" value="int" order="2"/>如果在战斗中buff到时，id放入此表，等战斗结束一起执行。key为buffId，value为处理方式：1为detach，2为period process
		<variable name="timerFutures" type="map" key="int" value="long" order="3"/>key=buffId value=future id
	</xbean>
	<xbean name="Buff">
		<variable name="id" type="int" order="1"/>buff类型Id，一种类型的buff只能有一个
		<variable name="attachTime" type="long" default="0" order="2"/>buff attach时的时间，用于计算剩余时间和检测到期
		<variable name="time" type="long" default="0" order="3"/>计时buff总持续时间（period时的period）
		<variable name="round" type="int" default="0" order="4"/>计数buff剩余回合（period时的count）
		<variable name="tiers" type="int" default="0" order="5"/>堆叠层数
		<variable name="amount" type="long" default="0" order="6"/>buff的剩余量（period时的initDelay）
		<variable name="effects" type="map" key="int" value="float" order="7"/> key = effect type id
		<variable name="fighterindex" type="int" order="8"/> 当在战斗中添加的buff时，记录战斗者index（施法者的）
		<variable name="repositoryeffects" type="map" key="int" value="float" order="9"/> 用于储备buff效果，效果需要生效时需要手动添加  key = effect type id
		<variable name="addround" type="int" default="0" order="10"/>被加上时的回合数addround		
		
		<enum name="BATTLE_END_DETACH" value="1"/>			战斗结束detach
		<enum name="BATTLE_END_PROCESS" value="2"/>	    战斗结束process
	</xbean>

	<xbean name="Effect">
		<variable name="effectTypeId" type="int" order="1"/>目标加成属性类型Id
		<variable name="value" type="float" order="2"/>加成的值
		<variable name="enable" type="boolean" order="3"/>是否生效
	</xbean>
	<table name="buffroles" lock="rolelock" type="map" key="long" value="BuffRole" cacheCapacity="0" persistence="MEMORY"/> liuchen
	
	<xbean name="StoredBuffRole">
		<variable name="buffs" type="map" key="int" value="Buff" order="1"/>
	</xbean>
	<table name="buffrolestodisk" type="map" lock="rolelock" key="long" value="StoredBuffRole" cacheCapacity="7000" foreign="key:properties"/>保存的BuffRole中只有storeToDisk为true的Buff及附带的Effect
	<!-- buff,effect end -->
	
	<!-- 保存timer的future，这个表会不会增加死锁几率？一个timer只属于一个其他的xbean，约束只有get xbean时才可以访问它的timerfuture -->
	<xbean name="TimerFuture" any="true">
		<variable name="future" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>
	</xbean>
	<table name="timerfutures" lock="futurelock" type="map" autoIncrement="true" key="long" value="TimerFuture" persistence="MEMORY"/> liuchen

	<xbean name="DebugFlag">
		<variable name="debugs" type="list" value="int" order="1"/> 不在list中的为非调试状态
		
		<enum name="BATTLE" value="1"/>
	</xbean>
	<table name="debugflag" lock="rolelock" type="map" key="long" value="DebugFlag" cacheCapacity="7000" foreign="key:properties"/>	liuchen
	
	<!--Skill-->
	<xbean name="AssistSkill">
		<variable name="level" type="int" order="1"/>
		<variable name="exp" type="long" order="2"/>
	</xbean>
	
	<xbean name="SpecialSkill">
		<variable name="skillId" type="int" order="1"/>
		<variable name="equipType" type="int" order="2"/>
	</xbean>
	
	<xbean name="SkillRole">
		<variable name="skillBases" type="map" key="int" value="int" order="1"/> key = skillbase id; value = skillbase level
		<variable name="acupoints" type="map" key="int" value="int" order="2"/> key = acupoint id; value = acupoint level
		<variable name="acupointstime" type="map" key="int" value="long" order="3"/> key = acupoint id; value = acupoint time
		<variable name="selectAcupoints" type="map" key="int" value="int" order="4"/> key = 当前已选技能id; value = 技能等级
		<variable name="lastDegradeTime" type="long" order="5"/> 上次穴位降级时间，一天只能降级一次
		<variable name="assistSkills" type="map" key="int" value="AssistSkill" order="6"/> 辅助技能
		<variable name="specialSkills" type="list" value="SpecialSkill" order="7"/>装备提供的特技特效
		<variable name="otherSkills" type="map" key="int" value="int" order="8"/> 其他技能，只有级别且暂无归类的技能放在这里
		<variable name="skillSequence" type="map" key="int" value="int" order="9"/> 技能顺序，key为技能ID。value=1~100时为门派技能，101~200时为特技
		<variable name="lastusedtime" type="map" key="int" value="long" order="10"/> 上一次使用技能的时间，目前只用在结拜拉人技能里
		<variable name="acupointScheme" type="int"  order="11"/> 启用门派灵符技能方案id
		<variable name="acupointSchemes" type="map" key="int" value="AcupointScheme" order="12"/> 门派灵符技能方案
	</xbean>
	<xbean name="AcupointScheme"> //门派技能方案
		<variable name="skills" type="list" value="int" order="1"/> 灵符技能配置
		<variable name="name" type="string" order="2"/> 方案名称
	</xbean>
	<table name="skillroles" lock="rolelock" type="map" key="long" value="SkillRole" cacheCapacity="7000" foreign="key:properties"/> liuchen
	<!--Skill end-->

	<xbean name="ChargeGood">
		<variable name="firstChargeTime" type="long" order="1"/>首冲的时间,可以被刷新的
	</xbean>
	<xbean name="FirstCharge">    
	   <variable name="firstChargeTime" type="long" order="1"/>首冲的时间,可以被刷新的
	   <variable name="firstChargeGood" type="map" key="int" value="ChargeGood" order="2"/>
    </xbean>

	<table name="rolefirstcharge" key="long" value="int" cacheCapacity="7000" lock="rolelock"/>记录玩家首冲数据，0--未充过值 1-－充值了，未领取礼包 2，领取礼包了
	<table name="rolefirstcharges" key="long" value="FirstCharge" cacheCapacity="7000" lock="rolelock"/>记录玩家每档充值的首冲信息
	
	<xbean name="SingleCharge">
		<variable name="awardedNum" type="int" order="1"/>已领奖次数
		<variable name="chargeRmb" type="int" order="2"/>充值的总金额
	</xbean>
	<xbean name="SingleCharges">
		<variable name="charges" type="map" key="int" value="SingleCharge" order="1"/> //key=活动配置表ID
	</xbean>
	<table name="singlecharges" key="long" value="SingleCharges" cacheCapacity="7000" lock="rolelock"/>单笔充值
	
	<!--Yuanbao Table End-->
	
	<!--FortuneWheelProgress-->
	<xbean name="WheelItem"> 大转盘中的一格
		<variable name="itemtype" type="int" order="1"/>1为物品,2为经验,3为金钱
		<variable name="itemid" type="int" order="2"/>金钱和经验的id为0
		<variable name="num" type="int" order="3"/>数量
		<variable name="times" type="int" order="4"/>倍数,为实际倍数的10倍
		<variable name="bind" type="int" order="5"/> 是否绑定,只对物品有效
		<variable name="limit" type="int" order="6"/> 最大上限,只对物品有效
		<variable name="msgid" type="int" order="7"/> 发公告,只对物品有效
	</xbean>
	
	<xbean name="WheelInfo"> 一个大转盘的信息
		<variable name="time" type="long" order="1"/>答题的时间
		<variable name="npcbaseid" type="int" order="2"/>大转盘可能有多个npc有服务,所以要有npc的id
		<variable name="serviceid" type="int" order="3"/>一个npc可以有多个大转盘,所以要有服务的id
		<variable name="finish" type="boolean" order="4"/>是否完成了这个大转盘
		<variable name="baseMoney" type="int" order="5"/>金钱的基数(在翻倍的时候用得上)
		<variable name="baseSMoney" type="int" order="6"/>
		<variable name="baseExp" type="int" order="7"/>
		<variable name="msgid" type="int" order="8"/> 策划要求每个大转盘给的闲话id都不一样
		<variable name="msgParas" type="vector" value="string" capacity="10" order="9"/>
		<variable name="index" type="int" order="10"/> 真正中奖的那个item的下标
		<variable name="wheelItems" type="vector" value="WheelItem" capacity="50" order="11"/> 一个大转盘所包含的格子
	</xbean>
	<xbean name="WheelInfos"> 一个玩家可以有多个大转盘
		<variable name="wheelList" type="vector" value="WheelInfo" capacity="20" order="1"/>
	</xbean>
	<xbean name="WheelItemLimit"> 大转盘限制条件
		<variable name="limitMap" type="map" key="int" value="int" capacity="20" order="1"/>
	</xbean>
	
	<table name="wheelprogress" key="long" value="WheelInfos" lock="rolelock" foreign="key:properties" cacheCapacity="7000"/>记录玩家的幸运大转盘开始时间
	<table name="wheelitemlimit" key="int" value="WheelItemLimit" cacheCapacity="500"/> key为awardIndex
	<!--FortuneWheelProgress End-->
	
	<!-- 装备表 -->
	<xbean name="AppendAttr">
		<variable name="id" type="int" order="1"/> 附加属性id
		<variable name="fBaseValue" type="float" order="2"/>附加属性初始value
		<variable name="fAddValue" type="float" order="3"/>附加属性精炼增加value
		<variable name="jinglianNum" type="int" order="4"/>精炼次数
	</xbean>	
	<xbean name="Equip">
		<variable name="extid" type="long" order="1"/>在gen时用于判断数据库是否存在，防止重复插入报错
		<variable name="equiplevel" type="int" order="2"/>装备等级(目的就是用于离线快照需要过滤级别)
		<variable name="forginglevel" type="int" order="3"/>锻炼等级
		<!--variable name="repairtimes" type="int"/-->修理失败次数
		<!--variable name="endure" type="int"/-->耐久
		<!--variable name="curMaxEndure" type="int" /--> 当前最大耐久
		<!--variable name="producer" type="string"/-->制造者
		<variable name="growattr" type="map" key="int" value="int" order="4"/> 装备增强属性
		<variable name="godid" type="long" order="5"/> 神兵附加属性
		<!--variable name="extendure" type="int" default="0"/--> 当值为100时,减少1
		<!--variable name="maxEndure" type="int"/-->
		<!--variable name="skill" type="int" default="0"/--> 技能
		<!--variable name="effect" type="int" default="0"/--> 特效
		<!--variable name="specialeffect" type="int" default="0"/--> 特殊效果
		<variable name="prefixType" type="int" default="0" order="6"/> 前缀类型
		<!--variable name="isIdentified" type="int" default="0"/--> 是否鉴定过
		<variable name="appendAttr" type="list" value="AppendAttr" order="7"/> 附加属性
		<!--variable name="nameColor" type="int" default="1"/--> 名字颜色
		<!--variable name="equipScore" type="int" /--> 装备评分
		<variable name="diamondOnEquip" type="map" key="int" value="int" order="8"/> 钻石的列表,key为第几个洞,value为钻石的id
		<variable name="refineLevel" type="int" default="1" order="9"/> 淬炼等级
		<variable name="refineProgress" type="int" default="0" order="10"/> 冲星进度
		<variable name="deadline" type="long" order="11"/> 过期时间
		<variable name="isguoqi" type="boolean" order="12"/> 是否是真的过期
		<!--variable name="refineFailedTimesMap" type="map" key="int" value="int"/--> 淬炼失败次数
		<!--variable name="genWay" type="int" default="0"/--> 产出途径
	</xbean>
	<table name="equips" key="long" value="Equip" cacheCapacity="40480" autoIncrement="true"/>
	
	<xbean name="AdditionAttr">
		<variable name="attrid" type="int" order="1"/> 附加属性id
		<variable name="attrvalue" type="int" order="2"/> 附加属性value
	</xbean>
	
	<cbean name="GodEquipCreateType">
		<enum name="UNIDENTIFIEDF_GODEQUIP" value="1"/> 鉴定神兵
		<enum name="COMP_GODEQUIP" value="2" /> 打造神兵
	</cbean>
	
	<xbean name="GodEquip">
		<variable name="godlevel" type="int" order="1"/> 进阶等级(0普通装备，大于1神兵)
		<variable name="godattr" type="map" key="int" value="int" order="2"/> 神兵基础属性
		<!--variable name="godAdditionattr1" type="map" key="int" value="int" order="3"/> 神兵附加 属性1-->
		<!--variable name="godAdditionattr2" type="map" key="int" value="int" order="4"/> 神兵附加 属性2-->
		<variable name="skill" type="map" key="int" value="int" order="5"/> 装备技能
		<variable name="preitemid" type="int" order="6"/> 神兵中的道具
		<variable name="extid" type="long" order="7"/> 神兵中的道具的extid
		<!--variable name="turnedattr" type="map" key="int" value="int" order="8"/> 神兵幻化属性-->
		<!--variable name="turnedskill" type="map" key="int" value="int" order="9"/> 神兵幻化技能-->
		<variable name="curexp" type="int" order="10"/> 神兵经验
		<!--variable name="godAdditionattr3" type="map" key="int" value="int" order="11"/> 神兵附加 属性3-->
		<variable name="godAdditionattr" type="map" key="int" value="AdditionAttr" order="12"/> 神兵附加 属性
		<variable name="createrolename" type="string" order="13"/> 神兵的鉴定者是谁
		<variable name="createroleid" type="long" order="14"/> 神兵的鉴定者是谁
		<variable name="createtype" type="int" order="15"/> 神兵生成类型 1-鉴定 2-打造 注：GodEquipCreateType
		<variable name="illusionSkill" type="map" key="int" value="int" order="16"/> 神兵幻化技能
		<variable name="isIllusion" type="boolean" order="17"/> 是否幻化过(成功失败都算)
	</xbean>
	
	<table name="godequips" key="long" value="GodEquip" cacheCapacity="20240" autoIncrement="true"/>
	
	<xbean name="ItemOtherInfo">
		<variable name="godequipaddattrcounts" type="map" key="int" value="int" order="1"/> 神兵洗练次数
	</xbean>
	<xbean name="ItemOther">
		<variable name="itemotherinfo" type="map" key="long" value="ItemOtherInfo" order="1"/>  key-uniqueid 
	</xbean>
	<table name="role2itemother" key="long" value="ItemOther" cacheCapacity="7000" lock="rolelock"/> 
	
	<!-- 好友系统相关表 start -->
	<xbean name="BattleStatusInfo">
		<variable name="battlestatus" type="int" order="1"/> 战斗状态id
		<variable name="lastfrushbattletime" type="long" order="2"/> 最后战斗状态的时间
	</xbean>
	<table name="battlestatus" key="long" value="BattleStatusInfo" persistence="MEMORY" cacheCapacity="8192" lock="rolelock"/>
	
	<!-- 存储玩家上线的name to id -->
	<xbean name="SelectInfo">
		<variable name="rolemaps" type="map" key="long" value="string" order="1"/>
	</xbean>
	
	<table name="onlinename2role" key="int" value="SelectInfo" persistence="MEMORY" cacheCapacity="1"/>

	<xbean name="FriendsInfo">
		<variable name="friendlevel" type="int" default="0" order="1"/> 好友度
		<variable name="lastpushfriendtime" type="long" default="0" order="2"/> 最后一次发送的时间
		<variable name="friendbattlecount" type="int" default="0" order="3"/> 战斗的次数
		<variable name="lastfriendbattletime" type="long" default="0" order="4"/> 最后一次战斗的时间
		<variable name="friendmsgcount" type="int" default="0" order="5"/> 好友护发消息的次数
		<variable name="lastfriendmsgtime" type="long" default="0" order="6"/> 最后一次好友护发消息的时间
	</xbean>
	
	<xbean name="StrangersInfo">
		<variable name="nowTime" type="long" order="1"/>
	</xbean>
	
	<xbean name="FriendsApplyInfo">
		<variable name="nowTime" type="long" order="1"/>
	</xbean>
	<xbean name="DeleteRoleInfo">
		<variable name="friendlevel" type="int" order="1"/>
	</xbean>
	<xbean name="FriendGroups">
		<variable name="blackList" type="map" key="long" value="StrangersInfo" order="1"/> 黑名单列表
		<variable name="friendsApply" type="map" key="long" value="FriendsApplyInfo" order="2"/> 好友申请列表
		<variable name="friendsMaps" type="map" key="long" value="FriendsInfo" order="3"/> 好友列表 key=玩家id value=好友的信息
		<variable name="delFriends" type="map" key="long" value="DeleteRoleInfo" order="4"/> 删除的好友列表 key=玩家id value=好友的信息
		<variable name="lastpushtime" type="long" default="0" order="5"/> 最后给好友推送消息的时间
		<variable name="offLineMsgList" type="vector" value="OfflineMsg" order="6"/> 角色收到的离线消息上线发送以后立刻清除
		<variable name="maxfriendlevel" type="int" order="7"/> 历史最高好友度
		<variable name="isOld" type="boolean" default="false" order="8"/> 是否处理过old数据
		<variable name="follows" type="map" key="long" value="FriendsInfo" order="9"/> 关注的好友	
		<variable name="fans" type="set" value="long" order="10"/> 粉丝
		<variable name="offlineanonyflowers" type="map" key="int" value="int" order="11"/> 离线送花数量 key = 花id value = 花的数量
		<variable name="offlineanonyroleids" type="set" value="long" order="12"/> 离线送花玩家id
	</xbean>
	<table name="friends" key="long" lock="rolelock" value="FriendGroups" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="GiveFriendGift"> 
		<variable name="giftnum" type="int" order="1"/> 赠送次数
	</xbean>
	<xbean name="FriendGift">
		<variable name="giveFriendGift" type="map" key="long" value="GiveFriendGift" order="1"/>
		<variable name="receiveGiftsNum" type="int" order="2"/> 接受到的礼物数量
		<variable name="lastGiveTime" type="long" order="3"/> 每日刷新时间
	</xbean>
	<table name="friendsgifts" key="long" lock="rolelock" value="FriendGift" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256"/>	
	
	<xbean name="MutualFriendInfo"> 共同好友信息
		<variable name="roleId" type="long" order="1"/> id
		<variable name="friends" type="list" value="long" order="2"/> 哪些人是这个人的好友
	</xbean>
	
	<xbean name="MutualFriend"> 共同好友
		<variable name="mutualFriendInfos" type="map" key="long" value="MutualFriendInfo" order="1"/> 共同好友推荐列表
		<variable name="usedInfos" type="map" key="long" value="MutualFriendInfo" order="2"/> 已推荐列表
		<variable name="updateTime" type="long" order="3"/> 更新时间
	</xbean>
	
	<table name="mutualfriends" key="long" value="MutualFriend" lock="mutualfriendsrolelock" cacheCapacity="8192" persistence="MEMORY"/>
	
	<xbean name="OfflineMsg">
		<variable name="roleId" type="long" validator="value=[0,)" order="1"/>
        <variable name="content" type="string" order="2"/>
		<variable name="details" type="list" value="binary" order="3"/> 展示品信息
		<variable name="showinfos" type="list" value="ShowInfoBean" order="4"/> 展示品信息
		<variable name="sendTime" type="long" order="5"/>
		<variable name="checkshiedmsg" type="string" order="6"/> 被屏蔽的纯文本
		<variable name="url" type="string" order="7"/> 语音链接
		<variable name="voicetime" type="int" order="8"/>	语音时间长度
		<variable name="urltype" type="int" order="9"/>	链接类型
	</xbean>
	
	<xbean name="ShowInfoBean">
		<variable name="showType" type="int" order="1"/> 类型
		<variable name="roleid" type="long" order="2"/> 角色id 
		<variable name="shopid" type="long" order="3"/> 商店id,成就类型的时候是完成时间
		<variable name="counterid" type="int" order="4"/> 柜台id,成就类型的时候是成就进度
		<variable name="thiskey" type="long" order="5"/> 唯一id,成就类型的时候是是成就id
		<variable name="baseid" type="int" order="6"/> 物品id
	</xbean>
	
	<xbean name="Recommends">
		<variable name="roleIds" type="set" value="long" order="1"/>
	</xbean>
	<table name="friendrecommend" key="int" value="Recommends" cacheCapacity="8192" cachehigh="512" cachelow="256" persistence="MEMORY"/> 推荐好友库 key=玩家等级
	<!-- 好友系统相关表 end-->

	<!--节日礼物-->
	<xbean name="FestivalGift">
		<variable name="time" type="long" order="1"/>  上次领取节日礼物的时间
		<variable name="onlineTotal" type="long" order="2"/>   距上次领取礼物累计时间
	</xbean>
	<table name="festival" type="map" key="long" value="FestivalGift" cacheCapacity="7000" lock="rolelock" foreign="key:properties"/> key为roleid
	<!--节日礼物 End-->
	
	<!--离线消息表-->
	<xbean name="OfflineMsgList">
		<variable name="protocolList" type="vector" value="OfflineMsgProtocol" order="1"/>
	</xbean>
	<xbean name="OfflineMsgProtocol">
		<variable name="proType" type="int" order="1"/>
		<variable name="content" type="binary" capacity="128" order="2"/> 
		<variable name="proClassName" type="string" order="3"/>
		<variable name="tick" type="long" order="4"/> 插入到离线协议的时间
	</xbean>
	<table name="offlinemsg" key="long" value="OfflineMsgList" cacheCapacity="7000" lock="rolelock" cachehigh="512" cachelow="256"/>
	
	<!--全服系统消息表-->
	<xbean name="BroadcastMsgList">
		<variable name="msglist" type="vector" value="BroadcastMsg" order="1"/>
	</xbean>
	<xbean name="BroadcastMsg">
		<variable name="msgprotocol" type="OfflineMsgProtocol" order="1"/>
		<variable name="broadtime" type="long" order="2"/>
		<variable name="broadendtime" type="long" order="3"/> 如果默认是0，则没有广播的结束时间
	</xbean>
	<table name="broadmsg" key="int" value="BroadcastMsgList" cacheCapacity="1" cachehigh="1" cachelow="1"/> 只有一个记录，key = 1
	
	<!--角色名称对应表，key为角色名称（包括曾用名），value为roleid-->
	<table name="rolename2key" key="string" value="long" cacheCapacity="7000" cachehigh="512" cachelow="256"/>

	<xbean name="FactionIndex">
		<variable name="index" type="map" key="int" value="long" order="1"/> 所有帮派的id和key的对应
	</xbean>
	<table name="factionindex" type="map" key="int" value="FactionIndex" cacheCapacity="1"/>  仅有一条记录 key为1
	
	<table name="tablekeycounter" key="int" value="int" cacheCapacity="4096"/>  维护自增长的表key的table，key为计数器类型，value是当前值
	
	<!-- 新帮派start -->
	<xbean name="CampFactionInfo"> 
		<variable name="subfactionmoney" type="int" order="1"/> 扣除帮派资金的数量
		<variable name="lastsubfactionmoneytime" type="long" order="2"/> 
	</xbean>
	<table name="campfaction" key="long" value="CampFactionInfo" cacheCapacity="4096" cachehigh="512" cachelow="256" lock="factionlock"/> 野外pk帮派表
	
	<!-- 帮派副本地图相关 -->
	<xbean name="DynamicMapInfo">
		<variable name="factionmap" type="long" default="-1" order="1"/> 帮派地图  存放的副本的sceneId -1-不存在   
	</xbean>
	<xbean name="FactionCarbonInfo">
		<variable name="dynamicmap" type="DynamicMapInfo" order="1"/> 帮派副本信息
	</xbean>
	<table name="factioncarbon" key="long" value="FactionCarbonInfo" cacheCapacity="4096" cachehigh="512" cachelow="256" persistence="MEMORY" lock="factionlock"/>
	
	<!-- 保存帮派建筑的future -->
	<xbean name="FactionBuildFutureInfo" any="true">
		<variable name="buildfuturemaps" type="map" key="int" value="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>
	</xbean>
	<table name="factionbuildfuture" type="map" key="long" cacheCapacity="10240" value="FactionBuildFutureInfo" persistence="MEMORY" lock="factionlock"/>

	<!--帮派事件日志表 key为帮派的id-->
	<xbean name="FactionEvent">	帮派事件日志表
		<variable name="typeid" type="int" order="1"/> 日志类型
		<variable name="content" type="list" value="string" order="2"/> 日志内容
		<variable name="eventtime" type="long" default="0" order="3"/> 日志记录时间
	</xbean>
	<xbean name="FactionEventList">
		<variable name="eventlist" type="list" value="FactionEvent" order="1"/> 所有的记录
	</xbean>
	<table name="factioneventlog" key="long" value="FactionEventList" cacheCapacity="4096" cachehigh="512" cachelow="256" lock="factionlock"/>
	
	<!--帮派建筑表 key为帮派的id-->
	<xbean name="FactionConstructionInfo">			帮派建设列表
		<variable name="factionmoney" type="int" order="1"/>                         帮派资金
		<variable name="lossday" type="int" order="2"/>                         	帮派资金连续亏损天数
		<variable name="construction" type="int" order="3"/>                         帮派贡献
		<variable name="factionglodbar" type="int" order="4"/>                        帮派金砖
		<variable name="factionstealedmoney" type="int" order="5"/>                   帮派被窃取资金
		<variable name="laststealtime" type="long" order="6"/>                        最后一次被窃取的时间
		<variable name="stockbuff" type="map" key="int" value="Stockbuffeffect" order="7"/>				帮派采备buff列表 key-buffId value-效果
		<variable name="lastWeekFactionMoney" type="int" order="8"/>上周帮派资金，换帮清除，每周一0点后（变化时）重置
		<variable name="thisWeekFactionMoney" type="int" order="9"/>本周帮派资金，换帮清除并重新计数，每周一0点后（变化时）转到上周帮贡
		<variable name="moveWeekFactionMoneyTime" type="long" order="10"/>转移帮派资金时间
		<variable name="yesterdayFactionMoney" type="int" order="11"/>前一天帮派资金，换帮清除，每天8点后（变化时）重置
		<variable name="todayFactionMoney" type="int" order="12"/>当天帮派资金，换帮清除并重新计数，每天8点后（变化时）转到前一天帮贡
		<variable name="movedayFactionMoneyTime" type="long" order="13"/>转移帮派资金时间 以天为单位
		<variable name="factionstealmoney" type="int" order="14"/>                   帮派窃取的资金
		<variable name="aim" type="long" order="15"/>                   推荐目标帮派key
		<variable name="bossid" type="long" order="16"/>  
	</xbean>
	<xbean name="Stockbuffeffect"> buff效果
		<variable name="attrmap" type="map" key="int" value="float" order="1"/> 属性效果 key-属性id value-属性效果
		<variable name="endtime" type="long" order="2"/>   结束时间
	</xbean>
	<table name="factionconstructions" key="long" value="FactionConstructionInfo" cacheCapacity="4096" lock="factionlock"/>  建设 key为帮派的id
	
	<!-- 帮派学徒 start-->	
	<xbean name="FactionTrainSwitch">		
		<variable name="changeTime" type="long" order="1"/>更改时间
	</xbean>
	<table name="factiontrainswitch" key="long" value="FactionTrainSwitch" cacheCapacity="4096" lock="factionlock"/>
	<xbean name="FactionTrainees"> 
		<variable name="trainMembers" type="map" key="long" value="FactionMemberInfo" order="1"/>	帮派学徒成员
	</xbean>	
	<table name="factiontrainees" key="long" value="FactionTrainees" cacheCapacity="4096" lock="factionlock"/>	
	<!-- 帮派学徒 end-->
	
	
	<!--离开帮派记录离帮次数-->
	<xbean name="LeaveFactionInfo">
		<variable name="lastfactionid" type="long" order="1"/>
		<variable name="leavefactioncount" type="int" order="2"/>
		<variable name="leavefactiontime" type="long" order="3"/>
	</xbean>
	<table name="leavefactions" key="long" value="LeaveFactionInfo" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/> 离帮数据表
	
	<!--记录邀请入帮-->
	<xbean name="InviteFactionInfo">
		<variable name="inviteinfo" type="map" key="long" value="long" order="1"/>
	</xbean>
	<table name="invitefaction" key="long" value="InviteFactionInfo" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/> 邀请入帮表
	
	<xbean name="FactionMemberInfo">
		<variable name="factionPosition" type="int" order="1"/>		成员职务（参见枚举值）
		<variable name="isBannedTalk" type="boolean" default="false" order="2"/> 是否被禁言
		<variable name="bannedTalkTime" type="long" default="0" order="3"/> 被禁言的时间
		<variable name="salutation" type="string" order="4"/> 帮派中的称谓
		<variable name="lastonlinetime" type="long" order="5"/>	为0表示在线，否则表示上次离线时间,单位毫秒
		<variable name="jointime" type="long" order="6"/>	玩家加入帮派的时间
		<variable name="buildspeedcount" type="int" order="7"/>	玩家加速建筑次数
		<variable name="speakTimes" type="map" key="int" value="int" order="8"/> 玩家频道发言次数 key=频道id
	</xbean>
	
	<xbean name="FactionSkill">			帮派技能
		<variable name="factionskillid" type="int" order="1"/> 		技能id
		<variable name="factionskilllevel" type="int" order="2"/> 	技能当前等级
		<variable name="factionskillexp" type="int" order="3"/> 		技能当前经验
	</xbean>
	
	<!--<xbean name="DynamicMapInfo2">		帮派副本信息
		<variable name="basemapid"  type="int"  />
	</xbean>-->
	
	<xbean name="CourseInfo">		帮派历程的信息
		<variable name="id" type="int" order="1"/> 		        历程的id
		<variable name="param" type="vector" value="string" order="2"/> 		历程的参数
	</xbean>
	
	<xbean name="CreateFactionVoteInfo">
		<variable name="factionName" type="string" order="1"/> 帮派名
		<variable name="factionAim" type="string" order="2"/> 帮派宗旨
		<variable name="endTime" type="long" order="3"/> 投票结束时间(倒计时用，防止超时)
		<variable name="members" type="map" key="long" value="int" order="4"/> value为投票结果
		<variable name="iconid" type="int" order="5"/> 图标id
		<variable name="hostid" type="long" order="7"/> 发起人（未来帮主）
		<variable name="cost" type="int" order="8"/> 花费
	</xbean>
	<table name="createfactionvote" key="long" value="CreateFactionVoteInfo" lock="teamlock" persistence="MEMORY" cacheCapacity="8000"/>
	
	<xbean name="FactionInfo">
		<variable name="camp" type="int" order="1"/> 							帮派阵营
		<variable name="index" type="int" order="2"/> 							帮派序号
		<variable name="key" type="long" order="3"/> 							在帮派表里的key
		<variable name="factionName" type="string" order="4"/> 				帮派名字
		<variable name="creator" type="long" order="5"/>						帮派创始人
		<variable name="popularity" type="int" order="6"/> 					帮派人气度
		<variable name="buildLevel" type="int" order="7"/> 					帮派建设度
		<variable name="factionLevel" type="int" default="1" order="8"/> 		帮派级别
		<variable name="yesterdayBuildLevel" type="int" default="0" order="9"/> 昨日帮派新增建设度
		<variable name="factionAim" type="string" order="10"/> 					帮派宗旨
		<variable name="factionnotice" type="string" order="11"/> 				帮派公告
		<variable name="factionMaster" type="long" order="12"/>					帮主
		<variable name="factionViceMaster" type="long" default="-1" order="13"/>					副帮主
		<variable name="factionrank" type="int" order="14"/>						帮派排名
		<variable name="factionCourseList" type="vector" value="CourseInfo" order="15"/>帮派历程
		<variable name="factionSkillMap" type="map" key="int" value="FactionSkill" order="16"/>	帮派技能信息
		<variable name="members" type="map" key="long" value="FactionMemberInfo" order="17"/>	帮派成员
		<variable name="applicants" type="map" key="long" value="long" order="18"/> 		申请加入帮派人员
		<variable name="factionmaps" type="map" key="long" value="DynamicMapInfo" order="19"/>  帮派副本
		<variable name="createtime" type="long" order="20"/> 						帮派创建时间
		<variable name="practices" type="map" key="int" value="int" order="21"/> 帮派中的修炼技能 key=为技能id  value 0=关闭  1=开启
		<variable name="impeachtime" type="long" order="22"/> 弹劾帮主时间 0-代表没有弹劾
		<variable name="impeachdays" type="int" order="23"/>	帮主被弹劾天数
		<variable name="decaytime" type="long" order="24"/> 帮派建设度衰减时间
		<variable name="lowzerodays" type="int" order="25"/> 帮派建设度低于0天数
		<variable name="modifiednum" type="int" default="0" order="26"/> 帮派数据修正次数 0-未修正 1-修正过
		<variable name="factionbattlewin" type="int" default="0" order="27"/> 帮派战胜场
		<variable name="factionbattlelose" type="int" default="0" order="28"/> 帮派战负场
		<variable name="factioniconid" type="int" default="0" order="29"/> 帮派图标id
		<variable name="loginnumbers" type="map" key="int" value="FactionLoginNumInfo" order="30"/>  key:天 value：登陆人数
		<variable name="activeScore" type="int" order="31"/> 帮派活跃度总分
		<variable name="hongbaoTimes" type="map" key="long" value="int" order="32"/> 发红包总次数
		<variable name="maxOnlineNum" type="int" order="33"/> 每天最高同时在线人数
		<variable name="scorebytype" type="map" key="int" value="float" order="34"/>各类型活跃度分数
		<variable name="beMergedFaction" type="long" order="35"/> 被成为合帮目标
		<variable name="mergedfuturekey" type="long" order="36"/> 被合并定时器key
		<variable name="factionweiwang" type="int" order="37"/>帮派获得威望
		<variable name="factionbooty" type="int" order="38"/>末世之战战利品（元宝）
		<variable name="type" type="int" order="39"/> 帮派类型(正常0，冻结2，中立3)
		<variable name="factionaccountbook" type="list" value="FactionAccountBookInfo" order="40"/>帮派账簿信息
		<variable name="factionfiremembernum" type="int" order="41"/>逐鹿活动期间帮派主动踢出成员数（不计学徒）
	</xbean>
	
	<xbean name="FactionAccountBookInfo">		帮派账簿信息
		<variable name="rolename" type="string" order="1"/> 		角色名字
		<variable name="giveyuanbao" type="int" order="2"/>			分配元宝
	</xbean>
	<xbean name="FactionLoginNumInfo">		帮派每天登陆信息
		<variable name="loginrole" type="set" value="long" order="1"/> 		登陆的人
	</xbean>
	
	<xbean name="FactionRoleInfo">	RoleContribution 更名而来 用来存储帮派的个人数据
		<variable name="qidaoNum" type="int" order="1"/> 今日祈祷次数
		<variable name="totalContribution"  type="int" order="2" /> 帮派总贡献度  换帮派会清零
		<variable name="currentContribution"  type="int" order="3" /> 当前帮派贡献度 玩家身上的货币 一直存在
		<variable name="historyContribution" type="int" order="4" /> 历史帮派贡献度 换帮派会存总帮贡值 
		<variable name="lastfactionid"  type="long"  order="5"/> 上一个帮派的id
		<variable name="lastFreshTime" type="long" order="6"/>上次更新数据时间 用于隔天清0
		<variable name="lastWeekContribution" type="int" order="7"/>上周帮贡，换帮清除，每周一0点后（变化时）重置
		<variable name="thisWeekContribution" type="int" order="8"/>本周帮贡，换帮清除并重新计数，每周一0点后（变化时）转到上周帮贡
		<variable name="moveWeekContributionTime" type="long" order="9"/>转移帮贡时间

		<variable name="changeNoticeTimes" type="int" order="10"/>更改帮派公告次数
		<variable name="changeNoticeClearTime" type="long" order="11"/>清除时间
		<variable name="yesterdayContribution" type="int" order="12"/>前一天帮贡，换帮清除，每天8点后（变化时）重置
		<variable name="todayContribution" type="int" order="13"/>当天帮贡，换帮清除并重新计数，每天8点后（变化时）转到上一天帮贡
		<variable name="movedayContributionTime" type="long" order="14"/>转移帮贡时间以天为单位
		<variable name="contributionScore" type="int" order="15"/>当天帮贡积分，换帮清除重记，每天0点后（变化时）清零
		<variable name="clearScoreTime" type="long" order="16"/>清除积分时间
	
	</xbean>
	
	<table name="factions" key="long" value="FactionInfo" cacheCapacity="4096" cachehigh="512" cachelow="256" autoIncrement="true" lock="factionlock"/>
	<table name="roleid2faction" key="long" value="long" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="FactionBonusInfo">	RoleContribution 更名而来 用来存储帮派的个人数据
		<variable name="bonusMoney" type="long" order="2"/>上周分红数量
		<variable name="lastReceiveTime" type="long" order="3"/>上周分红领取时间
	</xbean>
	<table name="factionbonus" key="long" value="FactionBonusInfo" cacheCapacity="7000" lock="rolelock" />

	
	<xbean name="CampFactions">		阵营帮派
		<variable name="factions" type="list" value="long" order="1"/> 阵营帮派列表
	</xbean>
	<table name="camp2factions" type="map" key="int" value="CampFactions" cacheCapacity="8"/>  key=阵营  最多应该只有3个
	<table name="factionrole" key="long" value="FactionRoleInfo" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>

	<!-- 帮派捐助 -->
	<xbean name="ContributeAwardInfo"> 捐赠记录
		<variable name="roleid" type="long" order="1"/> 捐赠者
		<variable name="itemid" type="int" order="2"/> 捐赠道具id
		<variable name="itemnum" type="int" order="3"/> 捐赠数量
	</xbean>
	
	<xbean name="ContributeInfo">
		<variable name="contributetime" type="long" order="1"/> 发起申请时间
		<variable name="contributenum" type="int" order="2"/>  当前获赠数量
	</xbean>
	<xbean name="ContributeRoleInfo">
		<variable name="contributes" type="map" key="int" value="ContributeInfo" order="1"/>
	</xbean>
	<xbean name="FactionContributeInfo">
		<variable name="factioncontributerole" type="map" key="long" value="ContributeRoleInfo" order="1"/>
	</xbean>
	<table name="factioncontribute" type="map" key="long" cacheCapacity="4096" value="FactionContributeInfo" lock="factionlock"/>
	
	<xbean name="FactionContributeRoleInfo"> 个人捐赠相关数据 
		<variable name="helpcount" type="int" order="1"/> 累计捐助次数
		<variable name="lasthelptime" type="long" order="2"/> 上次捐助时间
		<variable name="askcount" type="map" key="int" value="int" order="3"/> 累计请求次数
		<variable name="lastasktime" type="long" order="4"/> 上次请求时间
		<variable name="awardlist" type="list" value="ContributeAwardInfo" order="5"/> 捐献详情
	</xbean>
	<table name="factioncontributerole" type="map" key="long" cacheCapacity="7000" value="FactionContributeRoleInfo" lock="rolelock"/>
	
	
	<!-- 帮派外交 start -->	  
    <xbean name="FactionRequestLeague">
        <variable name="requestLeagues" type="set" value="long" order = "1"/> 请求结盟帮派
		<variable name="requestAntagonizes" type="set" value="long" order = "2"/> 请求敌对帮派		
    </xbean>
    <table name="factionrequestleague" key="long" value="FactionRequestLeague" cacheCapacity="4096" lock="factionlock"/>
    
    <xbean name="FactionRelation">
        <variable name="createTime" type="long" order = "1"/>建立关系时间    
    </xbean>    
    <xbean name="FactionDiplomacy">
        <variable name="leagues" type="map" key="long" value="FactionRelation" order = "1"/> 结盟帮派
        <variable name="antagonizes" type="map" key="long" value="FactionRelation" order = "2"/>我的敌对帮派
		<variable name="antagonizeds" type="set" value="long" order = "3"/>被敌对帮派
    </xbean>
    <table name="factiondiplomacy" key="long" value="FactionDiplomacy" cacheCapacity="4096" lock="factionlock"/>    
    <!-- 帮派外交 end -->
	
	<!-- 帮派窃取 start-->
	<xbean name="FactionMoneyStolen">
		<enum name="ANTAGONIZE" value="1" /> 窃取
		<enum name="LEAGUE" value="2" /> 援助		
		<variable name="oppoFactionKey" type="long" order = "1"/> 目标帮派key
		<variable name="diplomacyType" type="int" order = "2"/>		
		<variable name="taskstage" type="int" order = "3"/>
		<variable name="resettime" type="long" order = "4"/>
		<variable name="bossbattletime" type="long" order = "5"/>
	</xbean>
	<table name="factionmoneystolenrole" key="long" value="FactionMoneyStolen" cacheCapacity="7000" lock="rolelock"/> 帮派资金窃取
	
	<xbean name="FactionMoneyStolenInfo">
		<variable name="roleid" type="long" order = "1"/> 	
		<variable name="attack" type="int" order = "2"/> 	
		<variable name="defend" type="int" order = "3"/>
	</xbean>
	
	<xbean name="FactionMoneyStolenInfos">	
		<variable name="infos" type="map" key="long" value="FactionMoneyStolenInfo" order = "1"/>
		<variable name="attackrank" type="list" value="long" order = "2"/>
		<variable name="defendrank" type="list" value="long" order = "3"/>
	</xbean>
	<table name="factionmoneystolenrank" key="long" value="FactionMoneyStolenInfos" cacheCapacity="4096"  persistence="MEMORY" lock="factionlock"/> 
	
	<xbean name="FactionBossInfo">
		<variable name="roleid" type="long" order = "1"/> 	
		<variable name="score" type="int" order = "2"/> 	
	</xbean>
	<xbean name="FactionBossInfos">	
		<variable name="infos" type="map" key="long" value="FactionBossInfo" order = "1"/>
		<variable name="rank" type="list" value="FactionBossInfo" order = "2"/>
	</xbean>
	<table name="factionbossrank" key="long" value="FactionBossInfos" cacheCapacity="4096"  persistence="MEMORY" lock="factionlock"/> 
	<!-- 帮派窃取 end-->
	
	<!--帮派排行榜相关表-->
	<xbean name="FactionRankList">
		<variable name="records" type="list" value="FactionRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="FactionRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="factionid" type="int" order="2"/> 帮派序号
		<variable name="factionkey" type="long" order="3"/> 帮派表唯一键值
		<variable name="factionname" type="string" order="4"/> 帮派名称
		<variable name="mastername" type="string" order="5"/> 帮主名称
		<variable name="level" type="int" order="6"/> 帮派等级
		<variable name="buildlevel" type="int" order="7"/> 帮派建设度
		<variable name="membernum" type="int" order="8"/> 帮派成员数
		<variable name="camp" type="int" order="9"/> 阵营
		<variable name="factionmoney" type="int" order="10"/> 帮派资金
	</xbean>
	<!--帮派排行榜table key为id=1，只有一条记录一个map-->
	<table name="factionlist" key="int" value="FactionRankList" cacheCapacity="1"/>
	<!--新帮派End-->
	
	<!-- 帮派活跃榜 start -->
	<xbean name="FactionActiveRecord">
		<variable name="factionkey" type="long" order="1"/> 帮派key
		<variable name="factionname" type="string" order="2"/> 帮派名称
		<variable name="score" type="int" order="3"/> 活跃度
		<variable name="level" type="int" order="4"/>等級
		
	</xbean>
	<xbean name="FactionActiveRecordList">
		<variable name="records" type="list" value="FactionActiveRecord" order="1"/>
	</xbean>
	<table name="factionactiveranklist" key="int" value="FactionActiveRecordList" cacheCapacity="1"/>
	<!-- 帮派活跃榜 end -->
	
	<!--排行榜相关表-->
	<!--人物综合实力排行榜相关表-->
	<xbean name="RoleZongheRankList">
		<variable name="records" type="list" value="RoleZongheRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="RoleZongheRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="school" type="int" order="4"/> 门派
		<variable name="level" type="int" order="5"/> 等级
		<variable name="score" type="int" order="6"/> 总评分
	</xbean>
	<!--人物综合实力榜table key为id=1-7见RankType枚举类，只有7条记录-->
	<table name="rolezonghelist" key="int" value="RoleZongheRankList" cacheCapacity="15"/>
	<!--人物综合实力排行榜相关表-->
	
	<!-- 装备评分排行榜相关表 -->
	<xbean name="EquipScoreRankList">
		<variable name="records" type="list" value="EquipScoreRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="EquipScoreRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="score" type="int" order="5"/> 总评分
	</xbean>
	<!-- 装备评分排行榜 key为id=1，只有1条记录-->
	<table name="equipscorelist" key="int" value="EquipScoreRankList" cacheCapacity="1"/>
	<!-- 装备评分排行榜相关表 -->
	
	<!-- 图鉴评分排行榜相关表 -->
	<xbean name="DrawingScoreRankList">
		<variable name="records" type="list" value="DrawingScoreRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="DrawingScoreRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="drawingnum" type="int" order="4"/> 图鉴搜集数量
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="level" type="int" order="6"/> 等级
	</xbean>
	<table name="drawingscorelist" key="int" value="DrawingScoreRankList" cacheCapacity="1"/>
	<!-- 图鉴评分排行榜相关表 -->
	
	<!--玫瑰榜相关表-->
	<xbean name="RoseRankList">
		<variable name="records" type="list" value="RoseListRecord" order="1"/> 所有的记录
	</xbean>
	
	<xbean name="RoseListRecord">
		<variable name="time" type="long" order="1"/> 达到这个数量的时间
		<variable name="marshalData" type="MarshalRoseRecord" order="2"/> 
	</xbean>
	
	<xbean name="MarshalRoseRecord">
		<variable name="roleid" type="long" order="1"/> 角色id
		<variable name="name" type="string" order="2"/> 角色名
		<variable name="titleid" type="long" order="3"/> 称谓id
		<variable name="roseNum" type="int" order="4"/> 玫瑰数量
		<variable name="rank" type="int" order="5"/> 排名
		<variable name="level" type="int" order="6"/> 角色等级
	</xbean>
	
	<!--玫瑰排行榜table key为玫瑰榜的id（昨日榜，今日榜，历史榜），只有一条记录一个map-->
	<table name="roselist" key="int" value="RoseRankList" cacheCapacity="5"/>
	
	<xbean name="RoseListRecordMap">
		<variable name="records" type="map" key="long" value="RoseListRecord" order="1"/> 所有的记录
	</xbean>
	
	<table name="roleroserank" key="int" value="RoseListRecordMap" cacheCapacity="1"/>
	
		<!--跨服花榜-->
	<table name="crossroselist" key="int" value="RoseRankList" cacheCapacity="5"/> 全服花榜-存在cross服
	
	<!--跨服花榜二期-->
	<xbean name="CrossFlowerRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="rolename" type="string" order="2"/> rolename
		<variable name="level" type="int" order="3"/> 等级
		<variable name="shapeid" type="int" order="4"/> shapeid
		<variable name="headurl" type="string" order="5"/> 相册中被设为头像的照片
		<variable name="num" type="int" order="6"/> 数量
		<variable name="factionid" type="int" order="7"/> 时装id
		<variable name="equipitemid" type="int" order="8"/> 武器id
		<variable name="equiplevel" type="int" order="9"/> 武器阶数
		<variable name="equipturned" type="int" order="10"/> 武器幻化
		<variable name="equipcolor" type="int" order="11"/> 武器颜色
		<variable name="equiprecast" type="int" order="12"/> 武器重铸
		<variable name="schoolid" type="int" order="13"/> 门派
	</xbean>
	<xbean name="CrossFlowerRecordList">
		<variable name="records" type="list" value="CrossFlowerRecord" order="1"/>
	</xbean>
	<!--全服花榜二期-排行榜-存在cross服-->
	<table name="crossflowerrank" key="int" value="CrossFlowerRecordList" cacheCapacity="2"/>
	
	<!--跨服花榜 个人本服记录-->
	<xbean name="GuardFlowerRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="rolename" type="string" order="2"/> 角色名
		<variable name="shapeid" type="int" order="3"/> shapeid
		<variable name="headurl" type="string" order="4"/> 相册中被设为头像的照片
		<variable name="flowernum" type="int" order="5"/> 鲜花数
		<variable name="school" type="int" order="6"/> 角色门派
		<variable name="level" type="int" order="7"/> 等级
	</xbean>
	<xbean name="CrossFlowerLocalRecord">
		<variable name="num" type="int" order="1"/> 数量
		<variable name="guardnum" type="map" key="long" value="int" order="2"/> 守护榜花数 key-roleid value-num
		<variable name="guardrank" type="list" value="GuardFlowerRecord" order="3"/> 守护榜
	</xbean>
	<xbean name="CrossFlowerLocalRecordMap">
		<variable name="rolerecords" type="map" key="long" value="CrossFlowerLocalRecord" order="1"/>
	</xbean>
	<!--全服花榜二期-个人收花/送花记录-存在本服-->
	<table name="crossflowerlocalrecords" key="int" value="CrossFlowerLocalRecordMap" cacheCapacity="2"/>
	
	<!--功德榜相关表-->
	<xbean name="GongdeRankList">
		<variable name="records" type="list" value="GongdeRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="GongdeRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="gongde" type="int" order="4"/> 功德值
		<variable name="school" type="int" order="5"/> 职业
	</xbean>
	
	<table name="gongdelist" key="int" value="GongdeRankList" cacheCapacity="1"/>
	
	<xbean name="GongdeRankRecordMap">
		<variable name="records" type="map" key="long" value="GongdeRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="rolegongderank" key="int" value="GongdeRankRecordMap" cacheCapacity="1"/>
	<!--功德榜相关表 end -->
	
	<!--古董榜 start -->
	<xbean name="GudongRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="zhenpin" type="int" order="4"/> 真品数量
		<variable name="xishizhenpin" type="int" order="5"/> 稀世珍品数量
	</xbean>
	
	<xbean name="GudongRankList">
		<variable name="records" type="list" value="GudongRankRecord" order="1"/> 所有的记录
	</xbean>
	
	<table name="gudongranklist" key="int" value="GudongRankList" cacheCapacity="1"/>
	
	<xbean name="GudongRankRecordMap">
		<variable name="records" type="map" key="long" value="GudongRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="rolegudongrank" key="int" value="GudongRankRecordMap" cacheCapacity="1"/>
	<!--古董榜 end -->
	
	<!--名师排行榜相关表-->
	<xbean name="ApprenticeRankList">
		<variable name="records" type="list" value="ApprenticeRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="ApprenticeRankRecord">
		<variable name="roleid" type="long" order="1"/> 人物ID
		<variable name="rank" type="int" order="2"/> 排名
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="apprenticenum" type="int" order="4"/> 出徒数量
		<variable name="school" type="int" order="5"/> 职业
	</xbean>
	
	<table name="apprenticelist" key="int" value="ApprenticeRankList" cacheCapacity="1"/>
	
	<xbean name="ApprenticeRankRecordMap">
		<variable name="records" type="map" key="long" value="ApprenticeRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="roleapprenticerank" key="int" value="ApprenticeRankRecordMap" cacheCapacity="1"/>
	<!--名师排行榜相关表 end -->
	
	<!--个人级别榜相关表-->
	<xbean name="RoleLevelRankList">
		<variable name="records" type="list" value="RoleLevelListRecord" order="1"/> 所有的记录
	</xbean>
	
	<xbean name="RoleLevelListRecord">
		<variable name="time" type="long" order="1"/> 达到这个数量的时间
		<variable name="marshalData" type="MarshalRoleLevelRecord" order="2"/> 
	</xbean>
	
	<xbean name="MarshalRoleLevelRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="rolename" type="string" order="2"/> 名字
		<variable name="level" type="int" order="3"/> 等级
		<variable name="school" type="int" order="4"/> 门派id
		<variable name="rank" type="int" order="5"/> 排名
	</xbean>
	
	<!--个人级别榜table key为个人级别榜的id=1，只有一条记录一个map-->
	<table name="rolelevellist" key="int" value="RoleLevelRankList" cacheCapacity="1"/>
	
	<!--个人财富榜相关表-->
	<xbean name="RoleMoneyRankList">
		<variable name="records" type="list" value="RoleMoneyListRecord" order="1"/> 所有的记录
	</xbean>
	
	<xbean name="RoleMoneyListRecord">
		<variable name="time" type="long" order="1"/> 达到这个数量的时间
		<variable name="marshalData" type="MarshalRoleMoneyRecord" order="2"/> 
	</xbean>
	
	<xbean name="MarshalRoleMoneyRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="nickname" type="string" order="2"/> 名字
		<variable name="wealth" type="long" order="3"/> 财富
		<variable name="school" type="int" order="4"/> 门派id
		<variable name="rank" type="int" order="5"/> 排名
	</xbean>
	
	<!--个人财富榜table key为个人级别榜的id=1，只有一条记录一个map-->
	<table name="rolemoneylist" key="int" value="RoleMoneyRankList" cacheCapacity="1"/>
	
	<!--宠物能力榜相关表-->
	<xbean name="PetScoreRankList">
		<variable name="records" type="list" value="PetScoreListRecord" order="1"/> 所有的记录
	</xbean>
	
	<xbean name="PetScoreListRecord">
		<variable name="time" type="long" order="1"/> 达到这个数量的时间
		<variable name="marshalData" type="MarshalPetScoreRecord" order="2"/> 
	</xbean>
	
	<xbean name="MarshalPetScoreRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="petkey" type="int" order="2"/> 宠物key
		<variable name="uniquePetId" type="long" order="3"/> 宠物的唯一id
		<variable name="petId" type="long" order="4"/> 宠物id
		<variable name="nickname" type="string" order="5"/> 名字
		<variable name="petname" type="string" order="6"/> 宠物名字
		<variable name="petgrade" type="int" order="7"/> 宠物评分
		<variable name="rank" type="int" order="8"/> 排名
		<variable name="colour" type="int" order="9"/> 宠物颜色
	</xbean>
	
	<!--宠物能力榜table key为个人级别榜的id=1，只有一条记录一个map-->
	<table name="petscorelist" key="int" value="PetScoreRankList" cacheCapacity="1"/>
	
	<!--宠物最高战力榜 start-->
	<xbean name="PetMaxScoreRankList">
		<variable name="records" type="list" value="PetMaxScoreRankRecord" order="1"/> 
	</xbean>
	<xbean name="PetMaxScoreRankRecord">
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="petkey" type="int" order="2"/> 宠物key
		<variable name="uniquePetId" type="long" order="3"/> 宠物的唯一id
		<variable name="petId" type="long" order="4"/> 宠物id
		<variable name="nickname" type="string" order="5"/> 名字
		<variable name="petname" type="string" order="6"/> 宠物名字
		<variable name="petgrade" type="int" order="7"/> 宠物评分
		<variable name="rank" type="int" order="8"/> 排名
		<variable name="colour" type="int" order="9"/> 宠物颜色
	</xbean>
	<table name="petmaxscoreranklist" key="int" value="PetMaxScoreRankList" cacheCapacity="1"/>
	
	<!--宠物最高战力榜 end-->
	
	<!--阵法排行榜 start-->
	<xbean name="FormationRankList">
		<variable name="records" type="list" value="FormationRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="FormationRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="school" type="int" order="4"/> 门派id
		<variable name="score" type="int" order="5"/> 阵法评分
	</xbean>
	<table name="formationlist" key="int" value="FormationRankList" cacheCapacity="1"/>
	<!--阵法排行榜 end-->
	
	<!--好友排行榜 start-->
	<xbean name="FriendRankList">
		<variable name="records" type="list" value="FriendRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="FriendRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="friendlevel" type="int" order="5"/> 好友度
	</xbean>
	<table name="friendlist" key="int" value="FriendRankList" cacheCapacity="1"/>
	<!--好友排行榜 end-->
	
	<!--帮派实力榜 start -->
	<xbean name="FactionPowerRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="factionkey" type="long" order="2"/> 帮派key
		<variable name="factionname" type="string" order="3"/> 帮派名称
		<variable name="camp" type="int" order="4"/> 阵营
		<variable name="score" type="int" order="5"/> 综合评分
		<variable name="level" type="int" order="6"/> 等级
	</xbean>
	<xbean name="FactionPowerRankList">
		<variable name="records" type="list" value="FactionPowerRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="factionpowerranklist" key="int" value="FactionPowerRankList" cacheCapacity="1"/>
	
	<xbean name="FactionPowerRecordMap">
		<variable name="records" type="map" key="long" value="FactionPowerRankRecord" order="1"/> key=factionkey,value=record
	</xbean>
	<table name="factionpowerrank" key="int" value="FactionPowerRecordMap" cacheCapacity="1"/>
	<!--帮派实力榜 end -->
	
	<!--坐骑排行榜 start-->
	<xbean name="ZuoqiRankList">
		<variable name="records" type="list" value="ZuoqiRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="ZuoqiRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="score" type="int" order="5"/> 坐骑评分
	</xbean>
	<table name="zuoqilist" key="int" value="ZuoqiRankList" cacheCapacity="1"/>
	<!--坐骑排行榜 end-->
	
	<!--人气排行榜 start-->
	<xbean name="PopularRankList">
		<variable name="records" type="list" value="PopularRankRecord" order="1"/> 所有记录
	</xbean>
	<xbean name="PopularRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名字
		<variable name="school" type="int" order="4"/> 门派
		<variable name="popularnum" type="int" order="5"/> 人气值
	</xbean>
	<table name="popularlist" key="int" value="PopularRankList" cacheCapacity="1"/>
	<xbean name="PopularRankRecordMap">
		<variable name="records" type="map" key="long" value="PopularRankRecord" order="1"/> 所有记录
	</xbean>
	<table name="rolepopularrank" key="int" value="PopularRankRecordMap" cacheCapacity="1"/>
	<!--人气排行榜 end-->

	<!--冬日庙会排行榜-->
	<xbean name="TemplefairRankList">
		<variable name="records" type="list" value="TemplefairRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="TemplefairRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="score" type="int" order="5"/> 总评分
	</xbean>
	<table name="templefairlist" key="int" value="TemplefairRankList" cacheCapacity="1"/>
	<!--冬日庙会排行榜-->
	
	<!-- 天机卷排行榜 start -->
	<xbean name="TianjiJuanRankList">
		<variable name="records" type="list" value="TianjiJuanRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="TianjiJuanRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="school" type="int" order="4"/> 门派id
		<variable name="score" type="int" order="5"/> 天机卷评分
	</xbean>
	<table name="tianjijuanlist" key="int" value="TianjiJuanRankList" cacheCapacity="1"/>
	<!-- 天机卷排行榜 end -->
	
	<!--排行榜相关表 end-->
	
	<!--全服排行榜相关表 start-->
	<!--综合实力排行榜-->
	<xbean name="CrossZongheRankList">
		<variable name="records" type="list" value="CrossZongheRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossZongheRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="school" type="int" order="4"/> 门派
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="serverid" type="int" order="6"/> 服务器id
	</xbean>
	<table name="crosszonghelist" key="int" value="CrossZongheRankList" cacheCapacity="1"/>
	<!--综合实力排行榜-->
	
	<!--装备评分排行榜-->
	<xbean name="CrossEquipRankList">
		<variable name="records" type="list" value="CrossEquipRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossEquipRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="serverid" type="int" order="6"/> 服务器id
	</xbean>
	<table name="crossequiplist" key="int" value="CrossEquipRankList" cacheCapacity="1"/>
	<!--装备评分排行榜-->
	
	<!--宠物评分排行榜-->
	<xbean name="CrossPetRankList">
		<variable name="records" type="list" value="CrossPetRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossPetRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="petuniqueid" type="long" order="4"/> 宠物的唯一id
		<variable name="petkey" type="int" order="5"/> 宠物key
		<variable name="petname" type="string" order="6"/> 宠物名称
		<variable name="score" type="int" order="7"/> 总评分
		<variable name="serverid" type="int" order="8"/> 服务器id
	</xbean>
	<table name="crosspetlist" key="int" value="CrossPetRankList" cacheCapacity="1"/>
	<!--宠物评分排行榜-->
	
	<!--奇侠评分排行榜-->
	<xbean name="CrossXiakeRankList">
		<variable name="records" type="list" value="CrossXiakeRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossXiakeRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="serverid" type="int" order="6"/> 服务器id
	</xbean>
	<table name="crossxiakelist" key="int" value="CrossXiakeRankList" cacheCapacity="1"/>
	<!--奇侠评分排行榜-->
	
	<!--阵法评分排行榜-->
	<xbean name="CrossFormationRankList">
		<variable name="records" type="list" value="CrossFormationRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossFormationRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="school" type="int" order="4"/> 门派
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="serverid" type="int" order="6"/> 服务器id
	</xbean>
	<table name="crossformationlist" key="int" value="CrossFormationRankList" cacheCapacity="1"/>
	<!--阵法评分排行榜-->
	
	<!--坐骑评分排行榜-->
	<xbean name="CrossZuoqiRankList">
		<variable name="records" type="list" value="CrossZuoqiRankRecord" order="1"/> 所有的记录
	</xbean>
	<xbean name="CrossZuoqiRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="roleid" type="long" order="2"/> 人物ID
		<variable name="rolename" type="string" order="3"/> 人物名称
		<variable name="level" type="int" order="4"/> 等级
		<variable name="score" type="int" order="5"/> 总评分
		<variable name="serverid" type="int" order="6"/> 服务器id
	</xbean>
	<table name="crosszuoqilist" key="int" value="CrossZuoqiRankList" cacheCapacity="1"/>
	<!--坐骑评分排行榜-->
	
	<!--全服排行榜相关表 end-->
	
	<!-- 单个任务状态 -->
	<xbean name="Task">
		<variable name="id" type="int" order="1"/>
		<variable name="tasktype" type="int" order="2"/> 任务类型参考TaskType
		<variable name="status" type="int" default="0" order="3"/> 任务状态
		<variable name="path" type="vector" value="int" order="4"/> 已完成的任务id
		<variable name="taskvalue" type="int" default="0" order="5"/> 任务所需目标的当前值
		<variable name="deadline" type="long" default="0" order="6"/> 任务有效期（暂未用）
		<variable name="difficulty" type="int" default="0" order="7"/> 任务难度
		<variable name="targetid" type="int" order="8"/> 任务所需的目标id（物品id等）
		<variable name="targetcount" type="int" order="9"/> 任务中的目标次数（如所需道具个数、战斗次数、杀怪个数等）
		<variable name="dstnpcid" type="int" order="10"/> 目的NPCID
		<variable name="dstnpckey" type="long" order="11"/> 目的NPCKey
		<variable name="dstmapid" type="int" order="12"/> 目的mapID
		<variable name="dstx" type="int" order="13"/> 目的坐标x
		<variable name="dsty" type="int" order="14"/> 目的坐标y
		<variable name="dstz" type="int" order="15"/> 目的坐标z
		<variable name="timerfuture" type="long" order="16"/> 限时任务的定时器key
		<variable name="questionId" type="int" order="17"/>	答题任务题号ID
	</xbean>
	
	<xbean name="CommitedScenarioTask">
		<variable name="committed" type="list" value="int" capacity="128" order="1"/>
	</xbean>
	<table name="commitedscenariotask" key="long" value="CommitedScenarioTask" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="AcceptedScenarioTask">
		<variable name="accepted" type="map" key="int" value="Task" capacity="128" order="1"/>
	</xbean>
	<table name="acceptedscenariotask" key="long" value="AcceptedScenarioTask" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	<table name="majorscenariotask" key="long" value="Task" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="ShowingTask">
		<variable name="taskid" type="int" order="1"/>
		<variable name="isleader" type="boolean" order="2"/>
	</xbean>
	<table name="showingtask" key="long" value="ShowingTask" cacheCapacity="8192" lock="rolelock" cachehigh="512" cachelow="256" persistence="MEMORY"/>

	<xbean name="LastBattleResults">
		<variable name="lastbattles" type="list" value="BattleResult" cacheCapacity="10" order="1"/>
	</xbean>
	<table name="lasttaskbattle" key="long" value="LastBattleResults" lock="rolelock" cacheCapacity="8192" cachehigh="512" cachelow="256" persistence="MEMORY"/>
	
	<!-- 人物的特殊任务start  包括师门任务等-->
	<xbean name="SpecialTask">
		<variable name="commoninfo" type="Task" order="1"/> 通用任务信息
		<variable name="round" type="int" order="2"/> 当前任务的环数
		<variable name="sumnum" type="int" order="3"/> 刷新周期内的累积完成次数. 根据不同的任务，拥有不同的含义：师门是每天的累积次数
		<variable name="smallaward" type="int" order="4"/> 小奖励 累计次数
		<variable name="bigaward" type="int" order="5"/> 大奖励 累积次数
		<variable name="lastgiveuptime" type="long" order="6"/> 本次任务放弃的时间，下次任务的可接时间: 已为放弃时间+delay. 0 为没有放弃,
		<variable name="taketasktime" type="long" order="7"/> 接任务的时间,单位毫秒
		<variable name="sametimes" type="int" order="8"/> 相同任务类型的次数
		<variable name="lasttaskid" type="int" order="9"/> 上次的任务id
		<variable name="taketasksumonlinetime" type="long" order="10"/> 接任务时玩家总在线时间.这个仅给师门任务记log用,其他任何时候都不需要这个参数
		<variable name="waiguaround" type="vector" value="int" order="11"/> 师门反外挂答题用
		<!-- 成就系统使用部分 -->
		<variable name="continuousdays" type="int" order="12"/> 连续做满的天数
		<variable name="lastfinishday" type="int" order="13"/> 最后一次做满任务是哪一天,用system.currenttime/一天的毫秒数
		<variable name="continuoustimes" type="int" order="14"/> 连续做的次数
		<variable name="firsttasktime" type="long" order="15"/> 今天第一次接取任务的时间
	</xbean>
	<xbean name="SpecialTaskList">
		<variable name="tasklist" type="list" value="SpecialTask" order="1"/>
	</xbean>
	<table name="rolespecialtasks" key="long" value="SpecialTaskList" cacheCapacity="7000" lock="rolelock"/>  key 为roleid
	
	<!-- 限时类特殊任务的计时器存储 -->
	<xbean name="SpecailTaskFuture" any="true">
		<variable name="questfuture" type="map" key="int" value="java.util.concurrent.ScheduledFuture&lt;?&gt;" capacity="80" order="1"/>
	</xbean>
	<table name="rolespecialtasktimer" key="long" value="SpecailTaskFuture" cacheCapacity="8192" lock="rolelock" persistence="MEMORY"/> key为roleid
	<!-- 人物的特殊任务end-->
	
	<!-- 队伍任务  保存属于队伍部分的任务数据 -->
	<xbean name="TeamTaskInfo">
		<variable name="round" type="int" order="1"/> 队伍任务的当前环数
		<variable name="curtasklib" type="int" order="2"/> 当前正在进行的任务库id  捉鬼优化用
		<variable name="finishedtasks" type="list" value="int" order="3"/> 当前任务库已被完成的任务列表  捉鬼优化用
	</xbean>
	<xbean name="TeamTasks">
		<variable name="tasks" type="map" key="int" value="TeamTaskInfo" order="1"/> key为任务类型 见TaskType 
	</xbean>
	<table name="teamtasks" key="long" value="TeamTasks" cacheCapacity="10240" lock="teamlock" persistence="MEMORY"/> key为teamId
	
	<xbean name="CreateNpcExecType" any="true">
		<variable name="execinstance" type="ares.maplogic.GMCreateNpcExec" order="1"/>
	</xbean>
	<table name="gmcreatenpcuniversal" key="long" value="CreateNpcExecType" persistence="MEMORY" autoIncrement="true"/>
	
	<!-- NPC内存表 -->	
	<xbean name="NpcInfo">
		<variable name="isInBattle" type="int" order="1"/> 0表示不在战斗中,1表示在战斗中,2表示在战斗中且已经到期,战斗结束就要删除
		<!--<variable name="baseId" type="int" />npcBaseId
		<variable name="name" type="string" />npc名称
		<variable name="shape" type="int" />npc造型
		<variable name="scene" type="long" default="-1" /> 场景实例ID，默认为-1，表示还没设置，下同
		<variable name="mapid" type="int" default="-1"  /> 地图ID
		<variable name="posx" type="int" default="-1" /> 坐标x
		<variable name="posy" type="int" default="-1" /> 坐标y
		<variable name="futureId" type="long" default="-1" /> 如果是限时NPC，这里存放npc的future在xtable.Timerfuture中的key-->
		<variable name="beatedNum" type="int" order="2"/> 被攻击的队伍的个数
		<variable name="belongRole" type="long" order="3"/> npc的归属者
		<variable name="createTime" type="long" order="4"/> npc的刷出时间
		<variable name="activityId" type="int" order="5"/> 活动id
		<variable name="score" type="int" order="6"/> score
	</xbean>
	<table name="npcs" type="map" key="long" value="NpcInfo" persistence="MEMORY" cacheCapacity="200000"/> liuchen
	
	<!--上线宝箱-->
	<xbean name="GiftInfo">
		<variable name="giftid" type="int" order="1"/> 玩家已经领了几个宝盒,初始是0
	    <variable name="time" type="long" order="2"/>  上次接受宝盒的时间
		<variable name="remainTime" type="long" order="3"/>距离下次领取剩余时间
		<!-- 转盘部分 -->
		<variable name="nullGrids" type="list" value="int" order="4"/>	空格子
		<variable name="todayUseNum" type="int" order="5"/>	今日已使用次数
		<variable name="lastClearTime" type="long" order="6"/>	上次重置数据时间
	</xbean>
	<table name="onlinegift" type="map" key="long" value="GiftInfo" lock="rolelock" cacheCapacity="7000" foreign="key:properties"/> key为roleid
	<!--上线宝箱 End-->
	
	<!--活跃统计-->
	<xbean name="ActiveRoleInfo">
		<variable name="createroletime" type="long" order="1"/> 创建时间
		<variable name="firsttimeEnter" type="int" order="2"/> 第一次进入服务器 当前天
		<variable name="enterWorldTime" type="long" order="3"/> 最近一次登录游戏的时间
		<variable name="lasttimeEnter" type="int" order="4"/> 最近一次进入服务器 当前天
		<variable name="dayOnline" type="int" order="5"/> 上次更新当前天在线时长的时间（天）
		<variable name="dayOnlineTime" type="int" order="6"/> 在线时长 当前天 分钟为单位
		<variable name="weekOnline" type="int" order="7"/> 上次更新当前周在线时长的时间（周）
		<variable name="weekOnlineTime" type="int" order="8"/> 在线时长 当前周 分钟为单位
		<variable name="lasttimeActiveDay1" type="int" order="9"/> 最近两次活跃的 当前天 day1比day2新,下同
		<variable name="lasttimeActiveDay1OnlineTime" type="int" order="10"/> 最近一次日活跃的在线时长
		<variable name="lasttimeActiveDay2" type="int" order="11"/> 
		<variable name="lasttimeActiveWeek1" type="int" order="12"/> 最近两次活跃的 当前周 week1比week2新,下同
		<variable name="lasttimeActiveWeek1OnlineTime" type="int" order="13"/> 最近一次周活跃的在线时长
		<variable name="lasttimeActiveWeek2" type="int" order="14"/> 
		<variable name="firsttimeActiveDay" type="int" order="15"/> 第一次活跃的 当前天
		<variable name="firsttimeActiveWeek" type="int" order="16"/> 第一次活跃的 当前周
		<variable name="lasttimeChargeDay1" type="int" order="17"/> 最近2次充值的当前天
		<variable name="lasttimeChargeDay2" type="int" order="18"/> 最近2次充值的当前天
		<variable name="lasttimeChargeWeek1" type="int" order="19"/> 最近2次充值的当前周
		<variable name="lasttimeChargeWeek2" type="int" order="20"/> 最近2次充值的当前周
		<variable name="firsttimeChargeDay" type="int" order="21"/> 第一次充值 当前天
		<variable name="firsttimeChargeWeek" type="int" order="22"/> 第一次充值 当前周
		<variable name="lasttimeChargeDay" type="int" order="23"/> 最近一天充值 当前天,理论上跟lasttimeChargeDay1是相等的
		<variable name="lasttimeChargeDayTotalAmount" type="int" order="24"/>最近一天充值的总额 当前天
		<variable name="lasttimeChargeWeek" type="int" order="25"/> 最近一周充值 当前周,理论上跟lasttimeChargeWeek1相等
		<variable name="lasttimeChargeWeekTotalAmount" type="int" order="26"/>最近一周充值的总额 当前周
		<variable name="chargeTotalAmount" type="int" order="27"/> 充值总额
		<variable name="chargeTotalRmb" type="int" order="28"/> 充值rmb总额
		<variable name="yuanbaoConsumeTotalAmount" type="long" order="29"/> 元宝消耗的总量
		<variable name="cashyuanbaoConsumeTotalAmount" type="long" order="30"/> 现金充值元宝消耗的总量
		<variable name="lasttimeYuanbaoConsumeDay" type="int" order="31"/> 最近天 消耗元宝,记录的是天数
		<variable name="lasttimeYuanbaoConsumeDayTotalAmount" type="int" order="32"/> 最近天 消耗的元宝数量
	    <variable name="lasttimeYuanbaoConsumeWeek" type="int" order="33"/> 最近周 消耗元宝,记录的是周数
	    <variable name="lasttimeYuanbaoConsumeWeekTotalAmount" type="int" order="34"/> 最近周 消耗的元宝数量
	    <variable name="yuanbaoBuyTotalAmount" type="long" order="35"/> 元宝购买的总量,给log用,不影响活跃
	    <variable name="yuanbaoSellTotalAmount" type="long" order="36"/> 元宝出售的总量,给log用
	    <variable name="cashYuanbao" type="int" order="37"/> 剩余流通元宝
	    <variable name="bindYuanbao" type="int" order="38"/> 剩余绑定rmb元宝
	    <variable name="sysYuanbao" type="int" order="39"/> 剩余系统赠送元宝
	    <variable name="yuanbaoInPlatform" type="int" order="40"/> 在交易平台里面的挂单元宝
		<variable name="firstChargeAmount" type="int" order="41"/> 属于首充的充值金额
	</xbean>
	<table name="activeroleinfos" key="long" value="ActiveRoleInfo" cacheCapacity="7000" lock="rolelock"/> 
	
	<xbean name="LianyunAwardInfo">
		<variable name="awards" type="map" key="int" value="long" order="1"/>
	</xbean>
	<table name="rolelianyunaward" key="long" value="LianyunAwardInfo" cacheCapacity="7000" lock="rolelock"/>
	<!--活跃统计 End-->
	
	<!-- 新手引导表 -->
	<xbean name="BeginnerTip">
		<variable name="tips" type="map" key="int" value="int" capacity="1024" order="1"/>
		<variable name="skip" type="boolean" order="2"/> 是否跳过 true 跳过  false不跳
	</xbean>
	<table name="beginnertip" key="long" value="BeginnerTip" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="Gather">
		<enum name="GETITEM" value="0"/> 获得物品
		<enum name="LAUNCHBATTLE" value="1"/> 开始战斗
		<variable name="gatherkey" type="long" order="1"/> 采集物key
		<variable name="npcId" type="long" order="2"/> 采集物npcId
		<variable name="result" type="int" order="3"/> 采集的结果,战斗或者获得物品
		<variable name="endgathertime" type="long" order="4"/> 开始采集的时间
	</xbean>
	<table name="gather" key="long" value="Gather" cacheCapacity="8192" cachehigh="512" cachelow="256" persistence="MEMORY" lock="rolelock"/>
	
  	<!-- 从地图模块获取一系列角色然后回调，存放回调接口 -->
	<xbean name="GetRolesCallBackInst" any="true">
		<variable name="callback" type="ares.maplogic.IGetRolesCallBack" order="1"/>
	</xbean>
	<table name="getrolescallback" key="long" value="GetRolesCallBackInst" cacheCapacity="10240" autoIncrement="true" persistence="MEMORY"/>
	
	<xbean name="forbidinfo">
		<variable name="forbidtime" type="long" order="1"/>
		<variable name="reason" type="string" order="2"/>
	</xbean>
	<table name="userid2forbidtime" key="int" value="forbidinfo" cacheCapacity="8192" persistence="MEMORY" lock="userlock"/>

	<table name="roleid2forbidtime" key="long" value="forbidinfo" cacheCapacity="7000" lock="rolelock"/>
	 
	<xbean name="ForbidState">
		<variable name="startTime" type="long" order="1"/>封禁时间
		<variable name="forbidTime" type="int" order="2"/>封禁时长，分钟
	</xbean>
	<xbean name="ForbidStates">
		<enum name="FORBID_LOGIN" value="1"/>
		<enum name="FORBID_TRADE" value="2"/>
		<enum name="FORBID_CHAT" value="3"/>
		<variable name="shutupNum" type="int" order="1"/>
		<variable name="forbidType" type="map" key="int" value="ForbidState" order="2"/>	
	</xbean>
	<table name="forbiduser" key="int" value="ForbidStates" cacheCapacity="7000"/> key=userid 不需要userlock
	<table name="forbidip" key="int" value="ForbidStates" cacheCapacity="7000"/> key=ip
	<table name="forbidmac" key="string" value="ForbidStates" cacheCapacity="7000"/> key=mac
	
	<xbean name="ForbidRoleInfo">
		<variable name="forbidtime" type="long" order="1"/> 封禁到xx时刻
	</xbean>
	<table name="forbidrole" key="long" value="ForbidRoleInfo" cacheCapacity="7000" lock="rolelock"/>
	<!-- 人物统计表 -->
	<xbean name="RoleQuitStatistics">
		<variable name="money" type="long" order="1"/>
		<variable name="smoney" type="long" order="2"/>
		<variable name="exp" type="int" order="3"/>
		<variable name="lastcountdate" type="long" order="4"/> 最近统计钱,储备金,经验的时间
		<variable name="lastrewardidx" type="int" order="5"/> 上次领取奖励序号
		<variable name="rewarddate" type="long" order="6"/> 上次领取上线奖励
	</xbean>
	<table name="rolequitstatistics" key="long" value="RoleQuitStatistics" foreign="key:properties" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
  
	<!-- 活动日历 -->
	<xbean name="DayFinishTask">
		<variable name="taskList" type="list" value="int" order="1"/>
	</xbean>
	<xbean name="ActivityCalendarStatus">
		<variable name="week" type="int" order="1"/> 该记录是今年的第几周的 
		<variable name="dayStatus" type="map" key="int" value="DayFinishTask" order="2"/>
	</xbean>
	<table name="activitycalendar" key="long" value="ActivityCalendarStatus" lock="rolelock" foreign="key:properties" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	<!-- 活动日历End -->
   
	<!-- 活跃度：这个是从玩法角度的活跃度，与统计角度的活跃度不同 -->
	<xbean name="PlayActiveData">
		<variable name="id" type="int" order="1"/>
		<variable name="count" type="int" order="2"/> 完成次数
	</xbean>
	<xbean name="PlayActiveDay">
		<variable name="weekday" type="int" order="1"/>1-7 周1-周日
		<variable name="activeness" type="int" default="0" order="2"/> 今天的活跃度值 
		<variable name="chest" type="int" default="0" order="3"/> 活跃度宝箱，按位，1为已打开
		<variable name="actives" type="map" key="int" value="PlayActiveData" cacheCapacity="7" order="4"/>一天的数据
	</xbean>
	<xbean name="ReceiveChestInfo">
		<variable name="lasttime" type="long" order="1"/> 上次更改数据的时间
		<variable name="chest" type="int" defalut="0" order="2"/>   活跃度宝箱，按位，1为已打开
		<variable name="activity" type="int" order="3"/> 活跃度
	</xbean>
	<xbean name="PlayActiveRole">
		<variable name="week" type="int" order="1"/> 该记录是今年的第几周
		<variable name="receiveChestInfo" type="ReceiveChestInfo" order="2"/> 领取宝箱信息
		<variable name="activedays" type="map" key="int" value="PlayActiveDay" order="3"/> 一周每天的数据
		<variable name="lastweekactivedays" type="map" key="int" value="PlayActiveDay" order="4"/> 跨周清空数据时的备份
	</xbean>
	<table name="playactiveroles" key="long" value="PlayActiveRole" foreign="key:properties" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	<!-- 活跃度End -->
	
	<xbean name="UserPunish">
		<variable name="userid" type="int" order="1"/> 用户id
		<variable name="records" type="list" value="PunishRecord" order="2"/> 封禁记录
		<variable name="releasetime" type="long" order="3"/> 解封的时间,gacd用
		<variable name="waiguaTimes" type="int" order="4"/> 使用外挂的次数,gacd用
		<variable name="sendMsgtime" type="long" order="5"/> 解封后发消息给玩家的时间,如果没有发过消息,为0
	</xbean>
	<xbean name="PunishRecord">
	  	<variable name="userid" type="int" order="1"/> 用户id
	  	<variable name="roleid" type="long" order="2"/> 角色id，roleid为0时是对整个账户的处罚
	  	<variable name="type" type="int" order="3"/> 惩罚类型，参考下面
	  	<variable name="forbidtime" type="long" order="4"/> 封禁的持续时间
	  	
	  	<variable name="gmuserid" type="int" order="5"/> 封禁操作的GM用户id
	  	<variable name="optime" type="long" defalut="0" order="6"/> 操作时间
	  	<variable name="reason" type="string" order="7"/> 原因
	  	
	  	<enum name="TYPE_FORBID_LOGIN" value="1"/>禁止登陆
	  	<enum name="TYPE_SHUTUP" value="2"/>禁言
	  	<enum name="TYPE_UNFORBID_LOGIN" value="3"/>解除禁止登陆
	  	<enum name="TYPE_UNSHUTUP" value="4"/>解除禁言
  	</xbean>
  	<table name="userpunish" key="int" value="UserPunish" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="userlock"/>
  
	<xbean name="FreshcardUsed">
		<variable name="freshcards" type="map" key="string" value="CardInfo" order="1"/> key为具体的码
		<variable name="forbidTypes" type="set" value="string" order="2"/>
		<variable name="sdxlTongMa" type="int" order="3"/> 通码领取奖励 0=没有领取过  1=领取过 	  
	</xbean>
	<xbean name="CardInfo">
		<variable name="userid" type="int" order="1"/> 
		<variable name="roleid" type="long" order="2"/>
		<variable name="useCardTime" type="long" order="3"/> 用掉卡的时间
		<variable name="useCount" type="int" order="4"/> 该码使用的次数
		<variable name="answer" type="string" order="5"/> 新手卡号
		<variable name="parentType" type="int" order="6"/> 父类型
		<variable name="type" type="int" order="7"/> 子类型
	</xbean>
	<table name="rolefreshcard" key="long" value="FreshcardUsed" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="Freshcards">
	  	<variable name="starttime" type="long" order="1"/>
		<variable name="endtime" type="long" order="2"/>
		<variable name="itemid" type="int" order="3"/> 
		<variable name="minlv" type="int" order="4"/> 
		<variable name="maxlv" type="int" order="5"/> 
		<variable name="availableNumber" type="int" order="6"/> 
		<variable name="status" type="int" order="7"/> 
		<variable name="forbidCardtypes" type="set" value="string" order="8"/> 
		<variable name="cardids" type="set" value="string" order="9"/> 
		<variable name="serverids" type="string" order="10"/> 
	</xbean>
	<table name="freshcards" key="string" value="Freshcards" cacheCapacity="1024" cachehigh="512" cachelow="256"/>
  
	<xbean name="CompensationInfo">
		<variable name="receiveAwardTime" type="long" order="1"/> 领取奖励的时间
		<variable name="sendMsgTime" type="long" order="2"/> 是否已经发送过系统通知,记录下发送时间
	</xbean>
	<xbean name="Compensation">
		<variable name="compensationMap" type="map" key="int" value="CompensationInfo" order="1"/> 领取补偿的id
	</xbean>
	<xbean name="LimitItemInfo">
		<variable name="maxNum" type="int" order="1"/> 
		<variable name="num" type="int" order="2"/> 
	</xbean>
	<xbean name="ActivityItemLimit">
		<variable name="limitItemMap" type="map" key="int" value="LimitItemInfo" order="1"/> key为itemid
	</xbean>
	<table name="compensation" key="long" value="Compensation" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="usercompensation" key="string" value="Compensation" cacheCapacity="7000" cachehigh="512" cachelow="256"/> 给user的补偿,一个账户只能给一次
	<table name="awarditemlimit" key="int" value="ActivityItemLimit" cacheCapacity="4000" cachehigh="512" cachelow="256"/>	
	
	<!-- GM手动补偿 -->
	<xbean name="SingleCompensation">
		<variable name="time" type="long" order="1"/>
		<variable name="state" type="int" default="0" order="2"/> 0 = 生效，1 = 取消
		<variable name="roleids" type="list" value="long" cacheCapacity="1000" order="3"/> key = roleid, value = get time
		<variable name="itemId" type="int" order="4"/>
		<variable name="num" type="int" order="5"/>
	</xbean>
	<table name="singlecompensations" key="long" autoIncrement="true" value="SingleCompensation" cacheCapacity="1000" cachehigh="512" cachelow="256"/>
	
	<xbean name="CompensationRole">
		<variable name="singlecompensations" type="map" key="long" value="long" cacheCapacity="20" order="1"/>
	</xbean>
	<table name="compensationroles" key="long" foreign="key:properties" value="CompensationRole" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<!-- GM手动补偿END -->

	<xbean name="ActivityStatus">
		<variable name="id" type="int" order="1"/> 活动的id
		<variable name="baseid" type="int" order="2"/> 活动的baseid
		<variable name="inistarttime" type="long" order="3"/> 活动预计的开始的时间(填在表里的时间)
		<variable name="iniendtime" type="long" order="4"/> 活动预计的结束的时间(填在表里的时间)
		<variable name="laststarttime" type="long" order="5"/> 最近开始的时间
		<variable name="lastendtime" type="long" order="6"/> 最近结束的时间
		<variable name="costtime" type="long" order="7"/> 活动已经过去了多少时间
	</xbean>
	<table name="activitytable" key="int" value="ActivityStatus" cacheCapacity="100" cachehigh="512" cachelow="256"/> 活动表,在服务器中已经开启的活动
  
    <!-- 副本玩法START -->
  	<!-- 副本实例START -->
  	<xbean name="InstanceZone">
		<variable name="instZoneId" type="int" order="1"/>
		<variable name="ownerId" type="long" order="2"/>
		<variable name="zonestatus" type="int" order="3"/> 副本区域当前的状态
		<variable name="hardlevel" type="int" order="4"/> 难度等级，默认为0
		<variable name="extId" type="long" default="-1" order="5"/> 副本如果有额外存储的数据,-1为没有
		<variable name="roleIds" type="list" value="long" cacheCapacity="20" order="6"/>当前在副本内的角色
		<variable name="saves" type="map" key="int" value="InstanceSave" cacheCapacity="20" order="7"/>进度状态
		<variable name="npcs" type="map" key="int" value="InstanceNpc" cacheCapacity="100" order="8"/>副本NPC状态，注意这里保存的是npcid相关的npc状态，不具体到实例
		<variable name="services" type="map" key="int" value="InstanceNpcServ" cacheCapacity="100" order="9"/>副本NPC服务状态，注意这里保存的是serviceid相关的，不具体到哪个npc
		<variable name="loots" type="list" value="InstanceLoot" cacheCapacity="20" order="10"/>副本掉落状态
		<variable name="timers" type="map" key="int" value="InstanceTimer" cacheCapacity="10" order="11"/>副本定时器，key=定时器id
		<variable name="rolequestions" type="map" key="long" value="int" cacheCapacity="10" order="12"/> 玩家正在回答的问题
	
		<enum name="STATUS_INITING" value="0"/> 副本区域正在初始化
		<enum name="STATUS_ACTIVE" value="1"/> 副本区域激活，可以正常进入
		<enum name="STATUS_CLOSING" value="2"/> 副本区域正在进行关闭处理，不能进入
		<enum name="STATUS_CLOSED" value="3"/> 副本区域已关闭
  	</xbean>
  
	<xbean name="InstanceSave">
		<variable name="saveId" type="int" order="1"/>
		<variable name="status" type="int" order="2"/>
		<variable name="subsaves" type="map" key="int" value="int" cacheCapacity="20" order="3"/>子进度状态，value是子进度计数
		<variable name="rolescores" type="map" key="long" value="int" cacheCapacity="10" order="4"/>在此进度中，每个角色的积分
		<variable name="savescore" type="int" order="5"/>完成进度时该进度的分数，如果是组队副本，则是队长的分数
	</xbean>
	  
	<xbean name="InstanceNpc">
		<variable name="npcbaseId" type="int" order="1"/> npcbaseId
		<variable name="status" type="int" order="2"/> 状态 1 显示 2 隐藏
	</xbean>
	  
	<xbean name="InstanceNpcServ">
		<variable name="serviceId" type="long" order="1"/> serviceid
		<variable name="actId" type="int" order="2"/> 0为隐藏，大于0则为某个服务动作的ID，显示出来肯定得有服务动作
	</xbean>
	  
	<xbean name="InstanceLoot">
		<variable name="lootId" type="int" order="1"/>副本奖励id
		<variable name="chests" type="list" value="InstanceChest" cacheCapacity="60" order="2"/>箱子
		<variable name="roleids" type="map" key="long" value="int" cacheCapacity="20" order="3"/>跟此次奖励绑定的角色id,key = roleid, value=剩余箱子个数
	</xbean>
  
	<xbean name="InstanceChest">
		<variable name="chestcfgId" type="int" order="1"/> 宝箱的配置ID（等于宝箱的npcbaseid）
		<variable name="status" type="int" default="0" order="2"/> 状态 0=未开；1=打开
		<variable name="roleId" type="long" default="0" order="3"/>哪个角色打开的，未开为0
		<!--<variable name="sceneid" type="long"/>场景ID
		<variable name="posx" type="int"/>坐标x
		<variable name="posy" type="int"/>坐标y-->
	</xbean>
	  
	<xbean name="InstanceTimer">
		<variable name="status" type="int" order="1"/> 状态 0=未开始；1=已开始；2=已结束
		<variable name="starttime" type="long" order="2"/>开始时间
		<variable name="endtime" type="long" order="3"/>结束时间
		<variable name="futurekey" type="long" order="4"/>在timerfutures中的key
		<enum name="STATUS_UNSTART" value="0"/>
		<enum name="STATUS_START" value="1"/>
		<enum name="STATUS_END" value="2"/>
	</xbean>
	<table name="instancezones" key="long" value="InstanceZone" autoIncrement="true" persistence="MEMORY" cacheCapacity="8192"/>
	<table name="role2instancezone" key="long" value="long" persistence="MEMORY" cacheCapacity="8192" lock="rolelock"/>角色当前在哪个副本玩法中
	<!-- 副本实例END -->
	  	
	<!-- 个人副本进度START -->
	<xbean name="CompleteZoneAward">  完成副本时随机翻牌的奖励信息
		<variable name="itemid" type="int" order="1"/>  奖励的道具id
		<variable name="itemnum" type="int" order="2"/> 奖励的道具数量
		<variable name="flag" type="boolean" order="3"/> 是否已领取
		<variable name="weight" type="int" order="4"/> 获得该奖励的权重
	</xbean>
	<xbean name="OneTypeZoneCompleteInfo">  每种类型副本完成奖励的信息
		<variable name="awardtype" type="int" order="1"/> 0没有资格领奖，1有资格但未领取，2已领取
		<variable name="usednum" type="int" order="2"/> 已经领取的通关奖励次数
		<variable name="lastawardtime" type="long" order="3"/> 上次领取通关奖励的时间
		<enum name="STATUS_NO" value="0"/>
		<enum name="STATUS_CANGET" value="1"/>
		<enum name="STATUS_HAVEGET" value="2"/>	
	</xbean>
	<xbean name="RoleInstanceZones">
		<variable name="singlezonekey" type="long" default="0" order="1"/> 当前拥有的单人副本的key，0为不存在
		<variable name="zones" type="map" key="int" value="RoleInstanceZone" cacheCapacity="20" order="2"/>进度状态 key=zoneid,value=status
		<variable name="completezoneinfos" type="map" key="string" value="OneTypeZoneCompleteInfo" order="3"/> 每类副本的通关奖励信息 key=副本类型名   value=该类副本的通关奖励信息
	</xbean>
	
	<xbean name="RoleSaveInfo">
		<variable name="status" type="int" order="1"/>
		<variable name="score" type="int" order="2"/>
	</xbean>
	
	<xbean name="RoleInstanceZone">
		<variable name="instZoneId" type="int" order="1"/> 副本玩法id
		<variable name="refreshtime" type="long" order="2"/> 刷新时间
		<variable name="refreshcount" type="int" order="3"/> 在刷新时间内已刷新的次数
		<variable name="saveinfos" type="map" key="int" value="RoleSaveInfo" cacheCapacity="20" order="4"/>进度状态
		<variable name="hardlevel" type="int" order="5"/> 进入副本的难度
		<variable name="hasComplete" type="int" order="6"/> 是否完成标志位
	</xbean>
	<table name="roleinstancezones" foreign="key:properties" lock="rolelock" key="long" value="RoleInstanceZones" cacheCapacity="7000"/>
	<!-- 个人副本进度END -->
	<!-- 副本玩法END -->
  
	<!-- 副本中保存个人永久信息-->
	<xbean name="ConstantInstanzoneData">
		<variable name="instZoneId" type="int" order="1"/> 副本玩法id
		<variable name="saveCGFlag" type="map" key="int" value="int" cacheCapacity="20" order="2"/>key=进度id，value=1表示已经播放
		<variable name="saveawradtimes" type="map" key="int" value="int" order="3"/> key=进度id，value=刷新周期内的累积领奖次数
		<variable name="hasComplete" type="int" order="4"/> 是否完成标志位
	</xbean>
	
	<xbean name="ConstantInstanzoneDatas">
		<variable name="zones" type="map" key="int" value="ConstantInstanzoneData" cacheCapacity="20" order="1"/>key=zoneid,value=副本数据
	</xbean>
	<table name="constantinstanzone" foreign="key:properties" lock="rolelock" key="long" value="ConstantInstanzoneDatas" cacheCapacity="7000"/>
	
	<!-- 日常副本START -->
	<xbean name="DailyInstanceZone">
		<variable name="finalscore" type="int" order="1"/> 最后得分
		<variable name="roleawards" type="map" key="long" value="int" order="2"/> 已领奖励个数
	</xbean>
	<table name="dailyzones" key="long" value="DailyInstanceZone" persistence="MEMORY" lock="instancezones" cacheCapacity="8192"/>  
	
	<xbean name="TodayDailyInstanceZone">
		<variable name="taodayFubenId" type="int" order="1"/> 今日日常副本id
		<variable name="refreshtime" type="long" order="2"/> 最后一次刷新时间
	</xbean>	
	
	<table name="todaydailyzone" key="int" value="TodayDailyInstanceZone" cacheCapacity="1"/> 
	<!-- 日常副本END -->
	
	<xbean name="TimeLimitInfo">   
		<variable name="requestName" type="long" order="1"/>
		<variable name="activeUser" type="long" order="2"/>
	</xbean>
	<table name="qiantong" key="int" value="TimeLimitInfo" persistence="MEMORY" cacheCapacity="8192"/>  
	
	<cbean name="ExpStateKey">
		<variable name="pathway" type="int" order="1"/> 各个途径的经验统计信息
		<variable name="levelSpace" type="int" order="2"/> 各个等级段（5，10，15……）
	</cbean>
	
	<table name="expstate" key="ExpStateKey" value="long" cacheCapacity="4096" cachehigh="512" cachelow="256"/>
	
	<xbean name="QuickPayInfo">
		<variable name="mintVector" type="vector" value="int" order="1"/> 绑定的支付商信息
	</xbean>
	<table name="quickpay" key="int" value="QuickPayInfo" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="userlock"/> key为userid
	
	<xbean name="PlatformInfo">
		<variable name="id" type="int" order="1"/> 商家id
		<variable name="name" type="string" order="2"/> 商家名，UTF-16LE编码
		<variable name="discount" type="int" order="3"/> 折扣介于1-100之间	
	</xbean>
	<table name="payplatform" key="int" value="PlatformInfo" cacheCapacity="50" cachehigh="512" cachelow="256"/> key为支付平台id

	<xbean name="ServerRoles">
	    <variable name="rolenum" type="int" order="1"/>
	    <variable name="createtime" type="long" order="2"/>
	</xbean>
	<table name="rolenumfornewserver" key="int" value="ServerRoles" cacheCapacity="1" cachehigh="512" cachelow="256"/>
	
	<!--单人及多人品剑-->
	<xbean name="SPvPFightReport"> 竞技场战斗历史
		<variable name="result" type="int" order="1"/>  1=我对xx胜利, 2=我对xx胜利并且连胜 3=xx打败了我 4=xx打败了我 并且终结了我的胜利
		<variable name="params" type="list" value="string" order="2"/>
		<variable name="time" type="long" order="3"/>  结束时间
	</xbean>
	<xbean name="SPvPFightReports">
		<variable name="spvpfightreports" type="list" value="SPvPFightReport" order="1"/>
		<variable name="createtime" type="long" order="2"/>  战斗时间
	</xbean>
	<xbean name="SPvPReportTypes">
		<variable name="pvpType2Reports" type="map" key="int" value="SPvPFightReports" order="1"/> 根据不同pvp类型存储个人数据
	</xbean>
	<table name="spvprolefightreports" key="long" value="SPvPReportTypes" cacheCapacity="7000" lock="rolelock"/> 竞技场角色相关的战斗日志
	
	<xbean name="ChestInfo"> 宝箱状态
		<variable name="chesttype" type="int" order="1"/>  n连胜或n连战
		<variable name="result" type="int" order="2"/> 结果 0代表没有领取 1代表已经领取
	</xbean>
	<xbean name="SPvPRole"> 单人pvp记录
		<variable name="lastbattletime" type="long" order="1"/> 上次战斗结束的时间，以此来计算相关数据是不是本场或者本赛季
		<variable name="lastbattletimeweek" type="long" order="2"/> 上次战斗结束的时间，以此来计算相关数据是不是本场或者本赛季
		<variable name="combowinnum" type="int" order="3"/> 连胜次数，失败或者跨赛季清零
		<variable name="maxcombowinnum" type="int" order="4"/> 最大连胜次数，跨赛季清零
<!--		<variable name="combowinaward" type="list" value="ChestInfo"/> 连胜 每次清 -->
		<variable name="firstwinaward" type="int" order="5"/> 首胜	每次清
		<variable name="combobattleaward" type="list" value="ChestInfo" order="6"/> n战	每次清
		<variable name="winbattleaward" type="list" value="ChestInfo" order="7"/> 胜利	每次清
		<variable name="battlenum" type="int" order="8"/> 比赛的次数 每次清
		<variable name="winnum" type="int" order="9"/> 本场比赛的赢的次数	每次清
		<variable name="lastenemyid" type="long" order="10"/> 上次战斗的角色id
		<variable name="lastentertime" type="long" order="11"/> 上次进入赛场时间
		<variable name="allbattlenum" type="int" order="12"/> 比赛的次数 每周清
		<variable name="allwinnum" type="int" order="13"/> 一届封王赛季前赛赢的次数，每周清
		<variable name="clearTime" type="long" order="14"/> 清数据时的时间
		<variable name="captainWinNum" type="int" order="15"/> 多人品剑时作为队长带队胜利场次
		<variable name="combowlosenum" type="int" order="16"/> 连败次数，每次活动清
		<variable name="spvpscore" type="int" order="17"/> 积分
		
		<variable name="lastSeasonid" type="int" order="18"/> 第几届武道会
		<variable name="lastFightRoleIds" type="list" value="long" order="19"/>  最后三场战斗过的角色id
		<variable name="battleWin" type="int" order="20"/> 季后赛胜利次数
		<variable name="battleLost" type="int" order="21"/> 季后赛失败次数
		<variable name="lastOutBattleTime" type="long" order="22"/> 出战斗时间
	</xbean>
	<xbean name="SPvPRoleTypes">
		<variable name="pvpType2Role" type="map" key="int" value="SPvPRole" order="1"/> 根据不同pvp类型存储个人数据
	</xbean>
	<table name="spvprole" key="long" value="SPvPRoleTypes" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="SPvPRaceRole"> 赛场中的角色
		<variable name="roleid" type="long" order="1"/>
		<variable name="name" type="string" order="2"/>
		<variable name="score" type="int" order="3"/> 积分
	</xbean>
	
	<xbean name="SPvPRaceRoleWins"> 赛场中的角色
		<variable name="roleid" type="long" order="1"/>
		<variable name="name" type="string" order="2"/>
		<variable name="combonum" type="int" order="3"/> 连胜次数
	</xbean>
	
	<xbean name="SPvPQueueRole"> 等待队列中的角色
		<variable name="roleid" type="long" order="1"/>
		<variable name="enterqueuetime" type="long" order="2"/> 进入队列的时间
		<variable name="comboWinNum" type="int" order="3"/> 连胜
		<variable name="comboLoseNum" type="int" order="4"/> 连败
		<variable name="totalFightPower" type="int" order="5"/> 玩家即时战力
	</xbean>
	<xbean name="SPvPRace"> 赛场
		<variable name="watingQueue" type="list" value="SPvPQueueRole" cacheCapacity="300" order="1"/> 等待序列
		<variable name="joinRoles" type="set" value="long" order="2"/> 记录参加本次活动的roleid，用于活动结束时发宝箱奖励
		<variable name="comboWinQueueCount" type="int" order="3"/> 连胜队列连续未匹配次数，超过某个值就强行匹配
		<variable name="comboLoseQueueCount" type="int" order="4"/> 连败队列连续未匹配次数，超过某个值就强行匹配
	</xbean>
	<table name="spvpraces" key="int" value="SPvPRace" lock="spvpgradelock" cacheCapacity="8" cachehigh="512" cachelow="256"/>
	
	<table name="spvproles" key="long" value="SPvPRole" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="EnterRole"> 等待队列中的角色
		<variable name="roleid" type="long" order="1"/>
		<variable name="lastOutBattleTime" type="long" order="2"/> 出战斗时间
		<variable name="flag" type="int" order="3"/> 战斗状态 0=空闲 1=战斗中 2=战败或者主动离开PK地图
		<variable name="battleWin" type="int" order="4"/> 胜利次数
		<variable name="battleLost" type="int" order="5"/> 失败次数
		<variable name="outmapIndex" type="int" order="6"/>
		<variable name="awardid" type="int" order="7"/>
	</xbean>
	
	<xbean name="SPvPGrade"> 赛级
		<variable name="currentTimes" type="int" order="1"/> 第几场
		<variable name="seasonid" type="int" order="2"/> 第几届武道会
		<variable name="lastEndTime" type="long" order="3"/> 上一次结束时间
		<variable name="jueSaiRolesId" type="list" value="long" order="4"/> 进阶到决赛的角色id
		<variable name="enterRolesId" type="map" key="long" value="EnterRole" order="5"/>角色id value=上一场的战斗时间
		<variable name="outmapIndex" type="int" order="6"/> 每离开一个+1
		<variable name="gjRoleid" type="long" order="7"/>
		<variable name="firstClear" type="int" order="8"/> 0=清除
		<variable name="outRoleIds" type="list" value="long" order="9"/> 进阶到决赛的角色id
		<variable name="seasonEndTime" type="long" order="10"/> 用来记录一届封王赛（季后赛）结束的时间
	</xbean>
	<table name="spvpgrades" key="int" value="SPvPGrade" cacheCapacity="1"/>
	
	<xbean name="SPvPChampion"> 历届王者
		<variable name="time" type="long" order="1"/> 封王时间
		<variable name="championRoleid" type="long" order="2"/> 王者Roleid
		<variable name="wuxun" type="int" order="3"/> 封王时的战功
	</xbean>
	<xbean name="SPvPChampions">
		<variable name="champions" type="list" value="SPvPChampion" order="1"/>
	</xbean>
	<table name="spvpchampions" key="int" value="SPvPChampions" cacheCapacity="1"/>
	
	<xbean name="SeansonBattle">
		<variable name="left" type="long" order="1"/>
		<variable name="right" type="long" order="2"/>
	</xbean>
	<xbean name="SeansonBattles">
		<variable name="seansonbattles" type="map" key="long" value="SeansonBattle" order="1"/>	
	</xbean>
	<table name="seansonbattle" key="int" value="SeansonBattles" cacheCapacity="1"/>
	
	<!--单人及多人品剑 END-->
	
	<!--品剑 胜利次数排行 start-->
	<xbean name="RoleAllWinNumBean">
		<variable name="roleid" type="long" order="1"/> 
		<variable name="spvpscore" type="int" order="2"/> 积分
	</xbean>
	<xbean name="RoleAllWinNumList">
		<variable name="createtime" type="long" order="1"/> 创建时间时间
		<variable name="records" type="list" value="RoleAllWinNumBean" order="2"/> 所有的记录
	</xbean>
	<table name="allwinnumranklist" key="int" value="RoleAllWinNumList" cacheCapacity="3"/>
	<!--品剑 胜利次数排行 end-->
	
	<!--pvp 积分 start-->
	<xbean name="RoleScoreBean">
		<variable name="roleid" type="long" order="1"/> roleid(当是npc的时候 记录的是npc的id)
		<variable name="roleName" type="string" order="2"/> 玩家的名字
		<variable name="historyScore" type="int" order="3"/> 分数
		<variable name="school" type="int" order="4"/>	  门派
		<variable name="fightPower" type="int" order="5"/> 战斗力
		<variable name="flag" type="int" order="6"/> 1=npc
		<variable name="shape" type="int" order="7"/> 角色模型
		<variable name="level" type="int" order="8"/>	 角色等级
	</xbean>
	<xbean name="RoleScoreList">
		<variable name="lastUpdateTime" type="long" order="1"/> 最后一次更新记录的时间
		<variable name="records" type="list" value="RoleScoreBean" order="2"/> 所有的记录
	</xbean>
	<table name="rolescoreranklist" key="int" value="RoleScoreList" cacheCapacity="1"/>
	<table name="protecttime" key="int" value="long" cacheCapacity="1"/>（第一次折算积分的保护时间超过这个保护时间跨月才能折算积分 日期为开服时间15天）
	
	<!--离线pk start-->
	//角色造型缓存到内存    取一个 缓存一个
	<xbean name="XiaKeFinalAttrs">	
		<variable name="finalattrs" type="map" key="int" value="float" capacity="50" order="1"/> key = attr type
		<variable name="skills" type="map" key="int" value="int" order="2"/>技能列表 key=技能id  value=技能等级
		<variable name="xiakeLevel" type="int" order="3"/>
		<variable name="color" type="int" order="4"/>侠客颜色
		<variable name="stage" type="int" order="5"/> 远征玩法新加stage
	    <variable name="xiakeMp" type="int" order="6"/> 远征玩法新加xiakeMp
	</xbean>
	
	<xbean name="petFinalAttrs">	
		<variable name="petName" type="string" order="1"/> 
		<variable name="petTemplateId" type="int" order="2"/>
		<variable name="petLevel" type="int" order="3"/>
		<variable name="shape" type="int" order="4"/>
		<variable name="finalAttrs" type="map" key="int" value="float" order="5"/> 最后一个参战宠物的属性
		<variable name="color" type="int" order="6"/>宠物颜色
		<variable name="prefix" type="int" order="7"/> 前缀
		<variable name="skills" type="map" key="int" value="int" order="8"/>技能列表 key=技能id  value=技能等级
	</xbean>
	
	<xbean name="RoleOffLinePropBean">
		<variable name="formId" type="int" order="1"/> 阵法
		<variable name="formLevel" type="int" order="2"/> 阵法等级
		<variable name="roleFinalAttrs" type="map" key="int" value="float" order="3"/>角色的属性 key = attr type
		<variable name="petFinalAttr" type="petFinalAttrs" order="4"/> 最后一个参战宠物的属性
		<variable name="XiaKeFinalAttrsMap" type="map" key="int" value="XiaKeFinalAttrs" order="5"/>侠客列表
		<variable name="defendAttrs" type="map" key="int" value="float" order="6"/> 阵法灵珠/水晶属性
	</xbean>
	//角色相关的属性保存   包括宠物 侠客的 战斗属性
	<table name="roleofflineproperties" key="long" value="RoleOffLinePropBean" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	
	<xbean name="MessageBean">  历史消息列表
		<variable name="time" type="long" order="1"/> 时间 
		<variable name="roleName" type="string" order="2"/> 角色名字
		<variable name="roleid" type="long" order="3"/> 角色id 
		<variable name="messageType" type="int" order="4"/> 消息类型  1 2 3 4（2是己方战败 可以反击）
		<variable name="rank" type="int" order="5"/>
		<variable name="rankIsChange" type="short" order="6"/>
		<variable name="fight" type="int" order="7"/> 是否反击过
		<variable name="exp" type="int" order="8"/>
		<variable name="money" type="int" order="9"/>
		<variable name="shape" type="int" order="10"/>
		<variable name="emroleid" type="long" order="11"/> 对手排名
		<variable name="isnpc" type="boolean" default="false" order="12"/> 对手排名
	</xbean>
	
	<xbean name="ChangeBean">
		<variable name="name" type="string" order="1"/> 名字
		<variable name="roleId" type="long" order="2"/> 角色Id
		<variable name="shape" type="int" order="3"/>外形
		<variable name="flag" type="int" order="4"/> 1=npc
		<variable name="school" type="int" order="5"/>
		<variable name="fightPower" type="int" order="6"/> 战斗力
		<variable name="isOpen" type="int" order="7"/>是否翻了该对手 0-否 1-是
		<variable name="battleId" type="int" order="8"/>
	</xbean>
	
	<xbean name="RolePKRefreshBean">
		<variable name="randomRanks" type="map" key="int" value="ChangeBean" order="1"/> 随机战对手 key为要挑战者的排名
		<variable name="paiweiRanks" type="map" key="int" value="ChangeBean" order="2"/> 排位战对手 key为要挑战者的排名
		<variable name="lastReqTime" type="long" order="3"/> 最后一次请求的时间
		<variable name="currentPkTimes" type="int" order="4"/> 当前已经pk的次数
		<variable name="takeAwardFlag" type="int" order="5"/> 1=领取过10战奖励
		<variable name="MaxPKTimes" type="int" order="6"/>(默认是10次)
		<variable name="messList" type="list" value="MessageBean" order="7"/> 战斗消息
		<variable name="lastRank" type="int" order="8"/>排名
		<variable name="comwin" type="int" order="9"/>连胜次数
		<variable name="slogan" type="string" order="10"/>口号
		<variable name="setSloganTime" type="long" order="11"/>上次设置口号时间
		<variable name="maxRank" type="int" order="12"/>历史最高排名
		<variable name="lastClimbAward" type="int" order="13"/>上次领取的攀登奖
		<variable name="fiveRecord" type="list" value="int" order="14"/>最近5场比赛结果
	</xbean>
	<table name="rolepkrefresh" key="long" value="RolePKRefreshBean" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="LadderInfo">
		<variable name="school" type="int" order="1"/>
		<variable name="rolename" type="string" order="2"/> 角色名
		<variable name="fightPower" type="int" order="3"/> 战斗力
		<variable name="flag" type="int" order="4"/> 1=npc
		<variable name="shape" type="int" order="5"/>外形
		<variable name="fighting" type="int" order="6"/>是否处于战斗中 1=战斗中
		<variable name="roleId" type="long" order="7"/> 角色id
		<variable name="level" type="int" order="8"/>	 角色等级
		<variable name="lastPkTime" type="long" order="9"/>角色上次被pk的时间
		<variable name="battleId" type="int" order="10"/> 
	</xbean>
	
	<xbean name="LadderMap">
	      <variable name="ladderRankMap" type="map" key="int" value="LadderInfo" order="1"/> key为要挑战者的排名
	</xbean>
	<table name="pvpladder" type="map" key="int" value="LadderMap" cacheCapacity="1"/>
	<!--离线pk end-->
	
	<xbean name="RankingTitleInfo">
		<variable name="titleRoles" type="list" value="long" capacity="32" order="1"/> list存的是roleid
	</xbean>
	<table name="roserankingtitles" key="int" value="RankingTitleInfo"/> key为titleid，用于保存合服后，每个服务器的获得鲜花宝贝称谓的角色
	
	<xbean name="ModifyNameRole">
		<variable name="lastBuytime" type="long" order="1"/> 上次购买的时间
		<variable name="lastModtime" type="long" order="2"/> 上次改名的时间
		<variable name="buyCount" type="int" default="0" order="3"/> 记录已经购买的次数
		<variable name="modCount" type="int" default="0" order="4"/> 记录已经修改名字的次数
	</xbean>
	<table name="modnameitemroles" key="long" value="ModifyNameRole" lock="rolelock" cacheCapacity="7000"/> 记录角色购买改名道具信息
	
	<!-- 充值订单   开始-->
	<xbean name="ChargeOrder">
	  <variable name="status" type="int" order="1"/>
		<variable name="platformSn" type="string" order="2"/> 充值的平台的sn
		<variable name="platType" type="string" order="3"/> 来自哪个平台的充值
		<variable name="platformUid" type="string" order="4"/> 充值的平台的账号id
		<variable name="receipt" type="string" order="5"/> 只有苹果官方平台才有
		<variable name="transcationid" type="string" order="6"/> 只有苹果官方平台才有
		<variable name="roleid" type="long" order="7"/> 充值的角色id
		<variable name="num" type="int" order="8"/> 充值金额
		<variable name="goodid" type="int" order="9"/>
		<variable name="goodnum" type="int" order="10"/>
		<variable name="createTime" type="long" order="11"/>
		<variable name="userid" type="int" order="12"/> 充值的userid
		<variable name="retryTimes" type="int" default="10" order="13"/> 超过10次单子被标记为失败
		<variable name="extinfo" type="string" order="14"/> 生成充值订单时的额外信息（赠送时装使用）
		<enum name="STATE_SENDED" value="1"/> 已通知客户端
		<enum name="STATE_CONFIRMED" value="2"/> 已确认并且发放
		<enum name="STATE_FAILED" value="4"/> 确认失败的
	</xbean>
	<xbean name="ChargeHistory"> 
		<variable name="charges" type="map" key="long" value="ChargeOrder" capacity="40" order="1"/>
	</xbean>
	<xbean name="AppstoretidStatus"> 
		<variable name="chargesn" type="long" order="1"/>  
		<variable name="status" type="int" order="2"/> 0处理中,1充值成功,2充值失败
	</xbean>
	<table name="chargeorder" key="long" value="ChargeOrder" cacheCapacity="4096" autoIncrement="true"/>
	<table name="failedchargeorder" key="long" value="ChargeOrder" cacheCapacity="4096"/>
	<table name="chargehistory" key="long" value="ChargeHistory" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	<table name="appstoretidstatus" key="long" value="AppstoretidStatus" cacheCapacity="4096"/>
	
	<xbean name="CheckChargeFutureInfo" any="true">
	    <variable name="checkChargeFuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/> 自动提交任务的定时器
	</xbean>
	<table name="checkchargefuture" key="long" value="CheckChargeFutureInfo" persistence="MEMORY" cacheCapacity="10240"/> key = chargesn
	<!-- 充值订单   结束-->
	
	<xbean name="FanPaiInfo"> 角色的所有的牌信息
		<variable name="serviceid" type="int" order="1"/> 这次翻牌的来源
		<variable name="takeFlag" type="int" order="2"/>0=奖励没有提取过   1=提取过
		<variable name="baseMoney" type="int" order="3"/>金钱的基数(在翻倍的时候用得上)
		<variable name="baseSMoney" type="int" order="4"/>
		<variable name="baseExp" type="int" order="5"/>
		<variable name="index" type="int" order="6"/> 真正中奖的那个item的下标
		<variable name="wheelItems" type="vector" value="WheelItem" capacity="4" order="7"/> 4张牌
	</xbean>
	<table name="rolefanpai" key="long" value="FanPaiInfo" lock="rolelock" foreign="key:properties" cacheCapacity="7000"/>
	
	
	<xbean name="RoleFutureNotifyMap" any="true">
		<variable name="notifyMap" type="map" key="int" value="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>
	</xbean>
	<xbean name="RolesNotifyMap" any="true">
		<variable name="rolesFutureMap" type="map" key="long" value="RoleFutureNotifyMap" order="1"/>
	</xbean>
	<table name="notify" type="map" key="int" value="RolesNotifyMap" cacheCapacity="1" persistence="MEMORY"/>
	
	<xbean name="PresentWelfare">
	    <!-- 累计登录礼包 -->
	    <variable name="lastupdate" type="long" order="1"/>更新时间
		<variable name="days" type="int" order="2"/> 累计登录天数 超过7天后置1
		<variable name="takeFlags" type="int" order="3"/> 是否领取过奖励 0=没领取过  1=领取过奖励
		<!-- 上线礼包 -->
		<variable name="todayGainNum" type="int" order="4"/>今日已领次数,每日3次
		<!-- 体力礼包 -->
		<variable name="tiliFlag" type="list" value="int" order="5"/>领取体力的情况 value=领过的ID
		<!-- 升级礼包 -->
		<variable name="takeLevelAwardFlag" type="int" order="6"/>冲级大礼包    领取奖标识
	</xbean>
	<table name="rolepresent" key="long" value="PresentWelfare" foreign="key:properties" lock="rolelock" cacheCapacity="7000"/>
	
	<!-- 阵营相关数据    开始-->
	<!-- 投票类数据表，key为团队id-->
	<xbean name="Position">
		<variable name="posx" type="float" order="1"/> x
		<variable name="posy" type="float" order="2"/> y
		<variable name="posz" type="float" order="3"/> z
	</xbean>
	<xbean name="votePvpMapData">
		<variable name="voteMapId" type="int" order="1"/> 要跳转的地图id
		<variable name="voteMembers" type="map" key="long" value="int" order="2"/> key为队员的id，value为投票意见，1==同意，0==不同意
		<variable name="allVoteMembers" type="list" value="long" order="3"/> 本次投票者的roleids
		<variable name="createtime" type="long" order="4"/> 创建时间
	</xbean>
	<table name="teamvotepvpmap" key="long" value="votePvpMapData" cacheCapacity="4096" persistence="MEMORY" lock="teamlock"/>
	
	<!--更换阵营定时器-->
	<xbean name="ChangeCampFutureInfo" any="true">
		<variable name="reqchangecampremindfuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/> 请求更换12小时提醒邮件的定时器
		<variable name="changecampfuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="2"/> 请求24小时更换阵营定时器
		<variable name="changecampconfirmfuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="3"/> 48小时的更换阵营确认定时器
	</xbean>
	<table name="changecampfuture" type="map" key="long" cacheCapacity="10240" value="ChangeCampFutureInfo" persistence="MEMORY" lock="factionlock"/>
	
	<!--更换阵营信息表-->
	<xbean name="ChangeCampInfo">		
		<variable name="reqchangecamptime" type="long" order="1"/> 请求更换阵营时间
		<variable name="changecampstate" type="int" defalut="0" order="2"/> 请求更换阵营状态
		<variable name="changecampsuccesstime" type="long" order="3"/> 更换阵营成功的时间		
		
		<enum name="NO_REQ_CHANGE_CAMP" value="0"/> 没有请求更换阵营状态
		<enum name="REQ_CHANGE_CAMP" value="1"/> 请求更换阵营状态
		<enum name="CHANGE_CAMP_SUCCESS" value="2"/> 更换阵营成功
	</xbean>
	<table name="changecamp" key="long" value="ChangeCampInfo" lock="factionlock" cacheCapacity="4096" cachehigh="512" cachelow="256"/> 更换阵营表
	
	<xbean name="roleCampInfo">
		<variable name="camptype" type="int" order="1"/> 0=中立  1= 北府 2= 南廷
		<variable name="firstrandomcamp" type="boolean" default="false" order="2"/> 是否第一次使用顺应天命 false-没有 true-有
		<variable name="leavecampcount" type="int" order="3"/> 离开阵营次数
		<variable name="lastleavecamptime" type="long" order="4"/>最后一次退出阵营的时间
		<!--<variable name="contributecount" type="int" order="5"/>捐献次数
		<variable name="lastcontributetime" type="long" order="6"/>最后一次捐献时间-->
		<variable name="receivesalary" type="boolean" order="7"/> 是否领取阵营俸禄
		<variable name="lastreceivesalarytime" type="long" order="8"/>最后一次领取阵营俸禄时间
		<variable name="wuxun" type="int" order="9"/> 武勋值
		
		<variable name="todayaddwuxun" type="int" order="10"/> 今日获得武勋值
		<variable name="lastlosttime" type="long" order="11"/> 最后一次野外pvp失败时间
		<variable name="updatepktime" type="long" order="12"/>更新野外pk时间 （今日获得武勋、pk失去武勋、杀死人的次数）
		<variable name="pklostwuxun" type="int" order="13"/> pk失去的武勋值
		<variable name="killeds" type="map" key="long" value="int" order="14"/> key=被杀的角色Id value=被杀的次数
		
		<variable name="robnum" type="int" order="15"/> 抢劫次数 (掠夺)
		<variable name="berobednum" type="int" order="16"/> 被抢劫次数 (掠夺)
		<variable name="robrolenum" type="map" key="long" value="int" order="17"/>抢劫玩家次数 (掠夺)
		
		<variable name="lastupdatewuxuntime" type="long" order="18"/> 上一次更新武勋值得时间
		<variable name="weekaddwuxun" type="int" order="19"/> 本周获得武勋
		<variable name="weekaward" type="boolean" order="20"/> 是否领取本周获得武勋奖励
		<variable name="weekawardtime" type="long" order="21"/> 领取本周获得武勋奖励时间
		
		<variable name="changecamptimes" type="int" order="22"/>更换阵营次数
		<variable name="subfactionmoneycount" type="int" order="23"/> 扣除帮派资金的次数
		<variable name="lastsubfactionmoneytime" type="long" order="24"/> 最后一次扣除帮派资金的时间
		
		<variable name="todaygaingodscore" type="int" order="25"/> 每日获得神兵积分
		<variable name="todaylosegodscore" type="int" order="26"/> 每日失去神兵积分
		<variable name="lastgodscoretime" type="long" order="27"/> 最后一次神兵积分变动时间
		<variable name="campposition" type="int" order="36"/> 官职
		
		<!--阵营战使用的字段-->
		<variable name="todayScore" type="int" order="28"/> 今日阵营战获得的积分
		<variable name="enterBattleFieldTime" type="long" order="29"/> 进入战场的时间
		<variable name="lastBattleTime" type="long" order="30"/> 最后一场战斗时间
		<variable name="awardstate" type="boolean" order="31"/> 三战奖励领取状态
		<variable name="winTimes" type="int" order="32"/> 胜利次数
		<variable name="lostTimes" type="int" order="33"/> 失败次数
		<variable name="comwin" type="int" order="34"/> 连胜次数
		<variable name="effects" type="map" key="int" value="float" order="35"/>
	</xbean>
	<table name="role2camp" key="long" value="roleCampInfo" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/> 角色阵营相关数据
	
	<xbean name="CampInfo">
		<variable name="tangNumber" type="int" order="1"/> 北府当前人数
		<variable name="suiNumber" type="int" order="2"/> 南廷当前人数
	</xbean>
	<table name="campinfo" key="int" value="CampInfo" cacheCapacity="1"/> key=1  阵营相关数据

	<xbean name="GoldTeamInfo">
		<variable name="teamId" type="long" order="1"/> 
		<variable name="score" type="int" order="2"/>
		<variable name="members" type="list" value="long" order="3"/> 
	</xbean>
	
	<xbean name="CampBattle">
		<variable name="tangScore" type="int" order="1"/> 北府积分
		<variable name="suiScore" type="int" order="2"/> 南廷积分
		<variable name="tanggoldteam" type="list" value="GoldTeamInfo" order="3"/> 北府精英队
		<variable name="suigoldteam" type="list" value="GoldTeamInfo" order="4"/> 南廷精英队
		<variable name="buff" type="int" order="5"/> 复仇buff
		<variable name="tangroles" type="set" value="long" order="6"/> 战场北府玩家
		<variable name="suiroles" type="set" value="long" order="7"/> 战场南廷玩家
	</xbean>
	<table name="campbattle" key="int" value="CampBattle" cacheCapacity="1" lock="campbattlelock" persistence="MEMORY"/> key=1  阵营战
	
	<xbean name="CampBattleRoles">
		<variable name="tangroles" type="set" value="long" order="1"/> 北府参战人员
		<variable name="suiroles" type="set" value="long" order="2"/> 南廷参战人员
	</xbean>
	<table name="campbattleroles" key="int" value="CampBattleRoles" cacheCapacity="1" lock="campbattlelock" persistence="MEMORY"/> key=1  记录阵营战所有参战玩家,用于活动结束发奖
	
	<xbean name="CampBattleRankInfo">
		<variable name="roleid" type="long" order="1"/> 角色id
		<variable name="name" type="string" order="2"/> 角色名
		<variable name="camp" type="int" order="3"/> 阵营
		<variable name="score" type="int" order="4"/> 积分
		<variable name="school" type="int" order="5"/> 门派
	</xbean>
	<xbean name="CampBattleRankBean">
		<variable name="rank" type="list" value="CampBattleRankInfo" order="1"/> 
	</xbean>
	<xbean name="CampBattleRank">
		<variable name="ranks" type="map" key="int" value="CampBattleRankBean" order="1"/> 1北府 2南廷 3总榜
		<variable name="rankRoles" type="map" key="long" value="CampBattleRankInfo" order="2"/> 用于点击排行榜显示自己相关数据
	</xbean>
	<table name="campbattleranks" key="int" value="CampBattleRank" cacheCapacity="2"/> key=1  阵营战排行榜 1为本届 2为上届
	
	<xbean name="HonourRecord">
		<variable name="roleid" type="long" order="1"/> 角色id
		<variable name="name" type="string" order="2"/> 角色名
		<variable name="title" type="string" order="3"/> 称谓
		<variable name="wuxun" type="int" order="4"/> 武勋数
		<variable name="level" type="int" order="5"/> 等级
		<variable name="school" type="int" order="6"/> 门派
	</xbean>
	<xbean name="camprankData">
		<variable name="tangRecords" type="list" value="HonourRecord" order="1"/> 所有的记录 北府
		<variable name="suiRecords" type="list" value="HonourRecord" order="2"/> 所有的记录 南廷
		<variable name="tangRecordsBackup" type="list" value="HonourRecord" order="3"/>  北府备份
		<variable name="suiRecordsBackup" type="list" value="HonourRecord" order="4"/> 南廷备份
		
		<variable name="wuxunRecords" type="list" value="HonourRecord" order="5"/>  北府备份
		<variable name="wuxunRecordsBackup" type="list" value="HonourRecord" order="6"/> 南廷备份
	</xbean>
	
	<table name="camprank" key="int" value="camprankData" cacheCapacity="1"/> key=1 阵营当前排行榜数据
	<!-- 阵营相关数据   结束-->
	
	<xbean name="GongChengNpcInfo">
		<variable name="refreshTime" type="long" order="1"/>刷新时间
		<variable name="npcInfos" type="map" key="long" value="int" order="2"/> //npckey 对应的战斗状态 0=空闲  1=战斗中
		<variable name="curractiveId" type="int" order="3"/>当前活动的ID   121
	</xbean>
	<table name="gongchenginfo" key="int" value="GongChengNpcInfo" cacheCapacity="1"/> key=1  攻城相关数据
	<xbean name="RoleGongchengNum">
		<variable name="num" type="int" order="1"/>
		<variable name="lastsetTime" type="long" order="2"/>时间
	</xbean>
	
	<xbean name="RoleGongChengInfo">
		<variable name="RoleGongChengInfoMap" type="map" key="int" value="RoleGongchengNum" order="1"/>key为活动ID(同一类型活动每天参加的次数，不按场次划分)
	</xbean>
	
	<table name="rolegongchenginfo" key="long" value="RoleGongChengInfo" lock="rolelock" cacheCapacity="7000"/>  人物攻城相关数据
	
	<xbean name="RmNpc">
		<variable name="refreshmonsterId" type="int" order="1"/>定时刷怪活动配置表的ID
		<variable name="currActiveId" type="int" order="2"/>当前活动场次ID 121001
		<variable name="isinfight" type="int" order="3"/>是否战斗中
		<variable name="fightnumber" type="int" order="4"/>战斗次数
		<variable name="zhandouId" type="int" order="5"/>相关战斗
		<variable name="jiangliId" type="int" order="6"/>相关奖励
	</xbean>
	<table name="rmnpcinfo" key="long" value="RmNpc" persistence="MEMORY" cacheCapacity="8192"/> key=npckey
	
	<xbean name="RolermActiveInfo">
		<variable name="num" type="int" order="1"/>
		<variable name="killNpcMap" type="map" key="long" value="int" order="2"/>key为npckey,value为击杀次数
		<variable name="lastsetTime" type="long" order="3"/>时间
		
	</xbean>
	<xbean name="RoleRefreshMonsterInfo">
		<variable name="RolermActiveInfoMap" type="map" key="int" value="RolermActiveInfo" order="1"/>key为活动场次ID
	</xbean>
	<table name="rolerefreshmonsterinfo" key="long" value="RoleRefreshMonsterInfo" lock="rolelock" cacheCapacity="7000"/>  人物定时刷怪活动相关数据 
	  
	<!-- 玩家活动积分表-->
	<xbean name="ActivityScoreInfo">
	     <variable name="zqhdTime" type="long" order="1"/>中秋活动最后一次加积分时间
		 <variable name="currentZqhdScore" type="int" order="2"/>中秋活动积分
		 <variable name="zqhdFightTimes" type="int" order="3"/>有效战斗次数
	</xbean>
	<table name="roleactivityscore" key="long" value="ActivityScoreInfo" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>玩家活动积分表  所有的活动积分都往这个表里边加
	
	<xbean name="ItemMap">
		<variable name="number" type="int" order="1"/> 拾取次数
	    <variable name="lastupdate" type="long" order="2"/> 上次拾取物品的时间
	</xbean>
	<xbean name="PickUpMap">
		<variable name="pickUpItemsMap" type="map" key="int" value="ItemMap" order="1"/>
	</xbean>
	<table name="rolepickupitems" key="long" value="PickUpMap" foreign="key:properties" lock="rolelock" cacheCapacity="7000"/>
	
	<!-- 邮件开始 -->
	<xbean name="AwardInfo">
		<variable name="itemId" type="int" order="1"/>		物品id
		<variable name="type" type="int" order="2"/>			物品类型
		<variable name="num" type="int" order="3"/>			物品数量
	</xbean>
	<xbean name="Mail">
		<variable name="configId" type="int" order="1"/>		是策划配置的邮件会有该ID
		<variable name="state" type="int" order="2"/>			状态
		<variable name="receiveTime" type="long" order="3"/>	接收时间
		<variable name="allParams" type="map" key="int" value="ParamInfo" order="4"/> key见ParamInfo枚举
		<variable name="awardId" type="int" order="5"/>       邮件奖励id
		<variable name="awardList" type="list" value="AwardInfo" order="6"/>       邮件其他奖励列表
	</xbean>
	<xbean name="ParamInfo">
	    <enum name="NAME_PARAM" value="1"/>         邮件标题参数
		<enum name="ADDRESSER_PARAM" value="2"/>    邮件发送方参数
		<enum name="CONTENTDES_PARAM" value="3"/>   邮件内容参数
		<enum name="LINK_PARAM" value="4"/>  超链接参数
	    <variable name="paramList" type="list" value="string" order="1"/>	 对应参数列表
	</xbean>
	<xbean name="MailInfos">
	    <variable name="nextKey" type="int" order="1"/> 下一个新添加邮件分配的唯一key
		<variable name="receiveMailIds" type="list" value="int" order="2"/>已经收到过的邮件ID 负值表示GM邮件
		<variable name="mailMap" type="map" key="int" value="Mail" order="3"/>  保存邮件的map key=邮件唯一key value=对应key的邮件对象
	</xbean>
	<table name="rolemails" key="long" value="MailInfos" lock="rolelock" cacheCapacity="7000" cachelow="256"/>
	
	<!-- GM全服发送邮件 -->
	<xbean name="GmMailInfo">
		<variable name="id" type="int" order="1"/>
	    <variable name="allParams" type="map" key="int" value="ParamInfo" order="2"/> key见ParamInfo枚举
	    <variable name="awardList" type="list" value="AwardInfo" order="3"/> 邮件其他奖励列表
	    <variable name="startDate" type="string" order="4"/> 开始时间
	    <variable name="endDate" type="string" order="5"/> 结束时间
	    <variable name="channel" type="string" order="6"/> 渠道
	    <variable name="condition" type="string" order="7"/> 条件
	</xbean>
	<xbean name="GmMailInfos">
		<variable name="nextid" type="int" default="0" order="1"/>
	    <variable name="gmMailInfo" type="list" value="GmMailInfo" order="2"/>已经收到过的邮件ID
	</xbean>
	<table name="gmmails" key="int" value="GmMailInfos" cacheCapacity="4096" cachelow="256"/>
	
	<!-- 职业系统开始 -->
	<xbean name="TalentInfo">
		<variable name="lv" type="int" order="1"/>	天赋等级
		<variable name="skillPoint" type="int" order="2"/>天赋分配的技能点
	</xbean>
	
	<xbean name="PointProject">
		//加点部分
		<variable name="str" type="int" order="1"/>	力量分配的点数
		<variable name="iq" type="int" order="2"/>	智力分配的点数
		<variable name="cons" type="int" order="3"/>	体质分配的点数
		<variable name="endu" type="int" order="4"/>	耐力分配的点数
		<variable name="agi" type="int" order="5"/>	敏捷分配的点数
	</xbean>
	
	<xbean name="CareerInfo">
		<variable name="exp" type="int" order="1"/>				当前经验（职业声望）
		<variable name="lv" type="int" order="2"/>				等级，初始0级
		<variable name="step" type="int" default="1" order="3"/>	阶数
		<variable name="pointProjectNum" type="int" default="1" order="4"/>	第几套加点方案
		<variable name="pointProjects" type="list" value="PointProject" order="5"/> 加点方案
		<variable name="changeAddPointCount" type="int" order="6"/> 加点方案切换次数
		<variable name="lastFreshTime" type="long" order="7"/> 加点方案切换最后的时间
		//天赋部分
		<variable name="talentInfos" type="map" key="int" value="TalentInfo" order="8"/> key=天赋ID
		//转职部分
		<variable name="curChangeState" type="int" order="9"/> 当前转换为哪一个职业状态 以剑士为例：0-剑士 1-狂战士 2-圣骑士
	</xbean>
	<table name="careerinfo" key="long" value="CareerInfo" lock="rolelock" cacheCapacity="7000" cachelow="256"/>
	
	<xbean name="StageInfo">
		<variable name="id" type="int" order="1"/>
		<variable name="maxstar" type="int" order="2"/>
	</xbean>
	<xbean name="StageAwardInfo"> 
			<variable name="exp" type="int" order="1"/>
			<variable name="money" type="int" order="2"/>
			<variable name="items" type="map" key="int" value="int" order="3"/> 物品奖励
	</xbean>
	<xbean name="StageRole">
			<variable name="sweepednum" type="int" order="1"/>  已扫荡次数
			<variable name="refreshtime" type="long" order="2"/>  扫荡次数的刷新时间
			<variable name="stages" type="map" key="int" value="StageInfo" order="3"/>
			<variable name="stageAward" type="map" key="int" value="StageAwardInfo" order="4"/> 推图结束之后该关卡总共获得的奖励信息
	</xbean>
	<table name="stageroles" key="long" value="StageRole" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="KeySpotInfo">
		<variable name="spottype" type="int" order="1"/>
		<variable name="npckey" type="long" order="2"/>
		<variable name="npcid" type="int" order="3"/>
		<variable name="spotvalue" type="int" order="4"/>
		<variable name="state" type="int" order="5"/>
	</xbean>
	<xbean name="StageInstzoneInfo">
		<variable name="bossbattledamage" type="int" order="1"/>
		<variable name="bossbattleround" type="int" order="2"/>	
		<variable name="battlefail" type="int" order="3"/> 
		<variable name="goldpickupnum" type="int" order="4"/>    
		<variable name="goldcollect" type="int" order="5"/>
		<variable name="keyspots" type="map" key="int" value="KeySpotInfo" order="6"/>
	</xbean>
	<table name="stageinstzones" key="long" value="StageInstzoneInfo" cacheCapacity="4096" cachehigh="512" cachelow="256"/>
	
	<!-- 消息推送用户表 -->
	<xbean name="PushUserInfo">
		<variable name="logindate" type="long" order="1"/>	
	</xbean>
	<table name="pushroles" key="long" value="PushUserInfo" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	
	<!-- 人物综合战力区间-->
	<xbean name="RoleFightingInfoNew">
	    <variable name="fightingInfo" type="map" key="long" value="RoleOffLinePropBean" capacity="512" order="1"/> key为人物的roleid，value为当前的战斗力
	</xbean>
	<table name="rolefightcapacitynew" key="int" value="RoleFightingInfoNew" cacheCapacity="4096" cachehigh="512" cachelow="256"/> key为区间号
	
	<xbean name="SpecialBagInfo">
		<variable name="num" type="int" order="1"/>key为碎片id,value为数量 
	</xbean>
	<xbean name="SpecialBag">	
		<variable name="petChips" type="map" key="int" value="SpecialBagInfo" order="1"/>key为碎片id,value为数量 
		<variable name="xiakeChips" type="map" key="int" value="SpecialBagInfo" order="2"/>key为碎片id,value为数量 
		<variable name="hunQis" type="map" key="int" value="SpecialBagInfo" order="3"/>key为碎片id,value为数量 
		<variable name="xinwu" type="map" key="int" value="SpecialBagInfo" order="4"/>key为信物id,value为数量 
	</xbean>
	<table name="specialbag" key="long" value="SpecialBag" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<!-- 礼包使用加时间限制 -->
	<xbean name="PresentInfo">		
		<variable name="createTime" type="long" order="1"/> 
	</xbean>
	<xbean name="Present">		
		<variable name="presentrole" type="map" key="long" value="PresentInfo" order="1"/> 
	</xbean>
	<table name="present" key="long" value="Present" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="ChargeExtAward">
		<variable name="chargedNum" type="int" order="1"/> 已充值次数
	</xbean>
	
	<xbean name="LimitBuyInfo">
		<variable name="limitBuyId" type="int" order="1"/>	在策划限时表里配置的ID
		<variable name="buyNum" type="int" order="2"/>	已经购买的数量，如果是按天限购的需要清零
	</xbean>
	<xbean name="LimitBuyInfos">
		<variable name="lastClearTime" type="long" order="1"/>	用于按天限购计算清零的时间
		<variable name="limits" type="map" key="int" value="LimitBuyInfo" order="2"/> key=confid
		<variable name="weekLastClearTime" type="long" order="3"/>	用于按周限购计算清零的时间
	</xbean>
	<table name="limitbuy" key="long" value="LimitBuyInfos" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<!-- 角色零散数据表，角色相关的非关键字段可存储在这里-->
	<xbean name="properties2Info">
		<variable name="bangshaValue" type="int" order="1"/> 当日获得的帮杀值，被动清零
	    <variable name="rongyuTime" type="long" order="2"/> 获取荣誉值的时间 
	    <variable name="lastShowKey" type="int" order="3"/>  加队之前，展示的侠客/宠物key
	    <variable name="lastShowType" type="int" order="4"/>  加队之前，展示的类型(宠物/侠客)
		<variable name="lastShowTeamId" type="long" order="5"/>  加队之后的teamId
		<variable name="maxExpReminder" type="map" key="int" value="int" order="6"/> 人物满级之后，给提示，key为级别，value=1表示给过提示
		<variable name="shieldChatRoleMap" type="map" key="long" value="long" order="7"/>	屏蔽的玩家
		<variable name="shieldChatToMeMap" type="map" key="long" value="long" order="8"/> 屏蔽我聊天的玩家集合 value为时间
		<variable name="formtaionrankflag" type="int" order="9"/> 阵法排行榜初始化标志
		<variable name="buyyuanbaoNum" type="int" order="10"/>角色充值得到的钻石数
		<variable name="battleSpeed" type="int" order="11"/>战斗加速设置x1,x2,x3
		<variable name="applyFactionList" type="list" value="long" order="12"/>角色申请过的家族KEY，加入家族时，清掉
		<variable name="chargeExtAward" type="map" key="int" value="ChargeExtAward" order="13"/> 充值额外奖励功能 key=活动届数
		<variable name="lastloginserverlv" type="int" order="14"/> 上一次登录服务器等级
		<variable name="sellitemsilver" type="int" order="15"/> 出售道具获得的银票数量
		<variable name="lastsellitemtime" type="long" order="16"/> 上次出售道具获得银票的时间
		<variable name="exchangenum" type="map" key="int" value="int" order="17"/> 积分兑换每个物品每天的已经兑换数
		<variable name="lastexchangetime" type="long" order="18"/> 积分兑换每个物品上次兑换时间
		<variable name="petboxscore" type="int" order="19"/> 宠物合成赠送的宝箱分数
		<variable name="speedbuildcount" type="int" order="20"/> 加速建筑次数
		<variable name="speedbuildtime" type="long" order="21"/> 加速建筑时间
		<variable name="petrandomtimes" type="int" order="22"/> 总计抽宠次数
		<variable name="schoolcheckpointstime" type="long" order="23"/> 逐日之旅最快时间
		<variable name="curschoolcheckpointstime" type="long" order="24"/> 本次逐日之旅最快时间
		<variable name="lastupdateschoolcheckpointstime" type="long" order="25"/> 最后一次逐日之旅更新时间
		<variable name="enteredmaps" type="list" value="int" order="26"/> 玩家曾经进入过的（静态）地图id列表  第一次进入某地图时要播放CG
		<variable name="signname" type="string" order="27"/> 个性签名
		<variable name="qq" type="string" order="28"/> qq
		<variable name="weixin" type="string" order="29"/> 微信
		<variable name="lastleveluptime" type="long" order="30"/> 最近一次角色升级时间
		<variable name="isgetfirstpet" type="boolean" order="31"/> 玩家是否获得过第一个宠物 false-未获得过 true-获得过
		<variable name="finishedanimation" type="vector" value="int" order="32"/> 新手已经完成的动画和战斗id
		<variable name="taskhelpnum" type="int" order="33"/> 任务帮杀获得奖励的次数  每周清空 
		<variable name="lasttaskhelptime" type="long" order="34"/> 上次任务帮杀获得奖励的时间
		<variable name="firstchargegifts" type="list" value="int" order="35"/> 已经领取到的首冲礼包（保存的是奖励id列表）
		<variable name="ishide" type="int" order="36"/> 是否隐藏地理位置 1-隐藏 2-显示
		<variable name="location" type="string" order="37"/> 地理位置
		<variable name="joinfactiontime" type="long" order="38"/> 帮派加入时间
	    <variable name="factionpostion" type="int" order="39"/> 帮派职务	
	    <variable name="lastreporttime" type="long" order="40"/> 上一次举报别人的时间
	    <variable name="pklostshenbingscorecount" type="int" order="41"/> 野外pk丢失神兵积分次数	
	    <variable name="pklostshenbingscoretime" type="long" order="42"/> 野外pk丢失神兵积分时间
		<variable name="onestepstatus" type="int" order="43"/>  69级突破状态  0-未接任务 1-已接任务 2-完成任务
		<variable name="levelbreakexp" type="long" order="44"/>  69级突破 多余经验存储
		<variable name="strangersofsendmsg" type="set" value="long" order="45"/> 每天私聊的陌生人。陌生人指自己不在别人的好友列表里。
		<variable name="timeofsendMsgtostranger" type="long" order="46"/> 发私聊给陌生人的时间。用于每天清零。
		<variable name="sociatycard" type="string" order="47"/> 公会码
		<variable name="worldanswerlastawardtime" type="long" order="48"/> 世界答题最后一次获得奖励时间
		<variable name="worldanswerawardtimes" type="int" order="49"/> 世界答题当天奖励次数
		<variable name="danmupretime" type="long" order="50"/> 弹幕发送时间记录
		<variable name="zbdanmupretime" type="long" order="51"/> 直播弹幕发送时间记录
		<variable name="gameshareaward" type="int" order="52"/> 分享奖励本周领取次数
		<variable name="lastshareawardtime" type="long" order="53"/> 上次获得分享奖励时间
		<variable name="worldanswer" type="int" order="54"/> 本次世界答题所选答案
		<variable name="worldanswertime" type="long" order="55"/> 本次世界答题选择时间
		<variable name="newplayersale" type="boolean" order="56"/> 交易行新玩家
		<variable name="weiwang" type="int" order="57"/>个人威望值
		<variable name="weiwangDayCount" type="map" key="int" value="int" order="58"/>
		<variable name="pklostweiwangCount" type="int" order="59"/>
		<variable name="festivalgivegifttime" type="map" key="long" value="int" order="60"/>个人每天赠送节日活动道具次数
		<variable name="lastgivegifttime" type="long" order="61"/>最后一次赠送道具时间（用于每日清零）
	</xbean> 
	<table name="properties2" key="long" value="properties2Info" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="Properties3Info">
		<variable name="birthday" type="int" order="1"/> 生日 19990203
		<variable name="shortcutchat" type="list" value="string" order="2"/> 便捷聊天列表
		<variable name="yesterlastlevel" type="int" order="3"/> 昨日最后等级
		<variable name="updatecleartime" type="long" order="4"/> 更新时间（用于刷新每一天八点更新数据）
		<variable name="firstpet" type="boolean" order="5"/> 是否抽取第一个宠物 true已抽取 false未抽取
		<variable name="packagelevel" type="list" value="int" order="6"/> 新手引导已经领取礼包的等级list
		<variable name="stalls" type="list" value="int" order="7"/> 已经提交的问卷期号
		<variable name="factionhongbao" type="boolean" order="9"/> 首次入帮红包是否发放 false未发放  true已发放
		<variable name="petlingqi" type="int" order="10"/> 宠物灵气
		<variable name="dailyjubaotimes" type="int" order="11"/> 举报第一人次数
		<variable name="dailyfirstjubaotime" type="long" order="12"/> 每天第一次举报时间
		<variable name="combinedlimititems" type="map" key="int" value="int" order="13"/> 已合成受限制的物品 key=物品id value-数量
		<variable name="sex" type="int" order="14"/> 0-隐藏 1-男 2-女
		<variable name="petbattleconfigids" type="set" value="int" order="15"/> 宠物已经直接领悟技能的战斗配置id
		<variable name="monstersoul" type="int" order="16"/> 兽魂
		<!-- <variable name="stockbuff" type="map" key="int" value="Stockbuffeffect" order="16"/>		帮派采备buff列表 key-buffId value-效果 -->
		<variable name="firstpetcall" type="boolean" order="17"/> 特定任务下使用兽魂抽宠触发
		<variable name="lastapplyallfactiontime" type="long" order="18"/> 上次一键申请帮派时间
		<variable name="lastsharepetstime" type="long" order="19"/> 上次分享宠物时
		<variable name="firstschool" type="boolean" order="20"/>第一次师门任务
		<variable name="todayTaskId" type="int" order="21"/>师门今天随机出来的任务配置id(第一次随完后今天不在随机)
		<variable name="firstschooltime" type="long" order="22"/>第一次师门任务跨天修改数据时间
		<variable name="randomschooltime" type="long" order="23"/>随机师门任务id时间
		<variable name="firstroundschooltime" type="long" order="24"/>师门跨天第一环任务重新随机时间
		<variable name="tradinggold" type="int" order="25"/>交易金币
		<variable name="identificateaward" type="int" order="26"/> 身份认证奖励领取状态
		<variable name="goldleaf" type="int" order="27"/> 金叶子
		<variable name="downloadawardstate" type="map" key="int" value="int" order="28"/> 分包下载奖励状态（key-包ID, value-state）0：未领取，1：领取
		<variable name="xiakescore" type="int" order="29"/> 伙伴积分
		<!--<variable name="drawxiaketimes" type="int" order="30"/> 抽侠客次数-->
		<variable name="onedrawtimes" type="int" order="31"/> 抽侠客次数
		<variable name="tendrawtimes" type="int" order="32"/> 抽侠客次数
		<variable name="formationcrystalscore" type="int" order="33"/> 阵法水晶积分
		<!--ariable name="chargeRebate" type="boolean" order="34"/> 是否领取过充值返利-->
		<variable name="lingfuBreaks" type="int" order="35"/> 灵符碎片数量
		<variable name="betCrossPvpTeams" type="set" value="long" order="36"/> 下注的跨服战队列表
		<variable name="fengshenScore" type="int" order="37"/> 封神积分
		<variable name="currentPoints" type="int" order="38"/> 当天已兑换的封神积分
		<variable name="exchangePointsTime" type="long" order="39"/> 兑换封神积分的时间
		<variable name="drawingScore" type="int" order="40"/> 图鉴积分
		<variable name="receiveXiakeTaskItem" type="map" key="int" value="boolean" order="41"/> 是否领取过侠客任务道具
		<variable name="bellScore" type="int" order="42"/> 铃铛积分
		<variable name="lingyiScore" type="int" order="43"/> 灵翼积分
		<variable name="updateAward" type="set" value="int" order="44"/>更新版本奖励（value 为configid）
	</xbean>
	<table name="properties3" key="long" value="Properties3Info" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="PetAutoInfo">
		<variable name="petOpType" type="short" order="1"/> 宠物自动操作类型
		<variable name="petOpId" type="int" order="2"/> 设置的宠物自动操作ID
	</xbean>
	<xbean name="BattleAutoData">
		<enum name="AUTO_FALSE" value="0"/>
		<enum name="AUTO_TRUE" value="1"/>
		
		<variable name="isAuto" type="short" order="1"/> 是否自动
		<variable name="roleOpType" type="short" order="2"/> 自动操作类型
		<variable name="roleOpId" type="int" order="3"/> 设置的自动操作ID
		<variable name="petopinfo" type="map" key="int" value="PetAutoInfo" order="4"/> 宠物自动操作
	</xbean>
	<table name="battleauto" key="long" value="BattleAutoData" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="AutoSendMailFutures" any="true">
	    <variable name="futures" type="list" value="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/> 自动发邮件的定时器
	</xbean>
	<table name="autosendmailfutures" key="int" value="AutoSendMailFutures" persistence="MEMORY" cacheCapacity="5"/>
	
	<!-- 投票类数据表，key为团队id-->
	<xbean name="voteData">
	    <variable name="voteBeginTime" type="long" order="1"/> 投票开始时间
		<variable name="hardlevel" type="int" order="2"/> 0,1,2
		<variable name="voteResult" type="int" order="3"/> 1=通过 0 = 没通过
		<variable name="voteMembers" type="map" key="long" value="int" order="4"/> key为队员的id，value为投票意见，1==同意，0==不同意
		<variable name="allVoteMembers" type="list" value="long" order="5"/> 本次投票者的roleids 
	</xbean>
	<table name="teamvote" key="long" value="voteData" cacheCapacity="8192" persistence="MEMORY" lock="teamlock"/>
	
	<!-- 家族副本相关-->
	<xbean name="FamilyInstzoneInfo">
		<variable name="familyKey" type="long" order="1"/> 家族key	
	</xbean>
	<table name="familyinstzones" key="long" value="FamilyInstzoneInfo" cacheCapacity="4096" cachehigh="512" cachelow="256"/> instzoneKey
	
	<!-- 等级限定推送商城道具 -->
	<xbean name="GoodInfo">
		<variable name="restNum" type="int" order="1"/>剩余购买数量
	</xbean>
	<xbean name="LimitGoodInfo">
		<variable name="goods" type="map" key="int" value="GoodInfo" order="1"/> key=goodid 
	</xbean>
	<xbean name="LimitGoods">
		<variable name="infos" type="map" key="string" value="LimitGoodInfo" order="1"/> key=最小等级-最大等级
	</xbean>
	<table name="limitgoods" key="long" value="LimitGoods" cacheCapacity="7000" lock="rolelock"/>
	
	<!-- 每日限购推送礼包 -->
	<xbean name="DailyGiftInfo">
		<enum name="BUY_STATE_NOTIP" value="0"/>没有弹出过界面
		<enum name="BUY_STATE_NOORDER" value="1"/>弹出过界面没下订单
		<enum name="BUY_STATE_HAVEORDER" value="2"/>下了订单还没充值成功
		<enum name="BUY_STATE_BUYED" value="3"/>购买过了
		<variable name="giftId" type="int" order="1"/>
		<variable name="tipTime" type="long" order="2"/>
		<variable name="billTime" type="long" order="3"/>
		<variable name="buyStatus" type="int" order="4"/>
	</xbean>
	<xbean name="DailyGiftInfos">
		<variable name="infos" type="map" key="int" value="DailyGiftInfo" order="1"/>
	</xbean>
	<table name="dailygiftinfos" key="long" value="DailyGiftInfos" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="Apns">
		<variable name="platform" type="int" order="1"/>
		<variable name="tokens" type="list" value="string" order="2"/>
		<variable name="account" type="string" order="3"/>
	</xbean>
	<table name="apns" key="long" value="Apns" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	
	<!-- 定时系统公告 -->
	<xbean name="GonggaoFuture" any="true">
		<variable name="strattimefuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>
	</xbean>
	<table name="gonggaofuture" key="int" value="GonggaoFuture" cacheCapacity="10240" cachehigh="512" cachelow="256" persistence="MEMORY"/>
		
	<!-- 单笔充值送礼 -->
	<xbean name="ChargeAwardInfo">
		<variable name="cash" type="long" order="1"/> 积累金额
		<variable name="flag" type="int" order="2"/> 0未领取，1领取
	</xbean>
	<xbean name="ChargeAward">
		<variable name="awards" type="map" key="int" value="ChargeAwardInfo" order="1"/>
	</xbean>
	<table name="chargeaward" key="long" value="ChargeAward" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="GainState">
		<variable name="state" type="int" order="1"/> 0-未领取 1-已领取
	</xbean>
	<xbean name="TotalLoginInfo">
		<variable name="lastUpdateMonthTimestamp" type="long" order="1"/> 用于每月清除数据
		<variable name="lastUpdateDayTimestamp" type="long" order="2"/> 用于每天登录判断是否还要累加天数
		<variable name="gainState" type="map" key="int" value="GainState" order="3"/> 当月各天领奖情况 key=天数
	</xbean>
	<table name="totallogininfo" key="long" value="TotalLoginInfo" cacheCapacity="7000" lock="rolelock"/>
	
	<!-- 存储天猫订单与游戏订单的映射 -->
	<table name="tmallordertogameorder" key="string" value="long" cacheCapacity="4096"/>
	
	<!-- 宠物佣兵大礼包 -->
	<xbean name="QuackGiftInfo">
		<variable name="startTime" type="long" order="1"/> 开始时间
	</xbean>
	<xbean name="QuackGift">
		<variable name="gifts" type="map" key="int" value="QuackGiftInfo" order="1"/> key = id
	</xbean>
	<table name="quackgift" key="long" value="QuackGift" cacheCapacity="7000" lock="rolelock"/>
		
	<xbean name="DefendEffect">
		<variable name="effects" type="map" key="int" value="float" order="1"/> key=灵珠/水晶属性ID
	</xbean>
	<table name="defendeffects" key="long" value="DefendEffect" cacheCapacity="20240" autoIncrement="true"/>
	
	<!-- 商会系统start -->
	<xbean name="PawnShopItem">  商会道具信息
		<variable name="price" type="int" order="1"/>  道具的当前价格
		<variable name="oldpricemap" type="map" key="int" value="int" order="2"/>  每个时间点的价格(用来计算涨幅和跌幅)
		<variable name="buycount" type="int" order="3"/> 当前小时玩家的购买量
		<variable name="sellcount" type="int" order="4"/> 当前小时玩家的出售量
		<variable name="last24hourbuy" type="list" value="int" order="5"/> 最近24小时内每小时的购买量
		<variable name="last24hoursell" type="list" value="int" order="6"/> 最近24小时内每小时的出售量
	</xbean>
	<xbean name="PawnShopItems">
		<variable name="allitems" type="map" key="int" value="PawnShopItem" order="1"/>  所有商会道具信息
		<variable name="freshtime" type="long" order="2"/> 上次刷新价格的时间
	</xbean>
	<table name="pawnshopitems" key="int" value="PawnShopItems" cacheCapacity="1"/> 商会物品信息表
	
	<xbean name="RolePawnShopBuy">
		<variable name="buynum" type="int" order="1"/>  当天已购买道具的数量
		<variable name="lastbuytime" type="long" order="2"/> 最近一次购买该道具的时间
	</xbean>
	<xbean name="RolePawnShopInfo">
		<variable name="hasbuyitems" type="map" key="int" value="RolePawnShopBuy" order="1"/> 当天已购买道具的信息  key=itemId value=今日已购买该道具的信息
	</xbean>
	<table name="rolepawnshop" key="long" value="RolePawnShopInfo" lock="rolelock" cacheCapacity="7000"/> 角色在商会中购买道具的信息
	<!-- 商会系统end -->
	
	<!-- 帮派商店系统start -->
	<xbean name="FactionStockItem">  帮派采备货物信息
		<variable name="itemid" type="int" order="1"/>  道具ID
		<variable name="buynum" type="int" order="2"/> 周期内已买数量
		<variable name="lastbuytime" type="long" order="3"/> 上次购买时间
		<variable name="lastcleartime" type="long" order="4"/> 上次刷新时间
		<!-- <variable name="iscanbuy" type="int" order="5"/> 是否可买 -->
	</xbean>

	<xbean name="FactionStockShopItems">
		<!-- <variable name="allitems" type="map" key="int" value="FactionStockItem" order="1"/>  帮派采备所有道具信息 -->
		<variable name="stockitems" type="map" key="int" value="FactionStockItem" order="2"/>  帮派采备所有道具信息
	</xbean>
	<table name="factionstockshopitems" key="long" value="FactionStockShopItems" lock="factionlock" cacheCapacity="4096"/> 帮派采备物品信息表
	
	<!-- 帮派商店系统end -->
	
	<!-- 帮派强盗 -->
	<xbean name="FactionRobberInfo">  
		<!--<variable name="date" type="long" order="1"/> 活动日期 -->
		<variable name="robberNpcs" type="map" key="long" value="Robbernpcinfo" order="2"/> 产出的npc
		<variable name="killNum" type="int" order="4"/> 已杀死数量
		<variable name="configId" type="int" order="5"/> 怪物刷新表ID
		<variable name="curwaveid" type="int" order="6"/> 当前波数id
		<variable name="lastClearTime" type="long" order="8"/> 清理时间
	</xbean>
	
	<xbean name="Robbernpcinfo">  
		<variable name="npckey" type="long" order="1"/> npckey
		<variable name="npcid" type="int" order="2"/> npcid
		<variable name="npcdefeatnum" type="int" order="3"/> npc被击打次数
		<variable name="awardid" type="int" order="4"/> 奖励id
	</xbean>
	<table name="factionrobberinfo" key="long" value="FactionRobberInfo" cacheCapacity="4096" lock="factionlock" persistence="MEMORY"/> 帮派强盗
	
	<xbean name="FactionRobberRole">  
		<variable name="awardtimes" type="int" order="1"/>  领取战斗奖励次数
		<variable name="opentimes" type="int" order="2"/> 领取宝箱奖励次数
		<!--<variable name="date" type="long" order="3"/> 活动日期 -->
	    <variable name="lastClearTime" type="long" order="4"/> 清理时间
	</xbean>
	<table name="factionrobberroleinfo" key="long" value="FactionRobberRole" cacheCapacity="10240" lock="rolelock" persistence="MEMORY"/> 帮派强盗

	<!-- 帮派强盗 -->
	
	<!-- 地图随机有效点start -->
	<xbean name="MapWalkableGrids">
		<variable name="usedpos2gridkey" type="map" key="long" value="long" order="1"/>  已使用坐标到格子的反索引 key=(posx左移32 | posz) value=gridkey
	</xbean>
	<table name="mapwalkablegrids" key="long" value="MapWalkableGrids" capacity="4096" persistence="MEMORY"/> key=sceneid 
	<!--地图随机有效点end -->
	
	<!-- 封妖系统 start  -->
	<xbean name="SealNpcMonster">  随机npc
		<variable name="npckey" type="long" order="1"/>  npckey
		<variable name="npcid" type="int" order="2"/>  npcid
		<variable name="name" type="string" order="3"/> npc名字
		<variable name="mapid" type="int" order="4"/> 地图
	</xbean>
	
	<xbean name="SealNpcMonsterMap">  随机npc集合
		<variable name="mapid" type="int" order="1"/> 地图ID
		<variable name="cratetime" type="long" order="2"/> 创建时间
		<variable name="kills" type="int" order="3"/> 已经击杀的次数
		<variable name="npcmap" type="map" key="long" value="SealNpcMonster" order="4"/> 
	</xbean>
	
	<table name="sealnpcmonster" key="int" value="SealNpcMonsterMap" cacheCapacity="1" persistence="MEMORY"/> 封妖表
	<!-- 封妖系统 end  -->
	
	<!-- 妖王 start -->
	<xbean name="YaowangNpcInfo">  随机npc
		<variable name="confid" type="int" order="1"/>  配置表id
		<variable name="flag" type="int" order="2"/> 1假妖王 0真
		<variable name="npckeylist" type="list" value="long" order="3"/> 假妖王npckey列表
	</xbean>
	
	<table name="yaowangnpcinfo" key="long" value="YaowangNpcInfo" cacheCapacity="1024" persistence="MEMORY"/> 妖王信息表
	<!-- 妖王 end -->
		
	<!-- 仙剑问答 start-->
	<xbean name="AnswerInfo">
		<variable name="status" type="int" order="1"/> 未答，答对，答错
		<variable name="exp" type="int" order="2"/> 当前题获得的总经验
		<variable name="money" type="int" order="3"/> 当前题获得的总金币
	</xbean>
	<xbean name="AnswerInfos">
		<variable name="questionidlist" type="vector" value="int" order="1"/> 一次性随机的问题集合
		<variable name="answerinfolist" type="vector" value="AnswerInfo" order="2"/>已答题bean的list
		<variable name="fireeyetimes" type="int" order="3"/> 火眼金睛次数
		<variable name="starttime" type="long" order="4"/> 开始答题时间
		<variable name="hadrewardlist" type="list" value="int" order="5"/> 已经领取的额外奖励集合
		<variable name="factionhelptimes" type="int" order="6"/> 帮派求助次数
		<variable name="helptime" type="long" order="7"/> 求助时间
		<variable name="helpquestionid" type="int" order="8"/> 求助题目id
	</xbean>
	<table name="answerinfos" key="long" value="AnswerInfos" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>key 是roleid
	<!-- 仙剑问答 end-->
	
	<!-- 每日奖励次数，隔天重置  start-->
	<cbean name="AwardLimitByDayType"> 不同用途的枚举
		<enum name="TRANSFORM_SKILL" value="-1"/> 上线处理转职技能问题临时处理了
		<enum name="SEAL_MONSTER_AWARDCOUNT" value="2"/> 封妖奖励次数
		<enum name="SEAL_MONSTER_GONGDE" value="3"/> 封妖活动功德值
		<enum name="STAR_MONSTER_AWARDCOUNT" value="4"/> 杀星奖励次数
		<enum name="STAR_MONSTER_GONGDE" value="5"/> 杀星活动功德值
		<enum name="TREASUREMAP" value="6"/> 宝图任务
		<enum name="CATCH_GHOST_GONGDE" value="7"/> 捉鬼活动每日功德值
		<enum name="TASK_CHAIN_GONGDE" value="8"/> 任务链玩法每日功德值（援助获得）
		<enum name="DAILY_INSTANCE1_GONGDE" value="9"/> 日常副本-玩法每日功德值
		<enum name="DAILY_INSTANCE2_GONGDE" value="10"/> 日常副本-玩法每日功德值
		<enum name="DAILY_INSTANCE3_GONGDE" value="11"/> 日常副本-玩法每日功德值
		<enum name="SEAL_MONSTER_PETAWARD" value="12"/> 封妖宠物怪奖励次数
		<enum name="FAIRY_DREAM_GONGDE" value="13"/> 回魂仙梦每日功德值
		<enum name="SUZHOU_CITY_DANGER" value="14"/> 苏州城之危
		<enum name="DAILY_INSTANCE4_GONGDE" value="15"/> 中秋限时副本-玩法每日功德值
		<enum name="FISH_SHARED_TIMES" value="16"/> 每日被赠送鱼数量
		<enum name="FACTION_MONEYSTOLEN" value="17"/> 每日资金窃取的次数
		<enum name="FIVE_GHOST_SEAL_NUM" value="18"/> 五鬼封印奖励次数
		<enum name="STAR_MONSTER_PVE" value="19"/> 杀星pve奖励次数
		<enum name="FIVE_GHOST_SEAL_GONGDE" value="20"/> 五鬼封印功德次数
		<enum name="MAGICIAN_COUNT" value="21"/> 魔器现世次数
		<enum name="RANDOM_BATTLE" value="22"/> 随机战斗每日功德
		<enum name="DAILY_INSTANCE5_GONGDE" value="23"/> 限时副本
	</cbean>
	<xbean name="AwardData"> 
		<variable name="time" type="long" order="1"/> 最近一次领奖的时间
		<variable name="count" type="int" order="2"/> 计数，或者累计值，根据不同情况区分  
	</xbean>
	<xbean name="AwardDataMap"> 
		<variable name="dataMap" type="map" key="int" value="AwardData" order="1"/>   key见AwardLimitByDayType
	</xbean>
	
	<table name="awardcountbyday" key="long" value="AwardDataMap" cacheCapacity="7000" lock="rolelock"/> 奖励次数表
	<!-- 每日奖励次数，隔天重置  end-->


	<xbean name="VisitData"> 
		<variable name="datas" type="set" value="int" order="1"/> 
		<variable name="resettime" type="long" order="2"/>  
	</xbean>
	
	<table name="visitactivity" key="long" value="VisitData" cacheCapacity="7000" lock="rolelock"/> 
	<!-- 拜访功能，隔天重置  end-->
	
	<xbean name="TreasureMapLocationInfo">
		<variable name="mapid" type="int" order="1"/> 地图id
		<variable name="x" type="int" order="2"/>
		<variable name="y" type="int" order="3"/>
		<variable name="z" type="int" order="4"/>
		<variable name="lastmapid" type="int" default="-1" order="5"/> 上一次随机的地图id , 为了下次抽取排除用的
	</xbean>
	<xbean name="AdavanceTreasureMapInfo">
		<!-- <variable name="locationinfo" type="TreasureMapLocationInfo" /> 位置信息 -->
		<variable name="chooseinfo" type="list" value="int" order="1"/> 表示抽取信息
		<variable name="state" type="int" order="2"/> 状态信息
		<!-- <variable name="lucky" type="int" /> 运势值-->
		<variable name="currentIndex" type="int" order="3"/>当前所在位置
		<variable name="finalAwards" type="list" value="int" order="4"/> 最终司南奖励随出的4个
	</xbean>
	<xbean name="TreasureMapInfo"> 
		<variable name="lastOperaType" type="int" default="0" order="1"/> 上一次操作的宝图类型,用位表示
		<variable name="locationinfo" type="TreasureMapLocationInfo" order="2"/> 普通宝图地点信息
		<variable name="advanceinfo" type="AdavanceTreasureMapInfo" order="3"/> 高级宝图信息
	</xbean>	
	<table name="treasuremap" key="long" value="TreasureMapInfo" cacheCapacity="7000" lock="rolelock"/> 宝图信息
	
	<!-- 捉鬼玩法start -->
	<xbean name="CatchGhostInfo">
		<variable name="currentnum" type="int" order="1"/> 当前是一轮中的第几次（不大于每轮的最大次数）
		<variable name="leftcatchnum" type="int" order="2"/> 刷新周期内剩余的捉鬼次数（可累计但不能超过累计上限）
		<variable name="lastcatchtime" type="long" order="3"/> 最近一次完成捉鬼的时间
		<variable name="leftrewardnum" type="int" order="4"/> 刷新周期内剩余额外奖励领取次数（可累计，同上）
		<variable name="doubleexpnum" type="int" order="5"/> 双倍经验奖励次数 
		<variable name="totalnum" type="int" order="6"/> 从初生到当前总的捉鬼次数
		<variable name="daynum" type="int" order="7"/> 当天捉鬼次数
	</xbean>
	<table name="catchghost" key="long" value="CatchGhostInfo" cacheCapacity="7000" lock="rolelock"/> 每个玩家的捉鬼信息
	<!-- 捉鬼玩法end -->
	
	<!-- 签到玩法start -->
	<xbean name="Sign"> 
		<variable name="rewardstatus" type="int" order="1"/> 领奖信息，用位表示每一天领奖状态
		<variable name="accumulaterewardstatus" type="list" value="int" order="2"/> 累计签到奖励领取记录
		<variable name="modifynum" type="int" order="3"/> 可补签剩余次数
		<variable name="time" type="long" order="4"/> 上次签到时间
	</xbean>	
	<table name="signinformation" key="long" value="Sign" cacheCapacity="7000" lock="rolelock"/> 签到信息
	<!-- 签到玩法end -->
	
	<!-- 等级礼包start -->
	<xbean name="LevelReward"> 已领取的奖励 保留原结构以备扩展
		<variable name="level" type="int" order="1"/>  
		<variable name="time" type="long" order="2"/>  领取时间
	</xbean>	
	
	<xbean name="RoleLevelReward"> 
		<variable name="dataMap" type="treemap" key="int" value="LevelReward" order="1"/>  已经领过的等级奖励
	</xbean>	
	
	<table name="levelrewardtable" key="long" value="RoleLevelReward" cacheCapacity="7000" lock="rolelock"/>等级礼包信息
	<!-- 等级礼包end -->
	
	<!-- 竞技场start  -->
	<xbean name="HistoryDetail"> 战斗细节
		<variable name="rank" type="int" order="1"/> 
		<variable name="oldrank" type="int" order="2"/> 
	</xbean>
	<xbean name="ArenaFightReport"> 竞技场战斗历史
		<variable name="date" type="long" order="1"/> 发生日期
		<variable name="oppentroleid" type="long" order="2"/> 对方id
		<variable name="name" type="string" order="3"/> 对方名字
		<variable name="result" type="int" order="4"/>  1=我打对方胜利, 2=我打对方失败 3=对方打我胜利 4=对方打我失败
		<variable name="details" type="HistoryDetail" order="5"/> 战斗细节
	</xbean>
	
	<xbean name="ArenaRoleProp"> 竞技场中玩家的克隆数据( 数值, 外观)
		<variable name="formId" type="int" order="1"/> 阵法
		<variable name="formLevel" type="int" order="2"/> 阵法等级
		<variable name="roleFinalAttrs" type="map" key="int" value="float" order="3"/>角色的属性 key = attr type
		<variable name="roleskills" type="map" key="int" value="int" order="4"/>角色的技能列表 key=技能id  value=技能等级
		<variable name="petFinalAttr" type="petFinalAttrs" order="5"/> 最后一个参战宠物的属性
		<variable name="XiaKeFinalAttrsMap" type="map" key="int" value="XiaKeFinalAttrs" order="6"/>侠客列表
		<variable name="defendAttrs" type="map" key="int" value="float" order="7"/> 阵法灵珠/水晶属性
		<variable name="level" type="int" order="8"/> 
		<variable name="school" type="int" order="9"/> 
		<variable name="shape" type="int" order="10"/> 
		<variable name="defendStarId" type="int" order="11"/> 阵法灵珠id
	</xbean>
	//角色相关的属性保存   包括宠物 侠客的 战斗属性 
	<table name="arenaroleproperties" key="long" value="ArenaRoleProp" cacheCapacity="7000" cachehigh="512" cachelow="256" lock="rolelock"/>
	
	
	<xbean name="ArenaRankFighterInfo">
		<variable name="uniqueId" type="long" order="1"/> 角色或机器人id
		<variable name="robitId" type="int" order="2"/> 机器人id, 玩家时为0
		<variable name="robitName" type="string" order="3"/>
		<variable name="lastoperatime" type="long" order="4"/> 最后一次主动挑战时间
	</xbean>
	
	<table name="arenaranks" key="int" value="ArenaRankFighterInfo" cacheCapacity="10000" lock="arenalock"/> 
	<table name="arenafightstate" key="int" value="boolean" cacheCapacity="10000" lock="arenalock" persistence="MEMORY"/>
	<xbean name="ArenaRole"> 
		<variable name="resetTime" type="long" order="1"/> 上次重置时间
		<variable name="arenascore" type="int" order="2"/> 竞技积分
		<variable name="todaychallengecount" type="int" order="3"/> 今日挑战次数	(每日重置)
		<variable name="todaybuycount" type="int" order="4"/> 今日购买次数	(每日重置)
		<variable name="todayfirstwinaward" type="int" order="5"/> 首胜奖励是否领取 (0=未领但不能领取 1=可领取但是未领, 2已经领取)
		<variable name="todayfivebattleaward" type="int" order="6"/> 5战奖励是否领取 (0=未领但不能领取 1=可领取但是未领, 2已经领取)
		<variable name="historyrank" type="int" default="-1" order="7"/> 历史最高名次
		<variable name="shape" type="int" order="8"/> 外观
		<variable name="fightpower" type="int" order="9"/> 战斗力
		<variable name="enemy" type="list" value="int" order="10"/> 挑战的排名
		<variable name="arenafightreports" type="list" value="ArenaFightReport" order="11"/> 
	</xbean>		
	<table name="arenarole" key="long" value="ArenaRole" cacheCapacity="7000" lock="rolelock"/> 竞技场玩家信息
	<!-- 竞技场end  -->
	
	<!-- 逐日之旅start -->
	<xbean name="SchoolCheckPointsInfo">
		<variable name="currentnum" type="int" order="1"/> 当前是一轮中的第几次（不大于每轮的最大次数）
		<variable name="havedonetasks" type="vector" value="int" order="2"/> 已经接完的任务id
		<variable name="startactivetime" type="long" order="3"/> 开始时间
	</xbean>
	<table name="schoolcheckpoints" key="long" value="SchoolCheckPointsInfo" cacheCapacity="8192" lock="teamlock" persistence="MEMORY"/> 对应逐日之旅 队伍的信息
	
	<xbean name="SchoolCheckPointsRoleInfo"> 玩家信息
		<variable name="roleid" type="long" order="1"/>
		<variable name="usetime" type="long" order="2"/>
		<variable name="rolename" type="string" order="3"/>
	</xbean>
	<xbean name="SchoolCheckPointsList"> 本次逐日之旅排行榜前五的玩家信息
		<variable name="rolelist" type="list" value="SchoolCheckPointsRoleInfo" order="1"/>
	</xbean>
	<table name="schoolcheckpointsrank" key="int" value="SchoolCheckPointsList" cacheCapacity="1"/> 本次逐日之旅排行榜只存前五个玩家的信息
	
	<xbean name="SchoolCheckTeam"> 本次逐日之旅队伍id
		<variable name="teamlist" type="list" value="long" order="1"/>
	</xbean>
	<table name="schoolcheckpointsteam" key="int" value="SchoolCheckTeam" cacheCapacity="1" persistence="MEMORY"/> 参加逐日之旅的队伍id
	<!-- 逐日之旅end -->
	
	<!-- 坐骑 start -->
	<xbean name="ControlInfo"> 
		<enum name="CONTROL_PET" value="1"/> 宠物
		<enum name="CONTROL_XIAKE" value="2"/> 侠客
		<variable name="controltype" type="int" default="1" order="1"/> 统御类型
		<variable name="allkeys" type="vector" value="int" order="2"/> 被统御单位的key
	</xbean>
	
	<xbean name="BloodStoneInfo"> 
		<enum name="TYPE_ATTR" value="1"/> 属性
		<enum name="TYPE_SKILL" value="2"/> 技能
		<variable name="stonetype" type="int" order="1"/> 类型
		<variable name="stoneid" type="int" order="2"/> 血玉id
		<variable name="washid" type="int" order="3"/> 洗练的id
	</xbean>
	
	<xbean name="BloodStoneInfos"> 
		<variable name="infos" type="vector" value="BloodStoneInfo" order="1"/> 血玉效果
	</xbean>
	
	<xbean name="ZuoqiInfo"> 
		<variable name="zuoqikey" type="int" order="1"/> 坐骑key
		<variable name="zuoqiid" type="int" order="2"/> 坐骑id
		<variable name="duetime" type="long" order="3"/> 过期时间
		
		<variable name="degree" type="int" order="4"/> 亲密度
		<variable name="score" type="int" order="5"/> 评分
		<variable name="controlType" type="int" default="1" order="6"/> 当前统御类型，默认宠物
		<variable name="controls" type="map" key="int" value="ControlInfo" order="7"/> 被统御的宠物或侠客
		<variable name="stage" type="int" order="8"/> 阶数
		<variable name="times" type="int" order="9"/> 当前阶数对应的进度
		<variable name="count" type="int" order="10"/> 当前阶数已经升阶次数
		<variable name="bloodstones" type="map" key="int" value="BloodStoneInfos" order="11"/> key-阶数
		
		<variable name="bfp" type="BasicFightProperties" order="12"/>  一级属性
		<variable name="effects" type="map" key="int" value="float" order="13"/> key = effect type id
		<variable name="finalattrs" type="map" key="int" value="float" capacity="50" order="14"/> key = attr type
		<variable name="buffzuoqi" type="BuffAgent" order="15"/>	 buff
		
		<variable name="transformtasklineid" type="int" order="16"/>  变身任务线id
		<variable name="fashionid" type="int" order="17"/> 
	</xbean>
	
	<xbean name="ControlToZuoqi"> 
		<variable name="controled" type="map" key="int" value="int" order="1"/> key:侠客或宠物key, value:坐骑key
	</xbean> 
	<xbean name="zuoqiColumn"> 
		<variable name="nextkey" type="int" default="0" order="1"/> 下一个key
		<variable name="usingstatus" type="int" default="0" order="2"/>
		<variable name="selectkey" type="int" default="0" order="3"/>  默认坐骑 0无
		<variable name="rolezuoqimap" key="int" type="map" value="ZuoqiInfo" order="4"/>
		<variable name="controltozuoqi" key="int" type="map" value="ControlToZuoqi" order="5"/> 被统御单位与坐骑对应表 key:1-宠物 2-侠客,value:坐骑key
		<variable name="selectkeycopy" type="int" default="0" order="6"/>  默认坐骑备份 用于退队还原
		<variable name="selectstatuscopy" type="int" default="0" order="7"/>  默认坐骑状态
	</xbean>
	<table name="zuoqicolumns" key="long" type="map" value="zuoqiColumn" cacheCapacity="7000" lock="rolelock"/> 角色坐骑
	<!-- 坐骑 end -->
	
	<!-- 开服7天活动 start -->
	<xbean name="OpenServiceTask"> 
		<enum name="NOT" value="0"/> 不可领取奖励
		<enum name="CAN" value="1"/> 可领取奖励
		<enum name="DONE" value="2"/> 已领取奖励
		<variable name="tasknum" type="map" key="int" value="int" order="1"/> 每个大活动已经进行的活动次数
		<variable name="taskstatus" type="map" key="int" value="int" order="2"/> 已经领取奖励的以及可领取的子任务id  状态 0-默认不可领,1-可领取奖励 2-已领取奖励(已完成)
		<variable name="hadrewardlist" type="vector" value="int" order="3"/> 第7天已经领取的任务奖励
	</xbean>
	<table name="openservicetask" key="long" value="OpenServiceTask" cacheCapacity="7000" lock="rolelock"/> 开服7天活动总表
	<!-- 开服7天活动 end -->
	
	<!-- 任务链玩法 start -->
	<xbean name="TaskChainEvent"> 任务链不同类型事件的信息
		<variable name="configid" type="int" order="1"/> 事件的基础配置id
		<variable name="taskchaintype" type="int" order="2"/>  事件类型 见TaskChainType
		<variable name="status" type="int" order="3"/> 事件的完成状态  见TaskChainCommon中枚举
		<variable name="triggertime" type="long" order="4"/> 事件触发的时间（上交商会道具巡逻计时用）
		<variable name="patrolconf" type="int" order="5"/> 巡逻配置id
		<variable name="patrolitemnum" type="int" order="6"/> 巡逻获得道具的数量
		<variable name="npcid" type="int" order="7"/> 上交道具的NPCid
		<variable name="expaward" type="int" order="8"/>  完成传授心得任务时获得的经验值
		<variable name="assitname" type="string" order="9"/>  援助者的名字
		<variable name="doubleaward" type="boolean" order="10"/>  是否双倍 1是0否
		<variable name="askedforassit" type="boolean" order="11"/> 是否求助过 1是0否
		<variable name="npckey" type="long" order="12"/> 动态npc的key
		<variable name="npcmapid" type="int" order="13"/> 动态npc所在的地图
		<variable name="dstnpcx" type="int" order="14"/> 目的坐标x
		<variable name="dstnpcy" type="int" order="15"/> 目的坐标y
		<variable name="dstnpcz" type="int" order="16"/> 目的坐标z
		<variable name="orderlist" type="vector" value="int" order="17"/> 拼图任务序列
		<variable name="npcInfoId" type="int" order="18"/> 任务发布npc配置id
		<variable name="descriptionId" type="int" order="19"/> 任务描述配置id
	</xbean>
	<xbean name="TaskChain"> 每个任务链任务对应的玩法信息
		<variable name="acceptnum" type="int" order="1"/> 该任务链任务在刷新周期内接取的次数
		<variable name="lastaccepttime" type="long" order="2"/> 该任务链任务最近接取的时间
		<variable name="donenum" type="int" order="3"/> 当前完成的次数  当任务链任务完成时重置为0
		<variable name="openboxnum" type="int" order="4"/> 已开宝箱次数
		<variable name="totalawardexp" type="int" order="5"/> 刷新周期内累计获得的经验奖励
		<variable name="eventinfos" type="map" key="int" value="TaskChainEvent" order="6"/> 每个小循序中不同类型事件的详细信息 key=事件的唯一id
		<variable name="finishevents" type="map" key="int" value="TaskChainEvent" order="7"/> 已完成事件的详细信息 key=事件的唯一id
		<variable name="finishtaskchaincount" type="int" order="8"/> 完成环任务的次数
		<variable name="nextid" type="int" order="9"/> 事件的下一个唯一id
		<variable name="isAbandon" type="boolean" order="10"/> 是否因退帮强行放弃过
		<variable name="patroluniqueid" type="int" order="11"/> 当前正在巡逻的事件唯一id
		<variable name="tasklibid" type="int" order="12"/> 任务库id
		
		 
	</xbean>
	<xbean name="AllTaskChains">
		<variable name="taskchainmap" type="map" key="int" value="TaskChain" order="1"/> 每个任务对应的详细玩法信息  key=任务链任务id
		<variable name="helpfightnum" type="int" order="2"/>  援助杀怪次数
		<variable name="giveitemnum" type="int" order="3"/>  援助上交道具次数
		<variable name="reqgiveitemnum" type="int" order="4"/> 请求援助上交道具次数
	</xbean>
	<table name="roletaskchain" key="long" value="AllTaskChains" cacheCapacity="7000" lock="rolelock"/>
	<!-- 任务链玩法 end -->
	
	<xbean name="UseKiteInfo"> 
		<variable name="itemId" type="int" order="1"/> 当前风筝道具Id
		<variable name="useKiteCount" type="int" order="2"/> 使用道具次数	
		<variable name="lastUseTime" type="long" order="3"/> 最后一次使用风筝时间
		<variable name="totalExp" type="long" order="4"/> 当前道具获得经验累积
	</xbean>
	<table name="roleuseexpkite" key="long" value="UseKiteInfo" cacheCapacity="7000" lock="rolelock"/>经验风筝
	
	<!-- 切磋战斗记录start -->
	<xbean name="QieCuoRecordInfo">
		<variable name="hostroleid" type="long" order="1"/> 主方角色id
		<variable name="guestroleid" type="long" order="2"/> 客方角色id
		<variable name="isteam" type="int" order="3"/> 默认0无队伍，1有队伍
		<variable name="pktime" type="long" order="4"/> pk结束时间
	</xbean>
	<xbean name="QieCuoRecords">
		<variable name="recordlist" type="vector" value="QieCuoRecordInfo" order="1"/>
	</xbean>
	<table name="qiecuorecords" key="int" value="QieCuoRecords" cacheCapacity="4096"/> 战斗记录表
	<!-- 切磋战斗记录end -->
	
	<!-- PVP战斗记录和安全区列表start -->
	<xbean name="PKRecordInfo">
		<variable name="hostroleid" type="long" order="1"/> 主方角色id
		<variable name="guestroleid" type="long" order="2"/> 客方角色id
		<variable name="isteam" type="int" order="3"/> 默认0无队伍，1有队伍
		<variable name="pktime" type="long" order="4"/> pk结束时间
	</xbean>
	<xbean name="PKRecords">
		<variable name="recordlist" type="vector" value="PKRecordInfo" order="1"/>
	</xbean>
	<table name="pkrecords" key="int" value="PKRecords" cacheCapacity="1024" lock="maplock"/> 战斗记录表 ,key为mapid
	
	<xbean name="SafePKInfo">
		<variable name="hostroleid" type="long" order="1"/> 主方角色id
		<variable name="guestroleid" type="long" order="2"/> 客方角色id
	</xbean>
	<xbean name="SafePKInfos">
		<variable name="pkmap" type="map" key="long" value="SafePKInfo" order="1"/> key为battleid
	</xbean>
	<table name="safepkinfos" key="int" value="SafePKInfos" cacheCapacity="2048" persistence="MEMORY" lock="maplock"/> 安全区pk列表,key为mapid
	<!-- PVP战斗记录和安全区列表end -->
	
	<!-- 帮派申请优化 -->
	<xbean name="ApplyFactionBean">
		<variable name="factionkey" type="long" order="1"/>帮派Id
		<variable name="factionIndex" type="int" order="2"/> 帮派index
		<variable name="enterTime" type="long" order="3"/> 插入队列的时间
	</xbean>
	<xbean name="ApplyFrontTenFaction">
		<variable name="applyFactions" type="map" key="int" value="ApplyFactionBean" order="1"/>有规则的10个帮派	
	</xbean>
	<table name="applyfronttenfaction" key="int" value="ApplyFrontTenFaction" cacheCapacity="1"/> 帮派申请列表
	<!-- 帮派申请优化end -->
	
	<!-- 留存活动表 start -->
	<xbean name="RetainActivity">
		<variable name="currentId" type="int" order="1"/>      当前进行的任务id(-1-活动链进行完，0-活动链未激活)
		<variable name="activeTime" type="long" order="2"/>    当前活动激活时间
		<variable name="canAwardTime" type="long" order="3"/>  当前活动可以领奖的时间
	</xbean>
	<table name="retainactivity" key="long" value="RetainActivity" cacheCapacity="7000" lock="rolelock"/>
	<!-- 留存活动表 end -->
	
	<!-- 摆摊start -->
	<xbean name="AttentInfo">
		<variable name="attenttime" type="long" order="1"/> 关注时间
	</xbean>
	
	<xbean name="PetWaresInfo">
		<variable name="roleid" type="long" order="1"/> 卖家id
		<variable name="petinfo" type="PetInfo" order="2"/> 宠物信息
		<variable name="sellyuanbao" type="int" order="3"/> 卖多少元宝
		<variable name="yushoubuyer" type="list" value="long" order="4"/> 预售期买家
		<variable name="entershoptime" type="long" order="5"/> 进入摆摊的时间
		<variable name="yushoubuytime" type="long" order="6"/> 预售期被买的时间
		<variable name="chushoubuyer" type="long" order="7"/> 出售期买家
		<variable name="isdangerprice" type="boolean" defalut="false" order="8"/> 上架价格是否是危险价格
		<variable name="attentroles" type="map" key="long" value="AttentInfo" order="9"/> 关注玩家
		<variable name="preordertime" type="long" order="10"/> 预购时间
	</xbean>
	
	<xbean name="ItemWaresInfo">
		<variable name="roleid" type="long" order="1"/> 卖家id
		<variable name="iteminfo" type="Item" order="2"/>	道具信息
		<variable name="sellyuanbao" type="int" order="3"/> 卖多少元宝
		<variable name="yushoubuyer" type="list" value="long" order="4"/> 预售期买家
		<variable name="entershoptime" type="long" order="5"/> 进入摆摊的时间
		<variable name="yushoubuytime" type="long" order="6"/> 预售期被买的时间
		<variable name="chushoubuyer" type="long" order="7"/> 出售期买家
		<variable name="isdangerprice" type="boolean" defalut="false" order="8"/> 上架价格是否是危险价格
		<variable name="attentroles" type="map" key="long" value="AttentInfo" order="9"/> 关注玩家
		<variable name="preordertime" type="long" order="10"/> 预购时间
		<variable name="score" type="int" order="11"/> 评分
	</xbean>
	
	<xbean name="WaresLockInfo">
		<variable name="wareslockstatus" type="int" order="1"/> 商品锁定的状态 0--未锁定 1-已锁定
	</xbean>
	
	<xbean name="WaresPriceInfo">
		<variable name="prices" type="list" value="int" order="1"/> 商品平均价格
	</xbean>
	
	<xbean name="StallWaresInfo">
		<variable name="nextid" type="long" order="1"/>		下一个id
		<variable name="petwaresmap" type="map" key="long" value="PetWaresInfo" capacity="15" order="2"/> 宠物商品数据表
		<variable name="itemwaresmap" type="map" key="long" value="ItemWaresInfo" capacity="15" order="3"/> 背包商品数据表
		<variable name="wareslocks" type="map" key="int" value="WaresLockInfo" capacity="15" order="4"/> 商品锁定和解锁
		<variable name="waresprices" type="map" key="int" value="WaresPriceInfo" order="5"/> 商品最近平均价格信息
	</xbean>
	
	<table name="stallshopwares" key="int" value="StallWaresInfo" cacheCapacity="1"/> 摆摊商品信息表
	
	<xbean name="AuditingInfo">
		<variable name="wareskey" type="long" order="1"/> 商品单号
		<variable name="sellerid" type="long" order="2"/> 卖家id
		<variable name="pet" type="PetInfo" order="3"/> 宠物信息
		<variable name="item" type="Item" order="4"/> 物品信息
		<variable name="price" type="int" order="5"/> 价格
		<variable name="entertime" type="long" order="6"/> 上架时间
		<variable name="auditingtime" type="long" order="7"/> 交易成功时间
		<variable name="buyerid" type="long" order="8"/> 买家id
		<variable name="auditingendtime" type="long" order="9"/> 审核结束
	</xbean>
	<xbean name="Auditings">
		<variable name="nextid" type="long" order="1"/>
		<variable name="auditings" type="map" key="long" value="AuditingInfo" cacheCapacity="30" order="2"/>
	</xbean>
	<table name="auditing" key="int" value="Auditings" cacheCapacity="1"/> 审核信息
	
	<xbean name="AuditingLogInfo">
		<variable name="auditingkey" type="long" order="1"/> 审核记录表的key
		<variable name="sellerid" type="long" order="2"/> 卖家id
		<variable name="pet" type="PetInfo" order="3"/> 宠物信息
		<variable name="item" type="Item" order="4"/> 物品信息
		<variable name="price" type="int" order="5"/> 价格
		<variable name="entertime" type="long" order="6"/> 上架时间
		<variable name="auditingtime" type="long" order="7"/> 交易成功时间
		<variable name="buyerid" type="long" order="8"/> 买家id
		<variable name="auditinglogtime" type="long" order="9"/> 审核结束之后 审核日志表交易开始时间
	</xbean>
	<xbean name="AuditingLogs">
		<variable name="nextid" type="long" order="1"/>
		<variable name="auditinglogs" type="map" key="long" value="AuditingLogInfo" cacheCapacity="30" order="2"/>
	</xbean>
	<table name="auditinglog" key="int" value="AuditingLogs" cacheCapacity="1"/> 审核通过后信息存储表 每一次起服会被清空
	
	<xbean name="TransactionLogInfo">
		<variable name="result" type="int" order="1"/> 1.出售 2.购买
		<variable name="itemid" type="int" order="2"/> 商品的id
		<variable name="itemnum" type="int" order="3"/> 商品的数量
		<variable name="price" type="int" order="4"/> 商品的价格
		<variable name="endtime" type="long" order="5"/> 交易成功的时间
		<variable name="starid" type="int" order="6"/> 星级
		<variable name="perfix" type="int" order="7"/> 前缀
		<variable name="level" type="int" order="8"/> 等级
		<variable name="auditingkey" type="long" order="9"/> 审核记录的key
		<variable name="turned" type="int" order="10"/> 幻化状态
	</xbean>
	<xbean name="TransactionLog">
		<variable name="transactionlogs" type="list" value="TransactionLogInfo" cacheCapacity="30" order="1"/>
	</xbean>
	<table name="transactionlog" key="long" value="TransactionLog" cacheCapacity="7000" lock="rolelock"/> 交易日志
	
	<xbean name="AttentWares">
		<variable name="wareskey" type="long" order="1"/>
		<variable name="itemid" type="int" order="2"/>
	</xbean>
	<xbean name="StallWaresIds">
		<variable name="stallwaresidlist" type="list" value="long" order="1"/>  摊位id
		<variable name="tipsnotime" type="long" order="2"/>  七天不弹tips
		<variable name="attentwares" type="list" value="AttentWares" order="3"/>  关注商品
		<variable name="preorders" type="list" value="AttentWares" order="4"/> 玩家预购商品
	</xbean>
	<table name="role2stallwares" key="long" value="StallWaresIds" cacheCapacity="7000" lock="rolelock"/> 角色对应摊位id的list
	<!-- 摆摊end -->
	
	<!-- 师徒系统 start -->
	<xbean name="Zuoye">
		<variable name="count" type="int" order="1"/>
		<variable name="configId" type="int" order="2"/>
		<variable name="isFinish" type="boolean" order="3"/>
	</xbean>
	<xbean name="BreakBean">
		<variable name="roleId" type="long" order="1"/>
		<variable name="isUseYinpiao" type="boolean" order="2"/> 是否使用银票来解除 
		<variable name="breakchoose" type="int" order="3"/> 解除关系的选项 1 师傅 2 徒弟
	</xbean>
	<xbean name="YanshouCount">
		<variable name="yanshouType" type="int" order="1"/> 1 师傅 2 徒弟
		<variable name="count" type="int" order="2"/> 次数
	</xbean>
	<xbean name="ShituRelation">
		<variable name="state" type="int" order="1"/> 0 正常, 1 师傅 2 徒弟
		<variable name="isChushi" type="boolean" order="2"/> 是否已经出师
		<variable name="shifuRid" type="long" order="3"/> 师傅的roleid
		<variable name="canBaishiNextTime" type="long" order="4"/>  解除关系后下一次能申请的时间
		<variable name="zuoyeMap" type="map" key="int" value="Zuoye" order="5"/> 作业 key=configid
		<variable name="tudiIngList" type="list" value="long" order="6"/> 授业中 放置roleid
		<variable name="tudiedList" type="list" value="long" order="7"/> 已出师 放置roleid
		<variable name="yanshouCount" type="map" key="int" value="YanshouCount" order="8"/> 今日的验收次数(徒弟最多1次, 师傅每天最多2次)
		<variable name="breakBean" type="BreakBean" order="9"/> 解除关系的bean
		<variable name="lastsetTime" type="long" order="10"/>上一次更新时间
		<variable name="isyanshou" type="int" order="11"/> 是否已经验收(0未验收 1已经验收) 
		<variable name="joinshimentime" type="long" default="0" order="12"/>  加入师门时间
		<variable name="chushitime" type="long" default="0" order="13"/> 出师时间
	</xbean>
	<table name="shiturelation" key="long" value="ShituRelation" cacheCapacity="7000" lock="rolelock"/> 师徒系统表
	<!-- 师徒系统 end -->
	<!-- 师徒系统重构 -->
	<xbean name="Master">
		<variable name="tudiinglist" type="list" value="long" order="1"/> 授业中 放置roleid
		<variable name="tudiedlist" type="list" value="long" order="2"/> 已出师 放置roleid
		<variable name="yanshouCount" type="int" order="3"/> 今日的验收次数(徒弟最多1次, 师傅每天最多2次)
		<variable name="lastsetTime" type="long" order="4"/>上一次更新时间
		<variable name="isdealrank" type="boolean" order="5"/>是否处理过插入排行榜
	</xbean>
	<table name="mastertable" key="long" value="Master" cacheCapacity="7000" lock="rolelock"/> 师徒系统表师傅
	<xbean name="Disciple">
		<variable name="isChushi" type="boolean" order="1"/> 是否已经出师
		<variable name="shifuRid" type="long" order="2"/> 师傅的roleid
		<variable name="canBaishiNextTime" type="long" order="3"/>  解除关系后下一次能申请的时间
		<variable name="zuoyeMap" type="map" key="int" value="Zuoye" order="4"/> 作业 key=configid
		<variable name="lastsetTime" type="long" order="5"/>上一次更新时间
		<variable name="isyanshou" type="int" order="6"/> 是否已经验收(0未验收 1已经验收)
		<variable name="joinshimentime" type="long" default="0" order="7"/>  加入师门时间
		<variable name="chushitime" type="long" default="0" order="8"/> 出师时间
	</xbean>
	<table name="discipletable" key="long" value="Disciple" cacheCapacity="7000" lock="rolelock"/> 师徒系统表徒弟
	<xbean name="ItemCount">
		<variable name="itemid" type="int" order="1"/>
		<variable name="count" type="int" order="2"/>
	</xbean>
	<xbean name="OtherItemCountInfo">
		<variable name="itemcount" type="map" key="int" value="ItemCount" order="1"/> 送给xx人xx物品xx次
	</xbean>
	<xbean name="ShituGift">
		<variable name="itemcount" type="map" key="int" value="ItemCount" order="1"/> 今日已经送了xx物品多少次
		<variable name="giveotherinfo" type="map" key="long" value="OtherItemCountInfo" order="2"/> 别人送我礼物的信息
		<variable name="lastsettime" type="long" order="3"/>
	</xbean>
	<table name="shitugifttable" key="long" value="ShituGift" cacheCapacity="7000" lock="rolelock"/> 师徒礼物表
	<!-- 师徒系统重构end -->
	
	<!-- 拜师平台start -->
	<xbean name="LoginAsMasterInfo">
		<variable name="roleid" type="long" order="1"/>
		<variable name="choosess" type="list" value="int" order="2"/>
		<variable name="expiretime" type="long" order="3"/> 失效时间(14 days)
	</xbean>
	<xbean name="LoginAsMasterTable">
		<variable name="loginasmastertable" type="map" key="long" value="LoginAsMasterInfo" order="1"/>
	</xbean>
	<table name="loginasmaster" key="int" value="LoginAsMasterTable" cacheCapacity="1"/> 
	<!-- 拜师平台end -->
	
	<!-- 固定队伍start -->
	<xbean name="FixedTeamInfo">
		<variable name="teamLeaderId" type="long" order="1"/>队长ID
		<variable name="teammembers" type="map" key="long" value="FixedTeamMember" order="2"/>
	</xbean>
	
	<xbean name="FixedTeamMember">
		<variable name="jointime" type="long" order="1"/>
	</xbean>
	<table name="fixedteam" key="long" value="FixedTeamInfo" lock="fixedteamlock" autoIncrement="true" cacheCapacity="4096"/> 固定队伍表
	<table name="roleid2fixedteamid" key="long" value="long" lock="rolelock" cacheCapacity="7000"/> 角色与固定队对应表
	
	<xbean name="FixedInviteInfo">
		<variable name="beingInvited" type="boolean" order="1"/>
	</xbean>
	<table name="fixedteaminvite" key="long" value="FixedInviteInfo" lock="rolelock" persistence="MEMORY" cacheCapacity="8192"/> 固定队邀请记录
	<table name="roleid2groupmsg" key="long" value="long" lock="rolelock" cacheCapacity="7000"/> 群发消息表，上次发送时间
	
	<!-- 固定队伍end -->

	<!--举报系统start-->
	<!--举报者的信息-->
	<xbean name="ReporterInfo"> 
		<variable name="times" type="int" order="1"/> 同一条msg举报次数
	</xbean>
	<!--单条举报信息-->
	<xbean name="ReportInfo">
    	<variable name="reporterRoleIds" type="map" key="long" value="ReporterInfo" order="1"/> 举报者的roleid以及举报信息
    	<variable name="reasons" type="map" key="string" value="int" order="2"/> 举报原因以及每种原因的举报次数
	</xbean>
	<!--被举报者的所有举报信息-->
	<xbean name="ReportInfos">
    	<variable name="reportedRoleId" type="long" order="1"/>  被举报者roleid
    	<variable name="firstReportRoleId" type="long" order="2"/> 第一个举报者的roleid，用于发奖。每举报成功一次清零
    	<variable name="reportMsgs" type="map" key="string" value="ReportInfo" order="3"/>  举报信息，key为message
    	<variable name="successCount" type="int" order="4"/>  24小时内被举报成功次数
    	<variable name="firstSuccessTime" type="long" order="5"/>  第一次被举报成功时间，24小时内有效
    	<variable name="lastReportTime" type="long" order="6"/> roleid最后一次被举报的时间，用来清理举报失败数据
    	<variable name="gmtGetTime" type="long" order="7"/>  gmt最后一次取数据的时间
    	<variable name="lastReportSucessTime" type="long" order="8"/> 最后一次被举报成功的时间
	</xbean>
	<xbean name="UnCheckReportInfos">
    	<variable name="unCheckReportInfos" type="map" key="long" value="ReportInfos" order="1"/>  未处理过的举报信息
    	<variable name="sentGmtRoleIds" type="list" value="long" order="2"/> 本时段要发给GMT的被举报者的roleid集合
	</xbean>
	<table name="uncheckreportinfos" key="int" value="UnCheckReportInfos" cacheCapacity="1"/>

	<xbean name="AutoCheckedReportInfos">
    	<variable name="autoCheckedReportInfos" type="list" value="ReportInfos" order="1"/>  自动处理过的举报信息
	</xbean>
	<table name="autocheckedreportinfos" key="int" value="AutoCheckedReportInfos" cacheCapacity="1"/>
	<!--举报系统end-->
	
	<!--7日登陆奖励表 start-->
 	<xbean name="SevenDayAwardInfo">
		<variable name="sevendayonlinetime" type="long" order="1"/> 七日累计登陆 上次登陆时间
		<variable name="todayid" type="int" order="3"/> 当前天数
		<variable name="sevendayaward" type="map" key="int" value="AwardState" order="4"/> 七日累计登陆奖励信息
	</xbean>
	<table name="sevendayaward" key="long" value="SevenDayAwardInfo" cacheCapacity="7000" lock="rolelock"/> 
	<!-- 7日登陆奖励表 end -->
	<xbean name="AwardState">
    	<variable name="firststate" type="int" order="1"/>  第一次领奖状态
    	<variable name="twicestate" type="int" order="2"/> 第二次领奖状态
	</xbean>

	<!-- 帮派周任务 start-->
	<xbean name="WeekTaskBean"> 
		<variable name="taskId" type="int" order="1"/> 任务Id
		<variable name="addAward" type="int" order="2"/> 奖励加成 增加1%-300% 当前保存[1-300]
		<variable name="receicedNum" type="int" order="3"/> 被领取的次数
		<variable name="taskMirrorRoleId" type="long" order="4"/> 挑战帮友镜像roleId
	</xbean>
	<xbean name="FactionWeekTaskBean"> 		
		<variable name="weekTaskInfos" type="map" key="int" value="WeekTaskBean" order="1"/>任务列表
		<variable name="refreshTime" type="long" order="2"/>刷新时间	
	</xbean>
	<table name="factionweektask" key="long" value="FactionWeekTaskBean" cacheCapacity="4096" lock="factionlock"/>
	<xbean name="FactionWeekTaskRole"> 		
		<variable name="completeNum" type="int" order="1"/> 本周已领取的任务次数
		<variable name="allCompleteNum" type="int" order="2"/> 领取任务累积 计算额外奖励
		<variable name="abandonNum" type="int" order="3"/> 放弃次数
		<variable name="lastReceiveTaskTime" type="long" order="4"/> 最后一次领取的时间
		<variable name="curTaskId" type="int" order="5"/> 当前领取的ID
		<variable name="curAddAward" type="int" order="6"/> 当前的任务加成	
		<variable name="taskMirrorRoleId" type="long" order="7"/> 挑战帮友镜像roleId
		<variable name="extraAwardStatus" type="int" order="8"/> 是否领取额外奖励 1是0否
	</xbean>
	<table name="factionweektaskrole" key="long" value="FactionWeekTaskRole" cacheCapacity="7000" lock="rolelock"/> 帮派周任务
	<!-- 帮派周任务 end-->
	<!-- 阵营每日任务 start-->
	<xbean name="DayTaskBean"> 
		<variable name="taskId" type="int" order="1"/> 任务Id
		<variable name="taskSatr" type="int" order="2"/> 任务星级
	</xbean>
	<xbean name="CampDayTaskRole">
		<variable name="commitNum" type="int" order="1"/> 已完成任务次数
		<variable name="lastReceiveTaskTime" type="long" order="2"/> 最后一次领取的时间
		<variable name="curTaskId" type="int" order="3"/> 当前领取的ID
		<variable name="dayTaskInfos" type="map" key="int" value="DayTaskBean" order="4"/>任务列表
		<variable name="refreshTime" type="long" order="5"/>刷新时间
		<variable name="boxReceive" type="boolean" order="6"/>宝箱是否领取
		<variable name="freerefreshcount" type="int" order="7"/>免费刷新次数
		<variable name="freerefreshtime" type="long" order="8"/>免费刷新时间
	</xbean>
	<table name="campdaytaskrole" key="long" value="CampDayTaskRole" cacheCapacity="7000" lock="rolelock"/> 阵营每日任务
	<!-- 阵营每日任务 end-->
	<!--红包start-->
	<xbean name="RandomHongbaoInfo">
		<variable name="receivedroleId" type="long" order="1"/> 收红包人roleid
		<variable name="randomMoney" type="int" order="2"/> 随机的金钱
		<variable name="receivedTime" type="long" order="3"/> 收到红包的时间
	</xbean>

	<xbean name="HongbaoInfo">
		<variable name="sender" type="long" order="1"/> 发红包人roleid
		<variable name="sendTime" type="long" order="2"/>  发红包时间
		<variable name="channel" type="int" order="3"/> 频道
		<variable name="msg" type="string" order="4"/> 附言
		<variable name="hongbaoLevel" type="int" order="5"/> 普通红包配置档位id，道具红包为0
		<variable name="money" type="int" order="6"/>  红包金额
		<variable name="type" type="int" order="7"/> 红包类型。普通红包-1，金钱道具红包-2
		<variable name="randomHongbaos" type="list" value="RandomHongbaoInfo" order="8"/> 随机拆分出的红包
		<variable name="usedNum" type="int" order="9"/> 已经被抢到红包个数
		<variable name="overdueflag" type="int" order="10"/> 0-未过期，1-过期已返还 
		<variable name="factionKey" type="long" order="11"/> 如果是帮派红包，记录factionkey
	</xbean>
	<table name="hongbao" key="long" value="HongbaoInfo" cacheCapacity="8192" autoIncrement="true"/>  红包表

	<xbean name="SentHongbao">
		<variable name="totalMoney" type="int" order="1"/> 发红包的总金钱
		<variable name="totalNum" type="int" order="2"/> 发红包总个数
		<variable name="hongbaos" type="list" value="long" order="3"/> 已经发出的红包key
		<variable name="everyDaySendtimesInWorld" type="int" order="4"/> 世界频道每天发出红包个数。用来限制每天世界频道发红包个数
		<variable name="lastInWorldSendTime" type="long" order="5"/> 世界频道最后一次发红包时间。用来隔天清理数据。
		<variable name="everyDaySendtimesInFaction" type="int" order="6"/> 帮派频道每天发出红包个数。用来限制每天帮派频道发红包个数
		<variable name="lastInFactionSendTime" type="long" order="7"/> 帮派频道最后一次发红包时间。用来隔天清理数据。
	</xbean>

	<xbean name="ReceivedHongbaoInfo">
		<variable name="hongbaoKey" type="long" order="1"/> 收到红包的key
		<variable name="receivedMoney" type="int" order="2"/> 收到红包的金钱
	</xbean>
	<xbean name="ReceivedHongbao">
		<variable name="totalLuckNum" type="int" order="1"/> 收到运气最佳红包总数量
		<variable name="totalMoney" type="int" order="2"/> 收红包的总金钱
		<variable name="totalNum" type="int" order="3"/> 收红包总个数
		<variable name="hongbaos" type="list" value="ReceivedHongbaoInfo" order="4"/> 收到红包的信息，按收到时间插入，方便返回收红包历史纪录
		<variable name="everyDayReceivedMoney" type="int" order="5"/> 每天抢红包累计金钱。用来限制每天抢红包金钱
		<variable name="lastReceiveTime" type="long" order="6"/> 最后一次抢红包的时间。用来隔天清理数据。
	</xbean>

	<xbean name="HongbaoRecord">
		<variable name="sentHongbao" type="SentHongbao" order="1"/>  已经发过的红包
		<variable name="receivedHongbao" type="ReceivedHongbao" order="2"/> 已经收到的红包
	</xbean>
	<table name="hongbaorecord" key="long" value="HongbaoRecord" cacheCapacity="7000" lock="rolelock"/> 发红包和收红包的记录表。key为roleid

	<xbean name="LastHongbao">
		<variable name="lastHongbaoKeys" type="list" value="long" order="1"/>  最近100条红包key
	</xbean>
	<table name="worldlasthongbao" key="int" value="LastHongbao" cacheCapacity="1"/> 世界最近更新的红包信息表

	<table name="factionlasthongbao" key="long" value="LastHongbao" cacheCapacity="4096" lock="factionlock"/> 帮派最近更新红包表
	<!--红包end-->
	
	<xbean name="CrossPropertiesInfo">
		<variable name="fromServerid" type="int" order="1"/> 来自服务器
	</xbean>
	<table name="crossproperties" key="long" value="CrossPropertiesInfo" cacheCapacity="7000" lock="rolelock"/>
	
	<!-- 跨服观战 start -->
	<xbean name="CrossBattleWatch">
		<variable name="allfighters" type="set" value="long" order="1"/> 该场战斗的所有参战玩家
		<variable name="crosswatchers" type="set" value="long" order="2"/> 本服观战该场战斗的所有玩家
	</xbean>
	<table name="crossbattlewatch" key="long" value="CrossBattleWatch" cacheCapacity="20000" lock="battle" persistence="MEMORY"/> key=battleid

	<table name="crossroleid2battleid" key="long" value="long" cacheCapacity="30000" lock="rolelock" persistence="MEMORY"/> 跨服战斗广播给每个服战斗者id与battleid的映射关系
	<!-- 跨服观战 end -->
	
	<xbean name="CrossBattleInfo" any="true">
		<enum name="TOBATTLE_NO" value="0"/>
		<enum name="TOBATTLE_OK" value="1"/>
		<variable name="onlineToBattle" type="int" order="3"/> 状态为重新登录时进入跨服战斗中
		<variable name="battleServerid" type="int" order="4"/>
		<variable name="sysBattleId" type="long" order="5"/>
		<variable name="battleId" type="long" order="6"/>
		<variable name="hostRoleId" type="long" order="7"/>
		<variable name="hostMembers" type="set" value="long" order="8"/>
		<variable name="guestRoleId" type="long" order="9"/>
		<variable name="guestMembers" type="set" value="long" order="10"/>
		<variable name="future" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="11"/>
		<variable name="handler" type="ares.logic.cross.battle.CrossCommonBattleHandler" order="12"/>
		<variable name="enterWorldFuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="13"/>
	</xbean>
	<table name="crossbattle" key="long" value="CrossBattleInfo" cacheCapacity="7000" lock="rolelock" persistence="MEMORY"/>
	
	<xbean name="CrossBattleState">
		<enum name="NO" value="0"/>
		<enum name="OK" value="1"/>
		<variable name="state" type="int" order="3"/>
	</xbean>
	<xbean name="SysCrossBattleInfo" any="true">
		<variable name="roles" type="map" key="long" value="CrossBattleState" order="1"/>
		<variable name="future" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="2"/>
		<variable name="battle" type="ares.logic.battle.PNewBattle" order="3"/>
		<variable name="handler" type="ares.logic.cross.battle.CrossCommonBattleHandler" order="4"/>
	</xbean>
	<table name="syscrossbattle" key="long" value="SysCrossBattleInfo" cacheCapacity="3000" persistence="MEMORY" autoIncrement="true"/>
	
	<!--蜀山论剑-->
	<xbean name="ShuShanPKGradeAward">
		<variable name="status" type="boolean" default="false" order="1"/> true-已经发放、false-未发放
	</xbean>
	<xbean name="ShuShanPKRoleInfo">
		<variable name="score" type="int" order="1"/>
		<variable name="battleNum" type="int" order="2"/> 赛季总战斗场次
		<variable name="winNum" type="int" order="3"/> 赛季总胜利次数
		<variable name="todayWinNum" type="int" order="4"/> 今天胜利次数
		<variable name="firstWinAward" type="boolean" default="false" order="5"/> 首胜奖励状态
		<variable name="todayJoinTime" type="long" order="6"/> 今天参与时间，用于刷新每天数据
		<variable name="curSeasonId" type="int" order="7"/> 当前赛季id
		<variable name="seasonAwardStatus" type="boolean" default="false" order="8"/> 赛季奖励发放状态
		<variable name="gradeAwards" type="map" key="int" value="ShuShanPKGradeAward" order="9"/> 段位奖励发放状态。key-段位id
		<variable name="watchawardnum" type="int" order="10"/> 观战奖励发放次数
		<variable name="todaybattleawardnum" type="int" order="11"/> 每天战斗获得奖励次数
		<variable name="seasonfirstspecialgrade" type="boolean" order="12"/> 赛季第一次达到特殊段位
	</xbean>
	<xbean name="ShuShanPKRoleInfos">
		<variable name="infos" type="map" key="int" value="ShuShanPKRoleInfo" order="1"/> key为pk类型，参看ShuShanPKType枚举
	</xbean>
	<table name="shushanpkroles" key="long" value="ShuShanPKRoleInfos" cacheCapacity="7000" lock="rolelock"/>

	<xbean name="ShuShanPKMatchRoleInfo">
		<variable name="roleId" type="long" order="1"/>
		<variable name="school" type="int" order="2"/>
		<variable name="shapeId" type="int" order="3"/>
	</xbean>
	<xbean name="ShuShanPKMatchInfo">
		<!--<variable name="roleId" type="long" order="1"/> 单人或队长id-->
		<variable name="fightPower" type="int" order="2"/> 单人或队伍平均战力
		<variable name="score" type="int" order="3"/> 单人或队伍平均积分
		<variable name="formid" type="int" order="4"/> 单人或队伍阵法，用于匹配成功后显示
		<variable name="roles" type="list" value="ShuShanPKMatchRoleInfo" order="5"/> 队伍成员
		<variable name="leader" type="ShuShanPKMatchRoleInfo" order="6"/> 单人或队长信息
		<variable name="matchNum" type="int" order="7"/> 匹配次数，每次匹配队列匹配一次没有匹配成功就加1
		<variable name="isMatched" type="boolean" default="false" order="8"/> 是否已经匹配到了
		<variable name="level" type="int" order="9"/> 单人或队伍平均等级
	</xbean>
	<xbean name="ShuShanPKMatchList">
		<variable name="matchList" type="list" value="ShuShanPKMatchInfo" order="1"/>
		<variable name="matchingRoles" type="map" key="long" value="long" order="2"/> 正在匹配中的角色，用于加入队列时做过滤
	</xbean>
	<table name="shushanpkmatchlists" key="int" value="ShuShanPKMatchList" cacheCapacity="5" persistence="MEMORY"/> 匹配表，key为pk类型，单人，五人

	<xbean name="ShuShanPKRankUnit">
		<variable name="roleId" type="long" order="1"/>
		<variable name="serverId" type="int" order="2"/>
		<variable name="roleName" type="string" order="3"/>
		<variable name="school" type="int" order="4"/>
		<variable name="score" type="int" order="5"/>
		<variable name="battleNum" type="int" order="6"/>
	</xbean>
	<xbean name="ShuShanPKRank">
		<variable name="ranklist" type="list" value="ShuShanPKRankUnit" order="1"/>
		<variable name="seasonId" type="int" order="2"/>
		<variable name="seasonjoinroles" type="map" key="long" value="long" order="3"/> 本赛季参与比赛的角色，用于赛季结束发奖。key=roleid，value=待定
	</xbean>
	<xbean name="ShuShanPKRanklists">
		<!--<variable name="curSeasonRank" type="ShuShanPKRank" order="1"/> 本赛季排行榜
		<variable name="historyRanks" type="list" value="ShuShanPKRank" order="2"/> 历史赛季排行榜-->
		<variable name="ranks" type="map" key="int" value="ShuShanPKRank" order="3"/> key为赛季id
	</xbean>
	<table name="shushanpkranklist" key="int" value="ShuShanPKRanklists" cacheCapacity="5"/> 排行榜，key为pk类型，单人，五人

	<xbean name="ShuShanPKWatchUnitOneSide">
		<variable name="serverId" type="int" order="1"/>
		<variable name="leaderId" type="long" order="2"/>
		<variable name="leaderName" type="string" order="3"/>
		<variable name="school" type="int" order="4"/>
		<variable name="score" type="int" order="5"/>
		<variable name="battlenum" type="int" order="6"/>
	</xbean>
	<xbean name="ShuShanPKWatchUnit">
		<variable name="battleServerId" type="int" order="1"/> 弃用。可以用battleid计算出serverid
		<variable name="battleId" type="long" order="2"/>
		<variable name="avgScore" type="int" order="3"/>
		<variable name="avgFightPower" type="int" order="4"/>
		<variable name="left" type="ShuShanPKWatchUnitOneSide" order="5"/>
		<variable name="right" type="ShuShanPKWatchUnitOneSide" order="6"/>
	</xbean>
	<xbean name="ShuShanPKWatchBattle">
		<variable name="battleList" type="list" value="ShuShanPKWatchUnit" order="1"/>
	</xbean>
	<table name="shushanpkwatchbattle" key="int" value="ShuShanPKWatchBattle" cacheCapacity="5" persistence="MEMORY"/> 观战列表, key为pk类型，单人，五人
	
	<xbean name="LimitInfo">
		<variable name="lastgettime" type="long" order="1"/> 最后一次试用礼包的时间
		<variable name="usecount" type="int" order="2"/> 使用次数
	</xbean>
	<xbean name="PresentLimitRole">
		<variable name="presentlimitinfos" type="map" key="int" value="LimitInfo" order="1"/> 礼包限制信息数组
	</xbean>
	<table name="presentlimit" key="long" value="PresentLimitRole" cacheCapacity="7000" lock="rolelock"/> 礼包限制表
	
	<!-- 回魂仙梦start -->
	<xbean name="FairyDreamInfo">
		<variable name="chapter" type="treemap" key="int" value="ChapterInfo" order="1"/> 开启的章节
	</xbean>
	
	<xbean name="ChapterInfo">
		<enum name="UNDONE" value="0"/> 正在进行
		<enum name="DONE" value="1"/> 已完成
		<variable name="chapterstatus" type="int" order="1"/> 章节状态
		<variable name="stages" type="list" value="int" order="2"/> 已经进行的关卡
	</xbean>
	<table name="fairydream" key="long" value="FairyDreamInfo" lock="rolelock" cacheCapacity="7000"/> 回魂仙梦表
	
	<xbean name="FairyDreamReplyRole">	
		<variable name="roleid" type="long" order="1"/>
		<variable name="level" type="int" order="2"/>
	</xbean>
	
	<xbean name="FairyDreamReply">	
		<variable name="time" type="int" order="1"/>
		<variable name="replyid" type="long" order="2"/>
		<variable name="roles" type="list" value="FairyDreamReplyRole" order="3"/>
	</xbean>
	
	<xbean name="FairyDreamReplys">	
		<variable name="reolys" type="list" value="FairyDreamReply" order="1"/>
	</xbean>
	
	<table name="fairydreamreply" key="int" value="FairyDreamReplys" lock="fairydreamreplyslock" cacheCapacity="1024"/> 回魂仙梦录像表 key=关卡id
	
	<!-- 回魂仙梦end -->
	
	<!-- 帮派搜索 start-->
	<xbean name="FactionBean">
		<variable name="factionKey" type="long" order="1"/>
		<variable name="factionName" type="string" order="2"/>
	</xbean>
	<xbean name="SearchFactionInfo">
		<variable name="factionmaps" type="map" key="int" value="FactionBean" order="1"/>
	</xbean>	
	<table name="factioninfoindexandname" key="int" value="SearchFactionInfo" persistence="MEMORY" cacheCapacity="1"/>
	
	<!--帮派名称对应表，key为帮派名称，value为factionindex-->
	<table name="factionname2index" key="string" value="int" cacheCapacity="4096" cachehigh="512" cachelow="256"/>
	<!-- 帮派搜索 end-->
	
	<!-- 累计充值 start -->
	<xbean name="GrandTotalRowBean">
		<variable name="confid" type="int" order="1"/>
		<variable name="count" type="int" order="2"/>
		<variable name="state" type="int" order="3"/> 状态 0未完成,1完成未领取, 2 已经领取
	</xbean>
	<xbean name="GrandTotalPageBean">
		<variable name="grandtotalpage" type="map" key="int" value="GrandTotalRowBean" order="1"/> key是configid ,value是rowbean
		<variable name="pagetype" type="int" order="2"/> 页面类型 1 充值, 2消费 
	</xbean>
	<xbean name="GrandTotal">
		<variable name="historyrowbean" type="map" key="int" value="GrandTotalRowBean" order="1"/> 历史配置信息
		<variable name="grandtotal" type="map" key="int" value="GrandTotalPageBean" order="2"/> key是页面类型 ,pagebean
		<variable name="lastreqtime" type="long" order="3"/> 最后一次访问时间
	</xbean>
	<table name="grandtotaltable" key="long" value="GrandTotal" cacheCapacity="7000" lock="rolelock"/>
	<!-- 累计充值 end -->
	<xbean name="StarNpcBean">
		<variable name="npcids" type="set" value="int" order="1"/> 击败过得npc
		<variable name="awardrecord" type="set" value="int" order="2"/> 图鉴奖励领取记录
	</xbean>	
	<table name="beatnpcsrole" key="long" value="StarNpcBean" cacheCapacity="7000" lock="rolelock"/> 伏魔击败过的npc
	<xbean name="KumamotoItemBean">
		<variable name="kumamotoCount" type="int" order="1"/> 使用熊本次数
		<variable name="awardKumamotoCount" type="int" order="2"/> 领取熊本奖励次数
		<variable name="lastUseKumamotoTime" type="long" order="3"/> 最后使用熊本的时间
	</xbean>	
	<xbean name="DemonItemBean">
		<enum name="SHENMO_TYPE" value="1"/> 伏魔令
		<enum name="SHENMO_AWARD_TYPE" value="1"/> 伏魔奖励次数
		<enum name="SHENMO_HELP_AWARD_TYPE" value="2"/> 伏魔奖励次数
		<variable name="demonCount" type="int" order="1"/> 使用的道具次数
		<variable name="awardCount" type="int" order="2"/> 领取奖励的次数
		<variable name="helpAwardCount" type="int" order="3"/> 领取帮杀奖励的次数
		<variable name="lastUseDemonTime" type="long" order="4"/> 最后一次的领取时间
	</xbean>
	<table name="demonrole" key="long" value="DemonItemBean" cacheCapacity="7000" lock="rolelock"/> 使用道具召唤的怪

	<!-- 传记 start-->
	<xbean name="Biographys">
		<variable name="curRead" type="int" default="0" order="1"/>
		<variable name="taskIds" type="list" value="int" order="2"/>
	</xbean>
	<table name="biography" key="long" value="Biographys" cacheCapacity="7000" lock="rolelock"/>
	<!-- 传记 end-->
	
	<!-- 自定义头像 start-->
	<xbean name="avatarBean">
		<variable name="avatarUrl" type="string" order="1"/>
		<variable name="lastUploadTime" type="long" order="2"/>
		<variable name="defaultAvatar" type="int" default="0" order="3"/> 0默认头像 1自定义头像
	</xbean>

	<table name="customavatar" key="long" value="avatarBean" cacheCapacity="7000" lock="rolelock"/>
	<!-- 自定义头像 end-->
	
	<!-- 个人空间 start-->
	<xbean name="PersonalSpaceBean">
		<variable name="dianzangiftnum" type="int" order="1"/> 点赞放置礼物数量
		<variable name="popularnum" type="int" order="2"/>  人气值
		<variable name="todaydianzanrole" type="map" key="int" value="TodayZanRole" order="3"/>  当天点赞过的人
		<variable name="recentdianzan" type="list" value="RecentDianZan" order="4"/> 最近来点赞的人
		<variable name="timeofdianzan" type="long" order="5"/> 点赞时间  每天对指定人只能点赞一次  每天清零
		<variable name="albumphotolist" type="list" value="AlbumPhoto" order="6"/> 相册列表
		<variable name="currentcolor" type="int" default="-1" order="7"/>  最新分享的染色方案Id
		<variable name="sharepetkeys" type="list" value="int" order="8"/> 分享的宠物列表
		<variable name="lastUploadTime" type="long" order="9"/> 上次上传相册时间
	</xbean>
	
	<xbean name="TodayZanRole">
		<variable name="roles" type="set" value="long" order="1"/>  当天点赞过的人
	</xbean>
	
	<xbean name="AlbumPhoto">
		<variable name="photourl" type="string" order="1"/>  相册照片URL
		<variable name="photodianzannum" type="int" order="2"/>  相册照片点赞数
		<variable name="photodianzanrolelist" type="list" value="long" order="3"/>  相册照片点过赞的人记录列表
	</xbean>
	
	<xbean name="RecentDianZan">
		<variable name="roleid" type="long" order="1"/> 点赞人的ID
		<variable name="giftstate" type="int" order="2"/> 点赞获得礼物情况  0-未获得  1-获得
	</xbean>
	
	<table name="personalspacetable" key="long" value="PersonalSpaceBean" cacheCapacity="7000" lock="rolelock"/>
	<!-- 个人空间 end-->
	
	<!-- 捷径（等级限购）礼包 start -->
	<xbean name="LevelLimitBuyInfo">
		<variable name="buynum" type="int" order="1"/> 已购买个数
		<variable name="opentime" type="long" order="2"/> 限购开启时间
	</xbean>
	<xbean name="LevelLimitBuyInfos">
		<variable name="levellimits" type="map" key="int" value="LevelLimitBuyInfo" order="1"/>  key=商城道具配置id
	</xbean>
	<table name="levellimitbuy" key="long" value="LevelLimitBuyInfos" cacheCapacity="7000" lock="rolelock"/> 记录玩家的等级限购信息
	<!-- 捷径（等级限购）礼包 end -->
	
	<xbean name="StarBoxBean">
		<variable name="openCount" type="int" order="1"/> 开启宝箱的次数
		<variable name="lastOpenBoxTime" type="long" order="2"/> 最后一次的开启宝箱时间
	</xbean>
	<table name="starboxrole" key="long" value="StarBoxBean" cacheCapacity="7000" lock="rolelock"/> 开启伏魔宝箱
	
	<!-- 成就系统 start-->
	<xbean name="AchievementItemPara">
		<variable name="pkWinNum" type="int" order="1"/>			阵营PK胜利总次数
		<variable name="itemsNum" type="map" key="int" value="int" order="2"/>	各种道具总使用数量 key=itemid value=itemNum
		<variable name="countNum" type="map" key="int" value="int" order="3"/>    计数类成就完成的次数 key=成就id value=次数
		<enum name="STALLYUANBAO" value="1"/>  商城元宝
		<enum name="TUDI" value="2"/>  收徒弟
		<enum name="LINGFU_BUY_NUM" value="3"/>灵符购买数量
		
		<enum name="POS1COLOR" value="50"/>  位置1染色
		<enum name="POS2COLOR" value="51"/>  位置2染色
		
		<variable name="activityNum" type="map" key="int" value="int" order="4"/>    活动日历表各活动完成的总次数 key=活动id value=次数(key参见PlayActiveRole)
	</xbean>
	<!-- 成就中某些成就项的条件完成进度数据，不能随时算出来的就记录在这里 -->
	<table name="achievementitempara" key="long" value="AchievementItemPara" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	
	<xbean name="AchievementInfo">
		<enum name="CANGAINAWARD" value="1"/>		
		<enum name="GAINEDAWARD" value="2"/>		
		<variable name="state" type="int" order="1"/>	状态 1-可领取奖励 2-已领取奖励(已完成)
	</xbean>
	<xbean name="AchievementInfos">
		<variable name="infos" type="map" key="int" value="AchievementInfo" order="1"/> key = 成就ID
	</xbean>
	<table name="achievementinfos" key="long" value="AchievementInfos" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	<!-- 成就系统 end-->
	
	<!--功能解锁 start-->
	<xbean name="UnlockPara">
		<variable name="loginday" type="int" order="1"/> 登陆多少钱天
	</xbean>
	<!-- 功能解锁中某些成就项的条件完成进度数据，不能随时算出来的就记录在这里 -->
	<table name="unlockpara" key="long" value="UnlockPara" lock="rolelock" cacheCapacity="7000"/>
	
	<xbean name="UnlockInfo">
		<enum name="CANGAINAWARD" value="1"/>		
		<enum name="GAINEDAWARD" value="2"/>		
		<variable name="state" type="int" order="1"/>	状态 1-可领取奖励 2-已领取奖励(已完成)
	</xbean>
	<xbean name="UnlockInfos">
		<variable name="infos" type="map" key="int" value="UnlockInfo" order="1"/> key = 解锁id
	</xbean>
	<table name="unlockinfos" key="long" value="UnlockInfos" lock="rolelock" cacheCapacity="7000"/>
	<!--功能解锁 end-->
	
	<!-- 订婚/结婚系统 start -->
	<xbean name="MarryInfo">
		<enum name="NONE" value="0"/>
		<enum name="ENGAGED" value="1"/>
		<enum name="MARRIED" value="2"/>
		<variable name="marryState" type="int" order="1"/> 婚姻状态0-无 1-订婚 2-结婚
		<variable name="mateId" type="long" order="2"/> 伴侣roleid
		<variable name="mateName" type="string" order="3"/> 伴侣姓名(婚戒tips用，不存的话会有死锁)
		<variable name="ringType" type="int" order="4"/> 订婚使用的戒指类型
		<variable name="engagedTime" type="long" order="5"/> 订婚时间
		<variable name="activerId" type="long" order="6"/> 主动者ID(发起订婚、结婚者)
		<variable name="vow1" type="string" order="7"/> 誓言1(主动者誓言)
		<variable name="vow2" type="string" order="8"/> 誓言2
		
		<variable name="order" type="int" order="9"/> 第几对夫妻
		<variable name="marryTime" type="long" order="10"/> 结婚时间
		<variable name="marryType" type="int" order="11"/> 婚礼类型
		<variable name="titleName" type="string" order="12"/> 自定义称号
		<enum name="DIVORCE_AGREEMENT" value="1"/>
		<enum name="DIVORCE_FORCE" value="2"/>
		<variable name="applyDivorceId" type="long" order="13"/>发起离婚申请的人
		<variable name="startDivorceTime" type="long" order="14"/> 大于0表示离婚中
		<variable name="divorceType" type="int" order="15"/> 离婚类型 1-协议 2-强制
	</xbean>
	<table name="marry" key="long" value="MarryInfo" cacheCapacity="7000" lock="rolelock"/>
	<xbean name="DivorceInfo">
		<variable name="temp" type="boolean" order="1"/> 占位符没用,以后这个bean有数据了可删除
	</xbean>
	<xbean name="FeastInfo">
		<variable name="eatNum" type="int" order="1"/>被吃了几次
	</xbean>
	<xbean name="GiveMoneyInfo">
		<variable name="money" type="int" order="1"/> 礼金数量
		<variable name="toRoleId" type="long" order="2"/> 送给谁
		<variable name="giveTime" type="long" order="3"/> 送的时间
	</xbean>
	<xbean name="GiveMoneyInfos">
		<variable name="infos" type="list" value="GiveMoneyInfo" order="1"/> 礼金相关信息
	</xbean>
	<xbean name="MarryOrderInfo">
		<variable name="giveMoneyRoles" type="map" key="long" value="int" order="1"/> 给过礼金的人(旧版) key=roleid value=num
		<variable name="robMarryNum" type="int" order="2"/> 已抢亲次数
		<variable name="throwHappySweetNum" type="int" order="3"/> 已撒喜糖次数
		<variable name="eatFeastRoles" type="map" key="long" value="int" order="4"/> 吃过酒席的人 key=roleid value=num
		<variable name="feastInfos" type="map" key="int" value="FeastInfo" order="5"/>每桌酒席的情况 key=酒桌ID
		<variable name="giveMoneyRoleInfos" type="map" key="long" value="GiveMoneyInfos" order="6"/> 给过礼金的人（新版）key=roleid
	</xbean>
	<xbean name="SysMarry">
		<variable name="curOrder" type="int" order="1"/>
		<variable name="divorceInfos" type="map" key="long" value="DivorceInfo" order="2"/> key=发起离婚的人
		<variable name="marryOrderInfo" type="map" key="int" value="MarryOrderInfo" order="3"/> key=marryOrder 每场婚礼的数据
	</xbean>
	<table name="sysmarry" key="int" value="SysMarry" cacheCapacity="1"/>
	<!-- 订婚/结婚系统 end -->
	
	<!-- 仓库改名 start -->
	<xbean name="Warehouse">		
		<variable name="warehouseName" type="string" order="1"/>仓库name		
	</xbean>
	<xbean name="WarehouseRole">
		<variable name="warehouses" type="map" key="int" value="Warehouse" order="1"/>			
	</xbean>
	<table name="warehouserole" key="long" value="WarehouseRole" cacheCapacity="7000" lock="rolelock"/> 仓库
	<!-- 仓库改名 end -->
	
	<!-- 染色系统 start -->
	<xbean name="XColorProject"> 配色方案
		<variable name="projectid" type="int" order="1"/> 染色方案id
		<variable name="colorWithState" type="map" key="int" value="PosColorDetail" order="4"/> 部位颜色对应状态 key-posId
	</xbean>
	
	<xbean name="PosColorDetail"> 配色方案
		<variable name="color" type="int" order="1"/> 颜色
		<variable name="state" type="int" order="2"/> 状态
	</xbean>

	<xbean name="RoleColorProject"> 角色的染色系统信息
		<!--<variable name="nextid" type="int" order="3"/> 下一个方案id（自增）-->
		<variable name="curprojectid" type="int" order="4"/> 当前使用的染色方案ID
		<variable name="projectinfo" type="map" key="int" value="XColorProject" order="5"/> 所有的染色方案信息	
	</xbean>

	<table name="rolecolorprojects" key="long" value="RoleColorProject" cacheCapacity="7000" lock="rolelock"/>
	<!-- 染色系统 end -->
	
	<!-- bingo活动start-->
	<xbean name="HolidayStatus">
		<enum name="CANGAINAWARD" value="1"/>		
		<enum name="GAINEDAWARD" value="2"/>		
		<variable name="state" type="int" order="1"/>	状态 1-可领取奖励(达到次数) 2-已领取奖励(已完成)
	</xbean>
	<xbean name="BingoTaskInfo">
		<variable name="donenum" type="int" order="1"/> 已完成次数
		<variable name="lasttime" type="long" order="2"/> 上次加次数时间
	</xbean>
	<xbean name="HolidayInfos">
		<variable name="tasks" type="map" key="int" value="HolidayStatus" order="1"/> key = 任务id
		<variable name="awards" type="map" key="int" value="HolidayStatus" order="2"/> key = 奖励配置id
		<variable name="tasknum" type="map" key="int" value="BingoTaskInfo" order="3"/>    计数类活动完成的次数 key=任务类型
	</xbean>
	<xbean name="CommonHolidays">
		<variable name="holidayinfos" type="map" key="int" value="HolidayInfos" order="1"/> key-大活动id
	</xbean>
	<table name="commonholiday" key="long" value="CommonHolidays" lock="rolelock" cacheCapacity="7000"/>
	<!-- bingo活动 end-->
	
	<!-- 充值转盘 -->
	<xbean name="ChargeWheel">
		<variable name="chargeTotal" type="int" order="1"/> 充值总数
		<variable name="hundredUseNum" type="int" order="2"/>百里挑一已抽奖次数
		<variable name="thousandUseNum" type="int" order="3"/> 千载难逢已抽奖次数
		<variable name="consumeTotal" type="int" order="4"/> 消费总数
		<variable name="fiveHundredUseNum" type="int" order="5"/> 稀有之宝已抽奖次数 
		<variable name="tenThousandUseNum" type="int" order="6"/> 旷世奇珍已抽奖次数
		<variable name="hundredAddNum" type="int" order="7"/>百里挑一使用道具获得的抽奖次数
		<variable name="thousandAddNum" type="int" order="8"/> 千载难逢使用道具获得的抽奖次数
		<variable name="fiveHundredAddNum" type="int" order="9"/> 稀有之宝使用道具获得的抽奖次数
		<variable name="tenThousandAddNum" type="int" order="10"/> 旷世奇珍使用道具获得的抽奖次数
	</xbean>
	<xbean name="ChargeWheelActivity">
		<variable name="activities" type="map" key="int" value="ChargeWheel" order="1"/> key=活动id
	</xbean>
	<table name="chargewheel" key="long" value="ChargeWheelActivity" lock="rolelock" cacheCapacity="7000"/>
	
	<table name="chargewheelitemlimit" key="int" value="ActivityItemLimit" cacheCapacity="1024" cachehigh="512" cachelow="256"/>
	
	<!-- 魂玉转盘 -->
	<xbean name="SoulWheel">
		<variable name="exp" type="int" order="1"/> 经验值
		<variable name="expbox" type="list" value="int" order="2"/> 经验宝箱 1,2,3
	</xbean>
	<xbean name="SoulWheelActivity">
		<variable name="activities" type="map" key="int" value="SoulWheel" order="1"/> key=活动id
	</xbean>
	<table name="soulwheel" key="long" value="SoulWheelActivity" lock="rolelock" cacheCapacity="7000"/>
	
	<table name="soulwheelitemlimit" key="int" value="ActivityItemLimit" cacheCapacity="1024" />
	
	<xbean name="SoulWheelPoolInfo">
		<variable name="soul" type="int" order="1"/> 池子魂玉总值
	</xbean>
	<table name="soulwheelpool" key="int" value="SoulWheelPoolInfo" cacheCapacity="1024" />
	
	<!-- 魂玉返利 -->
	<xbean name="ConsumereturnsInfo">
		<variable name="costnum" type="int" order="1"/>玩家当日消费数
		<variable name="returnnum" type="int" order="2"/>玩家明日可领取返利数
		<variable name="todaynum" type="int" order="3"/>玩家今日可领取返利
		<variable name="refreshtime" type="long" order="4"/>活动刷新时间
	</xbean>
	<table name="consumereturns" key="long" value="ConsumereturnsInfo" lock="rolelock" cacheCapacity="7000"/>
	
	<!-- 战斗反外挂相关统计信息 -->
	<xbean name="IllegalBattleInfo">
		<variable name="lastbattleid" type="long" order="1"/> 最近一次非法战斗的id
		<variable name="illegalnum" type="int" order="2"/>  非法战斗次数
		<variable name="continuenum" type="int" order="3"/> 连续非法战斗的次数（每三次记录一条日志，并清空该计数）
		<variable name="beloggednum" type="int" order="4"/> 被日志统计的次数
	</xbean>
	<xbean name="AllIllegalBattleInfo">
		<variable name="teamillegalbattles" type="map" key="long" value="IllegalBattleInfo" order="1"/> 所有队伍的非法战斗信息记录  key=teamId  value=非法战斗统计信息
		<variable name="lasttime" type="long" order="2"/> 最近一次修改数据的时间（数据每天清空）
	</xbean>
	<table name="illegalbattleinfos" key="int" value="AllIllegalBattleInfo" persistence="MEMORY" cacheCapacity="1"/>

	<!-- IOS低档位充值的次数统计信息 -->
	<xbean name="AppsChargeNum">
		<variable name="num" type="int" order="1"/> 档位今日已购买次数
	</xbean>
	<xbean name="AppsRmb6ChargeInfo">
		<variable name="chargenums" type="map" key="int" value="AppsChargeNum" order="1"/> 不同档位今日的购买信息  key=档位金额  value=该档位今日购买信息
		<variable name="refreshtime" type="long" order="2"/> 刷新时间
		<variable name="appid" type="string" order="3"/> 玩家所用客户端的appid（用于区分不同的客户端包）
	</xbean>
	<table name="appschargenum" key="long" value="AppsRmb6ChargeInfo" lock="rolelock" cacheCapacity="7000"/>
	
	<!-- 跨服-服内战 start -->
	<xbean name="PreCrossTeamNames">
		<variable name="configid" type="int" order="1"/> 每届的id
		<variable name="usednames" type="list" value="string" order="2"/> 本届已被使用的名字
	</xbean>
	<table name="precrossteamname" key="int" value="PreCrossTeamNames" cacheCapacity="1"/>  跨服-服内战每届已用的战队名字
	
	<xbean name="PreCrossTeamVoteInfo">
		<variable name="votedmembers" type="map" key="long" value="boolean" order="1"/> key为队员的id，value为投票意见，true==同意，false==不同意
		<variable name="totalnum" type="int" order="2"/> 参与本次投票的总人数
	</xbean>
	<table name="precrossteamvote" key="long" value="PreCrossTeamVoteInfo" cacheCapacity="8192" lock="teamlock" persistence="MEMORY"/> key=战队id
	
	<xbean name="PreCrossRoleInfo"> 服内战参战玩家的信息
		<variable name="teamid" type="long" order="1"/> 玩家所属战队id
		<variable name="isleader" type="boolean" order="2"/> 是否是战队队长
		<variable name="configid" type="int" order="3"/> 玩家参加的当期服内战配置id（即每届的id）
		<variable name="ischampion" type="boolean" order="4"/> 是否是本届服内战的冠军战队成员
	</xbean>
	<table name="precrossrole" key="long" value="PreCrossRoleInfo" cacheCapacity="7000" lock="rolelock"/>
	
	<xbean name="PreCrossRoleBet"> 玩家的下注信息
		<variable name="num" type="int" order="1"/> 玩家的下注总金额
	</xbean>
	<xbean name="PreCrossTeamBetInfo"> 战队的被下注信息
		<variable name="round" type="int" order="1"/> 场次，冗余一份，逻辑处理方便一些
		<variable name="rolebets" type="map" key="long" value="PreCrossRoleBet" order="2"/> 所有下注玩家的信息
		<variable name="totalnum" type="int" order="3"/> 被下注的总金额（单独存储，避免每次都遍历计算）
		<variable name="dealstatus" type="boolean" order="4"/> 结算状态，true=已结算，false=未结算，避免逻辑异常导致结算多次
	</xbean>
	<xbean name="PreCrossFightInfo">  服内战对战信息
		<variable name="myteamleader" type="long" order="1"/>  发起准备的队长id
		<variable name="starttime" type="long" order="2"/>  对战开始准备的时间
		<variable name="aimteamid" type="long" order="3"/> 对战战队id
		<variable name="finishnum" type="int" order="4"/> 已战斗次数
		<variable name="winnum" type="int" order="5"/> 获胜次数
		<variable name="fightstatus" type="int" order="6"/> 对战状态 见如下枚举
		<variable name="preparefuture" type="long" order="7"/> 系统准备时间内（或对手发起准备后）的广播定时器key
		<variable name="betinfos" type="map" key="int" value="PreCrossTeamBetInfo" order="8"/> key=对战场次 value=玩家的下注数据
		
		<enum name="INITIAL" value="0"/> 初始状态
		<enum name="PREPARING" value="1"/> 准备中
		<enum name="FIGHTING" value="2"/> 对战中
	</xbean>
	<xbean name="PreCrossTeamMember"> 服内战战队队员的信息
		<variable name="roleid" type="long" order="1"/> 角色id
	</xbean>
	<xbean name="PreCrossTeamInfo"> 服内战战队信息
		<variable name="leaderid" type="long" order="1"/> 战队队长的roleid
		<!--<variable name="camp" type="int" order="2"/> 战队报名时的阵营-->
		<variable name="name" type="string" order="3"/> 战队名字
		<variable name="taskstep" type="int" order="4"/> 试炼任务完成的步数
		<variable name="taskfinishtime" type="long" order="5"/> 试炼任务完成的时间
		<variable name="members" type="vector" value="PreCrossTeamMember" order="6"/> 战队中的所有队员信息
		<variable name="doingtask" type="boolean" order="7"/> 是否在进行试炼任务
		<variable name="receivedflowers" type="int" order="8"/> 全民支持阶段战队累计获得的鲜花数量
		<variable name="ischampion" type="boolean" order="9"/> 是否是本届服内战的冠军战队
		<variable name="fightinfos" type="map" key="int" value="PreCrossFightInfo" order="10"/> 本战队的所有对战信息 key见SOpenPreCrossFightDlg中枚举
		<variable name="canCrossPvp" type="boolean" order="11" /> 战队是否能参加跨服战
		<variable name="group" type="int" order="12"/> 分组情况
		<variable name="isexchange" type="boolean" order="13"/> 交换状态(记录进入半决赛交换两组第二名)
	</xbean>
	<table name="precrossteam" key="long" value="PreCrossTeamInfo" cacheCapacity="4096" autoIncrement="true" lock="precrossteamlock"/>
	
	<xbean name="PreCrossActivityInfo"> 每届服内战的全部参战信息
		<variable name="teams" type="vector" value="long" order="1"/> 本届参战的所有战队id
		<variable name="championteams" type="set" value="long" order="2"/> 本届参战的冠军战队id（应该是有资格进行真跨服的战队）
	</xbean>
	<table name="precrossactivity" key="int" value="PreCrossActivityInfo" cacheCapacity="4" lock="precrosslock"/> key=每届活动的配置id
	
	<xbean name="PreCrossTeamRankData"> 排行榜战队信息
		<variable name="teamid" type="long" order="1"/> 战队id
		<variable name="teamname" type="string" order="2"/> 战队名字
		<variable name="finishtasknum" type="int" order="3"/> 完成试炼层数
		<variable name="finishtasktime" type="long" order="4"/> 完成试炼层数的时间
		<variable name="totalpower" type="int" order="5"/> 战队总战力
	</xbean>
	<xbean name="PreCrossRankData"> 每届活动所有上榜战队信息
		<!--<variable name="xianmeng" type="list" value="PreCrossTeamRankData" order="1"/> 仙盟的上榜战队列表
		<variable name="jianmeng" type="list" value="PreCrossTeamRankData" order="2"/> 剑盟的上榜战队列表-->
		<variable name="rankList" type="list" value="PreCrossTeamRankData" order="3"/> 上榜战队列表
	</xbean>
	<table name="precrossrank" key="int" value="PreCrossRankData" cacheCapacity="4" lock="precrosslock"/> key=每届活动的配置id
	
	<xbean name="PreCrossAwardMailStatus">
		<variable name="groupmail" type="map" key="int" value="boolean" order="1"/> 小组赛淘汰奖励是否发送  key=分组
		<variable name="semifinalmail" type="map" key="int" value="boolean" order="2"/> 半决赛淘汰奖励是否发送 key=分组
		<variable name="finalmail" type="boolean" order="3"/> 决赛奖励邮件是否发送
	</xbean>
	<xbean name="PreCrossGroupMatch">  跨服-服内战小组赛所有资格战队
		<!--<variable name="xianmeng" type="list" value="long" capacity="8" order="1"/> 仙盟参加小组赛的所有战队id(8个)
		<variable name="jianmeng" type="list" value="long" capacity="8" order="2"/> 剑盟参加小组赛的所有战队id(8个)-->
		<variable name="awardmailstatus" type="PreCrossAwardMailStatus" order="3"/> 奖励邮件的发送状态
		<variable name="oneGroup" type="list" value="long" capacity="8" order="4"/> 分出的组一参加小组赛的所有战队id(4个)
		<variable name="twoGroup" type="list" value="long" capacity="8" order="5"/> 分出的组二参加小组赛的所有战队id(4个)
		<variable name="exstatus" type="int" order="6"/> 两小组队伍交换状态
	</xbean>
	<table name="precrossgroupmatch" key="int" value="PreCrossGroupMatch" cacheCapacity="4" lock="precrosslock"/> key=每届活动的配置id
	
	<xbean name="PreCrossBattleInfo"> 对战双方的队长id
		<variable name="hostroleid" type="long" order="1"/>
		<variable name="guestroleid" type="long" order="2"/>
	</xbean>
	<xbean name="PreCrossBattles">
		<variable name="battleinfos" type="map" key="long" value="PreCrossBattleInfo" order="1"/> key=战斗id  value=对战双方的简要信息
	</xbean>
	<table name="precrossbattles" key="int" value="PreCrossBattles" cacheCapacity="1" persistence="MEMORY"/> 服内战当前正在进行的对战信息
	
	<xbean name="CandidateInfo">
		<variable name="serverId" type="int" order="1" />
		<variable name="teamId" type="long" order="2" />
		<variable name="totalScore" type="int" order="3" /> 总战力
	</xbean>
	<xbean name="Candidates">
		<variable name="allTeams" type="map" key="long" value="CandidateInfo" order="1"/> key=teamid
	</xbean>
	<table name="candidateslist" key="int" value="Candidates" cacheCapacity="4" lock="precrosslock"/> key=每届活动的配置id
	<!-- 跨服-服内战 end -->
	
	<!-- roll点机制 -->
	<xbean name="RollCounts">
		<variable name="rollIDs" type="set" value="long" order="1"/> 当前正在进行的roll点id
		<variable name="dayresettime" type="long" order="2"/>	每天重置活动的次重置时间
		<variable name="weekresettime" type="long" order="3"/>	每周重置活动上次重置时间 
		<variable name="count" type="map" key="int" value="RollCount" order="4"/>		
	</xbean>
	<xbean name="RollCount">
		<variable name="daycount" type="int" order="1"/>			当天参与次数
		<variable name="weekcount" type="int" order="2"/>		每周参与次数
	</xbean>
	<table name="rollcounts" key="long" value="RollCounts" cacheCapacity="7000" lock="rolelock"/>	记录玩家roll事件参与次数
	
	<xbean name="Roll">	
		<variable name="confId" type="int" order="1"/> 对应配表id
		<variable name="endTime" type="long" order="2"/> 结束时间
		<variable name="roles" type="list" value="long" order="3"/>	参与玩家id
		<variable name="rollitems" type="list" value="RollItemBean" order="4"/>	奖励物品
	</xbean>
	<xbean name="RollItemBean">	
		<variable name="item" type="Item" order="1"/>	道具
		<variable name="winner" type="long" order="2"/> 道具获得者,为0表示还未开奖
		<variable name="roles" type="list" value="RollItemRoleBean" order="3"/>每个roll点玩家的信息
	</xbean>
	<xbean name="RollItemRoleBean">
		<variable name="roleid" type="long" order="1"/>
		<variable name="rollstate" type="int" order="2"/> 是否完成 -1 未选 0放弃 1已选
		<variable name="rollscore" type="short" order="3"/>
	</xbean>

	<table name="roll" key="long" value="Roll" cacheCapacity="7000" autoIncrement="true" lock="rolllock"/>	记录玩家roll事件参与次数
	<!-- roll点机制 end-->
	<xbean name="AnonyItemBean">
		<variable name="itemId" type="int" order="1"/> 匿名卡Id 	
		<variable name="anonyName" type="string" order="2"/>		
		<variable name="anonyshape" type="int" order="3"/>		
	</xbean>
	<table name="anonyrole" key="long" value="AnonyItemBean" cacheCapacity="7000" lock="rolelock"/> 帮派资金窃取

	<!-- 历史累计充值返利 start-->
	<xbean name="ChargeRebateAwardInfo">
		<variable name="isreceive" type="boolean" order="1"/> 奖励领取状态. false-未领取，true-已领取
	</xbean>
	<xbean name="ChargeRebateBean">
		<variable name="chargeRebateAwards" type="map" key="int" value="ChargeRebateAwardInfo" order="1"/> 奖励列表。key-奖励配置id，value-奖励信息
		<variable name="gmaddcash" type="int" order="2"/> GM指令增加的充值金额，用于测试
	</xbean>
	<table name="historychargerebate" key="long" value="ChargeRebateBean" cacheCapacity="7000" lock="rolelock"/>
	<!-- 历史累计充值返利 end-->

	<!-- 回归玩家奖励 start-->
	<xbean name="returnAwardInviteeInfo">
		<variable name="roleid" type="long" order="1"/> 被邀请人roleid
	</xbean>
	<xbean name="returnAwardBean">
		<variable name="returnTime" type="long" order="1"/> 本次回归时间
		<variable name="lossDays" type="int" order="2"/> 本次流失天数
		<variable name="inviterRoleId" type="long" order="3"/> 本次回归邀请者roleid。没有为0
		<variable name="todayLiveness" type="int" order="4"/> 本次回归期间当天活跃度
		<variable name="totalLiveness" type="int" order="5"/> 本次回归期间累计活跃度
		<variable name="refreshLivenessTime" type="long" order="6"/> 本次回归期间刷新活跃时间，为了累加多天活跃度
		<variable name="isInvitedSuccess" type="boolean" order="7"/> 本次是否被邀请成功
		<variable name="invitees" type="list" value="returnAwardInviteeInfo" order="8"/> 被邀请者列表
	</xbean>
	<table name="returnawards" key="long" value="returnAwardBean" cacheCapacity="7000" lock="rolelock"/>
	<!-- 回归玩家奖励 end-->

		
	<!-- 讨论组聊天 start-->
	<xbean name="ChatGroupInfo">  讨论组
		<variable name="createRoleId" type="long" order="1"/>		创建者roleId
		<variable name="name" type="string" order="2"/>			讨论组名字
		<variable name="members" type="list" value="long" order="3"/>     组内成员
	</xbean>		
	<table name="chatgroup" key="long" value="ChatGroupInfo" lock="chatgrouplock" autoIncrement="true" cacheCapacity="20480"/> 讨论组表
	<xbean name="ChatGroupData"> 个人的群信息和设置
		<variable name="isleader" type="boolean" order="1"/> 是否是群主 
		<variable name="isshield" type="boolean" order="2"/> 是否屏蔽
	</xbean>
	<xbean name="ChatGroupRoleInfo">
		<variable name="groupinfos" type="map" key="long" value="ChatGroupData" order="1"/>
	</xbean>
	<table name="role2chatgroup" key="long" value="ChatGroupRoleInfo" lock="rolelock" cacheCapacity="7000"/> 角色加入的讨论组
	<!-- 讨论组聊天 end-->
	
	<!-- 五鬼封印 start-->
	<xbean name="FiveGhostPointBean">  五鬼封印点位
		<variable name="roles" type="list" value="long" order="1"/>  站在点上的roleId 按照进入先后排序
	</xbean>
	<xbean name="FiveGhostSealBean"> 五鬼封印任务所需数据
		<variable name="points" type="map" key="int" value="FiveGhostPointBean" order="1"/> 点位情况
	</xbean>
	<table name="fiveghostseal" key="long" value="FiveGhostSealBean" cacheCapacity="8192" lock="teamlock" persistence="MEMORY"/> 五鬼封印表 key=战队id
	<!-- 五鬼封印 end-->
	
	<!-- 押镖 start-->
	<xbean name="YaBiaoRole">  讨论组
		<variable name="count" type="int" order="1"/>	押镖次数
		<variable name="hubiaoCount" type="int" order="2"/>	护镖次数
		<variable name="resetTime" type="long" order="3"/>	每日重置时间
		<variable name="biaoType" type="int" order="4"/>   本次随机到的押镖类型
		<variable name="lostCount" type="int" order="5"/>   本次押镖战斗失败次数
		<variable name="isRun" type="boolean" default="false" order="6"/>	是否正在进行
		<variable name="biginTime" type="long" order="7"/>  记录押镖开始时间
		<variable name="taskId" type="int" order="8"/> 任务ID
 	</xbean>		
	<table name="yabiaorole" key="long" value="YaBiaoRole" lock="rolelock" cacheCapacity="7000"/> 押镖
	<!-- 押镖 end-->
	
	<!-- VIP start-->
	<xbean name="VipDetail">
		<variable name="vipEndTime" type="long" order="1"/> vip到期时间
		<variable name="vipDayAwardTime" type="long" order="2"/> vip每日礼包领取/发放时间
		<variable name="alertMailRecord" type="int" order="3"/> 最后发送到期提醒天数 默认-1,未发送 ,0为过期提醒
		<variable name="freenum" type="int" order="4"/> 可赠送次数 废弃
	</xbean>
	<xbean name="VipInfo"> 
		<variable name="vipdetail" type="map" key="int" value="VipDetail" order="1"/> key为vip等级
		<variable name="freenums" type="map" key="int" value="int" order="2"/> 可赠送次数
	</xbean>
	<table name="viprole" key="long" value="VipInfo" lock="rolelock" cacheCapacity="7000"/> vip
	<!-- VIP end-->
	
	<!-- 贵族 start-->
	<xbean name="Aristocrat"> 
		<variable name="exp" type="int" order="1"/>  贵族经验
		<variable name="awards" type="map" key="int" value="int" order="2"/> 购买贵族礼包次数 key 礼包id
	</xbean>
	<table name="aristocratrole" key="long" value="Aristocrat" lock="rolelock" cacheCapacity="7000"/> 
	<!-- 贵族 end-->
	
	<xbean name="RetrieveActivity"> 
		<variable name="free" type="boolean" order="1"/> 是否免费找回经验
		<variable name="useitem" type="boolean" order="2"/> 是否使用道具找回经验
	</xbean>
	<xbean name="RetrieveExp"> 
		<variable name="retrieveTime" type="long" order="1"/> 
		<variable name="RetrieveActivity" type="map" key="int" value="RetrieveActivity" order="2"/>
	</xbean>
	<table name="retrieveexprole" key="long" value="RetrieveExp" lock="rolelock" cacheCapacity="7000"/> 找回经验
	
	<!-- 挂机历练玩法 start -->
	<xbean name="HangUpInfo">
		<variable name="battleNum" type="int" order="1"/> 今日战斗场数
		<variable name="refreshTime" type="long" order="2"/> 每日刷新战斗场数时间
		<variable name="doublePoints" type="int" order="3"/> 双倍点数
	</xbean> 
	<table name="hangupexperience" key="long" value="HangUpInfo" lock="rolelock" cacheCapacity="7000"/> 挂机历练
	<!-- 挂机历练玩法 end -->
	
	<!-- 经验雨 start -->
	<xbean name="ExpRain">  
		<variable name="lastResetTime" type="long" order="1"/>						最后重置时间
		<variable name="expRainCount" type="map" key="int" value="int" order="2"/> 	次数统计,key=活动id,value=当日次数
	</xbean>
	<table name="exprainbean" key="long" value="ExpRain" cacheCapacity="7000" lock="rolelock"/>
	<!-- 经验雨 end -->

	<!-- 秦岭探宝 start -->
	<xbean name="ClimbTowerMonster"> 山海爬塔怪物信息(以备扩展)
		<variable name="npcKey" type="long" order="1"/> npcKey
	</xbean>
	
	<xbean name="ClimbTowerFloor"> 山海爬塔楼层数据
		<variable name="mapId" type="int" order="1"/> 地图ID
		<variable name="monsters" type="map" key="long" value="ClimbTowerMonster" order="2"/> 存活怪物
		<variable name="boxes" type="set" value="long" order="3"/> 剩余宝箱
		<variable name="transferNpcs" type="set" value="long" order="4"/> 传送npc
		<variable name="killNum" type="int" order="5"/> 杀怪数量
		<variable name="findNpcNum" type="int" order="6"/> 找到真npc的次数
	</xbean>
	
	<xbean name="ClimbTowerInfo"> 山海爬塔数据
		<variable name="floors" type="treemap" key="int" value="ClimbTowerFloor" order="1"/> 所有层数据  key层数 value ClimbTowerFloor
	</xbean>
	
	<xbean name="ClimbTowerFloorFuture" any="true"> 山海爬塔定时器
		<variable name="boxFuture" type="java.util.concurrent.ScheduledFuture&lt;?&gt;" order="1"/>宝箱刷新定时器
	</xbean>
	<table name="climbtower" key="int" value="ClimbTowerInfo" cacheCapacity="1" persistence="MEMORY" lock="climbtowerlock"/> 山海爬塔
	<table name="climbtowerfloorfuture" key="int" value="ClimbTowerFloorFuture" cacheCapacity="500" persistence="MEMORY"/> 山海爬塔定时器
	<xbean name="ClimbTowerRoleInfo"> 山海爬塔角色信息
		<variable name="items" type="map" key="int" value="int" order="1"/> 本次活动的掉落数据 key 道具id
		<variable name="lastTime" type="long" order="2"/> 最新一次参与活动的时间
		<variable name="awardFloors" type="set" value="int" order="3"/>已领取过哪些层的额外奖励
		<variable name="killAwardNum" type="int" order="4"/> 杀怪奖励次数
		<variable name="boxAwardNumMap" type="map" key="int" value="int" order="5"/> 宝箱获奖次数  key宝箱类型 1金 2银 value 拾取次数
		<variable name="totalKillNum" type="int" order="6"/> 本次杀怪数量
	</xbean>
	<table name="climbtowerroles" key="long" value="ClimbTowerRoleInfo" lock="rolelock" cacheCapacity="7000"/> 山海爬塔角色数据
	<xbean name="ClimbTowerVoteInfo"> 山海爬塔金宝箱奖励界面(类似投票)
		<variable name="awardRoles" type="set" value="long" order="1"/> 获得奖励的人
		<variable name="chosenMap" type="map" key="long" value="int" order="2"/> key roleid  value index
		<variable name="expireTime" type="long" order="3"/> 过期时间
	</xbean>
	<table name="climbtowervote" key="long" value="ClimbTowerVoteInfo" cacheCapacity="8192" persistence="MEMORY" lock="teamlock"/>
	<!-- 秦岭探宝 end -->
	
	<!-- 守卫战 start -->
	<xbean name="GuardsBattle">
		<variable name="gatherNum" type="int" order="1"/>		元气值/采集值
		<variable name="killNum" type="int" order="2"/>		场景总击杀数
		<variable name="mosterLevel" type="int" order="3"/>	怪物等级
		<variable name="buffLevel" type="int" order="4"/>		buff等级
		<variable name="perKillNum" type="int" order="5"/>   当前阶段需要击杀怪物的指定值 ，根据地图人数通过JS算出
		<variable name="perGatherNum" type="int" order="6"/> 当前阶段需要采集的指定值，根据地图人数通过JS算出
		<variable name="awardStage" type="int" order="7"/>	奖励阶段,击杀数达到指定值时,给场景内所有玩家发奖
		<variable name="mosters" type="map" key="long" value="GuardsBattleNpc" order="8"/>	场景内的怪物
		<variable name="gathers" type="map" key="long" value="GuardsBattleNpc" order="9"/>	场景内的采集物
	</xbean>
	<xbean name="GuardsBattleNpc">
		<variable name="visitTimes" type="int" order="1"/>   npc访问次数
	</xbean>
	<table name="guardsbattle" key="int" value="GuardsBattle" cacheCapacity="1" lock="guardsbattlelock" persistence="MEMORY"/>
	
	<xbean name="GuardsBattleRole">  
		<variable name="lastResetTime" type="long" order="1"/>	最后重置时间
		<variable name="gatherNum" type="int" order="2"/>			采集次数
		<variable name="killNum" type="int" order="3"/>			击杀次数
	</xbean>
	<table name="guardsbattlerole" key="long" value="GuardsBattleRole" cacheCapacity="7000" lock="rolelock"/>
	<!-- 守卫战 end -->
	
	<!-- CG弹幕 start -->
	<xbean name="DanmuInfo">
		<variable name="segmentid" type="int" order="1"/> 片段id
		<variable name="content" type="string" order="2"/>
		<variable name="recordtime" type="long" order="3"/>
	</xbean>

	<xbean name="DanmuRecords">
		<variable name="danmuinfos" type="list" value="DanmuInfo" order="1"/>
	</xbean>
	<table name="danmuinfos" key="int" value="DanmuRecords" cacheCapacity="7000"/>
	
	<xbean name="DanmuCDInfo">
		<variable name="lastsendcgid" type="long" default="-1" order="1"/> 角色上次发送剧情动画弹幕的id
		<variable name="lastsendtime" type="long" default="-1" order="2"/> 角色上次发送剧情动画弹幕的时间
	</xbean>
	<table name="danmucdinfos" key="long" value="DanmuCDInfo" cacheCapacity="8192" lock="rolelock" persistence="MEMORY"/>
	<!-- CG弹幕 end -->
	
	<!-- 神魔乱舞 start-->
	<xbean name="StarMonsterNpcInfo"> 神魔npc信息
		<variable name="npcKey" type="long" order="1"/>		npcKey
		<variable name="npcId" type="int" order="2"/>		npcId
		<variable name="state" type="int" order="3"/>		生存状态 0活 1死
	</xbean>
	<xbean name="StarMonsterRankInfo"> 神魔击杀排行
		<variable name="teamMemberIds" type="list"  value="long" order="1"/>
		<variable name="npcId" type="int" order="2"/>		怪物Id
		<variable name="round" type="int" order="3"/>		回合数
		<variable name="killTime" type="long" order="4"/>		击杀时间
		
	</xbean>
	<xbean name="StarMonsterNpcGroup"> 神魔npc信息
		<variable name="monsters" type="map" key="long" value="StarMonsterNpcInfo" order="1"/> 怪物信息 key npckey
	</xbean>
	<xbean name="StarMonsterInfo">
		<variable name="currentGroups" type="map" key="int" value="int" order="1"/>	当前星级组刷出的地图 key 星级组id value为怪信息
		<variable name="nextGroups" type="map" key="int" value="int" order="2"/>	下一次星级组刷出的地图 key 星级组id
		<variable name="refreshTime" type="long" order="3"/>		刷新时间
		<variable name="rankList" type="list" value="StarMonsterRankInfo" order="4"/> 击杀排行
		<variable name="monsters" type="map" key="int" value="StarMonsterNpcGroup" order="5"/> 怪物信息 key 星级组id
		
	</xbean>
	<table name="starmonster" key="int" value="StarMonsterInfo" cacheCapacity="10" lock="starmonstermaplock" persistence="MEMORY"/>
	<xbean name="StarMonsterRoleRecord"> 玩家挑战记录
		<variable name="npcId" type="int" order="1"/>		怪物Id
		<variable name="round" type="int" order="2"/>		回合数
		<variable name="killTime" type="long" order="3"/>		击杀时间
	</xbean>
	<xbean name="StarMonsterRole">
		<variable name="records" type="list" value="StarMonsterRoleRecord" order="1"/> 击杀记录
		<variable name="recordTime" type="long" order="2"/>		记录时间
	</xbean>
	<table name="starmonsterrole" key="long" value="StarMonsterRole" cacheCapacity="7000" lock="rolelock"/>
	<!-- 神魔乱舞 end-->
	<xbean name="Testa">
		<variable name="intv" type="int" order="1"/>
		<variable name="stringv" type="string"  order="2"/>
		<variable name="longv" type="long" order="3"/>		
	</xbean>
	<table name="testa" key="int" value="Testa" />
	
	<xbean name="TestS">
		<variable name="intv" type="int" order="1"/>
		<variable name="stringv" type="string"  order="2"/>
		<variable name="longv" type="long" order="3"/>		
	</xbean>
	<table name="tests" key="int" value="TestS" />
	
	<!-- 结拜 start -->
	<xbean name="SwornInfo">
		<variable name="leaderId" type="long" order="1"/>
		<variable name="swronName" type="string" order="2"/> 结拜称号
		<variable name="swornMembers" type="map" key="long" value="SwornMemberInfo" order="3"/>
	</xbean>
	<xbean name="SwornMemberInfo">
		<variable name="swornTime" type="long" order="1"/> 结拜时间
	</xbean>
	<table name="swornrelation" key="long" value="SwornInfo" lock="swornlock" autoIncrement="true" cacheCapacity="4096"/> 结拜表
	
	<xbean name="SwornData">
		<variable name="groupId" type="long" order="1"/> 结拜组对应的讨论组id
		<variable name="titleId" type="int" order="2"/> 结拜称号id
		<variable name="swornMembers" type="list" value="long" order="3"/> 结拜成员
	</xbean>
	<xbean name="ToastInfo">
		<variable name="continueTime" type="long" order="1"/> buff持续时间
		<variable name="coastRoleId" type="long" order="2"/> 敬酒人
		<variable name="swronName" type="string" order="3"/> 结拜名字
	</xbean>
	<xbean name="SwornRoleInfo">
		<variable name="swornTimes" type="int" order="1"/> 结拜次数
		<variable name="swornData" type="map" key="long" value="SwornData" order="2"/>
		<variable name="toastInfo" type="map" key="int" value="ToastInfo" order="3"/> 敬酒信息
	</xbean>
	<table name="swornroleinfo" key="long" value="SwornRoleInfo" lock="rolelock" cacheCapacity="7000"/>
	
	<xbean name="SwornTeamVoteInfo">
		<variable name="swronName" type="string" order="1"/> 
		<variable name="endTime" type="long" order="2"/> 投票结束时间(倒计时用，防止超时)
		<variable name="members" type="map" key="long" value="boolean" order="3"/> value为投票结果
	</xbean>
	<table name="swornteamvote" key="long" value="SwornTeamVoteInfo" lock="teamlock" persistence="MEMORY" cacheCapacity="4096"/>
	<!-- 结拜 end -->
	
	<!--成长基金 start-->
	<xbean name="RoleGrowFund">
		<variable name="buynum" type="int" order="1"/>  成长基金的已购买次数
		<variable name="gotawards" type="list" value="int" order="2"/>  已经领取过等级奖励对应的等级列表
	</xbean>
	<table name="growfunds" key="long" value="RoleGrowFund" cacheCapacity="7000" lock="rolelock"/> 成长基金表
	<!--成长基金 end-->
	
	<!--首次充值奖励 start-->
	<xbean name="FirstChargeAward">
		<variable name="chargetime" type="long" order="1"/>  首次充值奖励开始时间
		<variable name="rewards" type="map" key="int" value="boolean" order="2"/>  领取奖励状态 key-第几天 value-是否领取
	</xbean>
	<table name="firstchargeaward" key="long" value="FirstChargeAward" cacheCapacity="7000" lock="rolelock"/> 首次充值奖励
	<!--首次充值奖励 end-->
	
	<!--累计充值天数奖励 start-->
	<xbean name="TotalChargeDayAward">
		<variable name="conf" type="int" order="1"/>配置表id
		<variable name="chargedays" type="int" order="2"/>充值天数
		<variable name="chargeNum" type="int" order="3"/>充值金额
		<variable name="state" type="map" key="int" value="int" order="4"/>key confid  value 领奖状态 1——未领取，2——可领取，3——已领取
		<variable name="freshTime" type="long" order="5"/>刷新时间
		<variable name="flag" type="int" order="6"/>
	</xbean>
	<table name="totalchargedayaward" key="long" value="TotalChargeDayAward" cacheCapacity="7000" lock="rolelock"/>
	<!--累计充值天数奖励 end-->
	
	<!-- 在线奖励start-->	
	<xbean name="OnlineRewards">
		<variable name="totalonlinetime" type="long" order="1"/> 在线总时长
		<variable name="sectiontime" type="long" order="2"/> 分段在线活动-当前阶段持续时间
		<variable name="lastonlinetime" type="long" order="3"/> 单独记录最近上线时间   防止闪退再上线时间的重置
		<variable name="lastrewardtime" type="long" order="4"/>  上次领取奖励的时间
		<variable name="receivedrewards" type="list" value="int" order="5"/>  已领取的奖励
	</xbean>
	
	<table name="onlinerewards" key="long" value="OnlineRewards" cacheCapacity="7000" lock="rolelock"/>
	<!-- 在线奖励end-->
	
	<!-- 饕餮盛宴 start -->	
	<xbean name="IngredientsInfo">
		<variable name="ingredientsNum" type="int" order="1"/> 已经获得的食材数量
	</xbean>
	<xbean name="FoodAnswerInfo">
		<variable name="status" type="int" order="1"/> 未答 答对 答错
	</xbean>
	<xbean name="GourmetFeast">
		<variable name="awardTimes" type="int" order="1"/> 烹饪奖励次数
		<variable name="chestTimes" type="int" order="2"/> 领取宝箱次数
		<variable name="foodId" type="int" order="3"/> 菜名id
		<variable name="questions" type="list" value="int" order="4"/> 随机的题库
		<variable name="answered" type="list" value="FoodAnswerInfo" order="5"/> 已答题目
		<variable name="correctNum" type="int" order="6"/> 答对题数
		<variable name="ingredients" type="map" key="int" value="IngredientsInfo" order="7"/> 食材(key为食材的类型)
		<variable name="freshTime" type="long" order="8"/> 角色数据刷新时间 
		<variable name="leaderAwardNum" type="int" order="9"/>队长额外奖励次数
		<variable name="submitTimes" type="int" order="10"/>提交食物次数
	</xbean>
	<table name="gourmetfeast" key="long" value="GourmetFeast" lock="rolelock" persistence="MEMORY" cacheCapacity="8192"/> 
	
	<xbean name="FeastFactionInfo">
		<variable name="totalSatiety" type="int" order="1"/> 帮派总饱食度
		<variable name="completeGoal" type="int" order="2"/> 已经完成的进度
		<variable name="boxNpcs" type="set" value="long" order="3"/> 创建出来的宝箱npc
		<variable name="allNpcs" type="set" value="long" order="4"/> 所有npc(食材npc、食神、饕餮、烤火架npc)
		<variable name="feastActivity" type="boolean" order="5"/>用于标识盛宴活动(防止经验雨多次开启)
		<variable name="factionRoleNum" type="int" order="6"/>以活动开启时帮派在线人数计算后续帮派饱食度目标
	</xbean>
	<table name="factionsatiety" key="long" value="FeastFactionInfo" lock="factionlock" persistence="MEMORY" cacheCapacity="4096"/> key为factionkey
	<!-- 饕餮盛宴 end -->
	
	<!-- 拯救桃花 start -->
	<xbean name="SavePeachFlowerRole">
		<variable name="lastsavetime" type="long" order="1"/> 上次拯救桃花时间
		<variable name="totalnum" type="int" order="2"/> 总拯救次数
		<variable name="todaynum" type="int" order="3"/> 今日拯救次数
		<variable name="awardstatus" type="int" order="4"/> 是否领取拯救桃花奖励
		
	</xbean>
	<table name="savepeachflower" key="long" value="SavePeachFlowerRole" cacheCapacity="7000" lock="rolelock"/> 拯救桃花小活动
	<!-- 拯救桃花 end -->
	
	<!-- 开服每日培养竞赛 start -->
	<xbean name="ContestRole">
		<variable name="stagegoal" type="map" key="int" value="GoalState" order="2"/>  阶段目标状态
		<variable name="lastconfigId" type="int" order="3"/>  上一次竞赛id
	</xbean>
	<xbean name="GoalState">
		<variable name="state" type="map" key="int" value="int" order="1"/> 领奖状态
	</xbean>
	<table name="openserverontest" key="long" value="ContestRole" cacheCapacity="7000" lock="rolelock"/> 开服每日竞赛
	<!-- 开服每日培养竞赛 end -->
	
	<!-- 灵兽游历 start -->
	<xbean name="PairPetInfo">
		<variable name="partnerRoleid" type="long" order="1"/> 伙伴roleid
		<variable name="partnerPetKey" type="int" order="2"/> 伙伴petkey 
	</xbean>
	<xbean name="TravelChestInfo"> 
		<variable name="chestId" type="int" order="1"/> 宝箱id
		<variable name="cheststatus" type="int" order="2"/> 宝箱状态
		<variable name="inforId" type="int" order="3"/> 见闻id(有奖励的inforid)
		<variable name="msgId" type="int" order="4"/> msgid(客户端展示用)
	</xbean>
	<xbean name="ReadyState">
		<variable name="libraryId" type="int" order="1"/> 准备阶段随机事件id
		<variable name="readyInforIds" type="int" order="2"/> 准备阶段见闻ids
	</xbean>
	<xbean name="TravelState">
		<variable name="probabilitys" type="int" order="1"/> 游历阶段随机事件id
		<variable name="setOutInforIds" type="int" order="2"/> 游历阶段见闻ids
		<variable name="setOutMsgIds" type="int" order="3"/> 游历阶段见闻id对应的msgid
	</xbean>
	<xbean name="TravelPetInfo">
		<variable name="travelStatus" type="int" order="1"/> 宠物游历状态(空闲、游历、匹配、准备)
		<variable name="readyTime" type="long" order="2"/> 准备时间
		<variable name="teamStatus" type="int" order="3"/> 游历方式(单人、组队)
		<variable name="pairPetInfo" type="PairPetInfo" order="4"/> 组队出行伙伴及宠物信息
		<variable name="chestInfo" type="list" value="TravelChestInfo" order="5"/> 游历获得宝箱相关信息(保证获取顺序)
		<variable name="readyState" type="list" value="ReadyState" order="6"/> 准备阶段信息
		<variable name="travelState" type="list" value="TravelState" order="7"/> 游历阶段信息
		<variable name="statusFuture" type="long" order="8"/> 改变游历状态定时器key
		<variable name="endFuture" type="long" order="9"/> 游历结束定时器key
	</xbean>
	<xbean name="ApplyInfo">
		<variable name="applyPetKey" type="int" order="1"/> 申请者出战petkey
		<variable name="applyTime" type="long" order="2"/> 申请时间
	</xbean>
	<xbean name="TravelInfo">
		<variable name="travelPet" type="map" key="int" value="TravelPetInfo" order="1"/> 游历宠物信息(key为petkey)
		<variable name="fortuneId" type="int" order="2"/> 今日运势
		<variable name="openedBoxNum" type="int" order="3"/> 已开格子数
		<variable name="applyRoleIds" type="map" key="long" value="ApplyInfo" order="4"/> 申请列表(key为申请者roleid)
		<variable name="refreshTime" type="long" order="5"/> 每日刷新时间
	</xbean>
	<table name="travelpet" key="long" value="TravelInfo" lock="rolelock" cacheCapacity="7000"/> 宠物游历信息
	<xbean name="PeerRecord">
		<variable name="teamStatus" type="int" order="1"/> 
		<variable name="myRoleId" type="long" order="2"/>
		<variable name="myPetKey" type="int" order="3"/>
		<variable name="otherRoleId" type="long" order="4"/>
		<variable name="otherPetKey" type="int" order="5"/>
		<variable name="readyTime" type="long" order="6"/>
		<variable name="startTime" type="long" order="7"/>
		<variable name="travelTime" type="long" order="8"/>
		<variable name="chestNum" type="int" order="9"/>
	</xbean>
	<xbean name="PeesRecords">
		<variable name="peerRecords" type="list" value="PeerRecord" order="1"/> 一周内的同行记录
	</xbean>
	<table name="peerrecord" key="long" value="PeesRecords" lock="rolelock" cacheCapacity="7000"/>
	<xbean name="PairInfo">
		<variable name="roleStatus" type="int" order="1"/> 角色匹配状态
		<variable name="pairPetKey" type="int" order="2"/> 匹配中的petkey
		<variable name="readyStatus" type="int" order="3"/> 角色准备状态
		<variable name="pairRoleId" type="long" order="4"/> 配对方roleid
		<variable name="overTime" type="long" order="5"/> 邀请超时限制
		<variable name="rolePosition" type="int" order="6"/> 邀请方、被邀请方
	</xbean>
	<table name="pairinfo" key="long" value="PairInfo" lock="rolelock" persistence="MEMORY" cacheCapacity="7000"/> 角色匹配数据
	<xbean name="DetailedInfo">
		<variable name="petKey" type="int" order="1"/> 发布宠物的petkey
		<variable name="recruitTime" type="long" order="2"/> 发布时间
	</xbean>
	<xbean name="RecruitInfo">
		<variable name="recruitInfo" type="map" key="long" value="DetailedInfo" order="1"/> 发布招募的角色信息(key为roleid)
	</xbean>
	<table name="releaserecruit" key="int" value="RecruitInfo" persistence="MEMORY" lock="pettravellock" cacheCapacity="1"/> 发布招募信息(key==1)
	<!-- 灵兽游历 end -->

	
	<!-- 合服 -->
	<xbean name="XMergeInfo">
		<variable name="zoneid" type="int" order="1"/>	服务器ID
		<variable name="mergeTime" type="long" order="2"/> 合服时间
	</xbean>
	<table name="xmerge" key="int" value="XMergeInfo" cacheCapacity="1"/>
	<!-- 合服end -->
	
	<!-- 道具随机鉴定 start -->
	<xbean name="RandomItemInfo">
		<variable name="productItem" type="Item" order="4"/>
	</xbean>
	<xbean name="RandomItemInfos">
		<variable name="randomItemInfos" type="list" value="RandomItemInfo" order="1"/>
	</xbean>
	<xbean name="RandomItemRole">
		<variable name="identifiedItems" type="map" key="int" value="RandomItemInfos" order="1"/> key-中转道具itemKey
	</xbean>
	<table name="randomidentifieditem" key="long" value="RandomItemRole" cacheCapacity="7000" lock="rolelock"/>
	<!-- 道具随机鉴定 end -->
	
	<!-- 图鉴收集start -->
	<xbean name="IconAttribute">
		<variable name="iconLevel" type="int" order="1"/> 图标等级
		<variable name="isUnLock" type="boolean" order="2"/> 是否解锁
		<variable name="curExp" type="int" order="3"/> 图标当前经验
	</xbean> 
	<xbean name="Icons">
		<variable name="icon" type="map" key="int" value="IconAttribute" order="1"/> key=iconId图标唯一id
	</xbean>
	<xbean name="DrawingIcons">
		<variable name="drawingIcon" type="map" key="int" value="Icons" order="1"/>
		<variable name="specialType" type="list" value="int" order="2"/> 特殊属性类型(唯一id)
	</xbean>
	<table name="drawing" key="long" value="DrawingIcons" cacheCapacity="7000" lock="rolelock"/>
	<!-- 图鉴收集end -->
	
	<!-- 助力礼包 start -->
	<xbean name="HelpPresentInfo">
		<variable name="startTime" type="long" order="1"/> 礼包触发时间
		<variable name="count" type="int" order="2"/> 礼包购买次数
	</xbean>
	<xbean name="HelpPresentInfos">
		<variable name="helpPresentInfos" type="map" key="int" value="HelpPresentInfo" order="1"/> 
	</xbean>
	<table name="helppresentinfos" key="long" value="HelpPresentInfos" lock="rolelock" cacheCapacity="7000" cachehigh="512" cachelow="256"/>
	<!-- 助力礼包 end -->
	
	<!--许愿池 start-->
	<xbean name="WishingWellInfo">
		<variable name="num" type="int" order="1"/> 使用许愿池的次数
		<variable name="startTime" type="long" order="2"/> 开启许愿池功能的时间
	</xbean>
	<table name="wishingwell" key="long" value="WishingWellInfo" cacheCapacity="7000" lock="rolelock"/>记录玩家许愿池相关信息
	<!--许愿池 end-->	
	
	<!-- 首充团购 start -->
	<xbean name="GroupBuy">
		<variable name="groupRewards" type="set" value="int" order="1"/> (只存领取过得奖励id)
		<variable name="chargeNum" type="int" order="2"/> 当天充值金额
		<variable name="refreshTime" type="long" order="3"/> 刷新时间
	</xbean>
	<table name="groupbuy" key="long" value="GroupBuy" cacheCapacity="7000" lock="rolelock"/> 首充团购
	
	<xbean name="GroupBuyRoleInfo">
		<variable name="chargeRoleIds" type="set" value="long" order="1"/> 
		<variable name="clearDataTime" type="long" order="2"/>
		<variable name="roleNums" type="int" order="3"/> 
	</xbean>
	<table name="groupbuyroleinfo" key="int" value="GroupBuyRoleInfo" cacheCapacity="1"/>
	<!-- 首充团购 end -->
	 
	<!-- 帮派语音答题start -->
	<xbean name="FactionVoiceAnswerInfo"> 
		<variable name="roleid" type="long" order="1"/> roleid
		<variable name="answer" type="string" order="2"/> 玩家给出答案
	</xbean>
	<xbean name="FactionVoiceExtAwardInfo"> 
		<variable name="awardnum" type="int" order="1"/> 获得额外奖励次数
	</xbean>
	<xbean name="FactionVoiceAnswerInfos"> 玩家语音答题信息
		<variable name="lastanswertime" type="long" order="1"/> 最近答题时间
		<variable name="answerinfos" type="list" value="FactionVoiceAnswerInfo" order="2"/> 玩家答案信息
		<variable name="extawardinfos" type="map" key="long" value="FactionVoiceExtAwardInfo" order="3"/> 玩家获得奖励信息
	</xbean>
	<table name="factionvoiceanswer" key="long" value="FactionVoiceAnswerInfos" cacheCapacity="4096" lock="factionlock" persistence="MEMORY"/> 
	<!-- 帮派语音答题end -->	 
	 
	 <!-- 伏魔组队start -->
	
	<xbean name="FuMoTeamInfo"> 
		<variable name="leader" type="long" order="1"/> 队长
		<variable name="timestamp" type="int" order="2"/> 进入队列时间 秒
		<variable name="msg" type="string" order="3"/>
		<variable name="autoagree" type="int" order="4"/> 自动接受报名 1= true
	</xbean>
	<xbean name="FuMoTeamGroup"> 
		<variable name="teams" type="map" key="long" value="FuMoTeamInfo" order="1"/> 
	</xbean>
	<table name="fumoteamgroups" key="int" value="FuMoTeamGroup" cacheCapacity="100" persistence="MEMORY"/> 
	
	<table name="fumoteam2group" key="long" value="int" cacheCapacity="4096" lock="teamlock"  persistence="MEMORY"/> 
	<!-- 伏魔组队end -->	 
	 
	 <cbean name="PlatAccount">
		<variable name="plat" type="string" order="1"/>
		<variable name="account" type="string" order="2"/>
	</cbean>
	<table name="plataccountinfo" key="PlatAccount" value="int" cacheCapacity="7000"/>
	
	
	<table name="userrebate" key="int" value="int" cacheCapacity="8192" lock="userlock"/> 删档测试充值返利
	
	<!-- 侠客灵符 start -->
	<xbean name="LingFu">
		<variable name="bayNum" type="int" order="1"/> 						灵符方案购买次数
		<variable name="maxScore" type="int" order="2"/> 					最高评分
		<variable name="maxScoreKey" type="list" value="int" order="3"/> 		最高评分的方案key
		<variable name="sortList" type="list" value="int" order="4"/>		 	排序id
		<variable name="schemes" type="map" key="int" value="LingFuScheme" order="5"/> 方案信息
	</xbean>
	<xbean name="LingFuScheme"> 
		<variable name="id" type="int" order="1"/> 						方案id
		<variable name="name" type="string" order="2"/> 					方案名称
		<variable name="lingfus" type="map" key="int" value="int" order="3"/> 		槽位灵符信息
		<variable name="score" type="int" order="4"/> 					评分
	</xbean>
	<table name="linffu" key="long" value="LingFu" cacheCapacity="7000" lock="rolelock"/> 灵符信息
	<!-- 侠客灵符 end -->
	
	<!-- 通天塔 start -->
	<xbean name="LayerInfo">
		<variable name="isFirstAdopt" type="boolean" order="1"/> 是否是首次通过
		<variable name="isRecommended" type="boolean" order="2"/> 是否推荐过
	</xbean>
	<xbean name="PagodaInfo">
		<variable name="challengeNum" type="int" order="1"/> 剩余挑战次数
		<variable name="layer" type="map" key="int" value="LayerInfo" order="2"/> 层信息
		<variable name="replyTime" type="long" order="3"/> 挑战次数回复时间
		<variable name="sweepSet" type="set" value="int" order="4"/> 可扫荡层数列表
		<variable name="sweepResetTime" type="long" order="5"/> 荡层刷新时间
	</xbean>
	<table name="pagoda" key="long" value="PagodaInfo" cacheCapacity="7000" lock="rolelock"/>
	<!-- 通天塔 end -->
	
	<!-- 帮派伴生兽 start -->
	<xbean name="FactionAnimalInfo">
		<variable name="animalId" type="int" order="1"/> 伴生兽id
		<variable name="character" type="map" key="int" value="int" order="2"/> 伴生兽性格  key-性格id
		<variable name="size" type="int" order="3"/> 体积大小
		<variable name="addWeight" type="map" key="int" value="int" order="4"/> 权重提升值  key-伴生兽id
		<variable name="feedValue" type="int" order="5"/> 喂养值
		<variable name="feedScore" type="int" order="6"/> 喂养得分
		<variable name="evolveTimes" type="int" order="7"/> 进化次数
		<variable name="lastEvolveTime" type="long" order="8"/> 上一次进化时间
		<variable name="isExsit" type="int" order="9"/> 是否存在
	</xbean> 
	<table name="factionanimal" key="long" value="FactionAnimalInfo" cacheCapacity="4096" lock="factionlock"/>
	
	<xbean name="FactionNpcInfo">
		<variable name="animalNpcKey" type="long" order="1"/>
	</xbean>
	<table name="factionnpc" key="long" value="FactionNpcInfo" cacheCapacity="4096" lock="factionlock" persistence="MEMORY"/>
	<!-- 帮派伴生兽 end -->
	
	<!-- 帮派伴生兽排行榜 -->
	<xbean name="FactionAnimalRankRecord">
		<variable name="rank" type="int" order="1"/> 排名
		<variable name="factionKey" type="long" order="2"/> 帮派key
		<variable name="animalName" type="string" order="3"/> 伴生兽名称
		<variable name="factionName" type="string" order="4"/> 帮派名称
		<variable name="score" type="int" order="5"/> 综合评分
	</xbean>
	<xbean name="FactionAnimalRankList">
		<variable name="records" type="list" value="FactionAnimalRankRecord" order="1"/> 所有的记录
	</xbean>
	<table name="factionanimalranklist" key="int" value="FactionAnimalRankList" cacheCapacity="1"/>
	
	<!-- 抽宠设定 start -->
	<xbean name="PetTripInfo">
		<variable name="petTrip" type="map"  key="int" value="int" order="1"/> key=魂印技能id value=魂印牵绊值
	</xbean>
	<table name="pettrip" key="long" value="PetTripInfo" cacheCapacity="7000" lock="rolelock"/>
	<!-- 抽宠设定 end -->
	
	<!-- 神兵幻化 start -->
	<xbean name="IllusionInfo">
		<variable name="illusionSkill" type="map" key="int" value="int" order="1"/> 技能幻化次数
		<variable name="spirit" type="boolean" order="2"/> 是否开启幻化套装属性
		<variable name="illusion" type="boolean" order="3"/> 是否开启幻化
	</xbean>
	<table name="illusion" key="long" value="IllusionInfo" cacheCapacity="7000" lock="rolelock"/>
	<!-- 神兵幻化 end -->
	
    <xbean name="SharehpBoss"> 可共享血量的boss
	    <variable name="owner" type="long" order="1"/> 如果是家族boss的话，这个值就是家族的fackey
        <variable name="maxHp" type="int" order="2"/> 最大血量
        <variable name="hp" type="int" order="3"/> 血量
        <variable name="deadTime" type="long" order="4"/> boss死亡时间
		<variable name="battlesInfo" type="map" key="long" value="long" order="5"/> 存打这个怪的战斗数据 key=battleId value=参战人的id，如果是队伍就是队长的id
		<variable name="npckey" type="long" order="6"/> 地图上生成的npc的key
		<variable name="battleDamage" type="map" key="long" value="int" order="7"/>战斗伤害 key=battleId
		<variable name="fatalDamage" type="long" order="8"/> 致命一击的战斗id
		<variable name="battleid" type="int" order="9"/> 战斗id
    </xbean>	
	<table name="shareboss" key="long" value="SharehpBoss" cacheCapacity="2048" cachehigh="512" cachelow="256" lock="sharebosslock" autoIncrement="true"/> 
	
	<!--帮派合并 start-->
	<xbean name="TargetFactionBean">		
		<variable name="launchmergetime" type="long" order="1"/> 发起合帮时间
	</xbean>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	<xbean name="FactionMergeInfo">		
		<variable name="targetfactions" type="map" key="long" value="TargetFactionBean" order="1"/> 合并目标帮派
		<variable name="preparemergetime" type="long" order="2"/> 进入合并时间
		<variable name="mergefactionkey" type="long" order="3"/> 合并帮派
		<variable name="mergestate" type="int" defalut="0" order="4"/> 合并帮派状态
		<variable name="futurekey" type="long" order="5"/> 发起合帮定时器key
		<enum name="WAITING" value="1"/> 等待接受中
		<enum name="PREPARE" value="2"/> 准备中
		<enum name="CONFIRM" value="3"/> 确认中
	</xbean>	
	<table name="factionmerge" key="long" value="FactionMergeInfo" lock="factionlock" cacheCapacity="4096" cachehigh="512" cachelow="256"/> 合并帮派表
	<!--帮派合并 end-->	
	
	<!--删除七重天录像需要的表 end-->	
	<table name="luxiangjiangli" key="int" value="int" cacheCapacity="100" lock="fairydreamreplyslock"/>	七重天录像奖励相关
	
	<!-- 每日首充 start -->
	<xbean name="EveryFirstCharge">
		<variable name="groupRewards" type="set" value="int" order="1"/> (只存领取过得奖励id)
		<variable name="chargeNum" type="int" order="2"/> 当天充值金额
		<variable name="refreshTime" type="long" order="3"/> 刷新时间
		<variable name="restRewards" type="set" value="int" order="4"/> 可领但未领的奖励(用于邮件发奖励)
	</xbean>
	<table name="everyfirstcharge" key="long" value="EveryFirstCharge" cacheCapacity="7000" lock="rolelock"/> 
	<!-- 每日首充 end -->
	
	<!-- 跨服PVP start -->
	<xbean name="CrossPvpTeamInfo"> 跨服PVP战队信息
		<variable name="leaderid" type="long" order="1"/> 战队队长的roleid
		<variable name="name" type="string" order="2"/> 战队名字
		<variable name="serverid" type="int" order="3"/> 战队所属的服务器id
		<variable name="members" type="vector" value="PreCrossTeamMember" order="4"/> 战队中的所有队员信息
		<variable name="fightinfos" type="map" key="int" value="PreCrossFightInfo" order="5"/> 本战队的所有对战信息 key见SCrossPvpMatchTeams中枚举
		<variable name="totalpower" type="int" order="6"/> 战队总战力
	</xbean>
	<table name="crosspvpteams" key="long" value="CrossPvpTeamInfo" cacheCapacity="4096" lock="precrossteamlock"/>
	
	<xbean name="CrossPvpActivityInfo"> 每届跨服PVP的全部参战战队信息
		<variable name="allteams" type="set" value="long" order="1"/> 本届参战的所有战队id
		<variable name="matchrandomed" type="boolean" order="2"/> 混战对手是否已生成
		<variable name="topsixteen" type="vector" value="long" capacity="16" order="3"/> 本届参战的16强战队id(有序的) 按积分和战力排名
		<variable name="topeight" type="vector" value="long" capacity="8" order="4"/> 本届参战的8强战队id(有序的) 按战力排名
		<variable name="topfour" type="vector" value="long" capacity="4" order="5"/> 本届参战的4强战队id(有序的) 按战力排名
		<variable name="topthirtytwo" type="vector" value="long" capacity="32" order="6"/> 本届参战的32强战队id(有序的) 按积分和战力排名
	</xbean>
	<table name="crosspvpactivity" key="int" value="CrossPvpActivityInfo" cacheCapacity="4" lock="crosspvplock"/> key=每届活动的配置id
	<!-- 跨服PVP end -->
	
	<!-- 帮派领土战 start -->
	<xbean name="RankInfo">
		<variable name="id" type="long" order="1"/> 
		<variable name="name" type="string" order="2"/> 
		<variable name="kill" type="int" order="3"/> 
		<variable name="score" type="int" order="4"/> 
	</xbean>
	
	<xbean name="TerritoryBattleRank"> 
		<variable name="factionInfos" type="map" key="long" value="RankInfo" order="1"/> 
		<variable name="factionRank" type="list" value="RankInfo" order="2"/> 
		<variable name="roleInfos" type="map" key="long" value="RankInfo" order="3"/> 
		<variable name="roleRank" type="list" value="RankInfo" order="4"/> 
	</xbean>
	<table name="territorybattlerank" key="int" value="TerritoryBattleRank" cacheCapacity="20"  persistence="MEMORY" lock = "territory"/> 
	<xbean name="TerritoryBattleBorn"> 
		<variable name="born" type="map" key="long" value="int" order="1"/>
	</xbean>
	<table name="territorybattleborn" key="int" value="TerritoryBattleBorn" cacheCapacity="20"  persistence="MEMORY" lock = "territory"/> 
	<table name="territory" key="int" value="long" cacheCapacity="20" lock = "territory" /> 
	
	<xbean name="TerritoryBattleRole"> 
		<variable name="territory" type="int" order="1"/> 进攻领土id
		<variable name="winStreak" type="int" order="2"/> 连胜
		<variable name="gatherScore" type="int" order="3"/> 当前采集积分
		<variable name="gatherNum" type="int" order="4"/> 采集数量  影响移动速度
		<variable name="lostnum" type="int" order="5"/> 战败次数
		<variable name="lastBattleTime" type="long" order="6"/> 
		<variable name="lastGatherTime" type="long" order="7"/> 
		<variable name="resetTime" type="long" order="8"/>
		<variable name="lostroles" type="list" value="long" order="9"/>战败角色
		<variable name="sameroleLostnum" type="int" order="10"/>同一角色连续被击败次数
	</xbean>
	<table name="territorybattlerole" key="long" value="TerritoryBattleRole" cacheCapacity="0" lock="rolelock" persistence="MEMORY"/> 
	<!-- 帮派领土战 end -->
	<xbean name="RandomShop"> 
		<variable name="items" type="list" value="int" order="1"/>
		<variable name="resetTime" type="long" order="2"/>
	</xbean>
	<table name="randomshop" key="int" value="RandomShop" cacheCapacity="256" lock="randomshop"/> 
	
	<xbean name="BuyCount"> 
		<variable name="items" type="map" key="int" value="int" order="1"/> key=itemid value=buynum
		<variable name="resetTime" type="long" order="2"/>
	</xbean>
	<xbean name="RandomShopRole"> 
		<variable name="buyCount" type="map" key="int" value="BuyCount" order="1"/> key=shopid 
	</xbean>
	<table name="randomshoprole" key="long" value="RandomShopRole" cacheCapacity="7000" lock="rolelock" /> 
	
	<!-- 五行修炼 start -->
	<xbean name="WuxingPracticeTask">
		<variable name="curRound" type="int" order="1"/> 当前正在执行任务的环数
		<variable name="refreshTime" type="long" order="2"/> 每日刷新任务环数的时间
		<variable name="leftRounds" type="int" order="3"/> 所领取的任务剩余的环数
		<variable name="notToday" type="boolean" order="4"/> 所领取任务剩余环数的状态
	</xbean>
	<table name="wuxingpracticetask" key="long" value="WuxingPracticeTask" cacheCapacity="7000" lock="rolelock"/>
	<!-- 五行修炼 end -->
	
	<!-- 灵翼系统 start-->
	<xbean name="WingRune">
		<variable name="id" type="int" order="1"/>
	</xbean>
	<xbean name="TurnInfo">
		<variable name="turnattr" type="map" key="int" value="int" order="1"/> 幻化属性
		<variable name="turnskill" type="map" key="int" value="int" order="2"/> 幻化技能
	</xbean>
	<xbean name="GodWing"> 
		<variable name="wingRunes" type="map" key="int" value="WingRune" order="1"/> 符文  key-羽符槽id
		<variable name="turnInfos" type="map" key="int" value="TurnInfo" order="2"/> 幻化属性 key-幻化槽id
		<variable name="award" type="boolean" order="3"/> 是否发过解锁灵翼时的羽符奖励
	</xbean>
	<table name="godwing" key="long" value="GodWing" cacheCapacity="7000" lock="rolelock"/>
	<!-- 灵翼系统 end-->	
	
	<!-- 阵法 天机卷 start -->
	<xbean name="ReelInfo">
		<variable name="reelstage" type="int" order="1"/>
		<variable name="score" type="int" order="2"/>
	</xbean>
	<xbean name="TianJiReel">
		<variable name="reels" type="map" key="int" value="ReelInfo" order="1"/>
	</xbean>
	<table name="tianjireel" key="long" value="TianJiReel" cacheCapacity="7000" lock="rolelock"/>
	<!-- 阵法 天机卷 end -->
	

	<!-- 末世之战 start -->
	<xbean name="LastTimeBattle"> 
		<enum name="OVER" value="0"/>	结束期
		<enum name="RUNNING" value="1"/> 进行中
		<enum name="FINAL" value="2"/>	决赛期
		
		
		<variable name="starttime" type="long" order="1"/>
		<variable name="endtime" type="long" order="2"/>
		<variable name="stage" type="int" order="3"/>
	</xbean>
	<table name="lasttimebattle" key="int" value="LastTimeBattle" cacheCapacity="1"/> 
	
	<xbean name="WeiWangInfo"> 
		<variable name="faction" type="long" order="1"/>
		<variable name="name" type="string" order="2"/>
		<variable name="score" type="int" order="3"/>
		<variable name="level" type="int" order="4"/>
	</xbean>
	<xbean name="WeiWangRank"> 
		<variable name="infos" type="map" key="long" value="WeiWangInfo" order="1"/> key factionkey
		<variable name="rank" type="list" value="WeiWangInfo" order="2"/>
	</xbean>
	<table name="weiwangrank" key="int" value="WeiWangRank" cacheCapacity="1"/>  帮派威望榜
	<!-- 末世之战 end -->
	
	<!-- 帮派事件活动 start -->
	<xbean name="FactionEventAct"> 
		<variable name="id" type="int" order="1"/> confid
		<variable name="score" type="int" order="2"/> 积分
		<variable name="item" type="int" order="3"/> 捐赠物品
	</xbean>
	
	<table name="factioneventact" key="int" value="FactionEventAct" cacheCapacity="1" persistence="MEMORY"/>  帮派事件活动
	<!-- 帮派事件活动 end -->
	
	<!-- 侠客印记 start -->
	<xbean name="StampAddAttr">
		<variable name="attrid" type="int" order="1"/> 附加属性id
		<variable name="attrvalue" type="int" order="2"/> 附加属性value
	</xbean>
	<xbean name="XiakeStamp">
		<variable name="stamplevel" type="int" order="1"/> 进阶等级(初始为1级)
		<variable name="stampattr" type="map" key="int" value="int" order="2"/> 印记基础属性
		<!-- <variable name="stampaddattr" type="map" key="int" value="StampAddAttr" order="3"/> 印记附加 属性 -->
		<variable name="curexp" type="int" order="4"/> 印记经验
		<variable name="stampaddattrs" type="list" value="StampAddAttr" order="5"/> 印记附加 属性
	</xbean>
	<table name="xiakestamps" key="long" value="XiakeStamp" cacheCapacity="20240" autoIncrement="true"/>
	<!-- 侠客印记 end -->
	
	<!-- 节日特殊活动 start-->
	<xbean name="FestivalItemInfo">
		<variable name="festivalItemMap" type="map" key="int" value="int" order="1"/> key为道具id value为觉醒（点亮）状态
		<variable name="freshTime" type="long" order="2"/>刷新时间
		<variable name="isAwarded" type="int" order="3"/>是否领取过首次集齐奖励
	</xbean>
	<table name="festivalactivity" key="long" value="FestivalItemInfo" cacheCapacity="7000" lock="rolelock"/>
	<!-- 节日特殊活动 end-->
	
	<!-- 魂玉转盘中奖记录 start-->
	<xbean name="SoulWheelReportInfo">
		<variable name="params" type="list" value="string" order="1"/> 对应的参数
		<variable name="time" type="long" order="2"/> 时间
		<variable name="msgReportId" type="int" order="3"/> 记录消息id
	</xbean>
	<xbean name="SoulWheelReport">
		<variable name="soulwheelreports" type="list" value="SoulWheelReportInfo" order="1"/>
		<variable name="activityId" type="int" order="2"/>
	</xbean>
	<table name="soulwheelreport" key="int" value="SoulWheelReport" cacheCapacity="100" lock="soulwheelreportlock"/>
	<!-- 魂玉转盘中奖记录 end-->
	
	<!-- 宠物限购 start-->
	<xbean name="PetLimitBuyRole">
		<variable name="buyset" type="set" value="int" order="1"/>
	</xbean>
	
	<table name="petlimitbuy" key="long" value="PetLimitBuyRole" cacheCapacity="7000" lock="rolelock"/>
	<!-- 宠物限购 end-->

	<TableSysConf name="_sys_" cacheCapacity="1" cachehigh="512" cachelow="256"/>
	<UniqNameConf localId="UN_LOCAL_ID">
		<XioConf name="xdb.util.UniqName">
			<Manager name="Client" keepSize="1" maxSize="1">
				<Coder>
					<Rpc class="xdb.util.UniqName$Allocate"/>
					<Rpc class="xdb.util.UniqName$Confirm"/>
					<Rpc class="xdb.util.UniqName$Release"/>
					<Rpc class="xdb.util.UniqName$Exist"/>
					<Rpc class="xdb.util.UniqName$AllocateId"/>
					<Rpc class="xdb.util.UniqName$ReleaseId"/>
				</Coder>
				<Connector remoteIp="UNIQNAME_SERVER_IP" remotePort="eval(STARTPORT+24)" sendBufferSize="16384" receiveBufferSize="16384" tcpNoDelay="true" inputBufferSize="131072" outputBufferSize="131072"/>
			</Manager>
		</XioConf>
	</UniqNameConf> 
 
	<LockCheckConf enable="true">
		<seqLockNames>
			<lock name="maplock"/>
			<lock name="territory"/>
			
			<lock name="factionbattletablelock"/>
			<lock name="factionbattlebackuplock"/>
			<lock name="factionbattlelock"/>
			<lock name="factionlock"/>
			
			<lock name="stallshopwares"/>
			<lock name="auditing"/>
			<lock name="auditinglog"/>
			
			<lock name="battle"/>
			<lock name="teamgroupids"/>
			<lock name="teamlock"/>
			<lock name="fixedteamlock"/>
			<lock name="chatgrouplock"/>
			<lock name="swornlock"/>
			<lock name="worldanswerlock"/>
			<lock name="magicianactivitylock"/>
			<lock name="magicianroomlock"/>
			<lock name="userlock"/>
			<lock name="mutualfriendsrolelock"/>
			<lock name="pettravellock"/>
			<lock name="AttackCityInfoLock"/>
			<lock name="rolelock"/>
			<lock name="sharebosslock"/>
			<lock name="climbtowerlock"/>
			<lock name="npcs"/>
			<lock name="hongbao"/>
			<lock name="sysmarry"/>
			
			<lock name="arenalock"/>
			<lock name="campbattlelock"/>
			<lock name="guardsbattlelock"/>
			<lock name="randomshop"/>
		</seqLockNames>
		<ignoredProcedures>
			<procedure name="ares.logic.task.TaskBattle"/>
			<procedure name="ares.logic.battle.PNewBattle"/>
			<procedure name="ares.logic.team.PCreateTeam"/>
			<procedure name="ares.logic.team.PInviteJoinTeam"/>
			<procedure name="ares.logic.faction.createfaction.PCreateFaction"/>
			<procedure name="ares.logic.faction.createfaction.PVoteResult"/>
			<procedure name="ares.logic.activity.starmonster.PStarMonsterBattleStart"/>
		</ignoredProcedures>
		<ignoredLockNames>
			<lock name="chanzi"/>
			<lock name="equips"/>
			<lock name="godequips"/>
			<lock name="uniquepets"/>
			<lock name="freshcards"/>
			<lock name="defendeffects"/>
			<lock name="xiakestamps"/>
		</ignoredLockNames>
	</LockCheckConf>
</xdb>