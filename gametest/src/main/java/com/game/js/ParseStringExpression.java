package com.game.js;

import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ParseStringExpression {

	private ScriptEngine engine;

	public ParseStringExpression() {

		javax.script.ScriptEngineManager em = new javax.script.ScriptEngineManager();
		engine = em.getEngineByName("JavaScript");
	}

//	public static ParseStringExpression getInstance() {
//
//		if (null == instance) {
//			synchronized (ParseStringExpression.class) {
//				if (null == instance) {
//					instance = new ParseStringExpression();
//				}
//			}
//		}
//		return instance;
//	}

	public  Double ParseStr(String expression, Map<String, Object> paras) throws ScriptException {

		if (paras != null)
			for (Entry<String, Object> entry : paras.entrySet()) {
				engine.put(entry.getKey(), entry.getValue());
			}
		if (expression == null || expression == "")
			expression = "0";
		Object o = engine.eval("with(Math){" + expression + "}");
		if (o == null)
			return null;
		if (o instanceof Double)
			return (Double) o;
		if (o instanceof Integer)
			return ((Integer) o).doubleValue();

		return 0.0;
	}

	public ScriptEngine getEngine() {
		return engine;
	}
}
