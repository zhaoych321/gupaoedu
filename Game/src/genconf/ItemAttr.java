package genconf;

import com.thoughtworks.xstream.XStream;
import org.apache.poi.ss.usermodel.Row;

public class ItemAttr  implements ConvMain.Checkable,Comparable<ItemAttr>{

	public int compareTo(ItemAttr o){
		return this.id-o.id;
	}

	final static private org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ItemAttr.class);
			
	private static java.util.Map<Integer,ItemAttr> doconv(String confDir) {		
		java.util.Map<Integer,ItemAttr> result=new java.util.TreeMap<Integer,ItemAttr>();
		try {
		final String filename=confDir+"/d道具表/z杂货表.xlsm";
		java.io.File xfile=new java.io.File(filename);
		if(!xfile.canRead()) {
			logger.error("无法读取"+xfile.getAbsolutePath());
			return result;
		}
		org.apache.poi.xssf.usermodel.XSSFWorkbook wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook(filename);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);			
		java.util.ArrayList<String> collnames=new java.util.ArrayList<String>();
		for (Row r:sheet ) {
			if(collnames.isEmpty()){						
				for(org.apache.poi.ss.usermodel.Cell c:r){
					collnames.add(c.getStringCellValue());
				}
				if(collnames.isEmpty())
					throw new RuntimeException("sheet is empty");
			} else {
				ItemAttr obj;
				try{
					obj=new ItemAttr(r,collnames,"",0);
				}catch(NeedId ex){
					continue;
				}
				if(result.put(obj.id,obj)!=null)
					throw new RuntimeException("在类ItemAttr中找到的重复的key="+obj.id);
			}
		}
		} catch(Exception ex){
			logger.error("从d道具表/z杂货表.xlsm读取数据转换成ItemAttr对象时出错",ex);
		}
		try {
		final String filename=confDir+"/d道具表/r任务物品表.xlsx";
		java.io.File xfile=new java.io.File(filename);
		if(!xfile.canRead()) {
			logger.error("无法读取"+xfile.getAbsolutePath());
			return result;
		}
		org.apache.poi.xssf.usermodel.XSSFWorkbook wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook(filename);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);			
		java.util.ArrayList<String> collnames=new java.util.ArrayList<String>();
		for (Row r:sheet ) {
			if(collnames.isEmpty()){						
				for(org.apache.poi.ss.usermodel.Cell c:r){
					collnames.add(c.getStringCellValue());
				}
				if(collnames.isEmpty())
					throw new RuntimeException("sheet is empty");
			} else {
				ItemAttr obj;
				try{
					obj=new ItemAttr(r,collnames,"",0);
				}catch(NeedId ex){
					continue;
				}
				if(result.put(obj.id,obj)!=null)
					throw new RuntimeException("在类ItemAttr中找到的重复的key="+obj.id);
			}
		}
		} catch(Exception ex){
			logger.error("从d道具表/r任务物品表.xlsx读取数据转换成ItemAttr对象时出错",ex);
		}
	return result;
	}	
	
	
	static class NeedId extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	/**
	 * @param row 褰撳墠姝ｅ湪澶勭悊鐨別xcel鐨勫綋鍓峳ow銆傛湰瀵硅薄鎵�鏈夌殑鏁版嵁閮芥潵鑷簬杩欎釜row
	 * @param collnames 浠庤繖涓猠xcel琛ㄧ殑绗竴琛屾彁鍙栧嚭鏉ョ殑鍒楀悕
	 * @param prefix 濡傛灉杩欎釜bean鏄彟涓�涓猚ollection鐨剉alue,骞朵笖杩欎釜bean琚涓猙ean寮曠敤锛岄偅涔堟牴鎹畃refix纭畾瀵瑰簲鍏崇郴
	 * @param index 濡傛灉杩欎釜bean鏄彟涓�涓猚ollection鐨剉alue,閭ｄ箞鏍规嵁index纭畾鍏蜂綋瀵瑰簲閭ｄ竴鍒�
	 * 濡傛灉index瓒呰繃闄愬埗锛屾垨鑰呮煇涓彉閲忔湁notnull灞炴�э紝閭ｄ箞鎶涘嚭IllegalArgumentException銆�
	 */
	public ItemAttr(Row row,java.util.ArrayList<String> collnames,String prefix,int index){
		super();
		
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"编号",collnames); 				
			
				if(v!=null) this.id=v; else throw new NeedId();}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{String v=ConvMain.getCellValue(row,"显示名",collnames); 
			
					this.name=v;}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{String v=ConvMain.getCellValue(row,"单位",collnames); 
			
					this.units=v;}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"类型",collnames); 				
			
					if(v!=null) this.itemtypeid=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的类型为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"等级",collnames); 				
			
					if(v!=null) this.等级=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的等级为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"最大堆叠数量",collnames); 				
			
					if(v!=null) this.最大堆叠数量=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的最大堆叠数量为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"最大拥有数量",collnames); 				
			
					if(v!=null) this.最大拥有数量=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的最大拥有数量为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"战斗外使用对象",collnames); 				
			
					if(v!=null) this.战斗外使用对象=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的战斗外使用对象为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"需求等级",collnames); 				
			
					if(v!=null) this.需求等级=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的需求等级为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"排序ID",collnames); 				
			
					if(v!=null) this.排序id=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的排序ID为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"出售价格",collnames); 				
			
					if(v!=null) this.sellprice=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的出售价格为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"卖店类型",collnames); 				
			
					if(v!=null) this.storetype=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的卖店类型为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"卖出",collnames); 				
			
					if(v!=null) this.tipssold=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的卖出为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"丢弃",collnames); 				
			
					if(v!=null) this.tipsdrop=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的丢弃为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"拆解",collnames); 				
			
					if(v!=null) this.tipsdestroy=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的拆解为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"合成",collnames); 				
			
					if(v!=null) this.tipsmade=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的合成为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"获取",collnames); 				
			
					if(v!=null) this.tipsget=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的获取为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"使用",collnames); 				
			
					if(v!=null) this.useable=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的使用为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"镶嵌",collnames); 				
			
					if(v!=null) this.tipsMetagems=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的镶嵌为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"仓库存储",collnames); 				
			
					if(v!=null) this.storage=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"行的仓库存储为空");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{String v=ConvMain.getCellValue(row,"道具名颜色",collnames); 
			
					this.namecolor=v;}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"行index过了");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
	
	}
	public ItemAttr(){
		super();
	}
	public ItemAttr(ItemAttr arg){
		this.id=arg.id ;
		this.name=arg.name ;
		this.units=arg.units ;
		this.itemtypeid=arg.itemtypeid ;
		this.等级=arg.等级 ;
		this.最大堆叠数量=arg.最大堆叠数量 ;
		this.最大拥有数量=arg.最大拥有数量 ;
		this.战斗外使用对象=arg.战斗外使用对象 ;
		this.需求等级=arg.需求等级 ;
		this.排序id=arg.排序id ;
		this.sellprice=arg.sellprice ;
		this.storetype=arg.storetype ;
		this.tipssold=arg.tipssold ;
		this.tipsdrop=arg.tipsdrop ;
		this.tipsdestroy=arg.tipsdestroy ;
		this.tipsmade=arg.tipsmade ;
		this.tipsget=arg.tipsget ;
		this.useable=arg.useable ;
		this.tipsMetagems=arg.tipsMetagems ;
		this.storage=arg.storage ;
		this.namecolor=arg.namecolor ;
	}
	public void checkValid(java.util.Map<String,java.util.Map<Integer,? extends Object> > objs){
		do{
			int tmprefvalue=itemtypeid;
			
			if(tmprefvalue < 1) throw new RuntimeException("ItemAttr.itemtypeid="+tmprefvalue+",所以不满足条件 ItemAttr.itemtypeid < 1");
		}while(false);
		do{
			int tmprefvalue=最大堆叠数量;
			
			if(tmprefvalue < 1) throw new RuntimeException("ItemAttr.最大堆叠数量="+tmprefvalue+",所以不满足条件 ItemAttr.最大堆叠数量 < 1");
			if(tmprefvalue > 9999) throw new RuntimeException("ItemAttr.最大堆叠数量="+tmprefvalue+",所以不满足条件 ItemAttr.最大堆叠数量 > 9999");
		}while(false);
		do{
			int tmprefvalue=需求等级;
			
			if(tmprefvalue < 1) throw new RuntimeException("ItemAttr.需求等级="+tmprefvalue+",所以不满足条件 ItemAttr.需求等级 < 1");
		}while(false);
	}
	/**
	 * id
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int id  = 0  ;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int v){
		this.id=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public String name  = null  ;
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String v){
		this.name=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public String units  = null  ;
	
	public String getUnits(){
		return this.units;
	}
	
	public void setUnits(String v){
		this.units=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int itemtypeid  = 0  ;
	
	public int getItemtypeid(){
		return this.itemtypeid;
	}
	
	public void setItemtypeid(int v){
		this.itemtypeid=v;
	}
	
	/**
	 * 等级
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 等级  = 0  ;
	
	public int get等级(){
		return this.等级;
	}
	
	public void set等级(int v){
		this.等级=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 最大堆叠数量  = 0  ;
	
	public int get最大堆叠数量(){
		return this.最大堆叠数量;
	}
	
	public void set最大堆叠数量(int v){
		this.最大堆叠数量=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 最大拥有数量  = 0  ;
	
	public int get最大拥有数量(){
		return this.最大拥有数量;
	}
	
	public void set最大拥有数量(int v){
		this.最大拥有数量=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 战斗外使用对象  = 0  ;
	
	public int get战斗外使用对象(){
		return this.战斗外使用对象;
	}
	
	public void set战斗外使用对象(int v){
		this.战斗外使用对象=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 需求等级  = 0  ;
	
	public int get需求等级(){
		return this.需求等级;
	}
	
	public void set需求等级(int v){
		this.需求等级=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int 排序id  = 0  ;
	
	public int get排序id(){
		return this.排序id;
	}
	
	public void set排序id(int v){
		this.排序id=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int sellprice  = 0  ;
	
	public int getSellprice(){
		return this.sellprice;
	}
	
	public void setSellprice(int v){
		this.sellprice=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int storetype  = 0  ;
	
	public int getStoretype(){
		return this.storetype;
	}
	
	public void setStoretype(int v){
		this.storetype=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipssold  = 0  ;
	
	public int getTipssold(){
		return this.tipssold;
	}
	
	public void setTipssold(int v){
		this.tipssold=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipsdrop  = 0  ;
	
	public int getTipsdrop(){
		return this.tipsdrop;
	}
	
	public void setTipsdrop(int v){
		this.tipsdrop=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipsdestroy  = 0  ;
	
	public int getTipsdestroy(){
		return this.tipsdestroy;
	}
	
	public void setTipsdestroy(int v){
		this.tipsdestroy=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipsmade  = 0  ;
	
	public int getTipsmade(){
		return this.tipsmade;
	}
	
	public void setTipsmade(int v){
		this.tipsmade=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipsget  = 0  ;
	
	public int getTipsget(){
		return this.tipsget;
	}
	
	public void setTipsget(int v){
		this.tipsget=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int useable  = 0  ;
	
	public int getUseable(){
		return this.useable;
	}
	
	public void setUseable(int v){
		this.useable=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int tipsMetagems  = 0  ;
	
	public int getTipsMetagems(){
		return this.tipsMetagems;
	}
	
	public void setTipsMetagems(int v){
		this.tipsMetagems=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int storage  = 0  ;
	
	public int getStorage(){
		return this.storage;
	}
	
	public void setStorage(int v){
		this.storage=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public String namecolor  = null  ;
	
	public String getNamecolor(){
		return this.namecolor;
	}
	
	public void setNamecolor(String v){
		this.namecolor=v;
	}
	
	
	public static java.util.Map<Integer,? extends Object> toXML(String confdir,String outdir,XStream xstream) throws java.io.IOException {
		java.util.Map<Integer,ItemAttr> ret=doconv(confdir);
		xstream.autodetectAnnotations(false);
		final java.io.FileOutputStream ops=new java.io.FileOutputStream(outdir+"/"+ItemAttr.class.getCanonicalName()+".xml");		
		final java.io.OutputStreamWriter writer = new java.io.OutputStreamWriter(ops, "UTF-8");
		try{
			writer.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
			writer.flush();
			xstream.toXML(ret, writer);
		}finally{
			writer.close();
		}
		return ret;
	}
	
};