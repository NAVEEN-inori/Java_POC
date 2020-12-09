package com;

import com.google.gson.Gson;

public class RuleSetJsonToRuleSetObject {

    public static void main(String[] args) {

        ruleSet ruleSet = new ruleSet();

        ruleSet = getRulesetObject();

        System.out.println(ruleSet);
    }

    public static ruleSet getRulesetObject(){

        String rulSetJson = "{ \"execution_mode\" : \"INLINE\", " +
                "\"name\" : \"Postpayments_Payouts_Recon\", " +
                "\"client_id\" : \"3\", " +
                "\"notification_preferences\" : [\"IRIS\"], " +
                "\"publish_preferences\" : [\"PUBLISH_FAILURE_RESULT\", \"PUBLISH_SUCCESS_RESULT\", \"PUBLISH_FOR_ANALYTICS\"], " +
                "\"rule_ids\" : [\"2016\"], " +
                "\"group_name\" : \"PayPal\"}";

        Gson gson = new Gson();

        ruleSet ruleSet = gson.fromJson(rulSetJson, com.ruleSet.class);

        return ruleSet;
    }
}
