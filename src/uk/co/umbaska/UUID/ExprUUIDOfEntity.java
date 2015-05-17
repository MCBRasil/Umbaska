package uk.co.umbaska.UUID;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zachary on 5/17/2015.
 */
public class ExprUUIDOfEntity extends SimpleExpression<String> {

    private Expression<Entity> entity;

    public Class<? extends String> getReturnType() {

        return String.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, SkriptParser.ParseResult arg3) {
        this.entity = (Expression<Entity>) args[0];
        return true;
    }

    @Override
    public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
        return "return uuids of entities";
    }

    @javax.annotation.Nullable
    protected String[] get(Event arg0) {
        Entity[] entities = this.entity.getAll(arg0);
        List<String> uuids = new ArrayList<>();
        for (Entity e : entities){
            uuids.add(e.getUniqueId().toString());
        }
        return ((String[])uuids.toArray());
    }
}