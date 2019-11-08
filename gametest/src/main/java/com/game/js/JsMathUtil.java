package com.game.js;

import java.util.concurrent.ConcurrentMap;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

/**
 * 解析js运算公式工具类
 * 
 * 相比直接调用ScriptEngine.eval(String),性能提升20倍以上
 * 
 * @author zhenyu.yin
 *
 */
public class JsMathUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsMathUtil.class);

	private static final ConcurrentMap<Key, ScriptObjectMirror> cache = new ConcurrentLinkedHashMap.Builder<Key, ScriptObjectMirror>().maximumWeightedCapacity(4096).build();
	private static final ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");

	/**
	 * @param js			js公式
	 * @param paramNames	js公式中引用的参数名, 逗号分隔
	 * @param params		参数列表 必须与paramNames 一致
	 */
	public static double evalDouble(String js, String paramNames, Object... params) {
		try {
			Object v = eval(js, paramNames, params);
			return v == null ? 0 : Number.class.cast(v).doubleValue();
		} catch (Exception e) {
			logger.error("evalDouble fail : js:{}  e:{}", js, e.getMessage());
			return 0;
		}
	}

	/**
	 * @param js			js公式
	 * @param paramNames	js公式中引用的参数名, 逗号分隔
	 * @param params		参数列表 必须与paramNames 一致
	 */
	public static int evalInt(String js, String paramNames, Object... params) {
		try {
			Object v = eval(js, paramNames, params);
			return v == null ? 0 : Number.class.cast(v).intValue();
		} catch (Exception e) {
			logger.error("evalInt fail : js:{}  e:{}", js, e.getMessage());
			return 0;
		}
	}
	
	/**
	 * @param js			js公式
	 * @param paramNames	js公式中引用的参数名, 逗号分隔
	 * @param params		参数列表 必须与paramNames 一致
	 */
	public static boolean evalBool(String js, String paramNames, Object... params) {
		try {
			Object v = eval(js, paramNames, params);
			return v == null ? false : (boolean) v;
		} catch (Exception e) {
			logger.error("evalBool fail : js:{}  e:{}", js, e.getMessage());
			return false;
		}
	}

	private static Object eval(String js, String paramNames, Object... params) {
		try {
			Key key = new Key(js, paramNames);
			ScriptObjectMirror math = cache.computeIfAbsent(key, v -> createFunction(paramNames, js));
			if (math == null) {
				return null;
			}
			return math.call(null, params);
		} catch (Exception e) {
			logger.error("eval fail : js:{}  e:{}", js, e.getMessage());
			return null;
		}
	}

	public static ScriptObjectMirror createFunction(String paramNames, String js) {
		try {
			String f = "function(" + paramNames + "){return " + js + "}";
			return (ScriptObjectMirror) engine.eval(addWithMath(f));
		} catch (Exception e) {
			logger.error("createFunction fail : js:{}  e:{}", js, e.getMessage());
			return null;
		}
	}

	private static String addWithMath(String js) {
		return "with(Math){" + js + "}";
	}

	private static class Key {
		String a;
		String b;

		public Key(String a, String b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws ScriptException {

//		String js = "a.hp()+b.hp()";
//		int num = 1000000;

//		test2(js, num);


		String js = "key";
		int num = 10000;

		test2(js, num);
	}

	private static void test2(String js, int num) throws ScriptException {
//		Role a = new Role(1000);
//		Role b = new Role(1000);
//		double v = 0;
//		long s1 = System.currentTimeMillis();
//		for (int i = 0; i < num; i++) {
//			v += evalDouble(js, "a,b", a, b);
//		}
//		long s2 = System.currentTimeMillis();
//		System.out.println((int) v + "  " + (s2 - s1));

		long s1 = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			evalDouble(js, "key", 1);
		}
		long s2 = System.currentTimeMillis();
		System.out.println((s2 - s1));
	}

	public static class Role {
		double hp = 0;

		public Role(double hp) {
			this.hp = hp;
		}

		public double hp() {
			return hp;
		}
	}
}