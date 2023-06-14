package mx.com.cfe.cfecontig.domaincandy

import java.util.TimeZone

data class Destination (
    val base: String,
    val base2: String,
    val secure_get_parametr: String,
    val secure_key: String,
    val gadid_key: String,
    val deeplink_key: String,
    val source_key: String,
    val af_id_key: String,
    val adset_id_key: String,
    val campaign_id_key: String,
    val app_campaign_key: String,
    val adset_key: String,
    val adgroup_key: String,
    val orig_cost_key: String,
    val af_siteid_key: String,
    val dev_tmz_key: String
){
    override fun toString(): String {
        return base+base2+secure_get_parametr+secure_key+gadid_key+deeplink_key+source_key+af_id_key+adset_id_key+app_campaign_key+adset_key+adgroup_key+orig_cost_key+af_siteid_key+dev_tmz_key
    }
}


class DestinationBuilder(){
    var base: String = "https://classicspace.online/"
    var base2: String = "city.php?"
    var secure_get_parametr: String = "Kio3pVaT6R="
    var secure_key: String = "ImnHBL584t"
    var gadid_key: String = "&kINAv7FLvQ=null"
    var deeplink_key: String = "&njvoJfbJpV=null"
    var source_key: String = "&7X6JQHfNKr=null"
    var af_id_key: String = "&2Qb6RdZxPA=null"
    var adset_id_key: String = "&oZFR57yxDX=null"
    var campaign_id_key: String = "&kXCmNliGVp=null"
    var app_campaign_key: String = "&XWdDLd6kII=null"
    var adset_key: String = "&vziwG7gO5v=null"
    var adgroup_key: String = "&LBhBAt7uCj=null"
    var orig_cost_key: String = "&ddpMoTluBD=null"
    var af_siteid_key: String = "&r37deZ33l1=null"
    var dev_tmz_key: String = "&bM2gTppdiG=${TimeZone.getDefault().id}"


    fun gadid_key(value: String): DestinationBuilder{
        this.gadid_key = value
        return this
    }

    fun deeplink_key(value: String): DestinationBuilder{
        this.deeplink_key = value
        return this
    }

    fun source_key(value: String): DestinationBuilder{
        this.source_key = value
        return this
    }

    fun af_id_key(value: String): DestinationBuilder{
        this.af_id_key = value
        return this
    }

    fun adset_id_key(value: String): DestinationBuilder{
        this.adset_id_key = value
        return this
    }

    fun campaign_id_key(value: String): DestinationBuilder{
        this.campaign_id_key = value
        return this
    }

    fun app_campaign_key(value: String): DestinationBuilder{
        this.app_campaign_key = value
        return this
    }

    fun adset_key(value: String): DestinationBuilder{
        this.adset_key = value
        return this
    }

    fun adgroup_key(value: String): DestinationBuilder{
        this.adgroup_key = value
        return this
    }

    fun orig_cost_key(value: String): DestinationBuilder{
        this.orig_cost_key = value
        return this
    }

    fun af_siteid_key(value: String): DestinationBuilder{
        this.af_siteid_key = value
        return this
    }

    fun build() : Destination {
        return Destination(
            base = base,
            base2 = base2,
            secure_get_parametr = secure_get_parametr,
            secure_key = secure_key,
            gadid_key = gadid_key,
            deeplink_key = deeplink_key,
            source_key = source_key,
            af_id_key = af_id_key,
            adset_id_key = adset_id_key,
            campaign_id_key = campaign_id_key,
            app_campaign_key = app_campaign_key,
            adset_key = adset_key,
            adgroup_key = adgroup_key,
            orig_cost_key = orig_cost_key,
            af_siteid_key = af_siteid_key,
            dev_tmz_key = dev_tmz_key
        )
    }
}


