package entry

import java.io.Serializable

class GoogleTranslation : Serializable {
    /**
     * sentences : [{"trans":"計算","orig":"calculate","backend":1}]
     * src : en
     * confidence : 0.9609375
     * spell : {}
     * ld_result : {"srclangs":["en"],"srclangs_confidences":[0.9609375],"extended_srclangs":["en"]}
     */
    val src: String? = null
    val confidence = 0.0
    val spell: SpellBean? = null
    val ld_result: LdResultBean? = null
    val sentences: List<SentencesBean>? = null

    class SpellBean : Serializable

    class LdResultBean : Serializable {
        val srclangs: List<String>? = null
        val srclangs_confidences: List<Double>? = null
        val extended_srclangs: List<String>? = null
    }

    class SentencesBean : Serializable {
        /**
         * trans : 計算
         * orig : calculate
         * backend : 1
         */
        val trans: String? = null
        val orig: String? = null
        val backend = 0
    }
}