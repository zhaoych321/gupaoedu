package annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SqlAnnotation {
	@Target(ElementType.TYPE)//只能应用于类上
	@Retention(RetentionPolicy.RUNTIME)//保存到运行时
	public @interface DBTable {
		String name() default "";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface SQLInteger {
		//该字段对应数据库表列名
	    String name() default "";
	    //嵌套注解
	    Constraints constraint() default @Constraints;
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface SQLString {

	    //对应数据库表的列名
	    String name() default "";

	    //列类型分配的长度，如varchar(30)的30
	    int value() default 0;

	    Constraints constraint() default @Constraints;
	}
	
	@Target(ElementType.FIELD)//只能应用在字段上
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Constraints {
	    //判断是否作为主键约束
	    boolean primaryKey() default false;
	    //判断是否允许为null
	    boolean allowNull() default false;
	    //判断是否唯一
	    boolean unique() default false;
	}
}
