package genconf;

import com.thoughtworks.xstream.XStream;
import org.apache.poi.ss.usermodel.Row;

public class HuobanPassiveSkillbookAttr  extends ItemAttr  implements ConvMain.Checkable{

	public int compareTo(HuobanPassiveSkillbookAttr o){
		return this.id-o.id;
	}

	final static private org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(HuobanPassiveSkillbookAttr.class);
			
	private static java.util.Map<Integer,HuobanPassiveSkillbookAttr> doconv(String confDir) {		
		java.util.Map<Integer,HuobanPassiveSkillbookAttr> result=new java.util.TreeMap<Integer,HuobanPassiveSkillbookAttr>();
		try {
		final String filename=confDir+"/h伙伴物品表.xlsm";
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
				HuobanPassiveSkillbookAttr obj;
				try{
					obj=new HuobanPassiveSkillbookAttr(r,collnames,"",0);
				}catch(NeedId ex){
					continue;
				}
				if(result.put(obj.id,obj)!=null)
					throw new RuntimeException("在类HuobanPassiveSkillbookAttr中找到的重复的key="+obj.id);
			}
		}
		} catch(Exception ex){
			logger.error("从d道具表/h伙伴物品表.xlsm读取数据转换成HuobanPassiveSkillbookAttr对象时出错",ex);
		}
		return result;
	}	
	
	public HuobanPassiveSkillbookAttr(ItemAttr arg){
		super(arg);
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
	public HuobanPassiveSkillbookAttr(Row row,java.util.ArrayList<String> collnames,String prefix,int index){
		super(row,collnames,prefix,index);
	
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"瀵瑰簲琚姩鎶�鑳�",collnames); 				
			
					if(v!=null) this.XiakePassiveSkillid=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"琛岀殑瀵瑰簲琚姩鎶�鑳戒负绌�");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"琛宨ndex杩囦簡");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
		 if(prefix.equals("")){			
							
			 if(index == 0){			
				{Integer v=ConvMain.getIntegerCellValue(row,"鎻愪緵缁忛獙鍊�",collnames); 				
			
					if(v!=null) this.addxiakeexp=v; else throw new IndexOutOfBoundsException(row.getRowNum()+"琛岀殑鎻愪緵缁忛獙鍊间负绌�");}
			}
			 else throw new IndexOutOfBoundsException(row.getRowNum()+"琛宨ndex杩囦簡");
			 						
		}
			else throw new RuntimeException("unknown prefix:"+prefix);
	
	}
	public HuobanPassiveSkillbookAttr(){
		super();
	}
	public HuobanPassiveSkillbookAttr(HuobanPassiveSkillbookAttr arg){
		super(arg);
		this.XiakePassiveSkillid=arg.XiakePassiveSkillid ;
		this.addxiakeexp=arg.addxiakeexp ;
	}
	public void checkValid(java.util.Map<String,java.util.Map<Integer,? extends Object> > objs){
			super.checkValid(objs);
	}
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int XiakePassiveSkillid  = 0  ;
	
	public int getXiakePassiveSkillid(){
		return this.XiakePassiveSkillid;
	}
	
	public void setXiakePassiveSkillid(int v){
		this.XiakePassiveSkillid=v;
	}
	
	/**
	 * 
	 */
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public int addxiakeexp  = 0  ;
	
	public int getAddxiakeexp(){
		return this.addxiakeexp;
	}
	
	public void setAddxiakeexp(int v){
		this.addxiakeexp=v;
	}
	
	
	public static java.util.Map<Integer,? extends Object> toXML(String confdir,String outdir,XStream xstream) throws java.io.IOException {
		java.util.Map<Integer,HuobanPassiveSkillbookAttr> ret=doconv(confdir);
		xstream.autodetectAnnotations(false);
		final java.io.FileOutputStream ops=new java.io.FileOutputStream(outdir+"/"+HuobanPassiveSkillbookAttr.class.getCanonicalName()+".xml");		
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