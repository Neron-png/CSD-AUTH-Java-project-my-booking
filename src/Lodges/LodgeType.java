package Lodges;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This enum "class" is a list of different types of lodges (properties).
 * @author Christos Balaktsis
 */

public enum LodgeType implements Serializable {
    APARTMENT, ROOM, TRAILER, HOTEL;

    public static String getLodgeTypes() {
        StringBuilder str = new StringBuilder();
        for(LodgeType type : LodgeType.values())
            str.append(type.toString()).append(" ");
        return str.toString().trim();
    }

    public static boolean isLodgeType(String value) {
        ArrayList<String> lodgeTypes = new ArrayList<>();
        for(LodgeType type : LodgeType.values())
            lodgeTypes.add(type.toString());
        for (String tempType : lodgeTypes)
            if(tempType.equals(value)) return false;
        return true;
    }

}
