package uk.co.umbaska.Managers;

import java.util.List;
import org.bukkit.event.Event;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.util.SimpleEvent;

public class RegisterManager {
	
	public static <E extends Event> void registerEvent(Element e, Class<E> c){
		String[] usage = e.getRegisterUsage();
		for(int i = 0; i < usage.length; i++) usage[i] = usage[i].replace("on ", "").replace(":", "");
		Skript.registerEvent(e.getName(), SimpleEvent.class, c, usage);
		Documentation.addElement(e);
	}
	
	public static <E extends SkriptEvent> void registerEvent(Element e, Class<E> adapter, Class<? extends Event> c){
		String[] usage = e.getRegisterUsage();
		for(int i = 0; i < usage.length; i++) usage[i] = usage[i].replace("on ", "").replace(":", "");
		Skript.registerEvent(e.getName(), adapter, c, usage);
		Documentation.addElement(e);
	}
	
	public static <E extends Condition> void registerCondition(Element e, Class<E> c){
		Skript.registerCondition(c, e.getRegisterUsage());
		Documentation.addElement(e);
	}
		    
	public static <E extends Effect> void registerEffect(Element e, Class<E> c){
		Skript.registerEffect(c, e.getRegisterUsage());
		Documentation.addElement(e);
	}
	
	public static <E extends Expression<T>, T> void registerExpression(Element e, Class<E> c, Class<T> returnType){
		Skript.registerExpression(c, returnType, ExpressionType.PROPERTY, e.getRegisterUsage());
		Documentation.addElement(e);
	}
	
	public static void registerClasses(Element e, Object o){
		o = null;
		Documentation.addElement(e);
	}
	
	public static void registerEventValues(List<Element> es){
		for(Element e : es){
			Documentation.addElement(e);
		}
	}
	
}
