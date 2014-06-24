package com.liferay.lig.util;

import java.util.List;

import com.liferay.lig.model.Insult;
import com.liferay.portal.kernel.util.Validator;


/**
 * This class validates user input before storing to the
 * database.
 *
 * @author Rich Sezov
 *
 */
public class StatementValidator {

    @SuppressWarnings("unchecked")
    public static boolean validateStatement (Insult insult, List errors) {

        boolean valid = true;

        if (Validator.isNull(insult.getAdjectiveOne())) {
            valid = false;
            errors.add("adjective-required");

        }

        if (Validator.isNull(insult.getAdjectiveTwo())) {
            valid = false;
            errors.add("adjective-required");

        }

        if (Validator.isNull(insult.getDirectObject())) {
            valid = false;
            errors.add("noun-required");
        }

        if (Validator.isNull(insult.getObjPreposition())) {
            valid=false;
            errors.add("noun-required");
        }

        return valid;
    }

}
