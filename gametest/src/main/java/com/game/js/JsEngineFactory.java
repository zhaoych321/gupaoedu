package com.game.js;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;


/**
 * 提升性能，每个线程一个engine就行
 * 但是要注意不要前一次的参数用在了后一次
 */
public class JsEngineFactory {
	
	private static final ThreadLocal<ParseStringExpression> context = new ThreadLocal<ParseStringExpression>() {
		protected ParseStringExpression initialValue() {
			return new ParseStringExpression();
		};
	};
	
	public static ParseStringExpression createParseEngine() {
		ParseStringExpression parsEngine = context.get();
		//清除所有参数
		parsEngine.getEngine().getBindings(ScriptContext.ENGINE_SCOPE).clear();
		return parsEngine;
	}
	
	public static ScriptEngine createEngine() {
		return createParseEngine().getEngine();
	}
	
	public static void main(String[] args) {
//		ScriptEngine engine = createEngine();
//		String key = "key";
//		engine.put(key, 1);
//		System.out.println(engine.get(key));
//		engine = createEngine();
//		System.out.println(engine.get(key));

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ScriptEngine engine = createEngine();
			String key = "key";
			engine.put(key, 1);
//			System.out.println(engine.get(key));
		}
		System.out.println("111time : " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String key = "key";
			ParseStringExpression parseStringExpression = new ParseStringExpression();
			parseStringExpression.getEngine().put(key, 1);
//			System.out.println(parseStringExpression.getEngine().get(key));
		}
		System.out.println("time : " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String key = "key";
			JsMathUtil.evalDouble(key, "key", 1);
//			System.out.println(parseStringExpression.getEngine().get(key));
		}
		System.out.println("time : " + (System.currentTimeMillis() - start));

	}
}
