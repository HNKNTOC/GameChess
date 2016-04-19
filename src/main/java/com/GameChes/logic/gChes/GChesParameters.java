package com.GameChes.logic.gChes;

/**
 * В данном интерфейсе перечислены динамические параметры в GChes и их описание.
 */
public interface GChesParameters {

    /**
     * В данном классе описаны имена параметров.
     */
     class ParametersName{
        /**
         * Содержит тип данной GChes.
         */
        public static final String TYPE = "Type";
    }

    class ParametersValue{
        /**
         * Значение для Type.
         * Означает что данный GObject является GChes.
         */
        public static final  String TYPE_GCHESS = "GChes";
    }
}
