package com.liferay.talelets.util;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.talelets.service.model.Talelet;

public class TaleletValidator {
	 @SuppressWarnings("unchecked")
	    public static boolean validateTalelet (Talelet talelet, List errors) {

	        boolean valid = true;

	        if (Validator.isNull(talelet.getContent())) {
	            valid = false;
	            errors.add("content-required");

	        }

	        return valid;
	    }
}
